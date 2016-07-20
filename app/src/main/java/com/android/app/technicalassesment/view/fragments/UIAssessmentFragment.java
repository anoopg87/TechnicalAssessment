package com.android.app.technicalassesment.view.fragments;


import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.android.app.technicalassesment.App;
import com.android.app.technicalassesment.R;
import com.android.app.technicalassesment.databinding.UiAssessmentFragmentLayoutBinding;
import com.android.app.technicalassesment.view.UIAssessmentView;
import com.android.app.technicalassesment.viewmodel.UiAssessmentFragmentViewModel;
import com.viewpagerindicator.CirclePageIndicator;

public class UIAssessmentFragment extends Fragment implements View.OnClickListener,UIAssessmentView {

    /*

    This fragment show different type of UI

    RecyclerView is used for displaying items in the top by using the binding principles

    ViewPager is loaded with five different fragments

    textView is arranged is falling down model

    button clicks to change the color of button panel


     */


    UiAssessmentFragmentLayoutBinding binding;
    ViewPager viewPager;
    CirclePageIndicator indicator;
    UiAssessmentFragmentViewModel viewModel;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setRetainInstance(true);
    }

    public static UIAssessmentFragment newInstance() {
        Bundle args = new Bundle();
        UIAssessmentFragment fragment = new UIAssessmentFragment();
        fragment.setArguments(args);
        return fragment;
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
         binding=DataBindingUtil.inflate(inflater,R.layout.ui_assessment_fragment_layout,container,false);
         viewModel=new UiAssessmentFragmentViewModel(this);
        getActivity().setTitle(getResources().getString(R.string.ui_assessment_test));
         binding.setHandler(viewModel);
            setViewPager();
            setupButtonAction();
        return binding.getRoot();
    }

    private void setupButtonAction(){
        binding.redButton.setOnClickListener(this);
        binding.blueButton.setOnClickListener(this);
        binding.greenButton.setOnClickListener(this);  }

    private void setViewPager(){
         viewPager= binding.pager;
        indicator = binding.indicator;
        viewModel.setupViewPager();
      }

    @Override
    public void onClick(View view) {

        switch (view.getId()){
            case R.id.redButton:
                binding.buttonPanel.setBackgroundColor(App.getApplicationInstance().getResources().getColor(R.color.red));
                break;
            case R.id.blueButton:
                binding.buttonPanel.setBackgroundColor(App.getApplicationInstance().getResources().getColor(R.color.blue));
                break;
            case R.id.greenButton:
                binding.buttonPanel.setBackgroundColor(App.getApplicationInstance().getResources().getColor(R.color.green));
                break;
        }
    }

    @Override
    public ViewPager getViewPager() {
        return viewPager;
    }

    @Override
    public CirclePageIndicator getCircularIndicator() {
        return indicator;
    }

    @Override
    public FragmentManager getSupportManager() {
        return getChildFragmentManager();
    }


}
