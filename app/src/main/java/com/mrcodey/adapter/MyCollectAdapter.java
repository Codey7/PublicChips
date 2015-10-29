package com.mrcodey.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.android.volley.RequestQueue;
import com.android.volley.toolbox.Volley;
import com.mrcodey.main.R;
import com.mrcodey.model.ProjectInfo;
import com.mrcodey.net.AppController;

import java.util.List;

/**
 * Created by Mr.Codey on 2015/10/29.
 */
public class MyCollectAdapter extends WithImgAdapter
{
    private Context mContext;
    private List<ProjectInfo> mList;
    private RequestQueue requestQueue;
    public MyCollectAdapter(Context context, List list)
    {
        super(context, list);
        requestQueue= Volley.newRequestQueue(context);
        this.mContext=context;
        this.mList=list;
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
            holder.tvlabel=(TextView)convertView.findViewById(R.id.team_label);
            convertView.setTag(holder);
        } else {
            holder = (ViewHolder) convertView.getTag();
        }
        displayImg(holder.ivImg,mList.get(position).getsImgUrl(), requestQueue, R.drawable.head2);
        holder.name.setText(mList.get(position).getName());
        holder.content.setText(mList.get(position).getTitle());
        holder.tvlabel.setText(mList.get(position).getProLabel());
        return convertView;
    }
    public static class ViewHolder {
        TextView name;
        ImageView ivImg;
        TextView content;
        TextView tvlabel;
    }
}
