package com.catail.lib_commons.base;

import android.app.AlertDialog;
import android.content.Context;

import com.catail.lib_commons.interfaces.IApiHolder;
import com.catail.lib_commons.net.NetResponseError;
import com.catail.lib_commons.net.OkHttpManager;
import com.catail.lib_commons.utils.Logger;
import com.catail.lib_commons.utils.MyLog;
import com.squareup.okhttp.Request;
import com.squareup.okhttp.Response;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.util.HashMap;

public class BaseApi {
    private ResultCallBack resultCallBack;
    private Context context;

    public BaseApi(Context context) {
        super();
        this.context = context;
        if (this.context != null && this.context instanceof IApiHolder) {
            ((IApiHolder) this.context).addApiInstance(this);
        }
    }



    public void releaseActivityContext() {
        if (context != null && context instanceof BaseActivity) {
            context = null;
        }
    }

    public void transmitForm(String url, String method, HashMap<String, String> param,
                             final ResultCallBack resultCallBack) throws Exception {
        this.resultCallBack = resultCallBack;
        param.put("cmd", method);
        // OkHttpManager.getInstance()
        new OkHttpManager().postAsynFormRequest(url, param, requestCallBack);

    }

    public void transmitJson(String url, JSONObject jsonData, final ResultCallBack resultCallBack) throws Exception {
        this.resultCallBack = resultCallBack;
        // OkHttpManager.getInstance()
        new OkHttpManager().postAsynJsonRequest(url, jsonData, requestCallBack);
//        if (Config.SERVER_URLTEST.startsWith("https://t.cmstech.aoepos.cn")) {
//            Toast.makeText(CommonsApplication.getContext(), "URL=" + url, Toast.LENGTH_SHORT).show();
//        }
    }

    OkHttpManager.RequestCallBack requestCallBack = new OkHttpManager.RequestCallBack() {

        @Override
        public void onSuccess(Response arg0) {
            try {
                String body = arg0.body().string();
                MyLog.loger("body", body);
                JSONObject jsonObject = new JSONObject(body);
                if (jsonObject.has("errstr") &&
                        jsonObject.getString("errstr").equals("Invalid Token")) {
                    Logger.e("用户在其他设备登录");
//                    showDialogLogin(context);
                    //重复登录
                    //TODO 打开对应的登录界面
                }
                if (!jsonObject.getString("errstr").equals("Invalid Token")) {
                    if (resultCallBack != null)
                        resultCallBack.onSuccess(jsonObject);
                }
            } catch (JSONException e) {
                Logger.e("JSONException", e.getMessage());
                if (resultCallBack != null)
                    resultCallBack.OnFail(e.getMessage(), NetResponseError.analyticalAnomaly);
                e.printStackTrace();
            } catch (IOException e) {
                Logger.e("IOException", e.getMessage());
                if (resultCallBack != null)
                    resultCallBack.OnFail(e.getMessage(), NetResponseError.analyticalAnomaly);
                e.printStackTrace();
            } finally {
                if (resultCallBack != null)
                    resultCallBack = null;
            }

        }

        @Override
        public void onFail(String error, Request request) {
            Logger.e("error==" + error);
            if (resultCallBack != null) {
                resultCallBack.OnFail(error, NetResponseError.netError);
            }

        }
    };

    public interface ResultCallBack {
        void onSuccess(JSONObject jsonObject);

        void OnFail(String error, String failType);
    }

    private AlertDialog alertDialog;

//    private void showDialogLogin(Context context) {
//        Looper.prepare();
//        View view = LayoutInflater.from(context).inflate(R.layout.alertdialog_login, null);
//        alertDialog = new AlertDialog.Builder(context).create();
//        alertDialog.setCancelable(false);
//        alertDialog.setCanceledOnTouchOutside(false);
//        if (context != null && context instanceof Activity && !((Activity) context).isFinishing()) {
//            alertDialog.show();
//        }
//        Window window = alertDialog.getWindow();
//        window.setBackgroundDrawable(new BitmapDrawable());
//        window.setContentView(R.layout.alertdialog_login);
//        TextView quitTextView = window.findViewById(R.id.quit_text);
//        quitTextView.setOnClickListener(this);
//        TextView loginAgainText = window.findViewById(R.id.login_again_text);
//        loginAgainText.setOnClickListener(this);
//        Looper.loop();
//
//    }

//    @Override
//    public void onClick(View v) {
//        Looper.myLooper().quit();
//        if (alertDialog != null && alertDialog.isShowing())
//            alertDialog.dismiss();
//        switch (v.getId()) {
//            case R.id.quit_text:
//                /* 回退到登录界面 */
//                for (int i = 0; i < CommonsApplication.activityList.size(); i++) {
//                    CommonsApplication.activityList.get(i).finish();
//                }
//                break;
//
//            case R.id.login_again_text:
//                /* 回退到登录界面 */
//                for (int i = 0; i < CommonsApplication.activityList.size(); i++) {
//                    CommonsApplication.activityList.get(i).finish();
//                }
//                LoginBean loginBean;
//                try {
//                    loginBean = (LoginBean) Common.stringToObject
//                            (Preference.getSysparamFromSp(SHELL_Config.LOGIN_BEAN));
//                    loginBean.setSuccess(false);
//                    String objectVal = Common.objectToString(loginBean);
//                    Preference.saveSysparamsToSp(SHELL_Config.LOGIN_BEAN, objectVal);
//                    Intent intent = new Intent(CommonsApplication.context, LoginActivity.class);
//                    intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
//                    CommonsApplication.context.startActivity(intent);
//                } catch (Exception e) {
//                    Log.e("error", "activity栈异常：" + e.getMessage());
//                }
//                break;
//        }
//    }
}
