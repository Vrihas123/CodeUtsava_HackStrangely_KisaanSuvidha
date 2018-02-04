package com.hackstrangely.hackstrangely.hackstrangely.hackstrangely.hackstrangely.hackstrangely.e_commerce.calculator.view;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.design.widget.TextInputLayout;
import android.support.v4.app.Fragment;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.view.inputmethod.InputMethodManager;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;

import com.hackstrangely.hackstrangely.hackstrangely.hackstrangely.hackstrangely.hackstrangely.e_commerce.R;
import com.hackstrangely.hackstrangely.hackstrangely.hackstrangely.hackstrangely.hackstrangely.e_commerce.calculator.model.CalculatorData;

import com.hackstrangely.hackstrangely.hackstrangely.hackstrangely.hackstrangely.hackstrangely.e_commerce.calculator.presenter.CalculatorPresenter;
import com.hackstrangely.hackstrangely.hackstrangely.hackstrangely.hackstrangely.hackstrangely.e_commerce.calculator.presenter.CalculatorPresenterImpl;
import com.hackstrangely.hackstrangely.hackstrangely.hackstrangely.hackstrangely.hackstrangely.e_commerce.calculator.provider.CalculatorRetrofitProvider;
import com.hackstrangely.hackstrangely.hackstrangely.hackstrangely.hackstrangely.hackstrangely.e_commerce.helper.SharedPrefs;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import java.util.List;

