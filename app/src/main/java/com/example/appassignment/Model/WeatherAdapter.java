package com.example.appassignment.Model;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.appassignment.R;
import com.example.appassignment.ViewModel.AppViewModel;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;
import java.util.List;

public class WeatherAdapter extends RecyclerView.Adapter<WeatherAdapter.ViewHolder> {


    int count;



    public interface OnItemClickListener {
        void onItemClick(List<Weather> weather);
    }

    private List<Weather> weathers = new ArrayList<>();
    private final OnItemClickListener listener;

    public WeatherAdapter( OnItemClickListener listener) {
        this.listener = listener;

    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        View view = inflater.inflate(R.layout.weather_recycler, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        holder.bind(weathers, listener);
        holder.textViewCity.setText(weathers.get(position).getName());
        holder.textViewTime.setText(weathers.get(position).getLast_updated());
        holder.textViewTemp.setText(weathers.get(position).getTemp());
        holder.textViewTemp2.setText(weathers.get(position).getFeelslike_c());
        holder.textViewHumidity.setText(weathers.get(position).getHumidity());
        holder.textViewCloud.setText(weathers.get(position).getCloud());
        holder.textViewWind.setText(weathers.get(position).getWind_kph());
        holder.textViewDir.setText(weathers.get(position).getWind_dir());

    }

    @Override
    public int getItemCount() {
        return weathers.size();
    }

    public void setWeather(List<Weather>weathers){
        this.weathers = weathers;
        notifyDataSetChanged();
    }

    public int getCount() {
        return count;
    }

    class ViewHolder extends RecyclerView.ViewHolder {

        TextView textViewCity;
        TextView textViewTime;
        TextView textViewTemp;
        TextView textViewTemp2;
        TextView textViewHumidity;
        TextView textViewCloud;
        TextView textViewWind;
        TextView textViewDir;



        public ViewHolder(@NonNull View itemView) {

            super(itemView);


            textViewCity = itemView.findViewById(R.id.textViewRecCity);
            textViewTime = itemView.findViewById(R.id.textViewRecTime);
            textViewTemp = itemView.findViewById(R.id.textViewRecTemp);
            textViewTemp2 = itemView.findViewById(R.id.textViewRecTemp2);
            textViewHumidity = itemView.findViewById(R.id.textViewRecHumidity);
            textViewCloud = itemView.findViewById(R.id.textViewRecCloud);
            textViewWind = itemView.findViewById(R.id.textViewRecWind);
            textViewDir = itemView.findViewById(R.id.textViewRecDir);
        }



        public void bind(final  List<Weather> weathers, final OnItemClickListener listener) {



            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    for (int i = 0; i < weathers.size(); i ++){
                        listener.onItemClick(weathers);
                    }

                }
            });
        }
    }


}
