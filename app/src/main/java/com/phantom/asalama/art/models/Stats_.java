package com.phantom.asalama.art.models;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Stats_ implements Parcelable
{

    @SerializedName("views")
    @Expose
    private Integer views;
    @SerializedName("appreciations")
    @Expose
    private Integer appreciations;
    @SerializedName("comments")
    @Expose
    private Integer comments;
    public final static Parcelable.Creator<Stats_> CREATOR = new Creator<Stats_>() {


        @SuppressWarnings({
                "unchecked"
        })
        public Stats_ createFromParcel(Parcel in) {
            return new Stats_(in);
        }

        public Stats_[] newArray(int size) {
            return (new Stats_[size]);
        }

    }
            ;

    protected Stats_(Parcel in) {
        this.views = ((Integer) in.readValue((Integer.class.getClassLoader())));
        this.appreciations = ((Integer) in.readValue((Integer.class.getClassLoader())));
        this.comments = ((Integer) in.readValue((Integer.class.getClassLoader())));
    }

    /**
     * No args constructor for use in serialization
     *
     */
    public Stats_() {
    }

    /**
     *
     * @param views
     * @param appreciations
     * @param comments
     */
    public Stats_(Integer views, Integer appreciations, Integer comments) {
        super();
        this.views = views;
        this.appreciations = appreciations;
        this.comments = comments;
    }

    public Integer getViews() {
        return views;
    }

    public void setViews(Integer views) {
        this.views = views;
    }

    public Integer getAppreciations() {
        return appreciations;
    }

    public void setAppreciations(Integer appreciations) {
        this.appreciations = appreciations;
    }

    public Integer getComments() {
        return comments;
    }

    public void setComments(Integer comments) {
        this.comments = comments;
    }


    public void writeToParcel(Parcel dest, int flags) {
        dest.writeValue(views);
        dest.writeValue(appreciations);
        dest.writeValue(comments);
    }

    public int describeContents() {
        return 0;
    }

}