package com.meizu.flyme.sdk.opengldemo;

import android.content.Context;
import android.opengl.GLSurfaceView;

import com.meizu.flyme.sdk.opengldemo.utils.ClassHelper;

/**
 * Created by suyouxiong on 16/10/6.
 */
public class MyGLSurfaceView extends GLSurfaceView {
    private MyGLRenderer mMyGLRenderer;
    public MyGLSurfaceView(Context context) {
        super(context);

        setEGLContextClientVersion(2);

        com.suyouxiong.renderer.api.Renderer renderer = ClassHelper.getRendererImpl(getContext());
        mMyGLRenderer = new MyGLRenderer(renderer);
        setRenderer(mMyGLRenderer);

        setRenderMode(GLSurfaceView.RENDERMODE_WHEN_DIRTY);
    }
}
