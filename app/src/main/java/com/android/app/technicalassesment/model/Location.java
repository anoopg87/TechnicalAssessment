package com.android.app.technicalassesment.model;

import android.os.Parcel;
import android.os.Parcelable;

public class Location implements Parcelable{


    /*

    This class hold location information

    @PARAM  latitude used for storing the latitude of the location

    @PARAM longitude used for storing the longitude of the location


    class implemented Parcelable in order to pass between activities

     */


    private String latitude;
   private String longitude;

    public String getLatitude() {
        return latitude;
    }

    public void setLatitude(String latitude) {
        this.latitude = latitude;
    }

    public String getLongitude() {
        return longitude;
    }

    public void setLongitude(String longitude) {
        this.longitude = longitude;
    }

    protected Location(Parcel in) {
        latitude = in.readString();
        longitude = in.readString();
    }

    public static final Creator<Location> CREATOR = new Creator<Location>() {
        @Override
        public Location createFromParcel(Parcel in) {
            return new Location(in);
        }

        @Override
        public Location[] newArray(int size) {
            return new Location[size];
        }
    };

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(latitude);
        dest.writeString(longitude);
    }
}