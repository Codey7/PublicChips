package com.mrcodey.fragment;

import android.graphics.Bitmap;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import com.mrcodey.adapter.ChipsTeamAdapter;
import com.mrcodey.main.R;
import com.mrcodey.model.TeamInfo;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Mr.Codey on 2015/9/8.
 */
public class TeamFragment extends Fragment
{
    private View view;
    private List<TeamInfo> mList;
    private ListView mListView;
    private ChipsTeamAdapter chipsTeamAdapter;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState)
    {
        view=inflater.inflate(R.layout.team_fragment,container,false);
        mListView= (ListView) view.findViewById(R.id.team_list);
        ViewGroup p = (ViewGroup) view.getParent();
        if (p != null) {
            p.removeAllViewsInLayout();
            Log.v("huahua", "fragment1-->移除已存在的View");
        }
        return view;
    }

    @Override
    public void onActivityCreated(Bundle savedInstanceState)
    {
        super.onActivityCreated(savedInstanceState);
        setData();
        chipsTeamAdapter=new ChipsTeamAdapter(getActivity(), mList);
    mListView.setAdapter(chipsTeamAdapter);
}
    private void setData()
    {
        mList=new ArrayList<>();
        TeamInfo t1=new TeamInfo();
        t1.setImgUrl("http://www.2qqtouxiang.cn/uploads/allimg/120218/1_120218173502_1.jpg");
        t1.setTeamName("缺水");
        t1.setTeamIntro("水资源匮乏！");
        TeamInfo t2=new TeamInfo();
        t2.setImgUrl("http://wenwen.soso.com/p/20120529/20120529213837-1735460348.jpg");
        t2.setTeamName("永不停息");
        t2.setTeamIntro("扶贫助困，我们的脚步永不停息！");
        mList.add(t1);
        mList.add(t2);
        mList.add(t1);
        mList.add(t2);
    }

    @Override
    public void onStop()
    {
        super.onStop();
        //回收bitmao
        if(chipsTeamAdapter!=null)
        {
            Bitmap bitmap=chipsTeamAdapter.getBitmap();
            if(bitmap != null && !bitmap.isRecycled()){
                // 回收并且置为null
                bitmap.recycle();
                bitmap = null;
            }
        }
    }
}
