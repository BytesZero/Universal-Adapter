package com.zsl.universal_listview.baseadapter.utils;

import android.content.Context;
import android.graphics.Bitmap;
import android.util.SparseArray;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.koushikdutta.ion.Ion;

/**
 * ViewHolder
 * Created by zsl on 15/5/19.
 */
public class ViewHolder {
    private SparseArray<View> mViews;
    private int mPosition;
    private View mConvertView;
    private Context mContext;

    /**
     * 初始化ViewHolder
     * @param context
     * @param parent
     * @param layoutId
     * @param position
     */
    public ViewHolder(Context context, ViewGroup parent, int layoutId, int position) {
        this.mContext=context;
        this.mPosition=position;
        this.mViews=new SparseArray<View>();
        mConvertView= LayoutInflater.from(context).inflate(layoutId,parent,false);
        //设置Tag
        mConvertView.setTag(this);
    }

    /**
     * 获得到ViewHolder
     * @param context
     * @param convertView
     * @param parent
     * @param layoutId
     * @param position
     * @return
     */
    public static ViewHolder get(Context context, View convertView, ViewGroup parent, int layoutId, int position) {
        if (convertView == null) {
            return new ViewHolder(context, parent, layoutId, position);
        }else{
            return (ViewHolder) convertView.getTag();
        }
    }

    /**
     * 获得到控件
     * @param viewId
     * @param <T>
     * @return
     */

    public <T extends View> T getView(int viewId){
        View view=mViews.get(viewId);
        if (view==null){
            view=mConvertView.findViewById(viewId);
            mViews.put(viewId,view);
        }
        return (T) view;
    }

    /**
     * 获得到convertView
     * @return
     */
    public View getmConvertView() {
        return mConvertView;
    }

    /**
     * 设置TextView的文本
     * @param viewId
     * @param text
     * @return
     */
    public ViewHolder setText(int viewId,String text){
        TextView textView=getView(viewId);
        textView.setText(text);
        return this;
    }

    /**
     * 通过url设置ImageView 的图片
     * 这里可以修改为自己的图片加载库
     * @param viewId
     * @param url
     * @return
     */
    public ViewHolder setImage(int viewId,String url){
        ImageView imageView=getView(viewId);
        Ion.with(mContext).load(url).intoImageView(imageView);
        return this;
    }

    /**
     * 通过ResourceId设置ImageView 的图片
     * @param viewId
     * @param resourceId
     * @return
     */
    public ViewHolder setImageResource(int viewId,int resourceId){
        ImageView imageView=getView(viewId);
        imageView.setImageResource(resourceId);
        return this;
    }

    /**
     * 通过bitmap 设置ImageView 的图片
     * @param viewId
     * @param bitmap
     * @return
     */
    public ViewHolder setImageBitmap(int viewId,Bitmap bitmap){
        ImageView imageView=getView(viewId);
        imageView.setImageBitmap(bitmap);
        return this;
    }




}
