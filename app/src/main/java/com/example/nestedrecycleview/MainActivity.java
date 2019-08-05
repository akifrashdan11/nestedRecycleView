package com.example.nestedrecycleview;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import com.example.nestedrecycleview.Adapters.Models.HorizontalModel;
import com.example.nestedrecycleview.Adapters.Models.VerticalModel;
import com.example.nestedrecycleview.Adapters.VerticalRecycleViewAdapter;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    RecyclerView verticalRecyclerView;
    VerticalRecycleViewAdapter adapter;
    ArrayList<VerticalModel> arrayListVertical;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        arrayListVertical = new ArrayList<>();

        verticalRecyclerView=(RecyclerView) findViewById(R.id.recyclerview);
        verticalRecyclerView.setHasFixedSize(true);

        verticalRecyclerView.setLayoutManager(new LinearLayoutManager(this,LinearLayoutManager.HORIZONTAL,true));

        adapter = new VerticalRecycleViewAdapter(this,arrayListVertical);


        setData();

    }

    private void setData(){

        for (int i=1;i<5;i++){

            VerticalModel mverticalModel = new VerticalModel();
            mverticalModel.setTitle("Title "+i);
            ArrayList<HorizontalModel> arrayList = new ArrayList<>();

            for (int j=0;j<5;j++){

                HorizontalModel mhorizontalModel = new HorizontalModel();
                mhorizontalModel.setDescription("Description "+ j);
                mhorizontalModel.setName("Name "+j);

                arrayList.add(mhorizontalModel);
            }

            mverticalModel.setArrayList(arrayList);
            arrayListVertical.add(mverticalModel);


        }
        adapter.notifyDataSetChanged();

    }
}
