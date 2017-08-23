package com.sunilsahoo.analyticsexample;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import com.google.android.gms.analytics.GoogleAnalytics;
import com.google.android.gms.analytics.HitBuilders;
import com.google.android.gms.analytics.Tracker;

public class MainActivity extends Activity implements View.OnClickListener{

    private static final String TAG = MainActivity.class.getName();
    Tracker mTracker;
    Button login;
    Button logout;
    Button view;
    Button error;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.content_main);
        mTracker = ((AnalyticsApplication) getApplication()).getDefaultTracker();
        login = (Button) findViewById(R.id.login);
        login.setOnClickListener(this);
        logout = (Button) findViewById(R.id.logout);
        logout.setOnClickListener(this);
        view = (Button) findViewById(R.id.view);
        view.setOnClickListener(this);
        error = (Button) findViewById(R.id.error);
        error.setOnClickListener(this);
        

    }
    
    @Override
    protected void onResume() {
        mTracker.setScreenName(MainActivity.class.getSimpleName());
        mTracker.send(new HitBuilders.ScreenViewBuilder().build());
        super.onResume();
    }


    @Override
    public void onClick(View v) {
        String action = ((Button) v).getText().toString();
        mTracker.send(new HitBuilders.EventBuilder()
                .setCategory("Action")
                .setAction(action)
                .build());
        Log.d(TAG, "clicked : "+action);
        if(v == login){
            startActivity(new Intent(this, LoginActivity.class));
        }
        if(v == error){
            mTracker.send(new HitBuilders.ExceptionBuilder()
            .setDescription("onClick(Error)" + ":" + "Line 48")
            .setFatal(true)
            .build());
        }
        
        if(v == view){
            mTracker.send(new HitBuilders.ExceptionBuilder()
            .setDescription("onClick(View)" + ":" + "Line 48")
            .setFatal(false)
            .build());
        }

    }
 
    @Override
    public void onBackPressed() {
        GoogleAnalytics.getInstance(getBaseContext()).dispatchLocalHits();
        super.onBackPressed();
    }

}
