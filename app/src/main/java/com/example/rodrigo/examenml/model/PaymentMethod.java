package com.example.rodrigo.examenml.model;

import android.os.Parcel;
import android.os.Parcelable;

/**
 * Created by rodrigo on 21/01/18.
 */

public class PaymentMethod implements Parcelable {

    private String name;
    private String thumbnail;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getThumbnail() {
        return thumbnail;
    }

    public void setThumbnail(String thumbnail) {
        this.thumbnail = thumbnail;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(this.name);
        dest.writeString(this.thumbnail);
    }

    public PaymentMethod() {
    }

    protected PaymentMethod(Parcel in) {
        this.name = in.readString();
        this.thumbnail = in.readString();
    }

    public static final Parcelable.Creator<PaymentMethod> CREATOR = new Parcelable.Creator<PaymentMethod>() {
        @Override
        public PaymentMethod createFromParcel(Parcel source) {
            return new PaymentMethod(source);
        }

        @Override
        public PaymentMethod[] newArray(int size) {
            return new PaymentMethod[size];
        }
    };
}