/**
 * A simple {@link Fragment} subclass.
 * Activities that contain this fragment must implement the
 * {@link CalculatorFragment.OnFragmentInteractionListener} interface
 * to handle interaction events.
 * Use the {@link CalculatorFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class CalculatorFragment extends Fragment implements CalculatorView{
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    private OnFragmentInteractionListener mListener;

    @BindView(R.id.spinner_months)
    Spinner spinnerMonths;

    @BindView(R.id.spinner_crops)
    Spinner spinnerCrops;

    @BindView(R.id.spacing)
    TextView spacing;

    @BindView(R.id.seeds)
    TextView seeds;

    @BindView(R.id.bed_size)
    EditText bedSize;

    @BindView(R.id.bed_lines)
    EditText bedLines;

    @BindView(R.id.calculate)
    Button calculate;

    @BindView(R.id.input_layout_bed_size)
    TextInputLayout inputLayoutBedSize;

    @BindView(R.id.input_layout_bed_lines)
    TextInputLayout inputLayoutBedLines;

    ArrayAdapter<String> dataAdapter;
    List<String> list;

    private String size,lines;

    SharedPrefs sharedPrefs;

    CalculatorPresenter calculatorPresenter;

    CalculatorData calculatorData;

    public CalculatorFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment CalculatorFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static CalculatorFragment newInstance(String param1, String param2) {
        CalculatorFragment fragment = new CalculatorFragment();
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
        View view = inflater.inflate(R.layout.fragment_calculator, container, false);
        ButterKnife.bind(this,view);

        spinnerCrops.setVisibility(View.GONE);
        spacing.setVisibility(View.INVISIBLE);
        seeds.setVisibility(View.INVISIBLE);

        spinnerMonths.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                switch(position)
                {
                    case 1:
                        list = Arrays.asList(getResources().getStringArray(R.array.January));
                        dataAdapter = new ArrayAdapter<String>(getContext(),android.R.layout.simple_spinner_item, list);
                        dataAdapter.setDropDownViewResource
                                (android.R.layout.simple_spinner_dropdown_item);
                        spinnerCrops.setAdapter(dataAdapter);
                        spinnerCrops.setVisibility(View.VISIBLE);
                        break;
                    case 2:
                        list = Arrays.asList(getResources().getStringArray(R.array.February));
                        dataAdapter = new ArrayAdapter<String>(getContext(),android.R.layout.simple_spinner_item, list);
                        dataAdapter.setDropDownViewResource
                                (android.R.layout.simple_spinner_dropdown_item);
                        spinnerCrops.setAdapter(dataAdapter);
                        spinnerCrops.setVisibility(View.VISIBLE);
                        break;
                    case 3:
                        list = Arrays.asList(getResources().getStringArray(R.array.March));
                        dataAdapter = new ArrayAdapter<String>(getContext(),android.R.layout.simple_spinner_item, list);
                        dataAdapter.setDropDownViewResource
                                (android.R.layout.simple_spinner_dropdown_item);
                        spinnerCrops.setAdapter(dataAdapter);
                        spinnerCrops.setVisibility(View.VISIBLE);
                        break;
                    case 4:
                        list = Arrays.asList(getResources().getStringArray(R.array.April));
                        dataAdapter = new ArrayAdapter<String>(getContext(),android.R.layout.simple_spinner_item, list);
                        dataAdapter.setDropDownViewResource
                                (android.R.layout.simple_spinner_dropdown_item);
                        spinnerCrops.setAdapter(dataAdapter);
                        spinnerCrops.setVisibility(View.VISIBLE);
                        break;
                    case 5:
                        list = Arrays.asList(getResources().getStringArray(R.array.May));
                        dataAdapter = new ArrayAdapter<String>(getContext(),android.R.layout.simple_spinner_item, list);
                        dataAdapter.setDropDownViewResource
                                (android.R.layout.simple_spinner_dropdown_item);
                        spinnerCrops.setAdapter(dataAdapter);
                        spinnerCrops.setVisibility(View.VISIBLE);
                        break;
                    case 6:
                        list = Arrays.asList(getResources().getStringArray(R.array.June));
                        dataAdapter = new ArrayAdapter<String>(getContext(),android.R.layout.simple_spinner_item, list);
                        dataAdapter.setDropDownViewResource
                                (android.R.layout.simple_spinner_dropdown_item);
                        spinnerCrops.setAdapter(dataAdapter);
                        spinnerCrops.setVisibility(View.VISIBLE);
                        break;
                    case 7:
                        list = Arrays.asList(getResources().getStringArray(R.array.July));
                        dataAdapter = new ArrayAdapter<String>(getContext(),android.R.layout.simple_spinner_item, list);
                        dataAdapter.setDropDownViewResource
                                (android.R.layout.simple_spinner_dropdown_item);
                        spinnerCrops.setAdapter(dataAdapter);
                        spinnerCrops.setVisibility(View.VISIBLE);
                        break;
                    case 8:
                        list = Arrays.asList(getResources().getStringArray(R.array.August));
                        dataAdapter = new ArrayAdapter<String>(getContext(),android.R.layout.simple_spinner_item, list);
                        dataAdapter.setDropDownViewResource
                                (android.R.layout.simple_spinner_dropdown_item);
                        spinnerCrops.setAdapter(dataAdapter);
                        spinnerCrops.setVisibility(View.VISIBLE);
                        break;
                    case 9:
                        list = Arrays.asList(getResources().getStringArray(R.array.September));
                        dataAdapter = new ArrayAdapter<String>(getContext(),android.R.layout.simple_spinner_item, list);
                        dataAdapter.setDropDownViewResource
                                (android.R.layout.simple_spinner_dropdown_item);
                        spinnerCrops.setAdapter(dataAdapter);
                        spinnerCrops.setVisibility(View.VISIBLE);
                        break;
                    case 10:
                        list = Arrays.asList(getResources().getStringArray(R.array.October));
                        dataAdapter = new ArrayAdapter<String>(getContext(),android.R.layout.simple_spinner_item, list);
                        dataAdapter.setDropDownViewResource
                                (android.R.layout.simple_spinner_dropdown_item);
                        spinnerCrops.setAdapter(dataAdapter);
                        spinnerCrops.setVisibility(View.VISIBLE);
                        break;
                    case 11:
                        list = Arrays.asList(getResources().getStringArray(R.array.November));
                        dataAdapter = new ArrayAdapter<String>(getContext(),android.R.layout.simple_spinner_item, list);
                        dataAdapter.setDropDownViewResource
                                (android.R.layout.simple_spinner_dropdown_item);
                        spinnerCrops.setAdapter(dataAdapter);
                        spinnerCrops.setVisibility(View.VISIBLE);
                        break;
                    case 12:
                        list = Arrays.asList(getResources().getStringArray(R.array.December));
                        dataAdapter = new ArrayAdapter<String>(getContext(),android.R.layout.simple_spinner_item, list);
                        dataAdapter.setDropDownViewResource
                                (android.R.layout.simple_spinner_dropdown_item);
                        spinnerCrops.setAdapter(dataAdapter);
                        spinnerCrops.setVisibility(View.VISIBLE);
                        break;
                }

            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });
        spinnerCrops.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {

                sharedPrefs.setCrop(String.valueOf(spinnerCrops.getSelectedItem()));

            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });



        calculate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                    submit();
                spacing.setVisibility(View.VISIBLE);
                spacing.setText("Spacing between seeds should be: "+calculatorData.getSpacing());
                seeds.setVisibility(View.VISIBLE);
                seeds.setText("Number of seeds required per Acre"+calculatorData.getSeeds());
            }
        });

        bedSize.addTextChangedListener(new MyTextWatcher(bedSize));
        bedLines.addTextChangedListener(new MyTextWatcher(bedLines));


        return view;
    }

    public void submit(){
        if (!validateBedSize()){
            return;
        }
        if (!validateBedLines()){
            return;
        }
        calculatorPresenter = new CalculatorPresenterImpl(CalculatorFragment.this,new CalculatorRetrofitProvider());
                calculatorPresenter.requestCalculator("Put bed size here",sharedPrefs.getAccessToken(),"Put Bed lines here",sharedPrefs.getCrop());
        hideKeyboard();
    }

    private void hideKeyboard() {
        View view = getActivity().getCurrentFocus();
        if (view != null) {
            InputMethodManager imm = (InputMethodManager) getActivity().getSystemService(Context.INPUT_METHOD_SERVICE);
            imm.hideSoftInputFromWindow(view.getWindowToken(), 0);
        }
    }

    private void requestFocus(View view) {
        if (view.requestFocus()) {
            getActivity().getWindow().setSoftInputMode(WindowManager.LayoutParams.SOFT_INPUT_STATE_ALWAYS_VISIBLE);
        }
    }

    private boolean validateBedSize(){
        size = bedSize.getText().toString().trim();
        if (size.isEmpty()){
            inputLayoutBedSize.setError(getString(R.string.err_msg_password));
            requestFocus(bedSize);
            return false;
        }else {
            inputLayoutBedLines.setErrorEnabled(false);
        }
        return true;
    }
    private boolean validateBedLines(){
        lines = bedLines.getText().toString().trim();
        if (lines.isEmpty()){
            inputLayoutBedLines.setError(getString(R.string.err_msg_password));
            requestFocus(bedSize);
            return false;
        }else {
            inputLayoutBedLines.setErrorEnabled(false);
        }
        return true;
    }

    private class MyTextWatcher implements TextWatcher {

        private View view;

        private MyTextWatcher(View view) {
            this.view = view;
        }

        public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {
        }

        public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
        }

        public void afterTextChanged(Editable editable) {
            switch (view.getId()) {
                case R.id.input_login_mobile:
                    validateBedSize();
                    break;
                case R.id.input_login_password:
                    validateBedLines();
                    break;
            }
        }
    }




    // TODO: Rename method, update argument and hook method into UI event
    public void onButtonPressed(Uri uri) {
        if (mListener != null) {
            mListener.onFragmentInteraction(uri);
        }
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
    public void showProgressBar(boolean show) {

    }

    @Override
    public void setFinalProductData(List<CalculatorData> calculatorData) {

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
}
