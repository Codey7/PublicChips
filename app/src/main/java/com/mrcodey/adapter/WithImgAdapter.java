package com.mrcodey.adapter;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;

import com.android.volley.RequestQueue;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.ImageLoader;
import com.android.volley.toolbox.Volley;
import com.mrcodey.main.R;
import com.mrcodey.net.BitmapCache;
import com.mrcodey.tools.SetRoundImage;

import java.util.List;

/**
 * Created by Mr.Codey on 2015/10/26.
 */
public class WithImgAdapter extends BaseAdapter
{
    private Context mContext;
    private List<?> mList;
    private RequestQueue requestQueue;

    public WithImgAdapter(Context context, List list)
    {
        requestQueue = Volley.newRequestQueue(context);
        this.mContext = context;
        this.mList = list;
    }

    @Override
    public int getCount()
    {
        if (mList == null)
        {
            return 0;
        }
        return mList.size();
    }

    @Override
    public Object getItem(int position)
    {
        if (mList == null)
        {
            return null;
        }
        return mList.get(position);
    }

    @Override
    public long getItemId(int position)
    {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent)
    {
        return null;
    }
    public void displayImg(final View view,String url,RequestQueue mRequestQueue, final int resId){
        ImageLoader imageLoader = new ImageLoader(mRequestQueue, new BitmapCache());

        //ImageLoader.ImageListener listener = ImageLoader.getImageListener((ImageView) view, R.drawable.head, R.drawable.head);
        imageLoader.get(url, new ImageLoader.ImageListener()
        {
            @Override
            public void onResponse(ImageLoader.ImageContainer request, boolean b)
            {
                if(request.getBitmap()!=null)
                {
                    //  ((ImageView) view).setImageDrawable(new CircleImageDrawable(request.getBitmap()));
                    ((ImageView) view).setImageBitmap(SetRoundImage.getRoundedCornerBitmap(request.getBitmap()));
                }
                else
                {
                    ((ImageView) view).setImageResource(resId);//默认图片
                }
            }

            @Override
            public void onErrorResponse(VolleyError volleyError)
            {

            }
        });
        //指定图片允许的最大宽度和高度
        //imageLoader.get("http://developer.android.com/images/home/aw_dac.png",listener, 200, 200);
    }

}
