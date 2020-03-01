package com.iotproject.smartem.fragment;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.iotproject.smartem.R;
import com.iotproject.smartem.adapter.HomeAdapter;
import com.iotproject.smartem.model.Data;

import java.util.ArrayList;

/**
 * A simple {@link Fragment} subclass.
 */
public class HomeFragment extends Fragment {

    private RecyclerView rvHome;
    private ArrayList<Data> list = new ArrayList<>();

    public HomeFragment() {
        // Required empty public constructor
    }
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v = inflater.inflate(R.layout.fragment_home, container, false);

        rvHome = v.findViewById(R.id.rv_list);
        list.add(new Data(224.5f, 6.74f, 780.2f, 670.8f, "13-01-20 21:33:45"));
        showList();

        return v;
    }

    private void showList() {
        rvHome.setLayoutManager(new LinearLayoutManager(getContext()));
        HomeAdapter homeAdapter = new HomeAdapter(list);
        rvHome.setAdapter(homeAdapter);
    }
}
