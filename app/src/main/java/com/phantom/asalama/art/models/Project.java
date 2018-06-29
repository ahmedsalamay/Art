
package com.phantom.asalama.art.models;

import java.util.List;

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
    @SerializedName("privacy")
    @Expose
    private String privacy;
    @SerializedName("fields")
    @Expose
    private List<String> fields = null;
    @SerializedName("covers")
    @Expose
    private Covers covers;
    @SerializedName("mature_content")
    @Expose
    private Integer matureContent;
    @SerializedName("mature_access")
    @Expose
    private String matureAccess;
    @SerializedName("owners")
    @Expose
    private List<Owner> owners = null;
    @SerializedName("stats")
    @Expose
    private ProjectStats stats;
    @SerializedName("conceived_on")
    @Expose
    private Integer conceivedOn;
    @SerializedName("features")
    @Expose
    private List<Feature> features = null;
    @SerializedName("colors")
    @Expose
    private List<Color> colors = null;
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
        this.privacy = ((String) in.readValue((String.class.getClassLoader())));
        in.readList(this.fields, (java.lang.String.class.getClassLoader()));
        this.covers = ((Covers) in.readValue((Covers.class.getClassLoader())));
        this.matureContent = ((Integer) in.readValue((Integer.class.getClassLoader())));
        this.matureAccess = ((String) in.readValue((String.class.getClassLoader())));
        in.readList(this.owners, (com.phantom.asalama.art.models.Owner.class.getClassLoader()));
        this.stats = ((ProjectStats) in.readValue((ProjectStats.class.getClassLoader())));
        this.conceivedOn = ((Integer) in.readValue((Integer.class.getClassLoader())));
        in.readList(this.features, (com.phantom.asalama.art.models.Feature.class.getClassLoader()));
        in.readList(this.colors, (com.phantom.asalama.art.models.Color.class.getClassLoader()));
    }

    /**
     * No args constructor for use in serialization
     *
     */
    public Project() {
    }

    /**
     *
     * @param colors
     * @param stats
     * @param privacy
     * @param publishedOn
     * @param url
     * @param id
     * @param createdOn
     * @param modifiedOn
     * @param conceivedOn
     * @param covers
     * @param name
     * @param features
     * @param matureContent
     * @param owners
     * @param fields
     * @param matureAccess
     */
    public Project(Integer id, String name, Integer publishedOn, Integer createdOn, Integer modifiedOn, String url, String privacy, List<String> fields, Covers covers, Integer matureContent, String matureAccess, List<Owner> owners, ProjectStats stats, Integer conceivedOn, List<Feature> features, List<Color> colors) {
        super();
        this.id = id;
        this.name = name;
        this.publishedOn = publishedOn;
        this.createdOn = createdOn;
        this.modifiedOn = modifiedOn;
        this.url = url;
        this.privacy = privacy;
        this.fields = fields;
        this.covers = covers;
        this.matureContent = matureContent;
        this.matureAccess = matureAccess;
        this.owners = owners;
        this.stats = stats;
        this.conceivedOn = conceivedOn;
        this.features = features;
        this.colors = colors;
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

    public String getPrivacy() {
        return privacy;
    }

    public void setPrivacy(String privacy) {
        this.privacy = privacy;
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

    public String getMatureAccess() {
        return matureAccess;
    }

    public void setMatureAccess(String matureAccess) {
        this.matureAccess = matureAccess;
    }

    public List<Owner> getOwners() {
        return owners;
    }

    public void setOwners(List<Owner> owners) {
        this.owners = owners;
    }

    public ProjectStats getStats() {
        return stats;
    }

    public void setStats(ProjectStats stats) {
        this.stats = stats;
    }

    public Integer getConceivedOn() {
        return conceivedOn;
    }

    public void setConceivedOn(Integer conceivedOn) {
        this.conceivedOn = conceivedOn;
    }

    public List<Feature> getFeatures() {
        return features;
    }

    public void setFeatures(List<Feature> features) {
        this.features = features;
    }

    public List<Color> getColors() {
        return colors;
    }

    public void setColors(List<Color> colors) {
        this.colors = colors;
    }


    public void writeToParcel(Parcel dest, int flags) {
        dest.writeValue(id);
        dest.writeValue(name);
        dest.writeValue(publishedOn);
        dest.writeValue(createdOn);
        dest.writeValue(modifiedOn);
        dest.writeValue(url);
        dest.writeValue(privacy);
        dest.writeList(fields);
        dest.writeValue(covers);
        dest.writeValue(matureContent);
        dest.writeValue(matureAccess);
        dest.writeList(owners);
        dest.writeValue(stats);
        dest.writeValue(conceivedOn);
        dest.writeList(features);
        dest.writeList(colors);
    }

    public int describeContents() {
        return 0;
    }

}