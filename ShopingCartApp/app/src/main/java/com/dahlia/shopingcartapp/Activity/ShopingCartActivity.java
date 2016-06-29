package com.dahlia.shopingcartapp.Activity;

import android.graphics.Bitmap;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ListView;

import com.dahlia.shopingcartapp.Adapter.MyCustomAdapter;
import com.dahlia.shopingcartapp.Adapter.ShopingCartAdapter;
import com.dahlia.shopingcartapp.Model.ProductCatalog;
import com.dahlia.shopingcartapp.R;

import java.util.ArrayList;
import java.util.List;

public class ShopingCartActivity extends AppCompatActivity {

    List<ProductCatalog> mProduct = null;
    ProductCatalog mProductCatalog = null;
    ShopingCartAdapter mAdapter = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_shoping_cart);

        mProduct = new ArrayList<ProductCatalog>();
        mProductCatalog = new ProductCatalog();



        String productName = null;
        String productCost = null;
        String productCatagory = null;
        Bitmap productImage = null;
        String productDescription = null;

        Bundle extras = getIntent().getExtras();
        if(extras != null) {
            productName= extras.getString("ProductName");
            productImage = extras.getParcelable("ProductImage");
            productDescription = extras.getString("ProductDescription");
            productCost = extras.getString("ProductPrice");
            productCatagory = extras.getString("ProductCatagory");

            mProductCatalog.setProductName(productName);
            mProductCatalog.setProductImageBitmap(productImage);
            mProductCatalog.setProductCostInString(productCost);
            mProductCatalog.setProductCatagoryInString(productCatagory);
            mProductCatalog.setProductDetails(productDescription);

            mProduct.add(mProductCatalog);




            ListView listView = (ListView) findViewById(R.id.shoppingCartListview);
            mAdapter = new ShopingCartAdapter(this,mProduct);
            listView.setAdapter(mAdapter);

        }



    }
}
