package com.sunilsahoo.testapp2;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * To work on unit tests, switch the Test Artifact in the Build Variants view.
 */
import android.app.Activity;

import org.junit.runner.RunWith;
import org.robolectric.Robolectric;
import org.robolectric.RobolectricGradleTestRunner;
import org.robolectric.annotation.Config;

@RunWith(RobolectricGradleTestRunner.class)
@Config(constants = BuildConfig.class, sdk = 21, manifest = "src/main/AndroidManifest.xml")
public class TestApp2ActivityTest {

    @Test
    public void onCreate_activityNotNull_returnNotNull() throws Exception {
        Activity activity = Robolectric.setupActivity(TestApp2Activity.class);
        assertNotNull(activity);
    }
}