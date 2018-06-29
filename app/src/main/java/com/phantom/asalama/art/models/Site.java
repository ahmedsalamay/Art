package com.phantom.asalama.art.models;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Site implements Parcelable
{

    @SerializedName("id")
    @Expose
    private Integer id;
    @SerializedName("name")
    @Expose
    private String name;
    @SerializedName("key")
    @Expose
    private String key;
    @SerializedName("icon")
    @Expose
    private String icon;
    @SerializedName("url")
    @Expose
    private String url;
    @SerializedName("domain")
    @Expose
    private String domain;
    @SerializedName("ribbon")
    @Expose
    private Ribbon ribbon;
    @SerializedName("parent_id")
    @Expose
    private Integer parentId;
    @SerializedName("app_icon")
    @Expose
    private String appIcon;
    public final static Parcelable.Creator<Site> CREATOR = new Creator<Site>() {


        @SuppressWarnings({
                "unchecked"
        })
        public Site createFromParcel(Parcel in) {
            return new Site(in);
        }

        public Site[] newArray(int size) {
            return (new Site[size]);
        }

    }
            ;

    protected Site(Parcel in) {
        this.id = ((Integer) in.readValue((Integer.class.getClassLoader())));
        this.name = ((String) in.readValue((String.class.getClassLoader())));
        this.key = ((String) in.readValue((String.class.getClassLoader())));
        this.icon = ((String) in.readValue((String.class.getClassLoader())));
        this.url = ((String) in.readValue((String.class.getClassLoader())));
        this.domain = ((String) in.readValue((String.class.getClassLoader())));
        this.ribbon = ((Ribbon) in.readValue((Ribbon.class.getClassLoader())));
        this.parentId = ((Integer) in.readValue((Integer.class.getClassLoader())));
        this.appIcon = ((String) in.readValue((String.class.getClassLoader())));
    }

    /**
     * No args constructor for use in serialization
     *
     */
    public Site() {
    }

    /**
     *
     * @param id
     * @param parentId
     * @param icon
     * @param appIcon
     * @param ribbon
     * @param name
     * @param domain
     * @param url
     * @param key
     */
    public Site(Integer id, String name, String key, String icon, String url, String domain, Ribbon ribbon, Integer parentId, String appIcon) {
        super();
        this.id = id;
        this.name = name;
        this.key = key;
        this.icon = icon;
        this.url = url;
        this.domain = domain;
        this.ribbon = ribbon;
        this.parentId = parentId;
        this.appIcon = appIcon;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getKey() {
        return key;
    }

    public void setKey(String key) {
        this.key = key;
    }

    public String getIcon() {
        return icon;
    }

    public void setIcon(String icon) {
        this.icon = icon;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getDomain() {
        return domain;
    }

    public void setDomain(String domain) {
        this.domain = domain;
    }

    public Ribbon getRibbon() {
        return ribbon;
    }

    public void setRibbon(Ribbon ribbon) {
        this.ribbon = ribbon;
    }

    public Integer getParentId() {
        return parentId;
    }

    public void setParentId(Integer parentId) {
        this.parentId = parentId;
    }

    public String getAppIcon() {
        return appIcon;
    }

    public void setAppIcon(String appIcon) {
        this.appIcon = appIcon;
    }



    public void writeToParcel(Parcel dest, int flags) {
        dest.writeValue(id);
        dest.writeValue(name);
        dest.writeValue(key);
        dest.writeValue(icon);
        dest.writeValue(url);
        dest.writeValue(domain);
        dest.writeValue(ribbon);
        dest.writeValue(parentId);
        dest.writeValue(appIcon);
    }

    public int describeContents() {
        return 0;
    }

}