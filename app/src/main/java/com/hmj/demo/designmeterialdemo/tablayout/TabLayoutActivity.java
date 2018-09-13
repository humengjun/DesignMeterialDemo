package com.hmj.demo.designmeterialdemo.tablayout;

import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;

import com.hmj.demo.designmeterialdemo.R;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class TabLayoutActivity extends AppCompatActivity {

    @BindView(R.id.tabLayout)
    TabLayout tabLayout;
    @BindView(R.id.viewPager)
    ViewPager viewPager;
    @BindView(R.id.toolbar)
    Toolbar toolbar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tab_layout);
        ButterKnife.bind(this);
        setSupportActionBar(toolbar);
        initViewPager();
    }

    private void initViewPager() {
        List<String> titleList = new ArrayList<>();
        titleList.add("精选");
        titleList.add("头条");
        titleList.add("订阅");
        titleList.add("视频");
        titleList.add("新时代");
        titleList.add("娱乐");
        titleList.add("体育");
        titleList.add("要闻");
        titleList.add("体育");
        for (int i = 0; i < titleList.size(); i++) {
            tabLayout.addTab(tabLayout.newTab().setText(titleList.get(i)));
        }
        List<Fragment> fragmentList = new ArrayList<>();
        for (int i = 0; i < titleList.size(); i++) {
            fragmentList.add(new PagerFragment());
        }
        FragmentAdapter adapter = new FragmentAdapter(getSupportFragmentManager(),
                fragmentList, titleList);
        //设置viewpager适配器
        viewPager.setAdapter(adapter);
        //绑定tablayout和viewpager
        tabLayout.setupWithViewPager(viewPager);
        //设置tablayout适配器
        tabLayout.setTabsFromPagerAdapter(adapter);

    }
}
