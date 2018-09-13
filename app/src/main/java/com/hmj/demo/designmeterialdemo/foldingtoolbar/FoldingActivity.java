package com.hmj.demo.designmeterialdemo.foldingtoolbar;

import android.os.Bundle;
import android.support.design.widget.AppBarLayout;
import android.support.design.widget.CollapsingToolbarLayout;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.hmj.demo.designmeterialdemo.R;
import com.hmj.demo.designmeterialdemo.utils.ActivityUtils;

import java.util.Random;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class FoldingActivity extends AppCompatActivity {

    public static final String FRUIT_NAME = "fruit_name";
    public static final String FRUIT_IMAGE = "fruit_image";

    @BindView(R.id.fruit_img)
    ImageView fruitImg;
    @BindView(R.id.toolbar)
    Toolbar toolbar;
    @BindView(R.id.collapsing_toolbar)
    CollapsingToolbarLayout collapsingToolbar;
    @BindView(R.id.appBar)
    AppBarLayout appBar;
    @BindView(R.id.tv_fruit)
    TextView tvFruit;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ActivityUtils.addActivity(this);
        setContentView(R.layout.activity_floding);
        ButterKnife.bind(this);
        int fruitImage = getIntent().getIntExtra(FRUIT_IMAGE, 0);
        String fruitName = getIntent().getStringExtra(FRUIT_NAME);

        Glide.with(this).load(fruitImage).into(fruitImg);
        tvFruit.setText(RandomSize(fruitName));

        setSupportActionBar(toolbar);
        ActionBar actionBar = getSupportActionBar();
        if (actionBar != null) {
            actionBar.setDisplayHomeAsUpEnabled(true);
        }
        collapsingToolbar.setTitle(fruitName);

    }

    private String RandomSize(String fruitName) {
        StringBuilder builder = new StringBuilder();
        Random random = new Random();
        int size=random.nextInt(100);
        for (int i = 0; i < 100; i++) {
            builder.append(fruitName + ":" + i);
        }
        return builder.toString();
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if (item.getItemId() == android.R.id.home) {
            finish();
        }
        return super.onOptionsItemSelected(item);
    }

    @OnClick(R.id.float_btn)
    public void onViewClicked() {
        ActivityUtils.finishAllActivity();
    }
}
