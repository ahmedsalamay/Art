package com.phantom.asalama.art.models;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Stats implements Parcelable
{

    @SerializedName("followers")
    @Expose
    private Integer followers;
    @SerializedName("following")
    @Expose
    private Integer following;
    @SerializedName("appreciations")
    @Expose
    private Integer appreciations;
    @SerializedName("views")
    @Expose
    private Integer views;
    @SerializedName("comments")
    @Expose
    private Integer comments;
    public final static Parcelable.Creator<Stats> CREATOR = new Creator<Stats>() {


        @SuppressWarnings({
                "unchecked"
        })
        public Stats createFromParcel(Parcel in) {
            return new Stats(in);
        }

        public Stats[] newArray(int size) {
            return (new Stats[size]);
        }

    }
            ;

    protected Stats(Parcel in) {
        this.followers = ((Integer) in.readValue((Integer.class.getClassLoader())));
        this.following = ((Integer) in.readValue((Integer.class.getClassLoader())));
        this.appreciations = ((Integer) in.readValue((Integer.class.getClassLoader())));
        this.views = ((Integer) in.readValue((Integer.class.getClassLoader())));
        this.comments = ((Integer) in.readValue((Integer.class.getClassLoader())));
    }

    /**
     * No args constructor for use in serialization
     *
     */
    public Stats() {
    }

    /**
     *
     * @param following
     * @param followers
     * @param views
     * @param appreciations
     * @param comments
     */
    public Stats(Integer followers, Integer following, Integer appreciations, Integer views, Integer comments) {
        super();
        this.followers = followers;
        this.following = following;
        this.appreciations = appreciations;
        this.views = views;
        this.comments = comments;
    }

    public Integer getFollowers() {
        return followers;
    }

    public void setFollowers(Integer followers) {
        this.followers = followers;
    }

    public Integer getFollowing() {
        return following;
    }

    public void setFollowing(Integer following) {
        this.following = following;
    }

    public Integer getAppreciations() {
        return appreciations;
    }

    public void setAppreciations(Integer appreciations) {
        this.appreciations = appreciations;
    }

    public Integer getViews() {
        return views;
    }

    public void setViews(Integer views) {
        this.views = views;
    }

    public Integer getComments() {
        return comments;
    }

    public void setComments(Integer comments) {
        this.comments = comments;
    }


    public void writeToParcel(Parcel dest, int flags) {
        dest.writeValue(followers);
        dest.writeValue(following);
        dest.writeValue(appreciations);
        dest.writeValue(views);
        dest.writeValue(comments);
    }

    public int describeContents() {
        return 0;
    }

}