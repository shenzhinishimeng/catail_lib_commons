package com.catail.lib_commons.interfaces;

import androidx.appcompat.app.AppCompatActivity;

import com.catail.lib_commons.activity.LoginActivity;
import com.catail.lib_commons.base.BaseActivity;
import com.catail.lib_commons.bean.QRCodeResultBean;

public interface OnLoginFinishCallback {

    void onLoginFinish(LoginActivity loginActivity);
}
