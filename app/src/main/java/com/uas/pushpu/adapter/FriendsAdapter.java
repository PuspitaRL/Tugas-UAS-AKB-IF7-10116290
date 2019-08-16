package com.uas.pushpu.adapter;

import android.content.Context;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.uas.pushpu.R;
import com.uas.pushpu.activity.FriendsDetailActivity;
import com.uas.pushpu.data.model.Friends;

import java.util.ArrayList;
import java.util.Random;



public class FriendsAdapter extends RecyclerView.Adapter<FriendsAdapter.ViewHolder>  {

    private ArrayList<Friends> friends;
    private Context context;

    public FriendsAdapter(ArrayList<Friends> friends, Context context) {
        this.friends = friends;
        this.context = context;
    }

    public void setData(ArrayList<Friends> items) {
        this.friends = items;
        notifyDataSetChanged();
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.item_friends, viewGroup, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder viewHolder, final int i) {
        int[] ava = {R.drawable.ava1};
        Random ran = new Random();
        int j = ran.nextInt(ava.length);

        viewHolder.imgAva.setImageResource(ava[j]);
        viewHolder.tvName.setText(friends.get(i).getName());
        viewHolder.tvNIM.setText(friends.get(i).getNim());

        final Friends item = friends.get(i);
        final int pos = i;
        viewHolder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(v.getContext(), FriendsDetailActivity.class);
                i.putExtra("friend", item);
                i.putExtra("position", pos);
                context.startActivity(i);
            }
        });
    }

    @Override
    public int getItemCount() {
        return friends.size();
    }

    class ViewHolder extends RecyclerView.ViewHolder {
        ImageView imgAva;
        TextView tvName, tvNIM;

        ViewHolder(View itemView) {
            super(itemView);
            imgAva = itemView.findViewById(R.id.imgAva);
            tvName = itemView.findViewById(R.id.tvName);
            tvNIM = itemView.findViewById(R.id.tvNim);
        }
    }

}
