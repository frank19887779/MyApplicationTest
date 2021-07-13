package com.example.myapplicationtest.ui.home;

import android.content.Context;
import android.graphics.Typeface;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.StaggeredGridLayoutManager;

import com.example.myapplicationtest.R;
import com.example.myapplicationtest.databinding.FragmentHomeBinding;

import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;
import java.util.List;
import java.util.Vector;

public class HomeFragment extends Fragment {

    private HomeViewModel homeViewModel;
    private FragmentHomeBinding binding;
    private Context context = null;
    private RecyclerView FunctionBarRv = null;
    private RecyclerView DateRv = null;
    private RecyclerView NoticeDataRv = null;

    @Override
    public void onAttach(@NonNull @NotNull Context context) {
        super.onAttach(context);
        this.context = context;
    }

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        //homeViewModel = new ViewModelProvider(this).get(HomeViewModel.class);

        //binding = FragmentHomeBinding.inflate(inflater, container, false);
        //View root = binding.getRoot();

        /*final TextView textView = binding.textHome;
        homeViewModel.getText().observe(getViewLifecycleOwner(), new Observer<String>() {
            @Override
            public void onChanged(@Nullable String s) {
                textView.setText(s);
            }
        });*/

        //載入Fragment
        View root = inflater.inflate(R.layout.fragment_home, container, false);

        //載入RecyclerView
        FunctionBarRv = root.findViewById(R.id.functionBarRv);
        DateRv = root.findViewById(R.id.dateRv);
        NoticeDataRv = root.findViewById(R.id.noticeDataRv);
        TextView IdTv = root.findViewById(R.id.idTv);
        IdTv.setTypeface(IdTv.getTypeface(), Typeface.BOLD);//設定粗體

        //設定RecyclerView
        FunctionBarRv.setLayoutManager(new StaggeredGridLayoutManager(1,StaggeredGridLayoutManager.HORIZONTAL));//行數、左右滑動
        DateRv.setLayoutManager(new StaggeredGridLayoutManager(1,StaggeredGridLayoutManager.HORIZONTAL));//行數、左右滑動
        NoticeDataRv.setLayoutManager(new StaggeredGridLayoutManager(1,StaggeredGridLayoutManager.VERTICAL));//行數、上下滑動

        //set資料到畫面
        List<Function> FuncList = getFunctionList();
        FunctionAdapter functionAdapter = new FunctionAdapter(context,FuncList);
        FunctionBarRv.setAdapter(functionAdapter);

        List<String> dateList = getDate();
        DateAdapter dateAdapter = new DateAdapter(context,dateList);
        DateRv.setAdapter(dateAdapter);

        List<NewNotic> noticList = getNotic();
        NoticAdapter noticAdapter = new NoticAdapter(context,noticList);
        NoticeDataRv.setAdapter(noticAdapter);

        return root;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }

    public List<Function> getFunctionList(){
        List<Function> functionList = new ArrayList<>();
        functionList.add(new Function(R.drawable.f1,"加班"));
        functionList.add(new Function(R.drawable.f2,"排班"));
        functionList.add(new Function(R.drawable.f3,"文件"));
        functionList.add(new Function(R.drawable.f4,"訂餐"));
        functionList.add(new Function(R.drawable.f5,"打卡"));
        functionList.add(new Function(R.drawable.f6,"請假"));

        return functionList;

    }

    public List<String> getDate(){
        List<String> dateList = new ArrayList<>();

        int endDD = 30;
        for(int i = 0; i < endDD; i++){
            String iDD = String.valueOf(i+1);
            if(i<9){
                iDD = "0"+iDD;
            }
            dateList.add(iDD);
        }

        return dateList;
    }

    public List<NewNotic> getNotic(){
        List<NewNotic> noticList = new ArrayList<>();

        NewNotic newNotic = new NewNotic();
        newNotic.setPhotoImage(R.drawable.n1);
        newNotic.setName("(L091163)郭珮慈");
        newNotic.setNote("外訓申請提醒-JAVA認證");
        newNotic.setTime("09:30");
        newNotic.setWeek("Dec");
        newNotic.setDD("27");
        noticList.add(newNotic);

        newNotic = new NewNotic();
        newNotic.setPhotoImage(R.drawable.n1);
        newNotic.setName("(L107689)黃小傑");
        newNotic.setNote("2021下半年度測試序號");
        newNotic.setTime("09:20");
        newNotic.setWeek("Dec");
        newNotic.setDD("27");
        noticList.add(newNotic);

        newNotic = new NewNotic();
        newNotic.setPhotoImage(R.drawable.n1);
        newNotic.setName("(L000000)XXX");
        newNotic.setNote("1234567890");
        newNotic.setTime("09:10");
        newNotic.setWeek("Dec");
        newNotic.setDD("27");
        noticList.add(newNotic);

        return noticList;
    }


}