package com.husenansari.boxoffice.ui;

import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.Color;
import android.graphics.Typeface;
import android.graphics.drawable.GradientDrawable;
import android.os.Build;
import android.support.design.widget.TabLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.husenansari.boxoffice.R;
import com.husenansari.boxoffice.adapter.PopularAdapter;
import com.husenansari.boxoffice.adapter.TopratedAdapter;
import com.husenansari.boxoffice.api.call.GetData;
import com.husenansari.boxoffice.api.model.results;
import com.husenansari.boxoffice.helper.ApiConstants;
import com.husenansari.boxoffice.helper.AppConstant;
import com.husenansari.boxoffice.helper.Function;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    private Toolbar toolbar;
    private TextView txtTitle, txtPopular, txtTop;
    private TabLayout tabLayout;

    private RecyclerView recyclerViewPop, recyclerViewTop;
    private Context context;
    private PopularAdapter popularAdapter;
    private TopratedAdapter topratedAdapter;
    private ArrayList<results> resultsArray;
    private ArrayList<results> resultsArray1;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initToolbar();

        init();
    }

    private void init() {
        context = this;

        tabLayout = (TabLayout) findViewById(R.id.tabs);
        tabLayout.addTab(tabLayout.newTab().setText("Movie"));
        tabLayout.addTab(tabLayout.newTab().setText("Tv Show"));
        tabLayout.setTabGravity(TabLayout.GRAVITY_FILL);
        tabLayout.setTabTextColors(Color.WHITE, Color.WHITE);


        txtPopular = (TextView) findViewById(R.id.txtPopular);
        txtTop = (TextView) findViewById(R.id.txtTop);
        recyclerViewPop = (RecyclerView) findViewById(R.id.recyclePopular);
        recyclerViewPop.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false));
        resultsArray = new ArrayList<>();
        resultsArray1 = new ArrayList<>();
        popularAdapter = new PopularAdapter(context, resultsArray);
        recyclerViewPop.setAdapter(popularAdapter);
        callApi(ApiConstants.POPULAR);

        recyclerViewTop = (RecyclerView) findViewById(R.id.recycleToprated);
        recyclerViewTop.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false));
        topratedAdapter = new TopratedAdapter(context, resultsArray1);
        recyclerViewTop.setAdapter(topratedAdapter);
        callApi(ApiConstants.TOP_RATED);

    }

    private void callApi(final String type) {
        new GetData(type, context, new GetData.OnGetData() {
            @Override
            public void onSuccess(ArrayList<results> results) {
                if (results != null && results.size() > 0){
                    if (type.equals(ApiConstants.POPULAR)){
                        txtPopular.setVisibility(View.VISIBLE);
                        popularAdapter.setMoviePopularlist(results);
                    }else {
                        txtTop.setVisibility(View.VISIBLE);
                        topratedAdapter.setMovieTopratedlist(results);
                    }

                }else {
                    Function.showToast(context,"No Data");
                }
            }

            @Override
            public void onFail() {
                    Function.showToast(context,"Fail");
            }
        });
    }

    private void initToolbar() {
        toolbar = (Toolbar) findViewById(R.id.toolbar);
        txtTitle = (TextView) toolbar.findViewById(R.id.txtTitle);
        toolbar.setTitle("ENTERTAINMENT");
        txtTitle.setText(toolbar.getTitle());
        Typeface typeface = Typeface.createFromAsset(getAssets(), "fonts/Anton-Regular.ttf");
        txtTitle.setTypeface(typeface);
        setSupportActionBar(toolbar);
    }


}
