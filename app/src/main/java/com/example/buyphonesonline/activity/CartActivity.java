package com.example.buyphonesonline.activity;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Toast;

import com.example.buyphonesonline.GetData;
import com.example.buyphonesonline.OnQuantityChangeListener;
import com.example.buyphonesonline.ProfileFragment;
import com.example.buyphonesonline.R;
import com.example.buyphonesonline.VerticalItemDecoration;
import com.example.buyphonesonline.adapter.CartAdapter;
import com.example.buyphonesonline.callback.AddProductCallback;
import com.example.buyphonesonline.config.ModelMapperConfig;
import com.example.buyphonesonline.databinding.ActivityCartBinding;
import com.example.buyphonesonline.dtos.ProductDto;


import org.modelmapper.ModelMapper;

import java.util.ArrayList;
import java.util.List;

public class CartActivity extends AppCompatActivity implements OnQuantityChangeListener {

    List<ProductDto> productDtos=new ArrayList<>();
    ModelMapper modelMapper= ModelMapperConfig.getModelMapper();
    CartAdapter cartAdapter;
    ActivityCartBinding binding;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        binding=ActivityCartBinding.inflate(getLayoutInflater());
        super.onCreate(savedInstanceState);
        setContentView(binding.getRoot());

        SharedPreferences userDetails=getSharedPreferences("userdetails", MODE_PRIVATE);
        String username = userDetails.getString("username", "khanh1");
        GetData getData=new GetData("http://192.168.2.34:8080/cart/list-product?username="+username,CartActivity.this);
        getData.getCartItemToCart(new AddProductCallback() {
            @Override
            public void onSuccess(List<ProductDto> cartItems) {
                productDtos.addAll(cartItems);
                Toast.makeText(CartActivity.this,String.valueOf(productDtos.size()),Toast.LENGTH_LONG).show();
                cartAdapter=new CartAdapter(productDtos,CartActivity.this);
                binding.rvProduct.setLayoutManager(new LinearLayoutManager(CartActivity.this, RecyclerView.VERTICAL,false));
                binding.rvProduct.setAdapter(cartAdapter);
                binding.rvProduct.addItemDecoration(new VerticalItemDecoration(40));
                updateTotalPrice();
                if(productDtos.size()>0){
                    binding.btnPurchase.setEnabled(true);
                }else {
                    binding.btnPurchase.setEnabled(false);
                }
            }

            @Override
            public void onError(String error) {
                Log.e("CART",error);
            }
        });





        binding.frameLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });

        binding.btnPurchase.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                new AlertDialog.Builder(CartActivity.this)
                        .setTitle("Đặt hàng")
                        .setMessage("Vui lòng xác nhận mua các sản phẩm này")
                        .setIcon(android.R.drawable.ic_dialog_alert)
                        .setPositiveButton("Có", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int whichButton) {
                                SharedPreferences userDetails=getSharedPreferences("userdetails", MODE_PRIVATE);
                                String username1 = userDetails.getString("username", "khanh1");
                                GetData getData1=new GetData("http://192.168.2.34:8080/orders/create?username="+username1,CartActivity.this);


                                getData1.createOrder(username);
                                productDtos.removeIf(element ->element.quantity()>0 );
                                cartAdapter.notifyDataSetChanged();
                                Toast.makeText(CartActivity.this,"Đặt hàng thành công",Toast.LENGTH_SHORT).show();
                                finish();
                            }
                        })
                        .setNegativeButton("Không", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int whichButton) {
                            }
                        })
                        .show();

            }
        });



//        ItemTouchHelper itemTouchHelper = new ItemTouchHelper(new ItemTouchHelper.SimpleCallback(0, ItemTouchHelper.LEFT | ItemTouchHelper.RIGHT) {
//            @Override
//            public boolean onMove(@NonNull RecyclerView recyclerView, @NonNull RecyclerView.ViewHolder viewHolder, @NonNull RecyclerView.ViewHolder target) {
//                return false; // Không xử lý di chuyển các mục
//            }
//
//            @Override
//            public void onSwiped(@NonNull RecyclerView.ViewHolder viewHolder, int direction) {
//                int pos = viewHolder.getAdapterPosition(); // Lấy vị trí của mục bị vuốt
//                new AlertDialog.Builder(CartActivity.this)
//                        .setTitle("Bạn có chắc không?")
//                        .setMessage("Bạn muốn xóa sản phẩm này khỏi giỏ hàng!")
//                        .setIcon(android.R.drawable.ic_dialog_alert)
//                        .setPositiveButton("Có", new DialogInterface.OnClickListener() {
//                            @Override
//                            public void onClick(DialogInterface dialog, int whichButton) {
//                                Long productId = productDtos.get(pos).id();
//                                productDtos.remove(pos);
//                                cartAdapter.notifyItemRemoved(pos);
//                                int result=cartRepository.deleteProduct(productId);
//                                if(result==0)
//                                    Toast.makeText(CartActivity.this, "Không tìm thấy sản phẩm hoặc lỗi!", Toast.LENGTH_SHORT).show();
//                                else{
//                                    Toast.makeText(CartActivity.this, "Xóa thành công", Toast.LENGTH_SHORT).show();
//
//                                }
//                            }
//                        })
//                        .setNegativeButton("Không", new DialogInterface.OnClickListener() {
//                            @Override
//                            public void onClick(DialogInterface dialog, int whichButton) {
//                                cartAdapter.notifyItemChanged(pos);
//                            }
//                        })
//                        .show();
//            }
//        });
//
//        itemTouchHelper.attachToRecyclerView(binding.rvProduct);


    }
    private long getTotalPrice(List<ProductDto> productDtos){
        long total=0;
        for (ProductDto i:
             productDtos) {
            total+=i.price()*i.quantity();
        }
        return total;

    }

    private void updateTotalPrice() {
        long total = getTotalPrice(productDtos);
        binding.tvTotal.setText(String.valueOf(total));
        if(!binding.tvShip.getText().toString().equals("Free"))
        {
            long sum= total+Long.parseLong(binding.tvShip.getText().toString());
            binding.tvSum.setText(String.valueOf(sum));
        }
        else{
            binding.tvSum.setText(binding.tvTotal.getText());
        }


    }
    @Override
    public void onQuantityChanged() {
        updateTotalPrice();
    }

}