package com.mrcodey.activity;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

import com.mrcodey.main.R;

/**
 * Created by Mr.Codey on 2015/9/21.
 */
public class ProjectDetails extends Activity
{
    private ImageView mivBack;
    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.project_details);
        mivBack=(ImageView)findViewById(R.id.iv_back);
        mivBack.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                finish();
            }
        });
    }
}
