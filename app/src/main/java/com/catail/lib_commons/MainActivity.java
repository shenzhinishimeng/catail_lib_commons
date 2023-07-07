package com.catail.lib_commons;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.catail.lib_commons.base.BaseActivity;
import com.catail.lib_commons.utils.Logger;



public class MainActivity extends BaseActivity {

//    @Override
//    protected void onCreate(Bundle savedInstanceState) {
//        super.onCreate(savedInstanceState);
//        setContentView(R.layout.activity_main);
//
////        Logger.e("测试");
//    }

    @Override
    protected int getLayoutResId() {
        return R.layout.activity_main;
    }

    @Override
    public void initView() {
        Logger.e("测试");
    }

    @Override
    public void initData() {

    }
}