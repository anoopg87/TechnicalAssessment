package com.android.app.technicalassesment.viewmodel;


import android.content.Context;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import com.android.app.technicalassesment.BR;
import com.android.app.technicalassesment.R;
import com.android.app.technicalassesment.util.DemoUser;
import com.android.app.technicalassesment.view.adapters.RecyclerViewBindingAdapter;
import com.android.app.technicalassesment.view.adapters.RecyclerViewConfiguration;

@SuppressWarnings("ALL")
public class ComplexRecyclerViewModel {

    public RecyclerViewConfiguration userListConfiguration=new RecyclerViewConfiguration();
    private Context context;

    public ComplexRecyclerViewModel(Context context) {
        this.context = context;
        setUserListConfiguration();
    }

    private void setUserListConfiguration(){
        userListConfiguration.setItemAnimator(new DefaultItemAnimator());
        userListConfiguration.setLayoutManager(new LinearLayoutManager(context));
        RecyclerViewBindingAdapter<UserViewModel> adapter = new RecyclerViewBindingAdapter<>(R.layout.contact_item_layout, BR.handler, UserViewModel.getUserModelList(DemoUser.getUerList()));
        userListConfiguration.setAdapter(adapter);


    }
}
