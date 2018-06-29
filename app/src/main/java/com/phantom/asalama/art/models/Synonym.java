package com.phantom.asalama.art.models;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Synonym implements Parcelable
{

    @SerializedName("tag_id")
    @Expose
    private Integer tagId;
    @SerializedName("name")
    @Expose
    private String name;
    @SerializedName("title")
    @Expose
    private String title;
    @SerializedName("url")
    @Expose
    private String url;
    @SerializedName("download_url")
    @Expose
    private String downloadUrl;
    @SerializedName("gallery_url")
    @Expose
    private String galleryUrl;
    @SerializedName("authenticated")
    @Expose
    private Integer authenticated;
    @SerializedName("type")
    @Expose
    private Integer type;
    @SerializedName("icon_url")
    @Expose
    private String iconUrl;
    @SerializedName("icon_url_2x")
    @Expose
    private String iconUrl2x;
    public final static Parcelable.Creator<Synonym> CREATOR = new Creator<Synonym>() {


        @SuppressWarnings({
                "unchecked"
        })
        public Synonym createFromParcel(Parcel in) {
            return new Synonym(in);
        }

        public Synonym[] newArray(int size) {
            return (new Synonym[size]);
        }

    }
            ;

    protected Synonym(Parcel in) {
        this.tagId = ((Integer) in.readValue((Integer.class.getClassLoader())));
        this.name = ((String) in.readValue((String.class.getClassLoader())));
        this.title = ((String) in.readValue((String.class.getClassLoader())));
        this.url = ((String) in.readValue((String.class.getClassLoader())));
        this.downloadUrl = ((String) in.readValue((String.class.getClassLoader())));
        this.galleryUrl = ((String) in.readValue((String.class.getClassLoader())));
        this.authenticated = ((Integer) in.readValue((Integer.class.getClassLoader())));
        this.type = ((Integer) in.readValue((Integer.class.getClassLoader())));
        this.iconUrl = ((String) in.readValue((String.class.getClassLoader())));
        this.iconUrl2x = ((String) in.readValue((String.class.getClassLoader())));
    }

    /**
     * No args constructor for use in serialization
     *
     */
    public Synonym() {
    }

    /**
     *
     * @param title
     * @param iconUrl2x
     * @param authenticated
     * @param iconUrl
     * @param name
     * @param galleryUrl
     * @param downloadUrl
     * @param type
     * @param tagId
     * @param url
     */
    public Synonym(Integer tagId, String name, String title, String url, String downloadUrl, String galleryUrl, Integer authenticated, Integer type, String iconUrl, String iconUrl2x) {
        super();
        this.tagId = tagId;
        this.name = name;
        this.title = title;
        this.url = url;
        this.downloadUrl = downloadUrl;
        this.galleryUrl = galleryUrl;
        this.authenticated = authenticated;
        this.type = type;
        this.iconUrl = iconUrl;
        this.iconUrl2x = iconUrl2x;
    }

    public Integer getTagId() {
        return tagId;
    }

    public void setTagId(Integer tagId) {
        this.tagId = tagId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getDownloadUrl() {
        return downloadUrl;
    }

    public void setDownloadUrl(String downloadUrl) {
        this.downloadUrl = downloadUrl;
    }

    public String getGalleryUrl() {
        return galleryUrl;
    }

    public void setGalleryUrl(String galleryUrl) {
        this.galleryUrl = galleryUrl;
    }

    public Integer getAuthenticated() {
        return authenticated;
    }

    public void setAuthenticated(Integer authenticated) {
        this.authenticated = authenticated;
    }

    public Integer getType() {
        return type;
    }

    public void setType(Integer type) {
        this.type = type;
    }

    public String getIconUrl() {
        return iconUrl;
    }

    public void setIconUrl(String iconUrl) {
        this.iconUrl = iconUrl;
    }

    public String getIconUrl2x() {
        return iconUrl2x;
    }

    public void setIconUrl2x(String iconUrl2x) {
        this.iconUrl2x = iconUrl2x;
    }


    public void writeToParcel(Parcel dest, int flags) {
        dest.writeValue(tagId);
        dest.writeValue(name);
        dest.writeValue(title);
        dest.writeValue(url);
        dest.writeValue(downloadUrl);
        dest.writeValue(galleryUrl);
        dest.writeValue(authenticated);
        dest.writeValue(type);
        dest.writeValue(iconUrl);
        dest.writeValue(iconUrl2x);
    }

    public int describeContents() {
        return 0;
    }

}