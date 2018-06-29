package com.phantom.asalama.art.models;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Covers implements Parcelable
{

    @SerializedName("404")
    @Expose
    private String _404;
    @SerializedName("202")
    @Expose
    private String _202;
    @SerializedName("230")
    @Expose
    private String _230;
    @SerializedName("115")
    @Expose
    private String _115;
    @SerializedName("original")
    @Expose
    private String original;
    public final static Parcelable.Creator<Covers> CREATOR = new Creator<Covers>() {


        @SuppressWarnings({
                "unchecked"
        })
        public Covers createFromParcel(Parcel in) {
            return new Covers(in);
        }

        public Covers[] newArray(int size) {
            return (new Covers[size]);
        }

    }
            ;

    protected Covers(Parcel in) {
        this._404 = ((String) in.readValue((String.class.getClassLoader())));
        this._202 = ((String) in.readValue((String.class.getClassLoader())));
        this._230 = ((String) in.readValue((String.class.getClassLoader())));
        this._115 = ((String) in.readValue((String.class.getClassLoader())));
        this.original = ((String) in.readValue((String.class.getClassLoader())));
    }

    /**
     * No args constructor for use in serialization
     *
     */
    public Covers() {
    }

    /**
     *
     * @param _230
     * @param original
     * @param _202
     * @param _115
     * @param _404
     */
    public Covers(String _404, String _202, String _230, String _115, String original) {
        super();
        this._404 = _404;
        this._202 = _202;
        this._230 = _230;
        this._115 = _115;
        this.original = original;
    }

    public String get404() {
        return _404;
    }

    public void set404(String _404) {
        this._404 = _404;
    }

    public String get202() {
        return _202;
    }

    public void set202(String _202) {
        this._202 = _202;
    }

    public String get230() {
        return _230;
    }

    public void set230(String _230) {
        this._230 = _230;
    }

    public String get115() {
        return _115;
    }

    public void set115(String _115) {
        this._115 = _115;
    }

    public String getOriginal() {
        return original;
    }

    public void setOriginal(String original) {
        this.original = original;
    }



    public void writeToParcel(Parcel dest, int flags) {
        dest.writeValue(_404);
        dest.writeValue(_202);
        dest.writeValue(_230);
        dest.writeValue(_115);
        dest.writeValue(original);
    }

    public int describeContents() {
        return 0;
    }

}
