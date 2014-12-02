package org.sdsu.intelligrid.graphs;

import org.sdsu.intelligrid.R;

import android.app.Fragment;
import android.os.Bundle;
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
import org.sdsu.intelligrid.graphs.LineGraphView;
//import org.sdsu.intelligrid.util.Color;


public class GraphsPage extends Fragment {

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
        final View view = inflater.inflate(R.layout.graphs, container, false);

        // init example series data
        GraphViewSeries res1 = new GraphViewSeries("res1", new GraphViewSeriesStyle(Color.rgb(200,50,00),3), new GraphViewData[]{
                new GraphViewData(0, SimulationData.res1[0])
                , new GraphViewData(1, SimulationData.res1[1])
                , new GraphViewData(2, SimulationData.res1[2])
                , new GraphViewData(3, SimulationData.res1[3])
                , new GraphViewData(4, SimulationData.res1[4])
                , new GraphViewData(5, SimulationData.res1[5])
                , new GraphViewData(6, SimulationData.res1[6])
                , new GraphViewData(7, SimulationData.res1[7])
                , new GraphViewData(8, SimulationData.res1[8])
                , new GraphViewData(9, SimulationData.res1[9])
                , new GraphViewData(10, SimulationData.res1[10])
                , new GraphViewData(11, SimulationData.res1[11])
                , new GraphViewData(12, SimulationData.res1[12])
                , new GraphViewData(13, SimulationData.res1[13])
                , new GraphViewData(14, SimulationData.res1[14])
                , new GraphViewData(15, SimulationData.res1[15])
                , new GraphViewData(16, SimulationData.res1[16])
                , new GraphViewData(17, SimulationData.res1[17])
                , new GraphViewData(18, SimulationData.res1[18])
                , new GraphViewData(19, SimulationData.res1[19])
                , new GraphViewData(20, SimulationData.res1[20])
                , new GraphViewData(21, SimulationData.res1[21])
                , new GraphViewData(22, SimulationData.res1[22])
                , new GraphViewData(23, SimulationData.res1[23])
        });

        GraphViewSeries res2 = new GraphViewSeries(new GraphViewData[]{
                new GraphViewData(0, SimulationData.res2[0])
                , new GraphViewData(1, SimulationData.res2[1])
                , new GraphViewData(2, SimulationData.res2[2])
                , new GraphViewData(3, SimulationData.res2[3])
                , new GraphViewData(4, SimulationData.res2[4])
                , new GraphViewData(5, SimulationData.res2[5])
                , new GraphViewData(6, SimulationData.res2[6])
                , new GraphViewData(7, SimulationData.res2[7])
                , new GraphViewData(8, SimulationData.res2[8])
                , new GraphViewData(9, SimulationData.res2[9])
                , new GraphViewData(10, SimulationData.res2[10])
                , new GraphViewData(11, SimulationData.res2[11])
                , new GraphViewData(12, SimulationData.res2[12])
                , new GraphViewData(13, SimulationData.res2[13])
                , new GraphViewData(14, SimulationData.res2[14])
                , new GraphViewData(15, SimulationData.res2[15])
                , new GraphViewData(16, SimulationData.res2[16])
                , new GraphViewData(17, SimulationData.res2[17])
                , new GraphViewData(18, SimulationData.res2[18])
                , new GraphViewData(19, SimulationData.res2[19])
                , new GraphViewData(20, SimulationData.res2[20])
                , new GraphViewData(21, SimulationData.res2[21])
                , new GraphViewData(22, SimulationData.res2[22])
                , new GraphViewData(23, SimulationData.res2[23])
        });

        GraphViewSeries res3 = new GraphViewSeries(new GraphViewData[]{
        new GraphViewData(0, SimulationData.res3[0])
                , new GraphViewData(1, SimulationData.res3[1])
                , new GraphViewData(2, SimulationData.res3[2])
                , new GraphViewData(3, SimulationData.res3[3])
                , new GraphViewData(4, SimulationData.res3[4])
                , new GraphViewData(5, SimulationData.res3[5])
                , new GraphViewData(6, SimulationData.res3[6])
                , new GraphViewData(7, SimulationData.res3[7])
                , new GraphViewData(8, SimulationData.res3[8])
                , new GraphViewData(9, SimulationData.res3[9])
                , new GraphViewData(10, SimulationData.res3[10])
                , new GraphViewData(11, SimulationData.res3[11])
                , new GraphViewData(12, SimulationData.res3[12])
                , new GraphViewData(13, SimulationData.res3[13])
                , new GraphViewData(14, SimulationData.res3[14])
                , new GraphViewData(15, SimulationData.res3[15])
                , new GraphViewData(16, SimulationData.res3[16])
                , new GraphViewData(17, SimulationData.res3[17])
                , new GraphViewData(18, SimulationData.res3[18])
                , new GraphViewData(19, SimulationData.res3[19])
                , new GraphViewData(20, SimulationData.res3[20])
                , new GraphViewData(21, SimulationData.res3[21])
                , new GraphViewData(22, SimulationData.res3[22])
                , new GraphViewData(23, SimulationData.res3[23])
         });

