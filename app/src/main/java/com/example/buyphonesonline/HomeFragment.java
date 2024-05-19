package com.example.buyphonesonline;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.buyphonesonline.models.Product;

import java.util.ArrayList;
import java.util.List;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link HomeFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class HomeFragment extends Fragment {

    List<Product> products=new ArrayList<>();
    CategoryAdapter adapter;
    RecyclerView rvProduct;

    public HomeFragment() {
        // Required empty public constructor
    }

    public static HomeFragment newInstance() {

        return new HomeFragment();
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        products.add(new Product(
                1,
                "https://firebasestorage.googleapis.com/v0/b/fir-72119.appspot.com/o/adaptersactypecpd.png?alt=media&token=89c150a9-959b-4f77-a09f-228f0b2f1cbd",
                "Cáp Dây Rút Type C ",
                300000,
                20,
                1

        ));
        products.add(new Product(
                1,
                "https://firebasestorage.googleapis.com/v0/b/fir-72119.appspot.com/o/adapter-chuyen-doi-type-c.png?alt=media&token=c1523ccd-c73e-483d-baaf-9797749b859c",
                "Cáp Dây Rút Type C ",
                300000,
                20,
                1

        ));
        products.add(new Product(
                1,
                "https://firebasestorage.googleapis.com/v0/b/fir-72119.appspot.com/o/adapter-chuyen-doi-type-c.png?alt=media&token=c1523ccd-c73e-483d-baaf-9797749b859c",
                "Cáp Dây Rút Type C ",
                300000,
                20,
                1

        ));
        products.add(new Product(
                1,
                "https://firebasestorage.googleapis.com/v0/b/fir-72119.appspot.com/o/adaptersactypecpd.png?alt=media&token=89c150a9-959b-4f77-a09f-228f0b2f1cbd",
                "Cáp Dây Rút Type C ",
                300000,
                20,
                1

        ));
        products.add(new Product(
                1,
                "https://firebasestorage.googleapis.com/v0/b/fir-72119.appspot.com/o/cap-da-nang.png?alt=media&token=8e3c218f-0fe7-4626-b5c9-383e1d285874",
                "Cáp Dây Rút Type C ",
                300000,
                20,
                1

        ));
        products.add(new Product(
                1,
                "https://firebasestorage.googleapis.com/v0/b/fir-72119.appspot.com/o/cap-da-nang.png?alt=media&token=8e3c218f-0fe7-4626-b5c9-383e1d285874",
                "Cáp Dây Rút Type C ",
                300000,
                20,
                1

        ));
        products.add(new Product(
                1,
                "https://firebasestorage.googleapis.com/v0/b/fir-72119.appspot.com/o/adaptersactypecpd.png?alt=media&token=89c150a9-959b-4f77-a09f-228f0b2f1cbd",
                "Cáp Dây Rút Type C ",
                300000,
                20,
                1

        ));
        products.add(new Product(
                1,
                "https://firebasestorage.googleapis.com/v0/b/fir-72119.appspot.com/o/adaptersactypecpd.png?alt=media&token=89c150a9-959b-4f77-a09f-228f0b2f1cbd",
                "Cáp Dây Rút Type C ",
                300000,
                20,
                1

        ));
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_home, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        rvProduct=view.findViewById(R.id.rvPhoneChargeCord);
        adapter=new CategoryAdapter(products);
        rvProduct.setLayoutManager(new GridLayoutManager(view.getContext(),2));
        rvProduct.setAdapter(adapter);
        rvProduct.addItemDecoration(new CharacterItemDecoration(50));
    }
}