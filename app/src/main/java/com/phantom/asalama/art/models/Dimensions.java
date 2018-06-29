
package com.phantom.asalama.art.models;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Dimensions implements Parcelable
{

    @SerializedName("disp")
    @Expose
    private Disp disp;
    @SerializedName("max_1240")
    @Expose
    private Max1240 max1240;
    @SerializedName("max_1200")
    @Expose
    private Max1200 max1200;
    @SerializedName("original")
    @Expose
    private Original original;
    public final static Parcelable.Creator<Dimensions> CREATOR = new Creator<Dimensions>() {


        @SuppressWarnings({
                "unchecked"
        })
        public Dimensions createFromParcel(Parcel in) {
            return new Dimensions(in);
        }

        public Dimensions[] newArray(int size) {
            return (new Dimensions[size]);
        }

    }
            ;

    protected Dimensions(Parcel in) {
        this.disp = ((Disp) in.readValue((Disp.class.getClassLoader())));
        this.max1240 = ((Max1240) in.readValue((Max1240.class.getClassLoader())));
        this.max1200 = ((Max1200) in.readValue((Max1200.class.getClassLoader())));
        this.original = ((Original) in.readValue((Original.class.getClassLoader())));
    }

    /**
     * No args constructor for use in serialization
     *
     */
    public Dimensions() {
    }

    /**
     *
     * @param max1240
     * @param original
     * @param disp
     * @param max1200
     */
    public Dimensions(Disp disp, Max1240 max1240, Max1200 max1200, Original original) {
        super();
        this.disp = disp;
        this.max1240 = max1240;
        this.max1200 = max1200;
        this.original = original;
    }

    public Disp getDisp() {
        return disp;
    }

    public void setDisp(Disp disp) {
        this.disp = disp;
    }

    public Max1240 getMax1240() {
        return max1240;
    }

    public void setMax1240(Max1240 max1240) {
        this.max1240 = max1240;
    }

    public Max1200 getMax1200() {
        return max1200;
    }

    public void setMax1200(Max1200 max1200) {
        this.max1200 = max1200;
    }

    public Original getOriginal() {
        return original;
    }

    public void setOriginal(Original original) {
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