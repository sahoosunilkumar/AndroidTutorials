package com.example.androidpermissiontest;

import java.util.ArrayList;

import android.Manifest;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Bundle;
import android.provider.Settings;

public class MainActivity extends Activity {

    private static final int GRANT_PERMISSION_OVERLAY_REQUEST_CODE = 1001;
    private static final int GRANT_PERMISSION_REQUEST_CODE = 1002;
    public static String[] ALL_PERMISSIONS = new String[] {
            Manifest.permission.READ_CONTACTS, Manifest.permission.READ_SMS };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        grantSpecialPermissions();
        grantRequiredDangerousPermissions();
    }

    /**
     * checks and grants for ungranted overlay permission
     */
    private void grantSpecialPermissions() {
        if (!Settings.canDrawOverlays(this)) {
            Intent systemSettingsIntent = new Intent(
                    Settings.ACTION_MANAGE_OVERLAY_PERMISSION,
                    Uri.parse("package:" + getPackageName()));
            systemSettingsIntent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
            startActivityForResult(systemSettingsIntent,
                    GRANT_PERMISSION_OVERLAY_REQUEST_CODE);
        }
    }

    /**
     * check for ungranted dangerous permissions and request for it
     */
    private void grantRequiredDangerousPermissions() {
        ArrayList<String> unGrantedPermissionList = new ArrayList<String>();
        for (String permission : ALL_PERMISSIONS) {
            if (!isPermissionAllowed(this, permission)) {
                unGrantedPermissionList.add(permission);
            }
        }
        if (!unGrantedPermissionList.isEmpty()) {
            String[] unGrantedPermissionArr = new String[unGrantedPermissionList
                    .size()];
            unGrantedPermissionArr = unGrantedPermissionList
                    .toArray(unGrantedPermissionArr);
            requestPermissions(unGrantedPermissionArr,
                    GRANT_PERMISSION_REQUEST_CODE);
        }
    }

    private static boolean isPermissionAllowed(Context context,
            String permission) {
        return context.checkSelfPermission(permission) == PackageManager.PERMISSION_GRANTED;
    }

    @Override
    public void onRequestPermissionsResult(int requestCode,
            String[] permissions, int[] grantResults) {
     // TODO perform task on result of grant permission for example finish your activity
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        if (requestCode == GRANT_PERMISSION_OVERLAY_REQUEST_CODE) {
            // TODO perform task on result of grant permission for system alert
        }
    }
}
