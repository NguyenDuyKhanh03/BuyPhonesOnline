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
import android.widget.Button;

import com.example.buyphonesonline.adapter.OrderAdapter;
import com.example.buyphonesonline.callback.AddProductCallback;
import com.example.buyphonesonline.dtos.ProductDto;

import java.util.ArrayList;
import java.util.List;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link ProfileFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class ProfileFragment extends Fragment {

    RecyclerView rv;
    Button btn;
    OrderAdapter orderAdapter;
    List<ProductDto> productDtos=new ArrayList<>();

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
        rv=view.findViewById(R.id.rv1);
        btn=view.findViewById(R.id.btnShow);


        orderAdapter=new OrderAdapter(productDtos);
        rv.setLayoutManager(new LinearLayoutManager(view.getContext(), RecyclerView.VERTICAL,false));
        rv.setAdapter(orderAdapter);
        rv.addItemDecoration(new VerticalItemDecoration(40));
        SharedPreferences userDetails=view.getContext().getSharedPreferences("userdetails", MODE_PRIVATE);
        String username = userDetails.getString("username", "khanh1");
//        GetData getData=new GetData("http://192.168.2.34:8080/orders/get-order?username="+username,view.getContext());
//        getData.getCartItemToCart(new AddProductCallback() {
//            @Override
//            public void onSuccess(List<ProductDto> cartItems) {
//                productDtos.removeIf(item->item.price()>0);
//                productDtos.addAll(cartItems);
//                orderAdapter.notifyDataSetChanged();
//            }
//
//            @Override
//            public void onError(String error) {
//            }
//        });
    }
}