package com.qfkf.util;

import android.content.Context;
import android.content.SharedPreferences;

/**
 * Created by Administrator on 2016/8/3.
 */
public class ShareUtil {
    private static SharedPreferences sf;
    private static SharedPreferences.Editor editor;

    public static void init(Context context){
        sf = context.getSharedPreferences("shine",Context.MODE_PRIVATE);
        editor = sf.edit();
    }

    public static void putString(String key,String value){
        editor.putString(key,value);
        editor.commit();
    }
    public static String getString(String key){
        return sf.getString(key,null);
    }

    public static void putInt(String key, int value){
        editor.putInt(key, value);
        editor.commit();
    }

    public static int getInt(String key){
        return sf.getInt(key, -1);
    }
}
