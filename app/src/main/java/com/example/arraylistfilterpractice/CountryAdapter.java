package com.example.arraylistfilterpractice;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class CountryAdapter  extends RecyclerView.Adapter<CountryAdapter.CountryViewHolder> {
    private List<CountryData> countryList;

    public CountryAdapter(List<CountryData> countryList) {
        this.countryList = countryList;
    }

    @NonNull
    @Override
    public CountryViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_country, parent, false);
        return new CountryViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull CountryViewHolder holder, int position) {
        CountryData countryData = countryList.get(position);
        holder.countryNameTextView.setText(countryData.getCountryName());
    }

    @Override
    public int getItemCount() {
        return countryList.size();
    }

    public static class CountryViewHolder extends RecyclerView.ViewHolder {
        TextView countryNameTextView;

        public CountryViewHolder(View itemView) {
            super(itemView);
            countryNameTextView = itemView.findViewById(R.id.countryNameTextView);
        }
    }
}