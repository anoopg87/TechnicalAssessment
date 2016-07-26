package com.android.app.technicalassesment.model;


import android.databinding.BaseObservable;
import android.os.Parcel;
import android.os.Parcelable;

@SuppressWarnings("ALL")
public class FromCentral extends BaseObservable implements Parcelable {

    /* Mode of transport

    The class is used to store the mode of transport to the location

    two type of transport is available Car and Train

    Class implemented parcelable in order to pass the data between two activities

     */


   private String car;
   private String train;

    public String getCar() {
        return car;
    }

    public void setCar(String car) {
        this.car = car;
    }

    public String getTrain() {
        return train;
    }

    public void setTrain(String train) {
        this.train = train;
    }

    FromCentral(Parcel in) {
        car = in.readString();
        train = in.readString();
    }

    public static final Creator<FromCentral> CREATOR = new Creator<FromCentral>() {
        @Override
        public FromCentral createFromParcel(Parcel in) {
            return new FromCentral(in);
        }

        @Override
        public FromCentral[] newArray(int size) {
            return new FromCentral[size];
        }
    };

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(car);
        dest.writeString(train);
    }
}