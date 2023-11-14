package com.catail.lib_commons.interfaces;

import androidx.appcompat.app.AppCompatActivity;

import com.catail.lib_commons.bean.QRCodeResultBean;

public interface StartTaskDetailsActivityCallback {

    void startTaskDetailsActivity(AppCompatActivity activity, String open_flag,
                                  QRCodeResultBean qrCodeResultBean);
}
