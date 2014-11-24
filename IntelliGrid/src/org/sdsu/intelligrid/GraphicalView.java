package org.sdsu.intelligrid;

public class GraphicalView extends android.view.View {
    private org.sdsu.intelligrid.chart.AbstractChart mChart;
    private org.sdsu.intelligrid.chart.Renderer mRenderer;
    private android.graphics.Rect mRect;
    private android.os.Handler mHandler;
    private android.graphics.RectF mZoomR;
    private android.graphics.Bitmap zoomInImage;
    private android.graphics.Bitmap zoomOutImage;
    private android.graphics.Bitmap fitZoomImage;
    private int zoomSize;
    private static final int ZOOM_BUTTONS_COLOR;
    private org.sdsu.intelligrid.tools.Zoom mZoomIn;
    private org.sdsu.intelligrid.tools.Zoom mZoomOut;
    private org.sdsu.intelligrid.tools.FitZoom mFitZoom;
    private android.graphics.Paint mPaint;
    private org.sdsu.intelligrid.ITouchHandler mTouchHandler;
    private float oldX;
    private float oldY;

    public GraphicalView(android.content.Context context, org.sdsu.intelligrid.chart.AbstractChart chart) { /* compiled code */ }

    public org.sdsu.intelligrid.model.SeriesSelection getCurrentSeriesAndPoint() { /* compiled code */ }

    public double[] toRealPoint(int scale) { /* compiled code */ }

    protected void onDraw(android.graphics.Canvas canvas) { /* compiled code */ }

    public void setZoomRate(float rate) { /* compiled code */ }

    public void zoomIn() { /* compiled code */ }

    public void zoomOut() { /* compiled code */ }

    public void zoomReset() { /* compiled code */ }

    public void addZoomListener(org.sdsu.intelligrid.tools.ZoomListener listener, boolean onButtons, boolean onPinch) { /* compiled code */ }

    public synchronized void removeZoomListener(org.sdsu.intelligrid.tools.ZoomListener listener) { /* compiled code */ }

    public void addPanListener(org.sdsu.intelligrid.tools.PanListener listener) { /* compiled code */ }

    public void removePanListener(org.sdsu.intelligrid.tools.PanListener listener) { /* compiled code */ }

    protected android.graphics.RectF getZoomRectangle() { /* compiled code */ }

    public boolean onTouchEvent(android.view.MotionEvent event) { /* compiled code */ }

    public void repaint() { /* compiled code */ }

    public void repaint(int left, int top, int right, int bottom) { /* compiled code */ }

    public android.graphics.Bitmap toBitmap() { /* compiled code */ }
}
