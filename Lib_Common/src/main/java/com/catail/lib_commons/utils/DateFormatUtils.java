package com.catail.lib_commons.utils;

import android.annotation.SuppressLint;
import android.util.Log;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.TimeZone;

public class DateFormatUtils {
	
	/**
	 * 英文字符串转日期
	 */
	public static Date En2Date(String EnStr){
		SimpleDateFormat simpleDateFormat = new SimpleDateFormat("HH:mm:ss dd-MMM-yyyy",Locale.ENGLISH);
		simpleDateFormat.setTimeZone(TimeZone.getTimeZone("GMT+08:00"));
		Date date;
		if(EnStr!=null){
			try {
				date = simpleDateFormat.parse(EnStr);
			} catch (ParseException e) {
				date=CN2Date(EnStr);
//				e.printStackTrace();
			}
		}else{
			Log.e("NullExcepton", "时间为空");
			return null;
		}
		
		
		return date;
	}
	/**
	 * 英文字符串转日期
	 */
	public static Date En2DateNo(String EnStr){
		SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd MMM yyyy",Locale.ENGLISH);
		simpleDateFormat.setTimeZone(TimeZone.getTimeZone("GMT+08:00"));
		Date date ;
		if(EnStr!=null){
			try {
				date = simpleDateFormat.parse(EnStr);
			} catch (ParseException e) {
				date=CN2Date(EnStr);
//				e.printStackTrace();
			}
		}else{
			Log.e("NullExcepton", "时间为空");
			return null;
		}
		
		
		return date;
	}
	/**
	 * 中文字符串转日期
	 */
	@SuppressLint("SimpleDateFormat")
	public static Date CN2Date(String CnStr){
		//2017-06-01 04:15:00
		SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		simpleDateFormat.setTimeZone(TimeZone.getTimeZone("GMT+08:00"));
		Date date = null;
		if(CnStr!=null){
			try {
				date = simpleDateFormat.parse(CnStr);
			} catch (ParseException e) {
//				e.printStackTrace();
			}
		}else{
			Log.e("NullExcepton", "时间为空");
			return null;
		}
		return date;
	}
	/**
	 * 中文字符串转日期
	 */
	@SuppressLint("SimpleDateFormat")
	public static Date CN2DateNo(String CnStr){
		//2017-06-01 
		SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
		simpleDateFormat.setTimeZone(TimeZone.getTimeZone("GMT+08:00"));
		Date date = null;
		if(CnStr!=null){
			try {
				date = simpleDateFormat.parse(CnStr);
			} catch (ParseException e) {
//				e.printStackTrace();
			}
		}else{
			Log.e("NullExcepton", "时间为空");
			return null;
		}
		return date;
	}
	/**
	 * 转中文日期
	 */
	@SuppressLint("SimpleDateFormat")
	public static String  DatetoCNDate(Date date){
		String CnStr;
		//将日期转换为字符串
		if(date!=null){
			SimpleDateFormat simpleDateFormat2 = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
			simpleDateFormat2.setTimeZone(TimeZone.getTimeZone("GMT+08:00"));
			CnStr = simpleDateFormat2.format(date);
		}else{
			Log.e("NullExcepton", "时间为空");
			return null;
		}
		return CnStr;
		
	}
	/**
	 * 转中文日期
	 */
	@SuppressLint("SimpleDateFormat")
	public static String  DatetoCNStrNo(Date date){
		String CnStr;
		//将日期转换为字符串
		if(date!=null){
			SimpleDateFormat simpleDateFormat2 = new SimpleDateFormat("yyyy-MM-dd");
			simpleDateFormat2.setTimeZone(TimeZone.getTimeZone("GMT+08:00"));
			CnStr = simpleDateFormat2.format(date);
		}else{
			Log.e("NullExcepton", "时间为空");
			return null;
		}
		return CnStr;
		
	}

