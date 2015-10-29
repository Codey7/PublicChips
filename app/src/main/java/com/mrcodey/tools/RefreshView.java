package com.mrcodey.tools;


import android.content.Context;
import android.content.SharedPreferences;
import android.os.AsyncTask;
import android.preference.PreferenceManager;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewConfiguration;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.view.View.OnTouchListener;
import android.view.animation.RotateAnimation;

import com.mrcodey.main.R;

/*
 * 下拉刷新控件
 */
public class RefreshView extends LinearLayout implements OnTouchListener {
	/*
	 * 刷新状态设置
	 */
	private static final int pull_to_refresh = 0;// 下拉刷新状态
	private static final int release_to_refresh = 1;// 释放立即刷新
	private static final int on_refresh = 2;// 正在刷新状态
	private static final int finish_refresh = 3;// 刷新完成状态

	/**
	 * 下拉条的回滚速度
	 */
	private static final int back_speed = -20;
	/**
	 * 各种时间的毫秒值，用于判断上次的更新时间
	 */
	private long lastUpdateTime;
	private int mId = -1; // 区别不同界面的刷新key
	public static final long ONE_MINUTE = 60 * 1000;
	public static final long ONE_HOUR = 60 * ONE_MINUTE;
	public static final long ONE_DAY = 24 * ONE_HOUR;
	public static final long ONE_MONTH = 30 * ONE_DAY;
	public static final long ONE_YEAR = 12 * ONE_MONTH;
	/**
	 * 上次更新时间的字符串常量，用于作为SharedPreferences的键值
	 */
	private static final String time_key = "update_time";
	/**
	 * 使用sharedpreferences保存上次更新的时间
	 */
	private SharedPreferences preferences;

	private int current_status = finish_refresh;
	private int last_status = current_status;
	private View header; // 下拉头
	private ListView listView;
	private ProgressBar progressBar;
	private ImageView arrow;
	private TextView dec;
	private TextView updated_at;
	private PullToRefreshListener mListener;
	private boolean isLoadOnce;
	/**
	 * 当前是否可以下拉，只有ListView滚动到头的时候才允许下拉
	 */
	private boolean ableToPull;
	private int hideHeaderHeight; // 下拉头的高度
	/**
	 * 下拉头的布局参数
	 */
	private MarginLayoutParams headerLayoutParams;
	/**
	 * 手指按下时的屏幕纵坐标
	 */
	private float yDown;
	/**
	 * 在被判定为滚动之前用户手指可以移动的最大值。
	 */
	private int touchSlop;

	/**
	 * 构造函数 添加一个下拉头的布局
	 * 
	 * @param context
	 * @param attrs
	 */
	public RefreshView(Context context, AttributeSet attrs) {
		super(context, attrs);
		preferences = PreferenceManager.getDefaultSharedPreferences(context);
		header = LayoutInflater.from(context).inflate(R.layout.refresh_head,
				null, true);
		progressBar = (ProgressBar) header.findViewById(R.id.progress_bar);
		arrow = (ImageView) header.findViewById(R.id.arrow);
		dec = (TextView) header.findViewById(R.id.dec);
		updated_at = (TextView) header.findViewById(R.id.updated_at);
		touchSlop = ViewConfiguration.get(context).getScaledTouchSlop();
		refreshUpdateAtValue();
		setOrientation(VERTICAL);
		addView(header, 0);
	}

	@Override
	protected void onLayout(boolean changed, int l, int t, int r, int b) {
		// TODO Auto-generated method stub
		super.onLayout(changed, l, t, r, b);
		if (changed && !isLoadOnce) {
			hideHeaderHeight = -header.getHeight();
			headerLayoutParams = (MarginLayoutParams) header.getLayoutParams();
			headerLayoutParams.topMargin = hideHeaderHeight;
			header.layout(0, hideHeaderHeight, r, 0);
			listView = (ListView) getChildAt(1);
			listView.setOnTouchListener(this);
			isLoadOnce = true;
		}
	}

