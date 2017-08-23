package testapp2.sunilsahoo.com.testapp2;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Toast;

import testapp3.sunilsahoo.com.testapp3.utils.Utility;

public class TestApp2Activity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_test_app2);

        Toast.makeText(TestApp2Activity.this,Utility.isEmpty("dfvdfv")+"", Toast.LENGTH_SHORT).show();

    }
}
