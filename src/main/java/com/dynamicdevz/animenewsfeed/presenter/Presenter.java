package com.dynamicdevz.animenewsfeed.presenter;

import com.dynamicdevz.animenewsfeed.model.JikanResult;

import java.util.List;

public interface Presenter {



    interface JikanPresenter{
        void getJikanResults(String query);
    }

    interface JikanView{
        void displayResults(List<JikanResult>jikanResults);
        void displayError(String error);
    }

}



