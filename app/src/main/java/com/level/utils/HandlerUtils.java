package com.level.utils;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;


public class HandlerUtils {

	Handler handler;
	//创建一个固定数量线程的线程池对象
	public static ExecutorService executor=Executors.
			newFixedThreadPool(10);

	public HandlerUtils(Handler handler) {
		super();
		this.handler = handler;
	}
	
	public void downLoadImage(final String url) {
		//线程池分配一个子线程
		executor.execute(new Runnable() {
			
			@Override
			public void run() {
				// TODO Auto-generated method stub
				byte[] imageByte=DownLoadUtils.getImageByte(url);
				Bitmap bitmap=BitmapFactory.
						decodeByteArray(imageByte, 0, imageByte.length);
				Message message=Message.obtain();
				message.obj=bitmap;
				Bundle bundle=new Bundle();
				bundle.putString("url", url);
				message.setData(bundle);
				handler.sendMessage(message);//下载成功后发送消息
				
			}
		});
	}
	
}
