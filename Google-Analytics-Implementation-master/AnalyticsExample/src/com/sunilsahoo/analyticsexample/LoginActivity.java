package com.sunilsahoo.analyticsexample;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;

import com.google.android.gms.analytics.HitBuilders;
import com.google.android.gms.analytics.Tracker;

public class LoginActivity extends Activity {

    private static final String TAG = LoginActivity.class.getName();
    Tracker mTracker;

    

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.login);
        mTracker = ((AnalyticsApplication) getApplication())
                .getDefaultTracker();

    }

    @Override
    protected void onResume() {
        mTracker.setScreenName(LoginActivity.class.getSimpleName());
        mTracker.send(new HitBuilders.ScreenViewBuilder().build());
        super.onResume();
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        mTracker.send(new HitBuilders.EventBuilder().setCategory("Action")
                .setAction("BackKey").build());
        Log.d(TAG, "clicked : " + "backkey");
        
        mTracker.send(new HitBuilders.TimingBuilder()
        .setCategory("Time")
        .setValue(System.currentTimeMillis())
        .setVariable("BackKeyTime")
        .setLabel("LoginBackKeyTime")
        .build());
    }

}
