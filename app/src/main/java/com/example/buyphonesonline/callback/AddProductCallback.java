package com.example.buyphonesonline.callback;

import com.example.buyphonesonline.dtos.ProductDto;

import java.util.List;

public interface AddProductCallback {
    void onSuccess(List<ProductDto> cartItems);
    void onError(String error);
}
