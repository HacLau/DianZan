package com.mine.mishi.mishi.activity;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.StaggeredGridLayoutManager;
import android.view.View;
import android.widget.ImageView;

import com.mine.mishi.mishi.R;
import com.mine.mishi.mishi.adapter.CitySearchAdapter;
import com.mine.mishi.mishi.adapter.IndexSubAdapter;
import com.mine.mishi.mishi.base.Contants;
import com.mine.mishi.mishi.bean.CitySearchResultEntty;
import com.mine.mishi.mishi.utils.Utility;

import java.util.ArrayList;
import java.util.List;

public class CityChoiceActivity extends AppCompatActivity {
    private ImageView back;
    private RecyclerView history_city;

    private List<CitySearchResultEntty> historyCity = new ArrayList<>();

    private RecyclerView hot_city;

    private List<CitySearchResultEntty> hotCity = new ArrayList<>();

    private RecyclerView all_city;

    private List<CitySearchResultEntty> allCity = new ArrayList<>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_city_choice);

        initView();

    }

    private void initView() {
        back = findViewById(R.id.back);
        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
        history_city = (RecyclerView)findViewById(R.id.history_city);
        hot_city = (RecyclerView)findViewById(R.id.hot_city);
        all_city = (RecyclerView)findViewById(R.id.all_city);
        initHistoryCity();
        initHotCity();
        initAllCity();

    }
    private void initHistoryCity() {
        StaggeredGridLayoutManager recyclerViewLayoutManager = new StaggeredGridLayoutManager(6, StaggeredGridLayoutManager.VERTICAL);
        //GridLayoutManager recyclerViewLayoutManager = new GridLayoutManager(this, 3);
        history_city.setLayoutManager(recyclerViewLayoutManager);
        history_city.setNestedScrollingEnabled(false);
        historyCity = Contants.cityHistoryList;
        CitySearchAdapter adapter = new CitySearchAdapter(historyCity, this);
        //设置adapter
        history_city.setAdapter(adapter);

    }



    private void initHotCity() {
        StaggeredGridLayoutManager recyclerViewLayoutManager =
                new StaggeredGridLayoutManager(2, StaggeredGridLayoutManager.VERTICAL);
        hot_city.setLayoutManager(recyclerViewLayoutManager);
        hot_city.setNestedScrollingEnabled(false);

        hotCity = Contants.cityImageList;
        CitySearchAdapter adapter = new CitySearchAdapter(hotCity, this);

        hot_city.setAdapter(adapter);
    }

    private void initAllCity() {
        StaggeredGridLayoutManager recyclerViewLayoutManager =
                new StaggeredGridLayoutManager(6, StaggeredGridLayoutManager.VERTICAL);
        all_city.setLayoutManager(recyclerViewLayoutManager);
        allCity = Contants.cityTextList;
        CitySearchAdapter adapter = new CitySearchAdapter(allCity, this);
        all_city.setNestedScrollingEnabled(false);
        all_city.setAdapter(adapter);
    }




}
