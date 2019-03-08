package com.mine.mishi.mishi.fragment;

import android.content.Context;
import android.media.Image;
import android.net.Uri;
import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.StaggeredGridLayoutManager;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.mine.mishi.mishi.R;
import com.mine.mishi.mishi.activity.LoginActivity;
import com.mine.mishi.mishi.activity.NotesDetailActivity;
import com.mine.mishi.mishi.activity.OrderActivity;
import com.mine.mishi.mishi.activity.SettingActivity;
import com.mine.mishi.mishi.adapter.IndexSubAdapter;
import com.mine.mishi.mishi.adapter.MineMenuAdapter;
import com.mine.mishi.mishi.adapter.TablayoutViewpagerAdapter;
import com.mine.mishi.mishi.base.BaseFragment;
import com.mine.mishi.mishi.base.Contants;
import com.mine.mishi.mishi.entity.IndexSubEntity;
import com.mine.mishi.mishi.entity.MineMenuEntity;
import com.mine.mishi.mishi.view.TitleBar;

import org.greenrobot.eventbus.Subscribe;
import org.greenrobot.eventbus.ThreadMode;

import java.util.ArrayList;
import java.util.List;

/**
 * A simple {@link Fragment} subclass.
 * Activities that contain this fragment must implement the
 * {@link FourthFragment.OnFragmentInteractionListener} interface
 * to handle interaction events.
 * Use the {@link FourthFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class FourthFragment extends BaseFragment implements View.OnClickListener {
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    private OnFragmentInteractionListener mListener;
    List<MineMenuEntity> data = new ArrayList<>();
    List<IndexSubEntity> indexSubData = new ArrayList<>();
    private RecyclerView recyclerView;
    private TabLayout tabLayout;
    private RecyclerView recycler_view_tab;
    private TitleBar titleBar;
    private ImageView head;
    private IndexSubAdapter indexSubAdapter;
    public FourthFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment FourthFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static FourthFragment newInstance(String param1, String param2) {
        FourthFragment fragment = new FourthFragment();
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

        View view = inflater.inflate(R.layout.fragment_fourth, container, false);

        initView(view);
        return view;
    }

    private void initView( View view) {
        head = view.findViewById(R.id.head);
        head.setOnClickListener(this);
        titleBar = view.findViewById(R.id.title);
        titleBar.setTitleBarListener(new TitleBar.TitleBarListener() {
            @Override
            public void onLeftTextClick() {
            }

            @Override
            public void onRightTextClick() {

            }

            @Override
            public boolean onClickBack() {
                return true;
            }

            @Override
            public boolean onRightImageClick() {
                gotoSetting();
                return false;
            }
        });
        recyclerView = (RecyclerView)view.findViewById(R.id.recycler_view);
        //使用瀑布流布局,第一个参数 spanCount 列数,第二个参数 orentation 排列方向
        StaggeredGridLayoutManager recyclerViewLayoutManager = new StaggeredGridLayoutManager(3, StaggeredGridLayoutManager.VERTICAL);
        //线性布局Manager
//        LinearLayoutManager recyclerViewLayoutManager = new LinearLayoutManager(this);
//        recyclerViewLayoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        //网络布局Manager
//        GridLayoutManager recyclerViewLayoutManager = new GridLayoutManager(this.getContext(), 3);
        //给recyclerView设置LayoutManager
        recyclerView.setLayoutManager(recyclerViewLayoutManager);
        initData();
        MineMenuAdapter adapter = new MineMenuAdapter(data, this.getContext());
        //设置adapter
        recyclerView.setAdapter(adapter);
        adapter.setOnItemClickListener(new MineMenuAdapter.OnItemClickListener() {
            @Override
            public boolean onItemClickListener(int position) {
                Log.e("position:",position + "");
                switch (position){
                    case 1:
                        goToOrder();
                        break;
                }
                return true;
            }
        });

        tabLayout = (TabLayout) view.findViewById(R.id.tab_layout);
        recycler_view_tab = (RecyclerView) view.findViewById(R.id.recycler_view_tab);

        initViewTab();
        initTablayout();
    }

    private void initViewTab() {
        StaggeredGridLayoutManager recyclerViewLayoutManager =
                new StaggeredGridLayoutManager(2, StaggeredGridLayoutManager.VERTICAL){
                    @Override
                    public boolean canScrollVertically() {
                        // 直接禁止垂直滑动
                        return false;
                    }
                };
        recycler_view_tab.setLayoutManager(recyclerViewLayoutManager);
        indexSubData = Contants.indexEntityList;
        indexSubAdapter = new IndexSubAdapter(indexSubData, this.getContext());

        //设置adapter
        recycler_view_tab.setAdapter(indexSubAdapter);
        indexSubAdapter.setOnItemClickListener(new IndexSubAdapter.OnItemClickListener() {
            @Override
            public boolean onItemClickListener(int position) {
                Log.e("position:",position + "");
                gotoActivity(getActivity(), NotesDetailActivity.class,null);
                return false;
            }
        });
    }

    private void goToOrder() {
        gotoActivity(this.getActivity(), OrderActivity.class,null);
    }

    private void gotoSetting() {
        gotoActivity(mContext, SettingActivity.class, null);
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
        for (String tab:Contants.mineTitleList){
            tabLayout.addTab(tabLayout.newTab().setText(tab));
        }

        //设置TabLayout点击事件
        tabLayout.setOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                switch (tab.getPosition()){
                    case 0:
                        indexSubAdapter.setData(Contants.indexEntityList);
                        break;
                    case 1:
                        indexSubAdapter.setData(Contants.indexEntityList1);
                        break;
                }
            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {

            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {

            }
        });



    }



    private void initData() {
        data = Contants.mineEntityList;
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

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.head:
                goToLogin();
                break;
        }
    }

    private void goToLogin() {
        gotoActivity(this.getActivity(), LoginActivity.class,null);
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
        //mModel.refreshData();
    }
}
