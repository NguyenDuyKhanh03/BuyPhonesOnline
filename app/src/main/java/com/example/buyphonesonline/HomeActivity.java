package com.example.buyphonesonline;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;

import com.example.buyphonesonline.databinding.ActivityHomeBinding;
import com.google.android.material.navigation.NavigationBarView;

public class HomeActivity extends AppCompatActivity {

    ActivityHomeBinding binding;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        binding=ActivityHomeBinding.inflate(getLayoutInflater());
        super.onCreate(savedInstanceState);
        setContentView(binding.getRoot());
        loadFrag(new HomeFragment(),R.id.frameFragment);

        binding.bottomNav.setOnItemSelectedListener(new NavigationBarView.OnItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                int id=item.getItemId();
                if(id==R.id.menu_home){
                    loadFrag(new HomeFragment(),R.id.frameFragment);
                    return true;
                }
                else if(R.id.menu_cart==id){
                    Intent intent=new Intent(HomeActivity.this, CartActivity.class);
                    startActivity(intent);
                    return true;
                }
                else {
                    return true;
                }
            }
        });

    }

    public void loadFrag(Fragment fragment_name, int flag)
    {
        FragmentManager fm = getSupportFragmentManager();
        FragmentTransaction ft = fm.beginTransaction();

        ft.replace(R.id.frameFragment, fragment_name);
        ft.addToBackStack(null);

        ft.commit();
    }
}