	/**
	 * 下拉刷新的具体逻辑
	 */
	@Override
	public boolean onTouch(View v, MotionEvent event) {
		// TODO Auto-generated method stub
		setAbleToPull(event);
		if (ableToPull) {
			switch (event.getAction()) {
			case MotionEvent.ACTION_DOWN:
				yDown = event.getRawY();
				break;
			case MotionEvent.ACTION_MOVE:
				float yMove = event.getRawY();
				int distance = (int) (yMove - yDown);
				// 如果不是下拉，下拉头完全隐藏，就屏蔽下拉事件
				if (distance < 0
						&& headerLayoutParams.topMargin <= hideHeaderHeight) {
					return false;
				}
				if (distance < touchSlop) {
					return false;
				}
				if (current_status != on_refresh) {
					if (headerLayoutParams.topMargin > 0) {
						current_status = release_to_refresh;
					} else {
						current_status = pull_to_refresh;
					}
					// 通过偏移下拉头的topMargin值，来实现下拉效果
					headerLayoutParams.topMargin = (distance / 2)
							+ hideHeaderHeight;
					header.setLayoutParams(headerLayoutParams);
				}
				break;
			case MotionEvent.ACTION_UP:
			default:
				if (current_status == release_to_refresh) {
					new RefreshingTask().execute();
				}
				if (current_status == pull_to_refresh) {
					new HideHeaderTask().execute();
				}
				break;
			}
			if (current_status == pull_to_refresh
					|| current_status == release_to_refresh) {
				updateHeaderView();
				//当前处于下拉或释放状态，要让listView失去焦点
				listView.setFocusable(false);
				listView.setFocusableInTouchMode(false);
				listView.setPressed(false);
				last_status=current_status;
				return true;
			}
		}
		return false;
	}

	/**
	 * 监听器的实现
	 * 
	 * @param listener
	 * @param id
	 */
	public void setOnRefreshListener(PullToRefreshListener listener, int id) {
		mListener = listener;
		mId = id;
	}

	/**
	 * 当所有的刷新逻辑完成后，记录调用一下，否则你的ListView将一直处于正在刷新状态。
	 */
	public void finishRefreshing() {
		current_status = finish_refresh;
		preferences.edit().putLong(time_key + mId, System.currentTimeMillis())
				.commit();
		new HideHeaderTask().execute();
	}

	/*
	 * public boolean isAbleToPull() { return ableToPull; }
	 */
	/**
	 * 判断是否可以刷新
	 * 
	 * @param event
	 */
	public void setAbleToPull(MotionEvent event) {
		View firstChild = listView.getChildAt(0);
		if (firstChild != null) {
			int firstVisiblePos = listView.getFirstVisiblePosition();
			if (firstVisiblePos == 0 && firstChild.getTop() == 0) // 第一个元素距离父布局的值为0
																	// ，允许刷新
			{
				if (!ableToPull) {
					yDown = event.getRawY();
				}
				ableToPull = true;
			} else {
				if (headerLayoutParams.topMargin != hideHeaderHeight) {
					headerLayoutParams.topMargin = hideHeaderHeight;
					header.setLayoutParams(headerLayoutParams);
				}
				ableToPull = false;
			}
		} else {
			// 如果ListView中没有元素，也应该允许下拉刷新
			ableToPull = true;
		}
	}

	/**
	 * 更新下拉头中的信息
	 */
	private void updateHeaderView() {
		if (last_status != current_status) {
			if (current_status == pull_to_refresh) {
				dec.setText(getResources().getString(R.string.pull_to_refresh));
				arrow.setVisibility(View.VISIBLE);
				progressBar.setVisibility(View.GONE);
				rotateArrow();
			} else if (current_status == release_to_refresh) {
				dec.setText(getResources().getString(R.string.release_to_refresh));
				arrow.setVisibility(View.VISIBLE);
				progressBar.setVisibility(View.GONE);
				rotateArrow();
			} else if (current_status == on_refresh) {
				dec.setText(getResources().getString(R.string.refreshing));
				progressBar.setVisibility(View.VISIBLE);
				arrow.clearAnimation();
				arrow.setVisibility(View.GONE);
			}
			refreshUpdateAtValue();
		}
	}

	/**
	 * 根据当前的状态来旋转箭头。
	 */
	private void rotateArrow() {
		float pivotX = arrow.getWidth() / 2f;
		float pivotY = arrow.getHeight() / 2f;
		float fromDegrees = 0f;
		float toDegrees = 0f;
		if (current_status == pull_to_refresh) {
			fromDegrees = 180f;
			toDegrees = 360f;
		} else if (current_status == release_to_refresh) {
			fromDegrees = 0f;
			toDegrees = 180f;
		}
		RotateAnimation animation = new RotateAnimation(fromDegrees, toDegrees,
				pivotX, pivotY);
		animation.setDuration(100);
		animation.setFillAfter(true);
		arrow.startAnimation(animation);
	}

