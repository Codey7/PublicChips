package com.mrcodey.activity;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

import com.mrcodey.main.R;

/**
 * Created by Mr.Codey on 2015/9/19.
 */
public class AddProject extends Activity implements View.OnClickListener
{
    private Button mbtOk;
    private ImageView mivBack;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.add_project);
        mivBack = (ImageView) findViewById(R.id.iv_back);
        mivBack.setOnClickListener(this);
        mbtOk = (Button) findViewById(R.id.bt_ok);
        mbtOk.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                finish();
            }
        });
    }

    @Override
    public void onClick(View v)
    {
        switch (v.getId())
        {
            case R.id.iv_back:
                finish();
                break;
        }
    }
}
