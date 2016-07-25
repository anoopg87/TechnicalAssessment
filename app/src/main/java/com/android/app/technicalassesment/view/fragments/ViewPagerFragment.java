package com.android.app.technicalassesment.view.fragments;

import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.android.app.technicalassesment.R;
import com.android.app.technicalassesment.databinding.ViewpagerFragmentLayoutBinding;
import com.android.app.technicalassesment.viewmodel.ViewPagerFragmentViewModel;

public class ViewPagerFragment extends Fragment {
    /*
    Fragment which used for listing in viewpager Adapter
     */
    private static final String NAME="name";
    private static final String POSITION="position";
    private String fragmentName="";
    private String fragmentPosition="";

    public static ViewPagerFragment newInstance(String fragmentName,int position) {
        Bundle args = new Bundle();
        ViewPagerFragment fragment = new ViewPagerFragment();
        args.putString(NAME,fragmentName);
        args.putString(POSITION,String.valueOf(position));
        fragment.setArguments(args);
        return fragment;
    }
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if(null!=getArguments()){
            fragmentName=getArguments().getString(NAME);
            fragmentPosition=getArguments().getString(POSITION);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        ViewpagerFragmentLayoutBinding binding = DataBindingUtil.inflate(inflater, R.layout.viewpager_fragment_layout, container, false);
        binding.setFragmentName(fragmentName);
        binding.setFragmentPosition(fragmentPosition);
        ViewPagerFragmentViewModel viewModel=new ViewPagerFragmentViewModel();
        binding.setHandler(viewModel);
        return binding.getRoot();
    }



}