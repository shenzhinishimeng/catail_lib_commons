package com.catail.lib_commons.utils;

import android.content.Context;
import android.content.SharedPreferences;

public class PreferenceUtils {
    public static SharedPreferences sp;

    public static void getPreference(Context context) {
        if (sp == null) {
            sp = context.getSharedPreferences("CMSConfig", Context.MODE_PRIVATE);
        }
    }

    public static void putBoolean(Context context, String key, boolean value) {
        getPreference(context);
        sp.edit().putBoolean(key, value).commit();
    }

    public static boolean getBoolean(Context context, String key,
                                     boolean defValue) {
        getPreference(context);
        return sp.getBoolean(key, defValue);
    }

    public static boolean getBoolean(Context context, String key) {
        return getBoolean(context, key, true);
    }

    public static void putString(Context context, String key, String value) {
        getPreference(context);
        sp.edit().putString(key, value).commit();
    }

    public static String getString(Context context, String key, String defValue) {
        getPreference(context);
        return sp.getString(key, defValue);
    }

    public static String getString(Context context, String key) {
        return getString(context, key, "");
    }

    public static void putInt(Context context, String key, int value) {
        getPreference(context);
        sp.edit().putInt(key, value).commit();
    }

    public static int getInt(Context context, String key, int defValue) {
        getPreference(context);
        return sp.getInt(key, defValue);
    }

    /**
     * 移除
     */
    public static void remove(Context context, String key) {
        getPreference(context);
        sp.edit().remove(key).commit();
    }

}
