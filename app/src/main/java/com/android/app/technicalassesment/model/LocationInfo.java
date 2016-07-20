package com.android.app.technicalassesment.model;


import android.os.Parcel;
import android.os.Parcelable;

public class LocationInfo implements Parcelable {

    /*

    Hold the full location information from the feed

    @Params id hold the id of the location
    @params name hold the name of the location
    @params fromcentral hold the mode of transport available to the location
    @params location holds the latitude and longitude of the the location


     */


     private int id;
     private String name;
     private FromCentral fromcentral;
     private Location location;

    public LocationInfo(int id, String name) {
        this.id = id;
        this.name = name;
    }

    protected LocationInfo(Parcel in) {
        id = in.readInt();
        name = in.readString();
        fromcentral = in.readParcelable(FromCentral.class.getClassLoader());
        location = in.readParcelable(Location.class.getClassLoader());
    }

    public static final Creator<LocationInfo> CREATOR = new Creator<LocationInfo>() {
        @Override
        public LocationInfo createFromParcel(Parcel in) {
            return new LocationInfo(in);
        }

        @Override
        public LocationInfo[] newArray(int size) {
            return new LocationInfo[size];
        }
    };

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public FromCentral getFromCentral() {
        return fromcentral;
    }

    public void setFromCentral(FromCentral fromCentral) {
        this.fromcentral = fromCentral;
    }

    public Location getLocation() {
        return location;
    }

    public void setLocation(Location location) {
        this.location = location;
    }


    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeInt(id);
        dest.writeString(name);
        dest.writeParcelable(fromcentral, flags);
        dest.writeParcelable(location, flags);
    }
}


