package com.mine.mishi.mishi.activity;

import android.content.Context;
import android.databinding.DataBindingUtil;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.util.Log;
import android.view.KeyEvent;
import android.view.View;
import android.view.WindowManager;
import android.widget.Toast;

import com.mine.mishi.mishi.R;
import com.mine.mishi.mishi.adapter.ViewPagerIndexAdapter;
import com.mine.mishi.mishi.base.BaseActivity;
import com.mine.mishi.mishi.databinding.ActivityMainBinding;
import com.mine.mishi.mishi.fragment.FourthFragment;
import com.mine.mishi.mishi.fragment.IndexFragment;
import com.mine.mishi.mishi.fragment.IndexSubFragment;
import com.mine.mishi.mishi.fragment.SecondFragment;
import com.mine.mishi.mishi.fragment.SecondSubFragment;
import com.mine.mishi.mishi.fragment.ThirdFragment;
import com.mine.mishi.mishi.utils.PopupMenuUtil;
import com.mine.mishi.mishi.utils.Utility;

import org.greenrobot.eventbus.Subscribe;
import org.greenrobot.eventbus.ThreadMode;

import java.util.ArrayList;
import java.util.List;


public class MainActivity extends BaseActivity implements
        IndexFragment.OnFragmentInteractionListener,
        SecondFragment.OnFragmentInteractionListener,
        ThirdFragment.OnFragmentInteractionListener,
        FourthFragment.OnFragmentInteractionListener,
        IndexSubFragment.OnFragmentInteractionListener,
        SecondSubFragment.OnFragmentInteractionListener,
        View.OnClickListener {
    private static final String TAG = "MainActivity";

    private long CURRENT = 0l;
    private ViewPagerIndexAdapter viewPagerIndexAdapter;

    private Context context;

    private ActivityMainBinding mBinding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mBinding = DataBindingUtil.setContentView(this,R.layout.activity_main);

        initViews();
        initListData();
    }

    private void initViews() {
        context = this;
        mBinding.rlClick.setOnClickListener(this);
        mBinding.mainIndex.setOnClickListener(this);
        mBinding.mainSecond.setOnClickListener(this);
        mBinding.mainThird.setOnClickListener(this);
        mBinding.mainFourth.setOnClickListener(this);
        initViewPager();
    }

    @Override
    public void onBackPressed() {
        // 当popupWindow 正在展示的时候 按下返回键 关闭popupWindow 否则关闭activity
        if (PopupMenuUtil.getInstance()._isShowing()) {
            PopupMenuUtil.getInstance()._rlClickAction();
        } else {
            super.onBackPressed();
        }
    }

    private void initListData() {

    }

    private void initViewPager() {
        mBinding.viewPager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {
                selectPage(position,positionOffset,positionOffsetPixels);
            }

            @Override
            public void onPageSelected(int position) {
                selectPage(position,0,0);
            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });
        viewPagerIndexAdapter = new ViewPagerIndexAdapter(getSupportFragmentManager());
        List<Fragment> list = new ArrayList<>();
        list.add(IndexFragment.newInstance("首页",""));
        list.add(SecondFragment.newInstance("分类",""));
        list.add(ThirdFragment.newInstance("购物车",""));
        list.add(FourthFragment.newInstance("我的",""));
        viewPagerIndexAdapter.setList(list);
        mBinding.viewPager.setAdapter(viewPagerIndexAdapter);
        mBinding.viewPager.setOffscreenPageLimit(3);
        mBinding.mainIndex.setChecked(true);
        mBinding.mainIndex.setTextColor(getResources().getColor(R.color.theme_text_color));
    }

    private void selectPage(int position, float positionOffset, int positionOffsetPixels) {
        if (positionOffset == 0 && positionOffsetPixels == 0) {
            switch (position) {
                case 0:
                    mBinding.mainIndex.setChecked(true);
                    break;
                case 1:
                    mBinding.mainSecond.setChecked(true);
                    break;
                case 2:
                    mBinding.mainThird.setChecked(true);
                    break;
                case 3:
                    mBinding.mainFourth.setChecked(true);
                    break;

            }
        }else{

        }
    }




    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        if (keyCode == KeyEvent.KEYCODE_BACK) {
            if (System.currentTimeMillis() - CURRENT < 3000) {
                finish();
            } else{
                CURRENT = System.currentTimeMillis();
                Toast.makeText(this, "再按一次返回键退出", Toast.LENGTH_SHORT).show();
            }
            return false;
        }
        return super.onKeyDown(keyCode, event);
    }

    @Override
    public void onFragmentInteraction(Uri uri) {

    }

    @Subscribe(threadMode = ThreadMode.POSTING)
    public void getMessage(String message){
        Log.d(TAG,message);
    }


    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.main_index:
                mBinding.viewPager.setCurrentItem(0);
                mBinding.mainIndex.setTextColor(getResources().getColor(R.color.theme_text_color));
                mBinding.mainSecond.setTextColor(getResources().getColor(R.color.text_color_white));
                mBinding.mainThird.setTextColor(getResources().getColor(R.color.text_color_white));
                mBinding.mainFourth.setTextColor(getResources().getColor(R.color.text_color_white));
                break;
            case R.id.main_second:
                mBinding.viewPager.setCurrentItem(1);
                mBinding.mainIndex.setTextColor(getResources().getColor(R.color.text_color_white));
                mBinding.mainSecond.setTextColor(getResources().getColor(R.color.theme_text_color));
                mBinding.mainThird.setTextColor(getResources().getColor(R.color.text_color_white));
                mBinding.mainFourth.setTextColor(getResources().getColor(R.color.text_color_white));
                break;
            case R.id.main_third:
                mBinding.viewPager.setCurrentItem(2);
                mBinding.mainIndex.setTextColor(getResources().getColor(R.color.text_color_white));
                mBinding.mainSecond.setTextColor(getResources().getColor(R.color.text_color_white));
                mBinding.mainThird.setTextColor(getResources().getColor(R.color.theme_text_color));
                mBinding.mainFourth.setTextColor(getResources().getColor(R.color.text_color_white));
                break;
            case R.id.main_fourth:
                mBinding.viewPager.setCurrentItem(3);
                mBinding.mainIndex.setTextColor(getResources().getColor(R.color.text_color_white));
                mBinding.mainSecond.setTextColor(getResources().getColor(R.color.text_color_white));
                mBinding.mainThird.setTextColor(getResources().getColor(R.color.text_color_white));
                mBinding.mainFourth.setTextColor(getResources().getColor(R.color.theme_text_color));
                break;
            case R.id.rl_click:
                PopupMenuUtil.getInstance()._show(context, mBinding.ivImg);
                break;
        }

    }
}
