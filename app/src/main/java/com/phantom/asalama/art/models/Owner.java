package com.phantom.asalama.art.models;

import java.util.List;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Owner implements Parcelable
{

    @SerializedName("id")
    @Expose
    private Integer id;
    @SerializedName("first_name")
    @Expose
    private String firstName;
    @SerializedName("last_name")
    @Expose
    private String lastName;
    @SerializedName("username")
    @Expose
    private String username;
    @SerializedName("city")
    @Expose
    private String city;
    @SerializedName("state")
    @Expose
    private String state;
    @SerializedName("country")
    @Expose
    private String country;
    @SerializedName("location")
    @Expose
    private String location;
    @SerializedName("company")
    @Expose
    private String company;
    @SerializedName("occupation")
    @Expose
    private String occupation;
    @SerializedName("created_on")
    @Expose
    private Integer createdOn;
    @SerializedName("url")
    @Expose
    private String url;
    @SerializedName("images")
    @Expose
    private Images images;
    @SerializedName("display_name")
    @Expose
    private String displayName;
    @SerializedName("fields")
    @Expose
    private List<String> fields = null;
    @SerializedName("has_default_image")
    @Expose
    private Integer hasDefaultImage;
    @SerializedName("website")
    @Expose
    private String website;
    @SerializedName("stats")
    @Expose
    private Stats stats;
    public final static Parcelable.Creator<Owner> CREATOR = new Creator<Owner>() {


        @SuppressWarnings({
                "unchecked"
        })
        public Owner createFromParcel(Parcel in) {
            return new Owner(in);
        }

        public Owner[] newArray(int size) {
            return (new Owner[size]);
        }

    }
            ;

    protected Owner(Parcel in) {
        this.id = ((Integer) in.readValue((Integer.class.getClassLoader())));
        this.firstName = ((String) in.readValue((String.class.getClassLoader())));
        this.lastName = ((String) in.readValue((String.class.getClassLoader())));
        this.username = ((String) in.readValue((String.class.getClassLoader())));
        this.city = ((String) in.readValue((String.class.getClassLoader())));
        this.state = ((String) in.readValue((String.class.getClassLoader())));
        this.country = ((String) in.readValue((String.class.getClassLoader())));
        this.location = ((String) in.readValue((String.class.getClassLoader())));
        this.company = ((String) in.readValue((String.class.getClassLoader())));
        this.occupation = ((String) in.readValue((String.class.getClassLoader())));
        this.createdOn = ((Integer) in.readValue((Integer.class.getClassLoader())));
        this.url = ((String) in.readValue((String.class.getClassLoader())));
        this.images = ((Images) in.readValue((Images.class.getClassLoader())));
        this.displayName = ((String) in.readValue((String.class.getClassLoader())));
        in.readList(this.fields, (java.lang.String.class.getClassLoader()));
        this.hasDefaultImage = ((Integer) in.readValue((Integer.class.getClassLoader())));
        this.website = ((String) in.readValue((String.class.getClassLoader())));
        this.stats = ((Stats) in.readValue((Stats.class.getClassLoader())));
    }

    /**
     * No args constructor for use in serialization
     *
     */
    public Owner() {
    }

    /**
     *
     * @param lastName
     * @param occupation
     * @param website
     * @param location
     * @param stats
     * @param state
     * @param url
     * @param city
     * @param country
     * @param id
     * @param createdOn
     * @param hasDefaultImage
     * @param username
     * @param company
     * @param images
     * @param displayName
     * @param firstName
     * @param fields
     */
    public Owner(Integer id, String firstName, String lastName, String username, String city, String state, String country, String location, String company, String occupation, Integer createdOn, String url, Images images, String displayName, List<String> fields, Integer hasDefaultImage, String website, Stats stats) {
        super();
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.username = username;
        this.city = city;
        this.state = state;
        this.country = country;
        this.location = location;
        this.company = company;
        this.occupation = occupation;
        this.createdOn = createdOn;
        this.url = url;
        this.images = images;
        this.displayName = displayName;
        this.fields = fields;
        this.hasDefaultImage = hasDefaultImage;
        this.website = website;
        this.stats = stats;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getCompany() {
        return company;
    }

    public void setCompany(String company) {
        this.company = company;
    }

    public String getOccupation() {
        return occupation;
    }

    public void setOccupation(String occupation) {
        this.occupation = occupation;
    }

    public Integer getCreatedOn() {
        return createdOn;
    }

    public void setCreatedOn(Integer createdOn) {
        this.createdOn = createdOn;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public Images getImages() {
        return images;
    }

    public void setImages(Images images) {
        this.images = images;
    }

    public String getDisplayName() {
        return displayName;
    }

    public void setDisplayName(String displayName) {
        this.displayName = displayName;
    }

    public List<String> getFields() {
        return fields;
    }

    public void setFields(List<String> fields) {
        this.fields = fields;
    }

    public Integer getHasDefaultImage() {
        return hasDefaultImage;
    }

    public void setHasDefaultImage(Integer hasDefaultImage) {
        this.hasDefaultImage = hasDefaultImage;
    }

    public String getWebsite() {
        return website;
    }

    public void setWebsite(String website) {
        this.website = website;
    }

    public Stats getStats() {
        return stats;
    }

    public void setStats(Stats stats) {
        this.stats = stats;
    }



    public void writeToParcel(Parcel dest, int flags) {
        dest.writeValue(id);
        dest.writeValue(firstName);
        dest.writeValue(lastName);
        dest.writeValue(username);
        dest.writeValue(city);
        dest.writeValue(state);
        dest.writeValue(country);
        dest.writeValue(location);
        dest.writeValue(company);
        dest.writeValue(occupation);
        dest.writeValue(createdOn);
        dest.writeValue(url);
        dest.writeValue(images);
        dest.writeValue(displayName);
        dest.writeList(fields);
        dest.writeValue(hasDefaultImage);
        dest.writeValue(website);
        dest.writeValue(stats);
    }

    public int describeContents() {
        return 0;
    }

}