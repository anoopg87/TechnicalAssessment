package com.android.app.technicalassesment.view.adapters;




import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentStatePagerAdapter;

import com.android.app.technicalassesment.view.fragments.ViewPagerFragment;
public class ViewPageAdapter extends FragmentStatePagerAdapter {

/*

View pager adapter used for holding the Fragments
 */
    public ViewPageAdapter(android.support.v4.app.FragmentManager fm) {
        super(fm);
    }

    @Override
    public Fragment getItem(int position) {
        switch (position){
            case 0: return ViewPagerFragment.newInstance("Fragment1",1);
            case 1:return ViewPagerFragment.newInstance("Fragment2",2);
            case 2:return ViewPagerFragment.newInstance("Fragment3",3);
            case 3:return ViewPagerFragment.newInstance("Fragment4",4);
            default:return  ViewPagerFragment.newInstance("Fragment Default",0);
        }

    }


    // returning the count of fragments
    @Override
    public int getCount() {
        return 4;
    }
}