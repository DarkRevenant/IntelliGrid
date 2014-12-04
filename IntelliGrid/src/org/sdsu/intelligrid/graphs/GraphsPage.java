package org.sdsu.intelligrid.graphs;

import org.sdsu.intelligrid.R;

import android.app.Fragment;
import android.os.Bundle;
import android.os.Handler;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.graphics.Color;

import org.sdsu.intelligrid.graphs.GraphView;
import org.sdsu.intelligrid.graphs.GraphView.GraphViewData;
import org.sdsu.intelligrid.simulation.Simulation.SimulationData;
import org.sdsu.intelligrid.graphs.GraphViewSeries;
import org.sdsu.intelligrid.graphs.GraphViewSeries.GraphViewSeriesStyle;
import org.sdsu.intelligrid.graphs.GraphView.LegendAlign;
import org.sdsu.intelligrid.graphs.LineGraphView;
//import org.sdsu.intelligrid.util.Color;


public class GraphsPage extends Fragment {

    private GraphViewSeries res1;
    private GraphViewSeries res2;
    private GraphViewSeries res3;
    private GraphViewSeries comm1;
    private GraphViewSeries comm2;
    private GraphViewSeries comm3;
    private GraphViewSeries Battery;
    private Runnable mTimer1;
    private final Handler mHandler = new Handler();


	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
        final View view = inflater.inflate(R.layout.graphs, container, false);



        //for(int day = 0; day < 7; day++) {

            // init example series data
            GraphViewData[] graphData = new GraphViewData[24]; //7 days

            for (int i = 0; i < 24; i++) {
                graphData[i] = new GraphViewData(i, SimulationData.res1[i%23]);

            }
            res1 = new GraphViewSeries("Residential 1", new GraphViewSeriesStyle(Color.rgb(219, 48, 48), 5), graphData);

            graphData = new GraphViewData[24];
            for (int i = 0; i < 24; i++) {
                graphData[i] = new GraphViewData(i, SimulationData.res2[i%23]);
            }
            res2 = new GraphViewSeries("Residential 2", new GraphViewSeriesStyle(Color.rgb(245, 133, 22), 5), graphData);

            graphData = new GraphViewData[24];
            for (int i = 0; i < 24; i++) {
                graphData[i] = new GraphViewData(i, SimulationData.res3[i%23]);
            }
            res3 = new GraphViewSeries("Residential 3", new GraphViewSeriesStyle(Color.rgb(242, 227, 53), 5), graphData);

            graphData = new GraphViewData[24];
            for (int i = 0; i < 24; i++) {
                graphData[i] = new GraphViewData(i, SimulationData.comm1[i%23]);
            }
            comm1 = new GraphViewSeries("Commercial 1", new GraphViewSeriesStyle(Color.rgb(134, 219, 48), 5), graphData);

            graphData = new GraphViewData[24];
            for (int i = 0; i < 24; i++) {
                graphData[i] = new GraphViewData(i, SimulationData.comm2[i%23]);
            }
            comm2 = new GraphViewSeries("Commercial 2", new GraphViewSeriesStyle(Color.rgb(48, 168, 219), 5), graphData);

            graphData = new GraphViewData[24];
            for (int i = 0; i < 24; i++) {
                graphData[i] = new GraphViewData(i, SimulationData.comm3[i%23]);
            }
            comm3 = new GraphViewSeries("Commercial 3", new GraphViewSeriesStyle(Color.rgb(177, 48, 219), 5), graphData);

            graphData = new GraphViewData[24];
            for (int i = 0; i < 24; i++){
                graphData[i] = new GraphViewData(i, SimulationData.Battery[i%23]);
            }
             Battery = new GraphViewSeries("Battery", new GraphViewSeriesStyle(Color.rgb(20, 129, 12), 5), graphData);

        //}

        GraphView graphView = new LineGraphView(
                getActivity() // context
                , "Load Data" // heading
        );


        graphView.getGraphViewStyle().setTextSize(30);

        graphView.getGraphViewStyle().setNumHorizontalLabels(12);

        graphView.addSeries(res1); // data
        graphView.addSeries(res2);
        graphView.addSeries(res3);
        graphView.addSeries(comm1);
        graphView.addSeries(comm2);
        graphView.addSeries(comm3);
        graphView.addSeries(Battery);

        graphView.setViewPort(0,11);
        graphView.setScrollable(true);
        graphView.setScalable(true);

        // set legend
        graphView.setShowLegend(true);
        graphView.setLegendAlign(LegendAlign.TOP);
        graphView.getGraphViewStyle().setLegendWidth(250);

