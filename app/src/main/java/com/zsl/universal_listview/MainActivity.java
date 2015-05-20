package com.zsl.universal_listview;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

/**
 * Created by zsl on 15/5/20.
 */
public class MainActivity extends AppCompatActivity {
    Button bt_new,bt_old;

    Intent intent=new Intent();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.actvity_main);

        initView();

        bt_new.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                intent.setClass(MainActivity.this, NewActivity.class);
                startActivity(intent);
            }
        });

        bt_old.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                intent.setClass(MainActivity.this,OldActivity.class);
                startActivity(intent);
            }
        });

    }

    private void initView() {
        bt_new= (Button) findViewById(R.id.main_bt_new);
        bt_old= (Button) findViewById(R.id.main_bt_old);
    }
}
