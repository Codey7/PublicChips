package com.mrcodey.adapter;

import java.util.List;

import com.mrcodey.main.R;
import com.mrcodey.model.chatMsgEntity;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.RelativeLayout;
import android.widget.TextView;

/*
 * 聊天适配器
 */
public class ChatAdapter extends BaseAdapter
{
    private List<chatMsgEntity> mList;
    //	private int flag;
    private Context context;

    /*
     * 构造函数
     */
    public ChatAdapter(Context context, List<chatMsgEntity> list)
    {
        // TODO Auto-generated constructor stub
        this.mList = list;
        this.context = context;
    }

    @Override
    public int getItemViewType(int position)
    {
        // TODO Auto-generated method stub
        return super.getItemViewType(position);
    }

    @Override
    public int getViewTypeCount()
    {
        // TODO Auto-generated method stub
        return super.getViewTypeCount();
    }

    @Override
    public int getCount()
    {
        // TODO Auto-generated method stub
        if (mList == null)
        {
            return 0;
        }
        return mList.size();
    }

    @Override
    public Object getItem(int position)
    {
        // TODO Auto-generated method stub
        if (mList == null)
        {
            return null;
        }
        return mList.get(position);
    }

    @Override
    public long getItemId(int position)
    {
        // TODO Auto-generated method stub
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent)
    {
        // TODO Auto-generated method stub
        chatMsgEntity entity = mList.get(position);
        ViewHolder holder = null;
        //初始化各个控件
        if (convertView == null)
        {
            holder = new ViewHolder();
            convertView = LayoutInflater.from(context).inflate(R.layout.chatlist, parent, false);
            holder.rv_left = (RelativeLayout) convertView.findViewById(R.id.rl_left);
            holder.tv_left = (TextView) convertView.findViewById(R.id.iv_chat);
            holder.rv_right = (RelativeLayout) convertView.findViewById(R.id.rl_right);
            holder.tv_right = (TextView) convertView.findViewById(R.id.iv_r_chat);
            convertView.setTag(holder);
        } else
        {
            holder = (ViewHolder) convertView.getTag();
        }
        //0 左 1 右
        if (entity.isMsgType())
        {
            holder.rv_right.setVisibility(View.GONE);
            holder.rv_left.setVisibility(View.VISIBLE);
            holder.tv_left.setText(mList.get(position).getChatContent());
        } else
        {
            holder.rv_right.setVisibility(View.VISIBLE);
            holder.rv_left.setVisibility(View.GONE);
            holder.tv_right.setText(mList.get(position).getChatContent());
        }

        return convertView;
    }

    public static class ViewHolder
    {
        RelativeLayout rv_left;
        RelativeLayout rv_right;
        TextView tv_left;
        TextView tv_right;
    }
}
