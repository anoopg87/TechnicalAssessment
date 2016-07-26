package com.android.app.technicalassesment.model;

import android.databinding.BaseObservable;
import android.databinding.Bindable;

import com.android.app.technicalassesment.BR;

@SuppressWarnings("ALL")
public class User extends BaseObservable{

    private String userName;
    private String userStatus;
    private String userImage;
    private boolean isVideoCallEnabled;
    private boolean isAudioCallEnabled;

    public User(String userName, String userStatus, String userImage, boolean isVideoCallEnabled, boolean isAudioCallEnabled) {
        this.userName = userName;
        this.userStatus = userStatus;
        this.userImage = userImage;
        this.isVideoCallEnabled = isVideoCallEnabled;
        this.isAudioCallEnabled = isAudioCallEnabled;
    }

    @Bindable
    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
        notifyPropertyChanged(BR.userName);
    }
    @Bindable
    public String getUserStatus() {
        return userStatus;
    }

    public void setUserStatus(String userStatus) {
        this.userStatus = userStatus;
        notifyPropertyChanged(BR.userStatus);
    }
    @Bindable
    public String getUserImage() {
        return userImage;
    }

    public void setUserImage(String userImage) {
        this.userImage = userImage;
        notifyPropertyChanged(BR.userImage);
    }
    @Bindable
    public boolean isVideoCallEnabled() {
        return isVideoCallEnabled;
    }

    public void setVideoCallEnabled(boolean videoCallEnabled) {
        isVideoCallEnabled = videoCallEnabled;
        notifyPropertyChanged(BR.videoCallEnabled);
    }
    @Bindable
    public boolean isAudioCallEnabled() {
        return isAudioCallEnabled;
    }

    public void setAudioCallEnabled(boolean audioCallEnabled) {
        isAudioCallEnabled = audioCallEnabled;
        notifyPropertyChanged(BR.audioCallEnabled);
    }

}
