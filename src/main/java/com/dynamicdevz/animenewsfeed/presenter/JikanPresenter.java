package com.dynamicdevz.animenewsfeed.presenter;

import com.dynamicdevz.animenewsfeed.model.JikanResult;
import com.dynamicdevz.animenewsfeed.model.network.JikanNetwork;

import java.util.List;

public class JikanPresenter implements Presenter.JikanPresenter {


    private Presenter.JikanView view;

    public JikanPresenter(Presenter.JikanView view) {
        this.view = view;
    }

    @Override
    public void getJikanResults(String query) {

        new Thread(){

            @Override
            public void run() {
                super.run();
                try {
                    List<JikanResult> results = JikanNetwork.getInstance().searchJikan(query);
                    view.displayResults(results);

                } catch (Exception e) {
                    e.printStackTrace();
                    view.displayError(e.getMessage());
                }
            }

        }.start();

    }
}
