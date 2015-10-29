package com.mrcodey.adapter;

import android.content.Context;
import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.text.Spannable;
import android.text.SpannableStringBuilder;
import android.text.style.ForegroundColorSpan;
import android.text.style.ImageSpan;
import android.text.style.RelativeSizeSpan;

import com.mrcodey.main.R;

import java.util.ArrayList;

/**
 * Created by Mr.Codey on 2015/9/8.
 */
public class DreamViewPagerAdaper extends FragmentPagerAdapter
{
    private ArrayList<Fragment> mfragList;
    private static String[] TITLES = {"梦想TEAM","梦想FUND","梦想TOOL"};
    Context context;
    public DreamViewPagerAdaper(FragmentManager fm,Context context,ArrayList<Fragment> mfragList)
    {
        super(fm);
        this.context=context;
        this.mfragList=mfragList;
    }

    @Override
    public Fragment getItem(int position)
    {
        return mfragList.get(position);
    }

    @Override
    public int getCount()
    {
        return TITLES.length;
    }

    @Override
    public CharSequence getPageTitle(int position)
    {
        SpannableStringBuilder ssb = new SpannableStringBuilder(" "
                + TITLES[position]); // space added before text for
        Drawable myDrawable = context.getResources().getDrawable(
                R.drawable.ic_menu_emoticons);
        myDrawable.setBounds(0, 0, 40,
                40);
        ImageSpan span = new ImageSpan(myDrawable, ImageSpan.ALIGN_BASELINE);

        ForegroundColorSpan fcs = new ForegroundColorSpan(Color.parseColor("#ffffff"));//字体颜色设置为#2196F3
        ssb.setSpan(span, 0, 1, Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);//设置图标
        ssb.setSpan(fcs, 1, ssb.length(), Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);//设置字体颜色
        ssb.setSpan(new RelativeSizeSpan(1.2f), 1, ssb.length(), Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);
        return ssb;
    }
}
