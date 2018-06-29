package com.phantom.asalama.art.models;

import android.os.Parcel;
import android.os.Parcelable;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class ProjectPage implements Parcelable
{

    @SerializedName("project")
    @Expose
    private Project project;
    @SerializedName("http_code")
    @Expose
    private Integer httpCode;
    public final static Parcelable.Creator<ProjectPage> CREATOR = new Creator<ProjectPage>() {


        @SuppressWarnings({
                "unchecked"
        })
        public ProjectPage createFromParcel(Parcel in) {
            return new ProjectPage(in);
        }

        public ProjectPage[] newArray(int size) {
            return (new ProjectPage[size]);
        }

    }
            ;

    protected ProjectPage(Parcel in) {
        this.project = ((Project) in.readValue((Project.class.getClassLoader())));
        this.httpCode = ((Integer) in.readValue((Integer.class.getClassLoader())));
    }

    /**
     * No args constructor for use in serialization
     *
     */
    public ProjectPage() {
    }

    /**
     *
     * @param project
     * @param httpCode
     */
    public ProjectPage(Project project, Integer httpCode) {
        super();
        this.project = project;
        this.httpCode = httpCode;
    }

    public Project getProject() {
        return project;
    }

    public void setProject(Project project) {
        this.project = project;
    }

    public Integer getHttpCode() {
        return httpCode;
    }

    public void setHttpCode(Integer httpCode) {
        this.httpCode = httpCode;
    }

    public void writeToParcel(Parcel dest, int flags) {
        dest.writeValue(project);
        dest.writeValue(httpCode);
    }

    public int describeContents() {
        return 0;
    }

}