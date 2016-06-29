package com.dahlia.shopingcartapp.Singlton;

/**
 * Created by Admin on 01-06-2016.
 */

public class ShopingCartSingleton {
    private static ShopingCartSingleton mInstance = null;

    private String mString;

    private ShopingCartSingleton(){
        mString = "Hello";
    }

    public static ShopingCartSingleton getInstance(){
        if(mInstance == null)
        {
            mInstance = new ShopingCartSingleton();
        }
        return mInstance;
    }

    public String getString(){
        return this.mString;
    }

    public void setString(String value){
        mString = value;
    }
}