package com.mrcodey.activity;

import java.io.File;

import com.mrcodey.main.R;
import com.mrcodey.tools.QRCodeUtil;

import android.app.Activity;
import android.content.Context;
import android.content.SharedPreferences;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.os.Environment;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.ImageView;

public class DecodeQRCode extends Activity {
	private ImageView imageView;
	private Button mButton;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.qrcode);
		imageView=(ImageView)findViewById(R.id.imageView1);
		mButton=(Button)findViewById(R.id.button1);
		
		//生成二维码
		final String filePath = getFileRoot(getApplicationContext())
				+ File.separator + "qr_" + System.currentTimeMillis() + ".jpg";
		// 二维码图片较大时，生成图片、保存文件的时间可能较长，因此放在新线程中
		new Thread(new Runnable() {
			@Override
			public void run() {
				boolean success = QRCodeUtil.createQRImage("老王", 500, 500,
						BitmapFactory.decodeResource(getResources(),
								R.drawable.h2), filePath);

				if (success) {
					runOnUiThread(new Runnable() {
						@Override
						public void run() {
							imageView.setImageBitmap(BitmapFactory
									.decodeFile(filePath));
						}
					});
				}
			}
		}).start();
		imageView.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
			}
		});
		//返回
		mButton.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
			finish();	
			}
		});
	}

	// 文件存储根目录
	private String getFileRoot(Context context) {
		if (Environment.getExternalStorageState().equals(
				Environment.MEDIA_MOUNTED)) {
			File external = context.getExternalFilesDir(null);
			if (external != null) {
				return external.getAbsolutePath();
			}
		}
		return context.getFilesDir().getAbsolutePath();
	}
}
