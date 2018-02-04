package com.hackstrangely.hackstrangely.hackstrangely.hackstrangely.hackstrangely.hackstrangely.e_commerce.disease.view;

import android.content.Context;
import android.os.Handler;
import android.support.v4.view.PagerAdapter;
import android.support.v7.widget.CardView;
import android.text.Html;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.hackstrangely.hackstrangely.hackstrangely.hackstrangely.hackstrangely.hackstrangely.e_commerce.R;
import com.hackstrangely.hackstrangely.hackstrangely.hackstrangely.hackstrangely.hackstrangely.e_commerce.disease.model.data.DiseaseData;
import com.hackstrangely.hackstrangely.hackstrangely.hackstrangely.hackstrangely.hackstrangely.e_commerce.helper.image_loaders.GlideImageLoader;
import com.hackstrangely.hackstrangely.hackstrangely.hackstrangely.hackstrangely.hackstrangely.e_commerce.helper.image_loaders.ImageLoader;
import com.tomergoldst.tooltips.ToolTip;
import com.tomergoldst.tooltips.ToolTipsManager;
import com.wang.avi.AVLoadingIndicatorView;

import java.util.ArrayList;
import java.util.List;

public class VerticlePagerAdapter extends PagerAdapter {


    private List<DiseaseData> diseaseData = new ArrayList<>();
    Context mContext;
    LayoutInflater mLayoutInflater;
    private ImageLoader imageLoader;
    private CardView diseaseCard;
    private int length;
    private AVLoadingIndicatorView progressBar;

    public VerticlePagerAdapter(Context context) {
        mContext = context;
        mLayoutInflater = (LayoutInflater) mContext.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        imageLoader=new GlideImageLoader(mContext);
    }

    @Override
    public int getCount() {
        return this.diseaseData.size();
    }

    @Override
    public boolean isViewFromObject(View view, Object object) {
        return view == ((LinearLayout) object);
    }

    void setDiseaseData(List<DiseaseData> diseaseData)
    {
        this.diseaseData = diseaseData;
    }

    @Override
    public Object instantiateItem(ViewGroup container, int position) {
        View itemView = mLayoutInflater.inflate(R.layout.disease_card, container, false);

        diseaseCard = (CardView) itemView.findViewById(R.id.diseaseCard);
        final DiseaseData data= diseaseData.get(position);


        TextView name = (TextView) itemView.findViewById(R.id.name);
        TextView prevention=(TextView)itemView.findViewById(R.id.prevention);
        ImageView image= (ImageView) itemView.findViewById(R.id.image);
        progressBar = (AVLoadingIndicatorView) itemView.findViewById(R.id.progressBar_disease);
        RelativeLayout layout = (RelativeLayout) itemView.findViewById(R.id.disease_relative_layout);

        /*length = (data.getBody()).length();
        if(length>270)
        {
            read_more.setVisibility(View.VISIBLE);
        }
        else
        {
            read_more.setVisibility(View.INVISIBLE);
            read_more.setClickable(false);
        }*/

        imageLoader.loadImage(data.getImage(),image,progressBar);
        name.setText(data.getName());
        prevention.setText(Html.fromHtml(Html.fromHtml(data.getPrevention()).toString()));


        /*read_more.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                FragmentActivity activity = (FragmentActivity)(mContext);
                FragmentManager fm = activity.getSupportFragmentManager();
                ReadMoreDiseaseFragment readMoreDiseaseFragment = new ReadMoreDiseaseFragment();
                readMoreDiseaseFragment.setData(data);
                readMoreDiseaseFragment.show(fm, "read_more");

                *//*
                CustomTabsIntent.Builder builder = new CustomTabsIntent.Builder();
                CustomTabsIntent customTabsIntent = builder.build();
                try {
                    customTabsIntent.launchUrl(mContext, Uri.parse(data.getUrl()));
                }
                catch (Exception e)
                {
                    Toast.makeText(mContext, "Error opening custom tabs", Toast.LENGTH_SHORT).show();
                }
                *//*


            }
        });*/
        container.addView(itemView);





        final ToolTipsManager mToolTipsManager;
        mToolTipsManager = new ToolTipsManager();
        final ToolTip.Builder builder = new ToolTip.Builder(mContext,name,layout, "Swipe up to read next blog." , ToolTip.POSITION_ABOVE);
        builder.setBackgroundColor(R.color.black);

        if(position==0) {
            final Handler handler = new Handler();
            handler.postDelayed(new Runnable() {
                @Override
                public void run() {
                    mToolTipsManager.show(builder.build());
                }
            },3000);
        }


        return itemView;
    }

    @Override
    public void destroyItem(ViewGroup container, int position, Object object) {
        container.removeView((LinearLayout) object);
    }
}
