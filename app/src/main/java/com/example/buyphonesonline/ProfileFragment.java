package com.example.buyphonesonline;

import static android.content.Context.MODE_PRIVATE;

import android.content.Intent;
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
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.buyphonesonline.activity.EditProfileActivity;
import com.example.buyphonesonline.activity.LoginActivity;
import com.example.buyphonesonline.activity.OrderActivity;

public class ProfileFragment extends Fragment {

    Button btnSignOut;
    TextView tvName;
    ImageView imgEditProfile;
    ImageView imgShowOrder;
    public ProfileFragment() {
        // Required empty public constructor
    }

    public static ProfileFragment newInstance() {
        ProfileFragment fragment = new ProfileFragment();
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
        return inflater.inflate(R.layout.fragment_profile, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        btnSignOut=view.findViewById(R.id.btnSignOut);
        tvName=view.findViewById(R.id.tvName);
        imgEditProfile=view.findViewById(R.id.imgEditProfile);
        imgShowOrder=view.findViewById(R.id.imgShowOrder);
        imgEditProfile.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(v.getContext(), EditProfileActivity.class);
                v.getContext().startActivities(new Intent[]{intent});
            }
        });

        imgShowOrder.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(v.getContext(), OrderActivity.class);
                v.getContext().startActivities(new Intent[]{intent});
            }
        });

        SharedPreferences userDetails =view.getContext().getSharedPreferences("userdetails", MODE_PRIVATE);

        tvName.setText(userDetails.getString("username","khanh"));
        btnSignOut.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                SharedPreferences.Editor edit = userDetails.edit();
                edit.remove("username"); // Xóa mục "username"
                edit.remove("isLoggedIn"); // Xóa mục "isLoggedIn"
                edit.apply();
                Intent intent =new Intent(v.getContext(), LoginActivity.class);
                intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);
                v.getContext().startActivities(new Intent[]{intent});
            }
        });

    }
}