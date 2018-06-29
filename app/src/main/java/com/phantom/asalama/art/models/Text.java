package com.phantom.asalama.art.models;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Text implements Parcelable
{

    @SerializedName("title")
    @Expose
    private Title title;
    @SerializedName("subtitle")
    @Expose
    private Subtitle subtitle;
    @SerializedName("paragraph")
    @Expose
    private Paragraph paragraph;
    @SerializedName("caption")
    @Expose
    private Caption caption;
    @SerializedName("link")
    @Expose
    private Link link;
    public final static Parcelable.Creator<Text> CREATOR = new Creator<Text>() {


        @SuppressWarnings({
                "unchecked"
        })
        public Text createFromParcel(Parcel in) {
            return new Text(in);
        }

        public Text[] newArray(int size) {
            return (new Text[size]);
        }

    }
            ;

    protected Text(Parcel in) {
        this.title = ((Title) in.readValue((Title.class.getClassLoader())));
        this.subtitle = ((Subtitle) in.readValue((Subtitle.class.getClassLoader())));
        this.paragraph = ((Paragraph) in.readValue((Paragraph.class.getClassLoader())));
        this.caption = ((Caption) in.readValue((Caption.class.getClassLoader())));
        this.link = ((Link) in.readValue((Link.class.getClassLoader())));
    }

    /**
     * No args constructor for use in serialization
     *
     */
    public Text() {
    }

    /**
     *
     * @param title
     * @param paragraph
     * @param link
     * @param subtitle
     * @param caption
     */
    public Text(Title title, Subtitle subtitle, Paragraph paragraph, Caption caption, Link link) {
        super();
        this.title = title;
        this.subtitle = subtitle;
        this.paragraph = paragraph;
        this.caption = caption;
        this.link = link;
    }

    public Title getTitle() {
        return title;
    }

    public void setTitle(Title title) {
        this.title = title;
    }

    public Subtitle getSubtitle() {
        return subtitle;
    }

    public void setSubtitle(Subtitle subtitle) {
        this.subtitle = subtitle;
    }

    public Paragraph getParagraph() {
        return paragraph;
    }

    public void setParagraph(Paragraph paragraph) {
        this.paragraph = paragraph;
    }

    public Caption getCaption() {
        return caption;
    }

    public void setCaption(Caption caption) {
        this.caption = caption;
    }

    public Link getLink() {
        return link;
    }

    public void setLink(Link link) {
        this.link = link;
    }


    public void writeToParcel(Parcel dest, int flags) {
        dest.writeValue(title);
        dest.writeValue(subtitle);
        dest.writeValue(paragraph);
        dest.writeValue(caption);
        dest.writeValue(link);
    }

    public int describeContents() {
        return 0;
    }

}