	@SuppressLint("SimpleDateFormat")
	public static String  DatetoCNStrYY(Date date){
		String CnStr;
		//将日期转换为字符串
		if(date!=null){
			SimpleDateFormat simpleDateFormat2 = new SimpleDateFormat("yyyy");
			simpleDateFormat2.setTimeZone(TimeZone.getTimeZone("GMT+08:00"));
			CnStr = simpleDateFormat2.format(date);
		}else{
			Log.e("NullExcepton", "时间为空");
			return null;
		}
		return CnStr;

	}

	/**
	 * 英文格式的字符串转中文格式字符串时间
	 */
	public static String EnStr2CnStr(String EnStr){
		Date en2Date = En2Date(EnStr);
		return DatetoCNDate(en2Date);
	}

	/**
	 * 转英文日期
	 */
	public static String DatetoEnDateNo(Date date){
		String CnStr;
		//将日期转换为字符串
		if(date!=null){
			SimpleDateFormat simpleDateFormat2 = new SimpleDateFormat("dd MMM yyyy",Locale.ENGLISH);
			simpleDateFormat2.setTimeZone(TimeZone.getTimeZone("GMT+08:00"));
			CnStr = simpleDateFormat2.format(date);
		}else{
			Log.e("NullExcepton", "时间为空");
			return null;
		}
		return CnStr;
	}
	/**
	 * 转英文日期
	 */
	public static String DatetoEnDate(Date date){
		String CnStr;
		//将日期转换为字符串
		if(date!=null){
			SimpleDateFormat simpleDateFormat2 = new SimpleDateFormat("dd MMM yyyy HH:mm:ss",Locale.ENGLISH);
			simpleDateFormat2.setTimeZone(TimeZone.getTimeZone("GMT+08:00"));
			CnStr = simpleDateFormat2.format(date);
		}else{
			Log.e("NullExcepton", "时间为空");
			return null;
		}
		return CnStr;
	}

	public static String DatetoEnDateNoss(Date date){
		String CnStr;
		//将日期转换为字符串
		if(date!=null){
			SimpleDateFormat simpleDateFormat2 = new SimpleDateFormat("dd MMM yyyy HH:mm",Locale.ENGLISH);
			simpleDateFormat2.setTimeZone(TimeZone.getTimeZone("GMT+08:00"));
			CnStr = simpleDateFormat2.format(date);
		}else{
			Log.e("NullExcepton", "时间为空");
			return null;
		}
		return CnStr;
	}


	public static String CnStr2EnStr(String CnStr){
		Date en2Date = En2Date(CnStr);
		return  DatetoEnDate(en2Date);
	}

	/**
	 * 英文字符串转日期
	 */
	public static Date En2DateNoSS(String EnStr){
		SimpleDateFormat simpleDateFormat = new SimpleDateFormat("HH:mm dd-MMM-yyyy",Locale.ENGLISH);
		simpleDateFormat.setTimeZone(TimeZone.getTimeZone("GMT+08:00"));
		Date date;
		if(EnStr!=null){
			try {
				date = simpleDateFormat.parse(EnStr);
			} catch (ParseException e) {
				date=CN2DateNoSS(EnStr);
//				e.printStackTrace();
			}
		}else{
			Log.e("NullExcepton", "时间为空");
			return null;
		}


		return date;
	}

	/**
	 * 中文字符串转日期
	 */
	@SuppressLint("SimpleDateFormat")
	public static Date CN2DateNoSS(String CnStr){
		//2017-06-01 04:15:00
		SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm");
		simpleDateFormat.setTimeZone(TimeZone.getTimeZone("GMT+08:00"));
		Date date = null;
		if(CnStr!=null){
			try {
				date = simpleDateFormat.parse(CnStr);
			} catch (ParseException e) {
//				e.printStackTrace();
			}
		}else{
			Log.e("NullExcepton", "时间为空");
			return null;
		}
		return date;
	}

