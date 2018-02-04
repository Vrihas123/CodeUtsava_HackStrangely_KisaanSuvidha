package com.hackstrangely.hackstrangely.hackstrangely.hackstrangely.hackstrangely.hackstrangely.e_commerce.home;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.CardView;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;

import com.hackstrangely.hackstrangely.hackstrangely.hackstrangely.hackstrangely.hackstrangely.e_commerce.R;
import com.hackstrangely.hackstrangely.hackstrangely.hackstrangely.hackstrangely.hackstrangely.e_commerce.calculator.view.CalculatorFragment;

import com.hackstrangely.hackstrangely.hackstrangely.hackstrangely.hackstrangely.hackstrangely.e_commerce.products.view.ProductFragment;
import com.hackstrangely.hackstrangely.hackstrangely.hackstrangely.hackstrangely.hackstrangely.e_commerce.schemes.view.SchemesFragment;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

import static com.hackstrangely.hackstrangely.hackstrangely.hackstrangely.hackstrangely.hackstrangely.e_commerce.helper.MyApplication.getContext;


public class HomeActivity extends AppCompatActivity {

//    private RecyclerView recyclerView;
//    private HomeAdapter homeAdapter;
//    private List<HomeData> homeData = new ArrayList<>();

    @BindView(R.id.card1_home)
    CardView card1;
    @BindView(R.id.card2_home)
    CardView card2;
    @BindView(R.id.card3_home)
    CardView card3;
    @BindView(R.id.card4_home)
    CardView card4;

    @BindView(R.id.home_item_name1)
    TextView item1;
    @BindView(R.id.home_item_name2)
    TextView item2;
    @BindView(R.id.home_item_name3)
    TextView item3;
    @BindView(R.id.home_item_name4)
    TextView item4;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        ButterKnife.bind(this);
        setFragment(new CalculatorFragment());


        card1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                addFragment(new ProductFragment());
            }
        });
        card2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                addFragment(new CalculatorFragment());
            }
        });
        card3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                addFragment(new SchemesFragment());
            }
        });
        card4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {




            }
        });
//        //setFragment(new HomeFragment());
//
//        recyclerView = (RecyclerView) findViewById(R.id.recycler_view_home);
//        homeAdapter = new HomeAdapter(homeData);
//        RecyclerView.LayoutManager mLayoutManager = new LinearLayoutManager(getContext());
//        recyclerView.setLayoutManager(mLayoutManager);
//        recyclerView.setItemAnimator(new DefaultItemAnimator());
//        recyclerView.setAdapter(homeAdapter);
//        addItems();
    }

//    public void addItems(){
//        HomeData data = new HomeData("Products");
//        homeData.add(data);
//
//        data = new HomeData("Calculator");
//        homeData.add(data);
//
//        data = new HomeData("Diseases");
//        homeData.add(data);
//
//        data = new HomeData("Schemes");
//        homeData.add(data);
//
//        data = new HomeData("News");
//        homeData.add(data);
//
//        data = new HomeData("Benefits of Organic Farming");
//        homeData.add(data);
//
//        data = new HomeData("Discussion Forum");
//        homeData.add(data);
//
//        homeAdapter.notifyDataSetChanged();


    public void setFragment(Fragment fragment) {
        if (fragment != null) {
            FragmentManager fragmentManager = getSupportFragmentManager();
            FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
            fragmentTransaction.replace(R.id.container, fragment);
            fragmentTransaction.commit();
        }
    }


    public void addFragment(Fragment fragment) {
        if (fragment != null) {
            FragmentManager fragmentManager = getSupportFragmentManager();
            FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
            fragmentTransaction.replace(R.id.container, fragment);
            fragmentTransaction.addToBackStack(null);
            fragmentTransaction.commit();
        }

    }


}
