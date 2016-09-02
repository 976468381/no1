package com.level.utils;

import java.io.IOException;

import android.util.Log;

import com.squareup.okhttp.OkHttpClient;
import com.squareup.okhttp.Request;
import com.squareup.okhttp.Response;

public class DownLoadUtils {

	public static String getJsonString(String url) {
		String jString="";
		OkHttpClient client=new OkHttpClient();
		Request request=new Request.Builder().url(url).build();
		try {
			Response response=client.newCall(request).execute();
			jString=response.body().string();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		Log.d("zsp", "œ¬‘ÿjson----"+jString);
		return jString;
	}
	
	public static byte[] getImageByte(String url) {
		byte[] b=null;
		OkHttpClient client=new OkHttpClient();
		Request request=new Request.Builder().url(url).build();
		try {
			Response response=client.newCall(request).execute();
			b=response.body().bytes();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		Log.d("zsp", "œ¬‘ÿbyte----"+b);
		return b;
	}
}
