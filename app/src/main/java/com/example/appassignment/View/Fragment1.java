package com.example.appassignment.View;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;

import com.example.appassignment.Model.Weather;
import com.example.appassignment.R;
import com.example.appassignment.ViewModel.AppViewModel;

public class Fragment1 extends Fragment {


    Button btn;
    Button btnSave;
    AppViewModel viewModel;
    EditText editText;
    TextView textView_tempC;
    TextView textView_tempC2;
    TextView textView_windspeed;
    TextView textView_winddir;
    TextView textView_humidity;
    TextView textView_cloud;
    TextView textView_time;



    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_1,container,false);


        btnSave = (Button) v.findViewById(R.id.button2);
        btn = (Button) v.findViewById(R.id.button);
        editText = v.findViewById(R.id.editText);
        textView_tempC = v.findViewById(R.id.textView_tempC);
        textView_tempC2 = v.findViewById(R.id.textView_tempC2);
        textView_windspeed = v.findViewById(R.id.textViewWindSpeed);
        textView_winddir = v.findViewById(R.id.textViewWindDir);
        textView_humidity = v.findViewById(R.id.textViewHumidity);
        textView_cloud = v.findViewById(R.id.textViewCloud);
        textView_time = v.findViewById(R.id.textViewTime);



        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                viewModel.updateWeather(editText.getText().toString());
            }
        });

        btnSave.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                viewModel.insert(new Weather(editText.getText().toString(),textView_tempC.getText().toString(),textView_tempC2.getText().toString(),textView_windspeed.getText().toString(),textView_winddir.getText().toString(),textView_humidity.getText().toString(),textView_cloud.getText().toString(),textView_time.getText().toString()));

            }
        });

        viewModel = new ViewModelProvider(this).get(AppViewModel.class);
        viewModel.getWeather().observe(getActivity(), new Observer<Weather>() {
            @Override
            public void onChanged(Weather weather) {

                Fragment1.this.textView_tempC.setText(weather.getTemp() + "°C");
                Fragment1.this.textView_tempC2.setText(weather.getFeelslike_c() + "°C");
                Fragment1.this.textView_windspeed.setText(weather.getWind_kph() + "km/h");
                Fragment1.this.textView_winddir.setText("Dir: " + weather.getWind_dir());
                Fragment1.this.textView_humidity.setText(weather.getHumidity() + "%");
                Fragment1.this.textView_cloud.setText("Cloud: " + weather.getCloud());
                Fragment1.this.textView_time.setText("Updated: "+ weather.getLast_updated());


                
            }
        });


        return v;
    }




}

