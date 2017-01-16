package hzb.cdut.com.glidedemo.utils;

import android.util.Log;


/**
 * Created by Administrator on 2016/5/9 0009.
 */
public class LogUtil {
    public static boolean DEBUG = true;
    public static void i(String tag,String msg){
        if(DEBUG){
            Log.i(tag,msg);
        }
    }
    public static void d(String tag,String msg){
        if(DEBUG){
            Log.d(tag,msg);
        }
    }
    public static void e(String tag,String msg){
        if(DEBUG){
            Log.e(tag,msg);
        }
    }

    public static void e(String tag, String msg, Throwable e) {
        if (DEBUG) {
            Log.e(tag, msg, e);
        }
    }
}