	/**
	 * 转英文日期
	 */
	public static String DatetoEnDateNoSS(Date date){
		String CnStr;
		//将日期转换为字符串
		if(date!=null){
			SimpleDateFormat simpleDateFormat2 = new SimpleDateFormat("dd MMM yyyy HH:mm",Locale.ENGLISH);
			simpleDateFormat2.setTimeZone(TimeZone.getTimeZone("GMT+08:00"));
			CnStr = simpleDateFormat2.format(date);
		}else{
			Log.e("NullExcepton", "时间为空");
			return null;
		}
		return CnStr;
	}

	public static String CnStr2EnStrNoSS(String CnStr){
		Date en2Date = En2DateNoSS(CnStr);
		return  DatetoEnDateNoSS(en2Date);
	}

	/**
	 * 将2016-12-22 时间转换为英文格式时间
	 */
	@SuppressLint("SimpleDateFormat")
	public static String FormatDate(String str) {
		String EnStr = null;
		SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
		simpleDateFormat.setTimeZone(TimeZone.getTimeZone("GMT+08:00"));
		try {
			Date parse = simpleDateFormat.parse(str);
			simpleDateFormat = new SimpleDateFormat("dd MMM yyyy", Locale.ENGLISH);
			EnStr = simpleDateFormat.format(parse);
		} catch (ParseException e1) {
//			e1.printStackTrace();
		}
		return EnStr;
	}

	/**
	 * 将 06-DEc-2016类型的时间转换为 06 Dec 2016
	 */
	public static String FormatDateEN(String str) {
		String EnStr = null;
		SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd-MMM-yyyy", Locale.ENGLISH);
		simpleDateFormat.setTimeZone(TimeZone.getTimeZone("GMT+08:00"));
		try {
			Date parse = simpleDateFormat.parse(str);
			simpleDateFormat = new SimpleDateFormat("dd MMM yyyy", Locale.ENGLISH);
			EnStr = simpleDateFormat.format(parse);
		} catch (ParseException e1) {
//			e1.printStackTrace();
		}
		return EnStr;
	}

	/**
	 * 将字符串日期转换为时间日期
	 */
	@SuppressLint("SimpleDateFormat")
	public static Date StrToDate(String str) {
		Date date = null;
		if (str != null) {
			SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
			sdf.setTimeZone(TimeZone.getTimeZone("GMT+08:00"));
			try {
				date = sdf.parse(str);
			} catch (ParseException e) {
//				e.printStackTrace();
			}
		} else {
			Log.e("NullExcepton", "时间为空");
		}
		return date;
	}

	/**
	 * 将字符串日期转换为时间日期
	 */
	@SuppressLint("SimpleDateFormat")
	public static Date StrToDateNoss(String str) {
		Date date = null;
		if (str != null) {
			SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm");
			sdf.setTimeZone(TimeZone.getTimeZone("GMT+08:00"));
			try {
				date = sdf.parse(str);
			} catch (ParseException e) {
//				e.printStackTrace();
			}
		} else {
			Log.e("NullExcepton", "时间为空");
		}
		return date;
	}

	/**
	 * 将字符串日期转换为时间日期
	 */
	@SuppressLint("SimpleDateFormat")
	public static Date StrToDateNO(String str) {
		Date date = null;
		if (str != null) {
			SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
			sdf.setTimeZone(TimeZone.getTimeZone("GMT+08:00"));

			try {
				date = sdf.parse(str);
//				Log.e("AAA", date.toString());
			} catch (ParseException e) {
//				e.printStackTrace();
			}
		} else {
			Log.e("NullExcepton", "时间为空");
			return null;
		}

		return date;
	}

	/**
	 * 将时间日期转换为英文日期 yyyy-MM-dd HH:mm:ss
	 */
	public static String CNDateStrTOENDate(Date CNDate) {
		String ENDate;
		if (CNDate != null) {
			SimpleDateFormat df = new SimpleDateFormat("dd MMM yyyy HH:mm:ss", Locale.ENGLISH);
			df.setTimeZone(TimeZone.getTimeZone("GMT+08:00"));
			ENDate = df.format(CNDate);
		} else {
			Log.e("NullExcepton", "时间为空");
			return null;
		}

		return ENDate;
	}

