package org.sdsu.intelligrid.graphics;

import android.content.Context;
import android.opengl.GLSurfaceView;

public class MainSurfaceView extends GLSurfaceView {
	
    public MainSurfaceView(Context context){
        super(context);

        setEGLContextClientVersion(2);
        setRenderer(new MainRenderer());
    }
}
