package org.sdsu.intelligrid.chart;


public class XYMultipleSeriesRenderer extends org.sdsu.intelligrid.chart.Renderer {
    private java.lang.String mXTitle;
    private java.lang.String[] mYTitle;
    private float mAxisTitleTextSize;
    private double[] mMinX;
    private double[] mMaxX;
    private double[] mMinY;
    private double[] mMaxY;
    private int mXLabels;
    private int mYLabels;
    private org.sdsu.intelligrid.chart.XYMultipleSeriesRenderer.Orientation mOrientation;
    private java.util.Map<java.lang.Double,java.lang.String> mXTextLabels;
    private java.util.Map<java.lang.Integer,java.util.Map<java.lang.Double,java.lang.String>> mYTextLabels;
    private boolean mPanXEnabled;
    private boolean mPanYEnabled;
    private boolean mZoomXEnabled;
    private boolean mZoomYEnabled;
    private double mBarSpacing;
    private int mMarginsColor;
    private double[] mPanLimits;
    private double[] mZoomLimits;
    private float mXLabelsAngle;
    private float mYLabelsAngle;
    private java.util.Map<java.lang.Integer,double[]> initialRange;
    private float mPointSize;
    private int mGridColor;
    private int scalesCount;
    private android.graphics.Paint.Align xLabelsAlign;
    private android.graphics.Paint.Align[] yLabelsAlign;
    private android.graphics.Paint.Align[] yAxisAlign;
    private int mXLabelsColor;
    private int[] mYLabelsColor;

    public XYMultipleSeriesRenderer() { /* compiled code */ }

    public XYMultipleSeriesRenderer(int scaleNumber) { /* compiled code */ }

    public void initAxesRange(int scales) { /* compiled code */ }

    public void initAxesRangeForScale(int i) { /* compiled code */ }

    public org.sdsu.intelligrid.chart.XYMultipleSeriesRenderer.Orientation getOrientation() { /* compiled code */ }

    public void setOrientation(org.sdsu.intelligrid.chart.XYMultipleSeriesRenderer.Orientation orientation) { /* compiled code */ }

    public java.lang.String getXTitle() { /* compiled code */ }

    public void setXTitle(java.lang.String title) { /* compiled code */ }

    public java.lang.String getYTitle() { /* compiled code */ }

    public java.lang.String getYTitle(int scale) { /* compiled code */ }

    public void setYTitle(java.lang.String title) { /* compiled code */ }

    public void setYTitle(java.lang.String title, int scale) { /* compiled code */ }

    public float getAxisTitleTextSize() { /* compiled code */ }

    public void setAxisTitleTextSize(float textSize) { /* compiled code */ }

    public double getXAxisMin() { /* compiled code */ }

    public void setXAxisMin(double min) { /* compiled code */ }

    public boolean isMinXSet() { /* compiled code */ }

    public double getXAxisMax() { /* compiled code */ }

    public void setXAxisMax(double max) { /* compiled code */ }

    public boolean isMaxXSet() { /* compiled code */ }

    public double getYAxisMin() { /* compiled code */ }

    public void setYAxisMin(double min) { /* compiled code */ }

    public boolean isMinYSet() { /* compiled code */ }

    public double getYAxisMax() { /* compiled code */ }

    public void setYAxisMax(double max) { /* compiled code */ }

    public boolean isMaxYSet() { /* compiled code */ }

    public double getXAxisMin(int scale) { /* compiled code */ }

    public void setXAxisMin(double min, int scale) { /* compiled code */ }

    public boolean isMinXSet(int scale) { /* compiled code */ }

    public double getXAxisMax(int scale) { /* compiled code */ }

    public void setXAxisMax(double max, int scale) { /* compiled code */ }

    public boolean isMaxXSet(int scale) { /* compiled code */ }

    public double getYAxisMin(int scale) { /* compiled code */ }

    public void setYAxisMin(double min, int scale) { /* compiled code */ }

    public boolean isMinYSet(int scale) { /* compiled code */ }

    public double getYAxisMax(int scale) { /* compiled code */ }

    public void setYAxisMax(double max, int scale) { /* compiled code */ }

    public boolean isMaxYSet(int scale) { /* compiled code */ }

    public int getXLabels() { /* compiled code */ }

    public void setXLabels(int xLabels) { /* compiled code */ }

    /**
     * @deprecated
     */
    public void addTextLabel(double x, java.lang.String text) { /* compiled code */ }

    public void addXTextLabel(double x, java.lang.String text) { /* compiled code */ }

    public java.lang.String getXTextLabel(java.lang.Double x) { /* compiled code */ }

    public java.lang.Double[] getXTextLabelLocations() { /* compiled code */ }

    /**
     * @deprecated
     */
    public void clearTextLabels() { /* compiled code */ }

