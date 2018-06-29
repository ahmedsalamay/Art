package com.phantom.asalama.art.models;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Tool implements Parcelable
{

    @SerializedName("id")
    @Expose
    private Integer id;
    @SerializedName("title")
    @Expose
    private String title;
    @SerializedName("category")
    @Expose
    private String category;
    @SerializedName("category_label")
    @Expose
    private String categoryLabel;
    @SerializedName("category_id")
    @Expose
    private Integer categoryId;
    @SerializedName("synonym")
    @Expose
    private Synonym synonym;
    @SerializedName("approved")
    @Expose
    private String approved;
    @SerializedName("url")
    @Expose
    private String url;
    public final static Parcelable.Creator<Tool> CREATOR = new Creator<Tool>() {


        @SuppressWarnings({
                "unchecked"
        })
        public Tool createFromParcel(Parcel in) {
            return new Tool(in);
        }

        public Tool[] newArray(int size) {
            return (new Tool[size]);
        }

    }
            ;

    protected Tool(Parcel in) {
        this.id = ((Integer) in.readValue((Integer.class.getClassLoader())));
        this.title = ((String) in.readValue((String.class.getClassLoader())));
        this.category = ((String) in.readValue((String.class.getClassLoader())));
        this.categoryLabel = ((String) in.readValue((String.class.getClassLoader())));
        this.categoryId = ((Integer) in.readValue((Integer.class.getClassLoader())));
        this.synonym = ((Synonym) in.readValue((Synonym.class.getClassLoader())));
        this.approved = ((String) in.readValue((String.class.getClassLoader())));
        this.url = ((String) in.readValue((String.class.getClassLoader())));
    }

    /**
     * No args constructor for use in serialization
     *
     */
    public Tool() {
    }

    /**
     *
     * @param id
     * @param approved
     * @param category
     * @param title
     * @param synonym
     * @param categoryId
     * @param categoryLabel
     * @param url
     */
    public Tool(Integer id, String title, String category, String categoryLabel, Integer categoryId, Synonym synonym, String approved, String url) {
        super();
        this.id = id;
        this.title = title;
        this.category = category;
        this.categoryLabel = categoryLabel;
        this.categoryId = categoryId;
        this.synonym = synonym;
        this.approved = approved;
        this.url = url;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getCategoryLabel() {
        return categoryLabel;
    }

    public void setCategoryLabel(String categoryLabel) {
        this.categoryLabel = categoryLabel;
    }

    public Integer getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(Integer categoryId) {
        this.categoryId = categoryId;
    }

    public Synonym getSynonym() {
        return synonym;
    }

    public void setSynonym(Synonym synonym) {
        this.synonym = synonym;
    }

    public String getApproved() {
        return approved;
    }

    public void setApproved(String approved) {
        this.approved = approved;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }



    public void writeToParcel(Parcel dest, int flags) {
        dest.writeValue(id);
        dest.writeValue(title);
        dest.writeValue(category);
        dest.writeValue(categoryLabel);
        dest.writeValue(categoryId);
        dest.writeValue(synonym);
        dest.writeValue(approved);
        dest.writeValue(url);
    }

    public int describeContents() {
        return 0;
    }

}