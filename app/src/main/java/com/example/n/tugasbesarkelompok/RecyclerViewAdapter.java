package com.example.n.tugasbesarkelompok;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;

import java.util.ArrayList;

import static android.support.constraint.Constraints.TAG;

public class RecyclerViewAdapter extends RecyclerView.Adapter<RecyclerViewAdapter.ViewHolder> {

    private final int count;
    private ArrayList<String> obatNames = new ArrayList<>();
    private ArrayList<String> obatPics = new ArrayList<>();
    private Context mContext;

    public RecyclerViewAdapter(Context mContext, ArrayList<String> obatNames, ArrayList<String> obatPics, int count) {
        this.obatNames = obatNames;
        this.obatPics = obatPics;
        this.mContext = mContext;
        this.count = count;
    }

    @NonNull
    @Override
    public RecyclerViewAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.horizontal_item_list,parent,false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerViewAdapter.ViewHolder holder, final int position) {

        Log.d(TAG, "onBindViewHolder: called : "+ obatNames.get(position));

        Glide.with(mContext)
                .asBitmap()
                .load(obatPics.get(position))
                .into(holder.image);


        holder.name.setText(obatNames.get(position));

        holder.CardViewparent.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(mContext, obatNames.get(position), Toast.LENGTH_SHORT).show();
            }
        });

    }

    @Override
    public int getItemCount() {
        return count;
    }

    public class ViewHolder extends RecyclerView.ViewHolder{

        ImageView image;
        TextView name;
        CardView CardViewparent;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            image = itemView.findViewById(R.id.top_obat_pic);
            name = itemView.findViewById(R.id.top_obat_name);
            CardViewparent = itemView.findViewById(R.id.card_view_parent);

        }
    }


}
