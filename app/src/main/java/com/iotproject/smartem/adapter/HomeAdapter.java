package com.iotproject.smartem.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.iotproject.smartem.R;
import com.iotproject.smartem.model.Data;

import java.util.ArrayList;

public class HomeAdapter extends RecyclerView.Adapter<HomeAdapter.ListViewHolder>{
    private ArrayList<Data> listData;

    @NonNull
    @Override
    public HomeAdapter.ListViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_row_home, parent, false);
        return new ListViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull HomeAdapter.ListViewHolder holder, int position) {

    }

    @Override
    public int getItemCount() {
        return listData.size();
    }

    public class ListViewHolder extends RecyclerView.ViewHolder {
        TextView tvVoltage, tvCurrent, tvAppPower, tvRealPower, tvTimeStamp;
        public ListViewHolder(@NonNull View itemView) {
            super(itemView);

        }
    }
}
