package com.shafaseyo.utsblackpink;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;

import java.util.ArrayList;

public class CardBPAdapter extends RecyclerView.Adapter<CardBPAdapter.ListViewHolder>{

    private ArrayList<BlackPink> listBlackPink;
    private Context context;

    public CardBPAdapter(Context context, ArrayList<BlackPink> listBlackPink){
        this.listBlackPink = listBlackPink;
        this.context = context;
    }

    @NonNull
    @Override
    public ListViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_card_bp, parent, false);
        return new ListViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ListViewHolder holder, int position) {
        final BlackPink blackPink = listBlackPink.get(position);
        Glide.with(holder.itemView.getContext())
                .load(blackPink.getPhoto())
                .apply(new RequestOptions().fitCenter())
                .into(holder.imgPhoto);
        holder.tvName.setText(blackPink.getName());
        holder.tvDesc.setText(blackPink.getDescription());

        holder.cv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent detailBP = new Intent(context, DetailBlackPink.class);
                detailBP.putExtra("bp_id", blackPink.getId());
                context.startActivity(detailBP);
            }
        });
    }

    @Override
    public int getItemCount() {
        return listBlackPink.size();
    }

    public class ListViewHolder extends RecyclerView.ViewHolder {
        ImageView imgPhoto;
        TextView tvName, tvDesc;
        CardView cv;

        public ListViewHolder(@NonNull View itemView) {
            super(itemView);
            imgPhoto = itemView.findViewById(R.id.img_bp_list);
            tvName = itemView.findViewById(R.id.name_bp_list);
            tvDesc = itemView.findViewById(R.id.desc_bp_list);
            cv = itemView.findViewById(R.id.cardview_item);
        }
    }
}
