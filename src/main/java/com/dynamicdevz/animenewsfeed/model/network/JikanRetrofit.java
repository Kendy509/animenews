package com.dynamicdevz.animenewsfeed.model.network;

import com.dynamicdevz.animenewsfeed.model.JikanResponse;

import retrofit2.Call;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import retrofit2.http.GET;

import static com.dynamicdevz.animenewsfeed.util.containts.*;

public class JikanRetrofit {

    private JikanService jikanService = createRetrofit().create(JikanService.class);

        private Retrofit createRetrofit(){
            return new Retrofit.Builder()
                    .addConverterFactory(GsonConverterFactory.create())
                    .baseUrl(BASE_URL)
                    .build();
        }
        public Call<JikanResponse>getSearchResults(String query){
            return jikanService.searchJikan(query);
        }


    interface JikanService{
        @GET(END_POINT)
        public Call<JikanResponse> searchJikan(String query);
    }
}
