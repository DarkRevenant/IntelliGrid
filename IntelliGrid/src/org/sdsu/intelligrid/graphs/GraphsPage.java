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
//import org.sdsu.intelligrid.simulation.Simulation.SimulationData;
import org.sdsu.intelligrid.graphs.GraphViewSeries;
import org.sdsu.intelligrid.graphs.LineGraphView;


public class GraphsPage extends Fragment {

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
        final View view = inflater.inflate(R.layout.graphs, container, false);

        // init example series data
        GraphViewSeries res1 = new GraphViewSeries(new GraphViewData[]{
                new GraphViewData(0, 4d)
                , new GraphViewData(1, 1.5d)
                , new GraphViewData(2, 2.5d)
                , new GraphViewData(3, 1.0d)
                , new GraphViewData(4, 1.0d)
                , new GraphViewData(5, 1.0d)
                , new GraphViewData(6, 1.0d)
                , new GraphViewData(7, 1.0d)
                , new GraphViewData(8, 1.0d)
                , new GraphViewData(9, 1.0d)
                , new GraphViewData(10, 1.0d)
                , new GraphViewData(11, 1.0d)
                , new GraphViewData(12, 1.0d)
                , new GraphViewData(13, 1.0d)
                , new GraphViewData(14, 1.0d)
                , new GraphViewData(15, 1.0d)
                , new GraphViewData(16, 1.0d)
                , new GraphViewData(17, 1.0d)
                , new GraphViewData(18, 1.0d)
                , new GraphViewData(19, 1.0d)
                , new GraphViewData(20, 1.0d)
                , new GraphViewData(21, 1.0d)
                , new GraphViewData(22, 1.0d)
                , new GraphViewData(23, 1.0d)
        });

        GraphView graphView = new LineGraphView(
                getActivity() // context
                , "GraphViewDemo" // heading
        );
        graphView.addSeries(res1); // data

        LinearLayout layout = (LinearLayout) view.findViewById(R.id.graph1);
        layout.addView(graphView);

        return view;
    }



}
