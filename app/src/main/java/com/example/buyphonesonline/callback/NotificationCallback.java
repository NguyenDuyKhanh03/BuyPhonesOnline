package com.example.buyphonesonline.callback;

import com.example.buyphonesonline.models.Images;

import java.util.List;

public interface NotificationCallback {
    void onSuccess(List<String> list);
    void onError(String errorMessage);
}
