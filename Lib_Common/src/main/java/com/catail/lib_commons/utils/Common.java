package com.catail.lib_commons.utils;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface.OnClickListener;
import android.graphics.drawable.BitmapDrawable;
import android.util.Base64;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.Window;
import android.widget.PopupWindow;
import android.widget.TextView;
import android.widget.Toast;

import com.catail.lib_commons.R;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.text.ParsePosition;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

public class Common {
	/**
	 * 对象转字符串
	 * 
	 */
	public static String objectToString(Object object) throws IOException {
		// 创建字节输出流
		ByteArrayOutputStream baos = new ByteArrayOutputStream();
		// 创建字节对象输出流
		ObjectOutputStream out;

		// 然后通过将字对象进行64转码，写入key值为key的sp中
		out = new ObjectOutputStream(baos);
		out.writeObject(object);
		String objectVal = new String(Base64.encode(baos.toByteArray(),
				Base64.DEFAULT));
		
		out.close();
		out.close();
		baos.close();
		return objectVal;

	}

	/**
	 * 字符串转对象
	 * 
	 */

	public static Object stringToObject(String objectVal) throws IOException,
			ClassNotFoundException {
		byte[] buffer = Base64.decode(objectVal, Base64.DEFAULT);
		// 通过读取字节流，创建字节流输入流，写入对象
		ByteArrayInputStream bais = new ByteArrayInputStream(buffer);
		ObjectInputStream ois;

		ois = new ObjectInputStream(bais);
		Object object = ois.readObject();
		
		
		bais.close();
		ois.close();
		return object;

	}




	/**
	 * 像素转屏幕无关像素（dp）
	 * 
	 */
	public static int px2dp(int px, Context context) {
		float desntity = context.getResources().getDisplayMetrics().density;
		return (int) (px / desntity + 0.5f);

	}

	/**
	 * dp转px
	 * 
	 */

	public static int dp2px(int dp, Context context) {
		float desntity = context.getResources().getDisplayMetrics().density;
		return (int) (dp * desntity + 0.5f);
	}

	public static void showWindow(View view, int width, int height, View parent) {

		int[] location = new int[2];
		parent.getLocationOnScreen(location);
		PopupWindow popupWindow = new PopupWindow(view, width, height, true);
		popupWindow.setBackgroundDrawable(new BitmapDrawable());
		popupWindow.setOutsideTouchable(true);
		popupWindow.setFocusable(true);
		// popupWindow.setBackgroundDrawable(new ColorDrawable(R.color.green_textcolor_4BB406));
		popupWindow.showAtLocation(parent, Gravity.NO_GRAVITY, location[0],
				location[1] - popupWindow.getHeight());
	}

	/**
	 * 吐司
	 * 
	 */
	public static void showToast(final Activity activity, final String str) {
		if (activity != null) {
			activity.runOnUiThread(() -> Toast.makeText(activity, str, Toast.LENGTH_SHORT).show());
		}
	}

	/**
	 * 设置
	 * 
	 */
	public static void showDialog(Context context, String title,
			String negativeButtonText, OnClickListener negativeButtonListener,
			String positiveButtonText, OnClickListener positiveButtonListener) {
		AlertDialog.Builder builder = new AlertDialog.Builder(context);
		builder.setCancelable(false);
		builder.setTitle(title)
				.setNegativeButton(negativeButtonText, negativeButtonListener)
				.setPositiveButton(positiveButtonText, positiveButtonListener)
				.create().show();

	}

	/**
	 * 返回当前时间 例： 2016-01-01 12:00:00
	 */
	@SuppressLint("SimpleDateFormat")
	public static String getNowDateTime() {
		String retTime;
		SimpleDateFormat sDateFormat = new SimpleDateFormat(
				"yyyy-MM-dd HH:mm:ss");
		retTime = sDateFormat.format(new Date());
		return retTime;
	}

	/**
	 * 获取当前日期 例：2016-01-01
	 * 
	 */
	public static String getNowDate() {
		String retDate;

		String nowTime = getNowDateTime();
		retDate = nowTime.substring(0, 10);

		return retDate;
	}

	/**
	 * 2016-01-01 格式转化为 06-Apr-2016 格式
	 * 
	 */
	@SuppressLint("SimpleDateFormat")
	public static String dateToEnFormat(String date) {
		String ret = "";
		if (date == null || date.length() != 10 || !date.contains("-"))
			return ret;

		date = date.replaceAll("-", "/");
		SimpleDateFormat formatter = new SimpleDateFormat("yyyy/MM/dd");
		ParsePosition pos = new ParsePosition(0);
		Date strtodate = formatter.parse(date, pos);

		SimpleDateFormat df = new SimpleDateFormat("dd-MMM-yyyy",
				Locale.ENGLISH);
		ret = df.format(strtodate);

		return ret;
	}

	/**
	 * 获取当前日期 例：12:00
	 * 
	 */
	public static String getNowShortTime() {
		String retTime;

		String nowTime = getNowDateTime();
		retTime = nowTime.substring(11, 16);

		return retTime;
	}

	/**
	 * 加载等待....
	 */
	private static View loadView = null;//
	private static AlertDialog loadDialog = null;// 加载dialog,loading...

	public static AlertDialog loadDiaolog(Context context, String proceStr) {
		loadView = LayoutInflater.from(context).inflate(R.layout.load_dialog,
				null);
		loadDialog = new AlertDialog.Builder(context).create();
		Window window = loadDialog.getWindow();
		window.setBackgroundDrawableResource(android.R.color.transparent);
		TextView text =  loadView.findViewById(R.id.load_content);
		text.setText(proceStr);
		loadDialog.setCancelable(true);
		loadDialog.setCanceledOnTouchOutside(false);
		loadDialog.show();
		window.setContentView(loadView);
		// dialog.setContentView(view);
		return loadDialog;

	}

