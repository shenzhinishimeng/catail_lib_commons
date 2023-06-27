package com.catail.lib_commons;

import android.app.Application;

//import com.zhy.http.okhttp.OkHttpUtils;
//import java.util.concurrent.TimeUnit;
//import okhttp3.OkHttpClient;

public class DemoApplication extends Application {

    @Override
    public void onCreate() {
        super.onCreate();


       // initOkHttp();
    }

//    private void initOkHttp() {
//
////        HttpsUtils.SSLParams sslParams = HttpsUtils.getSslSocketFactory(null, null, null);
//        OkHttpClient okHttpClient = new OkHttpClient.Builder()
////              .addInterceptor(new LoggerInterceptor("TAG"))
//                .connectTimeout(10000L, TimeUnit.MILLISECONDS)
//                .readTimeout(10000L, TimeUnit.MILLISECONDS)
////                .sslSocketFactory(createSSLSocketFactory())
////                .sslSocketFactory(sslParams.sSLSocketFactory)
////                .sslSocketFactory(SSLSocketClient.getSSLSocketFactory())//配置
////                .hostnameVerifier(SSLSocketClient.getHostnameVerifier())//配置
//                //其他配置
//                .build();
//
//        OkHttpUtils.initClient(okHttpClient);
//
//    }
}
