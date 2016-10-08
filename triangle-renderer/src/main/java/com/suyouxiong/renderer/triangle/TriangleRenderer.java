package com.suyouxiong.renderer.triangle;

import android.opengl.GLES20;

import com.suyouxiong.renderer.api.Renderer;

import javax.microedition.khronos.egl.EGLConfig;
import javax.microedition.khronos.opengles.GL10;

public class TriangleRenderer implements Renderer{
    private Triangle mTriangle;

    @Override
    public void onSurfaceCreated(GL10 gl10, EGLConfig eglConfig) {
        GLES20.glClearColor(0.0f, 0.0f, 0.0f, 1.0f);

        mTriangle = new Triangle();
    }

    @Override
    public void onSurfaceChanged(GL10 gl10, int width, int height) {
        GLES20.glViewport(0, 0, width, height);
    }

    @Override
    public void onDrawFrame(GL10 gl10) {
        GLES20.glClear(GLES20.GL_COLOR_BUFFER_BIT);

        mTriangle.draw();
    }
}
