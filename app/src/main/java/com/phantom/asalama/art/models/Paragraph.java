
package com.phantom.asalama.art.models;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Paragraph implements Parcelable
{

    @SerializedName("font_family")
    @Expose
    private String fontFamily;
    @SerializedName("font_weight")
    @Expose
    private String fontWeight;
    @SerializedName("color")
    @Expose
    private String color;
    @SerializedName("text_align")
    @Expose
    private String textAlign;
    @SerializedName("line_height")
    @Expose
    private String lineHeight;
    @SerializedName("font_size")
    @Expose
    private String fontSize;
    @SerializedName("text_decoration")
    @Expose
    private String textDecoration;
    @SerializedName("font_style")
    @Expose
    private String fontStyle;
    @SerializedName("display")
    @Expose
    private String display;
    @SerializedName("text_transform")
    @Expose
    private String textTransform;
    public final static Parcelable.Creator<Paragraph> CREATOR = new Creator<Paragraph>() {


        @SuppressWarnings({
                "unchecked"
        })
        public Paragraph createFromParcel(Parcel in) {
            return new Paragraph(in);
        }

        public Paragraph[] newArray(int size) {
            return (new Paragraph[size]);
        }

    }
            ;

    protected Paragraph(Parcel in) {
        this.fontFamily = ((String) in.readValue((String.class.getClassLoader())));
        this.fontWeight = ((String) in.readValue((String.class.getClassLoader())));
        this.color = ((String) in.readValue((String.class.getClassLoader())));
        this.textAlign = ((String) in.readValue((String.class.getClassLoader())));
        this.lineHeight = ((String) in.readValue((String.class.getClassLoader())));
        this.fontSize = ((String) in.readValue((String.class.getClassLoader())));
        this.textDecoration = ((String) in.readValue((String.class.getClassLoader())));
        this.fontStyle = ((String) in.readValue((String.class.getClassLoader())));
        this.display = ((String) in.readValue((String.class.getClassLoader())));
        this.textTransform = ((String) in.readValue((String.class.getClassLoader())));
    }

    /**
     * No args constructor for use in serialization
     *
     */
    public Paragraph() {
    }

    /**
     *
     * @param fontWeight
     * @param lineHeight
     * @param textDecoration
     * @param color
     * @param textTransform
     * @param display
     * @param fontStyle
     * @param textAlign
     * @param fontFamily
     * @param fontSize
     */
    public Paragraph(String fontFamily, String fontWeight, String color, String textAlign, String lineHeight, String fontSize, String textDecoration, String fontStyle, String display, String textTransform) {
        super();
        this.fontFamily = fontFamily;
        this.fontWeight = fontWeight;
        this.color = color;
        this.textAlign = textAlign;
        this.lineHeight = lineHeight;
        this.fontSize = fontSize;
        this.textDecoration = textDecoration;
        this.fontStyle = fontStyle;
        this.display = display;
        this.textTransform = textTransform;
    }

    public String getFontFamily() {
        return fontFamily;
    }

    public void setFontFamily(String fontFamily) {
        this.fontFamily = fontFamily;
    }

    public String getFontWeight() {
        return fontWeight;
    }

    public void setFontWeight(String fontWeight) {
        this.fontWeight = fontWeight;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public String getTextAlign() {
        return textAlign;
    }

    public void setTextAlign(String textAlign) {
        this.textAlign = textAlign;
    }

    public String getLineHeight() {
        return lineHeight;
    }

    public void setLineHeight(String lineHeight) {
        this.lineHeight = lineHeight;
    }

    public String getFontSize() {
        return fontSize;
    }

    public void setFontSize(String fontSize) {
        this.fontSize = fontSize;
    }

    public String getTextDecoration() {
        return textDecoration;
    }

    public void setTextDecoration(String textDecoration) {
        this.textDecoration = textDecoration;
    }

    public String getFontStyle() {
        return fontStyle;
    }

    public void setFontStyle(String fontStyle) {
        this.fontStyle = fontStyle;
    }

    public String getDisplay() {
        return display;
    }

    public void setDisplay(String display) {
        this.display = display;
    }

    public String getTextTransform() {
        return textTransform;
    }

    public void setTextTransform(String textTransform) {
        this.textTransform = textTransform;
    }


    public void writeToParcel(Parcel dest, int flags) {
        dest.writeValue(fontFamily);
        dest.writeValue(fontWeight);
        dest.writeValue(color);
        dest.writeValue(textAlign);
        dest.writeValue(lineHeight);
        dest.writeValue(fontSize);
        dest.writeValue(textDecoration);
        dest.writeValue(fontStyle);
        dest.writeValue(display);
        dest.writeValue(textTransform);
    }

    public int describeContents() {
        return 0;
    }

}
