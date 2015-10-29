package com.mrcodey.adapter;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.android.volley.RequestQueue;
import com.android.volley.toolbox.Volley;
import com.mrcodey.main.R;
import com.mrcodey.model.WithDrawInfo;
import com.mrcodey.net.AppController;

import java.util.List;

/**
 * 提现记录的adapter
 * Created by Mr.Codey on 2015/10/28.
 */
public class WithDrawRecordAdapter extends WithImgAdapter
{
    private Context mContext;
    private List<WithDrawInfo> mList;
    private RequestQueue requestQueue;
    public WithDrawRecordAdapter(Context context, List list)
    {
        super(context, list);
        requestQueue= Volley.newRequestQueue(context);
        this.mList=list;
        this.mContext=context;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent)
    {
        ViewHolder holder=null;
        if (convertView==null)
        {
            holder=new ViewHolder();
            convertView= LayoutInflater.from(mContext).inflate(R.layout.withdraw_record_list,parent,false);
            holder.tvdate=(TextView)convertView.findViewById(R.id.tv_date);
            holder.tvtime=(TextView)convertView.findViewById(R.id.tv_time);
            holder.ivhead=(ImageView)convertView.findViewById(R.id.iv_draw_head);
            holder.tvmoney=(TextView)convertView.findViewById(R.id.tv_money_num);
            holder.tvname=(TextView)convertView.findViewById(R.id.tv_pro_name);
            holder.tvstatus=(TextView)convertView.findViewById(R.id.tv_status);
            convertView.setTag(holder);
        }
        else
        {
            holder = (ViewHolder) convertView.getTag();
        }
        /*if(AppController.getInstance().getRequestQueue()==null)
        {
           Log.e("sdf","errotr");
        }*/
       // else
       // {
            displayImg(holder.ivhead, mList.get(position).getHeadUrl(),
                    requestQueue, R.drawable.head2);
      //  }
        holder.tvdate.setText(mList.get(position).getDate());
        holder.tvtime.setText(mList.get(position).getTime());
        holder.tvmoney.setText(Float.toString(mList.get(position).getMoney()));
        holder.tvname.setText(mList.get(position).getName());
        holder.tvstatus.setText(mList.get(position).getStatus());
        return convertView;
    }
public static class ViewHolder
{
    TextView tvdate;
    TextView tvtime;
    ImageView ivhead;
    TextView tvmoney;
    TextView tvname;
    TextView tvstatus;
}
}
