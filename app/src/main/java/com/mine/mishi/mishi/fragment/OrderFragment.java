package com.mine.mishi.mishi.fragment;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.StaggeredGridLayoutManager;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.mine.mishi.mishi.HttpRequestLocal.HttpSMyOrder;
import com.mine.mishi.mishi.HttpRequestLocal.HttpSiscoveryH;
import com.mine.mishi.mishi.R;
import com.mine.mishi.mishi.activity.GoodsDetailActivity;
import com.mine.mishi.mishi.adapter.MineMenuAdapter;
import com.mine.mishi.mishi.adapter.OrderAdapter;
import com.mine.mishi.mishi.base.BaseFragment;
import com.mine.mishi.mishi.bean.BaseRequest;
import com.mine.mishi.mishi.bean.SMyOrder;
import com.mine.mishi.mishi.bean.SiscoveryH;
import com.mine.mishi.mishi.entity.MineMenuEntity;
import com.mine.mishi.mishi.url.RetrofitLoader;
import com.mine.mishi.mishi.utils.SharedPreferencesUtil;

import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;
import org.greenrobot.eventbus.ThreadMode;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import okhttp3.RequestBody;
import rx.functions.Action1;

/**
 * A simple {@link Fragment} subclass.
 * Activities that contain this fragment must implement the
 * {@link OrderFragment.OnFragmentInteractionListener} interface
 * to handle interaction events.
 * Use the {@link OrderFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class OrderFragment extends BaseFragment {
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    private OnFragmentInteractionListener mListener;

    List<SMyOrder> data = new ArrayList<>();
    private RecyclerView recyclerView;
    public OrderFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment OrderFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static OrderFragment newInstance(String param1, String param2) {
        OrderFragment fragment = new OrderFragment();
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
        View view =  inflater.inflate(R.layout.fragment_order, container, false);
        initView(view);
        return view;
    }

    private void initView(View view ) {
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
        OrderAdapter adapter = new OrderAdapter(data, this.getContext());
        //设置adapter
        recyclerView.setAdapter(adapter);
        adapter.setOnItemClickListener(new OrderAdapter.OnItemClickListener() {
            @Override
            public boolean onItemClickListener(int position) {
                Log.e("position:",position + "");

                return true;
            }
        });
    }

    private void initData() {
        Bundle arguments = getArguments();
        int position = arguments.getInt("position");
        getData(position);
    }

    private void getData(int position) {
        HttpSMyOrder params = new HttpSMyOrder();
        params.setUserid(SharedPreferencesUtil.getInstance(getActivity()).getString("userid","0"));
        params.setType(position);
        RetrofitLoader mRetrofitLoader = new RetrofitLoader();

        mRetrofitLoader.getSMyOrder(params).subscribe(new Action1<BaseRequest<List<SMyOrder>>>() {
            @Override
            public void call(BaseRequest<List<SMyOrder>> listBaseRequest) {
                if (200 == listBaseRequest.getCode() && listBaseRequest.isIsOk()) {
                    data = listBaseRequest.getData();
                    //adapter.notifyDataSetChanged();
                    EventBus.getDefault().post(data);
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
