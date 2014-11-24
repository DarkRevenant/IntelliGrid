package org.sdsu.intelligrid.graphics;

import org.achartengine.GraphicalView;

import android.app.Activity;
import android.os.Bundle;

public class GraphActivity extends Activity {

    private static GraphicalView view;
    private LineGraph line = new LineGraph();
    private static Thread thread;

    /** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //setContentView(R.layout.main);

        thread = new Thread() {
            public void run()
            {
                for (int i = 0; i < 15; i++)
                {
                    try {
                        Thread.sleep(2000);
                    } catch (InterruptedException e) {
                        // TODO Auto-generated catch block
                        e.printStackTrace();
                    }
                    Point p = ChartData.getDataFromReceiver(i); // New data
                    line.addNewPoints(p); // Add it to graph
                    view.repaint();
                }
            }
        };
        thread.start();
    }

    @Override
    protected void onStart() {
        super.onStart();
        view = line.getView(this);
        setContentView(view);
    }

}
