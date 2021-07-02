package com.dynamicdevz.animenewsfeed.model.network;

import com.dynamicdevz.animenewsfeed.model.JikanResponse;
import com.dynamicdevz.animenewsfeed.model.JikanResult;
import com.google.gson.Gson;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.List;

public class JikanNetwork {


    private JikanNetwork (){}

    private static JikanNetwork instance = null;

    public static JikanNetwork getInstance(){
        if (instance == null ){
            instance = new JikanNetwork();
        }
        return instance;
    }
    private static String BASE_URL="https://api.jikan.moe/";
    private static String END_POINT = "v3/search/anime?";
    private HttpURLConnection urlConnection;

    public List<JikanResult>searchJikan(String query) throws Exception{

        URL jikanURL = new URL(BASE_URL + END_POINT + "q= "+query);


        urlConnection = (HttpURLConnection) jikanURL.openConnection();
        urlConnection.setRequestMethod("GET");
        urlConnection.connect();

        BufferedReader bReader = new BufferedReader(
                new InputStreamReader(urlConnection.getInputStream()));

        String line;
        StringBuilder sBuilder = new StringBuilder();
        while ((line = bReader.readLine())!= null);{
            sBuilder.append(line);
        }
        urlConnection.disconnect();
        Gson gson = new Gson();
        JikanResponse response = gson.fromJson(sBuilder.toString(),JikanResponse.class);
        return response.getResults();
    }

}
