package com.mrcodey.activity;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

import com.mrcodey.main.R;

/**
 * Created by Mr.Codey on 2015/10/29.
 */
public class EditInfo extends Activity
{
    private ImageView ivback;
    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.edit_info);
        ivback=(ImageView)findViewById(R.id.iv_back);
        ivback.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                finish();
            }
        });
    }
}
