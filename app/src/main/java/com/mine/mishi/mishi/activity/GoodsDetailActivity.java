package com.mine.mishi.mishi.activity;

import android.content.Context;
import android.content.Intent;
import android.databinding.DataBindingUtil;
import android.graphics.Bitmap;
import android.net.Uri;
import android.support.v4.graphics.drawable.RoundedBitmapDrawable;
import android.support.v4.graphics.drawable.RoundedBitmapDrawableFactory;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.WindowManager;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.bumptech.glide.request.target.BitmapImageViewTarget;
import com.mine.mishi.mishi.HttpRequestLocal.HttpSGdetalis;
import com.mine.mishi.mishi.HttpRequestLocal.HttpSMyOrder;
import com.mine.mishi.mishi.R;
import com.mine.mishi.mishi.base.BaseActivity;
import com.mine.mishi.mishi.bean.BaseRequest;
import com.mine.mishi.mishi.bean.SGdetalis;
import com.mine.mishi.mishi.bean.SMyOrder;
import com.mine.mishi.mishi.databinding.ActivityGoodsDetailBinding;
import com.mine.mishi.mishi.url.ApiConfig;
import com.mine.mishi.mishi.url.RetrofitLoader;
import com.mine.mishi.mishi.utils.SharedPreferencesUtil;
import com.youth.banner.BannerConfig;
import com.youth.banner.Transformer;
import com.youth.banner.listener.OnBannerListener;
import com.youth.banner.loader.ImageLoader;

import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;
import org.greenrobot.eventbus.ThreadMode;

import java.util.ArrayList;
import java.util.List;

import rx.functions.Action1;

public class GoodsDetailActivity extends BaseActivity implements OnBannerListener {
    private ActivityGoodsDetailBinding binding;

