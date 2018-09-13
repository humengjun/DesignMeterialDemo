package com.hmj.demo.designmeterialdemo.tablayout;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.text.method.ScrollingMovementMethod;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.hmj.demo.designmeterialdemo.R;
import com.hmj.demo.designmeterialdemo.scrollmenu.Fruit;

import java.util.List;
import java.util.Random;

public class RecyclerViewAdapter extends RecyclerView.Adapter<RecyclerViewAdapter.ViewHolder> {
    private List<Fruit> fruitList;
    private Context context;

    public RecyclerViewAdapter(List<Fruit> fruitList, Context context) {
        this.fruitList = fruitList;
        this.context = context;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.recyclerview_item, parent, false);
        ViewHolder holder = new ViewHolder(view);
        return holder;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        Fruit fruit = fruitList.get(position);
        Glide.with(context).load(fruit.getImage()).into(holder.fruit_image);
        holder.fruit_name.setText(getRandomSize(fruit.getName()));
        holder.fruit_name.setMovementMethod(ScrollingMovementMethod.getInstance());
        holder.fruit_name.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                if(event.getAction() == MotionEvent.ACTION_DOWN){
                    v.getParent().requestDisallowInterceptTouchEvent(true);
                }
                if(event.getAction() == MotionEvent.ACTION_MOVE){
                    v.getParent().requestDisallowInterceptTouchEvent(true);
                }
                if(event.getAction() == MotionEvent.ACTION_UP){
                    v.getParent().requestDisallowInterceptTouchEvent(false);
                }
                return false;
            }
        });
    }

    private String getRandomSize(String name) {
        StringBuilder builder = new StringBuilder();
        Random random = new Random();
        int size = random.nextInt(50);
        for (int i = 0; i < size; i++) {
            builder.append(name +":"+ i);
        }
        return builder.toString();
    }

    @Override
    public int getItemCount() {
        return fruitList.size();
    }

    class ViewHolder extends RecyclerView.ViewHolder {
        ImageView fruit_image;
        TextView fruit_name;

        public ViewHolder(View itemView) {
            super(itemView);
            fruit_image = itemView.findViewById(R.id.image);
            fruit_name = itemView.findViewById(R.id.text);
        }
    }
}
