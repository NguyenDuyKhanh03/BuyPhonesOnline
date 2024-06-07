package com.example.buyphonesonline;

import android.content.Context;
import android.util.Log;

import androidx.annotation.Nullable;


import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.example.buyphonesonline.callback.AddProductCallback;
import com.example.buyphonesonline.callback.GetProductCallback;
import com.example.buyphonesonline.callback.LoginCallback;
import com.example.buyphonesonline.callback.NotificationCallback;
import com.example.buyphonesonline.callback.OrderCallback;
import com.example.buyphonesonline.callback.ProductCallback;
import com.example.buyphonesonline.callback.RegisterCallback;
import com.example.buyphonesonline.callback.UserCallBack;
import com.example.buyphonesonline.dtos.ProductDto;
import com.example.buyphonesonline.models.Images;
import com.example.buyphonesonline.models.Order;
import com.example.buyphonesonline.models.Product;
import com.example.buyphonesonline.models.User;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.UnsupportedEncodingException;
import java.nio.charset.StandardCharsets;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.TimeZone;

public class GetData {
    private String url;
    private Context context;


    public GetData(String url, Context context) {
        this.url = url;
        this.context = context;
    }

    public GetData(Context context) {
        this.context = context;
    }

    public String url() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public Context context() {
        return context;
    }

    public void setContext(Context context) {
        this.context = context;
    }

    public void getDataAllProduct(final ProductCallback callback) {
        RequestQueue requestQueue = Volley.newRequestQueue(context);
        StringRequest stringRequest = new StringRequest(
                Request.Method.GET,
                url,
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        try {
                            String utf8Response = new String(response.getBytes(StandardCharsets.ISO_8859_1), StandardCharsets.UTF_8);
                            List<Product> products = parseJsonData(utf8Response);
                            callback.onSuccess(products);
                        } catch (JSONException ex) {
                            callback.onError(ex.getMessage());
                        }
                    }
                },
                new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        callback.onError(error.getMessage());
                    }
                }
        );
        requestQueue.add(stringRequest);
    }
    public void getDataProductByCategoryId(final ProductCallback callback) {
        RequestQueue requestQueue = Volley.newRequestQueue(context);
        StringRequest stringRequest = new StringRequest(
                Request.Method.GET,
                url,
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        try {
                            String utf8Response = new String(response.getBytes(StandardCharsets.ISO_8859_1), StandardCharsets.UTF_8);
                            List<Product> products = parseJsonData(utf8Response);
                            callback.onSuccess(products);
                        } catch (JSONException ex) {
                            callback.onError(ex.getMessage());
                        }
                    }
                },
                new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        callback.onError(error.getMessage());
                    }
                }
        );
        requestQueue.add(stringRequest);
    }
    public void getDataImageByProductId(final ProductCallback callback) {
        RequestQueue requestQueue = Volley.newRequestQueue(context);
        StringRequest stringRequest = new StringRequest(
                Request.Method.GET,
                url,
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        try {
                            List<Images> images = parseJsonData1(response);
                            callback.onSuccess1(images);
                        } catch (JSONException ex) {
                            callback.onError(ex.getMessage());
                        }
                    }
                },
                new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        callback.onError(error.getMessage());
                    }
                }
        );
        requestQueue.add(stringRequest);
    }



    private List<Product> parseJsonData(String response) throws JSONException {
        List<Product> products2=new ArrayList<>();
        JSONArray jsonArray=new JSONArray(response);
        for (int i=0;i<jsonArray.length();i++){
            JSONObject jsonObject=jsonArray.getJSONObject(i);
            Long id=jsonObject.getLong("id");
            String name=jsonObject.getString("name");
            String des=jsonObject.getString("description");
            double price=jsonObject.getDouble("price");
            int quantity=jsonObject.getInt("quantity");
            String image=jsonObject.getString("image");
            Long categoryId=jsonObject.getLong("categoryId");
            products2.add(new Product(id,image,name,price,des,quantity,categoryId));
        }
        return products2;
    }

    private List<Images> parseJsonData1(String response) throws JSONException {
        List<Images> images=new ArrayList<>();
        JSONArray jsonArray=new JSONArray(response);
        for (int i=0;i<jsonArray.length();i++){
            JSONObject jsonObject=jsonArray.getJSONObject(i);
            Long id=jsonObject.getLong("id");
            String name=jsonObject.getString("name");
            String image=jsonObject.getString("url");
            Long relation_id=jsonObject.getLong("relation_id");
            String type=jsonObject.getString("type");
            images.add(new Images(id,name,image,relation_id,type));
        }
        return images;
    }

    public void registerUser(User user,final RegisterCallback registerCallback) {
        RequestQueue requestQueue = Volley.newRequestQueue(context);
        JSONObject jsonBody = new JSONObject();
        try {
            jsonBody.put("username", user.username());
            jsonBody.put("password", user.password());
            jsonBody.put("email",user.email());
            jsonBody.put("address",user.address());
            jsonBody.put("numberPhone",user.numberPhone());


        } catch (JSONException e) {
            e.printStackTrace();
        }

        final String requestBody = jsonBody.toString();

        StringRequest stringRequest = new StringRequest(Request.Method.POST, url, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                registerCallback.onSuccess(response);
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                registerCallback.onError(error.getMessage());
            }
        }) {
            @Override
            public String getBodyContentType() {
                return "application/json; charset=utf-8";
            }

            @Override
            public byte[] getBody() {
                try {
                    return requestBody == null ? null : requestBody.getBytes("utf-8");
                } catch (UnsupportedEncodingException uee) {
                    return null;
                }
            }
        };


        requestQueue.add(stringRequest);
    }

    public void login(String username, String password, final LoginCallback callback) {
        String loginUrl = "http://192.168.2.34:8080/user/login?username=" + username + "&password=" + password;

        RequestQueue requestQueue = Volley.newRequestQueue(context);
        StringRequest stringRequest = new StringRequest(
                Request.Method.GET,
                loginUrl,
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        try {
                            int result = Integer.parseInt(response);
                            callback.onSuccess(result);
                        } catch (NumberFormatException e) {
                            callback.onError("Invalid response format");
                        }
                    }
                },
                new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        callback.onError(error.getMessage());
                    }
                }
        );

        requestQueue.add(stringRequest);
    }

    public void addProductToCartOrReduce(final AddProductCallback callback) {

        RequestQueue requestQueue = Volley.newRequestQueue(context);
        StringRequest stringRequest = new StringRequest(
                Request.Method.POST,
                url,
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        try {
//                            List<CartItem> cartItems=parseJsonData2(response);
//                            callback.onSuccess(cartItems);

                        } catch (NumberFormatException ignored) {

                        }
                    }
                },
                new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
