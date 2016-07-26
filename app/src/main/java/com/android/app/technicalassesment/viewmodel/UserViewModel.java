package com.android.app.technicalassesment.viewmodel;


import android.databinding.BaseObservable;
import android.databinding.Bindable;
import android.util.Log;
import android.view.View;
import android.widget.Toast;

import com.android.app.technicalassesment.App;
import com.android.app.technicalassesment.BR;
import com.android.app.technicalassesment.R;
import com.android.app.technicalassesment.model.User;

import java.util.ArrayList;
import java.util.List;

@SuppressWarnings("ALL")
public class UserViewModel extends BaseObservable {

    private User user;

    public UserViewModel(User user) {
        this.user = user;
    }

    public void setUser(User user) {
        this.user = user;
        notifyPropertyChanged(BR.user);
    }

    @Bindable
    public User getUser() {
        return user;
    }

    public void onAudioCallClick(User user){
        Log.d("User",user.getUserName());
        Toast.makeText(App.getApplicationInstance(),App.getApplicationInstance().getResources().getString(R.string.initiate_audio_call) +user.getUserName(), Toast.LENGTH_SHORT).show();
    }
    public void onVideoCallClick(User user){
        Log.d("User",user.getUserName());
        Toast.makeText(App.getApplicationInstance(),App.getApplicationInstance().getResources().getString(R.string.initiate_video_call)+user.getUserName(), Toast.LENGTH_SHORT).show();
    }
    public void onTextMessageCallClick(User user){
        Log.d("User",user.getUserName());
        Toast.makeText(App.getApplicationInstance(),App.getApplicationInstance().getResources().getString(R.string.initiate_text_message) +user.getUserName(), Toast.LENGTH_SHORT).show();
    }

    public static List<UserViewModel> getUserModelList(List<User> userList){
        List<UserViewModel> userViewModelList=new ArrayList<>();
        for (User user:
                userList) {
             userViewModelList.add(new UserViewModel(user));
        }
        return userViewModelList;
    }
}
