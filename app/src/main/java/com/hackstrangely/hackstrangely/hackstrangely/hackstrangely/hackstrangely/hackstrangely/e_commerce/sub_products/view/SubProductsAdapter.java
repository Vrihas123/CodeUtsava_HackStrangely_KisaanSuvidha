package com.hackstrangely.hackstrangely.hackstrangely.hackstrangely.hackstrangely.hackstrangely.e_commerce.sub_products.view;

import android.content.Context;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.hackstrangely.hackstrangely.hackstrangely.hackstrangely.hackstrangely.hackstrangely.e_commerce.R;
import com.hackstrangely.hackstrangely.hackstrangely.hackstrangely.hackstrangely.hackstrangely.e_commerce.helper.image_loaders.GlideImageLoader;
import com.hackstrangely.hackstrangely.hackstrangely.hackstrangely.hackstrangely.hackstrangely.e_commerce.sub_products.model.SubProductsData;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by vrihas on 3/2/18.
 */

public class SubProductsAdapter extends RecyclerView.Adapter<SubProductsAdapter.ViewHolder>{

    private LayoutInflater layoutInflater;
    Context context;
    private List<SubProductsData> subProductsDataList = new ArrayList<>();

    public SubProductsAdapter(Context context) {
        layoutInflater = LayoutInflater.from(context);
        this.context = context;
    }

    public void setSubProductsDataList(List<SubProductsData> subProductsDataList){
        this.subProductsDataList = subProductsDataList;
    }
    @Override
    public SubProductsAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view=layoutInflater.inflate(R.layout.sub_products_item,parent,false);

        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(SubProductsAdapter.ViewHolder holder, int position) {
        final SubProductsData subProductsData = subProductsDataList.get(position);
        holder.productName.setText(subProductsData.getProduct_name());
        holder.productPrice.setText(subProductsData.getProduct_price());
        Glide.with(context).load(subProductsData.getProduct_image()).into(holder.productImage);
    }

    @Override
    public int getItemCount() {
        return subProductsDataList.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder{
            TextView productName,productPrice;
            ImageView productImage;
            CardView cardView_sub_products;

        public ViewHolder(View itemView){
            super(itemView);
        productName = (TextView) itemView.findViewById(R.id.product_name);
        productImage = (ImageView) itemView.findViewById(R.id.product_img);
        productPrice = (TextView) itemView.findViewById(R.id.product_price);
        cardView_sub_products = (CardView) itemView.findViewById(R.id.sub_product_card);
        }
    }
}
