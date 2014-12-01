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
import org.sdsu.intelligrid.graphs.GraphViewSeries;
import org.sdsu.intelligrid.graphs.LineGraphView;


public class GraphsPage extends Fragment {

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
        final View view = inflater.inflate(R.layout.graphs, container, false);

        // init example series data
        GraphViewSeries exampleSeries = new GraphViewSeries(new GraphViewData[]{
                new GraphViewData(1, 2.0d)
                , new GraphViewData(2, 1.5d)
                , new GraphViewData(3, 2.5d)
                , new GraphViewData(4, 1.0d)
        });

        GraphView graphView = new LineGraphView(
                getActivity() // context
                , "GraphViewDemo" // heading
        );
        graphView.addSeries(exampleSeries); // data

        LinearLayout layout = (LinearLayout) view.findViewById(R.id.graph1);
        layout.addView(graphView);

        return view;
    }



}
