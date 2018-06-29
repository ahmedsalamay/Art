package com.phantom.asalama.art.models;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Color implements Parcelable
{

    @SerializedName("h")
    @Expose
    private Double h;
    @SerializedName("s")
    @Expose
    private Double s;
    @SerializedName("v")
    @Expose
    private Double v;
    @SerializedName("r")
    @Expose
    private Integer r;
    @SerializedName("g")
    @Expose
    private Integer g;
    @SerializedName("b")
    @Expose
    private Integer b;
    public final static Parcelable.Creator<Color> CREATOR = new Creator<Color>() {


        @SuppressWarnings({
                "unchecked"
        })
        public Color createFromParcel(Parcel in) {
            return new Color(in);
        }

        public Color[] newArray(int size) {
            return (new Color[size]);
        }

    }
            ;

    protected Color(Parcel in) {
        this.h = ((Double) in.readValue((Double.class.getClassLoader())));
        this.s = ((Double) in.readValue((Double.class.getClassLoader())));
        this.v = ((Double) in.readValue((Double.class.getClassLoader())));
        this.r = ((Integer) in.readValue((Integer.class.getClassLoader())));
        this.g = ((Integer) in.readValue((Integer.class.getClassLoader())));
        this.b = ((Integer) in.readValue((Integer.class.getClassLoader())));
    }

    /**
     * No args constructor for use in serialization
     *
     */
    public Color() {
    }

    /**
     *
     * @param g
     * @param v
     * @param b
     * @param s
     * @param r
     * @param h
     */
    public Color(Double h, Double s, Double v, Integer r, Integer g, Integer b) {
        super();
        this.h = h;
        this.s = s;
        this.v = v;
        this.r = r;
        this.g = g;
        this.b = b;
    }

    public Double getH() {
        return h;
    }

    public void setH(Double h) {
        this.h = h;
    }

    public Double getS() {
        return s;
    }

    public void setS(Double s) {
        this.s = s;
    }

    public Double getV() {
        return v;
    }

    public void setV(Double v) {
        this.v = v;
    }

    public Integer getR() {
        return r;
    }

    public void setR(Integer r) {
        this.r = r;
    }

    public Integer getG() {
        return g;
    }

    public void setG(Integer g) {
        this.g = g;
    }

    public Integer getB() {
        return b;
    }

    public void setB(Integer b) {
        this.b = b;
    }



    public void writeToParcel(Parcel dest, int flags) {
        dest.writeValue(h);
        dest.writeValue(s);
        dest.writeValue(v);
        dest.writeValue(r);
        dest.writeValue(g);
        dest.writeValue(b);
    }

    public int describeContents() {
        return 0;
    }

}