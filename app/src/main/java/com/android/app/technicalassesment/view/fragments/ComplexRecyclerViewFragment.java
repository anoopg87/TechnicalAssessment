package com.android.app.technicalassesment.view.fragments;


import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.android.app.technicalassesment.R;
import com.android.app.technicalassesment.databinding.ComplexRecyclerviewFragmentLayoutBinding;
import com.android.app.technicalassesment.viewmodel.ComplexRecyclerViewModel;
import com.android.app.technicalassesment.viewmodel.ParentViewModel;

public class ComplexRecyclerViewFragment extends Fragment {

    public static ComplexRecyclerViewFragment newInstance() {
        ComplexRecyclerViewFragment fragment = new ComplexRecyclerViewFragment();
        Bundle args = new Bundle();
        fragment.setArguments(args);
        return fragment;
    }

      @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        ComplexRecyclerviewFragmentLayoutBinding binding= DataBindingUtil.inflate(inflater,R.layout.complex_recyclerview_fragment_layout,container,false);
          ParentViewModel.TITLE.set(getResources().getString(R.string.complexview_assessment));
        binding.setHandler(new ComplexRecyclerViewModel(getActivity()));
        return binding.getRoot();
    }

}
