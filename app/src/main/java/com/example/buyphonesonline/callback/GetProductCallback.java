package com.example.buyphonesonline.callback;

import com.example.buyphonesonline.models.Images;
import com.example.buyphonesonline.models.Product;

import java.util.List;

public interface GetProductCallback {
    void onSuccess(Product product);

    void onError(String errorMessage);
}
