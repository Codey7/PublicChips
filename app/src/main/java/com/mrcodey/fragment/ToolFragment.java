package com.mrcodey.fragment;

import android.support.v4.app.Fragment;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.mrcodey.main.R;

/**
 * Created by Mr.Codey on 2015/9/8.
 */
public class ToolFragment extends Fragment
{
    private View view;
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState)
    {
        view=inflater.inflate(R.layout.team_fragment,container,false);
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
    }
}
