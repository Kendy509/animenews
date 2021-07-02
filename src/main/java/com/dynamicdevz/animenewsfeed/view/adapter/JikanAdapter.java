package com.dynamicdevz.animenewsfeed.view.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;



import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;
import com.dynamicdevz.animenewsfeed.databinding.JikanItemLayoutBinding;
import com.dynamicdevz.animenewsfeed.model.JikanResult;

import java.util.ArrayList;
import java.util.List;

import javax.xml.transform.Result;

public class JikanAdapter extends RecyclerView.Adapter<JikanAdapter.JikanViewHolder> {



    @NonNull
    @Override
    public JikanViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        JikanItemLayoutBinding binding =
                JikanItemLayoutBinding.inflate(
                        LayoutInflater.from(parent.getContext()),
                        parent,
                        false
                );
        return new JikanViewHolder(binding);
    }
    private List<JikanResult> jikans = new ArrayList<>();

    public void setJikans(List<JikanResult> jikans) {
        this.jikans = jikans;
        notifyDataSetChanged();
    }
    private List<JikanResult> results = new ArrayList<>();

    public void setResults(List<JikanResult> results) {
        this.results = results;
        notifyDataSetChanged();

    }
    @Override
    public void onBindViewHolder (@NonNull JikanAdapter.JikanViewHolder holder,int position){
        JikanResult result = results.get(position);

        Glide.with(holder.itemView)
                .applyDefaultRequestOptions(RequestOptions.centerCropTransform())
                .load(result.getImageUrl())
                .into(holder.binding.posterImageview);

        holder.binding.synopsisTextview.setText(result.getSynopsis());
        holder.binding.titleTextview.setText(result.getTitle());
    }
    @Override
    public int getItemCount(){
        return results.size();
    }

    class JikanViewHolder extends RecyclerView.ViewHolder {
        JikanItemLayoutBinding binding;
        public JikanViewHolder(JikanItemLayoutBinding binding) {
            super(binding.getRoot());
            this.binding = binding;
        }
    }
}
