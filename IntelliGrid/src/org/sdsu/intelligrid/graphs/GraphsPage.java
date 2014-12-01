package org.sdsu.intelligrid.graphs;

import org.sdsu.intelligrid.R;

import android.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;

import org.sdsu.intelligrid.graphs.GraphView;
import org.sdsu.intelligrid.graphs.GraphView.GraphViewData;
import org.sdsu.intelligrid.simulation.Simulation.SimulationData;
import org.sdsu.intelligrid.graphs.GraphViewSeries;
import org.sdsu.intelligrid.graphs.LineGraphView;


public class GraphsPage extends Fragment {

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
        final View view = inflater.inflate(R.layout.graphs, container, false);

        // init example series data
        GraphViewSeries res1 = new GraphViewSeries(new GraphViewData[]{
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

        GraphView graphView = new LineGraphView(
                getActivity() // context
                , "Infographics" // heading
        );
        graphView.addSeries(res1); // data

        LinearLayout layout = (LinearLayout) view.findViewById(R.id.graph1);
        layout.addView(graphView);

        return view;
    }



}
