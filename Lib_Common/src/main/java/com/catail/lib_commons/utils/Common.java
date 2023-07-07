package com.catail.lib_commons.utils;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Context;
import android.graphics.drawable.BitmapDrawable;
import android.util.Base64;
import android.view.Gravity;
import android.view.View;
import android.widget.PopupWindow;
import android.widget.Toast;

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
	 */
	public static int px2dp(int px, Context context) {
		float desntity = context.getResources().getDisplayMetrics().density;
		return (int) (px / desntity + 0.5f);
	}

	/**
	 * dp转px
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
	 */
	public static void showToast(final Activity activity, final String str) {
		if (activity != null) {
			activity.runOnUiThread(() -> Toast.makeText(activity, str, Toast.LENGTH_SHORT).show());
		}
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
	 */
	public static String getNowDate() {
		String retDate;
		String nowTime = getNowDateTime();
		retDate = nowTime.substring(0, 10);
		return retDate;
	}

	/**
	 * 2016-01-01 格式转化为 06-Apr-2016 格式
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
	 */
	public static String getNowShortTime() {
		String retTime;
		String nowTime = getNowDateTime();
		retTime = nowTime.substring(11, 16);
		return retTime;
	}



}
