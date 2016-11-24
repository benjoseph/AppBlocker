package com.josephben.appblocker;

import android.content.Intent;
import android.util.Log;
import android.view.accessibility.AccessibilityEvent;

/**
 * Created by josephben on 11/16/2016.
 */

public class AccessibilityService extends android.accessibilityservice.AccessibilityService {

    private static final String TAG="AppBlocker";
    @Override
    public void onAccessibilityEvent(AccessibilityEvent event) {
        String packageName=event.getPackageName().toString();
        if(packageName.equalsIgnoreCase("com.facebook.katana")||packageName.equalsIgnoreCase("com.instagram.android")){
            Intent intent=new Intent(this,BlockActivity.class);
            intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
            startActivity(intent);
        }
    }

    @Override
    public void onInterrupt() {

    }
}
