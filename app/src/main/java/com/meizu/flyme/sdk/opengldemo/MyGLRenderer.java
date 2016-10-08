package com.meizu.flyme.sdk.opengldemo;

import android.opengl.GLES20;
import android.opengl.GLSurfaceView;

import com.suyouxiong.renderer.api.Renderer;

import javax.microedition.khronos.egl.EGLConfig;
import javax.microedition.khronos.opengles.GL10;

/**
 * Created by suyouxiong on 16/10/6.
 */
public class MyGLRenderer implements GLSurfaceView.Renderer {
    private Triangle mTriangle;
    private Renderer mRenderer;

    public MyGLRenderer(Renderer renderer) {
        mRenderer = renderer;
    }

    @Override
    public void onSurfaceCreated(GL10 gl10, EGLConfig eglConfig) {
//        GLES20.glClearColor(0.0f, 0.0f, 0.0f, 1.0f);
//
//        mTriangle = new Triangle();
        mRenderer.onSurfaceCreated(gl10, eglConfig);
    }

    @Override
    public void onSurfaceChanged(GL10 gl10, int i, int i1) {
//        GLES20.glViewport(0, 0, i, i1);
        mRenderer.onSurfaceChanged(gl10, i, i1);
    }

    @Override
    public void onDrawFrame(GL10 gl10) {
//        GLES20.glClear(GLES20.GL_COLOR_BUFFER_BIT);
//
//        mTriangle.draw();
        mRenderer.onDrawFrame(gl10);
    }

    public static int loadShader(int type, String shaderCode) {
        // create a vertex shader type (GLES20.GL_VERTEX_SHADER)
        // or a fragment shader type (GLES20.GL_FRAGMENT_SHADER)
        int shader = GLES20.glCreateShader(type);

        // add the source code to the shader and compile it
        GLES20.glShaderSource(shader, shaderCode);
        GLES20.glCompileShader(shader);

        return shader;
    }
}
