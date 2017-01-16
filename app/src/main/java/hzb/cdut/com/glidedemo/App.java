package hzb.cdut.com.glidedemo;

import android.app.Application;
import android.content.Context;

/**
 * Created by hans on 2017/1/16 0016.
 */

public class App extends Application {
    public static Context mContext;

    public static Context getAppContext() {
        return mContext;
    }

    @Override
    public void onCreate() {
        super.onCreate();
        mContext = this;
    }
}
