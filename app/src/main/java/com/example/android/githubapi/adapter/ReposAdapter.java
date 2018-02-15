package com.example.android.githubapi.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.example.android.githubapi.R;

import java.util.List;

public class ReposAdapter extends RecyclerView.Adapter<ReposAdapter.ReposViewHolder> {
    private List<String> repos;
    private int rowLayout;
    private Context context;

    public ReposAdapter(List<String> repos, int rowLayout, Context context) {
        this.setRepos(repos);
        this.setRowLayout(rowLayout);
        this.setContext(context);
    }

    public List<String> getRepos() {
        return repos;
    }

    public void setRepos(List<String> repos) {
        this.repos = repos;
    }

    public int getRowLayout() {
        return rowLayout;
    }

    public void setRowLayout(int rowLayout) {
        this.rowLayout = rowLayout;
    }

    public Context getContext() {
        return context;
    }

    public void setContext(Context context) {
        this.context = context;
    }

    @Override
    public ReposViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(rowLayout, parent, false);
        return new ReposViewHolder(view);
    }

    @Override
    public void onBindViewHolder(ReposViewHolder holder, int position) {
        holder.repoName.setText(repos.get(position));
    }

    @Override
    public int getItemCount() {
        return repos.size();
    }

    class ReposViewHolder extends RecyclerView.ViewHolder {
        LinearLayout repoLayout;
        TextView repoName;
        TextView repoDescription;
        TextView repoLanguage;

//        repo_item_layout
//        repo_name
//        repo_description
//        repo_language

        public ReposViewHolder(View v) {
            super(v);

            repoLayout = (LinearLayout) v.findViewById(R.id.repo_item_layout);
            repoName = (TextView) v.findViewById(R.id.repo_name);
            repoDescription = (TextView) v.findViewById(R.id.repo_description);
            repoLanguage = (TextView) v.findViewById(R.id.repo_language);
        }
    }
}
