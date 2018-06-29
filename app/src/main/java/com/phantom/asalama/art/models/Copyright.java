package com.phantom.asalama.art.models;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Copyright implements Parcelable
{

    @SerializedName("license")
    @Expose
    private String license;
    @SerializedName("description")
    @Expose
    private String description;
    @SerializedName("license_id")
    @Expose
    private Integer licenseId;
    public final static Parcelable.Creator<Copyright> CREATOR = new Creator<Copyright>() {


        @SuppressWarnings({
                "unchecked"
        })
        public Copyright createFromParcel(Parcel in) {
            return new Copyright(in);
        }

        public Copyright[] newArray(int size) {
            return (new Copyright[size]);
        }

    }
            ;

    protected Copyright(Parcel in) {
        this.license = ((String) in.readValue((String.class.getClassLoader())));
        this.description = ((String) in.readValue((String.class.getClassLoader())));
        this.licenseId = ((Integer) in.readValue((Integer.class.getClassLoader())));
    }

    /**
     * No args constructor for use in serialization
     *
     */
    public Copyright() {
    }

    /**
     *
     * @param licenseId
     * @param description
     * @param license
     */
    public Copyright(String license, String description, Integer licenseId) {
        super();
        this.license = license;
        this.description = description;
        this.licenseId = licenseId;
    }

    public String getLicense() {
        return license;
    }

    public void setLicense(String license) {
        this.license = license;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Integer getLicenseId() {
        return licenseId;
    }

    public void setLicenseId(Integer licenseId) {
        this.licenseId = licenseId;
    }



    public void writeToParcel(Parcel dest, int flags) {
        dest.writeValue(license);
        dest.writeValue(description);
        dest.writeValue(licenseId);
    }

    public int describeContents() {
        return 0;
    }

}