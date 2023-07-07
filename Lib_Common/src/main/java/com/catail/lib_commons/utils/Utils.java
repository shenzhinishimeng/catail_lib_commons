package com.catail.lib_commons.utils;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.app.AlertDialog;
import android.app.Dialog;
import android.content.ContentResolver;
import android.content.ContentUris;
import android.content.Context;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.database.Cursor;
import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Paint.Align;
import android.graphics.Typeface;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.net.Uri;
import android.os.Build;
import android.os.Environment;
import android.provider.DocumentsContract;
import android.provider.MediaStore;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import com.catail.lib_commons.CommonsApplication;
import com.catail.lib_commons.R;
import com.catail.lib_commons.base.BaseActivity;
import com.catail.lib_commons.bean.ProjectAndPermissionBean;
import com.finddreams.languagelib.LanguageType;
import com.finddreams.languagelib.MultiLanguageUtil;
import com.zhy.http.okhttp.OkHttpUtils;
import com.zhy.http.okhttp.callback.FileCallBack;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.math.BigDecimal;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Locale;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;

import okhttp3.Call;

public class Utils {
    /**
     * 检查当前网络是否可用
     */
    public static boolean isNetworkAvailable(Context context) {

        // 获取手机所有连接管理对象（包括对wi-fi,net等连接的管理）
        ConnectivityManager connectivityManager = (ConnectivityManager) context
                .getSystemService(Context.CONNECTIVITY_SERVICE);

        if (connectivityManager == null) {
            return false;
        } else {
            NetworkInfo[] networkInfo = connectivityManager.getAllNetworkInfo();
            NetworkInfo activeNetInfo = connectivityManager.getNetworkInfo(ConnectivityManager.TYPE_WIFI);
            NetworkInfo mobNetInfo = connectivityManager.getNetworkInfo(ConnectivityManager.TYPE_MOBILE);
            if (activeNetInfo.isConnected()) {
                // Toast.makeText(context,
                // CommonsApplication.context.getResources().getString(R.string.wifi),
                // Toast.LENGTH_SHORT).show();
                Logger.e("wifi链接");
            }
            if (mobNetInfo.isConnected()) {
                // Toast.makeText(context,
                // CommonsApplication.context.getResources().getString(R.string.liuliang),
                // Toast.LENGTH_SHORT).show();
                Logger.e("流量链接");
            }
            if (networkInfo != null && networkInfo.length > 0) {
                for (NetworkInfo info : networkInfo) {
                    // 判断当前网络状态是否为连接状态
                    if (info.getState() == NetworkInfo.State.CONNECTED) {
                        return true;
                    }
                }
            }
        }
        return false;
    }

    /**
     * 杀死当前应用的进程
     */
    public static void killProcess() {
        int pid = android.os.Process.myPid();
        android.os.Process.killProcess(pid);
    }

    /**
     * 获取当前系统的版本       中文/英文
     * return 0   ----中文
     * return 1   ----英文
     */
    public static int GetSystemCurrentVersion() {
        int languageType = MultiLanguageUtil.getInstance().getLanguageType();
        if (languageType == LanguageType.LANGUAGE_CHINESE_SIMPLIFIED) {
            return 0;
        } else if (languageType == LanguageType.LANGUAGE_EN) {
            return 1;
        } else if (languageType == LanguageType.LANGUAGE_FOLLOW_SYSTEM) {
            //8.0以上的判断
            if (Build.VERSION.SDK_INT >= 26) {
                String language = Locale.getDefault().getLanguage();
                String country = Locale.getDefault().getCountry();
//                Logger.e("language=", language);
//                Logger.e("country=", country);
                String languageAndCountry = language + "-" + country;
                switch (languageAndCountry) {
                    case "zh-":
                        return 0;
                    case "zh-CN":
                        return 0;
                    case "en-":
                        return 1;
                    case "en-US":
                        return 1;
                    case "en-SG":
                        return 1;
                    default:
                        return 1;
                }
            } else {
                Resources res = CommonsApplication.getContext().getResources();
                Configuration conf = res.getConfiguration();
                Locale locale = conf.locale;
//                Logger.e("local", locale.getLanguage());
//                Logger.e("country", locale.getCountry());
                String languageAndCountry = locale.getLanguage() + locale.getCountry();
                switch (languageAndCountry) {
                    case "zh-":
                        return 0;
                    case "zh-CN":
                        return 0;
                    case "en-":
                        return 1;
                    case "en-US":
                        return 1;
                    case "en-SG":
                        return 1;
                    default:
                        return 1;
                }
            }
        } else {
            return 1;
        }
    }

