package com.hackstrangely.hackstrangely.hackstrangely.hackstrangely.hackstrangely.hackstrangely.e_commerce.disease.view;

import android.app.Dialog;
import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.design.widget.CoordinatorLayout;
import android.support.design.widget.FloatingActionButton;
import android.support.v4.app.DialogFragment;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.widget.CardView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ProgressBar;

import com.hackstrangely.hackstrangely.hackstrangely.hackstrangely.hackstrangely.hackstrangely.e_commerce.R;
import com.hackstrangely.hackstrangely.hackstrangely.hackstrangely.hackstrangely.hackstrangely.e_commerce.disease.model.RetrofitDiseaseProvider;
import com.hackstrangely.hackstrangely.hackstrangely.hackstrangely.hackstrangely.hackstrangely.e_commerce.disease.model.data.DiseaseList;
import com.hackstrangely.hackstrangely.hackstrangely.hackstrangely.hackstrangely.hackstrangely.e_commerce.disease.presenter.DiseasePresenter;
import com.hackstrangely.hackstrangely.hackstrangely.hackstrangely.hackstrangely.hackstrangely.e_commerce.disease.presenter.DiseasePresenterImpl;
import com.hackstrangely.hackstrangely.hackstrangely.hackstrangely.hackstrangely.hackstrangely.e_commerce.helper.SharedPrefs;
import com.hackstrangely.hackstrangely.hackstrangely.hackstrangely.hackstrangely.hackstrangely.e_commerce.helper.VerticalViewPager;


/**
 * A simple {@link Fragment} subclass.
 * Activities that contain this fragment must implement the
 * {@link DiseaseFragment.OnFragmentInteractionListener} interface
 * to handle interaction events.
 * Use the {@link DiseaseFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class DiseaseFragment extends Fragment implements DiseaseInterface {


    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    VerticalViewPager verticalViewPager;
    VerticlePagerAdapter verticlePagerAdapter;
    DiseasePresenter diseasePresenter;
    private ProgressBar progressBar;
    private CardView card_default_blogs;

    private FloatingActionButton fab;
    private CoordinatorLayout layout;

    SharedPrefs sharedPrefs;

    Dialog dialog;
    private OnFragmentInteractionListener mListener;

    public DiseaseFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment DiseaseFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static DiseaseFragment newInstance(String param1, String param2) {
        DiseaseFragment fragment = new DiseaseFragment();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);

        }
    }




    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {


        // Inflate the layout for this fragment
        View view= inflater.inflate(R.layout.fragment_disease, container, false);

        sharedPrefs = new SharedPrefs(getContext());


        layout = (CoordinatorLayout) view.findViewById(R.id.coordinator_layout_blog);

        card_default_blogs = (CardView) view.findViewById(R.id.card_coming_soon_blogs);
        progressBar=(ProgressBar)view.findViewById(R.id.disease_progress_bar);
        verticalViewPager=(VerticalViewPager)view.findViewById(R.id.disease_viewPager);
        verticlePagerAdapter=new VerticlePagerAdapter(getContext());
        verticalViewPager.setAdapter(verticlePagerAdapter);
        diseasePresenter = new DiseasePresenterImpl(new RetrofitDiseaseProvider(),this);
//          blogsPresenter=new DiseasePresenterImpl(new MockBlogs(),this);
        diseasePresenter.requestDisease(sharedPrefs.getAccessToken());
        return view;
    }

    // TODO: Rename method, update argument and hook method into UI event
    public void onButtonPressed(Uri uri) {
        if (mListener != null) {
            mListener.onFragmentInteraction(uri);
        }
    }


    @Override
    public void onStop() {
        super.onStop();

    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
    }

    @Override
    public void onDetach() {
        super.onDetach();
        mListener = null;
    }

    @Override
    public void setData(DiseaseList diseaseList) {
        verticlePagerAdapter.setDiseaseData(diseaseList.getDisease());
        verticlePagerAdapter.notifyDataSetChanged();
    }

    @Override
    public void showMessage(String message) {

    }

    @Override
    public void showProgressBar(boolean show) {
        if(show)
            progressBar.setVisibility(View.VISIBLE);
        else
            progressBar.setVisibility(View.GONE);
    }

    @Override
    public void showDefault(boolean show) {
        if (show){
            card_default_blogs.setVisibility(View.VISIBLE);
        }
    }

    /**
     * This interface must be implemented by activities that contain this
     * fragment to allow an interaction in this fragment to be communicated
     * to the activity and potentially other fragments contained in that
     * activity.
     * <p>
     * See the Android Training lesson <a href=
     * "http://developer.android.com/training/basics/fragments/communicating.html"
     * >Communicating with Other Fragments</a> for more information.
     */
    public interface OnFragmentInteractionListener {
        // TODO: Update argument type and name
        void onFragmentInteraction(Uri uri);
    }

   /* public void checkNetwork()
    {
        if(!NetworkUtils.isNetworkAvailable(getContext())){
            dialog = new Dialog(getActivity());
            dialog.setContentView(R.layout.activity_rules__dialog_box);
            Button btn = (Button) dialog.findViewById(R.id.dialog_button);
            TextView rules5 = (TextView) dialog.findViewById(R.id.rules5);
            btn.setText("Retry");
            rules5.setText("No internet connection.Please try again.");
            dialog.setTitle("Connectivity Failed");
            dialog.setCancelable(false);
            dialog.show();
            btn.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {

                        blogsPresenter=new DiseasePresenterImpl(new RetrofitDiseaseProvider(),DiseaseFragment.this);
                        blogsPresenter.requestBlogs();
                        dialog.dismiss();
                }
            });
        }
    }*/

}
