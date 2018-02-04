package com.hackstrangely.hackstrangely.hackstrangely.hackstrangely.hackstrangely.hackstrangely.e_commerce.home;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.hackstrangely.hackstrangely.hackstrangely.hackstrangely.hackstrangely.hackstrangely.e_commerce.R;
import com.hackstrangely.hackstrangely.hackstrangely.hackstrangely.hackstrangely.hackstrangely.e_commerce.calculator.view.CalculatorFragment;
import com.hackstrangely.hackstrangely.hackstrangely.hackstrangely.hackstrangely.hackstrangely.e_commerce.products.view.ProductActivity;
import com.hackstrangely.hackstrangely.hackstrangely.hackstrangely.hackstrangely.hackstrangely.e_commerce.products.view.ProductFragment;
import com.hackstrangely.hackstrangely.hackstrangely.hackstrangely.hackstrangely.hackstrangely.e_commerce.schemes.view.SchemesFragment;

import java.util.List;

/**
 * Created by vrihas on 4/2/18.
 */

public class HomeAdapter extends RecyclerView.Adapter<HomeAdapter.ViewHolder> {
    private List<HomeData> homeData;
    Context context;

    public HomeAdapter(List<HomeData> homeData) {
        this.homeData = homeData;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.home_item, parent, false);

        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, final int position) {
        HomeData homeData1 = homeData.get(position);
        holder.item_title.setText(homeData1.getTitle());
        holder.cardView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
               if (position==0){
                   ((FragmentActivity)context).getSupportFragmentManager().beginTransaction()
                           .replace(R.id.container_body, new ProductFragment())
                           .addToBackStack(null)
                           .commit();
                }
                else if (position==1){
                   ((FragmentActivity)context).getSupportFragmentManager().beginTransaction()
                           .replace(R.id.container_body, new CalculatorFragment())
                           .addToBackStack(null)
                           .commit();
                } else if (position == 2) {
                   //((HomeActivity)context).addFragment(new CalculatorFragment());
               }else if (position==3){
                   ((FragmentActivity)context).getSupportFragmentManager().beginTransaction()
                           .replace(R.id.container_body, new SchemesFragment())
                           .addToBackStack(null)
                           .commit();
               }
            }
        });
    }

    @Override
    public int getItemCount() {
     return  homeData.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder{

        TextView item_title;
        CardView cardView;

        public ViewHolder(View itemView) {
            super(itemView);
            item_title = (TextView) itemView.findViewById(R.id.home_item_name);
            cardView = (CardView) itemView.findViewById(R.id.card_home);
        }
    }
}

