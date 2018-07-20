package com.phantom.asalama.art.screens.detail;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.phantom.asalama.art.R;
import com.phantom.asalama.art.infastructure.Application;
import com.phantom.asalama.art.models.Module;
import com.squareup.picasso.Picasso;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import timber.log.Timber;

public class ModulesRecyclerViewAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

    private Details mParent;
    private List<Module>mModules;

    public ModulesRecyclerViewAdapter(Details parent, List<Module> moduleList){

        mParent=parent;
        mModules=moduleList;

    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view;
        switch (viewType){
            case 0:
                 view= LayoutInflater.from(parent.getContext())
                         .inflate(R.layout.list_item_module_img,parent,false);
                return new ImagesViewHolder(view);
            case 1:
                 view= LayoutInflater.from(parent.getContext())
                         .inflate(R.layout.list_item_module_txt,parent,false);
                return new TextViewHolder(view);
        }
        return null;
    }

    @Override
    public int getItemViewType(int position) {
        String type=  mModules.get(position).getType();
        if(type.equals("image"))
            return 0;
        else
            return 1;
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {

        switch (holder.getItemViewType()){
            case 0:
                if(mModules.get(position).getSrc().endsWith(mParent.getString(R.string.jpg))||
                        mModules.get(position).getSrc().endsWith(mParent.getString(R.string.png)))
                {
                    ImagesViewHolder imagesViewHolder=(ImagesViewHolder)holder;
                    Picasso picasso=((Application)(mParent.getApplication())).getPicasso();
                    picasso.load(mModules.get(position).getSrc())
                            .placeholder(R.drawable.placeholder)
                            .error(R.drawable.placeholder)
                            .into(imagesViewHolder.ModelImg);
                }else {
                    Timber.e(mParent.getString(R.string.wrong_image_format));
                }

            break;
            case 1:
                TextViewHolder TextViewHolder=(TextViewHolder) holder;
                TextViewHolder.ModelTextView.setText(mModules.get(position).getTextPlain());
                        
             break;
        }
    }


    @Override
    public int getItemCount() {
        if(mModules!=null)
            return mModules.size();
        return 0;
    }
    public void setNewData(List<Module> newData) {
        mModules = newData;
    }

    public class ImagesViewHolder extends RecyclerView.ViewHolder{

        @BindView(R.id.module_img) ImageView ModelImg;
        public ImagesViewHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this,itemView);
        }
    }

    public class TextViewHolder extends RecyclerView.ViewHolder{

        @BindView(R.id.module_txt)TextView ModelTextView;
        public TextViewHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this,itemView);
        }
    }
}
