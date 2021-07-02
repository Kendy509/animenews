package com.dynamicdevz.animenewsfeed.view;

import android.os.Bundle;
import android.util.Log;

import androidx.appcompat.app.AppCompatActivity;

import com.dynamicdevz.animenewsfeed.databinding.ActivityMainBinding;
import com.dynamicdevz.animenewsfeed.model.JikanResponse;
import com.dynamicdevz.animenewsfeed.model.network.JikanRetrofit;
import com.dynamicdevz.animenewsfeed.view.adapter.JikanAdapter;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {

    private ActivityMainBinding binding;
    private JikanAdapter adapter = new JikanAdapter();
    private JikanRetrofit jikanRetrofit = new JikanRetrofit();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        binding.jikanRecyclerView.setAdapter(adapter);

        jikanRetrofit.getSearchResults("gojo")
                .enqueue(new Callback<JikanResponse>() {
                    @Override
                    public void onResponse(Call<JikanResponse> call, Response<JikanResponse> response) {
                        Log.d("TAG_X", "" + call.request().url());
                        adapter.setJikans(response.body().getResults());
                    }

                    @Override
                    public void onFailure(Call<JikanResponse> call, Throwable t) {
                        Log.d("TAG_X", "OOPS :<" + call.request().url());
                    }
                });


    }
}
