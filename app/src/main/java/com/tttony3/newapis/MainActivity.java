package com.tttony3.newapis;

import android.app.ActivityOptions;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.ImageView;

public class MainActivity extends AppCompatActivity {
ImageView mHero;
    private static final String KEY_ID = "ViewTransitionValues:id";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
    }

    public void clicked(View v) {
        mHero = (ImageView) v;
        Intent intent = new Intent(this, Main2Activity.class);
        intent.putExtra(KEY_ID, v.getTransitionName());
        ActivityOptions activityOptions
                = ActivityOptions.makeSceneTransitionAnimation(this, mHero, "img");
        startActivity(intent, activityOptions.toBundle());
    }
}
