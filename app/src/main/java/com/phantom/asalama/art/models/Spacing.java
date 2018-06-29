package com.phantom.asalama.art.models;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Spacing implements Parcelable
{

    @SerializedName("project")
    @Expose
    private Project_ project;
    @SerializedName("modules")
    @Expose
    private Modules modules;
    public final static Parcelable.Creator<Spacing> CREATOR = new Creator<Spacing>() {


        @SuppressWarnings({
                "unchecked"
        })
        public Spacing createFromParcel(Parcel in) {
            return new Spacing(in);
        }

        public Spacing[] newArray(int size) {
            return (new Spacing[size]);
        }

    }
            ;

    protected Spacing(Parcel in) {
        this.project = ((Project_) in.readValue((Project_.class.getClassLoader())));
        this.modules = ((Modules) in.readValue((Modules.class.getClassLoader())));
    }

    /**
     * No args constructor for use in serialization
     *
     */
    public Spacing() {
    }

    /**
     *
     * @param project
     * @param modules
     */
    public Spacing(Project_ project, Modules modules) {
        super();
        this.project = project;
        this.modules = modules;
    }

    public Project_ getProject() {
        return project;
    }

    public void setProject(Project_ project) {
        this.project = project;
    }

    public Modules getModules() {
        return modules;
    }

    public void setModules(Modules modules) {
        this.modules = modules;
    }

    public void writeToParcel(Parcel dest, int flags) {
        dest.writeValue(project);
        dest.writeValue(modules);
    }

    public int describeContents() {
        return 0;
    }

}