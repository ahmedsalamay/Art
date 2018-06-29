package com.phantom.asalama.art.models;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Max1200 implements Parcelable
{

    @SerializedName("width")
    @Expose
    private Integer width;
    @SerializedName("height")
    @Expose
    private Integer height;
    public final static Parcelable.Creator<Max1200> CREATOR = new Creator<Max1200>() {


        @SuppressWarnings({
                "unchecked"
        })
        public Max1200 createFromParcel(Parcel in) {
            return new Max1200(in);
        }

        public Max1200 [] newArray(int size) {
            return (new Max1200[size]);
        }

    }
            ;

    protected Max1200(Parcel in) {
        this.width = ((Integer) in.readValue((Integer.class.getClassLoader())));
        this.height = ((Integer) in.readValue((Integer.class.getClassLoader())));
    }

    /**
     * No args constructor for use in serialization
     *
     */
    public Max1200() {
    }

    /**
     *
     * @param height
     * @param width
     */
    public Max1200(Integer width, Integer height) {
        super();
        this.width = width;
        this.height = height;
    }

    public Integer getWidth() {
        return width;
    }

    public void setWidth(Integer width) {
        this.width = width;
    }

    public Integer getHeight() {
        return height;
    }

    public void setHeight(Integer height) {
        this.height = height;
    }

    public void writeToParcel(Parcel dest, int flags) {
        dest.writeValue(width);
        dest.writeValue(height);
    }

    public int describeContents() {
        return 0;
    }

}