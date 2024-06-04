package com.example.myapplication;


import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class Project4_Adapter extends RecyclerView.Adapter<Project4_Adapter.ViewHolder> {

    private List<Integer> items;  // List of image resource IDs

    public Project4_Adapter(List<Integer> items) {
        this.items = items;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.activity_project4_custom, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        holder.itemImage.setImageResource(items.get(position));
    }

    @Override
    public int getItemCount() {
        return items.size();
    }

    public void removeItem(int position) {
        items.remove(position);
        notifyItemRemoved(position);
    }

    public void moveItem(int fromPosition, int toPosition) {
        int item = items.remove(fromPosition);
        items.add(toPosition > fromPosition ? toPosition - 1 : toPosition, item);
        notifyItemMoved(fromPosition, toPosition);
    }

    class ViewHolder extends RecyclerView.ViewHolder {
        ImageView itemImage;
        ViewHolder(View itemView) {
            super(itemView);
            itemImage = itemView.findViewById(R.id.item_image);
        }
    }
}