	private void refreshUpdateAtValue() {
		lastUpdateTime = preferences.getLong(time_key + mId, -1);
		long currentTime = System.currentTimeMillis();
		long timePassed = currentTime - lastUpdateTime;
		long timeIntoFormat;
		String updateAtValue = "";
		if (lastUpdateTime == -1) {
			updateAtValue = getResources().getString(R.string.not_updated_yet);
		} else if (timePassed < 0) {
			updateAtValue = getResources().getString(R.string.time_error);
		} else if (timePassed < ONE_MINUTE) {
			timeIntoFormat = timePassed / ONE_MINUTE;
			String value = timeIntoFormat + "分钟";
			updateAtValue = String.format(
					getResources().getString(R.string.updated_at), value);
		} else if (timePassed < ONE_HOUR) {
			timeIntoFormat = timePassed / ONE_HOUR;
			String value = timeIntoFormat + "小时";
			updateAtValue = String.format(
					getResources().getString(R.string.updated_at), value);
		} else if (timePassed < ONE_DAY) {
			timeIntoFormat = timePassed / ONE_DAY;
			String value = timeIntoFormat + "天";
			updateAtValue = String.format(
					getResources().getString(R.string.updated_at), value);
		} else if (timePassed < ONE_MONTH) {
			timeIntoFormat = timePassed / ONE_MONTH;
			String value = timeIntoFormat + "月";
			updateAtValue = String.format(
					getResources().getString(R.string.updated_at), value);
		} else if (timePassed < ONE_YEAR) {
			timeIntoFormat = timePassed / ONE_YEAR;
			String value = timeIntoFormat + "年";
			updateAtValue = String.format(
					getResources().getString(R.string.updated_at), value);
		}
		updated_at.setText(updateAtValue);
	}

	/**
	 * 正在刷新的任务
	 * 
	 * @author baimi
	 *
	 */
	class RefreshingTask extends AsyncTask<Void, Integer, Void> {

		@Override
		protected Void doInBackground(Void... params) {
			// TODO Auto-generated method stub
			int topMargin = headerLayoutParams.topMargin;
			while (true) {
				topMargin = topMargin + back_speed;
				if (topMargin <= 0) {
					topMargin = 0;
					break;
				}
				publishProgress(topMargin);
				try {
					Thread.sleep(10);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			current_status = on_refresh;
			publishProgress(0);
			if (mListener != null) {
				mListener.onRefresh();
			}
			return null;
		}

		@Override
		protected void onProgressUpdate(Integer... values) {
			// TODO Auto-generated method stub
//			super.onProgressUpdate(values);
			updateHeaderView();
			headerLayoutParams.topMargin = values[0];
			header.setLayoutParams(headerLayoutParams);
		}

	}

	/**
	 * 隐藏下拉头的任务，当未进行下拉刷新或下拉刷新完成后，此任务将会使下拉头重新隐藏。
	 * 
	 * @author baimi
	 *
	 */
	class HideHeaderTask extends AsyncTask<Void, Integer, Integer> {

		@Override
		protected Integer doInBackground(Void... params) {
			int topMargin = headerLayoutParams.topMargin;
			while (true) {
				topMargin = topMargin + back_speed;
				if (topMargin <= hideHeaderHeight) {
					topMargin = hideHeaderHeight;
					break;
				}
				publishProgress(topMargin);
				try {
					Thread.sleep(10);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			return topMargin;
		}

		@Override
		protected void onProgressUpdate(Integer... topMargin) {
			// super.onProgressUpdate(values);
			headerLayoutParams.topMargin = topMargin[0];
			header.setLayoutParams(headerLayoutParams);
		}

		@Override
		protected void onPostExecute(Integer result) {
			// TODO Auto-generated method stub
			// super.onPostExecute(result);
			headerLayoutParams.topMargin = result;
			header.setLayoutParams(headerLayoutParams);
			current_status = finish_refresh;
		}
	}

	/**
	 * 下拉刷新的监听器，使用下拉刷新的地方应该注册此监听器来获取刷新回调。
	 * 
	 * @author baimi
	 */
	public interface PullToRefreshListener {

		/**
		 * 刷新时会去回调此方法，在方法内编写具体的刷新逻辑。注意此方法是在子线程中调用的， 你可以不必另开线程来进行耗时操作。
		 */
		void onRefresh();

	}
}
