package com.mine.mishi.mishi.activity;

import android.net.Uri;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.mine.mishi.mishi.R;
import com.mine.mishi.mishi.adapter.TablayoutViewpagerAdapter;
import com.mine.mishi.mishi.base.BaseActivity;
import com.mine.mishi.mishi.base.Contants;
import com.mine.mishi.mishi.fragment.IndexSubFragment;
import com.mine.mishi.mishi.fragment.OrderFragment;
import com.mine.mishi.mishi.fragment.SecondSubFragment;
import com.mine.mishi.mishi.view.TitleBar;

import org.greenrobot.eventbus.Subscribe;
import org.greenrobot.eventbus.ThreadMode;

import java.util.ArrayList;
import java.util.List;

public class OrderActivity extends BaseActivity implements OrderFragment.OnFragmentInteractionListener {

    private List<Fragment> fragments=new ArrayList<>();
    private TabLayout tabLayout;
    private ViewPager viewPager;
    private TitleBar titleBar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_order);
        initView();
    }

    private void initView() {
        titleBar = (TitleBar)findViewById(R.id.title);
        tabLayout = (TabLayout) findViewById(R.id.tab_layout);
        viewPager = (ViewPager) findViewById(R.id.view_pager);
        titleBar.setTitleBarListener(new TitleBar.TitleBarListener() {
            @Override
            public void onLeftTextClick() {
            }

            @Override
            public void onRightTextClick() {

            }

            @Override
            public boolean onClickBack() {
                finish();
                return true;
            }

            @Override
            public boolean onRightImageClick() {

                return false;
            }
        });

        initViewPager();
        initTablayout();
    }

    private void initTablayout() {
        //TabGravity:放置Tab的Gravity,有GRAVITY_CENTER 和 GRAVITY_FILL两种效果。
        //顾名思义，一个是居中，另一个是尽可能的填充（注意，GRAVITY_FILL需要和MODE_FIXED一起使用才有效果）
        //MODE_FIXED:固定tabs，并同时显示所有的tabs。
        //MODE_SCROLLABLE：可滚动tabs，显示一部分tabs，在这个模式下能包含长标签和大量的tabs，最好用于用户不需要直接比较tabs。
        //设置TabLayout标签的显示方式
        tabLayout.setTabMode(TabLayout.MODE_FIXED);
        //MODE_SCROLLABLE模式
        //tabLayout.setTabMode(TabLayout.MODE_SCROLLABLE);

        //循环注入标签
        for (String tab: Contants.orderTitleList){
            tabLayout.addTab(tabLayout.newTab().setText(tab));
        }


        //设置TabLayout点击事件
        tabLayout.setOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                viewPager.setCurrentItem(tab.getPosition());
            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {

            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {

            }
        });

        tabLayout.setupWithViewPager(viewPager);

    }

    private void initViewPager() {
        viewPager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {
                selectPage(position,positionOffset,positionOffsetPixels);
                //viewPager.setCurrentItem(position);
            }

            @Override
            public void onPageSelected(int position) {
                selectPage(position,0,0);
            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });
        fragments.clear();
        for (int i = 0; i < Contants.orderTitleList.size(); i++) {
            OrderFragment orderFragment = new OrderFragment();
            Bundle bundle = new Bundle();
            bundle.putInt("position",i);
            orderFragment.setArguments(bundle);
            fragments.add(orderFragment);
        }
        viewPager.setOffscreenPageLimit(3);
        TablayoutViewpagerAdapter viewPagerAdapter = new TablayoutViewpagerAdapter(getSupportFragmentManager(),Contants.orderTitleList,fragments);
        viewPager.setAdapter(viewPagerAdapter);

    }

    private void selectPage(int position, float positionOffset, int positionOffsetPixels) {
        if (positionOffset == 0 && positionOffsetPixels == 0) {
            tabLayout.setScrollPosition(position,positionOffset,true);
        }else{

        }
    }

    @Subscribe(threadMode = ThreadMode.POSTING)
    public void getMessage(String message){

    }


    @Override
    public void onFragmentInteraction(Uri uri) {

    }
}