        GraphViewSeries comm1 = new GraphViewSeries(new GraphViewData[]{
                new GraphViewData(0, SimulationData.comm1[0])
                , new GraphViewData(1, SimulationData.comm1[1])
                , new GraphViewData(2, SimulationData.comm1[2])
                , new GraphViewData(3, SimulationData.comm1[3])
                , new GraphViewData(4, SimulationData.comm1[4])
                , new GraphViewData(5, SimulationData.comm1[5])
                , new GraphViewData(6, SimulationData.comm1[6])
                , new GraphViewData(7, SimulationData.comm1[7])
                , new GraphViewData(8, SimulationData.comm1[8])
                , new GraphViewData(9, SimulationData.comm1[9])
                , new GraphViewData(10, SimulationData.comm1[10])
                , new GraphViewData(11, SimulationData.comm1[11])
                , new GraphViewData(12, SimulationData.comm1[12])
                , new GraphViewData(13, SimulationData.comm1[13])
                , new GraphViewData(14, SimulationData.comm1[14])
                , new GraphViewData(15, SimulationData.comm1[15])
                , new GraphViewData(16, SimulationData.comm1[16])
                , new GraphViewData(17, SimulationData.comm1[17])
                , new GraphViewData(18, SimulationData.comm1[18])
                , new GraphViewData(19, SimulationData.comm1[19])
                , new GraphViewData(20, SimulationData.comm1[20])
                , new GraphViewData(21, SimulationData.comm1[21])
                , new GraphViewData(22, SimulationData.comm1[22])
                , new GraphViewData(23, SimulationData.comm1[23])
        });

        GraphViewSeries comm2 = new GraphViewSeries(new GraphViewData[]{
                new GraphViewData(0, SimulationData.comm2[0])
                , new GraphViewData(1, SimulationData.comm2[1])
                , new GraphViewData(2, SimulationData.comm2[2])
                , new GraphViewData(3, SimulationData.comm2[3])
                , new GraphViewData(4, SimulationData.comm2[4])
                , new GraphViewData(5, SimulationData.comm2[5])
                , new GraphViewData(6, SimulationData.comm2[6])
                , new GraphViewData(7, SimulationData.comm2[7])
                , new GraphViewData(8, SimulationData.comm2[8])
                , new GraphViewData(9, SimulationData.comm2[9])
                , new GraphViewData(10, SimulationData.comm2[10])
                , new GraphViewData(11, SimulationData.comm2[11])
                , new GraphViewData(12, SimulationData.comm2[12])
                , new GraphViewData(13, SimulationData.comm2[13])
                , new GraphViewData(14, SimulationData.comm2[14])
                , new GraphViewData(15, SimulationData.comm2[15])
                , new GraphViewData(16, SimulationData.comm2[16])
                , new GraphViewData(17, SimulationData.comm2[17])
                , new GraphViewData(18, SimulationData.comm2[18])
                , new GraphViewData(19, SimulationData.comm2[19])
                , new GraphViewData(20, SimulationData.comm2[20])
                , new GraphViewData(21, SimulationData.comm2[21])
                , new GraphViewData(22, SimulationData.comm2[22])
                , new GraphViewData(23, SimulationData.comm2[23])
        });

        GraphViewSeries comm3 = new GraphViewSeries(new GraphViewData[]{
                new GraphViewData(0, SimulationData.comm3[0])
                , new GraphViewData(1, SimulationData.comm3[1])
                , new GraphViewData(2, SimulationData.comm3[2])
                , new GraphViewData(3, SimulationData.comm3[3])
                , new GraphViewData(4, SimulationData.comm3[4])
                , new GraphViewData(5, SimulationData.comm3[5])
                , new GraphViewData(6, SimulationData.comm3[6])
                , new GraphViewData(7, SimulationData.comm3[7])
                , new GraphViewData(8, SimulationData.comm3[8])
                , new GraphViewData(9, SimulationData.comm3[9])
                , new GraphViewData(10, SimulationData.comm3[10])
                , new GraphViewData(11, SimulationData.comm3[11])
                , new GraphViewData(12, SimulationData.comm3[12])
                , new GraphViewData(13, SimulationData.comm3[13])
                , new GraphViewData(14, SimulationData.comm3[14])
                , new GraphViewData(15, SimulationData.comm3[15])
                , new GraphViewData(16, SimulationData.comm3[16])
                , new GraphViewData(17, SimulationData.comm3[17])
                , new GraphViewData(18, SimulationData.comm3[18])
                , new GraphViewData(19, SimulationData.comm3[19])
                , new GraphViewData(20, SimulationData.comm3[20])
                , new GraphViewData(21, SimulationData.comm3[21])
                , new GraphViewData(22, SimulationData.comm3[22])
                , new GraphViewData(23, SimulationData.comm3[23])
        });

        GraphView graphView = new LineGraphView(
                getActivity() // context
                , "Load Data" // heading
        );

//        graphView.setCustomLabelFormatter(new CustomLabelFormatter() {
//            @Override
//            public String formatLabel(double value, boolean isValueY) {
//                if (isValueY) {
//                    if (value < 1) {
//                        return "small";
//                    } else if (value < 2) {
//                        return "middle";
//                    } else {
//                        return "big";
//                    }
//                }
//                return null; // let graphview generate Y-axis label for us
//            }
//        });

        graphView.getGraphViewStyle().setTextSize(20);

        graphView.getGraphViewStyle().setNumHorizontalLabels(24);

        graphView.addSeries(res1); // data
        graphView.addSeries(res2);
        graphView.addSeries(res3);
        graphView.addSeries(comm1);
        graphView.addSeries(comm2);
        graphView.addSeries(comm3);

        LinearLayout layout = (LinearLayout) view.findViewById(R.id.graph1);
        layout.addView(graphView);

        return view;
    }



}
