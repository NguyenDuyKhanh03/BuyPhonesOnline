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
import java.util.Objects;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link HomeFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class HomeFragment extends Fragment {

    List<Product> products=new ArrayList<>();
    ProductListAdapter adapter;

    RecyclerView rvProduct;
    RecyclerView rvProduct1;
    RecyclerView rvTelephone;

    List<Product> products1=new ArrayList<>();
    ProductListAdapter adapter1;

    List<Product> productsTelephone=new ArrayList<>();
    ProductListAdapter adapterTelephone;
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
        DatabaseHandler databaseHandler=DatabaseHandler.newInstance(requireContext().getApplicationContext());
        CategoryRepository categoryRepository=new CategoryRepository(databaseHandler);
        categoryRepository.addCategory("Dây sạc");
        categoryRepository.addCategory("Củ sạc");
        categoryRepository.addCategory("Điện thoại");
        categoryRepository.addCategory("Sạc dự phòng");

        ProductRepository productRepository=new ProductRepository(databaseHandler);
        Product product=new Product(
                "https://firebasestorage.googleapis.com/v0/b/fir-72119.appspot.com/o/image-Photoroom-Photoroom.png-Photoroom%20(1).png?alt=media&token=c48975b0-3aad-4429-983c-a370c2a91ca2",
                "Ugreen Robot Nexode 15550",
                300000,
                "Adapter Sạc Type C PD GaN 30W Ugreen Robot Nexode 15550 tạo điểm nhấn thu hút với màn hình LED biểu cảm ngộ nghĩnh và công suất sạc 30 W, giúp người dùng tiết kiệm thời gian.",
                20,
                2
        );
        productRepository.addProduct(product);
        Product product1=new Product(
                "https://firebasestorage.googleapis.com/v0/b/fir-72119.appspot.com/o/image-Photoroom-Photoroom.png-Photoroom.png?alt=media&token=4d80270b-38bb-4450-8e1a-f1b51ceade5c",
                "Ugreen Robot Nexode 25036",
                300000,
                "Adapter Sạc Type C PD GaN 30W Ugreen Robot Nexode 25036 sở hữu kiểu dáng bắt mắt với tone màu nữ tính, xinh xắn cùng màn hình LED biểu cảm dễ thương, bên trong là công suất sạc mạnh mẽ 30 W giúp sản phẩm trở thành phụ kiện lý tưởng cho mọi nhu cầu sạc của bạn khi di chuyển khắp mọi nơi.",
                21,
                2
        );
        productRepository.addProduct(product1);
        Product product2=new Product(
                "https://firebasestorage.googleapis.com/v0/b/fir-72119.appspot.com/o/image-Photoroom.png-Photoroom%20(1).png?alt=media&token=8219b9e4-8cb3-41a7-afa3-fefb1b2e2d63",
                "Anker A2145",
                200000,
                "Adapter Sạc 3 cổng USB Type-C IQ3 100W Anker A2145 không chỉ là một thiết bị sạc thông thường mà là một công cụ tiện lợi quan trọng cho tất cả các thiết bị số của bạn. Được trang bị công nghệ GaN2 tiên tiến, sản phẩm này có thiết kế nhỏ gọn, dễ dàng mang theo mỗi khi di chuyển.",
                10,
                2
        );
        productRepository.addProduct(product2);
        Product product3=new Product(
                "https://firebasestorage.googleapis.com/v0/b/fir-72119.appspot.com/o/image-Photoroom.png-Photoroom.png?alt=media&token=22ab7f70-b783-45ea-9efb-6f4733daa137",
                "Ugreen Nexode 90902",
                200000,
                "Adapter Sạc Type C PD GaN 20W Ugreen Nexode 90902 sở hữu thiết kế thiết kế nhỏ gọn, với gam màu tối sang trọng cùng công suất sạc lên đến 20 W, đem đến sự tiện dụng với khả năng tương thích nhiều thiết bị như điện thoại, máy tính bảng,...",
                5,
                2
        );
        productRepository.addProduct(product3);
        Product product4=new Product(
                "https://firebasestorage.googleapis.com/v0/b/fir-72119.appspot.com/o/CapLightning1mBaseusExplorerCB000041.png?alt=media&token=e776b8ab-8fad-48ea-b67d-72cfed335b50",
                "Baseus Explorer CB000041",
                135000,
                "Cáp Lightning 1m Baseus Explorer CB000041 với thiết kế gọn gàng, chiều dài 1 m lý tưởng, sản phẩm hỗ trợ sạc và truyền dữ liệu tiện lợi, dễ dàng mang theo mọi lúc.",
                50,
                1
        );
        productRepository.addProduct(product4);
        Product product5=new Product(
                "https://firebasestorage.googleapis.com/v0/b/fir-72119.appspot.com/o/Ugreen60759.png?alt=media&token=014a3f39-fe1d-4e17-8ba0-74518964f0ce",
                "Cáp Type C - Lightning MFI 1m Ugreen 60759 ",
                310000,
                "Cáp Type C - Lightning MFI 1m Ugreen 60759 sở hữu thiết kế tối giản, đầu ra Lightning hỗ trợ sạc nhanh lên tới 60 W cùng chuẩn sạc MFi, tương thích tốt với các sản phẩm của Apple",
                20,
                1
        );
        productRepository.addProduct(product5);
        Product product6=new Product(
                "https://firebasestorage.googleapis.com/v0/b/fir-72119.appspot.com/o/BaseusCoolPlayCB000047.png?alt=media&token=893d4c7f-7c96-4e28-976b-c36b12aa994d",
                "Baseus CoolPlay CB000047",
                215000,
                "Cáp Type C - Type C 2m Baseus CoolPlay CB000047 với gam màu đẹp mắt, kích thước 2 m sử dụng thoải mái, công suất sạc lớn cùng với nhiều tiện ích khác, hứa hẹn mang đến cho bạn những trải nghiệm tuyệt vời.",
                10,
                1
        );
        productRepository.addProduct(product6);
        Product product7=new Product(
                "https://firebasestorage.googleapis.com/v0/b/fir-72119.appspot.com/o/AppleMM0A3.png?alt=media&token=d0db6d49-35ac-4e6e-8b3f-6e63b2d0787a",
                "Lightning 1m Apple MM0A3",
                550000,
                "Cáp Type C - Lightning 1m Apple MM0A3 Trắng sở hữu thiết kế đơn giản, độ dài 1 m cùng khả năng sạc nhanh lên đến 87 W chính là sự lựa chọn tuyệt vời cho các iFans chân chính.",
                10,
                1
        );
        productRepository.addProduct(product7);
        Product product8=new Product(
                "https://firebasestorage.googleapis.com/v0/b/fir-72119.appspot.com/o/OPPOReno11%20F5G.png?alt=media&token=59c285cd-2f5a-4a35-b1ef-96f651b87dc2",
                "OPPO Reno11 F 5G Tím",
                8890000,
                "OPPO Reno11 F 5G là một chiếc điện thoại tầm trung mới được OPPO ra mắt trong thời gian gần đây. Máy sở hữu nhiều ưu điểm nổi bật như thiết kế trẻ trung, màn hình đẹp, hiệu năng mạnh mẽ nhờ chip Dimensity 7050 5G, hứa hẹn mang đến trải nghiệm tốt khi sử dụng.",
                10,
                3
        );
        productRepository.addProduct(product8);
        Product product9=new Product(
                "https://firebasestorage.googleapis.com/v0/b/fir-72119.appspot.com/o/OPPOA18.png?alt=media&token=5e52ee80-a752-45f7-8b03-78a48269dacd",
                "OPPO A18",
                2990000,
                "OPPO A18 - một trong những sản phẩm điện thoại giá rẻ được OPPO giới thiệu tại thị trường Việt Nam trong những tháng cuối năm 2023. Thiết kế của máy vẫn giữ nguyên phong cách quen thuộc như các sản phẩm điện thoại OPPO A, đi kèm với đó là một màn hình sắc nét cùng một hiệu năng ổn định.",
                40,
                3
        );
        productRepository.addProduct(product9);
        Product product10=new Product(
                "https://firebasestorage.googleapis.com/v0/b/fir-72119.appspot.com/o/vivoY03.png?alt=media&token=7fde77d1-f603-4a51-98bb-51e77658a606",
                "Vivo Y03",
                3290000,
                "Vivo Y03 tiếp tục là một mẫu điện thoại giá rẻ được vivo ra mắt tại thị trường Việt Nam. Sản phẩm lần này mang đến một diện mạo đẹp mắt hơn các phiên bản trước đó, tiếp đến là cấu hình nâng cấp cùng viên pin lớn 5000 mAh.",
                10,
                3
        );
        productRepository.addProduct(product10);
        Product product11=new Product(
                "https://firebasestorage.googleapis.com/v0/b/fir-72119.appspot.com/o/SamsungGalaxyA25.png?alt=media&token=48958aea-9c1b-44ca-973a-7dcf3c9f1574",
                "Samsung Galaxy A25",
                6690000,
                "Samsung Galaxy A25 5G 8GB một trong những mẫu điện thoại tầm trung mới nhất của Samsung được ra mắt vào tháng 12 năm 2023. Máy sở hữu thiết kế trẻ trung, màn hình Super AMOLED sống động, camera 50 MP chất lượng và pin 5000 mAh cho thời gian sử dụng lâu dài.",
                15,
                3
        );
        productRepository.addProduct(product11);

        ImagesRepository imagesRepository=new ImagesRepository(databaseHandler);

        imagesRepository.addImages(new Images(
                        "Ugreen Robot Nexode 15550",
                        "https://firebasestorage.googleapis.com/v0/b/fir-72119.appspot.com/o/UgreenRobotNexode_15570_1.png?alt=media&token=2ba2e506-3a0c-43aa-8828-62427a8492a3",
                        1,
                        "product"
                )
        );
        imagesRepository.addImages(new Images(
                        "Ugreen Robot Nexode 15550",
                        "https://firebasestorage.googleapis.com/v0/b/fir-72119.appspot.com/o/UgreenRobotNexode_15570_2.png?alt=media&token=acd01453-9105-4955-94ad-32062bc36020",
                        1,
                        "product"
                )
        );
        imagesRepository.addImages(new Images(
                        "Ugreen Robot Nexode 15550",
                        "https://firebasestorage.googleapis.com/v0/b/fir-72119.appspot.com/o/image-Photoroom-Photoroom.png-Photoroom%20(1).png?alt=media&token=c48975b0-3aad-4429-983c-a370c2a91ca2",
                        1,
                        "product"
                )
        );
        imagesRepository.addImages(new Images(
                "Ugreen Robot Nexode 25036",
                "https://firebasestorage.googleapis.com/v0/b/fir-72119.appspot.com/o/UgreenRobot1.png?alt=media&token=7155757f-0d1e-45ff-964f-e3ea26581d18",
                2,
                "product"
                )
        );
        imagesRepository.addImages(new Images(
                        "Ugreen Robot Nexode 25036",
                        "https://firebasestorage.googleapis.com/v0/b/fir-72119.appspot.com/o/UgreenRobot2.png?alt=media&token=06897e6b-87dc-496a-931d-db18ed7be2c9",
                        2,
                        "product"
                )
        );
        imagesRepository.addImages(new Images(
                        "Ugreen Robot Nexode 25036",
                        "https://firebasestorage.googleapis.com/v0/b/fir-72119.appspot.com/o/image-Photoroom-Photoroom.png-Photoroom.png?alt=media&token=4d80270b-38bb-4450-8e1a-f1b51ceade5c",
                        2,
                        "product"
                )
        );
        imagesRepository.addImages(new Images(
                        "Anker A2145",
                        "https://firebasestorage.googleapis.com/v0/b/fir-72119.appspot.com/o/AnkerA2145_1.png?alt=media&token=a90556e9-0299-470b-a7fa-e762dd387242",
                        3,
                        "product"
                )
        );
        imagesRepository.addImages(new Images(
                        "Anker A2145",
                        "https://firebasestorage.googleapis.com/v0/b/fir-72119.appspot.com/o/AnkerA2145_2.png?alt=media&token=88679709-5f30-42db-8de7-ed193a62b3a7",
                        3,
                        "product"
                )
        );
        imagesRepository.addImages(new Images(
                        "Anker A2145",
                        "https://firebasestorage.googleapis.com/v0/b/fir-72119.appspot.com/o/image-Photoroom.png-Photoroom%20(1).png?alt=media&token=8219b9e4-8cb3-41a7-afa3-fefb1b2e2d63",
                        3,
                        "product"
                )
        );
        imagesRepository.addImages(new Images(
                        "Ugreen Nexode 90902",
                        "https://firebasestorage.googleapis.com/v0/b/fir-72119.appspot.com/o/UgreenNexode90902_1.png?alt=media&token=1fa82072-594f-4395-894b-21237b9dec11",
                        4,
                        "product"
                )
        );
        imagesRepository.addImages(new Images(
                        "Ugreen Nexode 90902",
                        "https://firebasestorage.googleapis.com/v0/b/fir-72119.appspot.com/o/UgreenNexode90902_2.png?alt=media&token=0bd05d3a-aae3-44d1-9467-59745f582d98",
                        4,
                        "product"
                )
        );
        imagesRepository.addImages(new Images(
                        "Ugreen Nexode 90902",
                        "https://firebasestorage.googleapis.com/v0/b/fir-72119.appspot.com/o/image-Photoroom.png-Photoroom.png?alt=media&token=22ab7f70-b783-45ea-9efb-6f4733daa137",
                        4,
                        "product"
                )
        );
        imagesRepository.addImages(new Images(
                        "Baseus Explorer CB000041",
                        "https://firebasestorage.googleapis.com/v0/b/fir-72119.appspot.com/o/CapLightning1mBaseusExplorerCB000041.png?alt=media&token=e776b8ab-8fad-48ea-b67d-72cfed335b50",
                        5,
                        "product"
                )
        );
        imagesRepository.addImages(new Images(
                        "Baseus Explorer CB000041",
                        "https://firebasestorage.googleapis.com/v0/b/fir-72119.appspot.com/o/CapLightning1mBaseusExplorerCB000041_1.png?alt=media&token=80d30d15-2869-4e4b-83b5-551fba16c0a6",
                        5,
                        "product"
                )
        );
        imagesRepository.addImages(new Images(
                        "Baseus Explorer CB000041",
                        "https://firebasestorage.googleapis.com/v0/b/fir-72119.appspot.com/o/CapLightning1mBaseusExplorerCB000041_2.png?alt=media&token=a9241655-9e93-42fd-a30d-3ebc4bf8d0dc",
                        5,
                        "product"
                )
        );
        imagesRepository.addImages(new Images(
                        "Ugreen 60759",
                        "https://firebasestorage.googleapis.com/v0/b/fir-72119.appspot.com/o/Ugreen60759.png?alt=media&token=014a3f39-fe1d-4e17-8ba0-74518964f0ce",
                        6,
                        "product"
                )
        );
        imagesRepository.addImages(new Images(
                        "Ugreen 60759",
                        "https://firebasestorage.googleapis.com/v0/b/fir-72119.appspot.com/o/Ugreen60759_1.png?alt=media&token=37a28642-f9e0-4655-8730-0e77e0f3a76d",
                        6,
                        "product"
                )
        );
        imagesRepository.addImages(new Images(
                        "Ugreen 60759",
                        "https://firebasestorage.googleapis.com/v0/b/fir-72119.appspot.com/o/Ugreen60759_2.png?alt=media&token=e6359639-86b4-46f1-8ba4-03553b5a0ea0",
                        6,
                        "product"
                )
        );
        imagesRepository.addImages(new Images(
                        "Baseus CoolPlay CB000047",
                        "https://firebasestorage.googleapis.com/v0/b/fir-72119.appspot.com/o/BaseusCoolPlayCB000047.png?alt=media&token=893d4c7f-7c96-4e28-976b-c36b12aa994d",
                        7,
                        "product"
                )
        );
        imagesRepository.addImages(new Images(
                        "Baseus CoolPlay CB000047",
                        "https://firebasestorage.googleapis.com/v0/b/fir-72119.appspot.com/o/BaseusCoolPlayCB000047.png?alt=media&token=893d4c7f-7c96-4e28-976b-c36b12aa994d",
                        7,
                        "product"
                )
        );
        imagesRepository.addImages(new Images(
                        "Baseus CoolPlay CB000047",
                        "https://firebasestorage.googleapis.com/v0/b/fir-72119.appspot.com/o/BaseusCoolPlayCB000047_2.png?alt=media&token=b7cb7e10-4e57-4a9f-8cfe-559a1f06bfa1",
                        7,
                        "product"
                )
        );
        imagesRepository.addImages(new Images(
                        "Apple MM0A3",
                        "https://firebasestorage.googleapis.com/v0/b/fir-72119.appspot.com/o/AppleMM0A3.png?alt=media&token=d0db6d49-35ac-4e6e-8b3f-6e63b2d0787a",
                        8,
                        "product"
                )
        );
        imagesRepository.addImages(new Images(
                        "Apple MM0A3",
                        "https://firebasestorage.googleapis.com/v0/b/fir-72119.appspot.com/o/AppleMM0A3_1.png?alt=media&token=c5adb6fc-60b3-44db-9879-b0416ae6260c",
                        8,
                        "product"
                )
        );
        imagesRepository.addImages(new Images(
                        "Apple MM0A3",
                        "https://firebasestorage.googleapis.com/v0/b/fir-72119.appspot.com/o/AppleMM0A3_2.png?alt=media&token=a2edd5e3-4940-4085-9c36-f467def033db",
                        8,
                        "product"
                )
        );
        imagesRepository.addImages(new Images(
                        "OPPO Reno11 F 5G Tím",
                        "https://firebasestorage.googleapis.com/v0/b/fir-72119.appspot.com/o/OPPOReno11%20F5G.png?alt=media&token=59c285cd-2f5a-4a35-b1ef-96f651b87dc2",
                        9,
                        "product"
                )
        );
        imagesRepository.addImages(new Images(
                        "OPPO Reno11 F 5G Tím",
                        "https://firebasestorage.googleapis.com/v0/b/fir-72119.appspot.com/o/OPPOReno11%20F5G_1.png?alt=media&token=74217bf3-0ba8-4c73-9cfa-d001995c0eba",
                        9,
                        "product"
                )
        );
        imagesRepository.addImages(new Images(
                        "OPPO Reno11 F 5G Tím",
                        "https://firebasestorage.googleapis.com/v0/b/fir-72119.appspot.com/o/OPPOReno11%20F5G_2.png?alt=media&token=f391ab0b-790b-475e-83f2-03cc0aa1abf5",
                        9,
                        "product"
                )
        );
        imagesRepository.addImages(new Images(
                        "OPPO A18",
                        "https://firebasestorage.googleapis.com/v0/b/fir-72119.appspot.com/o/OPPOA18.png?alt=media&token=5e52ee80-a752-45f7-8b03-78a48269dacd",
                        10,
                        "product"
                )
        );
        imagesRepository.addImages(new Images(
                        "OPPO A18",
                        "https://firebasestorage.googleapis.com/v0/b/fir-72119.appspot.com/o/OPPOA18_1.jpg?alt=media&token=1a4a067a-5cc6-4bcf-adcc-6f2ad786493a",
                        10,
                        "product"
                )
        );
        imagesRepository.addImages(new Images(
                        "OPPO A18",
                        "https://firebasestorage.googleapis.com/v0/b/fir-72119.appspot.com/o/OPPOA18_2.png?alt=media&token=5d7b1a3f-b4c3-44d0-b174-8714610826eb",
                        10,
                        "product"
                )
        );
        imagesRepository.addImages(new Images(
                        "Vivo Y03",
                        "https://firebasestorage.googleapis.com/v0/b/fir-72119.appspot.com/o/vivoY03.png?alt=media&token=7fde77d1-f603-4a51-98bb-51e77658a606",
                        11,
                        "product"
                )
        );
        imagesRepository.addImages(new Images(
                        "Vivo Y03",
                        "https://firebasestorage.googleapis.com/v0/b/fir-72119.appspot.com/o/vivoY03_1.png?alt=media&token=b588c3d7-b2a4-4462-9c90-af2992418222",
                        11,
                        "product"
                )
        );
        imagesRepository.addImages(new Images(
                        "Vivo Y03",
                        "https://firebasestorage.googleapis.com/v0/b/fir-72119.appspot.com/o/vivoY03_2.png?alt=media&token=d329c697-276c-406f-9ece-08799df8c4c2",
                        11,
                        "product"
                )
        );
        imagesRepository.addImages(new Images(
                        "Samsung Galaxy A25",
                        "https://firebasestorage.googleapis.com/v0/b/fir-72119.appspot.com/o/SamsungGalaxyA25.png?alt=media&token=48958aea-9c1b-44ca-973a-7dcf3c9f1574",
                        12,
                        "product"
                )
        );
        imagesRepository.addImages(new Images(
                        "Samsung Galaxy A25",
                        "https://firebasestorage.googleapis.com/v0/b/fir-72119.appspot.com/o/SamsungGalaxyA25_1.png?alt=media&token=cf816b9f-51a8-40a9-a999-43b361a7d48f",
                        12,
                        "product"
                )
        );
        imagesRepository.addImages(new Images(
                        "Samsung Galaxy A25",
                        "https://firebasestorage.googleapis.com/v0/b/fir-72119.appspot.com/o/SamsungGalaxyA25_2.png?alt=media&token=ef8ef708-2cac-4a6f-94d7-347087bf51fb",
                        12,
                        "product"
                )
        );

        // day sac
        products=productRepository.getProductsByType(1);
        rvProduct=view.findViewById(R.id.rvPhoneChargeCord);
        adapter=new ProductListAdapter(products);
        rvProduct.setLayoutManager(new LinearLayoutManager(view.getContext(),RecyclerView.HORIZONTAL,false));
        rvProduct.setAdapter(adapter);
        rvProduct.addItemDecoration(new HorizontalItemDecoration(50));

        // cu sac
        products1=productRepository.getProductsByType(2);
        rvProduct1=view.findViewById(R.id.rvCharger);
        adapter1=new ProductListAdapter(products1);
        rvProduct1.setLayoutManager(new LinearLayoutManager(view.getContext(),RecyclerView.HORIZONTAL,false));
        rvProduct1.setAdapter(adapter1);
        rvProduct1.addItemDecoration(new HorizontalItemDecoration(50));

        // dien thoai
        productsTelephone=productRepository.getProductsByType(3);
        rvTelephone=view.findViewById(R.id.rvTelephone);
        adapterTelephone=new ProductListAdapter(productsTelephone);
        rvTelephone.setLayoutManager(new LinearLayoutManager(view.getContext(),RecyclerView.HORIZONTAL,false));
        rvTelephone.setAdapter(adapterTelephone);
        rvTelephone.addItemDecoration(new HorizontalItemDecoration(50));
    }
}