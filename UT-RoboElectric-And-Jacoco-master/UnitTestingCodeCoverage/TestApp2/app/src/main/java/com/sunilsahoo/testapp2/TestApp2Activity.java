package com.sunilsahoo.testapp2;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Toast;

import com.sunilsahoo.testapp3.utils.Utility;

public class TestApp2Activity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_test_app2);

        Toast.makeText(TestApp2Activity.this,Utility.isEmpty(getAppName())+"", Toast.LENGTH_SHORT).show();

    }

    public String getAppName(){
        return getString(R.string.app_name);
    }

    public String checkAppName(){
        return getString(R.string.app_name);
    }
}
