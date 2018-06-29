package com.phantom.asalama.art.models;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Background implements Parcelable
{

    @SerializedName("color")
    @Expose
    private String color;
    public final static Parcelable.Creator<Background> CREATOR = new Creator<Background>() {


        @SuppressWarnings({
                "unchecked"
        })
        public Background createFromParcel(Parcel in) {
            return new Background(in);
        }

        public Background[] newArray(int size) {
            return (new Background[size]);
        }

    }
            ;

    protected Background(Parcel in) {
        this.color = ((String) in.readValue((String.class.getClassLoader())));
    }

    /**
     * No args constructor for use in serialization
     *
     */
    public Background() {
    }

    /**
     *
     * @param color
     */
    public Background(String color) {
        super();
        this.color = color;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }


    public void writeToParcel(Parcel dest, int flags) {
        dest.writeValue(color);
    }

    public int describeContents() {
        return 0;
    }

}