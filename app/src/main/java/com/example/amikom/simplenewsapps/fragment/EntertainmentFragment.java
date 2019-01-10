package com.example.amikom.simplenewsapps.fragment;


import android.app.ProgressDialog;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.example.amikom.simplenewsapps.adapter.NewsAdapter;
import com.example.amikom.simplenewsapps.api.BaseApiService;
import com.example.amikom.simplenewsapps.api.UtilsApi;
import com.example.amikom.simplenewsapps.model.News;
import com.example.amikom.simplenewsapps.model.NewsResponse;
import com.example.amikom.simplenewsapps.BuildConfig;
import com.example.amikom.simplenewsapps.R;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * A simple {@link Fragment} subclass.
 */
public class EntertainmentFragment extends Fragment {

    private RecyclerView rvNews;
    private NewsAdapter adapter;
    List<News> listNews = new ArrayList<>();

    final String category = "entertainment";

    ProgressDialog loading;

    BaseApiService apiService;

    public EntertainmentFragment() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_entertainment, container, false);

        rvNews = (RecyclerView) view.findViewById(R.id.rv_news);

        apiService = UtilsApi.getAPIService();

        adapter = new NewsAdapter(getContext(), listNews);

        rvNews.setHasFixedSize(true);
        rvNews.setLayoutManager(new LinearLayoutManager(getContext()));
        rvNews.setAdapter(adapter);

        refresh();

        return view;
    }

    public void refresh() {
        loading = ProgressDialog.show(getContext(), null, "Harap Tunggu...", true, false);

        apiService.getListNews("us", category, BuildConfig.NEWS_API_TOKEN).enqueue(new Callback<NewsResponse>() {
            @Override
            public void onResponse(Call<NewsResponse> call, Response<NewsResponse> response) {
                if (response.isSuccessful()){
                    loading.dismiss();

                    listNews = response.body().getNewsList();

                    rvNews.setAdapter(new NewsAdapter(getContext(), listNews));
                    adapter.notifyDataSetChanged();
                } else {
                    loading.dismiss();
                    Toast.makeText(getContext(), "Failed to Fetch Data !", Toast.LENGTH_SHORT).show();
                }
            }

            @Override
            public void onFailure(Call<NewsResponse> call, Throwable t) {
                loading.dismiss();
                Toast.makeText(getContext(), "Failed to Connect Internet !", Toast.LENGTH_SHORT).show();
            }
        });
    }

}
