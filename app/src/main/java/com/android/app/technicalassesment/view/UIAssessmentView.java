package com.android.app.technicalassesment.view;


import android.support.v4.app.FragmentManager;
import android.support.v4.view.ViewPager;
import android.widget.LinearLayout;

import com.viewpagerindicator.CirclePageIndicator;
public interface UIAssessmentView {

    // Provide the data to the Corresponding ViewModel
    ViewPager getViewPager();
    CirclePageIndicator getCircularIndicator();
    FragmentManager getSupportManager();
    LinearLayout getButtonPanel();
}
