package com.example.buyphonesonline.repository;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import com.example.buyphonesonline.dtos.ProductDto;
import com.example.buyphonesonline.handler.DatabaseHandler;
import com.example.buyphonesonline.models.Cart;
import com.example.buyphonesonline.models.Product;

import java.util.ArrayList;
import java.util.List;

public class CartRepository {
    private final DatabaseHandler databaseHandler;
    private final ProductRepository productRepository;

    public CartRepository(DatabaseHandler databaseHandler, ProductRepository productRepository) {
        this.databaseHandler = databaseHandler;
        this.productRepository = productRepository;
    }

    // sua lai cho product.
    public void addProduct(int productId, String username, int count) {
        SQLiteDatabase db = databaseHandler.getWritableDatabase();
        Product product = productRepository.getProductById(productId);
        databaseHandler.getWritableDatabase();
        if (product == null) {
            throw new RuntimeException("Product not found");
        }

        Cart cart = findCartByUsername(username);
        if (cart == null) {
            // Create a new cart
            ContentValues cartValues = new ContentValues();
            cartValues.put(DatabaseHandler.COLUMN_CART_TOTAL_PRICE, 0);
            cartValues.put(DatabaseHandler.COLUMN_CART_USERNAME, username);
            long cartId = db.insert(DatabaseHandler.TABLE_CART, null, cartValues);

            // Insert product into the new cart
            ContentValues cartItemValues = new ContentValues();
            cartItemValues.put(DatabaseHandler.COLUMN_CART_ID, cartId);
            cartItemValues.put(DatabaseHandler.COLUMN_CART_ITEM_PRODUCT_ID, productId);
            cartItemValues.put(DatabaseHandler.COLUMN_CART_ITEM_QUANTITY, count);
            db.insert(DatabaseHandler.TABLE_CART_ITEM, null, cartItemValues);
        } else {
            int cartId = cart.id();
            if (!isProductInCart(cartId, productId)) {

                ContentValues cartItemValues = new ContentValues();
                cartItemValues.put(DatabaseHandler.COLUMN_CART_ID, cartId);
                cartItemValues.put(DatabaseHandler.COLUMN_CART_ITEM_PRODUCT_ID, productId);
                cartItemValues.put(DatabaseHandler.COLUMN_CART_ITEM_QUANTITY, count);
                db.insert(DatabaseHandler.TABLE_CART_ITEM, null, cartItemValues);
            } else {
                // Update the quantity of the existing product in the cart
                updateCartItem(cartId, productId, count);
            }
        }

        db.close();
    }
    public Cart findCartByUsername(String username) {
        SQLiteDatabase db = databaseHandler.getReadableDatabase();
        Cursor cursor = null;
        Cart cart = null;
        cursor = db.rawQuery("SELECT * FROM " + DatabaseHandler.TABLE_CART + " WHERE " + DatabaseHandler.COLUMN_CART_USERNAME + "=?", new String[]{username});
        if(cursor!=null){
            if( cursor.moveToFirst()) {
                cart = new Cart(cursor.getInt(0), cursor.getDouble(1), cursor.getString(2));
            }
        }
        return cart;


    }

    public boolean isProductInCart(int cartId, int productId) {
        SQLiteDatabase db = databaseHandler.getReadableDatabase();
        Cursor cursor = null;
        boolean check = false;
        String query = "SELECT COUNT(*) FROM " + DatabaseHandler.TABLE_CART_ITEM + " WHERE " + DatabaseHandler.COLUMN_CART_ID + " = ? AND " + DatabaseHandler.COLUMN_CART_ITEM_PRODUCT_ID + " = ?";
        cursor = db.rawQuery(query, new String[]{String.valueOf(cartId), String.valueOf(productId)});
        if(cursor != null && cursor.moveToFirst()) {
            check = cursor.getInt(0) > 0;
        }
        return check;
    }

    public void updateCartItem(int cartId, int productId, int quantity) {
        SQLiteDatabase db = databaseHandler.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(DatabaseHandler.COLUMN_CART_ITEM_QUANTITY, quantity);

        String selection = DatabaseHandler.COLUMN_CART_ID + " = ? AND " + DatabaseHandler.COLUMN_CART_ITEM_PRODUCT_ID + " = ?";
        String[] selectionArgs = { String.valueOf(cartId), String.valueOf(productId) };
        db.update(DatabaseHandler.TABLE_CART_ITEM, values, selection, selectionArgs);
    }



    public List<ProductDto> getCartItemsByUsername(String username) {
        SQLiteDatabase db = databaseHandler.getReadableDatabase();
        List<ProductDto> cartItems = new ArrayList<>();

        // Step 1: Get cartId from cart based on username
        Cart cart = getCartFromUsername(username, db);

        // Step 2: Get all cartItems based on cartId
        if (cart!= null) {

            String selection = DatabaseHandler.COLUMN_CART_ID + " = ?";
            String[] selectionArgs = {String.valueOf(cart.id())};

            Cursor cursor = db.query(DatabaseHandler.TABLE_CART_ITEM, null, selection, selectionArgs, null, null, null);

            if (cursor != null && cursor.moveToFirst()) {
                do {
                    int cartItemId = cursor.getInt(cursor.getColumnIndexOrThrow(DatabaseHandler.COLUMN_CART_ITEM_ID));
                    int productId = cursor.getInt(cursor.getColumnIndexOrThrow(DatabaseHandler.COLUMN_CART_ITEM_PRODUCT_ID));
                    int quantity = cursor.getInt(cursor.getColumnIndexOrThrow(DatabaseHandler.COLUMN_CART_ITEM_QUANTITY));
                    Product product=productRepository.getProductById(productId);
                    // Create CartItem object and add to the list
                    ProductDto c = new ProductDto(cartItemId,product.getName(),product.getImage(),product.getPrice(),quantity);
                    cartItems.add(c);
                } while (cursor.moveToNext());

                cursor.close();
            }
        }

        db.close();
        return cartItems;
    }

    private Cart getCartFromUsername(String username,SQLiteDatabase db){
        Cart cart=null;
        String[] projection = {DatabaseHandler.COLUMN_CART_ID};
        String selection = DatabaseHandler.COLUMN_CART_USERNAME + " = ?";
        String[] selectionArgs = {username};

        Cursor cursor = db.query(DatabaseHandler.TABLE_CART, null, selection, selectionArgs, null, null, null);

        if (cursor != null && cursor.moveToFirst()) {
            cart=new Cart(cursor.getInt(0),cursor.getDouble(1),cursor.getString(2));
        }
        cursor.close();
        return cart;
    }







}
