package com.example.myapplicationtest.ui.home;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.myapplicationtest.R;

import org.jetbrains.annotations.NotNull;

import java.util.List;

public class DateAdapter extends RecyclerView.Adapter<DateAdapter.MyDateViewHolder>{
    private Context context;
    private List<String> FuncList;

    DateAdapter(Context context, List<String> FuncList){
        this.context = context;
        this.FuncList = FuncList;
    }


    @NonNull
    @NotNull
    @Override
    public DateAdapter.MyDateViewHolder onCreateViewHolder(@NonNull @NotNull ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(context);
        View date_item_view = layoutInflater.inflate(R.layout.date_item_view,parent,false);

        return new DateAdapter.MyDateViewHolder(date_item_view);
    }

    @Override
    public void onBindViewHolder(@NonNull @NotNull DateAdapter.MyDateViewHolder holder, int position) {
        String Date_dd = FuncList.get(position);
        holder.dateIv.setText(Date_dd);
        holder.weekIv.setText("W");
    }

    @Override
    public int getItemCount() {
        return FuncList.size();
    }

    public class MyDateViewHolder extends RecyclerView.ViewHolder {
        TextView dateIv = null;
        TextView weekIv = null;
        public MyDateViewHolder(@NonNull @NotNull View itemView) {
            super(itemView);
            dateIv = itemView.findViewById(R.id.dateIv);
            weekIv = itemView.findViewById(R.id.weekIv);
        }
    }
}
