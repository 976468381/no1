package com.level.adapter;

import java.util.List;

import com.level.bean.NameEntity;
import com.level.day20handleutils.R;
import com.level.day20handleutils.onGetImageListener;
import com.level.utils.HandlerUtils;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

public class MyAdapter extends BaseAdapter {

	List<NameEntity> list;
	Context context;
	HandlerUtils handlerUtils;//传入工具类对象
	onGetImageListener listener;
	
	public MyAdapter(List<NameEntity> list, Context context,HandlerUtils handlerUtils) {
		super();
		this.list = list;
		this.context = context;
		this.handlerUtils=handlerUtils;
		if (context instanceof onGetImageListener) {
			listener=(onGetImageListener) context;
		}
	}

	@Override
	public int getCount() {
		// TODO Auto-generated method stub
		return list.size();
	}

	@Override
	public Object getItem(int position) {
		// TODO Auto-generated method stub
		return list.get(position);
	}

	@Override
	public long getItemId(int position) {
		// TODO Auto-generated method stub
		return position;
	}

	@Override
	public View getView(int position, View convertView, ViewGroup parent) {
		// TODO Auto-generated method stub
		ViewHolder viewHolder=null;
				
		if (convertView==null) {
			viewHolder=new ViewHolder();
			convertView=LayoutInflater.from(context).
					inflate(R.layout.item_listview, null);
			viewHolder.imageView=(ImageView) convertView.
					findViewById(R.id.imageId);
			viewHolder.name=(TextView) convertView.findViewById(R.id.nameId);
			convertView.setTag(viewHolder);
		}else {
			viewHolder=(ViewHolder) convertView.getTag();
		}
		
		viewHolder.name.setText(list.get(position).getName());
		String imageUrlString=list.get(position).getImageUrl();
		viewHolder.imageView.setTag(imageUrlString);//设置了一个标识
		
		handlerUtils.downLoadImage(imageUrlString);//调用了工具类的方法

		return convertView;
	}

	class ViewHolder{
		TextView name;
		ImageView imageView;
	}
}
