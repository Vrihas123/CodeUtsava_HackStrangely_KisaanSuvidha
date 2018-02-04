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
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.hackstrangely.hackstrangely.hackstrangely.hackstrangely.hackstrangely.hackstrangely.e_commerce.R;
import com.hackstrangely.hackstrangely.hackstrangely.hackstrangely.hackstrangely.hackstrangely.e_commerce.calculator.view.CalculatorFragment;

import com.hackstrangely.hackstrangely.hackstrangely.hackstrangely.hackstrangely.hackstrangely.e_commerce.disease.view.DiseaseFragment;
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
    @BindView(R.id.card5_home)
    CardView card5;
    @BindView(R.id.card6_home)
    CardView card6;

    @BindView(R.id.home_item_name1)
    TextView item1;
    @BindView(R.id.home_item_name2)
    TextView item2;
    @BindView(R.id.home_item_name3)
    TextView item3;
    @BindView(R.id.home_item_name4)
    TextView item4;
    @BindView(R.id.home_item_name5)
    TextView item5;
    @BindView(R.id.home_item_name6)
    TextView item6;

    @BindView(R.id.item1_img)
    ImageView img1;
    @BindView(R.id.item2_img)
    ImageView img2;
    @BindView(R.id.item3_img)
    ImageView img3;
    @BindView(R.id.item4_img)
    ImageView img4;
    @BindView(R.id.item5_img)
    ImageView img5;
    @BindView(R.id.item6_img)
    ImageView img6;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        ButterKnife.bind(this);
        //setFragment(new CalculatorFragment());


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
                addFragment(new DiseaseFragment());
            }
        });
        Glide.with(this).load("http://www.asianentrepreneur.org/wp-content/uploads/2014/08/Agricultural-India.jpg").into(img1);
        Glide.with(this).load("https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcS_0dP1tu3-C01x-TcGxKrorC5t7Bf5fz3rDtKQvZzLO0QfmKw6").into(img2);
        Glide.with(this).load("https://www.unionbankofindia.co.in/images/RURALAGRI.jpg").into(img3);
        Glide.with(this).load("http://ipm.uconn.edu/documents/raw2/html/images/clip_image002_071.jpg").into(img4);
        Glide.with(this).load("http://www.jayalaxmiagrotech.com/images/TimesofIndiaHubballiEdition02102015.jpg").into(img5);
        Glide.with(this).load("https://comtechies.com/wp-content/uploads/2017/07/discussion-forum-like-stackoverflow.jpg").into(img6);

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
