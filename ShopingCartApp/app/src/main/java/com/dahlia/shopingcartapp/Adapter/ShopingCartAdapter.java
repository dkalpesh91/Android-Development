package com.dahlia.shopingcartapp.Adapter;

import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.android.volley.toolbox.ImageLoader;
import com.android.volley.toolbox.NetworkImageView;
import com.dahlia.shopingcartapp.Activity.HomeCatalogActvity;
import com.dahlia.shopingcartapp.Activity.ProductDescriptionActivity;
import com.dahlia.shopingcartapp.Activity.ShopingCartActivity;
import com.dahlia.shopingcartapp.ControllerHelper.AppController;
import com.dahlia.shopingcartapp.Model.ProductCatalog;
import com.dahlia.shopingcartapp.R;

import java.util.List;

/**
 * Created by Admin on 01-06-2016.
 */
public class ShopingCartAdapter extends BaseAdapter {
    List<ProductCatalog> mProductlist = null;
    ProductCatalog mProduct = null;
    String [] result;
    Context context;
    Bitmap[] imageId;
    private static LayoutInflater inflater=null;
    ImageLoader imageLoader = AppController.getInstance().getImageLoader();
    public ShopingCartAdapter(ShopingCartActivity mainActivity, List<ProductCatalog> productList) {
        // TODO Auto-generated constructor stub
        mProductlist = productList;
        context=mainActivity;
        inflater = ( LayoutInflater )context.
                getSystemService(Context.LAYOUT_INFLATER_SERVICE);

    }

    @Override
    public int getCount() {
        return mProductlist.size();
    }

    @Override
    public Object getItem(int position) {
        return position;
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        final Holder holder=new Holder();
        final View rowView;
        rowView = inflater.inflate(R.layout.shoping_cart_product_list_row, null);
        holder.productName=(TextView) rowView.findViewById(R.id.scplr_product_Name_TV);
        holder.productCatagory = (TextView) rowView.findViewById(R.id.scplr_product_Category_TV);
        holder.productCost=(TextView) rowView.findViewById(R.id.scplr_product_price_TV);

        holder.img = (ImageView) rowView.findViewById(R.id.scplr_product_Imageview);

        mProduct = new ProductCatalog();
        mProduct = mProductlist.get(position);
        holder.productCatagory.setText(mProduct.getProductCatagoryInString());
        holder.productCost.setText(mProduct.getProductCostInString());
        holder.productName.setText(mProduct.getProductName());
        holder.img.setImageBitmap(mProduct.getProductImageBitmap());

        return rowView;
    }

    public class Holder
    {
        TextView productName;
        TextView productCost;
        ImageView img;
        TextView productCatagory;
    }
}
