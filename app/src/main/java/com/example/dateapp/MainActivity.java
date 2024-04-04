package com.example.dateapp;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;

import android.os.Build;
import android.os.Bundle;

import com.example.dateapp.databinding.ActivityMainBinding;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
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
        binding.recyclerViewDogItems.setLayoutManager(new LinearLayoutManager(this));

    }
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


                //Dog eachDog = new Dog(dogId,dogBreed,dogName,dogPicDrawable);
                //DogList.add(eachDog);

            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}