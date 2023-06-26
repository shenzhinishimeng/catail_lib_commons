package com.catail.lib_commons;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.catail.lib_commons.utils.Logger;


public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Logger.e("测试");
    }
}