	public static void cancleDialog(Activity activity,
			final AlertDialog loadDialog) {
		if (loadDialog != null) {
			activity.runOnUiThread(() -> {
				if (loadDialog.isShowing()) {
					loadDialog.dismiss();
				}
			});
		}
	}

//	private static RemoteViews contentView;
//	private static final int count = 0;
//	private static final int sum = 0;
//	private static final int len = 0;
//	private static String mSavePath;
//	private static byte[] buf;
//	private static int length;
//	private static OutputStream os;
//	private static InputStream inputStream;

//	public static void createNotification(final Context context, String url) {
//		final NotificationManager notificationManager = (NotificationManager) context
//				.getSystemService(Context.NOTIFICATION_SERVICE);
//		final Notification notification = new Notification();
//		notification.icon = R.drawable.ic_launcher;// 这个图标必须要设置，不然下面那个RemoteViews不起作用.
//		// 这个参数是通知提示闪出来的值.
//		notification.tickerText = "开始下载";
//		//
//		// pendingIntent = PendingIntent.getActivity(this, 0, updateIntent, 0);
//		//
//		// // 这里面的参数是通知栏view显示的内容
//		// notification.setLatestEventInfo(this, app_name, "下载：0%",
//		// pendingIntent);
//		//
//		// notificationManager.notify(notification_id, notification);
//
//		/***
//		 * 在这里我们用自定的view来显示Notification
//		 */
//		contentView = new RemoteViews(context.getPackageName(),
//				R.layout.notification_item);
//		contentView.setTextViewText(R.id.notificationTitle, "正在下载");
//		contentView.setTextViewText(R.id.notificationPercent, "0%");
//		contentView.setProgressBar(R.id.notificationProgress, 100, 0, false);
//
//		notification.contentView = contentView;
//
//		Intent updateIntent = new Intent(context, MenuActivity.class);
//		updateIntent.addFlags(Intent.FLAG_ACTIVITY_SINGLE_TOP);
//		PendingIntent pendingIntent = PendingIntent.getActivity(context, 0,
//				updateIntent, 0);
//
//		notification.contentIntent = pendingIntent;
//
//		notificationManager.notify(0, notification);
//
//		// 下载
//
//		if (Environment.getExternalStorageState().equals(
//				Environment.MEDIA_MOUNTED)) {
//			String sdpath = Environment.getExternalStorageDirectory() + "/";
//			mSavePath = sdpath + "download";
//			url = "https://ss0.bdstatic.com/5aV1bjqh_Q23odCf/static/superman/img/logo/bd_logo1_31bdc765.png";
//			Request request = new Request.Builder().url(url).build();
//			new OkHttpClient().newCall(request).enqueue(new Callback() {
//
//				@Override
//				public void onResponse(final Response arg0) throws IOException {
//
//					((Activity) context).runOnUiThread(new Runnable() {
//
//						@Override
//						public void run() {
//							try {
//								byte b[] = arg0.body().bytes();
//								length = b.length;
//
//								inputStream = new ByteArrayInputStream(b);
//								File file = new File(mSavePath);
//								if (!file.exists()) {
//									file.mkdir();
//								}
//								File apkFile = new File(mSavePath, "CMS.png");
//								os = new FileOutputStream(apkFile);
//								buf = new byte[10];
//
//								while ((len = inputStream.read(buf)) != -1) {
//									os.write(buf, 0, len);
//									sum += len;
//									if (sum != 0 && length != 0) {
//										int i = (int) (((float) sum / length) * 100);
//										contentView.setTextViewText(
//												R.id.notificationPercent, i
//														+ "%");
//										contentView.setProgressBar(
//												R.id.notificationProgress, 100,
//												i, false);
//										notificationManager.notify(0,
//												notification);
//									}
//								}
//								// 完毕，关闭所有链接
//								if (os != null) {
//									os.close();
//								}
//								if (inputStream != null) {
//									inputStream.close();
//								}
//							} catch (IOException e) {
//								Log.e("error", "mmmmmm" + e.getMessage());
//							}
//
//						}
//					});
//
//				}
//
//				@Override
//				public void onFailure(Request arg0, IOException arg1) {
//					showToast((Activity) context, "fail:" + arg1.getMessage());
//
//				}
//			});
//		} else {
//			Log.e("error", "nulllll");
//		}
//
//		// new Handler().postDelayed(new Runnable() {
//		//
//		// @Override
//		// public void run() {
//		// for (int i = 0; i < 30; i++) {
//		// count += 2;
//		// Log.e("error", "count=" + count);
//		// contentView.setTextViewText(R.id.notificationPercent, count
//		// + "%");
//		// contentView.setProgressBar(R.id.notificationProgress, 100,
//		// count, false);
//		// notificationManager.notify(0, notification);
//		// }
//		// }
//		// }, 5000);
//
//	}

	/**
	 * ptw是否粘贴
	 * 
	 */
	public static boolean ptwPaste() {
        return SHELL_Config.PTW_COPY_TAG && SHELL_Config.PTW_PASTE && SHELL_Config.COPY_TAG == 0;
    }

	/**
	 * tbm是否粘贴
	 * 
	 */
	public static boolean tbmPaste() {
        return SHELL_Config.TBM_COPY_TAG && SHELL_Config.TBM_PASTE && SHELL_Config.COPY_TAG == 1;

    }

//	private AlertDialog dialog;
//	private ListView catagoryListView;// 类别

}
