package com.mrcodey.adapter;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.RequestQueue;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.ImageLoader;
import com.android.volley.toolbox.Volley;
import com.mrcodey.main.R;
import com.mrcodey.model.TeamInfo;
import com.mrcodey.net.BitmapCache;
import com.mrcodey.tools.CircleImageDrawable;
import com.mrcodey.tools.SetRoundImage;

import java.util.List;

/**
 * Created by Mr.Codey on 2015/9/19.
 */
public class LabelAdapter extends BaseAdapter
{
    private Context mContext;
    private List<TeamInfo> mList;
    private Bitmap bitmap;
    private RequestQueue requestQueue;
    public Bitmap getBitmap()
    {
        return bitmap;
    }
    public LabelAdapter(Context context,List list)
    {
        requestQueue= Volley.newRequestQueue(context);
        this.mContext=context;
        this.mList=list;
    }
    @Override
    public int getCount()
    {
        if (mList == null) {
            return 0;
        }
        return mList.size();
    }

    @Override
    public Object getItem(int position)
    {
        if (mList == null) {
            return null;
        }
        return mList.get(position);
    }

    @Override
    public long getItemId(int position)
    {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent)
    {
        ViewHolder holder = null;
        // 初始化各个控件
        if (convertView == null) {
            holder = new ViewHolder();
            convertView = LayoutInflater.from(mContext).inflate(
                    R.layout.label_list, parent,false);
            holder.content = (TextView) convertView
                    .findViewById(R.id.team_content);
            holder.name = (TextView) convertView.findViewById(R.id.team_name);
            holder.ivImg = (ImageView) convertView.findViewById(R.id.avatar);
            convertView.setTag(holder);
        } else {
            holder = (ViewHolder) convertView.getTag();
        }

        /*try
        {
            bitmap = BitmapFactory.decodeResource(mContext.getResources(),
                    R.drawable.r);
        } catch (OutOfMemoryError e)
        {
            Toast.makeText(mContext, "内存溢出", Toast.LENGTH_LONG).show();
        }*/
      //  holder.ivImg.setImageDrawable(new CircleImageDrawable(bitmap));
        displayImg(holder.ivImg, mList.get(position).getImgUrl(), requestQueue);
        holder.name.setText(mList.get(position).getTeamName());
        holder.ivImg.setImageResource(R.drawable.r);
        holder.content.setText(mList.get(position).getTeamIntro());
        return  convertView;

    }
    public static class ViewHolder {
        TextView name;
        ImageView ivImg;
        TextView content;
    }
    public void displayImg(final View view,String url,RequestQueue mRequestQueue){
        ImageLoader imageLoader = new ImageLoader(mRequestQueue, new BitmapCache());

        //ImageLoader.ImageListener listener = ImageLoader.getImageListener((ImageView) view, R.drawable.head, R.drawable.head);
        imageLoader.get(url, new ImageLoader.ImageListener()
        {
            @Override
            public void onResponse(ImageLoader.ImageContainer request, boolean b)
            {
                if(request.getBitmap()!=null)
                {
                    //  ((ImageView) view).setImageDrawable(new CircleImageDrawable(request.getBitmap()));
                    ((ImageView) view).setImageBitmap(request.getBitmap());
                }
                else
                {
                    ((ImageView) view).setImageResource(R.drawable.head);
                }
            }

            @Override
            public void onErrorResponse(VolleyError volleyError)
            {

            }
        });
        //指定图片允许的最大宽度和高度
        //imageLoader.get("http://developer.android.com/images/home/aw_dac.png",listener, 200, 200);
    }
}
