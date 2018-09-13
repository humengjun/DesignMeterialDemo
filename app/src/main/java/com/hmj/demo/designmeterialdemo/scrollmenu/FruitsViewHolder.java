package com.hmj.demo.designmeterialdemo.scrollmenu;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.hmj.demo.designmeterialdemo.R;

public class FruitsViewHolder extends RecyclerView.ViewHolder {
    TextView fruit_name;
    ImageView fruit_img;

    public FruitsViewHolder(View itemView) {
        super(itemView);
        fruit_img = itemView.findViewById(R.id.fruit_img);
        fruit_name = itemView.findViewById(R.id.fruit_name);
    }
}
