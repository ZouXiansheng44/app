package com.example.yyy;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
//AS的根文件
public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //R.layout R类里面的一个布局文件
        //activity_main引用的一个布局资源
        //      activity_main引用的名字
        setContentView(R.layout.activity_register);
    }
}