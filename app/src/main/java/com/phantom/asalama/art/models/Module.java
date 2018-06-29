package com.phantom.asalama.art.models;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Module implements Parcelable
{

    @SerializedName("id")
    @Expose
    private Integer id;
    @SerializedName("project_id")
    @Expose
    private Integer projectId;
    @SerializedName("type")
    @Expose
    private String type;
    @SerializedName("full_bleed")
    @Expose
    private Integer fullBleed;
    @SerializedName("alignment")
    @Expose
    private String alignment;
    @SerializedName("caption_alignment")
    @Expose
    private String captionAlignment;
    @SerializedName("src")
    @Expose
    private String src;
    @SerializedName("sizes")
    @Expose
    private Sizes sizes;
    @SerializedName("dimensions")
    @Expose
    private Dimensions dimensions;
    @SerializedName("width")
    @Expose
    private Integer width;
    @SerializedName("height")
    @Expose
    private Integer height;
    @SerializedName("text")
    @Expose
    private String text;
    @SerializedName("text_plain")
    @Expose
    private String textPlain;
    public final static Parcelable.Creator<Module> CREATOR = new Creator<Module>() {


        @SuppressWarnings({
                "unchecked"
        })
        public Module createFromParcel(Parcel in) {
            return new Module(in);
        }

        public Module[] newArray(int size) {
            return (new Module[size]);
        }

    }
            ;

    protected Module(Parcel in) {
        this.id = ((Integer) in.readValue((Integer.class.getClassLoader())));
        this.projectId = ((Integer) in.readValue((Integer.class.getClassLoader())));
        this.type = ((String) in.readValue((String.class.getClassLoader())));
        this.fullBleed = ((Integer) in.readValue((Integer.class.getClassLoader())));
        this.alignment = ((String) in.readValue((String.class.getClassLoader())));
        this.captionAlignment = ((String) in.readValue((String.class.getClassLoader())));
        this.src = ((String) in.readValue((String.class.getClassLoader())));
        this.sizes = ((Sizes) in.readValue((Sizes.class.getClassLoader())));
        this.dimensions = ((Dimensions) in.readValue((Dimensions.class.getClassLoader())));
        this.width = ((Integer) in.readValue((Integer.class.getClassLoader())));
        this.height = ((Integer) in.readValue((Integer.class.getClassLoader())));
        this.text = ((String) in.readValue((String.class.getClassLoader())));
        this.textPlain = ((String) in.readValue((String.class.getClassLoader())));
    }

    /**
     * No args constructor for use in serialization
     *
     */
    public Module() {
    }

    /**
     *
     * @param sizes
     * @param alignment
     * @param text
     * @param width
     * @param projectId
     * @param type
     * @param fullBleed
     * @param id
     * @param height
     * @param captionAlignment
     * @param dimensions
     * @param src
     * @param textPlain
     */
    public Module(Integer id, Integer projectId, String type, Integer fullBleed, String alignment, String captionAlignment, String src, Sizes sizes, Dimensions dimensions, Integer width, Integer height, String text, String textPlain) {
        super();
        this.id = id;
        this.projectId = projectId;
        this.type = type;
        this.fullBleed = fullBleed;
        this.alignment = alignment;
        this.captionAlignment = captionAlignment;
        this.src = src;
        this.sizes = sizes;
        this.dimensions = dimensions;
        this.width = width;
        this.height = height;
        this.text = text;
        this.textPlain = textPlain;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getProjectId() {
        return projectId;
    }

    public void setProjectId(Integer projectId) {
        this.projectId = projectId;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public Integer getFullBleed() {
        return fullBleed;
    }

    public void setFullBleed(Integer fullBleed) {
        this.fullBleed = fullBleed;
    }

    public String getAlignment() {
        return alignment;
    }

    public void setAlignment(String alignment) {
        this.alignment = alignment;
    }

    public String getCaptionAlignment() {
        return captionAlignment;
    }

    public void setCaptionAlignment(String captionAlignment) {
        this.captionAlignment = captionAlignment;
    }

    public String getSrc() {
        return src;
    }

    public void setSrc(String src) {
        this.src = src;
    }

    public Sizes getSizes() {
        return sizes;
    }

    public void setSizes(Sizes sizes) {
        this.sizes = sizes;
    }

    public Dimensions getDimensions() {
        return dimensions;
    }

    public void setDimensions(Dimensions dimensions) {
        this.dimensions = dimensions;
    }

    public Integer getWidth() {
        return width;
    }

    public void setWidth(Integer width) {
        this.width = width;
    }

    public Integer getHeight() {
        return height;
    }

    public void setHeight(Integer height) {
        this.height = height;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public String getTextPlain() {
        return textPlain;
    }

    public void setTextPlain(String textPlain) {
        this.textPlain = textPlain;
    }


    public void writeToParcel(Parcel dest, int flags) {
        dest.writeValue(id);
        dest.writeValue(projectId);
        dest.writeValue(type);
        dest.writeValue(fullBleed);
        dest.writeValue(alignment);
        dest.writeValue(captionAlignment);
        dest.writeValue(src);
        dest.writeValue(sizes);
        dest.writeValue(dimensions);
        dest.writeValue(width);
        dest.writeValue(height);
        dest.writeValue(text);
        dest.writeValue(textPlain);
    }

    public int describeContents() {
        return 0;
    }

}