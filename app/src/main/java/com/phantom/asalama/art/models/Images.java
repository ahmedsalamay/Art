package com.phantom.asalama.art.models;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Images implements Parcelable
{

    @SerializedName("50")
    @Expose
    private String _50;
    @SerializedName("100")
    @Expose
    private String _100;
    @SerializedName("115")
    @Expose
    private String _115;
    @SerializedName("230")
    @Expose
    private String _230;
    @SerializedName("138")
    @Expose
    private String _138;
    @SerializedName("276")
    @Expose
    private String _276;
    public final static Parcelable.Creator<Images> CREATOR = new Creator<Images>() {


        @SuppressWarnings({
                "unchecked"
        })
        public Images createFromParcel(Parcel in) {
            return new Images(in);
        }

        public Images[] newArray(int size) {
            return (new Images[size]);
        }

    }
            ;

    protected Images(Parcel in) {
        this._50 = ((String) in.readValue((String.class.getClassLoader())));
        this._100 = ((String) in.readValue((String.class.getClassLoader())));
        this._115 = ((String) in.readValue((String.class.getClassLoader())));
        this._230 = ((String) in.readValue((String.class.getClassLoader())));
        this._138 = ((String) in.readValue((String.class.getClassLoader())));
        this._276 = ((String) in.readValue((String.class.getClassLoader())));
    }

    /**
     * No args constructor for use in serialization
     *
     */
    public Images() {
    }

    /**
     *
     * @param _230
     * @param _138
     * @param _50
     * @param _100
     * @param _115
     * @param _276
     */
    public Images(String _50, String _100, String _115, String _230, String _138, String _276) {
        super();
        this._50 = _50;
        this._100 = _100;
        this._115 = _115;
        this._230 = _230;
        this._138 = _138;
        this._276 = _276;
    }

    public String get50() {
        return _50;
    }

    public void set50(String _50) {
        this._50 = _50;
    }

    public String get100() {
        return _100;
    }

    public void set100(String _100) {
        this._100 = _100;
    }

    public String get115() {
        return _115;
    }

    public void set115(String _115) {
        this._115 = _115;
    }

    public String get230() {
        return _230;
    }

    public void set230(String _230) {
        this._230 = _230;
    }

    public String get138() {
        return _138;
    }

    public void set138(String _138) {
        this._138 = _138;
    }

    public String get276() {
        return _276;
    }

    public void set276(String _276) {
        this._276 = _276;
    }



    public void writeToParcel(Parcel dest, int flags) {
        dest.writeValue(_50);
        dest.writeValue(_100);
        dest.writeValue(_115);
        dest.writeValue(_230);
        dest.writeValue(_138);
        dest.writeValue(_276);
    }

    public int describeContents() {
        return 0;
    }

}