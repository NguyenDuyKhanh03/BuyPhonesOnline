package com.example.buyphonesonline;

import static android.content.Context.MODE_PRIVATE;

import android.content.SharedPreferences;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;


import com.example.buyphonesonline.adapter.NotiAdapter;
import com.example.buyphonesonline.callback.NotificationCallback;

import java.util.ArrayList;
import java.util.List;


public class NotiFragment extends Fragment {

    RecyclerView lvCustomer;
    List<String> listC=new ArrayList<>();
    NotiAdapter notiCAdapter;
    RecyclerView lvGeneral;
    List<String> listG=new ArrayList<>();
    NotiAdapter notiGAdapter;

    public NotiFragment() {
        // Required empty public constructor
    }



    public static NotiFragment newInstance(String param1, String param2) {
        NotiFragment fragment = new NotiFragment();

        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_noti, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        lvCustomer=view.findViewById(R.id.rvCustomer);
        lvGeneral=view.findViewById(R.id.rvGeneral);
        GetData getData=new GetData(view.getContext());

        notiCAdapter=new NotiAdapter(listC);
        lvCustomer.setLayoutManager(new LinearLayoutManager(view.getContext()));
        lvCustomer.setAdapter(notiCAdapter);
        lvCustomer.addItemDecoration(new VerticalItemDecoration(50));

        notiGAdapter=new NotiAdapter(listG);
        lvGeneral.setLayoutManager(new LinearLayoutManager(view.getContext()));
        lvGeneral.setAdapter(notiGAdapter);
        lvGeneral.addItemDecoration(new VerticalItemDecoration(50));

        SharedPreferences userDetails =view.getContext().getSharedPreferences("userdetails", MODE_PRIVATE);
        String name= userDetails.getString("username","khanh");
        getData.setUrl("http://192.168.5.119:8080/notifications/user/"+name);
        getData.getNoti(new NotificationCallback() {
            @Override
            public void onSuccess(List<String> list) {
                listC.addAll(list);
                notiCAdapter.notifyDataSetChanged();
            }

            @Override
            public void onError(String errorMessage) {

            }
        });

        getData.setUrl("http://192.168.5.119:8080/notifications/general");
        getData.getNoti(new NotificationCallback() {
            @Override
            public void onSuccess(List<String> list) {
                listG.addAll(list);
                notiGAdapter.notifyDataSetChanged();
            }

            @Override
            public void onError(String errorMessage) {

            }
        });
    }
}