package com.phantom.asalama.art.models;


import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Covers implements Parcelable
{

    @SerializedName("115")
    @Expose
    private String _115;
    @SerializedName("202")
    @Expose
    private String _202;
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
        this._115 = ((String) in.readValue((String.class.getClassLoader())));
        this._202 = ((String) in.readValue((String.class.getClassLoader())));
    }

    /**
     * No args constructor for use in serialization
     *
     */
    public Covers() {
    }

    /**
     *
     * @param _202
     * @param _115
     */
    public Covers(String _115, String _202) {
        super();
        this._115 = _115;
        this._202 = _202;
    }

    public String get115() {
        return _115;
    }

    public void set115(String _115) {
        this._115 = _115;
    }

    public String get202() {
        return _202;
    }

    public void set202(String _202) {
        this._202 = _202;
    }



    public void writeToParcel(Parcel dest, int flags) {
        dest.writeValue(_115);
        dest.writeValue(_202);
    }

    public int describeContents() {
        return 0;
    }

}