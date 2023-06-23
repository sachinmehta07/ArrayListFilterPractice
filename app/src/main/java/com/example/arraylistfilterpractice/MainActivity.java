package com.example.arraylistfilterpractice;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.widget.EditText;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    private List<CountryData> countryList;
    private List<CountryData> filteredList;
    private RecyclerView recyclerView;
    private EditText searchEditText;
    private CountryAdapter countryAdapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Initialize country list
        countryList = generateCountryList();

        // Initialize filtered list
        filteredList = new ArrayList<>(countryList);

        // Initialize RecyclerView and set adapter
        recyclerView = findViewById(R.id.recyclerView);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        countryAdapter = new CountryAdapter(filteredList);
        recyclerView.setAdapter(countryAdapter);

        // Initialize search EditText and add TextWatcher
        searchEditText = findViewById(R.id.searchEditText);
        searchEditText.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
                // Not needed
            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                // Filter the list based on the search input
                filterList(s.toString());
            }

            @Override
            public void afterTextChanged(Editable s) {
                // Not needed
            }
        });

    }

    private List<CountryData> generateCountryList() {
        // Generate a list of country data
        List<CountryData> countryList = new ArrayList<>();
        countryList.add(new CountryData(1, "India"));
        countryList.add(new CountryData(2, "Indonesia"));
        countryList.add(new CountryData(3, "United States"));
        countryList.add(new CountryData(4, "United Kingdom"));
        countryList.add(new CountryData(5, "China"));
        countryList.add(new CountryData(6, "Brazil"));
        return countryList;
    }

    private void filterList(String searchText) {
        filteredList.clear();

        // If the search text is empty, display all items
        if (searchText.isEmpty()) {
            filteredList.addAll(countryList);
        } else {

            
//            for (CountryData countryData : countryList) {
//                if (countryData.getCountryName().toLowerCase().contains(searchText.toLowerCase())) {
//                    filteredList.add(countryData);
//                }
//            }


            // Filter the list based on the search text
            String searchLowerCase = searchText.toLowerCase();
            for (int i = 0; i < countryList.size(); i++) {
                CountryData countryData = countryList.get(i);
                String countryNameLowerCase = countryData.getCountryName().toLowerCase();
                if (countryNameLowerCase.contains(searchLowerCase)) {
                    filteredList.add(countryData);
                }
            }
        }
        countryAdapter.notifyDataSetChanged();
    }


}