package com.iotproject.smartem.fragment;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.fragment.app.Fragment;
import androidx.navigation.NavDirections;
import androidx.navigation.Navigation;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.android.material.floatingactionbutton.ExtendedFloatingActionButton;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import com.iotproject.smartem.R;
import com.iotproject.smartem.adapter.HomeAdapter;
import com.iotproject.smartem.model.Data;

import java.util.ArrayList;

/**
 * A simple {@link Fragment} subclass.
 */
public class HomeFragment extends Fragment implements View.OnClickListener{


    private ArrayList<Data> list = new ArrayList<>();
    private ConstraintLayout layout1, layout2, layout3, layout4;
    private ExtendedFloatingActionButton btnConnect, btnDisconnect;
    private TextView tv_info, tvTegangan, tvArus, tvEnergi, tvDaya;
    FirebaseDatabase database = FirebaseDatabase.getInstance();
    DatabaseReference myRef, myRef2;

    public HomeFragment() {
        // Required empty public constructor
    }
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v = inflater.inflate(R.layout.fragment_home, container, false);

        btnConnect = v.findViewById(R.id.btn_connect);
        btnDisconnect = v.findViewById(R.id.btn_disconnect);
        layout1 = v.findViewById(R.id.container_tegangan);
        layout2 = v.findViewById(R.id.container_arus);
        layout3 = v.findViewById(R.id.container_daya);
        layout4 = v.findViewById(R.id.container_energi);
        tv_info = v.findViewById(R.id.tv_info);
        tvArus = v.findViewById(R.id.arus_val);

        btnConnect.setOnClickListener(this);
        btnDisconnect.setOnClickListener(this);

        String deviceId = "53156";
        myRef = database.getReference().child(deviceId).child("Current");
        myRef2 = database.getReference().child(deviceId).child("Voltage");
//        MyThread myThread = new MyThread();
//        myThread.start();

        myRef.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                String val = dataSnapshot.getValue(String.class);
                tvArus.setText(val);
            }
            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {
                Log.e("DB_ERROR", databaseError.getMessage());
            }
        });

        showElements();
        return v;
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.btn_connect :
                showElements();
//                Navigation.findNavController(v)
//                        .navigate(HomeFragmentDirections.actionHomeFragmentToConnectFragment2());
                break;
            case R.id.btn_disconnect :
                hideElements();
                break;
        }
    }

    private void showElements(){
        layout1.setVisibility(View.VISIBLE);
        layout2.setVisibility(View.VISIBLE);
        layout3.setVisibility(View.VISIBLE);
        layout4.setVisibility(View.VISIBLE);
        btnDisconnect.setVisibility(View.VISIBLE);
        btnConnect.setVisibility(View.GONE);
        tv_info.setVisibility(View.GONE);
    }
    private void hideElements(){
        layout1.setVisibility(View.GONE);
        layout2.setVisibility(View.GONE);
        layout3.setVisibility(View.GONE);
        layout4.setVisibility(View.GONE);
        btnDisconnect.setVisibility(View.GONE);
        btnConnect.setVisibility(View.VISIBLE);
        tv_info.setVisibility(View.VISIBLE);
    }

    public class MyThread extends Thread {
        public void run(){
            int volt = 219;
            for (;;){
                if(volt > 221) volt = 219;
                myRef2.setValue(volt);
                volt++;
                try {
                    Thread.sleep(250);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
