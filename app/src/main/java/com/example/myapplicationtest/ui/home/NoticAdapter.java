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

public class NoticAdapter extends RecyclerView.Adapter<NoticAdapter.MyNoticViewHolder>{
    private Context context;
    private List<NewNotic> newNoticList;

    NoticAdapter(Context context, List<NewNotic> newNoticList){
        this.context = context;
        this.newNoticList = newNoticList;
    }


    @NonNull
    @NotNull
    @Override
    public NoticAdapter.MyNoticViewHolder onCreateViewHolder(@NonNull @NotNull ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(context);
        View new_notice_item_view = layoutInflater.inflate(R.layout.new_notice_item_view,parent,false);

        return new MyNoticViewHolder(new_notice_item_view);
    }

    @Override
    public void onBindViewHolder(@NonNull @NotNull NoticAdapter.MyNoticViewHolder holder, int position) {
        NewNotic newNotic = newNoticList.get(position);
        holder.PhotoIv.setImageResource(newNotic.getPhotoImage());
        holder.EmpidTv.setText(newNotic.getName());
        holder.NoteTv.setText(newNotic.getNote());
        holder.TimeTv.setText(newNotic.getTime());
        holder.N_WeekTv.setText(newNotic.getWeek());
        holder.N_DateTv.setText(newNotic.getDD());
    }

    @Override
    public int getItemCount() {
        return newNoticList.size();
    }

    class MyNoticViewHolder extends RecyclerView.ViewHolder{
        ImageView PhotoIv = null;
        TextView EmpidTv = null;
        TextView NoteTv = null;
        TextView TimeTv = null;
        TextView N_WeekTv = null;
        TextView N_DateTv = null;
        public MyNoticViewHolder(@NonNull @NotNull View new_notice_item_view) {
            super(new_notice_item_view);
            PhotoIv = new_notice_item_view.findViewById(R.id.photoIv);
            EmpidTv = new_notice_item_view.findViewById(R.id.empidTv);
            NoteTv = new_notice_item_view.findViewById(R.id.noteTv);
            TimeTv = new_notice_item_view.findViewById(R.id.timeTv);
            N_WeekTv = new_notice_item_view.findViewById(R.id.nWeekTv);
            N_DateTv = new_notice_item_view.findViewById(R.id.nDateTv);
        }
    }
}
