package com.phantom.asalama.art.models;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Styles implements Parcelable
{

    @SerializedName("text")
    @Expose
    private Text text;
    @SerializedName("background")
    @Expose
    private Background background;
    @SerializedName("spacing")
    @Expose
    private Spacing spacing;
    @SerializedName("dividers")
    @Expose
    private Dividers dividers;
    public final static Parcelable.Creator<Styles> CREATOR = new Creator<Styles>() {


        @SuppressWarnings({
                "unchecked"
        })
        public Styles createFromParcel(Parcel in) {
            return new Styles(in);
        }

        public Styles[] newArray(int size) {
            return (new Styles[size]);
        }

    }
            ;

    protected Styles(Parcel in) {
        this.text = ((Text) in.readValue((Text.class.getClassLoader())));
        this.background = ((Background) in.readValue((Background.class.getClassLoader())));
        this.spacing = ((Spacing) in.readValue((Spacing.class.getClassLoader())));
        this.dividers = ((Dividers) in.readValue((Dividers.class.getClassLoader())));
    }

    /**
     * No args constructor for use in serialization
     *
     */
    public Styles() {
    }

    /**
     *
     * @param text
     * @param dividers
     * @param background
     * @param spacing
     */
    public Styles(Text text, Background background, Spacing spacing, Dividers dividers) {
        super();
        this.text = text;
        this.background = background;
        this.spacing = spacing;
        this.dividers = dividers;
    }

    public Text getText() {
        return text;
    }

    public void setText(Text text) {
        this.text = text;
    }

    public Background getBackground() {
        return background;
    }

    public void setBackground(Background background) {
        this.background = background;
    }

    public Spacing getSpacing() {
        return spacing;
    }

    public void setSpacing(Spacing spacing) {
        this.spacing = spacing;
    }

    public Dividers getDividers() {
        return dividers;
    }

    public void setDividers(Dividers dividers) {
        this.dividers = dividers;
    }

    public void writeToParcel(Parcel dest, int flags) {
        dest.writeValue(text);
        dest.writeValue(background);
        dest.writeValue(spacing);
        dest.writeValue(dividers);
    }

    public int describeContents() {
        return 0;
    }

}