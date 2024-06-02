package com.example.buyphonesonline.callback;

public interface RegisterCallback {
    void onSuccess(String response);
    void onError(String errorMessage);
}
