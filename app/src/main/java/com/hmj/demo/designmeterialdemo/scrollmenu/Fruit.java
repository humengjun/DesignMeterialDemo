package com.hmj.demo.designmeterialdemo.scrollmenu;

import android.os.Parcel;
import android.os.Parcelable;

public class Fruit implements Parcelable {

    private String name;
    private int image;

    public Fruit(String name, int image) {
        this.name = name;
        this.image = image;
    }

    public String getName() {
        return name;
    }

    public int getImage() {
        return image;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(this.name);
        dest.writeInt(this.image);
    }

    protected Fruit(Parcel in) {
        this.name = in.readString();
        this.image = in.readInt();
    }

    public static final Parcelable.Creator<Fruit> CREATOR = new Parcelable.Creator<Fruit>() {
        @Override
        public Fruit createFromParcel(Parcel source) {
            return new Fruit(source);
        }

        @Override
        public Fruit[] newArray(int size) {
            return new Fruit[size];
        }
    };
}
