package com.zsl.universal_listview;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ListView;
import com.zsl.universal_listview.baseadapter.MyBaseAdapter;
import com.zsl.universal_listview.entity.UserEntity;
import java.util.ArrayList;
import java.util.List;


public class MainActivity extends AppCompatActivity {

    ListView lv_show;

    List<UserEntity> userEntities;

    private MyBaseAdapter myBaseAdapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        initView();


        initData();


    }

    private void initData() {
        userEntities=new ArrayList<UserEntity>();
        for (int i=0;i<1000;i++){
            UserEntity userEntity=new UserEntity("小花"+i,"女"+i);
            userEntities.add(userEntity);
        }

        myBaseAdapter=new MyBaseAdapter(MainActivity.this,userEntities);
        lv_show.setAdapter(myBaseAdapter);
    }

    private void initView() {
        lv_show= (ListView) findViewById(R.id.main_lv_show);
    }
}
