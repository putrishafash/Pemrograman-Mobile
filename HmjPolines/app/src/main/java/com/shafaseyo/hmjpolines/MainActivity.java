package com.shafaseyo.hmjpolines;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import java.util.ArrayList;
import java.util.TreeMap;

public class MainActivity extends AppCompatActivity {

    private RecyclerView rvhmj;
    private ArrayList<Hmj> list = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        if (getSupportActionBar() !=null) {
            getSupportActionBar().setTitle("HMJ POLINES");
        }

        rvhmj = findViewById(R.id.rv_hmj);
        rvhmj.setHasFixedSize(true);

        list.addAll(HmjData.getListData());
        showRecycleList();
    }

    private void showRecycleList() {
        rvhmj.setLayoutManager(new LinearLayoutManager(this));
        CardHmjAdapter cardHmjAdapter = new CardHmjAdapter(this, list);
        rvhmj.setAdapter(cardHmjAdapter);
    }
}
