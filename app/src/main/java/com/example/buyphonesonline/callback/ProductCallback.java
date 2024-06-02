package com.example.buyphonesonline.callback;

import com.example.buyphonesonline.models.Images;
import com.example.buyphonesonline.models.Product;

import java.util.List;

public interface ProductCallback {
    void onSuccess(List<Product> products);
    void onSuccess1(List<Images> images);
    void onError(String errorMessage);
}
