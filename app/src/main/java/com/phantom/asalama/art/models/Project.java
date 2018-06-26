package com.phantom.asalama.art.models;

import java.util.List;
import java.util.Map;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Project implements Parcelable
{

    @SerializedName("id")
    @Expose
    private Integer id;
    @SerializedName("name")
    @Expose
    private String name;
    @SerializedName("published_on")
    @Expose
    private Integer publishedOn;
    @SerializedName("created_on")
    @Expose
    private Integer createdOn;
    @SerializedName("modified_on")
    @Expose
    private Integer modifiedOn;
    @SerializedName("url")
    @Expose
    private String url;
    @SerializedName("fields")
    @Expose
    private List<String> fields = null;
    @SerializedName("covers")
    @Expose
    private Covers covers;
    @SerializedName("mature_content")
    @Expose
    private Integer matureContent;
    @SerializedName("owners")
    @Expose
    private Map<String, Owners> owners;
    @SerializedName("stats")
    @Expose
    private Stats stats;
    public final static Parcelable.Creator<Project> CREATOR = new Creator<Project>() {


        @SuppressWarnings({
                "unchecked"
        })
        public Project createFromParcel(Parcel in) {
            return new Project(in);
        }

        public Project[] newArray(int size) {
            return (new Project[size]);
        }

    }
            ;

    protected Project(Parcel in) {
        this.id = ((Integer) in.readValue((Integer.class.getClassLoader())));
        this.name = ((String) in.readValue((String.class.getClassLoader())));
        this.publishedOn = ((Integer) in.readValue((Integer.class.getClassLoader())));
        this.createdOn = ((Integer) in.readValue((Integer.class.getClassLoader())));
        this.modifiedOn = ((Integer) in.readValue((Integer.class.getClassLoader())));
        this.url = ((String) in.readValue((String.class.getClassLoader())));
        in.readList(this.fields, (java.lang.String.class.getClassLoader()));
        this.covers = ((Covers) in.readValue((Covers.class.getClassLoader())));
        this.matureContent = ((Integer) in.readValue((Integer.class.getClassLoader())));
        this.owners = ((Map<String, Owners>) in.readValue((Owners.class.getClassLoader())));
        this.stats = ((Stats) in.readValue((Stats.class.getClassLoader())));
    }

    /**
     * No args constructor for use in serialization
     *
     */
    public Project() {
    }

    /**
     *
     * @param createdOn
     * @param id
     * @param modifiedOn
     * @param covers
     * @param stats
     * @param name
     * @param publishedOn
     * @param owners
     * @param matureContent
     * @param url
     * @param fields
     */
    public Project(Integer id, String name, Integer publishedOn, Integer createdOn, Integer modifiedOn, String url, List<String> fields, Covers covers, Integer matureContent,  Map<String, Owners> owners, Stats stats) {
        super();
        this.id = id;
        this.name = name;
        this.publishedOn = publishedOn;
        this.createdOn = createdOn;
        this.modifiedOn = modifiedOn;
        this.url = url;
        this.fields = fields;
        this.covers = covers;
        this.matureContent = matureContent;
        this.owners = owners;
        this.stats = stats;
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

    public Integer getPublishedOn() {
        return publishedOn;
    }

    public void setPublishedOn(Integer publishedOn) {
        this.publishedOn = publishedOn;
    }

    public Integer getCreatedOn() {
        return createdOn;
    }

    public void setCreatedOn(Integer createdOn) {
        this.createdOn = createdOn;
    }

    public Integer getModifiedOn() {
        return modifiedOn;
    }

    public void setModifiedOn(Integer modifiedOn) {
        this.modifiedOn = modifiedOn;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public List<String> getFields() {
        return fields;
    }

    public void setFields(List<String> fields) {
        this.fields = fields;
    }

    public Covers getCovers() {
        return covers;
    }

    public void setCovers(Covers covers) {
        this.covers = covers;
    }

    public Integer getMatureContent() {
        return matureContent;
    }

    public void setMatureContent(Integer matureContent) {
        this.matureContent = matureContent;
    }

    public  Map<String, Owners> getOwners() {
        return owners;
    }

    public void setOwners( Map<String, Owners> owners) {
        this.owners = owners;
    }

    public Stats getStats() {
        return stats;
    }

    public void setStats(Stats stats) {
        this.stats = stats;
    }



    public void writeToParcel(Parcel dest, int flags) {
        dest.writeValue(id);
        dest.writeValue(name);
        dest.writeValue(publishedOn);
        dest.writeValue(createdOn);
        dest.writeValue(modifiedOn);
        dest.writeValue(url);
        dest.writeList(fields);
        dest.writeValue(covers);
        dest.writeValue(matureContent);
        dest.writeValue(owners);
        dest.writeValue(stats);
    }

    public int describeContents() {
        return 0;
    }

}