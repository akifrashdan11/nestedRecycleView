package com.example.nestedrecycleview.Adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.nestedrecycleview.Adapters.Models.HorizontalModel;
import com.example.nestedrecycleview.R;

import java.util.ArrayList;

public class HorizontalRecyclerViewAdapter extends RecyclerView.Adapter<HorizontalRecyclerViewAdapter.HorizontalRVViewHolder> {


    Context context;
    ArrayList<HorizontalModel> arrayList;


    public HorizontalRecyclerViewAdapter(Context context,ArrayList<HorizontalModel> arrayList){

        this.context=context;
        this.arrayList=arrayList;

    }

    @NonNull
    @Override
    public HorizontalRVViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_horizontal,parent,false);
        return null;
    }

    @Override
    public void onBindViewHolder(@NonNull HorizontalRVViewHolder holder, int position) {

        HorizontalModel horizontalModel = arrayList.get(position);
        holder.textViewTitle.setText(horizontalModel.getName());

    }

    @Override
    public int getItemCount() {
        return arrayList.size();
    }

    public class HorizontalRVViewHolder extends RecyclerView.ViewHolder{

        TextView textViewTitle;
        ImageView imageViewThumb;


        public HorizontalRVViewHolder(@NonNull View itemView) {
            super(itemView);

            textViewTitle=(TextView)itemView.findViewById(R.id.txtTitleHorizontal);
            imageViewThumb=(ImageView)itemView.findViewById(R.id.ivThumb);

        }
    }
}
