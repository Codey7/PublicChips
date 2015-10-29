package com.mrcodey.activity;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.ListView;

import com.mrcodey.adapter.WithDrawRecordAdapter;
import com.mrcodey.main.R;
import com.mrcodey.model.WithDrawInfo;

import java.util.ArrayList;

/**
 * 提现记录
 * Created by Mr.Codey on 2015/10/28.
 */
public class WithdrawRecord extends Activity
{
    private ImageView ivback;
    private ListView listView;
    private ArrayList<WithDrawInfo> mList;
    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.withdraw_record);
        ivback=(ImageView)findViewById(R.id.iv_back);
        ivback.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                finish();
            }
        });
        listView=(ListView)findViewById(R.id.lv_record);
        setData();
        WithDrawRecordAdapter adapter=new WithDrawRecordAdapter(getApplicationContext(),mList);
        listView.setAdapter(adapter);
    }
    private void setData()
    {
        mList=new ArrayList<>();
        WithDrawInfo info1=new WithDrawInfo();
        info1.setDate("20日");
        info1.setTime("15:45");
        info1.setHeadUrl("http://img4.imgtn.bdimg.com/it/u=1519979105,1747027397&fm=21&gp=0.jpg");
        info1.setMoney(20.00f);
        info1.setName("东方医院器材项目");
        info1.setStatus("处理中");
        WithDrawInfo info2=new WithDrawInfo();
        info2.setDate("28日");
        info2.setTime("12:15");
        info2.setHeadUrl("http://p2.gexing.com/touxiang/20120818/1000/502ef72e972a7_200x200_3.png");
        info2.setMoney(10.00f);
        info2.setName("南水北调项目");
        info2.setStatus("处理中");
        WithDrawInfo info3=new WithDrawInfo();
        info3.setDate("20日");
        info3.setTime("16:45");
        info3.setHeadUrl("http://a.hiphotos.baidu.com/zhidao/wh%3D450%2C600/sign=c398a3a8b74543a9f54ef2c82b27a6b4/960a304e251f95caa149efeac9177f3e67095229.jpg");
        info3.setMoney(25.00f);
        info3.setName("大学生创业项目");
        info3.setStatus("处理中");
        WithDrawInfo info4=new WithDrawInfo();
        info4.setDate("10日");
        info4.setTime("19:45");
        info4.setHeadUrl("http://www.qqya.com/userimg/10041/130523120207-001.jpg");
        info4.setMoney(28.00f);
        info4.setName("健身器材项目");
        info4.setStatus("处理中");
        mList.add(info1);
        mList.add(info2);
        mList.add(info3);
        mList.add(info4);
    }
}
