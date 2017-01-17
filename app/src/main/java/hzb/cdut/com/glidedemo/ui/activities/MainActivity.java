package hzb.cdut.com.glidedemo.ui.activities;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

import com.github.piasy.biv.BigImageViewer;
import com.github.piasy.biv.indicator.progresspie.ProgressPieIndicator;
import com.github.piasy.biv.loader.glide.GlideImageLoader;
import com.github.piasy.biv.view.BigImageView;

import hzb.cdut.com.glidedemo.R;
import hzb.cdut.com.glidedemo.present.DownloadView;

public class MainActivity extends AppCompatActivity implements DownloadView{
    private static final String TAG = "MainActivity";


    private BigImageView bigImageView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        // 使用Glide下载
        BigImageViewer.initialize(GlideImageLoader.with(getApplicationContext())); //这一步必须放在setContentView()方法之前
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_main);
        bigImageView = (BigImageView) findViewById(R.id.big_image_viewer);


//        bigImageView.post(new Runnable() {
//            @Override
//            public void run() {
//                loadBigImage();
//            }
//        });

        findViewById(R.id.btn).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
//                loadBigImage();
                Intent intent = new Intent(MainActivity.this, BigImageActivity.class);
                startActivity(intent);
            }
        });
    }

    private void loadBigImage() {
//        Uri uri = Uri.parse("android.resource://" + getPackageName() + "/mipmap-xxhdpi/long_big_image");
//        bigImageView.showImage(uri);
        bigImageView.setProgressIndicator(new ProgressPieIndicator());
        bigImageView.showImage(
                Uri.parse("http://img1.imgtn.bdimg.com/it/u=1520386803,778399414&fm=21&gp=0.jpg"),
                Uri.parse("http://youimg1.c-ctrip.com/target/tg/773/732/734/7ca19416b8cd423f8f6ef2d08366b7dc.jpg"));
    }

    @Override
    protected void onResume() {
        super.onResume();
//        final String imageUrl = "http://img.ivsky.com/img/tupian/pic/201308/30/yueyuanzhiye-009.jpg";  //这个地址才可以  Glide加载图片没有网络权限也可以？
////        String imageUrl = "https://lscdn.r2games.com/uploads/1609/261442319520.jpg";  //这个地址不行
////        Glide.with(this).load(imageUrl).error(R.mipmap.ic_launcher).into(iv);  // 这样未显示， 加载不出来也不报错

//        present.download(imageUrl);
    }
}
