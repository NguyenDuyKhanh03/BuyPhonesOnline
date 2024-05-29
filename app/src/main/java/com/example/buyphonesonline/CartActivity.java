package com.example.buyphonesonline;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.ItemTouchHelper;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Context;
import android.content.DialogInterface;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.view.View;
import android.widget.Toast;

import com.example.buyphonesonline.adapter.CartAdapter;
import com.example.buyphonesonline.config.ModelMapperConfig;
import com.example.buyphonesonline.databinding.ActivityCartBinding;
import com.example.buyphonesonline.dtos.ProductDto;
import com.example.buyphonesonline.handler.DatabaseHandler;
import com.example.buyphonesonline.models.Cart;
import com.example.buyphonesonline.repository.CartRepository;
import com.example.buyphonesonline.repository.ProductRepository;

import org.modelmapper.ModelMapper;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class CartActivity extends AppCompatActivity implements OnQuantityChangeListener {

    List<ProductDto> productDtos=new ArrayList<>();
    ModelMapper modelMapper= ModelMapperConfig.getModelMapper();
    CartAdapter cartAdapter;
    ActivityCartBinding binding;
    DatabaseHandler databaseHandler;

    CartRepository cartRepository;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        binding=ActivityCartBinding.inflate(getLayoutInflater());
        super.onCreate(savedInstanceState);
        setContentView(binding.getRoot());
//                Product product=new Product(
//                "https://firebasestorage.googleapis.com/v0/b/fir-72119.appspot.com/o/image-Photoroom-Photoroom.png-Photoroom%20(1).png?alt=media&token=c48975b0-3aad-4429-983c-a370c2a91ca2",
//                "Adapter Sạc Type C PD GaN 30W Ugreen Robot Nexode 15550",
//                300000,
//                "Adapter Sạc Type C PD GaN 30W Ugreen Robot Nexode 15550 tạo điểm nhấn thu hút với màn hình LED biểu cảm ngộ nghĩnh và công suất sạc 30 W, giúp người dùng tiết kiệm thời gian.",
//                20,
//                2
//        );
//        productDtos.add(modelMapper.map(product,ProductDto.class));
//        Product product1=new Product(
//                "https://firebasestorage.googleapis.com/v0/b/fir-72119.appspot.com/o/image-Photoroom-Photoroom.png-Photoroom.png?alt=media&token=4d80270b-38bb-4450-8e1a-f1b51ceade5c",
//                "Adapter Sạc Type C PD GaN 30W Ugreen Robot Nexode 25036",
//                300000,
//                "Adapter Sạc Type C PD GaN 30W Ugreen Robot Nexode 25036 sở hữu kiểu dáng bắt mắt với tone màu nữ tính, xinh xắn cùng màn hình LED biểu cảm dễ thương, bên trong là công suất sạc mạnh mẽ 30 W giúp sản phẩm trở thành phụ kiện lý tưởng cho mọi nhu cầu sạc của bạn khi di chuyển khắp mọi nơi.",
//                21,
//                2
//        );
//        productDtos.add(modelMapper.map(product1,ProductDto.class));
//        Product product2=new Product(
//                "https://firebasestorage.googleapis.com/v0/b/fir-72119.appspot.com/o/image-Photoroom.png-Photoroom%20(1).png?alt=media&token=8219b9e4-8cb3-41a7-afa3-fefb1b2e2d63",
//                "Adapter Sạc 3 cổng USB Type C IQ3 100W Anker A2145",
//                200000,
//                "Adapter Sạc 3 cổng USB Type-C IQ3 100W Anker A2145 không chỉ là một thiết bị sạc thông thường mà là một công cụ tiện lợi quan trọng cho tất cả các thiết bị số của bạn. Được trang bị công nghệ GaN2 tiên tiến, sản phẩm này có thiết kế nhỏ gọn, dễ dàng mang theo mỗi khi di chuyển.",
//                10,
//                2
//        );
//        productDtos.add(modelMapper.map(product2,ProductDto.class));
//        Product product3=new Product(
//                "https://firebasestorage.googleapis.com/v0/b/fir-72119.appspot.com/o/image-Photoroom.png-Photoroom.png?alt=media&token=22ab7f70-b783-45ea-9efb-6f4733daa137",
//                "Adapter Sạc Type C PD GaN 20W Ugreen Nexode 90902",
//                200000,
//                "Adapter Sạc Type C PD GaN 20W Ugreen Nexode 90902 sở hữu thiết kế thiết kế nhỏ gọn, với gam màu tối sang trọng cùng công suất sạc lên đến 20 W, đem đến sự tiện dụng với khả năng tương thích nhiều thiết bị như điện thoại, máy tính bảng,...",
//                5,
//                2
//        );
//        productDtos.add(modelMapper.map(product3,ProductDto.class));
//        Product product4=new Product(
//                "https://firebasestorage.googleapis.com/v0/b/fir-72119.appspot.com/o/CapLightning1mBaseusExplorerCB000041.png?alt=media&token=e776b8ab-8fad-48ea-b67d-72cfed335b50",
//                "Cáp Lightning 1m Baseus Explorer CB000041",
//                135000,
//                "Cáp Lightning 1m Baseus Explorer CB000041 với thiết kế gọn gàng, chiều dài 1 m lý tưởng, sản phẩm hỗ trợ sạc và truyền dữ liệu tiện lợi, dễ dàng mang theo mọi lúc.",
//                50,
//                1
//        );
//        productDtos.add(modelMapper.map(product4,ProductDto.class));
//        Product product5=new Product(
//                "https://firebasestorage.googleapis.com/v0/b/fir-72119.appspot.com/o/Ugreen60759.png?alt=media&token=014a3f39-fe1d-4e17-8ba0-74518964f0ce",
//                "Cáp Type C - Lightning MFI 1m Ugreen 60759 ",
//                310000,
//                "Cáp Type C - Lightning MFI 1m Ugreen 60759 sở hữu thiết kế tối giản, đầu ra Lightning hỗ trợ sạc nhanh lên tới 60 W cùng chuẩn sạc MFi, tương thích tốt với các sản phẩm của Apple",
//                20,
//                1
//        );
//        productDtos.add(modelMapper.map(product5,ProductDto.class));
//        Product product6=new Product(
//                "https://firebasestorage.googleapis.com/v0/b/fir-72119.appspot.com/o/BaseusCoolPlayCB000047.png?alt=media&token=893d4c7f-7c96-4e28-976b-c36b12aa994d",
//                "Cáp Type C - Type C 2m Baseus CoolPlay CB000047",
//                215000,
//                "Cáp Type C - Type C 2m Baseus CoolPlay CB000047 với gam màu đẹp mắt, kích thước 2 m sử dụng thoải mái, công suất sạc lớn cùng với nhiều tiện ích khác, hứa hẹn mang đến cho bạn những trải nghiệm tuyệt vời.",
//                10,
//                1
//        );
//        productDtos.add(modelMapper.map(product6,ProductDto.class));
//        Product product7=new Product(
//                "https://firebasestorage.googleapis.com/v0/b/fir-72119.appspot.com/o/AppleMM0A3.png?alt=media&token=d0db6d49-35ac-4e6e-8b3f-6e63b2d0787a",
//                "Cáp Type C - Lightning 1m Apple MM0A3",
//                550000,
//                "Cáp Type C - Lightning 1m Apple MM0A3 Trắng sở hữu thiết kế đơn giản, độ dài 1 m cùng khả năng sạc nhanh lên đến 87 W chính là sự lựa chọn tuyệt vời cho các iFans chân chính.",
//                10,
//                1
//        );
        databaseHandler=DatabaseHandler.newInstance(getApplicationContext());
        ProductRepository productRepository=new ProductRepository(databaseHandler);
        cartRepository=new CartRepository(databaseHandler,productRepository);
        productDtos=cartRepository.getCartItemsByUsername("Khanh");
        cartAdapter=new CartAdapter(productDtos,databaseHandler,this);
        binding.rvProduct.setLayoutManager(new LinearLayoutManager(CartActivity.this, RecyclerView.VERTICAL,false));
        binding.rvProduct.setAdapter(cartAdapter);
        binding.rvProduct.addItemDecoration(new VerticalItemDecoration(40));


        binding.frameLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
        Cart cart= cartRepository.findCartByUsername("Khanh");
        if(cart!=null)
            binding.tvTotal.setText(String.valueOf(cart.totalPrice()));


        updateTotalPrice();
        ItemTouchHelper itemTouchHelper = new ItemTouchHelper(new ItemTouchHelper.SimpleCallback(0, ItemTouchHelper.LEFT | ItemTouchHelper.RIGHT) {
            @Override
            public boolean onMove(@NonNull RecyclerView recyclerView, @NonNull RecyclerView.ViewHolder viewHolder, @NonNull RecyclerView.ViewHolder target) {
                return false; // Không xử lý di chuyển các mục
            }

            @Override
            public void onSwiped(@NonNull RecyclerView.ViewHolder viewHolder, int direction) {
                int pos = viewHolder.getAdapterPosition(); // Lấy vị trí của mục bị vuốt
                new AlertDialog.Builder(CartActivity.this)
                        .setTitle("Bạn có chắc không?")
                        .setMessage("Bạn muốn xóa sản phẩm này khỏi giỏ hàng!")
                        .setIcon(android.R.drawable.ic_dialog_alert)
                        .setPositiveButton("Có", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int whichButton) {
                                int productId = productDtos.get(pos).id();
                                productDtos.remove(pos);
                                cartAdapter.notifyItemRemoved(pos);
                                int result=cartRepository.deleteProduct(productId);
                                if(result==0)
                                    Toast.makeText(CartActivity.this, "Không tìm thấy sản phẩm hoặc lỗi!", Toast.LENGTH_SHORT).show();
                                else{
                                    Toast.makeText(CartActivity.this, "Xóa thành công", Toast.LENGTH_SHORT).show();

                                }
                            }
                        })
                        .setNegativeButton("Không", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int whichButton) {
                                cartAdapter.notifyItemChanged(pos);
                            }
                        })
                        .show();
            }
        });

        itemTouchHelper.attachToRecyclerView(binding.rvProduct);


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