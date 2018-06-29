package com.phantom.asalama.art.models;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Modules implements Parcelable
{

    @SerializedName("bottom_margin")
    @Expose
    private Integer bottomMargin;
    public final static Parcelable.Creator<Modules> CREATOR = new Creator<Modules>() {


        @SuppressWarnings({
                "unchecked"
        })
        public Modules createFromParcel(Parcel in) {
            return new Modules(in);
        }

        public Modules[] newArray(int size) {
            return (new Modules[size]);
        }

    }
            ;

    protected Modules(Parcel in) {
        this.bottomMargin = ((Integer) in.readValue((Integer.class.getClassLoader())));
    }

    /**
     * No args constructor for use in serialization
     *
     */
    public Modules() {
    }

    /**
     *
     * @param bottomMargin
     */
    public Modules(Integer bottomMargin) {
        super();
        this.bottomMargin = bottomMargin;
    }

    public Integer getBottomMargin() {
        return bottomMargin;
    }

    public void setBottomMargin(Integer bottomMargin) {
        this.bottomMargin = bottomMargin;
    }



    public void writeToParcel(Parcel dest, int flags) {
        dest.writeValue(bottomMargin);
    }

    public int describeContents() {
        return 0;
    }

}
