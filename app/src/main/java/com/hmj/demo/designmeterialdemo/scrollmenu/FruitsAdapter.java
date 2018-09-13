package com.hmj.demo.designmeterialdemo.scrollmenu;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.bumptech.glide.Glide;
import com.hmj.demo.designmeterialdemo.R;
import com.hmj.demo.designmeterialdemo.foldingtoolbar.FoldingActivity;
import com.hmj.demo.designmeterialdemo.utils.ActivityUtils;

import java.util.List;

public class FruitsAdapter extends RecyclerView.Adapter<FruitsViewHolder> {
    private List<Fruit> fruitList;
    private Context context;

    public FruitsAdapter(List<Fruit> fruitList, Context context) {
        this.fruitList = fruitList;
        this.context = context;
    }

    @NonNull
    @Override
    public FruitsViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.fruits_item, parent, false);
        final FruitsViewHolder holder = new FruitsViewHolder(view);
        view.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Bundle bundle = new Bundle();
                bundle.putString(FoldingActivity.FRUIT_NAME, fruitList.get(holder.getAdapterPosition()).getName());
                bundle.putInt(FoldingActivity.FRUIT_IMAGE, fruitList.get(holder.getAdapterPosition()).getImage());
                ActivityUtils.startParamsActivity(context, FoldingActivity.class, bundle);
            }
        });
        return holder;
    }

    @Override
    public void onBindViewHolder(@NonNull FruitsViewHolder holder, int position) {
        holder.fruit_name.setText(fruitList.get(position).getName());
        Glide.with(context).load(fruitList.get(position).getImage()).into(holder.fruit_img);

    }

    @Override
    public int getItemCount() {
        return fruitList.size();
    }
}
