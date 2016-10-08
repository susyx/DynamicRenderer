package com.suyouxiong.renderer.api;

import javax.microedition.khronos.egl.EGLConfig;
import javax.microedition.khronos.opengles.GL10;

public interface Renderer {

    void onSurfaceCreated(GL10 gl10, EGLConfig eglConfig);

    void onSurfaceChanged(GL10 gl10, int width, int height);

    void onDrawFrame(GL10 gl10);
}
