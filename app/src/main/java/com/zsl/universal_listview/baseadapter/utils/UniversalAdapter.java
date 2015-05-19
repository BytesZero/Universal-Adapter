package com.zsl.universal_listview.baseadapter.utils;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.zsl.universal_listview.R;

import java.util.List;

/**
 * 这是一个通用的Adapter
 * Created by zsl on 15/5/19.
 */
public abstract class UniversalAdapter<T> extends BaseAdapter {
    protected Context context;
    protected List<T> mlists;
    protected LayoutInflater mInflater;


    public UniversalAdapter(Context context, List<T> mlists) {
        this.context = context;
        this.mlists = mlists;
        mInflater=LayoutInflater.from(context);
    }

    @Override
    public int getCount() {
        return mlists==null?0:mlists.size();
    }

    @Override
    public T getItem(int position) {
        return mlists.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent){
        ViewHolder holder=ViewHolder.get(context,convertView,parent, R.layout.listview_item,position);
        convert(holder,getItem(position));
        return holder.getmConvertView();
    }

    public abstract void convert(ViewHolder holder,T t);


}