//                        callback.onError(error.getMessage());
                    }
                }
        );

        requestQueue.add(stringRequest);
    }

    private List<ProductDto> parseJsonData2(String response) throws JSONException {
        List<ProductDto> cartItems=new ArrayList<>();
        JSONArray jsonArray=new JSONArray(response);
        for (int i=0;i<jsonArray.length();i++){
            JSONObject jsonObject=jsonArray.getJSONObject(i);
            Long id=jsonObject.getLong("id");
            String name=jsonObject.getString("name");
            String image=jsonObject.getString("image");
            double price=jsonObject.getDouble("price");
            int quantity=jsonObject.getInt("quantity");
            ProductDto cartItem=new ProductDto(id,name,image,price,quantity);
            cartItems.add(cartItem);
        }
        return cartItems;
    }

    public void getCartItemToCart(final AddProductCallback callback) {

        RequestQueue requestQueue = Volley.newRequestQueue(context);
        StringRequest stringRequest = new StringRequest(
                Request.Method.GET,
                url,
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        try {
                            String utf8Response = new String(response.getBytes(StandardCharsets.ISO_8859_1), StandardCharsets.UTF_8);
                            List<ProductDto> cartItems=parseJsonData2(utf8Response);
                            callback.onSuccess(cartItems);

                        } catch (NumberFormatException ignored) {

                        } catch (JSONException e) {
//                            callback.onError(e.getMessage());
                        }
                    }
                },
                new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        callback.onError(error.getMessage());
                    }
                }
        );

        requestQueue.add(stringRequest);
    }


    public void createOrder(String username){
        RequestQueue requestQueue=Volley.newRequestQueue(context);
        StringRequest stringRequest=new StringRequest(
                Request.Method.POST,
                url,
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        Log.d("ORDER","Ok");
                    }
                },
                new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        Log.d("ORDER", error.getMessage().toString());
                    }
                }
        );
        requestQueue.add(stringRequest);

    }

    public void getProductById(final GetProductCallback getProductCallback){
        RequestQueue requestQueue=Volley.newRequestQueue(context);
        StringRequest stringRequest=new StringRequest(
                Request.Method.GET,
                url,
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        try {
                            String utf8Response = new String(response.getBytes(StandardCharsets.ISO_8859_1), StandardCharsets.UTF_8);
                            Product product = parseJsonProduct(utf8Response);
                            getProductCallback.onSuccess(product);
                        } catch (NumberFormatException | JSONException ignored) {

                        }

                    }
                },
                new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        getProductCallback.onError(error.getMessage());
                    }
                }
        );
        requestQueue.add(stringRequest);
    }

    private Product parseJsonProduct(String response) throws JSONException {
        JSONObject jsonObject = new JSONObject(response);
        Long id = jsonObject.getLong("id");
        String name = jsonObject.getString("name");
        String description = jsonObject.getString("description");
        double price = jsonObject.getDouble("price");
        int quantity = jsonObject.getInt("quantity");
        String image = jsonObject.getString("image");
        Long categoryId = jsonObject.getLong("categoryId");
        return new Product(id,image,name,price,description,quantity,categoryId);
    }

    public void updateUser(String username,User user){
        RequestQueue requestQueue=Volley.newRequestQueue(context);
        JSONObject jsonObject=new JSONObject();
        try {
            jsonObject.put("address",user.address());
            jsonObject.put("email",user.email());
            jsonObject.put("numberPhone",user.numberPhone());
        }catch (JSONException e){
            e.printStackTrace();
        }

        JsonObjectRequest jsonObjectRequest=new JsonObjectRequest(
                Request.Method.PUT,
                url,
                jsonObject,
                new Response.Listener<JSONObject>() {
                    @Override
                    public void onResponse(JSONObject response) {

                    }
                },
                new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {

                    }
                }
        );
        requestQueue.add(jsonObjectRequest);
    }

    public void getUser(String username, final UserCallBack userCallBack){
        RequestQueue requestQueue=Volley.newRequestQueue(context);
        StringRequest stringRequest=new StringRequest(
                Request.Method.GET,
                url,
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        try {
                            User user=parseJsonUser(response);
                            userCallBack.onSuccess(user);
                        } catch (JSONException e) {
                            throw new RuntimeException(e);
                        }
                    }
                },
                new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {

                    }
                }
        );
        requestQueue.add(stringRequest);
    }

    private User parseJsonUser(String response) throws JSONException {
        JSONObject jsonObject=new JSONObject(response);

        String username=jsonObject.getString("username");
        String address=jsonObject.getString("address");
        String email=jsonObject.getString("email");
        String numberPhone=jsonObject.getString("numberPhone");
        return new User(username,numberPhone,email,address);
    }


    public void getNoti(final NotificationCallback callback){
        RequestQueue requestQueue=Volley.newRequestQueue(context);
        StringRequest stringRequest=new StringRequest(
                Request.Method.GET,
                url,
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        try {
                            String utf8Response = new String(response.getBytes(StandardCharsets.ISO_8859_1), StandardCharsets.UTF_8);
                            List<String> list=parseJsonNoti(utf8Response);
                            callback.onSuccess(list);

                        } catch (JSONException e) {
                            throw new RuntimeException(e);
                        }
                    }
                },
                new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {

                    }
                }
        );
        requestQueue.add(stringRequest);
    }
    private List<String> parseJsonNoti(String response) throws JSONException {
        List<String> list=new ArrayList<>();
        JSONArray jsonArray=new JSONArray(response);

        for(int i=0;i<jsonArray.length();i++){
            JSONObject jsonObject=jsonArray.getJSONObject(i);

            String title=jsonObject.getString("message");
            list.add(title);
        }

        return list;
    }


    public void getDataOrder(final OrderCallback callback){
        RequestQueue requestQueue=Volley.newRequestQueue(context);
        StringRequest stringRequest=new StringRequest(
                Request.Method.GET,
                url,
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        try {
                            Order order=parseJsonOrder(response);
                            callback.onSuccess(order);
                        } catch (JSONException e) {
                            throw new RuntimeException(e);
                        }
                    }
                },
                new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {

                    }
                }
        );
        requestQueue.add(stringRequest);
    }
    private Order parseJsonOrder(String response) throws JSONException {

        JSONObject jsonObject=new JSONObject(response);
        Long id=jsonObject.getLong("id");
        Double total=jsonObject.getDouble("totalAmount");
        String date= jsonObject.getString("orderDate");

        SimpleDateFormat inputFormat = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSSXXX");
        inputFormat.setTimeZone(TimeZone.getTimeZone("UTC"));


        SimpleDateFormat outputFormat = new SimpleDateFormat("dd-MM-yyyy HH:mm");
        outputFormat.setTimeZone(TimeZone.getDefault());
        String orderDate="";
        try {

            Date time = inputFormat.parse(date);
            assert time != null;
            orderDate=outputFormat.format(time);

        } catch (ParseException e) {
            e.printStackTrace();
        }
        return new Order(id,orderDate,total);
    }






}
