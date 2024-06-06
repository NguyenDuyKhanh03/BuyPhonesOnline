package com.example.buyphonesonline.callback;

import com.example.buyphonesonline.models.Order;

public interface OrderCallback {
    void onSuccess(Order order);
    void onError(String errorMessage);
}
