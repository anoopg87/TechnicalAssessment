package com.android.app.technicalassesment.viewmodel;


import android.databinding.BaseObservable;
import android.databinding.Bindable;
import android.graphics.drawable.ColorDrawable;
import android.support.v4.app.FragmentManager;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;

import com.android.app.technicalassesment.App;
import com.android.app.technicalassesment.R;
import com.android.app.technicalassesment.view.adapters.RecyclerViewBindingAdapter;
import com.android.app.technicalassesment.view.adapters.RecyclerViewConfiguration;
import java.util.Arrays;
import java.util.List;
import com.android.app.technicalassesment.BR;
import com.android.app.technicalassesment.view.UIAssessmentView;
import com.android.app.technicalassesment.view.adapters.ViewPageAdapter;
import com.viewpagerindicator.CirclePageIndicator;

@SuppressWarnings("ALL")
public class UiAssessmentFragmentViewModel  extends BaseObservable{

    /*
     UiAssessmentFragementViewModel helps to setting up the UI like RecyclerView, Veiwpager and the indicators

     */



    private final RecyclerViewConfiguration itemListConfig=new RecyclerViewConfiguration();
    private FragmentManager fragmentManager;
    private String selectedItem="";
    private ColorDrawable selectedColor;
    private final UIAssessmentView uiAssessmentView;

    public void setSelectedColor(ColorDrawable selectedColor) {
        this.selectedColor = selectedColor;
        notifyPropertyChanged(BR.selectedColor);
    }

    @Bindable
    public ColorDrawable getSelectedColor() {
        return selectedColor;
    }

    private void setSelectedItem(String selectedItem) {
        this.selectedItem = selectedItem;
        notifyPropertyChanged(BR.selectedItem);
    }

    @Bindable
    public String getSelectedItem(){
        return selectedItem;
    }

    public RecyclerViewConfiguration getItemListConfig() {
        return itemListConfig;
    }

    public UiAssessmentFragmentViewModel(UIAssessmentView uiAssessmentView) {
        this.uiAssessmentView = uiAssessmentView;
        setSelectedColor(convertColorToDrawable(R.color.white));
        setupItemListView();
    }

    private void setupItemListView(){
        itemListConfig.setItemAnimator(new DefaultItemAnimator());
        itemListConfig.setLayoutManager(new LinearLayoutManager(App.getApplicationInstance(),LinearLayoutManager.HORIZONTAL,false));
        String[] itemList= App.getApplicationInstance().getResources().getStringArray(R.array.item_list);
        List<String> dataSet = Arrays.asList(itemList);
        RecyclerViewBindingAdapter<String> adapter = new RecyclerViewBindingAdapter<>(R.layout.items_view_layout, BR.item, dataSet);
        adapter.setItemClickListener((position, item) -> setSelectedItem(item));
        itemListConfig.setAdapter(adapter);

    }

    public void setupViewPager() {

        uiAssessmentView.getViewPager().setAdapter(new ViewPageAdapter(uiAssessmentView.getSupportManager()));
        CirclePageIndicator indicator= uiAssessmentView.getCircularIndicator();
        uiAssessmentView.getCircularIndicator().setViewPager( uiAssessmentView.getViewPager());
        indicator.setSnap(true);
        indicator.setFillColor(App.getApplicationInstance().getResources().getColor(R.color.primary_dark));
        final float density = App.getApplicationInstance().getResources().getDisplayMetrics().density;
        indicator.setRadius(5 * density);
    }

    public void colorSelector(String color){
       int selClr= color.equals("red")?R.color.red:color.equals("blue")?R.color.blue:R.color.green;
        setSelectedColor(convertColorToDrawable(selClr));
    }

    private ColorDrawable convertColorToDrawable(int selClr) {
        return new ColorDrawable(App.getApplicationInstance().getResources().getColor(selClr));
    }


}


