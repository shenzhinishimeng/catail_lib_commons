package com.catail.lib_commons;

import android.app.Activity;
import android.app.Application;
import android.content.Context;

import com.blankj.utilcode.util.Utils;
import com.catail.lib_commons.utils.Preference;
import com.zhy.http.okhttp.OkHttpUtils;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

import okhttp3.OkHttpClient;

public class CommonsApplication extends Application {
    public static List<Activity> activityList;
    public static Context context;
    public static List<Activity> picActivityList;  //这个集合是单独记录照片从本地相册取出之后,要关闭的界面
    public static ArrayList<String> picArrayList;  //这个集合是记录选取的图片的张数


    @Override
    public void onCreate() {
        super.onCreate();

        init();//初始化基本数据

        initOkHttp();

        Utils.init(this);//初始化各种工具类
    }


    public static Context getContext() {
        return context;
    }


    private void init() {
        context = getApplicationContext();
        activityList = new ArrayList<>();
        picActivityList = new ArrayList<>();
        picArrayList = new ArrayList<>();
        Preference.createSysparamSp(getApplicationContext());
    }

    private void initOkHttp() {

//        HttpsUtils.SSLParams sslParams = HttpsUtils.getSslSocketFactory(null, null, null);
        OkHttpClient okHttpClient = new OkHttpClient.Builder()
//              .addInterceptor(new LoggerInterceptor("TAG"))
                .connectTimeout(10000L, TimeUnit.MILLISECONDS)
                .readTimeout(10000L, TimeUnit.MILLISECONDS)
//                .sslSocketFactory(createSSLSocketFactory())
//                .sslSocketFactory(sslParams.sSLSocketFactory)
//                .sslSocketFactory(SSLSocketClient.getSSLSocketFactory())//配置
//                .hostnameVerifier(SSLSocketClient.getHostnameVerifier())//配置
                //其他配置
                .build();

        OkHttpUtils.initClient(okHttpClient);

    }
}
