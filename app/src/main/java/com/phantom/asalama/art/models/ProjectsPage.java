
package com.phantom.asalama.art.models;

import java.util.List;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class ProjectsPage implements Parcelable
{

    @SerializedName("projects")
    @Expose
    private List<Project> projects = null;
    public final static Parcelable.Creator<ProjectsPage> CREATOR = new Creator<ProjectsPage>() {


        @SuppressWarnings({
                "unchecked"
        })
        public ProjectsPage createFromParcel(Parcel in) {
            return new ProjectsPage(in);
        }

        public ProjectsPage[] newArray(int size) {
            return (new ProjectsPage[size]);
        }

    }
            ;

    protected ProjectsPage(Parcel in) {
        in.readList(this.projects, (com.phantom.asalama.art.models.Project.class.getClassLoader()));
    }

    /**
     * No args constructor for use in serialization
     *
     */
    public ProjectsPage() {
    }

    /**
     *
     * @param projects
     */
    public ProjectsPage(List<Project> projects) {
        super();
        this.projects = projects;
    }

    public List<Project> getProjects() {
        return projects;
    }

    public void setProjects(List<Project> projects) {
        this.projects = projects;
    }


    public void writeToParcel(Parcel dest, int flags) {
        dest.writeList(projects);
    }

    public int describeContents() {
        return 0;
    }

}