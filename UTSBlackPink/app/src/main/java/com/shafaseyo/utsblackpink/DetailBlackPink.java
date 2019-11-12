package com.shafaseyo.utsblackpink;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;

import java.util.ArrayList;

public class DetailBlackPink extends AppCompatActivity {

    private int bp_id;
    ImageView imgDetail;
    TextView tvName, tvDesc;

    private ArrayList<BlackPink> listBP = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail_black_pink);

        bp_id = getIntent().getIntExtra("bp_id", 0);
        tvName = findViewById(R.id.name_detail);
        tvDesc = findViewById(R.id.desc_detail);
        imgDetail = findViewById(R.id.img_detail);

        listBP.addAll(BlackPinkData.getListData());
        setLayout();
    }

    void setLayout(){
        this.setTitle(listBP.get(bp_id).getName());
        tvName.setText(listBP.get(bp_id).getName());
        tvDesc.setText(listBP.get(bp_id).getDescription());
        Glide.with(this)
                .load(listBP.get(bp_id).getPhoto())
                .apply(new RequestOptions().fitCenter())
                .into(imgDetail);
    }
}
