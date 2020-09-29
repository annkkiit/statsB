package com.ankit.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

public class ArticleView extends AppCompatActivity {

    private static final String TAG = "ArticleView";
    private ImageView imageView;
    private TextView titleTV;
    private TextView contentTV;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_article_view);

        initializeUI();

        Intent intent = getIntent();
        imageView.setImageDrawable(getDrawable(intent.getIntExtra("drawable", 0)));
        titleTV.setText(intent.getStringExtra("title"));
        contentTV.setText(intent.getStringExtra("content"));
    }

    private void initializeUI() {
        imageView = findViewById(R.id.img);
        titleTV = findViewById(R.id.title);
        contentTV = findViewById(R.id.content);
    }

}
