package hzb.cdut.com.glidedemo.module;

import android.content.Context;

import com.bumptech.glide.Glide;
import com.bumptech.glide.GlideBuilder;
import com.bumptech.glide.load.engine.cache.DiskLruCacheFactory;
import com.bumptech.glide.module.GlideModule;

import hzb.cdut.com.glidedemo.constant.Constant;
import hzb.cdut.com.glidedemo.utils.FileUtil;
import hzb.cdut.com.glidedemo.utils.LogUtil;

/**
 * Created by hans on 2017/1/16 0016.
 */

public class CustomCachingGlideModule implements GlideModule{
    private static final String TAG = "CustomCachingGlideModule";
    @Override
    public void applyOptions(Context context, GlideBuilder builder) {
        int cacheSize100MegaBytes = 104857600;
        String downloadDirectoryPath = FileUtil.getFile();
        LogUtil.d(Constant.Debug,TAG + "--> downloadDirectoryPath =" + downloadDirectoryPath);
        builder.setDiskCache(new DiskLruCacheFactory(downloadDirectoryPath, cacheSize100MegaBytes));
    }

    @Override
    public void registerComponents(Context context, Glide glide) {

    }
}
