package com.dahlia.shopingcartapp.Activity;

import android.graphics.Bitmap;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.ImageView;
import android.widget.TextView;

import com.dahlia.shopingcartapp.R;

public class ProductDescriptionActivity extends AppCompatActivity {

    private TextView mProductNameTV = null;
    private TextView mProductDescTV = null;
    private TextView mProductCostTV = null;
    private TextView mProductCatagoryTV = null;
    private ImageView mProductImageIV = null;

    String TAG = "TAG";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_product_description);

        Log.d(TAG,"************OnCreate*************");

        String productName = null;
        String productCost = null;
        String productCatagory = null;
        Bitmap productImage = null;
        String productDescription = null;

//            Bundle extras = getIntent().getExtras();
//            if(extras == null) {
//                productName = null;
//                productImage = null;
//            } else {
//                productName= extras.getString("ProductName");
//                productImage = extras.getParcelable("ProductImage");
//                productDescription = extras.getString("ProductDescription");
//                productCost = extras.getString("ProductPrice");
//                productCatagory = extras.getString("ProductCatagory");
//            }

        mProductNameTV = (TextView)findViewById(R.id.ida_product_name_tv);
        mProductDescTV = (TextView)findViewById(R.id.ida_product_description_tv);
        mProductCatagoryTV = (TextView)findViewById(R.id.ida_product_catagory_tv);
        mProductCostTV = (TextView)findViewById(R.id.ida_product_price_tv);
        mProductImageIV = (ImageView) findViewById(R.id.ida_product_iv);

//        mProductNameTV.setText(productName);
//        mProductDescTV.setText(productDescription);
//        mProductCatagoryTV.setText(productCatagory);
//        mProductCostTV.setText(productCost);
//        mProductImageIV.setImageBitmap(productImage);

    }
}
