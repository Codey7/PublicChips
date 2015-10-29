package com.mrcodey.main;

import android.app.Activity;
import android.app.Dialog;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.view.Display;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.ScrollView;
import android.widget.TextView;
import android.widget.Toast;

import com.mrcodey.activity.AddProject;
import com.mrcodey.activity.DecodeQRCode;
import com.mrcodey.activity.EditInfo;
import com.mrcodey.activity.HowToPlay;
import com.mrcodey.activity.MyCollect;
import com.mrcodey.activity.Settings;
import com.mrcodey.activity.WithdrawRecord;
import com.mrcodey.fragment.DialogFrag;
import com.mrcodey.fragment.HomeFragment;
import com.mrcodey.fragment.LabelFragment;
import com.mrcodey.fragment.MessageFragment;
import com.mrcodey.fragment.RankingFragment;
import com.mrcodey.residemenu.ResideMenu;
import com.mrcodey.residemenu.ResideMenuItem;

/**
 * 总框架
 * @author Mr.Codey
 */
public class MainActivity extends FragmentActivity implements View.OnClickListener
{

    private ImageView mivAddnew;//添加按钮
    //四个fragment
    private HomeFragment homeFragment;
    private LabelFragment labelFragment;
    private RankingFragment rankingFragment;
    private MessageFragment messageFragment;

    // 四个layout
    private View homeLayout;
    private View labelLayout;
    private View rankLayout;
    private View messageLayout;

    // 四个底部图标
    private ImageView homeImage;
    private ImageView labelImage;
    private ImageView rankImage;
    private ImageView messageImage;

    //四个文字
    private TextView homeText;
    private TextView labelText;
    private TextView rankText;
    private TextView messageText;



    // 管理fragment
    private FragmentManager fragmentManager;

    private ResideMenu resideMenu;
    private ImageView miv_info;

