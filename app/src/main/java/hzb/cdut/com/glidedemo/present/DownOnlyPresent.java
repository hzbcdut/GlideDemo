package hzb.cdut.com.glidedemo.present;

import android.content.Context;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.animation.GlideAnimation;
import com.bumptech.glide.request.target.SimpleTarget;

import java.io.File;

import hzb.cdut.com.glidedemo.constant.Constant;
import hzb.cdut.com.glidedemo.utils.LogUtil;

/**
 * Created by hans on 2017/1/16 0016.
 */

public class DownOnlyPresent {
    public static final String TAG = "DownOnlyPresent";

    private Context mContext;
    private DownloadView downloadView;

    public DownOnlyPresent(Context context, DownloadView downloadView) {
        mContext = context;
        this.downloadView = downloadView;
    }

    public void download(String imageUrl) {
        Glide.with(mContext).load(imageUrl).downloadOnly(new SimpleTarget<File>() {
            @Override
            public void onResourceReady(File resource, GlideAnimation<? super File> glideAnimation) {
                LogUtil.d(Constant.Debug, TAG + " --> resource =" + resource +"   -- 文件大小 =" + resource.length()/1024/1024);
            }
        });
    }
}
