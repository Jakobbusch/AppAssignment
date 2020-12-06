package com.example.appassignment.View;

import android.content.Context;
import android.os.Bundle;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.PopupWindow;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.appassignment.Model.Weather;
import com.example.appassignment.Model.WeatherAdapter;
import com.example.appassignment.R;
import com.example.appassignment.ViewModel.AppViewModel;

import java.util.ArrayList;
import java.util.List;

import static androidx.core.content.ContextCompat.getSystemService;

public class Fragment2 extends Fragment {

    RecyclerView recyclerView;
    AppViewModel viewModel;
    Button buttonDelete;


    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_2,container,false);
        recyclerView = v.findViewById(R.id.recyclerView);
        recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
        recyclerView.hasFixedSize();
        buttonDelete = v.findViewById(R.id.buttonDelete);


        final WeatherAdapter weatherAdapter = new WeatherAdapter(new WeatherAdapter.OnItemClickListener() {

            @Override
            public void onItemClick(List<Weather> weather) {

            }
        });
        recyclerView.setAdapter(weatherAdapter);
        viewModel = new ViewModelProvider(this).get(AppViewModel.class);
        viewModel.getAllWeathers().observe(getActivity(), new Observer <List<Weather>>() {
            @Override
            public void onChanged(@Nullable List<Weather> weathers) {
                weatherAdapter.setWeather(weathers);
            }
            });

        buttonDelete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                viewModel.deleteAllNotes();
            }
        });

        return v;
    }


}
