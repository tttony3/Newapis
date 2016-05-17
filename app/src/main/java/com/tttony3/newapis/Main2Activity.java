package com.tttony3.newapis;

import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.ImageView;

public class Main2Activity extends AppCompatActivity {
    private static final String KEY_ID = "ViewTransitionValues:id";
    private int mImageResourceId = 0;
    String[] id = {"img1","img2","img3"};
    int[] resId = {R.drawable.photo1,R.drawable.photo2,R.drawable.photo3};
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "this is new api for 5.0", Snackbar.LENGTH_SHORT)
                        .setAction("Action", null).show();
            }
        });
        ImageView img = (ImageView) findViewById(R.id.img);
        img.setImageDrawable(getHeroDrawable());
    }

    private Drawable getHeroDrawable() {
        String name = getIntent().getStringExtra(KEY_ID);
        if (name != null) {
            mImageResourceId = getDrawableIdForKey(name);
        }

        return getResources().getDrawable(mImageResourceId);
    }

    private  int getDrawableIdForKey(String id) {
        for (int i = 0; i < this.id.length; i++) {
            String name = this.id[i];
            if (name.equals(id)) {
                return resId[i];
            }
        }
        return resId[0] ;
    }

    @Override
    public void finish() {
        super.finish();
    }

    @Override
    public void onBackPressed() {
        finishAfterTransition();
        super.onBackPressed();
    }
}
