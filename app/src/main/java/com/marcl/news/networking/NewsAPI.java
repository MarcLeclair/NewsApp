package com.marcl.news.networking;

import com.marcl.news.model.GetArticleResponse;

import retrofit2.Call;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import retrofit2.http.GET;
import retrofit2.http.Query;

/**
 * Created by marcl on 2018-01-16.
 */

public class NewsAPI {
    private static final String APIKEY = "651488af71444d10afd61d145c1b3e97";
    private static final String APIPATH= "https://newsapi.org/v2/";

    private static NewsService newsService = null;

    public static NewsService getApi(){
        if(newsService == null){
            //initialize newsService
            Retrofit retrofit = new Retrofit.Builder()
                                    .baseUrl(APIPATH)
                                    .addConverterFactory(GsonConverterFactory.create())
                                    .build();
            newsService = retrofit.create(NewsService.class);
        }
        return newsService;
    }
    public interface NewsService {
        @GET("articles?apiKey=" + APIKEY)
        Call<GetArticleResponse> getArticles(@Query("srouce")String source,@Query("sortBy") String sortBy);
    }
}
