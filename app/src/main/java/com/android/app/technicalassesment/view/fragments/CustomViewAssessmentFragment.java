package com.android.app.technicalassesment.view.fragments;

import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.android.app.technicalassesment.R;
import com.android.app.technicalassesment.databinding.CustomViewFragmentBinding;
import com.android.app.technicalassesment.viewmodel.CustomViewFragmentModel;
import com.android.app.technicalassesment.viewmodel.ParentViewModel;


public class CustomViewAssessmentFragment extends Fragment {

    public static CustomViewAssessmentFragment newInstance() {
        Bundle args = new Bundle();
        CustomViewAssessmentFragment fragment = new CustomViewAssessmentFragment();
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        CustomViewFragmentBinding binding= DataBindingUtil.inflate(inflater, R.layout.custom_view_fragment,container,false);
        ParentViewModel.TITLE.set(getResources().getString(R.string.custom_view_assessment));
        binding.setHandler(new CustomViewFragmentModel());
        return binding.getRoot();
    }
}
