package com.mrcodey.activity;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.ListView;

import com.mrcodey.adapter.MyCollectAdapter;
import com.mrcodey.main.R;
import com.mrcodey.model.ProjectInfo;

import java.util.ArrayList;

/**
 * Created by Mr.Codey on 2015/10/29.
 */
public class MyCollect extends Activity
{
    private ImageView ivback;
    private ListView listView;
    private ArrayList<ProjectInfo> mList;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.my_collect);
        ivback=(ImageView)findViewById(R.id.iv_back);
        ivback.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                finish();
            }
        });
        listView=(ListView)findViewById(R.id.lv_collect);
        setData();
        listView.setAdapter(new MyCollectAdapter(getApplicationContext(),mList));
    }
    private void setData()
    {
        mList=new ArrayList<>();
        ProjectInfo info1=new ProjectInfo();
        info1.setName("圆桌");
        info1.setTitle("圆桌众筹项目");
        info1.setsImgUrl("http://img1.touxiang.cn/uploads/20131103/03-034229_273.jpg");
        info1.setProLabel("筹钱");
        ProjectInfo info2=new ProjectInfo();
        info2.setName("医院");
        info2.setTitle("东方医院众筹项目");
        info2.setsImgUrl("http://www.gexing.me/uploads/150125/6-150125121G2359.jpg");
        info2.setProLabel("筹钱");
        ProjectInfo info3=new ProjectInfo();
        info3.setName("健身器材");
        info3.setTitle("健身器材众筹项目");
        info3.setsImgUrl("http://p4.gexing.com/touxiang/20130218/1408/5121c54e72768_200x200_3.jpg");
        info3.setProLabel("筹物");
        ProjectInfo info4=new ProjectInfo();
        info4.setName("学习用品");
        info4.setTitle("学习用品项目");
        info4.setsImgUrl("http://p4.gexing.com/G1/M00/22/71/rBACFFH2JqKgEioVAAAQ1RYM4qw198_200x200_3.jpg");
        info4.setProLabel("筹物");
        mList.add(info1);
        mList.add(info2);
        mList.add(info3);
        mList.add(info4);
    }
}

