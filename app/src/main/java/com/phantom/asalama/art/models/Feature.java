package com.phantom.asalama.art.models;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Feature implements Parcelable
{

    @SerializedName("featured_on")
    @Expose
    private Integer featuredOn;
    @SerializedName("site")
    @Expose
    private Site site;
    @SerializedName("url")
    @Expose
    private String url;
    public final static Parcelable.Creator<Feature> CREATOR = new Creator<Feature>() {


        @SuppressWarnings({
                "unchecked"
        })
        public Feature createFromParcel(Parcel in) {
            return new Feature(in);
        }

        public Feature[] newArray(int size) {
            return (new Feature[size]);
        }

    }
            ;

    protected Feature(Parcel in) {
        this.featuredOn = ((Integer) in.readValue((Integer.class.getClassLoader())));
        this.site = ((Site) in.readValue((Site.class.getClassLoader())));
        this.url = ((String) in.readValue((String.class.getClassLoader())));
    }

    /**
     * No args constructor for use in serialization
     *
     */
    public Feature() {
    }

    /**
     *
     * @param site
     * @param featuredOn
     * @param url
     */
    public Feature(Integer featuredOn, Site site, String url) {
        super();
        this.featuredOn = featuredOn;
        this.site = site;
        this.url = url;
    }

    public Integer getFeaturedOn() {
        return featuredOn;
    }

    public void setFeaturedOn(Integer featuredOn) {
        this.featuredOn = featuredOn;
    }

    public Site getSite() {
        return site;
    }

    public void setSite(Site site) {
        this.site = site;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public void writeToParcel(Parcel dest, int flags) {
        dest.writeValue(featuredOn);
        dest.writeValue(site);
        dest.writeValue(url);
    }

    public int describeContents() {
        return 0;
    }

}