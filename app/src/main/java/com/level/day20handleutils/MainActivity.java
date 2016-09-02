package com.level.day20handleutils;

import java.util.ArrayList;
import java.util.List;

import com.level.adapter.MyAdapter;
import com.level.bean.NameEntity;
import com.level.utils.HandlerUtils;

import android.app.Activity;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.os.Handler;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ImageView;
import android.widget.ListView;

public class MainActivity extends Activity implements onGetImageListener{

	ListView listView;
	List<NameEntity> dataEntities;//数据源
	String[] images={"http://img2.imgtn.bdimg.com/it/u=2059708553,255963759&fm=206&gp=0.jpg"
			,"http://img0.imgtn.bdimg.com/it/u=3232463365,1553586369&fm=206&gp=0.jpg",
			"http://img2.imgtn.bdimg.com/it/u=1023930876,2577057362&fm=206&gp=0.jpg",
			"http://img4.imgtn.bdimg.com/it/u=2664351687,1345171687&fm=206&gp=0.jpg",
			"http://img1.imgtn.bdimg.com/it/u=2749148122,2921708569&fm=206&gp=0.jpg",
			"http://img1.imgtn.bdimg.com/it/u=1999548382,459746913&fm=206&gp=0.jpg",
			"http://img1.imgtn.bdimg.com/it/u=3192461663,1356430848&fm=206&gp=0.jpg"};
	
	Handler handler=new Handler(){
		public void handleMessage(android.os.Message msg) {
			
			Bitmap bitmap=(Bitmap) msg.obj;
			Log.d("zsp", "handleMessage"+bitmap);
			String urlString=msg.getData().getString("url");
			ImageView imageView=(ImageView) listView.
					findViewWithTag(urlString);
			if (bitmap!=null&& imageView!=null) {
				imageView.setImageBitmap(bitmap);
			}
			
			
			
		};
	};//用来接收消息
	MyAdapter adapter;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		
		InitView();
		initData();
		HandlerUtils handlerUtils=new HandlerUtils(handler);
		adapter=new MyAdapter(dataEntities, this,handlerUtils);
		listView.setAdapter(adapter);
	}

	private void initData() {
		// TODO 初始化数据源
		dataEntities=new ArrayList<NameEntity>();
		NameEntity nameEntity;
		for (int i = 0; i < 7; i++) {
			nameEntity=new NameEntity("图片"+i, images[i]);
			dataEntities.add(nameEntity);
		}
	}

	private void InitView() {
		// TODO Auto-generated method stub
		listView=(ListView) findViewById(R.id.listviewId);
	}

	@Override
	public void getImage(Bitmap bitmap) {
		// TODO 接口回调方法
		
	}

}
