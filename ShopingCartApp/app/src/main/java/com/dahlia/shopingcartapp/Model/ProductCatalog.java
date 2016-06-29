package com.dahlia.shopingcartapp.Model;

import android.graphics.Bitmap;

/**
 * Created by Admin on 25-05-2016.
 */
public class ProductCatalog {

    private String productName;
    private int productId;
    private int productCategory;
    private String productDetails;
    private String productImageUrl;
    private float productCost;

    private String productCatagoryInString = null;
    private Bitmap productImageBitmap = null;
    private String productCostInString = null;

    public String getProductCostInString() {
        return productCostInString;
    }

    public void setProductCostInString(String productCostInString) {
        this.productCostInString = productCostInString;
    }

    public Bitmap getProductImageBitmap() {
        return productImageBitmap;
    }

    public void setProductImageBitmap(Bitmap productImageBitmap) {
        this.productImageBitmap = productImageBitmap;
    }


    public String getProductCatagoryInString() {
        return productCatagoryInString;
    }

    public void setProductCatagoryInString(String productCatagoryInString) {
        this.productCatagoryInString = productCatagoryInString;
    }

    public int getProductCategory() {
        return productCategory;
    }

    public void setProductCategory(int productCategory) {
        this.productCategory = productCategory;
    }


    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public int getProductId() {
        return productId;
    }

    public void setProductId(int productId) {
        this.productId = productId;
    }

    public String getProductDetails() {
        return productDetails;
    }

    public void setProductDetails(String productDetails) {
        this.productDetails = productDetails;
    }

    public String getProductImageUrl() {
        return productImageUrl;
    }

    public void setProductImageUrl(String productImageUrl) {
        this.productImageUrl = productImageUrl;
    }

    public float getProductCost() {
        return productCost;
    }

    public void setProductCost(float productCost) {
        this.productCost = productCost;
    }
}
