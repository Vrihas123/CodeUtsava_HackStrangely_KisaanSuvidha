package com.hackstrangely.hackstrangely.hackstrangely.hackstrangely.hackstrangely.hackstrangely.e_commerce.schemes.view;

import android.content.Context;
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
import com.hackstrangely.hackstrangely.hackstrangely.hackstrangely.hackstrangely.hackstrangely.e_commerce.schemes.model.SchemesData;
import com.hackstrangely.hackstrangely.hackstrangely.hackstrangely.hackstrangely.hackstrangely.e_commerce.sub_products.view.SubProductsFragment;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by samveg on 24/8/17.
 */

public class SchemesAdapter extends RecyclerView.Adapter<SchemesAdapter.ViewHolder>{

    private List<SchemesData> schemesData = new ArrayList<>();
    private LayoutInflater layoutInflater;
    Context context;
    SharedPrefs sharedPrefs;

    public SchemesAdapter(Context context){

        this.context = context;
        layoutInflater = LayoutInflater.from(context);

    }

    public void setProductData(List<SchemesData> schemesData){
        this.schemesData = schemesData;
    }

    @Override
    public SchemesAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        View view = layoutInflater.inflate(R.layout.schemes_item,parent,false);
        sharedPrefs = new SharedPrefs(context);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(final ViewHolder holder, int position) {

        final SchemesData schemesData1 = schemesData.get(position);
        holder.schemeName.setText(schemesData1.getScheme());
        holder.schemeMinistry.setText(schemesData1.getMinistry());
        holder.schemeDesc.setText(schemesData1.getObjective());
    }

    @Override
    public int getItemCount() {
        return schemesData.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder{

       TextView schemeName,schemeMinistry,schemeDesc;

        public ViewHolder(View itemView) {
            super(itemView);
            schemeName = (TextView) itemView.findViewById(R.id.scheme_name);
            schemeMinistry = (TextView) itemView.findViewById(R.id.scheme_ministry);
            schemeDesc = (TextView) itemView.findViewById(R.id.scheme_description);
        }
    }
}
