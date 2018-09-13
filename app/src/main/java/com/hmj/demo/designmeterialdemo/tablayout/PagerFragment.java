package com.hmj.demo.designmeterialdemo.tablayout;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.hmj.demo.designmeterialdemo.R;
import com.hmj.demo.designmeterialdemo.scrollmenu.Fruit;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;

public class PagerFragment extends Fragment {

    View view;
    @BindView(R.id.recyclerView)
    RecyclerView recyclerView;
    Unbinder unbinder;

    List<Fruit> mFruitList;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.pager_frament, null);
        unbinder = ButterKnife.bind(this, view);
        addData();
        initRecyclerView();
        return view;
    }

    private void addData() {
        mFruitList = new ArrayList<>();
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

    private void initRecyclerView() {
        RecyclerViewAdapter adapter = new RecyclerViewAdapter(mFruitList, getActivity());
        recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
        recyclerView.setAdapter(adapter);
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        unbinder.unbind();
    }
}
