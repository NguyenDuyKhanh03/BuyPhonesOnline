package com.example.buyphonesonline.callback;


import com.example.buyphonesonline.models.User;

import java.util.List;

public interface UserCallBack {
    void onSuccess(User user);
    void onError(String errorMessage);
}
