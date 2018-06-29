package com.phantom.asalama.art.models;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Project_ implements Parcelable
{

    @SerializedName("top_margin")
    @Expose
    private Integer topMargin;
    public final static Parcelable.Creator<Project_> CREATOR = new Creator<Project_>() {


        @SuppressWarnings({
                "unchecked"
        })
        public Project_ createFromParcel(Parcel in) {
            return new Project_(in);
        }

        public Project_[] newArray(int size) {
            return (new Project_[size]);
        }

    }
            ;

    protected Project_(Parcel in) {
        this.topMargin = ((Integer) in.readValue((Integer.class.getClassLoader())));
    }

    /**
     * No args constructor for use in serialization
     *
     */
    public Project_() {
    }

    /**
     *
     * @param topMargin
     */
    public Project_(Integer topMargin) {
        super();
        this.topMargin = topMargin;
    }

    public Integer getTopMargin() {
        return topMargin;
    }

    public void setTopMargin(Integer topMargin) {
        this.topMargin = topMargin;
    }


    public void writeToParcel(Parcel dest, int flags) {
        dest.writeValue(topMargin);
    }

    public int describeContents() {
        return 0;
    }

}