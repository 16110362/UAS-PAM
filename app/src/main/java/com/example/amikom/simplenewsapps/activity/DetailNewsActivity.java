package com.example.amikom.simplenewsapps.activity;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.example.amikom.simplenewsapps.R;

public class DetailNewsActivity extends AppCompatActivity {

    String imgNews, titleNews, contentNews, dateNews, authorNews, sourceNews;

    ImageView ivImgNews;
    TextView tvTitleNews, tvContentNews, tvDateNews, tvAuthorNews, tvSourceNews;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail_news);

        // Setting Toolbar
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setTitle("Detail News");

        bindView();

        imgNews = getIntent().getStringExtra("imgNews");
        titleNews = getIntent().getStringExtra("titleNews");
        contentNews = getIntent().getStringExtra("contentNews");
        dateNews = getIntent().getStringExtra("dateNews");
        authorNews = getIntent().getStringExtra("authorNews");
        sourceNews = getIntent().getStringExtra("sourceNews");

        Glide.with(getApplicationContext())
                .load(imgNews)
                .placeholder(R.drawable.no_image_icon)
                .into(ivImgNews);
        tvTitleNews.setText(titleNews);
        tvContentNews.setText(contentNews);
        tvDateNews.setText(dateNews);
        tvSourceNews.setText("view more");
        tvAuthorNews.setText(authorNews);

        tvSourceNews.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(Intent.ACTION_VIEW, Uri.parse(sourceNews)));
            }
        });
    }

    public void bindView(){
        ivImgNews = (ImageView) findViewById(R.id.img_news);
        tvTitleNews = (TextView) findViewById(R.id.title_news);
        tvContentNews = (TextView) findViewById(R.id.content_news);
        tvAuthorNews = (TextView) findViewById(R.id.author_news);
        tvDateNews = (TextView) findViewById(R.id.date_news);
        tvSourceNews = (TextView) findViewById(R.id.source_news);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.action_menu, menu);
        return super.onCreateOptionsMenu(menu);

    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        overridePendingTransition(android.R.anim.slide_in_left, android.R.anim.slide_out_right);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()){
            case android.R.id.home : {
                finish();
                overridePendingTransition(android.R.anim.slide_in_left, android.R.anim.slide_out_right);
                break;
            }
            case R.id.share : {
                Intent i = new Intent(android.content.Intent.ACTION_SEND);
                i.setType("text/plain");
                i.putExtra(android.content.Intent.EXTRA_TEXT, titleNews+"\n\n"+contentNews+"\n\n"+sourceNews);
                startActivity(Intent.createChooser(i, "Share this Article ?"));
                break;
            }
        }
        return super.onOptionsItemSelected(item);
    }
}
