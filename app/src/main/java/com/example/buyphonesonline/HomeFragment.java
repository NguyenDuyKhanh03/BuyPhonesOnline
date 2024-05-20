package com.example.buyphonesonline;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.buyphonesonline.adapter.ProductListAdapter;
import com.example.buyphonesonline.handler.DatabaseHandler;
import com.example.buyphonesonline.models.Images;
import com.example.buyphonesonline.models.Product;
import com.example.buyphonesonline.repository.CategoryRepository;
import com.example.buyphonesonline.repository.ImagesRepository;
import com.example.buyphonesonline.repository.ProductRepository;

import java.util.ArrayList;
import java.util.List;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link HomeFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class HomeFragment extends Fragment {

    List<Product> products=new ArrayList<>();
    ProductListAdapter adapter;
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
        DatabaseHandler databaseHandler=new DatabaseHandler(view.getContext());
//        CategoryRepository categoryRepository=new CategoryRepository(databaseHandler);
//        categoryRepository.addCategory("Dây sạc");
//        categoryRepository.addCategory("Củ sạc");

        ProductRepository productRepository=new ProductRepository(databaseHandler);
//        Product product=new Product(
//                "https://firebasestorage.googleapis.com/v0/b/fir-72119.appspot.com/o/image-Photoroom-Photoroom.png-Photoroom%20(1).png?alt=media&token=c48975b0-3aad-4429-983c-a370c2a91ca2",
//                "Adapter Sạc Type C PD GaN 30W Ugreen Robot Nexode 15550",
//                300000,
//                "Adapter Sạc Type C PD GaN 30W Ugreen Robot Nexode 15550 tạo điểm nhấn thu hút với màn hình LED biểu cảm ngộ nghĩnh và công suất sạc 30 W, giúp người dùng tiết kiệm thời gian.",
//                20,
//                1
//        );
//        productRepository.addProduct(product);
//        Product product1=new Product(
//                "https://firebasestorage.googleapis.com/v0/b/fir-72119.appspot.com/o/image-Photoroom-Photoroom.png-Photoroom.png?alt=media&token=4d80270b-38bb-4450-8e1a-f1b51ceade5c",
//                "Adapter Sạc Type C PD GaN 30W Ugreen Robot Nexode 25036",
//                300000,
//                "Adapter Sạc Type C PD GaN 30W Ugreen Robot Nexode 25036 sở hữu kiểu dáng bắt mắt với tone màu nữ tính, xinh xắn cùng màn hình LED biểu cảm dễ thương, bên trong là công suất sạc mạnh mẽ 30 W giúp sản phẩm trở thành phụ kiện lý tưởng cho mọi nhu cầu sạc của bạn khi di chuyển khắp mọi nơi.",
//                21,
//                1
//        );
//        productRepository.addProduct(product1);
//        Product product2=new Product(
//                "https://firebasestorage.googleapis.com/v0/b/fir-72119.appspot.com/o/image-Photoroom.png-Photoroom%20(1).png?alt=media&token=8219b9e4-8cb3-41a7-afa3-fefb1b2e2d63",
//                "Adapter Sạc 3 cổng USB Type C IQ3 100W Anker A2145",
//                200000,
//                "Adapter Sạc 3 cổng USB Type-C IQ3 100W Anker A2145 không chỉ là một thiết bị sạc thông thường mà là một công cụ tiện lợi quan trọng cho tất cả các thiết bị số của bạn. Được trang bị công nghệ GaN2 tiên tiến, sản phẩm này có thiết kế nhỏ gọn, dễ dàng mang theo mỗi khi di chuyển.",
//                10,
//                1
//        );
//        productRepository.addProduct(product2);
//        Product product3=new Product(
//                "https://firebasestorage.googleapis.com/v0/b/fir-72119.appspot.com/o/image-Photoroom.png-Photoroom.png?alt=media&token=22ab7f70-b783-45ea-9efb-6f4733daa137",
//                "Adapter Sạc Type C PD GaN 20W Ugreen Nexode 90902",
//                200000,
//                "Adapter Sạc Type C PD GaN 20W Ugreen Nexode 90902 sở hữu thiết kế thiết kế nhỏ gọn, với gam màu tối sang trọng cùng công suất sạc lên đến 20 W, đem đến sự tiện dụng với khả năng tương thích nhiều thiết bị như điện thoại, máy tính bảng,...",
//                5,
//                1
//        );
//        productRepository.addProduct(product3);
//        ImagesRepository imagesRepository=new ImagesRepository(databaseHandler);
//
//        imagesRepository.addImages(new Images(
//                        "Adapter Sạc Type C PD GaN 30W Ugreen Robot Nexode 15550",
//                        "https://firebasestorage.googleapis.com/v0/b/fir-72119.appspot.com/o/UgreenRobotNexode_15570_1.png?alt=media&token=2ba2e506-3a0c-43aa-8828-62427a8492a3",
//                        1,
//                        "product"
//                )
//        );
//        imagesRepository.addImages(new Images(
//                        "Adapter Sạc Type C PD GaN 30W Ugreen Robot Nexode 15550",
//                        "https://firebasestorage.googleapis.com/v0/b/fir-72119.appspot.com/o/UgreenRobotNexode_15570_2.png?alt=media&token=acd01453-9105-4955-94ad-32062bc36020",
//                        1,
//                        "product"
//                )
//        );
//        imagesRepository.addImages(new Images(
//                        "Adapter Sạc Type C PD GaN 30W Ugreen Robot Nexode 15550",
//                        "https://firebasestorage.googleapis.com/v0/b/fir-72119.appspot.com/o/image-Photoroom-Photoroom.png-Photoroom%20(1).png?alt=media&token=c48975b0-3aad-4429-983c-a370c2a91ca2",
//                        1,
//                        "product"
//                )
//        );
//        imagesRepository.addImages(new Images(
//                "Adapter Sạc Type C PD GaN 30W Ugreen Robot Nexode 25036",
//                "https://firebasestorage.googleapis.com/v0/b/fir-72119.appspot.com/o/UgreenRobot1.png?alt=media&token=7155757f-0d1e-45ff-964f-e3ea26581d18",
//                2,
//                "product"
//                )
//        );
//        imagesRepository.addImages(new Images(
//                        "Adapter Sạc Type C PD GaN 30W Ugreen Robot Nexode 25036",
//                        "https://firebasestorage.googleapis.com/v0/b/fir-72119.appspot.com/o/UgreenRobot2.png?alt=media&token=06897e6b-87dc-496a-931d-db18ed7be2c9",
//                        2,
//                        "product"
//                )
//        );
//        imagesRepository.addImages(new Images(
//                        "Adapter Sạc Type C PD GaN 30W Ugreen Robot Nexode 25036",
//                        "https://firebasestorage.googleapis.com/v0/b/fir-72119.appspot.com/o/image-Photoroom-Photoroom.png-Photoroom.png?alt=media&token=4d80270b-38bb-4450-8e1a-f1b51ceade5c",
//                        2,
//                        "product"
//                )
//        );
//        imagesRepository.addImages(new Images(
//                        "Adapter Sạc 3 cổng USB Type C IQ3 100W Anker A2145",
//                        "https://firebasestorage.googleapis.com/v0/b/fir-72119.appspot.com/o/AnkerA2145_1.png?alt=media&token=a90556e9-0299-470b-a7fa-e762dd387242",
//                        3,
//                        "product"
//                )
//        );
//        imagesRepository.addImages(new Images(
//                        "Adapter Sạc 3 cổng USB Type C IQ3 100W Anker A2145",
//                        "https://firebasestorage.googleapis.com/v0/b/fir-72119.appspot.com/o/AnkerA2145_2.png?alt=media&token=88679709-5f30-42db-8de7-ed193a62b3a7",
//                        3,
//                        "product"
//                )
//        );
//        imagesRepository.addImages(new Images(
//                        "Adapter Sạc 3 cổng USB Type C IQ3 100W Anker A2145",
//                        "https://firebasestorage.googleapis.com/v0/b/fir-72119.appspot.com/o/image-Photoroom.png-Photoroom%20(1).png?alt=media&token=8219b9e4-8cb3-41a7-afa3-fefb1b2e2d63",
//                        3,
//                        "product"
//                )
//        );
//        imagesRepository.addImages(new Images(
//                        "Adapter Sạc Type C PD GaN 20W Ugreen Nexode 90902",
//                        "https://firebasestorage.googleapis.com/v0/b/fir-72119.appspot.com/o/UgreenNexode90902_1.png?alt=media&token=1fa82072-594f-4395-894b-21237b9dec11",
//                        4,
//                        "product"
//                )
//        );
//        imagesRepository.addImages(new Images(
//                        "Adapter Sạc Type C PD GaN 20W Ugreen Nexode 90902",
//                        "https://firebasestorage.googleapis.com/v0/b/fir-72119.appspot.com/o/UgreenNexode90902_2.png?alt=media&token=0bd05d3a-aae3-44d1-9467-59745f582d98",
//                        4,
//                        "product"
//                )
//        );
//        imagesRepository.addImages(new Images(
//                        "Adapter Sạc Type C PD GaN 20W Ugreen Nexode 90902",
//                        "https://firebasestorage.googleapis.com/v0/b/fir-72119.appspot.com/o/image-Photoroom.png-Photoroom.png?alt=media&token=22ab7f70-b783-45ea-9efb-6f4733daa137",
//                        4,
//                        "product"
//                )
//        );
        products=productRepository.getAllProducts();

        rvProduct=view.findViewById(R.id.rvPhoneChargeCord);
        adapter=new ProductListAdapter(products);
        rvProduct.setLayoutManager(new LinearLayoutManager(view.getContext(),RecyclerView.HORIZONTAL,false));
        rvProduct.setAdapter(adapter);
        rvProduct.addItemDecoration(new HorizontalItemDecoration(50));


    }
}