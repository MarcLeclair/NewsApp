package com.marcl.news;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.marcl.news.model.GetArticleResponse;
import com.marcl.news.model.NewsArticle;
import com.marcl.news.networking.NewsAPI;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;

import static com.marcl.news.networking.NewsAPI.getApi;

public class MainActivity extends AppCompatActivity {
    private RecyclerView newsRecyclerView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        List<NewsArticle> lst = new ArrayList<NewsArticle>();
        lst.add(new NewsArticle("One dead in Pointe-Aux-Trembles fire", "A fire in a Pointe-Aux-Trembles apartment building left one woman dead late on Saturday night.\n" +
                "\n" +
                "According to the Montreal fire department, the fire began at around midnight on Sherbrooke St. near 51st Ave.\n" +
                "\n" +
                "When firefighters were able to enter the building, they found the victim unconscious. She was later declared dead on the scene.\n" +
                "\n" +
                "Police said the arson squad is investigating but the likely cause was a cigarette that was not put out properly.\n" +
                "\n" +
                "The building’s residents will be able to return home in a few days, according to the SPVM. ","https://www.ctvnews.ca/polopoly_fs/1.3758842.1515941614!/httpImage/image.jpg_gen/derivatives/landscape_620/image.jpg","January 14, 2018 9:54AM EST ","https://montreal.ctvnews.ca/one-dead-in-pointe-aux-trembles-fire-1.3758840"));

        lst.add(new NewsArticle("Everyone hates us, and it’s not because of our sex parties"    ,"It was, briefly, the zeitgeist’s perfect Silicon Valley story: a sex-and-drugs party hosted hosted by since-ousted top-tier VC Steve Jurvetson, at an official Draper Fisher Jurvetson event,attended by multiple billionaires including Elon Musk. So said Paul Biggar, founder of CircleCI, in a widely read Medium post, expanding on Vanity Fair’s excerpt of Emily Chang’s new book.","https://tctechcrunch2011.files.wordpress.com/2018/01/eyes-wide-shut.png?w=686&zoom=2", "January 14th, 8:23 A.M 2018","https://techcrunch.com/2018/01/14/everyone-hates-us-and-its-not-because-of-our-sex-parties/"));

        NewsStore.setNewsArticle(lst);

        newsRecyclerView = (RecyclerView) findViewById(R.id.activity_main_recyclerview);

        newsRecyclerView.setLayoutManager(new LinearLayoutManager((this)));

        HomeNewsAdapter homeNewsAdapter = new HomeNewsAdapter(NewsStore.getNewsArticle());
        newsRecyclerView.setAdapter(homeNewsAdapter);

        Call<GetArticleResponse> call =NewsAPI.getApi().getArticles("reuters", "top");
        call.enqueue(new Callback<GetArticleResponse>() {
                @Override
        });
    }
}
