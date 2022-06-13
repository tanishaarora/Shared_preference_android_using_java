package com.example.newapp;


import android.content.ClipData;
import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

import javax.xml.namespace.QName;

public class RecyclerAdapter extends RecyclerView.Adapter<RecyclerAdapter.ViewHolder> {
    public ArrayList<String> values;
    public int listItemLayout;

    public RecyclerAdapter (int layoutId, ArrayList<String> values) {
        listItemLayout = layoutId;
        this.values = values;
    }
    @Override
    public int getItemCount() {
        return values == null ? 0 : values.size();
    }

    @Override
    public RecyclerAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View view = LayoutInflater.from(parent.getContext()).inflate (listItemLayout, parent, false);
        ViewHolder viewHolder = new ViewHolder(view);
        return viewHolder;
    }
    public void onBindViewHolder(@NonNull RecyclerAdapter.ViewHolder viewHolder, int position) {
        TextView item = viewHolder.item;
        item.setText(values.get(position));

    }

    static class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        public TextView item;
        public ViewHolder(View itemView) {
            super(itemView);
            itemView.setOnClickListener(this);
            item = (TextView) itemView.findViewById(R.id.names);
        }

        @Override
        public void onClick(View view) {
            Log.d("onclick", "onClick " + getLayoutPosition() + " " + item.getText());
        }}}