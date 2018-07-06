
package com.phantom.asalama.art.models;

import java.util.ArrayList;
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
    private List<String> fields = new ArrayList<>();
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
    private List<Owner> owners = new ArrayList<>();
    @SerializedName("stats")
    @Expose
    private Stats_ stats;
    @SerializedName("conceived_on")
    @Expose
    private Integer conceivedOn;
    @SerializedName("canvas_width")
    @Expose
    private Integer canvasWidth;
    @SerializedName("tags")
    @Expose
    private List<String> tags = new ArrayList<>();
    @SerializedName("description")
    @Expose
    private String description;
    @SerializedName("editor_version")
    @Expose
    private Integer editorVersion;
    @SerializedName("allow_comments")
    @Expose
    private Integer allowComments;
    @SerializedName("modules")
    @Expose
    private List<Module> modules = new ArrayList<>();
    @SerializedName("short_url")
    @Expose
    private String shortUrl;
    @SerializedName("copyright")
    @Expose
    private Copyright copyright;
    @SerializedName("tools")
    @Expose
    private List<Tool> tools = new ArrayList<>();
    @SerializedName("features")
    @Expose
    private List<Feature> features = new ArrayList<>();
    @SerializedName("styles")
    @Expose
    private Styles styles;
    @SerializedName("creator_id")
    @Expose
    private Integer creatorId;
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
        this.stats = ((Stats_) in.readValue((Stats_.class.getClassLoader())));
        this.conceivedOn = ((Integer) in.readValue((Integer.class.getClassLoader())));
        this.canvasWidth = ((Integer) in.readValue((Integer.class.getClassLoader())));
        in.readList(this.tags, (java.lang.String.class.getClassLoader()));
        this.description = ((String) in.readValue((String.class.getClassLoader())));
        this.editorVersion = ((Integer) in.readValue((Integer.class.getClassLoader())));
        this.allowComments = ((Integer) in.readValue((Integer.class.getClassLoader())));
        in.readList(this.modules, (com.phantom.asalama.art.models.Module.class.getClassLoader()));
        this.shortUrl = ((String) in.readValue((String.class.getClassLoader())));
        this.copyright = ((Copyright) in.readValue((Copyright.class.getClassLoader())));
        in.readList(this.tools, (com.phantom.asalama.art.models.Tool.class.getClassLoader()));
        in.readList(this.features, (com.phantom.asalama.art.models.Feature.class.getClassLoader()));
        this.styles = ((Styles) in.readValue((Styles.class.getClassLoader())));
        this.creatorId = ((Integer) in.readValue((Integer.class.getClassLoader())));
    }

    /**
     * No args constructor for use in serialization
     *
     */
    public Project() {
    }

    /**
     *
     * @param stats
     * @param publishedOn
     * @param id
     * @param tools
     * @param conceivedOn
     * @param description
     * @param name
     * @param features
     * @param shortUrl
     * @param fields
     * @param tags
     * @param creatorId
     * @param privacy
     * @param styles
     * @param copyright
     * @param editorVersion
     * @param url
     * @param createdOn
     * @param canvasWidth
     * @param modifiedOn
     * @param covers
     * @param allowComments
     * @param modules
     * @param owners
     * @param matureContent
     * @param matureAccess
     */
    public Project(Integer id, String name, Integer publishedOn, Integer createdOn, Integer modifiedOn, String url, String privacy, List<String> fields, Covers covers, Integer matureContent, String matureAccess, List<Owner> owners, Stats_ stats, Integer conceivedOn, Integer canvasWidth, List<String> tags, String description, Integer editorVersion, Integer allowComments, List<Module> modules, String shortUrl, Copyright copyright, List<Tool> tools, List<Feature> features, Styles styles, Integer creatorId) {
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
        this.canvasWidth = canvasWidth;
        this.tags = tags;
        this.description = description;
        this.editorVersion = editorVersion;
        this.allowComments = allowComments;
        this.modules = modules;
        this.shortUrl = shortUrl;
        this.copyright = copyright;
        this.tools = tools;
        this.features = features;
        this.styles = styles;
        this.creatorId = creatorId;
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

    public Stats_ getStats() {
        return stats;
    }

    public void setStats(Stats_ stats) {
        this.stats = stats;
    }

    public Integer getConceivedOn() {
        return conceivedOn;
    }

    public void setConceivedOn(Integer conceivedOn) {
        this.conceivedOn = conceivedOn;
    }

    public Integer getCanvasWidth() {
        return canvasWidth;
    }

    public void setCanvasWidth(Integer canvasWidth) {
        this.canvasWidth = canvasWidth;
    }

    public List<String> getTags() {
        return tags;
    }

    public void setTags(List<String> tags) {
        this.tags = tags;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Integer getEditorVersion() {
        return editorVersion;
    }

    public void setEditorVersion(Integer editorVersion) {
        this.editorVersion = editorVersion;
    }

    public Integer getAllowComments() {
        return allowComments;
    }

    public void setAllowComments(Integer allowComments) {
        this.allowComments = allowComments;
    }

    public List<Module> getModules() {
        return modules;
    }

    public void setModules(List<Module> modules) {
        this.modules = modules;
    }

    public String getShortUrl() {
        return shortUrl;
    }

    public void setShortUrl(String shortUrl) {
        this.shortUrl = shortUrl;
    }

    public Copyright getCopyright() {
        return copyright;
    }

    public void setCopyright(Copyright copyright) {
        this.copyright = copyright;
    }

    public List<Tool> getTools() {
        return tools;
    }

    public void setTools(List<Tool> tools) {
        this.tools = tools;
    }

    public List<Feature> getFeatures() {
        return features;
    }

    public void setFeatures(List<Feature> features) {
        this.features = features;
    }

    public Styles getStyles() {
        return styles;
    }

    public void setStyles(Styles styles) {
        this.styles = styles;
    }

    public Integer getCreatorId() {
        return creatorId;
    }

    public void setCreatorId(Integer creatorId) {
        this.creatorId = creatorId;
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
        dest.writeValue(canvasWidth);
        dest.writeList(tags);
        dest.writeValue(description);
        dest.writeValue(editorVersion);
        dest.writeValue(allowComments);
        dest.writeList(modules);
        dest.writeValue(shortUrl);
        dest.writeValue(copyright);
        dest.writeList(tools);
        dest.writeList(features);
        dest.writeValue(styles);
        dest.writeValue(creatorId);
    }

    public int describeContents() {
        return 0;
    }

}