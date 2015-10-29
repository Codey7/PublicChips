package com.mrcodey;

import android.app.Activity;
import android.os.Bundle;
import android.os.Handler;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.Toast;
import android.widget.ViewFlipper;

import com.mrcodey.adapter.ChatAdapter;
import com.mrcodey.main.R;
import com.mrcodey.model.chatMsgEntity;
import com.mrcodey.tools.RefreshView;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Mr.Codey on 2015/9/21.
 */
public class Chat extends Activity
{
    private List<chatMsgEntity> mList;
    private ListView mListView;
    private ChatAdapter mAdapter;
    private Button mBtSend;
    private EditText mContent;
    private String content;
    private ViewFlipper mFlipper;
    private Button mAddBt;
    private RefreshView mRefreshView;
    private Handler mHandler;
    private ImageView mivBack;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.chat);
        mList= new ArrayList<>();
        mListView=(ListView) findViewById(R.id.chat_list);
        mContent=(EditText)findViewById(R.id.et_content);
        mBtSend=(Button)findViewById(R.id.send);
        mFlipper=(ViewFlipper)findViewById(R.id.hide_view);
        mAddBt=(Button)findViewById(R.id.add_others);

        mivBack=(ImageView)findViewById(R.id.iv_back);
        mivBack.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                finish();
            }
        });

        chatMsgEntity entity=new chatMsgEntity("我是小李", true);
        mList.add(entity);
        mAdapter=new ChatAdapter(getApplicationContext(), mList);
        if (mListView!=null)
        {
        mListView.setAdapter(mAdapter);}
        else
        {
            Log.i("log","list is null");
        }
        mHandler=new Handler();
        mRefreshView=(RefreshView)findViewById(R.id.refresh_view);
        if (mRefreshView!=null)
        {
            mRefreshView.setOnRefreshListener(new RefreshView.PullToRefreshListener()
            {

                @Override
                public void onRefresh()
                {
                    // TODO Auto-generated method stub

                    try
                    {
                        Thread.sleep(3000);
                        mHandler.post(new Runnable()
                        {

                            @Override
                            public void run()
                            {
                                // TODO Auto-generated method stub
                                chatMsgEntity entity = new chatMsgEntity("我是小李",
                                        true);
                                mList.add(entity);
                                chatMsgEntity entity1 = new chatMsgEntity("我是小明",
                                        false);
                                mList.add(entity1);
                                mAdapter.notifyDataSetChanged();
                            }
                        });
                    } catch (Exception e)
                    {
                        // TODO: handle exception
                    }
                    mRefreshView.finishRefreshing();
                }
            }, 0);
        }
        else
        {
            Log.i("tag","refersh is null");
        }
        mBtSend.setOnClickListener(new View.OnClickListener()
        {

            @Override
            public void onClick(View v)
            {
                // TODO Auto-generated method stub
                content = mContent.getText().toString().trim();
                if (content.equals(""))
                {
                    Toast.makeText(getApplicationContext(), "输入不能为空", Toast.LENGTH_SHORT).show();
                } else
                {
                    chatMsgEntity entity = new chatMsgEntity(content, false);
                    mList.add(entity);
                    mAdapter.notifyDataSetChanged();
                    mContent.setText("");
                    mListView.setSelection(mListView.getCount() - 1);
                    mContent.clearFocus();
                }
            }
        });
        mAddBt.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                // TODO Auto-generated method stub
                if(mFlipper.isShown())
                {
                    mFlipper.setVisibility(View.GONE);
                }
                else {
                    mFlipper.setVisibility(View.VISIBLE);
                }

            }
        });
    }
}
