package com.hmj.demo.designmeterialdemo;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

import com.hmj.demo.designmeterialdemo.scrollmenu.NavigationActivity;
import com.hmj.demo.designmeterialdemo.tablayout.TabLayoutActivity;
import com.hmj.demo.designmeterialdemo.toolbar.ToolBarActivity;
import com.hmj.demo.designmeterialdemo.utils.ActivityUtils;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class MainActivity extends AppCompatActivity {

    @BindView(R.id.toolbar)
    Button toolbar;
    @BindView(R.id.scrollmenu)
    Button scrollmenu;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
    }


    @OnClick({R.id.toolbar, R.id.scrollmenu, R.id.tablayout})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.toolbar:
                ActivityUtils.startEmptyActivity(this, ToolBarActivity.class);
                break;
            case R.id.scrollmenu:
                ActivityUtils.startEmptyActivity(this, NavigationActivity.class);
                break;
            case R.id.tablayout:
                ActivityUtils.startEmptyActivity(this, TabLayoutActivity.class);
                break;
        }
    }
}
