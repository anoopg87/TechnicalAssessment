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
import android.widget.LinearLayout;

import com.android.app.technicalassesment.R;
import com.android.app.technicalassesment.databinding.UiAssessmentFragmentLayoutBinding;
import com.android.app.technicalassesment.view.UIAssessmentView;
import com.android.app.technicalassesment.viewmodel.ParentViewModel;
import com.android.app.technicalassesment.viewmodel.UiAssessmentFragmentViewModel;
import com.viewpagerindicator.CirclePageIndicator;

@SuppressWarnings("ALL")
public class UIAssessmentFragment extends Fragment implements UIAssessmentView {

    /*

    This fragment show different type of UI

    RecyclerView is used for displaying items in the top by using the binding principles

    ViewPager is loaded with five different fragments

    textView is arranged is falling down model

    button clicks to change the color of button panel


     */


    private UiAssessmentFragmentLayoutBinding binding;
    private ViewPager viewPager;
    private CirclePageIndicator indicator;
    private UiAssessmentFragmentViewModel viewModel;

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
        ParentViewModel.TITLE.set(getResources().getString(R.string.ui_assessment_test));
         binding.setHandler(viewModel);
            setViewPager();

        return binding.getRoot();
    }

     private void setViewPager(){
         viewPager= binding.pager;
        indicator = binding.indicator;
        viewModel.setupViewPager();
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

    @Override
    public LinearLayout getButtonPanel() {
        return binding.buttonPanel;
    }


}
