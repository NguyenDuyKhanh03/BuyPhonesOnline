package com.example.buyphonesonline;

import android.content.Intent;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewpager2.widget.ViewPager2;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.SearchView;

import com.example.buyphonesonline.adapter.ProductListAdapter;
import com.example.buyphonesonline.adapter.VPAdapter;
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


    List<Integer> images=new ArrayList<>();
    ViewPager2 viewPager2;

    List<Product> products=new ArrayList<>();
    ProductListAdapter adapter;
    RecyclerView rvProduct;

    RecyclerView rvProduct1;

    List<Product> products1=new ArrayList<>();

    ProductListAdapter adapter1;

    RecyclerView rvProduct3;

    List<Product> products3=new ArrayList<>();
    ProductListAdapter adapter3;

    RecyclerView rvProduct5;

    List<Product> products5=new ArrayList<>();
    ProductListAdapter adapter5;

    SearchView searchView;

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
        categoryRepository.addCategory("Ipad");

        ProductRepository productRepository=new ProductRepository(databaseHandler);

        Product product=new Product(
                "https://firebasestorage.googleapis.com/v0/b/fir-72119.appspot.com/o/image-Photoroom-Photoroom.png-Photoroom%20(1).png?alt=media&token=c48975b0-3aad-4429-983c-a370c2a91ca2",
                "Adapter Sạc Type C PD GaN 30W Ugreen Robot Nexode 15550",
                300000,
                "Adapter Sạc Type C PD GaN 30W Ugreen Robot Nexode 15550 tạo điểm nhấn thu hút với màn hình LED biểu cảm ngộ nghĩnh và công suất sạc 30 W, giúp người dùng tiết kiệm thời gian.",
                20,
                2
        );
        productRepository.addProduct(product);
        Product product1=new Product(
                "https://firebasestorage.googleapis.com/v0/b/fir-72119.appspot.com/o/image-Photoroom-Photoroom.png-Photoroom.png?alt=media&token=4d80270b-38bb-4450-8e1a-f1b51ceade5c",
                "Adapter Sạc Type C PD GaN 30W Ugreen Robot Nexode 25036",
                300000,
                "Adapter Sạc Type C PD GaN 30W Ugreen Robot Nexode 25036 sở hữu kiểu dáng bắt mắt với tone màu nữ tính, xinh xắn cùng màn hình LED biểu cảm dễ thương, bên trong là công suất sạc mạnh mẽ 30 W giúp sản phẩm trở thành phụ kiện lý tưởng cho mọi nhu cầu sạc của bạn khi di chuyển khắp mọi nơi.",
                21,
                2
        );
        productRepository.addProduct(product1);
        Product product2=new Product(
                "https://firebasestorage.googleapis.com/v0/b/fir-72119.appspot.com/o/image-Photoroom.png-Photoroom%20(1).png?alt=media&token=8219b9e4-8cb3-41a7-afa3-fefb1b2e2d63",
                "Adapter Sạc 3 cổng USB Type C IQ3 100W Anker A2145",
                200000,
                "Adapter Sạc 3 cổng USB Type-C IQ3 100W Anker A2145 không chỉ là một thiết bị sạc thông thường mà là một công cụ tiện lợi quan trọng cho tất cả các thiết bị số của bạn. Được trang bị công nghệ GaN2 tiên tiến, sản phẩm này có thiết kế nhỏ gọn, dễ dàng mang theo mỗi khi di chuyển.",
                10,
                2
        );
        productRepository.addProduct(product2);
        Product product3=new Product(
                "https://firebasestorage.googleapis.com/v0/b/fir-72119.appspot.com/o/image-Photoroom.png-Photoroom.png?alt=media&token=22ab7f70-b783-45ea-9efb-6f4733daa137",
                "Adapter Sạc Type C PD GaN 20W Ugreen Nexode 90902",
                200000,
                "Adapter Sạc Type C PD GaN 20W Ugreen Nexode 90902 sở hữu thiết kế thiết kế nhỏ gọn, với gam màu tối sang trọng cùng công suất sạc lên đến 20 W, đem đến sự tiện dụng với khả năng tương thích nhiều thiết bị như điện thoại, máy tính bảng,...",
                5,
                2
        );
        productRepository.addProduct(product3);
        Product product4=new Product(
                "https://firebasestorage.googleapis.com/v0/b/fir-72119.appspot.com/o/CapLightning1mBaseusExplorerCB000041.png?alt=media&token=e776b8ab-8fad-48ea-b67d-72cfed335b50",
                "Cáp Lightning 1m Baseus Explorer CB000041",
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
                "Cáp Type C - Type C 2m Baseus CoolPlay CB000047",
                215000,
                "Cáp Type C - Type C 2m Baseus CoolPlay CB000047 với gam màu đẹp mắt, kích thước 2 m sử dụng thoải mái, công suất sạc lớn cùng với nhiều tiện ích khác, hứa hẹn mang đến cho bạn những trải nghiệm tuyệt vời.",
                10,
                1
        );
        productRepository.addProduct(product6);
        Product product7=new Product(
                "https://firebasestorage.googleapis.com/v0/b/fir-72119.appspot.com/o/AppleMM0A3.png?alt=media&token=d0db6d49-35ac-4e6e-8b3f-6e63b2d0787a",
                "Cáp Type C - Lightning 1m Apple MM0A3",
                550000,
                "Cáp Type C - Lightning 1m Apple MM0A3 Trắng sở hữu thiết kế đơn giản, độ dài 1 m cùng khả năng sạc nhanh lên đến 87 W chính là sự lựa chọn tuyệt vời cho các iFans chân chính.",
                10,
                1
        );
        productRepository.addProduct(product7);
        Product product8=new Product(
                "https://firebasestorage.googleapis.com/v0/b/hinhanhdoan-7826d.appspot.com/o/honorPadX9.png?alt=media&token=bf7e14e0-390b-4704-9a29-bffe5a1b4d3c",
                "HONOR Pad X9",
                4990000,
                "HONOR Pad X9 là mẫu máy tính bảng mới được nhà HONOR cho ra mắt sau khoảng thời gian dài vắng bóng tại Việt Nam, lần ra mắt này hãng mang tới một sản phẩm có giá thành rẻ, hiệu năng tốt cùng pin lớn giúp đáp ứng dài lâu cho mọi tác vụ.",
                10,
                5
        );
        productRepository.addProduct(product8);
        Product product9=new Product(
                "https://firebasestorage.googleapis.com/v0/b/hinhanhdoan-7826d.appspot.com/o/ssGalaxyTabS9.png?alt=media&token=a3bfbbb3-f3e8-447c-b0dc-548b75981b34",
                "Samsung Galaxy Tab S9+ 5G 256GB",
                8900000,
                "Tại sự kiện Unpacked 2023 Samsung đã cho ra mắt Samsung Galaxy Tab S9+ 5G 256GB với hiệu năng mạnh mẽ, màn hình hiển thị sắc nét và là máy tính bảng đầu tiên của hãng được trang bị kháng nước.",
                18,
                5
        );
        productRepository.addProduct(product9);
        Product product10=new Product(
                "https://firebasestorage.googleapis.com/v0/b/hinhanhdoan-7826d.appspot.com/o/ipad9.png?alt=media&token=d6ac14f4-d8b1-46d1-bc7d-3e2175a6c04a",
                "iPad 9 WiFi 64GB ",
                7090000,
                "Sau thành công của iPad 8, Apple đã cho ra mắt iPad Gen 9 - phiên bản tiếp theo của dòng iPad 10.2, về cơ bản nó kế thừa những điểm mạnh từ các phiên bản trước đó và được cải tiến thêm hiệu suất, trải nghiệm người dùng nhằm giúp nhu cầu sử dụng giải trí và làm việc tiện lợi, linh hoạt hơn.",
                10,
                5
        );
        productRepository.addProduct(product10);
        Product product11=new Product(
                "https://firebasestorage.googleapis.com/v0/b/hinhanhdoan-7826d.appspot.com/o/ipadAir5M1.png?alt=media&token=6d7971e7-92d2-4c1e-a987-54fb72e1dfd1",
                "iPad Air 5 M1 5G 64GB ",
                7690000,
                "So với chiếc iPad Air 5 M1 WiFi 64GB thì chiếc iPad Air 5 M1 WiFi Cellular 64GB đã có một điểm khác biệt đáng kể đó là phương thức kết nối khi bạn vừa có thể sử dụng Wifi và mạng di động một cách bình thường nhưng vẫn cho một trải nghiệm rất tuyệt vời.",
                10,
                5
        );
        productRepository.addProduct(product11);
        Product product12=new Product(
                "https://firebasestorage.googleapis.com/v0/b/hinhanhdoan-7826d.appspot.com/o/ipadPro10.png?alt=media&token=928e6523-57a6-4eef-91c8-9f4562c0ca61",
                "iPad 10 WiFi 64GB",
                9880000,
                "Sau khi trình làng hàng loạt mẫu iPhone vào tháng 09/2022 thì Apple cũng đã tiếp tục giới thiệu series iPad mới cho năm 2022. Trong đó iPad Gen 10 là cái tên được hãng chú trọng khá nhiều về việc tối ưu giá thành nhằm giúp người dùng có thể dễ dàng tiếp cận. Máy hỗ trợ hệ điều hành iPadOS 17 cùng con chip Apple A14 Bionic giúp mang lại hiệu năng vượt trội.",
                10,
                5
        );
        productRepository.addProduct(product12);
        Product product13=new Product(
                "https://firebasestorage.googleapis.com/v0/b/ngothanhhai-ba6b9.appspot.com/o/ip15pm-1.png?alt=media&token=4ccbfa9e-d8f5-43d5-bed8-3570f6077028",
                "Điện thoại iPhone 15 Pro Max",
                29590000,
                "Thiết kế: màn hình OLED kích thước 6.7 inch" +
                        "Bộ vi xử lý: Sử dụng con chip A17 Bionic" +
                        "Kết nối: Hỗ trợ 5G, Wi-Fi 6E" +
                        "Camera: bao gồm ít nhất 3 ống kính chính" +
                        "Pin:mlên tới 6000mAh, hỗ trợ sạc nhanh" +
                        "Tính năng mới: cảm biến vân tay trong màn hình, v.v.",
                50,
                3
        );
        productRepository.addProduct(product13);
        Product product14=new Product(
                "https://firebasestorage.googleapis.com/v0/b/ngothanhhai-ba6b9.appspot.com/o/nokia-1.png?alt=media&token=0dc010d4-702d-49c0-8686-140891de55c0",
                "Điện thoại Nokia 105",
                610000,
                " Màn hình: TFT 1.8 inch, 128 x 160 pixels" +
                        "Bộ nhớ: 4MB RAM, 4MB bộ nhớ trong" +
                        "Pin: Pin 800mAh" +
                        "Kết nối:chỉ có kết nối 2G cơ bản." +
                        "Tính năng: tính năng cơ bản",
                50,
                3
        );
        productRepository.addProduct(product14);
        Product product15=new Product(
                "https://firebasestorage.googleapis.com/v0/b/ngothanhhai-ba6b9.appspot.com/o/realme-1.png?alt=media&token=218f57cb-9eb4-4437-859f-a83ec16514ce",
                "Điện thoại realme C65",
                4790000,
                " Màn hình: 6.5 inch" +
                        "Bộ nhớ: RAM: 3GB/4GB, 32GB/64GB" +
                        "Pin: 5000mAh, hỗ trợ sạc nhanh 10W." +
                        "Kết nối: 4G LTE, Wi-Fi 802.11 b/g/n, Bluetooth 5.0" +
                        "Tính năng:Cảm biến vân tay",
                50,
                3
        );
        productRepository.addProduct(product15);
        Product product16=new Product(
                "https://firebasestorage.googleapis.com/v0/b/ngothanhhai-ba6b9.appspot.com/o/ss-1.png?alt=media&token=629550ea-f349-41ad-a84f-11ffacf28301",
                "Điện thoại Samsung Galaxy S23 Ultra ",
                24990000,
                " Màn hình: 6.8 inch, độ phân giải WQHD+ (3088 x 1440 pixels), Dynamic AMOLED 2X, tần số quét 120Hz, hỗ trợ HDR10+." +
                        "Bộ nhớ: RAM: 8GB/12GB, bộ nhớ trong: 128GB/256GB/512GB/1TB." +
                        "Pin: 5000mAh, hỗ trợ sạc nhanh 45W, sạc không dây 15W." +
                        "Kết nối: 5G, Wi-Fi 6E, Bluetooth 5.3, NFC, USB-C." +
                        "Camera chính: 200MP, khẩu độ f/1.7, OIS, Camera selfie: 12MP. " +
                        "Tính năng: Bút S Pen tích hợp, Cảm biến vân tay siêu âm trong màn hình, Chống nước IP68, Loa stereo, Dolby Atmos.",
                50,
                3
        );
        productRepository.addProduct(product16);
        ImagesRepository imagesRepository=new ImagesRepository(databaseHandler);


        imagesRepository.addImages(new Images(
                        "Adapter Sạc Type C PD GaN 30W Ugreen Robot Nexode 15550",
                        "https://firebasestorage.googleapis.com/v0/b/fir-72119.appspot.com/o/UgreenRobotNexode_15570_1.png?alt=media&token=2ba2e506-3a0c-43aa-8828-62427a8492a3",
                        1,
                        "product"
                )
        );
        imagesRepository.addImages(new Images(
                        "Adapter Sạc Type C PD GaN 30W Ugreen Robot Nexode 15550",
                        "https://firebasestorage.googleapis.com/v0/b/fir-72119.appspot.com/o/UgreenRobotNexode_15570_2.png?alt=media&token=acd01453-9105-4955-94ad-32062bc36020",
                        1,
                        "product"
                )
        );
        imagesRepository.addImages(new Images(
                        "Adapter Sạc Type C PD GaN 30W Ugreen Robot Nexode 15550",
                        "https://firebasestorage.googleapis.com/v0/b/fir-72119.appspot.com/o/image-Photoroom-Photoroom.png-Photoroom%20(1).png?alt=media&token=c48975b0-3aad-4429-983c-a370c2a91ca2",
                        1,
                        "product"
                )
        );
        imagesRepository.addImages(new Images(
                "Adapter Sạc Type C PD GaN 30W Ugreen Robot Nexode 25036",
                "https://firebasestorage.googleapis.com/v0/b/fir-72119.appspot.com/o/UgreenRobot1.png?alt=media&token=7155757f-0d1e-45ff-964f-e3ea26581d18",
                2,
                "product"
                )
        );
        imagesRepository.addImages(new Images(
                        "Adapter Sạc Type C PD GaN 30W Ugreen Robot Nexode 25036",
                        "https://firebasestorage.googleapis.com/v0/b/fir-72119.appspot.com/o/UgreenRobot2.png?alt=media&token=06897e6b-87dc-496a-931d-db18ed7be2c9",
                        2,
                        "product"
                )
        );
        imagesRepository.addImages(new Images(
                        "Adapter Sạc Type C PD GaN 30W Ugreen Robot Nexode 25036",
                        "https://firebasestorage.googleapis.com/v0/b/fir-72119.appspot.com/o/image-Photoroom-Photoroom.png-Photoroom.png?alt=media&token=4d80270b-38bb-4450-8e1a-f1b51ceade5c",
                        2,
                        "product"
                )
        );
        imagesRepository.addImages(new Images(
                        "Adapter Sạc 3 cổng USB Type C IQ3 100W Anker A2145",
                        "https://firebasestorage.googleapis.com/v0/b/fir-72119.appspot.com/o/AnkerA2145_1.png?alt=media&token=a90556e9-0299-470b-a7fa-e762dd387242",
                        3,
                        "product"
                )
        );
        imagesRepository.addImages(new Images(
                        "Adapter Sạc 3 cổng USB Type C IQ3 100W Anker A2145",
                        "https://firebasestorage.googleapis.com/v0/b/fir-72119.appspot.com/o/AnkerA2145_2.png?alt=media&token=88679709-5f30-42db-8de7-ed193a62b3a7",
                        3,
                        "product"
                )
        );
        imagesRepository.addImages(new Images(
                        "Adapter Sạc 3 cổng USB Type C IQ3 100W Anker A2145",
                        "https://firebasestorage.googleapis.com/v0/b/fir-72119.appspot.com/o/image-Photoroom.png-Photoroom%20(1).png?alt=media&token=8219b9e4-8cb3-41a7-afa3-fefb1b2e2d63",
                        3,
                        "product"
                )
        );
        imagesRepository.addImages(new Images(
                        "Adapter Sạc Type C PD GaN 20W Ugreen Nexode 90902",
                        "https://firebasestorage.googleapis.com/v0/b/fir-72119.appspot.com/o/UgreenNexode90902_1.png?alt=media&token=1fa82072-594f-4395-894b-21237b9dec11",
                        4,
                        "product"
                )
        );
        imagesRepository.addImages(new Images(
                        "Adapter Sạc Type C PD GaN 20W Ugreen Nexode 90902",
                        "https://firebasestorage.googleapis.com/v0/b/fir-72119.appspot.com/o/UgreenNexode90902_2.png?alt=media&token=0bd05d3a-aae3-44d1-9467-59745f582d98",
                        4,
                        "product"
                )
        );
        imagesRepository.addImages(new Images(
                        "Adapter Sạc Type C PD GaN 20W Ugreen Nexode 90902",
                        "https://firebasestorage.googleapis.com/v0/b/fir-72119.appspot.com/o/image-Photoroom.png-Photoroom.png?alt=media&token=22ab7f70-b783-45ea-9efb-6f4733daa137",
                        4,
                        "product"
                )
        );
        imagesRepository.addImages(new Images(
                        "Cáp Lightning 1m Baseus Explorer CB000041",
                        "https://firebasestorage.googleapis.com/v0/b/fir-72119.appspot.com/o/CapLightning1mBaseusExplorerCB000041.png?alt=media&token=e776b8ab-8fad-48ea-b67d-72cfed335b50",
                        5,
                        "product"
                )
        );
        imagesRepository.addImages(new Images(
                        "Cáp Lightning 1m Baseus Explorer CB000041",
                        "https://firebasestorage.googleapis.com/v0/b/fir-72119.appspot.com/o/CapLightning1mBaseusExplorerCB000041_1.png?alt=media&token=80d30d15-2869-4e4b-83b5-551fba16c0a6",
                        5,
                        "product"
                )
        );
        imagesRepository.addImages(new Images(
                        "Cáp Lightning 1m Baseus Explorer CB000041",
                        "https://firebasestorage.googleapis.com/v0/b/fir-72119.appspot.com/o/CapLightning1mBaseusExplorerCB000041_2.png?alt=media&token=a9241655-9e93-42fd-a30d-3ebc4bf8d0dc",
                        5,
                        "product"
                )
        );
        imagesRepository.addImages(new Images(
                        "Cáp Type C - Lightning MFI 1m Ugreen 60759",
                        "https://firebasestorage.googleapis.com/v0/b/fir-72119.appspot.com/o/Ugreen60759.png?alt=media&token=014a3f39-fe1d-4e17-8ba0-74518964f0ce",
                        6,
                        "product"
                )
        );
        imagesRepository.addImages(new Images(
                        "Cáp Type C - Lightning MFI 1m Ugreen 60759",
                        "https://firebasestorage.googleapis.com/v0/b/fir-72119.appspot.com/o/Ugreen60759_1.png?alt=media&token=37a28642-f9e0-4655-8730-0e77e0f3a76d",
                        6,
                        "product"
                )
        );
        imagesRepository.addImages(new Images(
                        "Cáp Type C - Lightning MFI 1m Ugreen 60759",
                        "https://firebasestorage.googleapis.com/v0/b/fir-72119.appspot.com/o/Ugreen60759_2.png?alt=media&token=e6359639-86b4-46f1-8ba4-03553b5a0ea0",
                        6,
                        "product"
                )
        );
        imagesRepository.addImages(new Images(
                        "Cáp Type C - Type C 2m Baseus CoolPlay CB000047",
                        "https://firebasestorage.googleapis.com/v0/b/fir-72119.appspot.com/o/BaseusCoolPlayCB000047.png?alt=media&token=893d4c7f-7c96-4e28-976b-c36b12aa994d",
                        7,
                        "product"
                )
        );
        imagesRepository.addImages(new Images(
                        "Cáp Type C - Type C 2m Baseus CoolPlay CB000047",
                        "https://firebasestorage.googleapis.com/v0/b/fir-72119.appspot.com/o/BaseusCoolPlayCB000047.png?alt=media&token=893d4c7f-7c96-4e28-976b-c36b12aa994d",
                        7,
                        "product"
                )
        );
        imagesRepository.addImages(new Images(
                        "Cáp Type C - Type C 2m Baseus CoolPlay CB000047",
                        "https://firebasestorage.googleapis.com/v0/b/fir-72119.appspot.com/o/BaseusCoolPlayCB000047_2.png?alt=media&token=b7cb7e10-4e57-4a9f-8cfe-559a1f06bfa1",
                        7,
                        "product"
                )
        );
        imagesRepository.addImages(new Images(
                        "Cáp Type C - Lightning 1m Apple MM0A3",
                        "https://firebasestorage.googleapis.com/v0/b/fir-72119.appspot.com/o/AppleMM0A3.png?alt=media&token=d0db6d49-35ac-4e6e-8b3f-6e63b2d0787a",
                        8,
                        "product"
                )
        );
        imagesRepository.addImages(new Images(
                        "Cáp Type C - Lightning 1m Apple MM0A3",
                        "https://firebasestorage.googleapis.com/v0/b/fir-72119.appspot.com/o/AppleMM0A3_1.png?alt=media&token=c5adb6fc-60b3-44db-9879-b0416ae6260c",
                        8,
                        "product"
                )
        );
        imagesRepository.addImages(new Images(
                        "Cáp Type C - Lightning 1m Apple MM0A3",
                        "https://firebasestorage.googleapis.com/v0/b/fir-72119.appspot.com/o/AppleMM0A3_2.png?alt=media&token=a2edd5e3-4940-4085-9c36-f467def033db",
                        8,
                        "product"
                )
        );

        imagesRepository.addImages(new Images(
                        "HONOR Pad X9",
                        "https://firebasestorage.googleapis.com/v0/b/hinhanhdoan-7826d.appspot.com/o/honorPadX9_a1.png?alt=media&token=37051ab8-9d9f-424d-b28c-c572aa63e808",
                        9,
                        "product"
                )
        );
        imagesRepository.addImages(new Images(
                        "HONOR Pad X9",
                        "https://firebasestorage.googleapis.com/v0/b/hinhanhdoan-7826d.appspot.com/o/honorPadX9_a2.png?alt=media&token=7f42e25f-08cf-40d1-a69e-ae049ac4f960",
                        9,
                        "product"
                )
        );
        imagesRepository.addImages(new Images(
                        "HONOR Pad X9",
                        "https://firebasestorage.googleapis.com/v0/b/hinhanhdoan-7826d.appspot.com/o/honorPadX9_a3.png?alt=media&token=3f2baed7-a0f9-4055-b553-6213585a0da7",
                        9,
                        "product"
                )
        );
        imagesRepository.addImages(new Images(
                        "Samsung Galaxy Tab S9+ 5G 256GB",
                        "https://firebasestorage.googleapis.com/v0/b/hinhanhdoan-7826d.appspot.com/o/ssGalaxyTabS9_a1.png?alt=media&token=1304057c-b6b2-4bf0-92a4-15d9da1bcd30",
                        10,
                        "product"
                )
        );
        imagesRepository.addImages(new Images(
                        "Samsung Galaxy Tab S9+ 5G 256GB",
                        "https://firebasestorage.googleapis.com/v0/b/hinhanhdoan-7826d.appspot.com/o/ssGalaxyTabS9_a2.png?alt=media&token=1cd65817-4177-4198-af4a-ce28d109631d",
                        10,
                        "product"
                )
        );
        imagesRepository.addImages(new Images(
                        "Samsung Galaxy Tab S9+ 5G 256GB",
                        "https://firebasestorage.googleapis.com/v0/b/hinhanhdoan-7826d.appspot.com/o/ssGalaxyTabS9_a3.png?alt=media&token=b52811c7-5bbb-470e-b61d-42513cd4047d",
                        10,
                        "product"
                )
        );
        imagesRepository.addImages(new Images(
                        "iPad 9 WiFi 64GB ",
                        "https://firebasestorage.googleapis.com/v0/b/hinhanhdoan-7826d.appspot.com/o/ipad9_a1.png?alt=media&token=b14f39af-56b4-4a59-b8e0-9cb57cb4997e",
                        11,
                        "product"
                )
        );
        imagesRepository.addImages(new Images(
                        "iPad 9 WiFi 64GB ",
                        "https://firebasestorage.googleapis.com/v0/b/hinhanhdoan-7826d.appspot.com/o/ipad9_a2.png?alt=media&token=9117b82a-9ddb-4f81-8eb8-6d39fb40be84",
                        11,
                        "product"
                )
        );
        imagesRepository.addImages(new Images(
                        "iPad 9 WiFi 64GB ",
                        "https://firebasestorage.googleapis.com/v0/b/hinhanhdoan-7826d.appspot.com/o/ipad9_a3.png?alt=media&token=2b02ae05-28fd-4bb5-9041-8b861193f9c9",
                        11,
                        "product"
                )
        );
        imagesRepository.addImages(new Images(
                        "iPad Air 5 M1 5G 64GB ",
                        "https://firebasestorage.googleapis.com/v0/b/hinhanhdoan-7826d.appspot.com/o/ipadAir5M1_a1.png?alt=media&token=326d9c5d-ab57-48e6-a97d-c0f9884c0765",
                        12,
                        "product"
                )
        );
        imagesRepository.addImages(new Images(
                        "iPad Air 5 M1 5G 64GB ",
                        "https://firebasestorage.googleapis.com/v0/b/hinhanhdoan-7826d.appspot.com/o/ipadAir5M1_a2.png?alt=media&token=176627c1-b23f-46e0-9dcf-0f98b59c3a6b",
                        12,
                        "product"
                )
        );
        imagesRepository.addImages(new Images(
                        "iPad Air 5 M1 5G 64GB ",
                        "https://firebasestorage.googleapis.com/v0/b/hinhanhdoan-7826d.appspot.com/o/ipadAir5M1_a3.png?alt=media&token=d507e74b-5165-44bd-894f-99f7ca41ee1c",
                        12,
                        "product"
                )
        );
        imagesRepository.addImages(new Images(
                        "iPad 10 WiFi 64GB",
                        "https://firebasestorage.googleapis.com/v0/b/hinhanhdoan-7826d.appspot.com/o/ipadPro10_a1.png?alt=media&token=6d3a7a04-eb71-4380-89b8-ade1143f86e2",
                        13,
                        "product"
                )
        );
        imagesRepository.addImages(new Images(
                        "iPad 10 WiFi 64GB",
                        "https://firebasestorage.googleapis.com/v0/b/hinhanhdoan-7826d.appspot.com/o/ipadPro10_a2.png?alt=media&token=41126cc7-c310-4607-9a15-eb0221d964a4",
                        13,
                        "product"
                )
        );
        imagesRepository.addImages(new Images(
                        "iPad 10 WiFi 64GB",
                        "https://firebasestorage.googleapis.com/v0/b/hinhanhdoan-7826d.appspot.com/o/ipadPro10_a3.png?alt=media&token=461eabe8-48ef-4d3c-bb63-83f7ac056c38",
                        13,
                        "product"
                )
        );
                imagesRepository.addImages(new Images(
                        "Điện thoại iPhone 15 Pro Max",
                        "https://firebasestorage.googleapis.com/v0/b/ngothanhhai-ba6b9.appspot.com/o/ip15pm-1.png?alt=media&token=4ccbfa9e-d8f5-43d5-bed8-3570f6077028",
                        14,
                        "product"
                )
        );
        imagesRepository.addImages(new Images(
                        "Điện thoại iPhone 15 Pro Max",
                        "https://firebasestorage.googleapis.com/v0/b/ngothanhhai-ba6b9.appspot.com/o/ip15pm-2.png?alt=media&token=5ee35e49-8ff0-41d6-94da-a14b6346dae6",
                        14,
                        "product"
                )
        );
        imagesRepository.addImages(new Images(
                        "Điện thoại iPhone 15 Pro Max",
                        "https://firebasestorage.googleapis.com/v0/b/ngothanhhai-ba6b9.appspot.com/o/ip15pm-3.png?alt=media&token=bda1cea8-bce9-42f0-8f1c-10acaef6b1ea",
                        14,
                        "product"
                )
        );
        imagesRepository.addImages(new Images(
                        "Điện thoại Nokia 105",
                        "https://firebasestorage.googleapis.com/v0/b/ngothanhhai-ba6b9.appspot.com/o/nokia-1.png?alt=media&token=0dc010d4-702d-49c0-8686-140891de55c0",
                        15,
                        "product"
                )
        );
        imagesRepository.addImages(new Images(
                        "Điện thoại Nokia 105",
                        "https://firebasestorage.googleapis.com/v0/b/ngothanhhai-ba6b9.appspot.com/o/nokia-2.png?alt=media&token=d0902efb-0ecf-4478-99e2-0987aede5e0b",
                        15,
                        "product"
                )
        );
        imagesRepository.addImages(new Images(
                        "Điện thoại Nokia 105",
                        "https://firebasestorage.googleapis.com/v0/b/ngothanhhai-ba6b9.appspot.com/o/nokia-3.png?alt=media&token=809131b1-15c7-4de2-a0f7-54de5a76d776",
                        15,
                        "product"
                )
        );
        imagesRepository.addImages(new Images(
                        "Điện thoại realme C65",
                        "https://firebasestorage.googleapis.com/v0/b/ngothanhhai-ba6b9.appspot.com/o/realme-1.png?alt=media&token=218f57cb-9eb4-4437-859f-a83ec16514ce",
                        16,
                        "product"
                )
        );
        imagesRepository.addImages(new Images(
                        "Điện thoại realme C65",
                        "https://firebasestorage.googleapis.com/v0/b/ngothanhhai-ba6b9.appspot.com/o/realme-2.png?alt=media&token=a834a0ff-3f7c-48cd-b49a-db24ada5a1b2",
                        16,
                        "product"
                )
        );
        imagesRepository.addImages(new Images(
                        "Điện thoại realme C65",
                        "https://firebasestorage.googleapis.com/v0/b/ngothanhhai-ba6b9.appspot.com/o/realme-3.png?alt=media&token=81a4aba5-0b16-4622-afae-84d872ddd40b",
                        16,
                        "product"
                )
        );
        imagesRepository.addImages(new Images(
                        "Điện thoại Samsung Galaxy S23 Ultra ",
                        "https://firebasestorage.googleapis.com/v0/b/ngothanhhai-ba6b9.appspot.com/o/ss-1.png?alt=media&token=629550ea-f349-41ad-a84f-11ffacf28301",
                        17,
                        "product"
                )
        );
        imagesRepository.addImages(new Images(
                        "Điện thoại Samsung Galaxy S23 Ultra ",
                        "https://firebasestorage.googleapis.com/v0/b/ngothanhhai-ba6b9.appspot.com/o/ss-2.png?alt=media&token=5fe2ce77-3ad6-4955-add4-ff903dea30ae",
                        17,
                        "product"
                )
        );
        imagesRepository.addImages(new Images(
                        "Điện thoại Samsung Galaxy S23 Ultra ",
                        "https://firebasestorage.googleapis.com/v0/b/ngothanhhai-ba6b9.appspot.com/o/ss-3.png?alt=media&token=6b8a6ffc-2faa-4081-adfd-8dbb46986e58",
                        17,
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
        products3=productRepository.getProductsByType(3);
        rvProduct3=view.findViewById(R.id.rvTelephone);
        adapter3=new ProductListAdapter(products3);
        rvProduct3.setLayoutManager(new LinearLayoutManager(view.getContext(),RecyclerView.HORIZONTAL,false));
        rvProduct3.setAdapter(adapter3);
        rvProduct3.addItemDecoration(new HorizontalItemDecoration(50));


        //Ipad
        products5=productRepository.getProductsByType(5);
        rvProduct5=view.findViewById(R.id.rvIpad);
        adapter5=new ProductListAdapter(products5);
        rvProduct5.setLayoutManager(new LinearLayoutManager(view.getContext(),RecyclerView.HORIZONTAL,false));
        rvProduct5.setAdapter(adapter5);
        rvProduct5.addItemDecoration(new HorizontalItemDecoration(50));

        searchView=view.findViewById(R.id.search_home);
        searchView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(v.getContext(), SearchActivity.class);
                startActivity(intent);
            }
        });

        images.add(R.drawable.galaxys20);
        images.add(R.drawable.oppoa92);
        images.add(R.drawable.redminot9);

        viewPager2=view.findViewById(R.id.viewPager);
        viewPager2.setAdapter(new VPAdapter(images));
    }
}////