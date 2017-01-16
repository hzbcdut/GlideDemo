package hzb.cdut.com.glidedemo;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.widget.ImageView;

import com.bumptech.glide.DrawableRequestBuilder;
import com.bumptech.glide.Glide;
import com.bumptech.glide.RequestManager;

public class MainActivity extends AppCompatActivity {

    ImageView iv;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

            iv= (ImageView) findViewById(R.id.iv);
//        String imageUrl = "http://lscdn.r2games.com/uploads/moments/livestar/170113/131652044214compress";
//        final String imageUrl = "https://lscdn.r2games.com/uploads/1609/261442319520.jpg";
//        Glide.with(this).load(imageUrl).error(R.mipmap.ic_launcher).into(iv);  // 这样未显示

//        iv.post(new Runnable() {
//            @Override
//            public void run() {
//                Glide.with(MainActivity.this).load(imageUrl).error(R.mipmap.ic_launcher).into(iv);  // 这样也未显示
//            }
//        });
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

    }
}
