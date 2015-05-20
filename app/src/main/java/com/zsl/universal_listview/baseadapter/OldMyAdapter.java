package com.zsl.universal_listview.baseadapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.TextView;

import com.koushikdutta.ion.Ion;
import com.zsl.universal_listview.R;
import com.zsl.universal_listview.entity.UserEntity;

import java.util.List;

/**
 * Created by zsl on 15/5/20.
 */
public class OldMyAdapter extends BaseAdapter {
    Context context;
    List<UserEntity> userEntities;
    LayoutInflater inflater;

    public OldMyAdapter(Context context, List<UserEntity> userEntities) {
        this.context = context;
        this.userEntities = userEntities;
        inflater=LayoutInflater.from(context);
    }

    @Override
    public int getCount() {
        return userEntities.size();
    }

    @Override
    public Object getItem(int position) {
        return userEntities.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        final ViewHolder viewHolder;
        if (convertView==null){
            viewHolder=new ViewHolder();
            convertView=inflater.inflate(R.layout.listview_item,parent,false);
            viewHolder.icon= (ImageView) convertView.findViewById(R.id.listview_item_iv_icon);
            viewHolder.name= (TextView) convertView.findViewById(R.id.listview_item_tv_name);
            viewHolder.sex= (TextView) convertView.findViewById(R.id.listview_item_tv_sex);
            viewHolder.checkBox= (CheckBox) convertView.findViewById(R.id.listview_item_cb_checkBox);
            convertView.setTag(viewHolder);
        }else{
            viewHolder= (ViewHolder) convertView.getTag();
        }

        final UserEntity userEntity=userEntities.get(position);


        viewHolder.name.setText(userEntity.getName());
        viewHolder.sex.setText(userEntity.getSex());
        viewHolder.checkBox.setChecked(userEntity.isCheck());
        Ion.with(context).load(userEntity.getIcon()).intoImageView(viewHolder.icon);

        viewHolder.checkBox.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                userEntity.setIsCheck(viewHolder.checkBox.isChecked());
            }
        });

        return convertView;
    }

    public static class ViewHolder{
        TextView name,sex;
        ImageView icon;
        CheckBox checkBox;
    }

}
