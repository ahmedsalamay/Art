package com.phantom.asalama.art.models;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Sizes implements Parcelable
{

    @SerializedName("disp")
    @Expose
    private String disp;
    @SerializedName("max_1240")
    @Expose
    private String max1240;
    @SerializedName("max_1200")
    @Expose
    private String max1200;
    @SerializedName("original")
    @Expose
    private String original;
    public final static Parcelable.Creator<Sizes> CREATOR = new Creator<Sizes>() {


        @SuppressWarnings({
                "unchecked"
        })
        public Sizes createFromParcel(Parcel in) {
            return new Sizes(in);
        }

        public Sizes[] newArray(int size) {
            return (new Sizes[size]);
        }

    }
            ;

    protected Sizes(Parcel in) {
        this.disp = ((String) in.readValue((String.class.getClassLoader())));
        this.max1240 = ((String) in.readValue((String.class.getClassLoader())));
        this.max1200 = ((String) in.readValue((String.class.getClassLoader())));
        this.original = ((String) in.readValue((String.class.getClassLoader())));
    }

    /**
     * No args constructor for use in serialization
     *
     */
    public Sizes() {
    }

    /**
     *
     * @param max1240
     * @param original
     * @param disp
     * @param max1200
     */
    public Sizes(String disp, String max1240, String max1200, String original) {
        super();
        this.disp = disp;
        this.max1240 = max1240;
        this.max1200 = max1200;
        this.original = original;
    }

    public String getDisp() {
        return disp;
    }

    public void setDisp(String disp) {
        this.disp = disp;
    }

    public String getMax1240() {
        return max1240;
    }

    public void setMax1240(String max1240) {
        this.max1240 = max1240;
    }

    public String getMax1200() {
        return max1200;
    }

    public void setMax1200(String max1200) {
        this.max1200 = max1200;
    }

    public String getOriginal() {
        return original;
    }

    public void setOriginal(String original) {
        this.original = original;
    }


    public void writeToParcel(Parcel dest, int flags) {
        dest.writeValue(disp);
        dest.writeValue(max1240);
        dest.writeValue(max1200);
        dest.writeValue(original);
    }

    public int describeContents() {
        return 0;
    }

}