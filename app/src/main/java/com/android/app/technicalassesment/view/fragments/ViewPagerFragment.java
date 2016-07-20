package com.android.app.technicalassesment.view.fragments;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;
import com.android.app.technicalassesment.R;
public class ViewPagerFragment extends Fragment {

    /*

    Fragment which used for listing in viewpager Adapter

     */

    private View mView;
    public static String NAME="NAME",POSITION="POSITION";
    private String fragmentName="";
    private String fragmentPosition="";
    private FrameLayout mFrameLayout;
    private ViewGroup container;

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
        mFrameLayout=new FrameLayout(getActivity());
        this.container=container;
        return populateView();
    }

    private View populateView(){
         mView=LayoutInflater.from(getActivity()).inflate(R.layout.viewpager_fragment_layout,container,false);
        ((TextView)mView.findViewById(R.id.textView)).setText(fragmentName);
        mView.findViewById(R.id.mainPanel).setOnClickListener(v -> Toast.makeText(getActivity(),"Fragment :"+fragmentPosition,Toast.LENGTH_SHORT).show());
        mFrameLayout.addView(mView);

        return mFrameLayout;
    }
}