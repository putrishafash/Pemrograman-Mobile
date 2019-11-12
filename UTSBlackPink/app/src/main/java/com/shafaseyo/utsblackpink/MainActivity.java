package com.shafaseyo.utsblackpink;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;

import android.content.Intent;
import android.view.MenuItem;
import android.widget.TextView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private RecyclerView rvBP;
    private ArrayList<BlackPink> list = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        MediaPlayer music = MediaPlayer.create(MainActivity.this,R.raw.foreveryoung);
        music.start();

        if (getSupportActionBar() !=null) {
            getSupportActionBar().setTitle("BLΛƆKPIИK");
        }

        rvBP = findViewById(R.id.rv_bp);
        rvBP.setHasFixedSize(true);

        list.addAll(BlackPinkData.getListData());
        showRecycleList();
    }

    private void showRecycleList() {
        rvBP.setLayoutManager(new LinearLayoutManager(this));
        CardBPAdapter cardBPAdapter = new CardBPAdapter(this, list);
        rvBP.setAdapter(cardBPAdapter);
    }

    public boolean onCreateOptionsMenu(Menu menu){
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.about_menu,menu);
        return true;
    }
    public boolean onOptionsItemSelected(MenuItem item){
        if (item.getItemId()==R.id.abt){
            startActivity(new Intent(MainActivity.this, About.class));
        }
        return true;
    }
}