    public void clearXTextLabels() { /* compiled code */ }

    public void addYTextLabel(double y, java.lang.String text) { /* compiled code */ }

    public void addYTextLabel(double y, java.lang.String text, int scale) { /* compiled code */ }

    public java.lang.String getYTextLabel(java.lang.Double y) { /* compiled code */ }

    public java.lang.String getYTextLabel(java.lang.Double y, int scale) { /* compiled code */ }

    public java.lang.Double[] getYTextLabelLocations() { /* compiled code */ }

    public java.lang.Double[] getYTextLabelLocations(int scale) { /* compiled code */ }

    public void clearYTextLabels() { /* compiled code */ }

    public int getYLabels() { /* compiled code */ }

    public void setYLabels(int yLabels) { /* compiled code */ }

    /**
     * @deprecated
     */
    public void setDisplayChartValues(boolean display) { /* compiled code */ }

    /**
     * @deprecated
     */
    public void setChartValuesTextSize(float textSize) { /* compiled code */ }

    public boolean isPanEnabled() { /* compiled code */ }

    public boolean isPanXEnabled() { /* compiled code */ }

    public boolean isPanYEnabled() { /* compiled code */ }

    public void setPanEnabled(boolean enabledX, boolean enabledY) { /* compiled code */ }

    public boolean isZoomEnabled() { /* compiled code */ }

    public boolean isZoomXEnabled() { /* compiled code */ }

    public boolean isZoomYEnabled() { /* compiled code */ }

    public void setZoomEnabled(boolean enabledX, boolean enabledY) { /* compiled code */ }

    /**
     * @deprecated
     */
    public double getBarsSpacing() { /* compiled code */ }

    public double getBarSpacing() { /* compiled code */ }

    public void setBarSpacing(double spacing) { /* compiled code */ }

    public int getMarginsColor() { /* compiled code */ }

    public void setMarginsColor(int color) { /* compiled code */ }

    public int getGridColor() { /* compiled code */ }

    public void setGridColor(int color) { /* compiled code */ }

    public double[] getPanLimits() { /* compiled code */ }

    public void setPanLimits(double[] panLimits) { /* compiled code */ }

    public double[] getZoomLimits() { /* compiled code */ }

    public void setZoomLimits(double[] zoomLimits) { /* compiled code */ }

    public float getXLabelsAngle() { /* compiled code */ }

    public void setXLabelsAngle(float angle) { /* compiled code */ }

    public float getYLabelsAngle() { /* compiled code */ }

    public void setYLabelsAngle(float angle) { /* compiled code */ }

    public float getPointSize() { /* compiled code */ }

    public void setPointSize(float size) { /* compiled code */ }

    public void setRange(double[] range) { /* compiled code */ }

    public void setRange(double[] range, int scale) { /* compiled code */ }

    public boolean isInitialRangeSet() { /* compiled code */ }

    public boolean isInitialRangeSet(int scale) { /* compiled code */ }

    public double[] getInitialRange() { /* compiled code */ }

    public double[] getInitialRange(int scale) { /* compiled code */ }

    public void setInitialRange(double[] range) { /* compiled code */ }

    public void setInitialRange(double[] range, int scale) { /* compiled code */ }

    public int getXLabelsColor() { /* compiled code */ }

    public int getYLabelsColor(int scale) { /* compiled code */ }

    public void setXLabelsColor(int color) { /* compiled code */ }

    public void setYLabelsColor(int scale, int color) { /* compiled code */ }

    public android.graphics.Paint.Align getXLabelsAlign() { /* compiled code */ }

    public void setXLabelsAlign(android.graphics.Paint.Align align) { /* compiled code */ }

    public android.graphics.Paint.Align getYLabelsAlign(int scale) { /* compiled code */ }

    public void setYLabelsAlign(android.graphics.Paint.Align align) { /* compiled code */ }

    public android.graphics.Paint.Align getYAxisAlign(int scale) { /* compiled code */ }

    public void setYAxisAlign(android.graphics.Paint.Align align, int scale) { /* compiled code */ }

    public void setYLabelsAlign(android.graphics.Paint.Align align, int scale) { /* compiled code */ }

    public int getScalesCount() { /* compiled code */ }

    public static enum Orientation {
        HORIZONTAL, VERTICAL;

        private int mAngle;

        public static org.sdsu.intelligrid.chart.XYMultipleSeriesRenderer.Orientation[] values() { /* compiled code */ }

        public static org.sdsu.intelligrid.chart.XYMultipleSeriesRenderer.Orientation valueOf(java.lang.String name) { /* compiled code */ }

        private Orientation(int angle) { /* compiled code */ }

        public int getAngle() { /* compiled code */ }
    }
}
