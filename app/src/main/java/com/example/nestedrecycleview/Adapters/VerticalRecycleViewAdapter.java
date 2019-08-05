package com.example.nestedrecycleview.Adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.nestedrecycleview.Adapters.Models.HorizontalModel;
import com.example.nestedrecycleview.Adapters.Models.VerticalModel;
import com.example.nestedrecycleview.R;

import java.util.ArrayList;

public class VerticalRecycleViewAdapter extends RecyclerView.Adapter<VerticalRecycleViewAdapter.VerticalRVViewHolder> {

    Context context;
    ArrayList<VerticalModel> arrayList;

    public VerticalRecycleViewAdapter(Context context,ArrayList<VerticalModel> arrayList){

        this.arrayList=arrayList;
        this.context=context;

    }


    @NonNull
    @Override
    public VerticalRVViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_vertical,parent,false);
        return new VerticalRVViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull VerticalRVViewHolder holder, int position) {

        VerticalModel verticalModel = arrayList.get(position);
        String title = verticalModel.getTitle();
        ArrayList<HorizontalModel> singleItem = verticalModel.getArrayList();

        holder.textViewTitle.setText(title);
        HorizontalRecyclerViewAdapter horizontalRecyclerViewAdapter = new HorizontalRecyclerViewAdapter(context,singleItem);

        holder.recyclerView.setHasFixedSize(true);
        holder.recyclerView.setLayoutManager(new LinearLayoutManager(context,LinearLayoutManager.HORIZONTAL,false));

        holder.recyclerView.setAdapter(horizontalRecyclerViewAdapter);

    }

    @Override
    public int getItemCount() {
        return arrayList.size();
    }

    public class VerticalRVViewHolder extends RecyclerView.ViewHolder{

        RecyclerView recyclerView;
        TextView textViewTitle;
        Button btnMore;


        public VerticalRVViewHolder(@NonNull View itemView) {
            super(itemView);
            recyclerView =(RecyclerView)itemView.findViewById(R.id.recyclerview1);
            textViewTitle = (TextView)itemView.findViewById(R.id.txtTitle1);
            btnMore=(Button)itemView.findViewById(R.id.btn);

        }
    }

}
