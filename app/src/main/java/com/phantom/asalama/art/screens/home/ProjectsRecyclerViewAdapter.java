package com.phantom.asalama.art.screens.home;

import android.app.ActivityOptions;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.phantom.asalama.art.R;
import com.phantom.asalama.art.infastructure.Application;
import com.phantom.asalama.art.models.Project;
import com.phantom.asalama.art.screens.detail.Details;
import com.phantom.asalama.art.screens.settings.SettingsActivity;
import com.squareup.picasso.Picasso;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class ProjectsRecyclerViewAdapter extends RecyclerView.Adapter<ProjectsRecyclerViewAdapter.ViewHolder> {

   private  List<Project>mProjects;
   private final AppCompatActivity mParent;
   private final View.OnClickListener mOnClickListener=new View.OnClickListener() {
       @Override
       public void onClick(View v) {
           Project project=(Project) v.getTag();
           Context context=v.getContext();

           if (android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.LOLLIPOP) {
               Bundle bundle= ActivityOptions
                       .makeSceneTransitionAnimation(mParent).toBundle();
               Intent intent=new Intent(context, Details.class);
               intent.putExtra(Details.PROJECT_ITEM_KEY,project);
               mParent.startActivity(intent,bundle);

           }else{
               Intent intent=new Intent(context, Details.class);
               intent.putExtra(Details.PROJECT_ITEM_KEY,project);
               mParent.startActivity(intent);
           }
              }
   };

    public ProjectsRecyclerViewAdapter(AppCompatActivity parent, List<Project> projects){
        mParent=parent;
        mProjects=projects;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(parent.getContext())
                .inflate(R.layout.list_item_project,parent,false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {

        Picasso picasso=((Application)(mParent.getApplication())).getPicasso();
        picasso.load(mProjects.get(position).getCovers().get230())
                .placeholder(R.drawable.placeholder)
                .error(R.drawable.placeholder)
                .into(holder.Cover);
        holder.ProjectName.setText(mProjects.get(position).getName());
        holder.ArtistName.setText(mProjects.get(position).getOwners().get(0).getDisplayName());
        /*holder.Views.setText(mProjects.get(position).getStats().getViews().toString());
        holder.Apprecations.
                setText(mProjects.get(position).getStats().getAppreciations().toString() );
        holder.CreativeFields.setText(Utility.convertArrayToString(mProjects.get(position).getFields()).replace("__,__",""));
       */
        holder.itemView.setTag(mProjects.get(position));
        holder.itemView.setOnClickListener(mOnClickListener);
    }

    @Override
    public int getItemCount() {
        if(mProjects==null)
            return 0;
        return mProjects.size();
    }

    public void setNewData(List<Project> newData) {
        mProjects = newData;
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
       @BindView(R.id.cover_img)  ImageView Cover;
       @BindView(R.id.project_name_txt)   TextView ProjectName;
       @BindView(R.id.artist_name_txt)  TextView ArtistName;
      //@BindView(R.id.views_txt)  TextView Views;
       //@BindView(R.id.likes_txt)  TextView Apprecations;
       //@BindView(R.id.creative_field_txt) TextView CreativeFields;

        public ViewHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this,itemView);
        }
    }
}