	public static String CNDateStrTOENDateNoss(Date CNDate) {
		String ENDate;
		if (CNDate != null) {
			SimpleDateFormat df = new SimpleDateFormat("dd MMM yyyy HH:mm", Locale.ENGLISH);
			df.setTimeZone(TimeZone.getTimeZone("GMT+08:00"));
			ENDate = df.format(CNDate);
		} else {
			Log.e("NullExcepton", "时间为空");
			return null;
		}

		return ENDate;
	}


	/**
	 * 将时间日期转换为英文日期 dd MMM yyyy
	 */
	public static String CNDateStrTOENDateNO(Date CNDate) {
		String ENDate;
		if (CNDate != null) {
//			Log.e("CNDate", CNDate.toString());
			SimpleDateFormat df = new SimpleDateFormat("dd MMM yyyy", Locale.ENGLISH);
			df.setTimeZone(TimeZone.getTimeZone("GMT+08:00"));
			ENDate = df.format(CNDate);
//			Log.e("ENDate", ENDate.toString());
		} else {
			Log.e("NullExcepton", "时间为空");
			return null;
		}

		return ENDate;
	}

	/**
	 * 中文时间转换为英文时间 (没有HH:mm:ss)
	 */
	public static String CNStr2ENStrNoTime(String CNStr) {
		String ENStr;
		if (CNStr != null) {
			Date strToDateNO = StrToDateNO(CNStr);
			ENStr = CNDateStrTOENDateNO(strToDateNO);
		} else {
			Log.e("NullExcepton", "时间为空");
			return null;
		}
		return ENStr;
	}

	/**
	 * 中文时间转换为英文时间
	 */
	public static String CNStr2ENStr(String CNStr) {
		String ENStr;
		if (CNStr != null) {
			Date strToDate = StrToDate(CNStr);
			ENStr = CNDateStrTOENDate(strToDate);
		} else {
			Log.e("NullExcepton", "时间为空");
			return null;
		}
		return ENStr;
	}


	public static String CNStr2ENStrNoss(String CNStr) {
		String ENStr;
		if (CNStr != null) {
			Date strToDate = StrToDateNoss(CNStr);
			ENStr = CNDateStrTOENDateNoss(strToDate);
		} else {
			Log.e("NullExcepton", "时间为空");
			return null;
		}
		return ENStr;
	}

	/**
	 * 英文时间转日期
	 */
	public static Date ENStr2Date(String ENStr) {
		SimpleDateFormat simpleDateFormat = new SimpleDateFormat("HH:mm:ss dd MMM yyyy", Locale.ENGLISH);
		simpleDateFormat.setTimeZone(TimeZone.getTimeZone("GMT+08:00"));
		Date date2 = null;
		try {
			date2 = simpleDateFormat.parse(ENStr);
		} catch (ParseException e) {
//			e.printStackTrace();
		}
		return date2;
	}

	/**
	 * 日期转中文时间
	 */
	@SuppressLint("SimpleDateFormat")
	public static String Date2CNStr(Date date) {
		//将日期转换为字符串
		SimpleDateFormat simpleDateFormat2 = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss ");
		simpleDateFormat2.setTimeZone(TimeZone.getTimeZone("GMT+08:00"));
		return simpleDateFormat2.format(date);
	}

	@SuppressLint("SimpleDateFormat")
	public static String Date2CNStrNoss(Date date) {
		//将日期转换为字符串
		SimpleDateFormat simpleDateFormat2 = new SimpleDateFormat("yyyy-MM-dd HH:mm");
		simpleDateFormat2.setTimeZone(TimeZone.getTimeZone("GMT+08:00"));
		return simpleDateFormat2.format(date);
	}

}
