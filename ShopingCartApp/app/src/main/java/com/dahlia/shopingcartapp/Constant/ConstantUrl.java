package com.dahlia.shopingcartapp.Constant;

/**
 * Created by Admin on 25-05-2016.
 */
public class ConstantUrl {

    public static String HOST_URL = "http://192.168.0.107:8082";
    public static String LOGIN_CREDENTIALS_SUB_URL = "/api/Customer/GetCustomerDetails";
    public static String USER_REGISTER_SUB_URL = "/api/Customer/PostCustomer";
    public static String FORGATE_PASSWORD_SUB_URL = "/api/Customer/ForgetPassword";
    public static String FETCH_PRODUCT_CATALOG_SUB_URL = "/api/Products/Get";
    public static String SAVE_QUANTITY_SUB_URL = "/api/ShoppingCart/UpdateShoppingCartDetails";
    public static String ADD_ITEM_IN_CART_SUB_URL = "/api/ShoppingCart/PostShoppingCart";
    public static String SHOW_ITEM_FROM_CART_SUB_URL = "/api/ShoppingCart/GetShoppingCart";
    public static String DELETE_SINGLE_ITEM_SUB_URL = "/api/ShoppingCart/DeleteShoppingCartItems";
    public static String DELETE_ALL_ITEM_SUB_URL = "/api/ShoppingCart/DeleteShoppingCart";
    public static String ORDER_HISTORY_SUB_URL = "/api/Orders/GetOrdersHistory";
    public static String POST_NEW_ORDER_SUB_URL = "/api/Orders/PostOrder";
    public static String GRAND_TOTAL_SUB_URL = "/api/ShoppingCart/GrandTotal";
    public static String RECENT_ORDER_SUB_URL = "/api/Orders/GetOrder";
    public static String USER_DETAILS_SUB_URL = "/api/Customer/GetCustomer";

    //***************************Category Constant**********************//
    public static String CATAGORY1 = "Book";
    public static String CATAGORY2 = "Sport";
    public static String CATAGORY3 = "Music";
    public static String CATAGORY4 = "Movie";


}
