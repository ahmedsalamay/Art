package com.phantom.asalama.art.models;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Dividers implements Parcelable
{

    @SerializedName("font_size")
    @Expose
    private String fontSize;
    @SerializedName("line_height")
    @Expose
    private String lineHeight;
    @SerializedName("height")
    @Expose
    private String height;
    @SerializedName("border_color")
    @Expose
    private String borderColor;
    @SerializedName("margin")
    @Expose
    private String margin;
    @SerializedName("position")
    @Expose
    private String position;
    @SerializedName("top")
    @Expose
    private String top;
    @SerializedName("border_width")
    @Expose
    private String borderWidth;
    @SerializedName("border_style")
    @Expose
    private String borderStyle;
    public final static Parcelable.Creator<Dividers> CREATOR = new Creator<Dividers>() {


        @SuppressWarnings({
                "unchecked"
        })
        public Dividers createFromParcel(Parcel in) {
            return new Dividers(in);
        }

        public Dividers[] newArray(int size) {
            return (new Dividers[size]);
        }

    }
            ;

    protected Dividers(Parcel in) {
        this.fontSize = ((String) in.readValue((String.class.getClassLoader())));
        this.lineHeight = ((String) in.readValue((String.class.getClassLoader())));
        this.height = ((String) in.readValue((String.class.getClassLoader())));
        this.borderColor = ((String) in.readValue((String.class.getClassLoader())));
        this.margin = ((String) in.readValue((String.class.getClassLoader())));
        this.position = ((String) in.readValue((String.class.getClassLoader())));
        this.top = ((String) in.readValue((String.class.getClassLoader())));
        this.borderWidth = ((String) in.readValue((String.class.getClassLoader())));
        this.borderStyle = ((String) in.readValue((String.class.getClassLoader())));
    }

    /**
     * No args constructor for use in serialization
     *
     */
    public Dividers() {
    }

    /**
     *
     * @param position
     * @param borderStyle
     * @param lineHeight
     * @param borderColor
     * @param height
     * @param borderWidth
     * @param margin
     * @param fontSize
     * @param top
     */
    public Dividers(String fontSize, String lineHeight, String height, String borderColor, String margin, String position, String top, String borderWidth, String borderStyle) {
        super();
        this.fontSize = fontSize;
        this.lineHeight = lineHeight;
        this.height = height;
        this.borderColor = borderColor;
        this.margin = margin;
        this.position = position;
        this.top = top;
        this.borderWidth = borderWidth;
        this.borderStyle = borderStyle;
    }

    public String getFontSize() {
        return fontSize;
    }

    public void setFontSize(String fontSize) {
        this.fontSize = fontSize;
    }

    public String getLineHeight() {
        return lineHeight;
    }

    public void setLineHeight(String lineHeight) {
        this.lineHeight = lineHeight;
    }

    public String getHeight() {
        return height;
    }

    public void setHeight(String height) {
        this.height = height;
    }

    public String getBorderColor() {
        return borderColor;
    }

    public void setBorderColor(String borderColor) {
        this.borderColor = borderColor;
    }

    public String getMargin() {
        return margin;
    }

    public void setMargin(String margin) {
        this.margin = margin;
    }

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    public String getTop() {
        return top;
    }

    public void setTop(String top) {
        this.top = top;
    }

    public String getBorderWidth() {
        return borderWidth;
    }

    public void setBorderWidth(String borderWidth) {
        this.borderWidth = borderWidth;
    }

    public String getBorderStyle() {
        return borderStyle;
    }

    public void setBorderStyle(String borderStyle) {
        this.borderStyle = borderStyle;
    }


    public void writeToParcel(Parcel dest, int flags) {
        dest.writeValue(fontSize);
        dest.writeValue(lineHeight);
        dest.writeValue(height);
        dest.writeValue(borderColor);
        dest.writeValue(margin);
        dest.writeValue(position);
        dest.writeValue(top);
        dest.writeValue(borderWidth);
        dest.writeValue(borderStyle);
    }

    public int describeContents() {
        return 0;
    }

}