package com.dahlia.shopingcartapp.Adapter;


        import android.content.Context;
        import android.content.Intent;
        import android.graphics.Bitmap;
        import android.view.LayoutInflater;
        import android.view.View;
        import android.view.ViewGroup;
        import android.widget.BaseAdapter;
        import android.widget.Button;
        import android.widget.TextView;

        import com.android.volley.toolbox.ImageLoader;
        import com.android.volley.toolbox.NetworkImageView;
        import com.dahlia.shopingcartapp.Activity.ProductDescriptionActivity;
        import com.dahlia.shopingcartapp.Constant.ConstantUrl;
        import com.dahlia.shopingcartapp.ControllerHelper.AppController;
        import com.dahlia.shopingcartapp.Activity.HomeCatalogActvity;
        import com.dahlia.shopingcartapp.Model.ProductCatalog;
        import com.dahlia.shopingcartapp.R;
        import com.dahlia.shopingcartapp.Activity.ShopingCartActivity;

        import java.util.List;

/**
 * Created by Admin on 18-05-2016.
 */
public class MyCustomAdapter extends BaseAdapter {
    List<ProductCatalog> mProductlist = null;
    ProductCatalog mProduct = null;
    String [] result;
    Context context;
    Bitmap[] imageId;
    private static LayoutInflater inflater=null;
    ImageLoader imageLoader = AppController.getInstance().getImageLoader();
    public MyCustomAdapter(HomeCatalogActvity mainActivity, List<ProductCatalog> productList) {
        // TODO Auto-generated constructor stub
        mProductlist = productList;
        context=mainActivity;
        inflater = ( LayoutInflater )context.
                getSystemService(Context.LAYOUT_INFLATER_SERVICE);

    }
    @Override
    public int getCount() {
        // TODO Auto-generated method stub
        return mProductlist.size();
    }

    @Override
    public Object getItem(int position) {
        // TODO Auto-generated method stub
        return position;
    }

    @Override
    public long getItemId(int position) {
        // TODO Auto-generated method stub
        return position;
    }


    public class Holder
    {
        TextView productName;
        TextView productCost;
        NetworkImageView img;
        Button buyBtn;
        TextView productCatagory;
    }
    @Override
    public View getView(final int position, View convertView, ViewGroup parent) {
        // TODO Auto-generated method stub
        final Holder holder=new Holder();
        final View rowView;
        rowView = inflater.inflate(R.layout.product_list_row, null);
        holder.productName=(TextView) rowView.findViewById(R.id.product_Name_TV);
        holder.buyBtn = (Button) rowView.findViewById(R.id.plr_buy_btn);
        holder.productCatagory = (TextView) rowView.findViewById(R.id.product_Category_TV);
        holder.productCost=(TextView) rowView.findViewById(R.id.product_price_TV);


        imageLoader = AppController.getInstance().getImageLoader();
        holder.img = (NetworkImageView) rowView.findViewById(R.id.product_Imageview);

        mProduct = new ProductCatalog();
        mProduct = mProductlist.get(position);

        holder.productCatagory.setText(getCatagory(mProduct.getProductCategory()));
        holder.productCost.setText(Float.toString(mProduct.getProductCost()));
        holder.productName.setText(mProduct.getProductName());
        holder.img.setImageUrl(mProduct.getProductImageUrl(), imageLoader);



        holder.buyBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                holder.img.buildDrawingCache();
                Bitmap bitmap1 = holder.img.getDrawingCache();

                Intent intent = new Intent(context , ShopingCartActivity.class);
                intent.putExtra("ProductImage", bitmap1);
                intent.putExtra("ProductName", holder.productName.getText().toString());
                intent.putExtra("ProductCatagory", holder.productCatagory.getText().toString());
                intent.putExtra("ProductPrice", holder.productCost.getText().toString());
                context.startActivity(intent);
            }
        });


        rowView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // TODO Auto-generated method stub

                mProduct = new ProductCatalog();

                mProduct = mProductlist.get(position);

                holder.img.buildDrawingCache();
                Bitmap bitmap = holder.img.getDrawingCache();
                String productName = holder.productName.getText().toString();
                Intent intent = new Intent(context, ProductDescriptionActivity.class);
                intent.putExtra("ProductImage", bitmap);
                intent.putExtra("ProductName", holder.productName.getText().toString());
                intent.putExtra("ProductDescription",mProduct.getProductDetails() );
                intent.putExtra("ProductCatagory", holder.productCatagory.getText().toString());
                intent.putExtra("ProductPrice", holder.productCost.getText().toString());
                context.startActivity(intent);

            }
        });
        return rowView;
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
