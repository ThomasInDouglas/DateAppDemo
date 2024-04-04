package com.example.dateapp;

import android.os.Build;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.RequiresApi;
import androidx.recyclerview.widget.RecyclerView;

import com.example.dateapp.databinding.LayoutDogitemBinding;

import java.time.format.DateTimeFormatter;
import java.util.List;

public class DogAdapter extends RecyclerView.Adapter<DogAdapter.DogViewHolder> {
    List<Dog> AdapterDogList;
    OnItemClickListener onItemClickListener;

    public DogAdapter(List<Dog> adapterDogList, OnItemClickListener onItemClickListener) {
        AdapterDogList = adapterDogList;
        this.onItemClickListener = onItemClickListener;
    }

    public DogAdapter(List<Dog> adapterDogList) {
        AdapterDogList = adapterDogList;
    }

    @NonNull
    @Override
    public DogViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return null;

    }

    @RequiresApi(api = Build.VERSION_CODES.O)
    @Override
    public void onBindViewHolder(@NonNull DogViewHolder holder, int position) {

    }

    @Override
    public int getItemCount() {
        return AdapterDogList.size();
    }

    public class DogViewHolder extends RecyclerView.ViewHolder {

        public DogViewHolder(@NonNull View itemView) {
            super(itemView);
        }


    }
    public interface OnItemClickListener {
        public void onItemClick(int i);
    }
}
