package com.mine.mishi.mishi.fragment;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.support.design.widget.TabLayout;

import com.mine.mishi.mishi.R;
import com.mine.mishi.mishi.activity.CityChoiceActivity;
import com.mine.mishi.mishi.activity.SearchActivity;
import com.mine.mishi.mishi.adapter.TablayoutViewpagerAdapter;
import com.mine.mishi.mishi.adapter.ViewPagerIndexAdapter;
import com.mine.mishi.mishi.base.BaseFragment;
import com.mine.mishi.mishi.base.Contants;
import com.mine.mishi.mishi.view.ChildViewPager;
import com.mine.mishi.mishi.view.TitleBar;

import org.greenrobot.eventbus.Subscribe;
import org.greenrobot.eventbus.ThreadMode;

import java.util.ArrayList;
import java.util.List;

/**
 * A simple {@link Fragment} subclass.
 * Activities that contain this fragment must implement the
 * {@link IndexFragment.OnFragmentInteractionListener} interface
 * to handle interaction events.
 * Use the {@link IndexFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class IndexFragment extends BaseFragment {
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    private OnFragmentInteractionListener mListener;

    private List<Fragment> fragments=new ArrayList<>();

    private TabLayout tabLayout;
    private ViewPager viewPager;
    private TitleBar titleBar;

    public IndexFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment IndexFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static IndexFragment newInstance(String param1, String param2) {
        IndexFragment fragment = new IndexFragment();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_index, container, false);
        initView(view);
        return view;
    }

    private void initView(View view) {
        tabLayout = (TabLayout) view.findViewById(R.id.tab_layout);
        viewPager = (ViewPager) view.findViewById(R.id.view_pager);
        titleBar = view.findViewById(R.id.title);
        titleBar.setTitleBarListener(new TitleBar.TitleBarListener() {
            @Override
            public void onLeftTextClick() {
                goToChoiceCity();
            }

            @Override
            public void onRightTextClick() {

            }

            @Override
            public boolean onClickBack() {
                goToChoiceCity();
                return true;
            }

            @Override
            public boolean onRightImageClick() {
                goToSearch();
                return false;
            }
        });
        initViewPager();
        initTablayout();
    }

    private void goToSearch() {
        gotoActivity(mContext, SearchActivity.class, null);
    }

    private void goToChoiceCity() {
        gotoActivity(mContext, CityChoiceActivity.class, null);
    }

    private void initTablayout() {
        //TabGravity:放置Tab的Gravity,有GRAVITY_CENTER 和 GRAVITY_FILL两种效果。
        //顾名思义，一个是居中，另一个是尽可能的填充（注意，GRAVITY_FILL需要和MODE_FIXED一起使用才有效果）
        //MODE_FIXED:固定tabs，并同时显示所有的tabs。
        //MODE_SCROLLABLE：可滚动tabs，显示一部分tabs，在这个模式下能包含长标签和大量的tabs，最好用于用户不需要直接比较tabs。
        //设置TabLayout标签的显示方式
        //tabLayout.setTabMode(TabLayout.MODE_FIXED);
        //MODE_SCROLLABLE模式
        tabLayout.setTabMode(TabLayout.MODE_SCROLLABLE);

        //循环注入标签
       for (String tab:Contants.tablayoutTitleList){
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
        for (String s : Contants.tablayoutTitleList) {
            fragments.add(new IndexSubFragment());
        }
        TablayoutViewpagerAdapter viewPagerAdapter = new TablayoutViewpagerAdapter(getChildFragmentManager(),Contants.tablayoutTitleList,fragments);
        viewPager.setAdapter(viewPagerAdapter);

    }

    private void selectPage(int position, float positionOffset, int positionOffsetPixels) {
        if (positionOffset == 0 && positionOffsetPixels == 0) {
            tabLayout.setScrollPosition(position,positionOffset,true);
        }else{

        }
    }

    // TODO: Rename method, update argument and hook method into UI event
    public void onButtonPressed(Uri uri) {
        if (mListener != null) {
            mListener.onFragmentInteraction(uri);
        }
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        if (context instanceof OnFragmentInteractionListener) {
            mListener = (OnFragmentInteractionListener) context;
        } else {
            throw new RuntimeException(context.toString()
                    + " must implement OnFragmentInteractionListener");
        }
    }

    @Override
    public void onDetach() {
        super.onDetach();
        mListener = null;
    }



    /**
     * This interface must be implemented by activities that contain this
     * fragment to allow an interaction in this fragment to be communicated
     * to the activity and potentially other fragments contained in that
     * activity.
     * <p>
     * See the Android Training lesson <a href=
     * "http://developer.android.com/training/basics/fragments/communicating.html"
     * >Communicating with Other Fragments</a> for more information.
     */
    public interface OnFragmentInteractionListener {
        // TODO: Update argument type and name
        void onFragmentInteraction(Uri uri);
    }


    @Subscribe(threadMode = ThreadMode.POSTING)
    public void getMessage(String message){

    }


}
