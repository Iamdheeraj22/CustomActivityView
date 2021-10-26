package com.sef.customactivityview;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class CricketerAdapter extends RecyclerView.Adapter<CricketerAdapter.ViewHolder>
{
    ArrayList<Cricketer> arrayList;

    public CricketerAdapter(ArrayList<Cricketer> arrayList) {
        this.arrayList = arrayList;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(parent.getContext()).inflate(R.layout.row_item,null,false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        Cricketer cricketer=arrayList.get(position);
        holder.teamName.setText(cricketer.getTeamName());
        holder.crickterName.setText(cricketer.getCricketerName());
    }

    @Override
    public int getItemCount() {
        return arrayList.size();
    }

    class ViewHolder extends RecyclerView.ViewHolder{
        TextView crickterName,teamName;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            crickterName=itemView.findViewById(R.id.playerName);
            teamName=itemView.findViewById(R.id.teamName);
        }
    }
}
