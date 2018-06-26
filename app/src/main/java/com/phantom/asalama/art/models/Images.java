package com.phantom.asalama.art.models;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Images implements Parcelable
{

    @SerializedName("32")
    @Expose
    private String _32;
    @SerializedName("50")
    @Expose
    private String _50;
    @SerializedName("78")
    @Expose
    private String _78;
    @SerializedName("115")
    @Expose
    private String _115;
    @SerializedName("129")
    @Expose
    private String _129;
    @SerializedName("138")
    @Expose
    private String _138;
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
        this._32 = ((String) in.readValue((String.class.getClassLoader())));
        this._50 = ((String) in.readValue((String.class.getClassLoader())));
        this._78 = ((String) in.readValue((String.class.getClassLoader())));
        this._115 = ((String) in.readValue((String.class.getClassLoader())));
        this._129 = ((String) in.readValue((String.class.getClassLoader())));
        this._138 = ((String) in.readValue((String.class.getClassLoader())));
    }

    /**
     * No args constructor for use in serialization
     *
     */
    public Images() {
    }

    /**
     *
     * @param _32
     * @param _129
     * @param _138
     * @param _78
     * @param _50
     * @param _115
     */
    public Images(String _32, String _50, String _78, String _115, String _129, String _138) {
        super();
        this._32 = _32;
        this._50 = _50;
        this._78 = _78;
        this._115 = _115;
        this._129 = _129;
        this._138 = _138;
    }

    public String get32() {
        return _32;
    }

    public void set32(String _32) {
        this._32 = _32;
    }

    public String get50() {
        return _50;
    }

    public void set50(String _50) {
        this._50 = _50;
    }

    public String get78() {
        return _78;
    }

    public void set78(String _78) {
        this._78 = _78;
    }

    public String get115() {
        return _115;
    }

    public void set115(String _115) {
        this._115 = _115;
    }

    public String get129() {
        return _129;
    }

    public void set129(String _129) {
        this._129 = _129;
    }

    public String get138() {
        return _138;
    }

    public void set138(String _138) {
        this._138 = _138;
    }

    public void writeToParcel(Parcel dest, int flags) {
        dest.writeValue(_32);
        dest.writeValue(_50);
        dest.writeValue(_78);
        dest.writeValue(_115);
        dest.writeValue(_129);
        dest.writeValue(_138);
    }

    public int describeContents() {
        return 0;
    }

}