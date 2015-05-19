package com.zsl.universal_listview.baseadapter;

import android.content.Context;
import com.zsl.universal_listview.R;
import com.zsl.universal_listview.baseadapter.utils.UniversalAdapter;
import com.zsl.universal_listview.baseadapter.utils.ViewHolder;
import com.zsl.universal_listview.entity.UserEntity;

import java.util.List;

/**
 * BaseAdapter
 * Created by zsl on 15/5/19.
 */
public class MyBaseAdapter extends UniversalAdapter<UserEntity> {


    public MyBaseAdapter(Context context, List<UserEntity> datas) {
        super(context, datas);
    }

    @Override
    public void convert(ViewHolder holder, UserEntity userEntity) {

        //这里使用链式编程，简化代码
        holder.setImage(R.id.listview_item_iv_icon, userEntity.getIcon())//设置头像
                .setText(R.id.listview_item_tv_name, userEntity.getName())
                .setText(R.id.listview_item_tv_sex,userEntity.getSex());
    }


}