    private ImageView mivAdd;
    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        fragmentManager=getSupportFragmentManager();
        initView();
        setUpMenu();
        setTabSelection(0);
    }

    private void setUpMenu()
    {

        // attach to current activity;
        resideMenu = new ResideMenu(this);
        resideMenu.setUse3D(false);
        resideMenu.setBackground(R.drawable.menu_background);
        resideMenu.attachToActivity(this);
        resideMenu.setMenuListener(menuListener);
        //valid scale factor is between 0.0f and 1.0f. leftmenu'width is 150dip.
        resideMenu.setScaleValue(0.61f);
        FrameLayout ignored_view = (FrameLayout) findViewById(R.id.content);
        resideMenu.addIgnoredView(ignored_view);

        ResideMenuItem resideMenuItem=new ResideMenuItem(getApplicationContext(),this);
        resideMenu.addLayoutView(resideMenuItem);

    }

    private ResideMenu.OnMenuListener menuListener = new ResideMenu.OnMenuListener() {
        @Override
        public void openMenu() {
         //   Toast.makeText(getApplicationContext(), "Menu is opened!", Toast.LENGTH_SHORT).show();
        }

        @Override
        public void closeMenu() {
          //  Toast.makeText(getApplicationContext(), "Menu is closed!", Toast.LENGTH_SHORT).show();
        }
    };

    private void setTabSelection(int index) {
        clearSelection();
        FragmentTransaction transaction = fragmentManager.beginTransaction();
        hideFragments(transaction);
        switch (index) {
            case 0:
                // 更改图标
                homeImage.setImageResource(R.drawable.ic_menu_block);
                homeText.setText("首页");
                homeText.setTextColor(Color.parseColor("#2196F3"));
                    if (homeFragment == null) {
                        homeFragment = new HomeFragment();
                        transaction.add(R.id.content, homeFragment);
                    } else {
                        transaction.show(homeFragment);
                    }
                break;
            case 1:
                rankImage.setImageResource(R.drawable.ic_menu_block);
                // 如果为空，则创建
                if (rankingFragment == null) {
                    rankingFragment = new RankingFragment();
                    transaction.add(R.id.content, rankingFragment);
                } else {
                    transaction.show(rankingFragment);
                }
                break;
            case 2:
                labelImage.setImageResource(R.drawable.ic_menu_block);
                // // 如果为空，则创建
                if (labelFragment == null) {
                    labelFragment = new LabelFragment();
                    transaction.add(R.id.content, labelFragment);
                } else {
                    transaction.show(labelFragment);
                }
                break;

            case 3:
            default:
                messageImage.setImageResource(R.drawable.ic_menu_block);
                // 如果为空，则创建
                if (messageFragment == null) {
                    messageFragment = new MessageFragment();
                    transaction.add(R.id.content, messageFragment);
                } else {
                    transaction.show(messageFragment);
                }

                break;
        }
        transaction.commit();
    }

    /**
     * @param fragmentTransaction
     *            隐藏所有
     */
    private void hideFragments(FragmentTransaction fragmentTransaction) {
        if (homeFragment != null) {
            fragmentTransaction.hide(homeFragment);
        }
        if (labelFragment != null) {
            fragmentTransaction.hide(labelFragment);
        }
        if (rankingFragment != null) {
            fragmentTransaction.hide(rankingFragment);
        }
        if (messageFragment != null) {
            fragmentTransaction.hide(messageFragment);
        }
    }
    /**
     * 实例化各个View 并设置监听
     */
    private void initView()
    {
        homeLayout=findViewById(R.id.layout_home);
        rankLayout=findViewById(R.id.layout_rank);
        labelLayout=findViewById(R.id.layout_label);
        messageLayout=findViewById(R.id.layout_msg);

        homeImage= (ImageView) findViewById(R.id.iv_home);
        rankImage=(ImageView)findViewById(R.id.iv_rank);
        labelImage=(ImageView)findViewById(R.id.iv_label);
        messageImage=(ImageView)findViewById(R.id.iv_msg);

        homeText= (TextView) findViewById(R.id.tv_home);
        rankText= (TextView) findViewById(R.id.tv_rank);
        labelText= (TextView) findViewById(R.id.tv_label);
        messageText= (TextView) findViewById(R.id.tv_msg);

        miv_info=(ImageView) findViewById(R.id.iv_person_info);
        mivAdd=(ImageView)findViewById(R.id.iv_add);
        homeLayout.setOnClickListener(this);
        rankLayout.setOnClickListener(this);
        labelLayout.setOnClickListener(this);
        messageLayout.setOnClickListener(this);
        miv_info.setOnClickListener(this);
        mivAdd.setOnClickListener(this);
    }

    /**
     * 清除之前的选择
     * 用于初始化
     */
    private void clearSelection() {
        homeImage.setImageResource(R.drawable.ic_menu_emoticons);
        rankImage.setImageResource(R.drawable.ic_menu_emoticons);
        labelImage.setImageResource(R.drawable.ic_menu_emoticons);
        messageImage.setImageResource(R.drawable.ic_menu_emoticons);

        /*homeText.setTextColor(Color.WHITE);
        rankText.setTextColor(Color.WHITE);
        labelText.setTextColor(Color.WHITE);
        messageText.setTextColor(Color.WHITE);*/
    }

    @Override
    public void onClick(View v)
    {
        Intent intent;
    switch (v.getId())
    {
        case R.id.iv_head:
            break;
        case R.id.tv_username:
            intent=new Intent(getApplicationContext(), DecodeQRCode.class);
            startActivity(intent);
            break;
        case R.id.tv_address:
            break;
        case R.id.tv_qr_code:
            intent=new Intent(getApplicationContext(), DecodeQRCode.class);
            startActivity(intent);
            break;
        case R.id.tv_edit_data:
            intent=new Intent(getApplicationContext(), EditInfo.class);
            startActivity(intent);
            break;
        case R.id.tv_collect:
            intent=new Intent(getApplicationContext(), MyCollect.class);
            startActivity(intent);
            break;
        case R.id.tv_record:
            intent=new Intent(getApplicationContext(), WithdrawRecord.class);
            startActivity(intent);
            break;
        case R.id.tv_setting:
            intent=new Intent(getApplicationContext(), Settings.class);
            startActivity(intent);
            break;
        case R.id.tv_how:
            intent=new Intent(getApplicationContext(), HowToPlay.class);
            startActivity(intent);
            break;
        case R.id.layout_home:
            setTabSelection(0);
            break;
        case R.id.layout_rank:
            setTabSelection(1);
            break;
        case R.id.layout_label:
            setTabSelection(2);
            break;
        case R.id.layout_msg:
            setTabSelection(3);
            break;
        case R.id.iv_person_info:
            resideMenu.openMenu(ResideMenu.DIRECTION_LEFT);
            break;
        case R.id.iv_add:
            /*DialogFrag dialogFrag=new DialogFrag();
            dialogFrag.show(getSupportFragmentManager(),"agree");*/
            final Dialog dialog = new Dialog(this);

            // setContentView可以设置为一个View也可以简单地指定资源ID
            // LayoutInflater
            // li=(LayoutInflater)getSystemService(LAYOUT_INFLATER_SERVICE);
            // View v=li.inflate(R.layout.dialog_layout, null);
            // dialog.setContentView(v);
            LayoutInflater inflaterDl = LayoutInflater.from(this);
            ScrollView layout = (ScrollView)inflaterDl.inflate(R.layout.dialog_agree, null );
            dialog.setContentView(layout);

            dialog.setTitle("服务条款");
            Window dialogWindow = dialog.getWindow();
/*            WindowManager.LayoutParams lp = dialogWindow.getAttributes();
            dialogWindow.setGravity(Gravity.LEFT | Gravity.TOP);
            lp.x = 100; // 新位置X坐标
            lp.y = 100; // 新位置Y坐标
            lp.width = 300; // 宽度
            lp.height = 300; // 高度
            lp.alpha = 0.7f; // 透明度*/
            WindowManager m = getWindowManager();
        Display d = m.getDefaultDisplay(); // 获取屏幕宽、高用
        WindowManager.LayoutParams p = dialogWindow.getAttributes(); // 获取对话框当前的参数值
        p.height = (int) (d.getHeight() * 0.6); // 高度设置为屏幕的0.6
        p.width = (int) (d.getWidth() * 0.8); // 宽度设置为屏幕的0.65
            dialogWindow.setAttributes(p);
            dialog.show();

            Button button;
            button= (Button)layout.findViewById(R.id.bt_agree);
            button.setOnClickListener(new View.OnClickListener()
            {
                @Override
                public void onClick(View v)
                {
                  dialog.dismiss();
                    Intent intent=new Intent(getApplicationContext(), AddProject.class);
                    startActivity(intent);
                }
            });
            break;
    }
    }

    // 再按一次返回键退出
    private long firstTime;

    /*
     * (non-Javadoc)
     *
     * @see android.app.Activity#onBackPressed()
     */
    @Override
    public void onBackPressed() {
        // TODO Auto-generated method stub
        if (System.currentTimeMillis() - firstTime < 2000) {
            finish();
        } else {
            firstTime = System.currentTimeMillis();

            Toast.makeText(this, R.string.press_again_backrun, Toast.LENGTH_SHORT).show();
            // T.showShort(this, R.string.press_again_backrun);
        }
    }

    @Override
    public boolean dispatchTouchEvent(MotionEvent ev)
    {
        return resideMenu.dispatchTouchEvent(ev);
    }
    /*
    @Override
    public boolean onCreateOptionsMenu(Menu menu)
    {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item)
    {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings)
        {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }*/
}
