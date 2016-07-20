package com.android.app.technicalassesment.view;
import android.support.v4.app.FragmentManager;
public interface ParentView {
    // Provide the information of the parentView to the corresponding viewModel
    FragmentManager getSupportManager();
    void closeDrawerLayout();

}
