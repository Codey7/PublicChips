package com.mrcodey.fragment;

import android.support.v4.app.Fragment;
import android.os.Bundle;
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
 * Created by Mr.Codey on 2015/9/6.
 */
public class RankingFragment extends Fragment
{
    private View view;
    private List<TeamInfo> mList;
    private ListView mListView;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState)
    {
        view =inflater.inflate(R.layout.ranking_fragment,container,false);
        mListView= (ListView) view.findViewById(R.id.lv_rank);
        return view;
    }
    @Override
    public void onActivityCreated(Bundle savedInstanceState)
    {
        super.onActivityCreated(savedInstanceState);
        setData();
        mListView.setAdapter(new ChipsTeamAdapter(getActivity(),mList));
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
}
