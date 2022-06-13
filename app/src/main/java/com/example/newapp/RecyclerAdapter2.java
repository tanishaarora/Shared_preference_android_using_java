package com.example.newapp;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.nfc.Tag;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;
import java.util.jar.Attributes;

public class RecyclerAdapter2 extends RecyclerView.Adapter<RecyclerAdapter2.ViewHolder2> {
    public ArrayList<ListModel> details;
    public int listItem;
    public RecyclerViewClickInterface recyclerViewClickInterface;

    public RecyclerAdapter2(int layoutId, ArrayList<ListModel> values, RecyclerViewClickInterface recyclerViewClick) {
        listItem = layoutId;
        this.details = values;
        this.recyclerViewClickInterface = recyclerViewClick;
    }

    @Override
    public int getItemCount() {
        return details == null ? 0 : details.size();
    }


    @Override
    public RecyclerAdapter2.ViewHolder2 onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {

        View view = LayoutInflater.from(viewGroup.getContext()).inflate(listItem, viewGroup, false);
        ViewHolder2 viewHolder = new ViewHolder2(view);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerAdapter2.ViewHolder2 viewHolder, @SuppressLint("RecyclerView") int i) {
        ListModel element = details.get(i);
        viewHolder.tv_name.setText(element.getName());
        viewHolder.tv_age.setText("Age:  " + element.getAge());
        viewHolder.tv_city.setText("City:  " + element.getCity());
        viewHolder.tv_dob.setText("Dob:  " + element.getDob());

        viewHolder.iv_delete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ListModel detail = details.get(i);
                details.remove(i);
                /*notifyItemRemoved(i);
                notifyItemRangeChanged(i,details.size());*/
                notifyDataSetChanged();
            }
        });

        viewHolder.ll_top.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                recyclerViewClickInterface.onItemClick(viewHolder.getAdapterPosition());

//                Log.d("onclick", "onClick " + getItemId(i) + " " + viewHolder.tv_name.getText());
            }
        });
    }
    static class ViewHolder2 extends RecyclerView.ViewHolder {
        public TextView tv_name, tv_city, tv_age, tv_dob;
        ImageView iv_delete;
        LinearLayout ll_top;

        public ViewHolder2(View itemView) {
            super(itemView);
            tv_name = (TextView) itemView.findViewById(R.id.named);
            tv_city = (TextView) itemView.findViewById(R.id.city);
            tv_age = (TextView) itemView.findViewById(R.id.age);
            tv_dob = (TextView) itemView.findViewById(R.id.dob);
            iv_delete =  itemView.findViewById(R.id.delete);
            ll_top = (LinearLayout) itemView.findViewById(R.id.ll_top);
        }
    }
}