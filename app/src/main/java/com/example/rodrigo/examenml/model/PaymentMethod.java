package com.example.rodrigo.examenml.model;

import android.os.Parcel;
import android.os.Parcelable;

/**
 * Created by rodrigo on 21/01/18.
 */

public class PaymentMethod implements Parcelable {

    private String id;
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

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public PaymentMethod() {
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(this.id);
        dest.writeString(this.name);
        dest.writeString(this.thumbnail);
    }

    protected PaymentMethod(Parcel in) {
        this.id = in.readString();
        this.name = in.readString();
        this.thumbnail = in.readString();
    }

    public static final Creator<PaymentMethod> CREATOR = new Creator<PaymentMethod>() {
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
