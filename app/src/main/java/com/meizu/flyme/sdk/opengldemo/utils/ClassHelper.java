package com.meizu.flyme.sdk.opengldemo.utils;

import android.content.Context;
import android.os.Environment;

import com.suyouxiong.renderer.api.Renderer;

import java.io.File;
import java.io.FileInputStream;
import java.net.URL;
import java.net.URLClassLoader;
import java.util.jar.Attributes;
import java.util.jar.JarInputStream;
import java.util.jar.Manifest;

import dalvik.system.DexClassLoader;

/**
 * Created by suyouxiong on 16/10/7.
 */
public class ClassHelper {

    public static Renderer getRendererImpl(Context context) {
        File jarFile = FileUtils.getPluginStorageFile(context);
        if (jarFile.exists()) {
            try {
//                URLClassLoader classLoader = new URLClassLoader(new URL[]{jarFile.toURL()}, context.getClassLoader());
                String optimizedDirectory = FileUtils.enforceDirExists(new File(FileUtils.enforceDirExists(
                        new File(context.getCacheDir().getParentFile(), "Plugin")), "dalvik-cache"));
                DexClassLoader classLoader = new DexClassLoader(jarFile.getAbsolutePath(), optimizedDirectory
                        , null, context.getClassLoader());
                JarInputStream jarInputStream = new JarInputStream(new FileInputStream(jarFile));
                Manifest manifest = jarInputStream.getManifest();
                Attributes attributes = manifest.getMainAttributes();
                String implClass = attributes.getValue("Implementation-Class");

                Class classToLoad = classLoader.loadClass(implClass);
                Renderer renderer = (Renderer) classToLoad.newInstance();
                return renderer;
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return null;
    }


}
