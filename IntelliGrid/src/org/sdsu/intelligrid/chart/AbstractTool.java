package org.sdsu.intelligrid.chart;


public class AbstractTool {
    public abstract class AbstractTool {
        protected org.sdsu.intelligrid.chart.AbstractChart mChart;
        protected org.sdsu.intelligrid.chart.XYMultipleSeriesRenderer mRenderer;

        public AbstractTool(org.sdsu.intelligrid.chart.AbstractChart chart) { /* compiled code */ }

        public double[] getRange(int scale) { /* compiled code */ }

        public void checkRange(double[] range, int scale) { /* compiled code */ }

        protected void setXRange(double min, double max, int scale) { /* compiled code */ }

        protected void setYRange(double min, double max, int scale) { /* compiled code */ }
    }
}
