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

    public HomeAdapter(ArrayList<Data> list) {
        this.listData = list;
    }

    @NonNull
    @Override
    public HomeAdapter.ListViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_row_home, parent, false);
        return new ListViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull HomeAdapter.ListViewHolder holder, int position) {
        final Data data = listData.get(position);
        holder.tvVoltage.setText(String.valueOf(data.getVoltage()));
        holder.tvCurrent.setText(String.valueOf(data.getCurrent()));
        holder.tvRealPower.setText(String.valueOf(data.getRealPower()));
        holder.tvAppPower.setText(String.valueOf(data.getAppPower()));
    }

    @Override
    public int getItemCount() {
        return listData.size();
    }

    public class ListViewHolder extends RecyclerView.ViewHolder {
        TextView tvVoltage, tvCurrent, tvAppPower, tvRealPower, tvTimeStamp;
        public ListViewHolder(@NonNull View itemView) {
            super(itemView);
            tvVoltage = itemView.findViewById(R.id.item_tv_voltage);
            tvCurrent = itemView.findViewById(R.id.item_tv_current);
            tvAppPower = itemView.findViewById(R.id.item_tv_apppower);
            tvRealPower = itemView.findViewById(R.id.item_tv_realpower);
        }
    }
}
