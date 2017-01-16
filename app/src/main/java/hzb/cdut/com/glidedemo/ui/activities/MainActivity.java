package hzb.cdut.com.glidedemo.ui.activities;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.widget.ImageView;

import com.bumptech.glide.DrawableRequestBuilder;
import com.bumptech.glide.Glide;
import com.bumptech.glide.RequestManager;

import java.io.File;

import hzb.cdut.com.glidedemo.R;
import hzb.cdut.com.glidedemo.constant.Constant;
import hzb.cdut.com.glidedemo.present.DownOnlyPresent;
import hzb.cdut.com.glidedemo.present.DownloadView;
import hzb.cdut.com.glidedemo.utils.FileUtil;
import hzb.cdut.com.glidedemo.utils.LogUtil;

public class MainActivity extends AppCompatActivity implements DownloadView{
    private static final String TAG = "MainActivity";

    private ImageView iv;

    private DownOnlyPresent present;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        iv = (ImageView) findViewById(R.id.iv);

        present = new DownOnlyPresent(this, this);
        File file = FileUtil.createFile("hzb");
        LogUtil.d(Constant.Debug, TAG + " --> 创建的文件的大小  file.length() =" + file.length());
    }

    @Override
    protected void onResume() {
        super.onResume();
        final String imageUrl = "http://img.ivsky.com/img/tupian/pic/201308/30/yueyuanzhiye-009.jpg";  //这个地址才可以  Glide加载图片没有网络权限也可以？
//        String imageUrl = "https://lscdn.r2games.com/uploads/1609/261442319520.jpg";  //这个地址不行
//        Glide.with(this).load(imageUrl).error(R.mipmap.ic_launcher).into(iv);  // 这样未显示， 加载不出来也不报错


        RequestManager requestManager = Glide.with(this);
        Log.d("debug", "--> requestMangaerr =" + requestManager);
        Log.d("debug", "-->  requestManager.load(imageUrl) =" +  requestManager.load(imageUrl));

        // DrawableRequestBuilder是DrawableTypeRequest的父类
        DrawableRequestBuilder drawableRequestBuilder = requestManager.load(imageUrl);

        drawableRequestBuilder.into(iv);

        present.download(imageUrl);

    }
}
