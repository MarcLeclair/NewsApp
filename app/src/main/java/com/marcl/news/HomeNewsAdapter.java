package com.marcl.news;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.marcl.news.model.NewsArticle;

import java.util.List;

/**
 * Created by marcl on 2018-01-14.
 */

public class HomeNewsAdapter extends RecyclerView.Adapter<HomeNewsAdapter.HomeNewsViewHolder> {
    private List<NewsArticle> newsArticles;

    public HomeNewsAdapter(List<NewsArticle> newsArticles) {
        this.newsArticles = newsArticles;
    }

    @Override
    public HomeNewsViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_home_news,parent, false);
        HomeNewsViewHolder homesNewsViewHolder = new HomeNewsViewHolder(view);
        return homesNewsViewHolder;
    }

    @Override
    public void onBindViewHolder(HomeNewsViewHolder holder, final int position) {
        NewsArticle article = newsArticles.get(position);
        Glide.with(holder.cardViewImage.getContext()).load(article.getImgUrl()).centerCrop().into(holder.cardViewImage);
        holder.cardTitleView.setText(article.getTitle());
        holder.cardTimeTextView.setText(article.getTime());
        holder.cardContentView.setText(article.getDetails());
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                NewsDetailsActivity.launch(view.getContext(),position);
            }
        });
    }

    @Override
    public int getItemCount() {
        return newsArticles.size(); //gotta add null pointer check
    }

    public static class HomeNewsViewHolder extends RecyclerView.ViewHolder {
        ImageView cardViewImage;
        TextView cardTitleView;
        TextView cardTimeTextView;
        TextView cardContentView;

        public HomeNewsViewHolder(View itemView) {
            super(itemView);
            cardViewImage = (ImageView) itemView.findViewById(R.id.card_news_image);
            cardTitleView = (TextView) itemView.findViewById(R.id.card_news_title);
            cardTimeTextView = (TextView) itemView.findViewById(R.id.card_news_time);
            cardContentView = (TextView) itemView.findViewById(R.id.card_news_content);
        }
    }
}
