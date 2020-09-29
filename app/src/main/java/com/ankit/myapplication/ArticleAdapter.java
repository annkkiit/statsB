package com.ankit.myapplication;

import android.app.Activity;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.ankit.myapplication.POJO.Article;

import java.util.ArrayList;

public class ArticleAdapter extends RecyclerView.Adapter<ArticleAdapter.ViewHolder> {

    private ArrayList<Article> articles;
    private Activity sender;

    public ArticleAdapter(Activity sender, ArrayList<Article> articles) {
        this.articles = articles;
        this.sender = sender;
    }

    @NonNull
    @Override
    public ArticleAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        if (sender.getClass().getSimpleName().equals("ResultActivity")) {
            View v = LayoutInflater.from(parent.getContext())
                    .inflate(R.layout.article_list_res, parent, false);
            return new ViewHolder(v);
        } else {
            View v = LayoutInflater.from(parent.getContext())
                    .inflate(R.layout.article_list, parent, false);
            return new ViewHolder(v);
        }
    }

    @Override
    public void onBindViewHolder(@NonNull ArticleAdapter.ViewHolder holder, int position) {
        final int pos = position;
        String text = articles.get(position).getTitle();

        if (sender.getClass().getSimpleName().equals("ResultActivity")) {
            if (text.length() > 15) {
                text = text.substring(0, 15) + "...";
            }
        } else {
            if (text.length() > 25) {
                text = text.substring(0, 25) + "...";
            }
        }

        holder.title.setText(text);
        holder.imageView.setImageDrawable(sender.getResources().getDrawable(articles.get(position).getImg()));
        holder.readMore.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (pos != RecyclerView.NO_POSITION) {
                    Article clickedDataItem = articles.get(pos);
                    Intent intent = new Intent(sender, ArticleView.class);
                    intent.putExtra("title", clickedDataItem.getTitle());
                    intent.putExtra("content", clickedDataItem.getContent());
                    intent.putExtra("drawable", clickedDataItem.getImg());
                    sender.startActivity(intent);
                }
            }
        });
    }

    @Override
    public int getItemCount() {
        return articles.size();
    }

    class ViewHolder extends RecyclerView.ViewHolder {

        private TextView title;
        private TextView readMore;
        private ImageView imageView;

        public ViewHolder(final View itemView) {
            super(itemView);
            title = itemView.findViewById(R.id.article_title);
            readMore = itemView.findViewById(R.id.read_more);
            imageView = itemView.findViewById(R.id.img_article);
        }

    }

}
