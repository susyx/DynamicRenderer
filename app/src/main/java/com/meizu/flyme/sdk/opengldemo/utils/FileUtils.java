package com.meizu.flyme.sdk.opengldemo.utils;

import android.content.Context;
import android.os.Environment;
import android.util.Log;

import java.io.File;

/**
 * Created by suyouxiong on 16/10/7.
 */
public class FileUtils {
    public static final String LOG_TAG = FileUtils.class.getSimpleName();
    public static final String DIRECTORY_PLUGIN = "plugin";

    public static File getPluginStorageFile(Context context) {
        File file = new File(context.getExternalFilesDir(
                DIRECTORY_PLUGIN), "plugin.jar");
        if(!file.exists()) {
            Log.e(LOG_TAG, "Directory not created");
        }
        return file;
    }

    private static boolean isStorageAvailable() {
        boolean mExternalStorageAvailable = false;
        String state = Environment.getExternalStorageState();
        if(Environment.MEDIA_MOUNTED.equals(state)) {
            mExternalStorageAvailable = true;
        } else if(Environment.MEDIA_MOUNTED_READ_ONLY.equals(state)) {
            mExternalStorageAvailable = true;
        } else{
            mExternalStorageAvailable = false;
        }
        return mExternalStorageAvailable;
    }

    private static boolean isStorageWriteable() {
        boolean mExternalStorageWriteable = false;
        String state = Environment.getExternalStorageState();
        if(Environment.MEDIA_MOUNTED.equals(state)) {
            mExternalStorageWriteable = true;
        } else if(Environment.MEDIA_MOUNTED_READ_ONLY.equals(state)) {
            mExternalStorageWriteable = false;
        } else{
            mExternalStorageWriteable = false;
        }
        return mExternalStorageWriteable;
    }


    public static String enforceDirExists(File file) {
        if (!file.exists()) {
            file.mkdirs();
        }
        return file.getPath();
    }
}