    private ArrayList<String> list_path;
    private ArrayList<String> list_title;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = DataBindingUtil.setContentView(this,R.layout.activity_goods_detail);
        initView();
        initData();
    }

    private void initData() {
        list_path = new ArrayList<>();
        list_title = new ArrayList<>();
        Bundle bundle = getIntent().getExtras();
        getData(bundle.getInt("actId"));
    }

    private void initView() {

    }

    @Subscribe(threadMode = ThreadMode.POSTING)
    public void getMessage(String message){

    }

    private void getData(int actId) {
        HttpSGdetalis params = new HttpSGdetalis();
        params.setUserid(SharedPreferencesUtil.getInstance(GoodsDetailActivity.this).getString("userid","0"));
        params.setActId(actId+"");
        RetrofitLoader mRetrofitLoader = new RetrofitLoader();

        mRetrofitLoader.getSGdetalis(params).subscribe(new Action1<BaseRequest<SGdetalis>>() {
            @Override
            public void call(BaseRequest<SGdetalis> listBaseRequest) {
                if (200 == listBaseRequest.getCode() && listBaseRequest.isIsOk()) {
                    Log.e("json:",listBaseRequest.getData().getHome().getGoods_img());
                    setInterfaceData(listBaseRequest);
                }
                Log.e("TAG","success message:" + listBaseRequest.toString());
            }
        }, new Action1<Throwable>() {
            @Override
            public void call(Throwable throwable) {
                Log.e("TAG","error message:" + throwable.getMessage());
            }
        });
    }

    private void setInterfaceData(BaseRequest<SGdetalis> listBaseRequest) {
        initBannerData(listBaseRequest);
        initTitleData(listBaseRequest);
    }

    private void initTitleData(BaseRequest<SGdetalis> listBaseRequest) {
        final SGdetalis.HomeBean home = listBaseRequest.getData().getHome();
        binding.detailTitle.setText(home.getGoods_title());
        binding.detailUsing.setText(home.getFlowNumber()+"人正在抢");
        binding.detailPrice.setText("￥"+home.getCurve_price()+"");

        binding.shopName.setText(home.getShop_name());
        binding.shopFans.setText(home.getNote_number()+"篇笔记");
        /*Glide.with(mContext)
                .load(home.)
                .asBitmap()
                .centerCrop()
                .placeholder(R.mipmap.ic_launcher)
                .diskCacheStrategy(DiskCacheStrategy.ALL) //设置缓存
                .into(new BitmapImageViewTarget(binding.shopHead){
                    @Override
                    protected void setResource(Bitmap resource) {
                        super.setResource(resource);
                        RoundedBitmapDrawable circularBitmapDrawable =
                                RoundedBitmapDrawableFactory.create(mContext.getResources(), resource);
                        circularBitmapDrawable.setCornerRadius(4); //设置圆角弧度
                        binding.shopHead.setImageDrawable(circularBitmapDrawable);
                    }
                });*/
        binding.shopAddress.setText(home.getShop_addres());
        binding.shopPhone.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                callPhone(home.getShop_phone());
            }
        });

    }

    /*public void callPhone(String phoneNum){
        Intent intent = new Intent(Intent.ACTION_CALL);
        Uri data = Uri.parse("tel:" + phoneNum);
        intent.setData(data);
        startActivity(intent);
    }*/

    public void callPhone(String phoneNum) {
        Intent intent = new Intent(Intent.ACTION_DIAL);
        Uri data = Uri.parse("tel:" + phoneNum);
        intent.setData(data);
        startActivity(intent);
    }

    private void initBannerData(BaseRequest<SGdetalis> listBaseRequest) {
        String a =  listBaseRequest.getData().getHome().getGoods_img();
        a = a.substring(1, a.length() - 1);
        String[] arra = a.split(",");

        for(String v : arra) {

            Log.e("json:",v);
            String replace = v.replace("\\\\", "/");
            Log.e("json:",replace);
            String replace1 = replace.replace("\"", "");
            Log.e("json:",replace1);
            list_path.add(ApiConfig.BIG_IMAGE + replace1);
            list_title.add(" ");
            System.out.println(v);
            initBannerNetView();
        }
    }

    private void initBannerNetView() {
        WindowManager wm = (WindowManager) this.getSystemService(Context.WINDOW_SERVICE);
        int width = wm.getDefaultDisplay().getWidth();
        LinearLayout.LayoutParams linearParams =(LinearLayout.LayoutParams) binding.banner.getLayoutParams();
        linearParams.height = width;
        binding.banner.setLayoutParams(linearParams);

        //设置样式，里面有很多种样式可以自己都看看效果
        binding.banner.setBannerStyle(BannerConfig.NOT_INDICATOR);
        //binding.banner.setBannerStyle(BannerConfig.CIRCLE_INDICATOR_TITLE_INSIDE);
        //设置图片加载器
        binding.banner.setImageLoader(new MyLoader());
        //设置轮播的动画效果,里面有很多种特效,可以都看看效果。
        binding.banner.setBannerAnimation(Transformer.Default);
        //轮播图片的文字
        binding.banner.setBannerTitles(list_title);
        //设置轮播间隔时间
        binding.banner.setDelayTime(5000);
        //设置是否为自动轮播，默认是true
        binding.banner.isAutoPlay(true);
        //设置指示器的位置，小点点显示
        binding.banner.setIndicatorGravity(BannerConfig.RIGHT);
        //设置图片加载地址
        binding.banner.setImages(list_path)
                //轮播图的监听
                .setOnBannerListener(this)
                //开始调用的方法，启动轮播图。
                .start();
    }

    /**
     * 轮播监听
     *
     * @param position
     */
    @Override
    public void OnBannerClick(int position) {
        if (list_title.size() != 0) {

        }else{
            Toast.makeText(this, "网络错误，请稍后重试", Toast.LENGTH_SHORT).show();
        }
    }

    /**
     * 网络加载图片
     * 使用了Glide图片加载框架
     */
    private class MyLoader extends ImageLoader {
        @Override
        public void displayImage(Context context, Object path, ImageView imageView) {
            Glide.with(context.getApplicationContext())
                    .load((String) path)
                    .into(imageView);
        }
    }
}
