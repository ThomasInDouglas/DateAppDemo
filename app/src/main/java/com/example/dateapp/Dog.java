package com.example.dateapp;

import java.time.LocalDate;

public class Dog {
    private int id;
    private String dogBreed;
    private String dogName;
    private int dogPicDrawable; //this is not the resource name but the drawable int value
    private LocalDate dogDob; //please note when working with dates in sqlite, need to use String or number

    public int getDogPicDrawable() {
        return dogPicDrawable;
    }

    public LocalDate getDogDob() {
        return dogDob;
    }

    public void setDogDob(LocalDate dogDob) {
        this.dogDob = dogDob;
    }

    public void setDogPicDrawable(int dogPicDrawable) {
        this.dogPicDrawable = dogPicDrawable;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getDogBreed() {
        return dogBreed;
    }

    public void setDogBreed(String dogBreed) {
        this.dogBreed = dogBreed;
    }

    public String getDogName() {
        return dogName;
    }

    public void setDogName(String dogName) {
        this.dogName = dogName;
    }

    public Dog(int id, String dogBreed, String dogName, int dogPicDrawable, LocalDate dogDob) {
        this.id = id;
        this.dogBreed = dogBreed;
        this.dogName = dogName;
        this.dogPicDrawable = dogPicDrawable;
        this.dogDob = dogDob;
    }
}
