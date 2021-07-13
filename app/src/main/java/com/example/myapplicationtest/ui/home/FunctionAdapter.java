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

import java.util.ArrayList;
import java.util.List;
import java.util.Vector;

public class FunctionAdapter extends RecyclerView.Adapter<FunctionAdapter.MyViewHolder>{
    private Context context;
    private List<Function> FuncList;

    FunctionAdapter(Context context, List<Function> FuncList){
        this.context = context;
        this.FuncList = FuncList;
    }

    @NonNull
    @NotNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull @NotNull ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(context);
        View function_item_view = layoutInflater.inflate(R.layout.function_item_view,parent,false);

        return new MyViewHolder(function_item_view);
    }

    @Override
    public void onBindViewHolder(@NonNull @NotNull MyViewHolder holder, int position) {
        Function func = FuncList.get(position);
        holder.FunctionImIv.setImageResource(func.getImage());
        holder.FunctionNameTv.setText(func.getName());
    }

    @Override
    public int getItemCount() {
        return FuncList.size();
    }


    class MyViewHolder extends RecyclerView.ViewHolder{
        ImageView FunctionImIv = null;
        TextView FunctionNameTv = null;
        public MyViewHolder(@NonNull @NotNull View function_item_view) {
            super(function_item_view);
            FunctionImIv = function_item_view.findViewById(R.id.functionImIv);
            FunctionNameTv = function_item_view.findViewById(R.id.functionNameTv);
        }
    }
}
