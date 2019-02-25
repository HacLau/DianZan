package com.mine.mishi.mishi.activity;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.StaggeredGridLayoutManager;
import android.view.View;
import android.widget.TextView;

import com.mine.mishi.mishi.R;
import com.mine.mishi.mishi.adapter.CitySearchAdapter;
import com.mine.mishi.mishi.adapter.IndexSubAdapter;
import com.mine.mishi.mishi.base.Contants;
import com.mine.mishi.mishi.bean.CitySearchResultEntty;
import com.mine.mishi.mishi.bean.IndexSubEntity;
import com.mine.mishi.mishi.utils.Utility;

import org.w3c.dom.Text;

import java.util.ArrayList;
import java.util.List;

public class SearchActivity extends AppCompatActivity {
    private TextView cancel;

    private List<CitySearchResultEntty> currentKey = new ArrayList<>();
    private RecyclerView current_key;

    private List<CitySearchResultEntty> hotKey = new ArrayList<>();
    private RecyclerView hot_key;

    private List<IndexSubEntity> searchResult = new ArrayList<>();
    private RecyclerView search_result;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_search);

        initView();
    }

    private void initView() {
        cancel = findViewById(R.id.cancel);
        cancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
        current_key = findViewById(R.id.current_key);
        hot_key = findViewById(R.id.hot_key);
        search_result = findViewById(R.id.search_result);
        initCurrentKsy();
        initHotKey();
        initSearchResult();
    }

    private void initCurrentKsy() {
        StaggeredGridLayoutManager recyclerViewLayoutManager = new StaggeredGridLayoutManager(6, StaggeredGridLayoutManager.VERTICAL);
        //GridLayoutManager recyclerViewLayoutManager = new GridLayoutManager(this, 3);
        current_key.setLayoutManager(recyclerViewLayoutManager);
        current_key.setNestedScrollingEnabled(false);
        currentKey = Contants.cityHistoryList;
        CitySearchAdapter adapter = new CitySearchAdapter(currentKey, this);
        //设置adapter
        current_key.setAdapter(adapter);
    }

    private void initHotKey() {
        StaggeredGridLayoutManager recyclerViewLayoutManager = new StaggeredGridLayoutManager(6, StaggeredGridLayoutManager.VERTICAL);
        //GridLayoutManager recyclerViewLayoutManager = new GridLayoutManager(this, 3);
        hot_key.setLayoutManager(recyclerViewLayoutManager);
        hot_key.setNestedScrollingEnabled(false);
        hotKey = Contants.cityHistoryList;
        CitySearchAdapter adapter = new CitySearchAdapter(hotKey, this);
        //设置adapter
        hot_key.setAdapter(adapter);
    }

    private void initSearchResult() {
        StaggeredGridLayoutManager recyclerViewLayoutManager = new StaggeredGridLayoutManager(2, StaggeredGridLayoutManager.VERTICAL);
        //GridLayoutManager recyclerViewLayoutManager = new GridLayoutManager(this, 3);
        search_result.setLayoutManager(recyclerViewLayoutManager);
        search_result.setNestedScrollingEnabled(false);
        searchResult = Contants.indexEntityList;
        IndexSubAdapter adapter = new IndexSubAdapter(searchResult, this);
        //设置adapter
        search_result.setAdapter(adapter);
    }
}
