package com.android.app.technicalassesment.view.activity;

import android.content.Context;
import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.v4.app.FragmentManager;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;

import com.android.app.technicalassesment.R;
import com.android.app.technicalassesment.databinding.ActivityMainBinding;
import com.android.app.technicalassesment.view.ParentView;
import com.android.app.technicalassesment.viewmodel.ParentViewModel;


public  class ParentActivity extends AppCompatActivity implements ParentView {

    /*
    ParentActivity hold the all the fragments in the applications

    implemented drawerlayout for the sliding menu

    Used binding method for listing the menu

     */

    private DrawerLayout drawerLayout;
    private Toolbar toolbar;
    private  ActivityMainBinding binding;
    private ParentViewModel parentViewModel;
    private Context context;
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
         binding= DataBindingUtil.setContentView(this, R.layout.activity_main);
        initView();
        context=this;
        parentViewModel=new ParentViewModel(context,this);
        binding.setHandler(parentViewModel);

    }

    private void initView(){
        toolbar= (Toolbar) findViewById(R.id.top_bar);
        setSupportActionBar(toolbar);
         drawerLayout= (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle= new ActionBarDrawerToggle(
                this, drawerLayout, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawerLayout.addDrawerListener(toggle);
        toggle.syncState();

    }

    @Override
    public boolean onPrepareOptionsMenu(Menu menu) {
        return super.onPrepareOptionsMenu(menu);
    }
    @Override
    public void onBackPressed() {
       if (drawerLayout.isDrawerOpen(GravityCompat.START)) {
            drawerLayout.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }

    @Override
    public void closeDrawerLayout() {
        drawerLayout.closeDrawer(GravityCompat.START);
    }


    @Override
    public FragmentManager getSupportManager(){
        return getSupportFragmentManager();
    }

}