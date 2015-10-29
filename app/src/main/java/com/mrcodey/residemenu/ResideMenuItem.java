package com.mrcodey.residemenu;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.mrcodey.activity.DecodeQRCode;
import com.mrcodey.activity.EditInfo;
import com.mrcodey.activity.MyCollect;
import com.mrcodey.activity.WithdrawRecord;
import com.mrcodey.main.R;

/**
 * User: special
 * Date: 13-12-10
 * Time: 下午11:05
 * Mail: specialcyci@gmail.com
 */
public class ResideMenuItem extends RelativeLayout {

    /** menu item  icon  */
    private ImageView iv_icon;
    /** menu item  title */
    private TextView tv_title;
    private ImageView iv_head;
    private TextView tv_username;
    private TextView tv_address;
    private Context mContext;
    private OnClickListener listener;
    private TextView tv_qrCode,tv_record,tv_editData,tv_collect,tv_setting,tv_how;

    public ResideMenuItem(Context context,OnClickListener listener) {
        super(context);
        this.mContext=context;
        this.listener=listener;
        initViews(context);
    }

    public ResideMenuItem(Context context, int icon, int title) {
        super(context);
        initViews(context);
        iv_icon.setImageResource(icon);
        tv_title.setText(title);
    }

    public ResideMenuItem(Context context, int icon, String title) {
        super(context);
        initViews(context);
        iv_icon.setImageResource(icon);
        tv_title.setText(title);
    }

    private void initViews(Context context){
        LayoutInflater inflater=(LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        inflater.inflate(R.layout.residemenu_item, this);
        iv_head=(ImageView)findViewById(R.id.iv_head);
        tv_username=(TextView)findViewById(R.id.tv_username);
        tv_address=(TextView)findViewById(R.id.tv_address);
        tv_qrCode=(TextView)findViewById(R.id.tv_qr_code);
        tv_record=(TextView)findViewById(R.id.tv_record);
        tv_editData=(TextView)findViewById(R.id.tv_edit_data);
        tv_collect=(TextView)findViewById(R.id.tv_collect);
        tv_setting=(TextView)findViewById(R.id.tv_setting);
        tv_how =(TextView)findViewById(R.id.tv_how);
        tv_how.setOnClickListener(listener);
        tv_setting.setOnClickListener(listener);
        iv_head.setOnClickListener(listener);
        tv_username.setOnClickListener(listener);
        tv_address.setOnClickListener(listener);
        tv_qrCode.setOnClickListener(listener);
        tv_record.setOnClickListener(listener);
        tv_editData.setOnClickListener(listener);
        tv_collect.setOnClickListener(listener);
       /* iv_icon = (ImageView) findViewById(R.id.iv_icon);
        tv_title = (TextView) findViewById(R.id.tv_title);*/
    }

    /*@Override
    public void onClick(View v)
    {
        Intent intent;
        switch (v.getId())
        {
            case R.id.iv_head:
                break;
            case R.id.tv_username:
                intent=new Intent(mContext, DecodeQRCode.class);
                mContext.startActivity(intent);
                break;
            case R.id.tv_address:
                break;
            case R.id.tv_qr_code:
                intent=new Intent(mContext, DecodeQRCode.class);
                mContext.startActivity(intent);
                break;
            case R.id.tv_record:
                intent=new Intent(mContext, WithdrawRecord.class);
                mContext.startActivity(intent);
                break;
            case R.id.tv_edit_data:
                intent=new Intent(mContext, EditInfo.class);
                mContext.startActivity(intent);
                break;
            case R.id.tv_collect:
                intent=new Intent(mContext, MyCollect.class);
                mContext.startActivity(intent);
                break;
        }
    }*/



   /* *//**
     * set the icon color;
     *
     * @param icon
     *//*
    public void setIcon(int icon){
        iv_icon.setImageResource(icon);
    }

    *//**
     * set the title with resource
     * ;
     * @param title
     *//*
    public void setTitle(int title){
        tv_title.setText(title);
    }

    *//**
     * set the title with string;
     *
     * @param title
     *//*
    public void setTitle(String title){
        tv_title.setText(title);
    }*/
}