    /**
     * 进行添加水印图片和文字
     */
    public static Bitmap createBitmap(Bitmap src, Bitmap waterMak, String title) {
        if (src == null) {
            return src;
        }
        // 获取原始图片与水印图片的宽与高
        int width = src.getWidth();
        int height = src.getHeight();

        Bitmap newBitmap = Bitmap.createBitmap(width, height, Config.ARGB_8888);
        Canvas mCanvas = new Canvas(newBitmap);
        // 往位图中开始画入src原始图片
        mCanvas.drawBitmap(src, 0, 0, null);

        if (null != waterMak) {
            int ww = waterMak.getWidth();
            int wh = waterMak.getHeight();
            // 在src的右下角添加水印
            Paint paint = new Paint();
            // paint.setAlpha(100);
            mCanvas.drawBitmap(waterMak, width - ww - 5, height - wh - 5, paint);
        }
        // 开始加入文字
        if (null != title) {
            Paint textPaint = new Paint();
            // 设置字体颜色
            textPaint.setColor(Color.WHITE);
            // 设置字体大小
            textPaint.setTextSize(40);
            // 阴影设置
            textPaint.setShadowLayer(3f, 1, 1, Color.DKGRAY);
            String familyName = "宋体";
            Typeface typeface = Typeface.create(familyName, Typeface.BOLD_ITALIC);
            textPaint.setTypeface(typeface);
            textPaint.setTextAlign(Align.LEFT);
            float textWidth = textPaint.measureText(title);
            // 文字 添加位置
            mCanvas.drawText(title, width - textWidth - 10, height - 26, textPaint);
        }
//        mCanvas.save(Canvas.ALL_SAVE_FLAG);
        mCanvas.save();
        // 保存
        mCanvas.restore();
        return newBitmap;
    }

