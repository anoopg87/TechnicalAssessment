package com.android.app.technicalassesment.viewmodel;
import android.content.Context;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import com.android.app.technicalassesment.BR;
import com.android.app.technicalassesment.model.Menu;
import com.android.app.technicalassesment.R;
import com.android.app.technicalassesment.view.ParentView;
import com.android.app.technicalassesment.view.adapters.RecyclerViewBindingAdapter;
import com.android.app.technicalassesment.view.adapters.RecyclerViewConfiguration;
import com.android.app.technicalassesment.view.fragments.UIAssessmentFragment;
import com.android.app.technicalassesment.view.fragments.LocationInfoFragment;

public class ParentViewModel  {

    /*
    ParentViewModel list the menu and handle the menu operations

    loading corresponding fragments on selecting the menu

     */

    private RecyclerViewConfiguration menuListConfiguration=new RecyclerViewConfiguration();
    private RecyclerViewBindingAdapter<Menu> menuBindingAdapter;
    private Context context;
    private ParentView parentView;

    public RecyclerViewConfiguration getMenuListConfiguration() {
        return menuListConfiguration;
    }

    public ParentViewModel(Context context, ParentView parentView) {
        this.context = context;
        this.parentView = parentView;
        setMenuListConfiguration();
        initialPageLoading();
    }
    private void initialPageLoading() {
        Fragment fragment=null;
        fragment=parentView.getSupportManager().findFragmentByTag(UIAssessmentFragment.class.getName());
        if(fragment==null) {
             fragment = UIAssessmentFragment.newInstance();
        }
        loadFragment(fragment);
    }

    private void setMenuListConfiguration(){
        menuListConfiguration.setLayoutManager(new LinearLayoutManager(context));
        menuListConfiguration.setItemAnimator(new DefaultItemAnimator());
        menuBindingAdapter=new RecyclerViewBindingAdapter<>(R.layout.nav_menu_item, BR.menu, Menu.getMenuList());
        menuBindingAdapter.setItemClickListener((position, item) -> {

           parentView.closeDrawerLayout();
           Fragment fragment= position==0?UIAssessmentFragment.newInstance(): LocationInfoFragment.newInstance();
            loadFragment(fragment);

        });
        menuListConfiguration.setAdapter(menuBindingAdapter);

    }
    public void loadFragment(Fragment fragment){
        FragmentTransaction fragmentTransaction=parentView.getSupportManager().beginTransaction();
        fragmentTransaction.replace(R.id.fragmentLoadingSpace,fragment);
        fragmentTransaction.addToBackStack(fragment.getClass().getName());
        fragmentTransaction.commit();

    }



}
