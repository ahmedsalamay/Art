package com.phantom.asalama.art.models;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Ribbon implements Parcelable
{

    @SerializedName("image")
    @Expose
    private String image;
    @SerializedName("image_2x")
    @Expose
    private String image2x;
    public final static Parcelable.Creator<Ribbon> CREATOR = new Creator<Ribbon>() {


        @SuppressWarnings({
                "unchecked"
        })
        public Ribbon createFromParcel(Parcel in) {
            return new Ribbon(in);
        }

        public Ribbon[] newArray(int size) {
            return (new Ribbon[size]);
        }

    }
            ;

    protected Ribbon(Parcel in) {
        this.image = ((String) in.readValue((String.class.getClassLoader())));
        this.image2x = ((String) in.readValue((String.class.getClassLoader())));
    }

    /**
     * No args constructor for use in serialization
     *
     */
    public Ribbon() {
    }

    /**
     *
     * @param image
     * @param image2x
     */
    public Ribbon(String image, String image2x) {
        super();
        this.image = image;
        this.image2x = image2x;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getImage2x() {
        return image2x;
    }

    public void setImage2x(String image2x) {
        this.image2x = image2x;
    }



    public void writeToParcel(Parcel dest, int flags) {
        dest.writeValue(image);
        dest.writeValue(image2x);
    }

    public int describeContents() {
        return 0;
    }

}