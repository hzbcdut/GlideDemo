package hzb.cdut.com.glidedemo.utils;

import android.content.Context;
import android.os.Environment;

import java.io.File;

import hzb.cdut.com.glidedemo.constant.Constant;

/**
 * Created by hans on 2017/1/16 0016.
 */

public class FileUtil {
    public static final String TAG = "FileUtil";

    /**判断是否有外置内存卡*/
    private static boolean isHasSdCard(){
        return Environment.getExternalStorageState().equals(
                Environment.MEDIA_MOUNTED);
    }

    /**
     * 创建一个文件
     *
     * @param fileName
     * @return
     */
    public static File createFile(Context context, String fileName) {
        if (isHasSdCard()) {
            String path = Environment.getExternalStorageDirectory().getPath() + "/" + AppInfoUtil.getPackageName(context);
            LogUtil.d(Constant.Debug, TAG + " --> path =" + path);

            File files = new File(path);  //文件夹

            if (!files.exists()) {
                files.mkdirs();
            }

            File file = new File(files, fileName);  //单个文件
            if (!file.exists()) {
                try {
                    file.createNewFile();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
            LogUtil.d(Constant.Debug, TAG + " --> file.getPath() =" + file.getPath());
            return file;
        }
        return null;
    }
}
