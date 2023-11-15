package com.catail.lib_commons;

import android.app.Activity;
import android.app.Application;
import android.content.Context;
import android.content.res.Configuration;
import android.os.Build;
import android.os.StrictMode;
import android.os.Vibrator;

import com.blankj.utilcode.util.Utils;
import com.catail.lib_commons.utils.Preference;
import com.finddreams.languagelib.MultiLanguageUtil;
import com.hjq.toast.Toaster;
import com.hjq.toast.style.WhiteToastStyle;
import com.zhy.http.okhttp.OkHttpUtils;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

import okhttp3.OkHttpClient;

public class MainApplication extends CommonsApplication {


    @Override
    public void onCreate() {
        super.onCreate();



    }

    public static Context getContext() {
        return mContext;
    }

}
