package com.example.dateapp;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;

import android.os.Build;
import android.os.Bundle;
import android.util.Log;

import com.example.dateapp.databinding.ActivityMainBinding;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    List<Dog> DogList = new ArrayList<>();
    ActivityMainBinding binding;

    @RequiresApi(api = Build.VERSION_CODES.O)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //setContentView(R.layout.activity_main);
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        ReadDogData();
        Log.d("DATEDEMO", DogList.size() + " dogs added to the list.");
        binding.recyclerViewDogItems.setLayoutManager(new LinearLayoutManager(this));
        binding.recyclerViewDogItems.setAdapter(new DogAdapter(DogList, new DogAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(int i) {
                binding.txtViewAdoptionSumary.setText("Thank you for taking " + DogList.get(i).getDogName() + " to their forever home");
            }
        }));

    }
    @RequiresApi(api = Build.VERSION_CODES.O)
    private void ReadDogData(){
        InputStream inputStream = getResources().openRawResource(R.raw.doginfo);
        BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream));
        String dogLine;
        try {
            if ((dogLine = reader.readLine()) != null){
                //process header line
            }
            while ((dogLine = reader.readLine()) != null){
                String[] eachDogFields = dogLine.split(",");
                int dogId = Integer.parseInt(eachDogFields[0]);
                String dogResourceName = eachDogFields[1];
                String dogBreed = eachDogFields[2];
                String dogName = eachDogFields[3];
                String dogDOBStr = eachDogFields[4];

                //turn into R.drawable.xxxxx
                int dogPicDrawable = getResources()
                                    .getIdentifier(dogResourceName, "drawable", getPackageName());

                //d - one or more digits for date, e.g., 9, 10, 31
                //dd - 2 digits for date e.g., 08, 30, 29, 31
                //MM - month number e.g. 01, 05, 12
                //MMM - 3 letter month code e.g., Spe, MAR
                //yy - 2 digit year number, e.g., 23, 24
                //yyyy - 4 digit year number, e.g. 2023, 2024
                DateTimeFormatter formatter = DateTimeFormatter.ofPattern("d-MMM-yyyy");
                LocalDate dogDob = LocalDate.parse(dogDOBStr,formatter);
                Dog eachDog = new Dog(dogId,dogBreed,dogName,dogPicDrawable,dogDob);
                DogList.add(eachDog);

            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}