package com.phantom.asalama.art.screens.detail;

import android.media.Image;
import android.os.Build;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.Display;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.widget.ImageView;

import com.phantom.asalama.art.R;
import com.phantom.asalama.art.infastructure.Application;
import com.phantom.asalama.art.models.Module;
import com.phantom.asalama.art.models.Project;
import com.phantom.asalama.art.screens.home.ProjectsRecyclerViewAdapter;
import com.squareup.picasso.Picasso;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

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
                return new WebViewHolder(view);
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
                ImagesViewHolder imagesViewHolder=(ImagesViewHolder)holder;
                Picasso picasso=((Application)(mParent.getApplication())).getPicasso();
                picasso.load(mModules.get(position).getSrc())
                        .into(imagesViewHolder.ModelImg);

            break;
            case 1:
                WebViewHolder webViewHolder=(WebViewHolder) holder;
                webViewHolder.ModelWebView.loadData
                        (mModules.get(position).getText(),"text/html", null);
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

    public class WebViewHolder extends RecyclerView.ViewHolder{

        @BindView(R.id.module_txt)WebView ModelWebView;
        public WebViewHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this,itemView);
            ModelWebView.getSettings().setRenderPriority(WebSettings.RenderPriority.HIGH);
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.KITKAT) {
                // chromium, enable hardware acceleration
                ModelWebView.setLayerType(View.LAYER_TYPE_HARDWARE, null);
            } else {
                // older android version, disable hardware acceleration
                ModelWebView.setLayerType(View.LAYER_TYPE_SOFTWARE, null);
            }
            ModelWebView.getSettings().setCacheMode(WebSettings.LOAD_NO_CACHE);
        }
    }
}
