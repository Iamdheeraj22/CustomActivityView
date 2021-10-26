package com.sef.customactivityview;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import java.util.ArrayList;

public class CricketersActivity extends AppCompatActivity {
    RecyclerView recyclerView;
    CricketerAdapter cricketerAdapter;
    ArrayList<Cricketer> arrayList=new ArrayList<>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cricketers);
        recyclerView=findViewById(R.id.cricketerNames);
//        LinearLayoutManager linearLayoutManager=new LinearLayoutManager(this);
//        recyclerView.setLayoutManager(linearLayoutManager);
        arrayList=(ArrayList<Cricketer>)getIntent().getExtras().getSerializable("list");
//        recyclerView.setAdapter(new CricketerAdapter(arrayList));
//        recyclerView.setHasFixedSize(true);

        CricketerAdapter adapter = new CricketerAdapter(arrayList);
        recyclerView.setHasFixedSize(false);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setAdapter(adapter);
    }
}