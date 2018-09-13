package com.hmj.demo.designmeterialdemo.scrollmenu;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;

import com.hmj.demo.designmeterialdemo.R;
import com.hmj.demo.designmeterialdemo.utils.ActivityUtils;
import com.hmj.demo.designmeterialdemo.utils.SnackbarUtils;
import com.hmj.demo.designmeterialdemo.utils.ToastUtils;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class NavigationActivity extends AppCompatActivity {

    private List<Fruit> mFruitList = new ArrayList<>();
    ExecutorService executorService = Executors.newSingleThreadExecutor();

    @BindView(R.id.swipeRefresh)
    SwipeRefreshLayout swipeRefresh;
    @BindView(R.id.toolbar)
    Toolbar toolbar;
    @BindView(R.id.nav_view)
    NavigationView navView;
    @BindView(R.id.drawerLayout)
    DrawerLayout drawerLayout;
    @BindView(R.id.fa_btn)
    FloatingActionButton faBtn;
    @BindView(R.id.recyclerView)
    RecyclerView recyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ActivityUtils.addActivity(this);
        setContentView(R.layout.activity_navigation);
        ButterKnife.bind(this);
        initToolBar();
        initRecyclerView();
        initSwipeRefreshLayout();

    }

    private void initSwipeRefreshLayout() {
        swipeRefresh.setColorSchemeResources(R.color.colorPrimary, R.color.colorAccent);
        swipeRefresh.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh() {
                refreshFruits();
            }
        });
    }

    private void refreshFruits() {
        executorService.execute(new Runnable() {
            @Override
            public void run() {
                try {
                    Thread.sleep(2000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                addFruit();
                runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        recyclerView.getAdapter().notifyDataSetChanged();
                        swipeRefresh.setRefreshing(false);
                    }
                });

            }
        });
    }

    private void initToolBar() {
        setSupportActionBar(toolbar);
        ActionBar actionBar = getSupportActionBar();
        if (actionBar != null) {
            actionBar.setDisplayHomeAsUpEnabled(true);
            actionBar.setHomeAsUpIndicator(R.mipmap.nav);
        }
        navView.setCheckedItem(R.id.nav_call);
        navView.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                drawerLayout.closeDrawers();
                return true;
            }
        });
    }

    private void initRecyclerView() {
        addFruit();
        recyclerView.setLayoutManager(new GridLayoutManager(this, 2));
        recyclerView.setAdapter(new FruitsAdapter(mFruitList, this));
    }

    private void addFruit() {
        mFruitList.clear();
        for (int i = 0; i < 10; i++) {
            mFruitList.add(new Fruit("Orange1", R.drawable.orang1));
            mFruitList.add(new Fruit("Orange2", R.drawable.orang2));
            mFruitList.add(new Fruit("Apple", R.drawable.apple));
            mFruitList.add(new Fruit("Banana", R.drawable.banana));
            mFruitList.add(new Fruit("Grape", R.drawable.grape));
            mFruitList.add(new Fruit("Mango", R.drawable.mango));
            mFruitList.add(new Fruit("PineApple", R.drawable.pineapple));
        }
        Collections.shuffle(mFruitList);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.toolbar, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case android.R.id.home:
                drawerLayout.openDrawer(GravityCompat.START);
                break;
        }
        return super.onOptionsItemSelected(item);
    }

    @OnClick(R.id.fa_btn)
    public void onViewClicked(View view) {
        SnackbarUtils.shortShow(view, "Data deleted", "Undo",
                new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        ToastUtils.shortToast(NavigationActivity.this,
                                "Data restored");
                    }
                });
    }

    @OnClick(R.id.swipeRefresh)
    public void onViewClicked() {
    }
}
