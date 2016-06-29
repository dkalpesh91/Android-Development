package com.dahlia.shopingcartapp.Adapter;

import java.util.List;

import com.android.volley.toolbox.ImageLoader;
import com.android.volley.toolbox.NetworkImageView;
import com.dahlia.shopingcartapp.Activity.HomeCatalogActvity;
import com.dahlia.shopingcartapp.Activity.ProductDescriptionActivity;
import com.dahlia.shopingcartapp.Constant.ConstantUrl;
import com.dahlia.shopingcartapp.ControllerHelper.AppController;
import com.dahlia.shopingcartapp.Model.ProductCatalog;
import com.dahlia.shopingcartapp.R;

import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.support.v4.view.PagerAdapter;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;



/**
 * Created by Admin on 01-06-2016.
 */
public class CustomPagerAdapter extends PagerAdapter {

    Context mContext = null;
    List<ProductCatalog> mProductList = null;
    LayoutInflater mLayoutInflater = null;

    ImageLoader imageLoader = AppController.getInstance().getImageLoader();

    String mProductName[] = {"Meluha","Reebok","king","WildLife","demo"};

    public CustomPagerAdapter(HomeCatalogActvity homeCatalogActvity , List<ProductCatalog> list){
         mContext = homeCatalogActvity;
         mProductList = list;
    }

    @Override
    public int getCount() {
        return mProductList.size();
    }

    @Override
    public boolean isViewFromObject(View view, Object object) {
        return (view == (LinearLayout)object);
    }

    @Override
    public Object instantiateItem(ViewGroup container, final int position) {

        mLayoutInflater = (LayoutInflater) mContext.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View v = mLayoutInflater.inflate(R.layout.swipe_product_list,container,false);

        ProductCatalog productCatalog = new ProductCatalog();
        productCatalog = mProductList.get(position);

        imageLoader = AppController.getInstance().getImageLoader();

        final TextView productName = (TextView) v.findViewById(R.id.spl_product_Name_TV);
        productName.setText(productCatalog.getProductName());

        final TextView productCatagory = (TextView) v.findViewById(R.id.spl_product_Category_TV);
        productCatagory.setText(getCatagory(productCatalog.getProductCategory()));

        final TextView productPrice = (TextView) v.findViewById(R.id.spl_product_price_TV);
        productPrice.setText(Float.toString(productCatalog.getProductCost()));

        final NetworkImageView productImage = (NetworkImageView) v.findViewById(R.id.spl_product_Imageview);
        productImage.setImageUrl(productCatalog.getProductImageUrl(), imageLoader);


        container.addView(v);

        v.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ProductCatalog productCatalog1 = new ProductCatalog();

                productCatalog1 = mProductList.get(position);

                productImage.buildDrawingCache();
                Bitmap bitmap = productImage.getDrawingCache();
                Intent intent = new Intent(mContext, ProductDescriptionActivity.class);
                intent.putExtra("ProductImage", bitmap);
                intent.putExtra("ProductName", productName.getText().toString());
                intent.putExtra("ProductDescription",productCatalog1.getProductDetails() );
                intent.putExtra("ProductCatagory", productCatagory.getText().toString());
                intent.putExtra("ProductPrice", productPrice.getText().toString());
                mContext.startActivity(intent);
            }
        });

        return v;
    }

    @Override
    public void destroyItem(ViewGroup container, int position, Object object) {
        container.removeView((LinearLayout)object);
    }



    String getCatagory(int catagoryId){
        String catagory = null;
        switch(catagoryId){
            case 8801 :
                catagory = ConstantUrl.CATAGORY1;
                break;
            case 8802 :
                catagory = ConstantUrl.CATAGORY2;
                break;
            case 8803 :
                catagory = ConstantUrl.CATAGORY3;
                break;
            case 8804 :
                catagory = ConstantUrl.CATAGORY4;
                break;
        }
        return catagory;
    }
}
