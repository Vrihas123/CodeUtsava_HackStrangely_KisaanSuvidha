package com.hackstrangely.hackstrangely.hackstrangely.hackstrangely.hackstrangely.hackstrangely.e_commerce.products.view;

import android.content.Context;
import android.support.v4.app.FragmentActivity;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.hackstrangely.hackstrangely.hackstrangely.hackstrangely.hackstrangely.hackstrangely.e_commerce.R;
import com.hackstrangely.hackstrangely.hackstrangely.hackstrangely.hackstrangely.hackstrangely.e_commerce.helper.SharedPrefs;
import com.hackstrangely.hackstrangely.hackstrangely.hackstrangely.hackstrangely.hackstrangely.e_commerce.home.HomeActivity;
import com.hackstrangely.hackstrangely.hackstrangely.hackstrangely.hackstrangely.hackstrangely.e_commerce.products.model.ProductData;
import com.hackstrangely.hackstrangely.hackstrangely.hackstrangely.hackstrangely.hackstrangely.e_commerce.sub_products.view.SubProductsFragment;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by samveg on 24/8/17.
 */

public class ProductAdapter extends RecyclerView.Adapter<ProductAdapter.ViewHolder>{

    private List<ProductData> productData = new ArrayList<>();
    private LayoutInflater layoutInflater;
    Context context;
    SharedPrefs sharedPrefs;

    public ProductAdapter(Context context){

        this.context = context;
        layoutInflater = LayoutInflater.from(context);

    }

    public void setProductData(List<ProductData> productData){
        this.productData = productData;
    }

    @Override
    public ProductAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        View view = layoutInflater.inflate(R.layout.product_recycler_items,parent,false);
        sharedPrefs = new SharedPrefs(context);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(final ViewHolder holder, int position) {

        final ProductData productData1 = productData.get(position);
        holder.productName.setText(productData1.getProduct_type());
        Glide.with(context).load(productData1.getImage_url()).into(holder.productImage);
        holder.subProductCard.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                sharedPrefs.setProduct(productData1.getProduct_type().toString());
//                ((HomeActivity)context).addFragment(new SubProductsFragment());
                ((FragmentActivity)context).getSupportFragmentManager().beginTransaction()
                        .replace(R.id.container_body, new SubProductsFragment())
                        .addToBackStack(null)
                        .commit();
            }
        });

    }

    @Override
    public int getItemCount() {
        return productData.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder{

        public ImageView productImage;
        public TextView productName;
        RelativeLayout subProductCard;

        public ViewHolder(View itemView) {
            super(itemView);
            productImage = itemView.findViewById(R.id.product_image);
            productName = itemView.findViewById(R.id.product_type);
            subProductCard = (RelativeLayout) itemView.findViewById(R.id.sub_product_card);
        }
    }
}
