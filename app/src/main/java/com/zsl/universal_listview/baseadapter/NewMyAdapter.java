package com.zsl.universal_listview.baseadapter;

import android.content.Context;
import android.view.View;
import android.widget.CheckBox;

import com.zsl.universal_listview.R;
import com.zsl.universal_listview.baseadapter.utils.UniversalAdapter;
import com.zsl.universal_listview.baseadapter.utils.ViewHolder;
import com.zsl.universal_listview.entity.UserEntity;

import java.util.List;

/**
 * NewMyAdapter
 * Created by zsl on 15/5/19
 */
public class NewMyAdapter extends UniversalAdapter<UserEntity> {

    public NewMyAdapter(Context context, List<UserEntity> datas) {
        super(context, datas,R.layout.listview_item);
    }

    @Override
    public void convert(ViewHolder holder, final UserEntity userEntity) {

        //这里使用链式编程，简化代码
        holder.setImage(R.id.listview_item_iv_icon, userEntity.getIcon())//设置头像
                .setText(R.id.listview_item_tv_name, userEntity.getName())
                .setText(R.id.listview_item_tv_sex,userEntity.getSex());

        //设置CheckBox
        final CheckBox cb=holder.getView(R.id.listview_item_cb_checkBox);
        cb.setChecked(userEntity.isCheck());

        //设置CheckBox的点击事件
        cb.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                userEntity.setIsCheck(cb.isChecked());
            }
        });
    }
}
