package com.example.buyphonesonline.callback;

import com.example.buyphonesonline.models.Product;

import java.util.List;

public interface LoginCallback {
    void onSuccess(int status);
    void onError(String errorMessage);
}
