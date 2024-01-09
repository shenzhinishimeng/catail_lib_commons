package com.catail.lib_commons;

import android.app.Activity;
import android.app.Application;
import android.content.Context;
import android.content.res.Configuration;
import android.os.Build;
import android.os.StrictMode;
import android.os.Vibrator;

import com.blankj.utilcode.util.Utils;
import com.bumptech.glide.Glide;
import com.bumptech.glide.integration.okhttp3.OkHttpUrlLoader;
import com.bumptech.glide.load.model.GlideUrl;
import com.catail.lib_commons.utils.Preference;
import com.catail.lib_commons.utils.TrustAllCerts;
import com.finddreams.languagelib.MultiLanguageUtil;
import com.hjq.toast.Toaster;
import com.hjq.toast.style.WhiteToastStyle;
import com.zhy.http.okhttp.OkHttpUtils;
import com.zhy.http.okhttp.https.HttpsUtils;

import java.io.InputStream;
import java.security.SecureRandom;
import java.security.cert.X509Certificate;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

import javax.net.ssl.HostnameVerifier;
import javax.net.ssl.HttpsURLConnection;
import javax.net.ssl.SSLContext;
import javax.net.ssl.SSLSession;
import javax.net.ssl.TrustManager;
import javax.net.ssl.X509TrustManager;

import okhttp3.OkHttpClient;

public class CommonsApplication extends Application {
    public static List<Activity> activityList;

    public static Context mContext;
    //    public LocationService locationService;
    public Vibrator mVibrator;

    @Override
    public void onCreate() {
        super.onCreate();
        activityList = new ArrayList<>();
        mContext = getApplicationContext();
        Preference.createSysparamSp(getApplicationContext());

        initOkHttp();//初始化okhttputils
//        handleSSLHandshake();
//        ZXingLibrary.initDisplayOpinion(this);//初始化二维码扫描
//        initX5WebView();//x5webview

        Utils.init(this);//初始化各种工具类

//        initBDLocation();

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.N) {
            StrictMode.VmPolicy.Builder builder = new StrictMode.VmPolicy.Builder();
            StrictMode.setVmPolicy(builder.build());

        }
        initMultiLanguage();//多语言切换

        // 初始化吐司工具类
        Toaster.init(this, new WhiteToastStyle());


    }


    public static Context getContext() {
        return mContext;
    }

    private void initOkHttp() {
        try {
//        HttpsUtils.SSLParams sslParams = HttpsUtils.getSslSocketFactory(null, null, null);
            TrustAllCerts trustAllCerts = new TrustAllCerts();
            SSLContext sslContext = SSLContext.getInstance("TLS");
            sslContext.init(null, new TrustManager[]{trustAllCerts}, new SecureRandom());

            OkHttpClient okHttpClient = new OkHttpClient.Builder()
//              .addInterceptor(new LoggerInterceptor("TAG"))
                    .connectTimeout(10000L, TimeUnit.MILLISECONDS)
                    .readTimeout(10000L, TimeUnit.MILLISECONDS)
//                .sslSocketFactory(sslParams.sSLSocketFactory, sslParams.trustManager)
//                .sslSocketFactory(createSSLSocketFactory())
//                .sslSocketFactory(sslParams.sSLSocketFactory)
//                .sslSocketFactory(SSLSocketClient.getSSLSocketFactory())//配置
//                .hostnameVerifier(SSLSocketClient.getHostnameVerifier())//配置
                    //其他配置
                    //
                    .hostnameVerifier((hostname, session) -> true)
                    .sslSocketFactory(sslContext.getSocketFactory(),trustAllCerts)
                    .build();
            OkHttpUtils.initClient(okHttpClient);
        } catch (Exception e) {
            e.printStackTrace();
        }


//        try{
//            OkHttpClient okHttpClient = null;
//            OkHttpClient.Builder builder = new OkHttpClient.Builder();
//            builder.connectTimeout(10000L, TimeUnit.SECONDS);//响应时间
//            builder.readTimeout(10000L, TimeUnit.SECONDS);//读取时间
//            // 信任https证书
//            builder.hostnameVerifier(new HostnameVerifier() {
//                @Override
//                public boolean verify(String hostname, SSLSession session) {
//                    return true;
//                }
//            });
//
//            //创建管理器
//            TrustAllCerts trustAllCerts = new TrustAllCerts();
//            try {
//                SSLContext sslContext = SSLContext.getInstance("TLS");
//                sslContext.init(null, new TrustManager[]{trustAllCerts}, new SecureRandom());
//
//                //为OkHttpClient设置sslSocketFactory
//                builder.sslSocketFactory(sslContext.getSocketFactory(), trustAllCerts);
//                okHttpClient = builder.build();
//            } catch (Exception e) {
//                e.printStackTrace();
//            }
//        }catch (Exception e){
//            e.printStackTrace();
//        }
    }

    @Override
    public void onConfigurationChanged(Configuration newConfig) {
        super.onConfigurationChanged(newConfig);
    }


    private void initMultiLanguage() {
        MultiLanguageUtil.init(this);
    }

}