        LinearLayout layout = (LinearLayout) view.findViewById(R.id.graph1);
        layout.addView(graphView);
        ((LineGraphView) graphView).setDrawDataPoints(true);
        ((LineGraphView) graphView).setDataPointsRadius(10f);

        return view;
    }

    public void update() {

    }


//    @Override
//    public void onPause() {
//        mHandler.removeCallbacks(mTimer1);
//        //mHandler.removeCallbacks(mTimer2);
//        super.onPause();
//    }
//
//    @Override
//     public void onResume() {
//        super.onResume();
//
//        mTimer1 = new Runnable() {
//
//            @Override
//            public void run() {
//                int graph = 2;
//                graph += 1;
//
//                for (int y = 0; y < 24; y++) {
//                    res1.appendData(new GraphViewData(graph, SimulationData.res1[y%23]), true, 10);
//                }
////                res1.appendData(new GraphViewData(graph, 2), true, 10);
//                mHandler.postDelayed(this, 200);
//            }
//        };
//
//        mHandler.postDelayed(mTimer1, 1000);

//        mTimer1 = new Runnable() {
//            @Override
//            public void run() {
//                res1.resetData(new GraphViewData[] {
//                        new GraphViewData(0, SimulationData.res1[0])
//                        , new GraphViewData(1, SimulationData.res1[1])
//                        , new GraphViewData(2, SimulationData.res1[2])
//                        , new GraphViewData(3, SimulationData.res1[3])
//                        , new GraphViewData(4, SimulationData.res1[4])
//                        , new GraphViewData(5, SimulationData.res1[5])
//                        , new GraphViewData(6, SimulationData.res1[6])
//                        , new GraphViewData(7, SimulationData.res1[7])
//                        , new GraphViewData(8, SimulationData.res1[8])
//                        , new GraphViewData(9, SimulationData.res1[9])
//                        , new GraphViewData(10, SimulationData.res1[10])
//                        , new GraphViewData(11, SimulationData.res1[11])
//                        , new GraphViewData(12, SimulationData.res1[12])
//                        , new GraphViewData(13, SimulationData.res1[13])
//                        , new GraphViewData(14, SimulationData.res1[14])
//                        , new GraphViewData(15, SimulationData.res1[15])
//                        , new GraphViewData(16, SimulationData.res1[16])
//                        , new GraphViewData(17, SimulationData.res1[17])
//                        , new GraphViewData(18, SimulationData.res1[18])
//                        , new GraphViewData(19, SimulationData.res1[19])
//                        , new GraphViewData(20, SimulationData.res1[20])
//                        , new GraphViewData(21, SimulationData.res1[21])
//                        , new GraphViewData(22, SimulationData.res1[22])
//                        , new GraphViewData(23, SimulationData.res1[23])
//                });
//                res2.resetData(new GraphViewData[] {
//                        new GraphViewData(0, SimulationData.res2[0])
//                        , new GraphViewData(1, SimulationData.res2[1])
//                        , new GraphViewData(2, SimulationData.res2[2])
//                        , new GraphViewData(3, SimulationData.res2[3])
//                        , new GraphViewData(4, SimulationData.res2[4])
//                        , new GraphViewData(5, SimulationData.res2[5])
//                        , new GraphViewData(6, SimulationData.res2[6])
//                        , new GraphViewData(7, SimulationData.res2[7])
//                        , new GraphViewData(8, SimulationData.res2[8])
//                        , new GraphViewData(9, SimulationData.res2[9])
//                        , new GraphViewData(10, SimulationData.res2[10])
//                        , new GraphViewData(11, SimulationData.res2[11])
//                        , new GraphViewData(12, SimulationData.res2[12])
//                        , new GraphViewData(13, SimulationData.res2[13])
//                        , new GraphViewData(14, SimulationData.res2[14])
//                        , new GraphViewData(15, SimulationData.res2[15])
//                        , new GraphViewData(16, SimulationData.res2[16])
//                        , new GraphViewData(17, SimulationData.res2[17])
//                        , new GraphViewData(18, SimulationData.res2[18])
//                        , new GraphViewData(19, SimulationData.res2[19])
//                        , new GraphViewData(20, SimulationData.res2[20])
//                        , new GraphViewData(21, SimulationData.res2[21])
//                        , new GraphViewData(22, SimulationData.res2[22])
//                        , new GraphViewData(23, SimulationData.res2[23])
//                });
//                mHandler.postDelayed(this, 300);
//            }
//        };
//        mHandler.postDelayed(mTimer1, 300);
//    }

}