    /**
     * 删除原图保存水印照片方法
     */
    public static void saveBitmap(Uri captureFileUri, Bitmap bm) {
        File f = new File(captureFileUri.getPath());
        if (f.exists()) {
            f.delete();
        }
        try {
            FileOutputStream out = new FileOutputStream(f);
            // 压缩图片 80 是压缩率，表示压缩20%; 如果不压缩是100，
            bm.compress(Bitmap.CompressFormat.JPEG, 100, out);
            out.flush();
            out.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * 删除原图保存水印照片方法
     */
    public static void saveBitmap(String path, Bitmap bm) {
        File f = new File(path);
        if (f.exists()) {
            f.delete();
        }
        try {
            FileOutputStream out = new FileOutputStream(f);
            // 压缩图片 80 是压缩率，表示压缩20%; 如果不压缩是100，
            bm.compress(Bitmap.CompressFormat.JPEG, 100, out);
            out.flush();
            out.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static int IMAGE_MAX_SIZE = 1024;

    public static Bitmap DealTakePhoto(ContentResolver mContentResolver, String path) {
        Uri uri = Uri.fromFile(new File(path));
        InputStream in;
        try {
            in = mContentResolver.openInputStream(uri);

            // Decode image size
            BitmapFactory.Options o = new BitmapFactory.Options();
            o.inJustDecodeBounds = true;

            BitmapFactory.decodeStream(in, null, o);
            in.close();

            int scale = 1;
            if (o.outHeight > IMAGE_MAX_SIZE || o.outWidth > IMAGE_MAX_SIZE) {
                scale = (int) Math.pow(
                        2,
                        (int) Math.round(Math.log(IMAGE_MAX_SIZE
                                / (double) Math.max(o.outHeight, o.outWidth))
                                / Math.log(0.5)));
            }

            BitmapFactory.Options o2 = new BitmapFactory.Options();
            o2.inSampleSize = scale;
            in = mContentResolver.openInputStream(uri);
            Bitmap b = BitmapFactory.decodeStream(in, null, o2);
            in.close();
            return b;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }


    /**
     * 获取进程号对应的进程名
     */
    public static String getProcessName(int pid) {
        BufferedReader reader = null;
        try {
            reader = new BufferedReader(new FileReader("/proc/" + pid + "/cmdline"));
            String processName = reader.readLine();
            if (!TextUtils.isEmpty(processName)) {
                processName = processName.trim();
            }
            return processName;
        } catch (Throwable throwable) {
            throwable.printStackTrace();
        } finally {
            try {
                if (reader != null) {
                    reader.close();
                }
            } catch (IOException exception) {
                exception.printStackTrace();
            }
        }
        return null;
    }

    /**
     * 判断邮箱的格式正确与否
     * return true/false;
     */
    public static boolean isMobileNO(String mobiles) {
        String rex;
        if (mobiles.length() == 8) {
            rex = "^[89]\\d{7}$";
        } else {
            rex = "^1[3578]\\d{9}$";
        }

        Pattern p = Pattern.compile(rex);
        Matcher m = p.matcher(mobiles);
        return m.matches();
    }

    /**
     * 判断是email不
     */
    public static boolean isEmail(String email) {
//        String regex =  "^([\\w-\\.]+)@((\\[[0-9]{1,3}\\.[0-9]{1,3}\\.[0-9]{1,3}\\.)|(([\\w-]+\\.)+))([a-zA-Z]{2,4}|[0-9]{1,3})(\\]?)$";
        String regex = "^([a-z0-9A-Z]+[-|\\\\.]?)+[a-z0-9A-Z]@([a-z0-9A-Z]+(-[a-z0-9A-Z]+)?\\\\.)+[a-zA-Z]{2,}$";

        Pattern p = Pattern.compile(regex);
        Matcher m = p.matcher(email);
        return m.matches();

    }


    /**
     * 得到自定义的progressDialog
     */
    public static Dialog createLoadingDialog(Activity context, String msg) {
        while (context.getParent() != null) {
            context = context.getParent();
        }
        LayoutInflater inflater = LayoutInflater.from(context);
        View v = inflater.inflate(R.layout.loading_dialog, null);// 得到加载view
        LinearLayout layout = v.findViewById(R.id.dialog_view);// 加载布局
        // main.xml中的ImageView
        ImageView spaceshipImage = v.findViewById(R.id.img);
        TextView tipTextView = v.findViewById(R.id.tipTextView);// 提示文字
        // 加载动画
        Animation hyperspaceJumpAnimation = AnimationUtils.loadAnimation(
                context, R.anim.load_animation);
        // 使用ImageView显示动画
        spaceshipImage.startAnimation(hyperspaceJumpAnimation);
        tipTextView.setText(msg);// 设置加载信息

        Dialog loadingDialog = new Dialog(context, R.style.loading_dialog);// 创建自定义样式dialog

//        loadingDialog.setCancelable(false);// 不可以用“返回键”取消
        loadingDialog.setCanceledOnTouchOutside(false);//点击对话框外不可以取消
        loadingDialog.setContentView(layout, new LinearLayout.LayoutParams(
                LinearLayout.LayoutParams.MATCH_PARENT,
                LinearLayout.LayoutParams.MATCH_PARENT));// 设置布局
        return loadingDialog;

    }

    public static Dialog loadingDialog;

    /**
     * 在某些没有baseActivity使用progressDialog出现方法
     */
    public static void showProgressDialog(Activity activity, String msg) {
//        loadingDialog=null;
        if (loadingDialog == null) {
            loadingDialog = Utils.createLoadingDialog(activity, msg);
            if (!loadingDialog.isShowing()) {
                loadingDialog.show();
            }
        }

    }

    /**
     * 在某些没有baseActivity使用progressDialog出现方法
     */
    public static void dismissProgressDialog() {
        if (loadingDialog != null) {
            loadingDialog.dismiss();
            loadingDialog = null;
        }
    }

    /**
     * 判断输入的字符串是不是数字
     */
    public static boolean isNumeric(String str) {
        return str.matches("^[-+]?(([0-9]+)([.]([0-9]+))?|([.]([0-9]+))?)$");
    }

    /**
     * 专为Android4.4设计的从Uri获取文件绝对路径，以前的方法已不好使
     */
    @SuppressLint("NewApi")
    public static String getPath(final Context context, final Uri uri) {
        final boolean isKitKat = Build.VERSION.SDK_INT >= Build.VERSION_CODES.KITKAT;
        // DocumentProvider
        if (isKitKat && DocumentsContract.isDocumentUri(context, uri)) {
            // ExternalStorageProvider
            if (isExternalStorageDocument(uri)) {
                final String docId = DocumentsContract.getDocumentId(uri);
                final String[] split = docId.split(":");
                final String type = split[0];
                if ("primary".equalsIgnoreCase(type)) {
                    return Environment.getExternalStorageDirectory() + "/" + split[1];
                }
            }
            // DownloadsProvider
            else if (isDownloadsDocument(uri)) {
                final String id = DocumentsContract.getDocumentId(uri);
                final Uri contentUri = ContentUris.withAppendedId(
                        Uri.parse("content://downloads/public_downloads"), Long.valueOf(id));
                return getDataColumn(context, contentUri, null, null);
            }
            // MediaProvider
            else if (isMediaDocument(uri)) {
                final String docId = DocumentsContract.getDocumentId(uri);
                final String[] split = docId.split(":");
                final String type = split[0];
                Uri contentUri = null;
                if ("image".equals(type)) {
                    contentUri = MediaStore.Images.Media.EXTERNAL_CONTENT_URI;
                } else if ("video".equals(type)) {
                    contentUri = MediaStore.Video.Media.EXTERNAL_CONTENT_URI;
                } else if ("audio".equals(type)) {
                    contentUri = MediaStore.Audio.Media.EXTERNAL_CONTENT_URI;
                }
                final String selection = "_id=?";
                final String[] selectionArgs = new String[]{split[1]};
                return getDataColumn(context, contentUri, selection, selectionArgs);
            }
        }
        // MediaStore (and general)
        else if ("content".equalsIgnoreCase(uri.getScheme())) {
            return getDataColumn(context, uri, null, null);
        }
        // File
        else if ("file".equalsIgnoreCase(uri.getScheme())) {
            return uri.getPath();
        }
        return null;
    }

    public static String getDataColumn(Context context, Uri uri, String selection,
                                       String[] selectionArgs) {
        Cursor cursor = null;
        final String column = "_data";
        final String[] projection = {column};
        try {
            cursor = context.getContentResolver().query(uri, projection, selection, selectionArgs,
                    null);
            if (cursor != null && cursor.moveToFirst()) {
                final int column_index = cursor.getColumnIndexOrThrow(column);
                return cursor.getString(column_index);
            }
        } finally {
            if (cursor != null)
                cursor.close();
        }
        return null;
    }

    /**
     * @param uri The Uri to check.
     * @return Whether the Uri authority is ExternalStorageProvider.
     */
    public static boolean isExternalStorageDocument(Uri uri) {
        return "com.android.externalstorage.documents".equals(uri.getAuthority());
    }

    /**
     * @param uri The Uri to check.
     * @return Whether the Uri authority is DownloadsProvider.
     */
    public static boolean isDownloadsDocument(Uri uri) {
        return "com.android.providers.downloads.documents".equals(uri.getAuthority());
    }

    /**
     * @param uri The Uri to check.
     * @return Whether the Uri authority is MediaProvider.
     */
    public static boolean isMediaDocument(Uri uri) {
        return "com.android.providers.media.documents".equals(uri.getAuthority());
    }

    /**
     * 这个方法是处理显示多个的pic
     */
    public static List<String> DealShowPicList(List<String> PhotoLists, int show_photo_count) {
        List<String> tempPhotoLists = new ArrayList<>();
        if (PhotoLists.size() >= show_photo_count) {
            for (int i = 0; i < show_photo_count; i++) {
                tempPhotoLists.add(PhotoLists.get(i));
            }
        } else {
            tempPhotoLists.addAll(PhotoLists);
        }
        return tempPhotoLists;
    }


    public static String OriginalUrlToThumbUrl(String OriginalUrl) {
        String thambulr = "";
        String[] imgStr = OriginalUrl.split("/");
        for (int i = 0; i < imgStr.length; i++) {
            if (i == imgStr.length - 1) {
                thambulr = thambulr + Global.ThambStr + imgStr[i];
            } else {
                thambulr += imgStr[i] + "/";
            }
        }
        Logger.e("thamburl==", thambulr);
        return thambulr;
    }


    public static String ThumbUrlToOriginalUrl(String OriginalUrl) {
        String thambulr = "";
        String[] imgStr = OriginalUrl.split("/");
        for (int i = 0; i < imgStr.length; i++) {
            if (i == imgStr.length - 1) {
                String substring = imgStr[i].substring(6);
                thambulr = thambulr + substring;
            } else {
                thambulr += imgStr[i] + "/";
            }
        }
        Logger.e("thamburl==", thambulr);
        return thambulr;
    }

    public static String getStackTraceStr(Exception e) {
        String s = "";
        for (int i = 0; i < e.getStackTrace().length; i++) {
//            Logger.e(i + "==" + (e.getStackTrace())[i].toString());
            s += (e.getStackTrace())[i].toString() + "\n";
        }
        return s;
    }




    public static void setAlertDialogSize(AppCompatActivity activity, AlertDialog dialog, double size) {
        int width = activity.getWindowManager().getDefaultDisplay().getWidth();
        int height = activity.getWindowManager().getDefaultDisplay().getHeight();
        if (size != 0) {
            dialog.getWindow().setLayout((int) (width * size), ActionBar.LayoutParams.WRAP_CONTENT);
        } else {
            dialog.getWindow().setLayout((int) (width * 0.88), ActionBar.LayoutParams.WRAP_CONTENT);
        }
    }

    public static void setAlertDialogConner(AlertDialog dialog) {
        dialog.getWindow().setBackgroundDrawable(null);
    }



    public static String getCurrentYYDate() {
        SimpleDateFormat sdf = new SimpleDateFormat();// 格式化时间
        sdf.applyPattern("yyyy-MM-dd");// a为am/pm的标记
        Date date = new Date();// 获取当前时间
        return DateFormatUtils.DatetoCNStrYY(date);
    }

    public static String getCurrentCNDate() {
        Calendar calendar = Calendar.getInstance();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        String dateStr = sdf.format(calendar.getTime());
        return dateStr;
    }

    public static boolean CheckStartDateAndEndDate(
            BaseActivity activity,
            String startDate, String endDate) {
        //1. 起止时间必须得选择, 2. 不能跨年.
        Logger.e("------------------------------");
        Logger.e("开始时间" + !TextUtils.isEmpty(startDate));
        Logger.e("结束时间" + !TextUtils.isEmpty(endDate));
        Logger.e("------------------------------");
        //第一个判断条件
        if (TextUtils.isEmpty(startDate) && TextUtils.isEmpty(endDate)) {
            return true;
        } else {
            if (TextUtils.isEmpty(startDate) || TextUtils.isEmpty(endDate)) {
                if (TextUtils.isEmpty(startDate)) {
                    activity.showToast(activity.getResources().getString(R.string.please_select_a_start_date));
                }

                if (TextUtils.isEmpty(endDate)) {
                    activity.showToast(activity.getResources().getString(R.string.please_select_an_end_date));
                }
                return false;
            } else {
                String startDateYY = startDate.substring(0, 4);
                String endDateYY = endDate.substring(0, 4);

                if (!startDateYY.equals(endDateYY)) {
                    activity.showToast(activity.getResources().getString(R.string.please_select_the_same_year));
                    return false;
                } else {
                    return true;
                }
            }
        }

    }

    public static double Keep1Decimal(double num1) {
        BigDecimal b = new BigDecimal(num1);
        //保留2位小数
        return b.setScale(1, BigDecimal.ROUND_HALF_UP).doubleValue();

    }


}
