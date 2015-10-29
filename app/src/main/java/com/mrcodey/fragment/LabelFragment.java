package com.mrcodey.fragment;

import android.graphics.Bitmap;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import com.mrcodey.adapter.ChipsTeamAdapter;
import com.mrcodey.adapter.LabelAdapter;
import com.mrcodey.main.R;
import com.mrcodey.model.TeamInfo;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Mr.Codey on 2015/9/6.
 */
public class LabelFragment extends Fragment
{
    private View view;
    private List<TeamInfo> mList;
    private ListView mListView;
    private LabelAdapter labelAdapter;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState)
    {
        view =inflater.inflate(R.layout.label_frag,container,false);
        mListView= (ListView) view.findViewById(R.id.lv_label);
        return view;
    }
    @Override
    public void onActivityCreated(Bundle savedInstanceState)
    {
        super.onActivityCreated(savedInstanceState);
        setData();
        labelAdapter=new LabelAdapter(getActivity(),mList);
        mListView.setAdapter(labelAdapter);
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
        TeamInfo t3=new TeamInfo();
        t3.setImgUrl("http://img1.touxiang.cn/uploads/20130306/06-073207_535.jpg");
        t3.setTeamName("永不停息");
        t3.setTeamIntro("扶贫助困，我们的脚步永不停息！");
        mList.add(t1);
        mList.add(t2);
        mList.add(t3);
        mList.add(t2);
    }

    @Override
    public void onStop()
    {
        super.onStop();
       /* //bitmap 回收
        if(labelAdapter!=null)
        {
            Bitmap bitmap=labelAdapter.getBitmap();
            if(bitmap != null && !bitmap.isRecycled()){
                // 回收并且置为null
                bitmap.recycle();
                bitmap = null;
                Log.i("bitmap", "recyled");
            }
        }*/
    }
}
