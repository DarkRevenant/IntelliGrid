// Copyright 2014 Emmanuel Demonteverde and San Diego Gas and Electric, all rights reserved

package org.sdsu.intelligrid.graphs;

import org.sdsu.intelligrid.R;

import android.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.graphics.Color;

import org.sdsu.intelligrid.simulation.Simulation.SimInfo;

import com.jjoe64.graphview.*;
import com.jjoe64.graphview.GraphViewSeries.*;
import com.jjoe64.graphview.GraphView.*;

public class GraphsPage extends Fragment {

	// private GraphViewSeries res1update;
	// private GraphViewSeries res1;
	// private GraphViewSeries res2;
	// private GraphViewSeries res2update;
	// private GraphViewSeries res3;
	// private GraphViewSeries res3update;
	// private GraphViewSeries comm1;
	// private GraphViewSeries comm1update;
	// private GraphViewSeries comm2;
	// private GraphViewSeries comm2update;
	// private GraphViewSeries comm3;
	// private GraphViewSeries comm3update;
	private GraphViewSeries feeder1;
	private GraphViewSeries feeder2;
	private GraphViewSeries sdge;
	private GraphViewSeries renewables;

	private GraphView graphView;

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		final View view = inflater.inflate(R.layout.graphs, container, false);

		// init example series data
		GraphViewData[] graphData = new GraphViewData[24];

		// for (int i = 0; i < 24; i++) {
		// graphData[i] = new GraphViewData(i, SimulationData.res1[i % 23]);
		// }
		// res1 = new GraphViewSeries("Res 1 Forecast", new
		// GraphViewSeriesStyle(
		// Color.rgb(237, 216, 216), 5), graphData);
		// res1update = new GraphViewSeries("Residential 1",
		// new GraphViewSeriesStyle(Color.rgb(219, 48, 48), 5), graphData);
		// res1update.resetData(new GraphViewDataInterface[0]);
		//
		// graphData = new GraphViewData[24];
		// for (int i = 0; i < 24; i++) {
		// graphData[i] = new GraphViewData(i, SimulationData.res2[i % 23]);
		// }
		// res2 = new GraphViewSeries("Res 2 Forecast", new
		// GraphViewSeriesStyle(
		// Color.rgb(245, 225, 206), 5), graphData);
		// res2update = new GraphViewSeries("Residential 2",
		// new GraphViewSeriesStyle(Color.rgb(245, 133, 22), 5), graphData);
		// res2update.resetData(new GraphViewDataInterface[0]);
		//
		// graphData = new GraphViewData[24];
		// for (int i = 0; i < 24; i++) {
		// graphData[i] = new GraphViewData(i, SimulationData.res3[i % 23]);
		// }
		// res3 = new GraphViewSeries("Res 3 Forecast", new
		// GraphViewSeriesStyle(
		// Color.rgb(245, 241, 196), 5), graphData);
		// res3update = new GraphViewSeries("Residential 3",
		// new GraphViewSeriesStyle(Color.rgb(242, 227, 53), 5), graphData);
		// res3update.resetData(new GraphViewDataInterface[0]);
		//
		// graphData = new GraphViewData[24];
		// for (int i = 0; i < 24; i++) {
		// graphData[i] = new GraphViewData(i, SimulationData.comm1[i % 23]);
		// }
		// comm2 = new GraphViewSeries("Comm 2 Forecast",
		// new GraphViewSeriesStyle(Color.rgb(202, 216, 222), 5),
		// graphData);
		// comm1update = new GraphViewSeries("Commercial 1",
		// new GraphViewSeriesStyle(Color.rgb(134, 219, 48), 5), graphData);
		// comm1update.resetData(new GraphViewDataInterface[0]);
		//
		// graphData = new GraphViewData[24];
		// for (int i = 0; i < 24; i++) {
		// graphData[i] = new GraphViewData(i, SimulationData.comm2[i % 23]);
		// }
		// comm3 = new GraphViewSeries("Comm 3 Forecast",
		// new GraphViewSeriesStyle(Color.rgb(227, 218, 230), 5),
		// graphData);
		// comm2update = new GraphViewSeries("Commercial 2",
		// new GraphViewSeriesStyle(Color.rgb(48, 168, 219), 5), graphData);
		// comm2update.resetData(new GraphViewDataInterface[0]);
		//
		// graphData = new GraphViewData[24];
		// for (int i = 0; i < 24; i++) {
		// graphData[i] = new GraphViewData(i, SimulationData.comm3[i % 23]);
		// }
		// comm1 = new GraphViewSeries("Comm 1 Forecast",
		// new GraphViewSeriesStyle(Color.rgb(207, 227, 186), 5),
		// graphData);
		// comm3update = new GraphViewSeries("Commercial 3",
		// new GraphViewSeriesStyle(Color.rgb(177, 48, 219), 5), graphData);
		// comm3update.resetData(new GraphViewDataInterface[0]);

		graphData = new GraphViewData[24];
		for (int i = 0; i < 24; i++) {
			graphData[i] = new GraphViewData(i, 0);
		}
		feeder1 = new GraphViewSeries("Residential Feeder",
				new GraphViewSeriesStyle(Color.rgb(255, 0, 0), 10), graphData);
		feeder1.resetData(new GraphViewDataInterface[0]);

		graphData = new GraphViewData[24];
		for (int i = 0; i < 24; i++) {
			graphData[i] = new GraphViewData(i, 0);
		}
		feeder2 = new GraphViewSeries("Industrial Feeder",
				new GraphViewSeriesStyle(Color.rgb(255, 255, 0), 10), graphData);
		feeder2.resetData(new GraphViewDataInterface[0]);

		graphData = new GraphViewData[24];
		for (int i = 0; i < 24; i++) {
			graphData[i] = new GraphViewData(i, 0);
		}
		sdge = new GraphViewSeries("SDG&E Power", new GraphViewSeriesStyle(
				Color.rgb(0, 255, 255), 15), graphData);
		sdge.resetData(new GraphViewDataInterface[0]);

		graphData = new GraphViewData[24];
		for (int i = 0; i < 24; i++) {
			graphData[i] = new GraphViewData(i, 0);
		}
		renewables = new GraphViewSeries("Renewable Energy",
				new GraphViewSeriesStyle(Color.rgb(0, 255, 0), 10), graphData);
		renewables.resetData(new GraphViewDataInterface[0]);

		// graphData = new GraphViewData[24];
		// for (int i = 0; i < 24; i++) {
		// graphData[i] = new GraphViewData(i, SimulationData.Battery[i % 23]);
		// }
		// Battery = new GraphViewSeries("Battery", new
		// GraphViewSeriesStyle(Color.rgb(31, 164, 5), 5), graphData);
		// Battery.resetData(new GraphViewDataInterface[0]);

		graphView = new LineGraphView(getActivity() // context
				, "Load Data" // heading
		);

		graphView.getGraphViewStyle().setTextSize(30);

		graphView.getGraphViewStyle().setNumHorizontalLabels(24);
		// graphView.getGraphViewStyle().setNumVerticalLabels(16);

		// graphView.addSeries(res1);// data
		// graphView.addSeries(res2);
		// graphView.addSeries(res3);
		// graphView.addSeries(comm1);
		// graphView.addSeries(comm2);
		// graphView.addSeries(comm3);
		// graphView.addSeries(res1update);
		// graphView.addSeries(res2update);
		// graphView.addSeries(res3update);
		// graphView.addSeries(comm1update);
		// graphView.addSeries(comm2update);
		// graphView.addSeries(comm3update);
		graphView.addSeries(feeder1);
		graphView.addSeries(feeder2);
		graphView.addSeries(sdge);
		graphView.addSeries(renewables);

		// graphView.addSeries(Battery);

		graphView.setManualMinY(true);
		graphView.setManualYMinBound(0.0);
		graphView.setViewPort(0, 23);
		graphView.setScrollable(true);
		// graphView.setScalable(true);

		// set legend
		graphView.setShowLegend(true);
		graphView.setLegendAlign(LegendAlign.TOP);
		graphView.getGraphViewStyle().setLegendWidth(300);

		LinearLayout layout = (LinearLayout) view.findViewById(R.id.graph1);
		layout.addView(graphView);
		((LineGraphView) graphView).setDrawDataPoints(true);
		((LineGraphView) graphView).setDataPointsRadius(10f);

		return view;
	}

	private double lastTime = 12.0;

	private int hour = 12;

	public void update() {
		double currentTime = SimInfo.currentTime;
		boolean update = false;
		if (currentTime < lastTime) {
			hour++;
			update = true;
		} else {
			if ((int) currentTime > (int) lastTime) {
				hour++;
				update = true;
			}
		}
		if (hour >= 24) {
			hour = 0;
			// res1update.resetData(new GraphViewDataInterface[0]);
			// res2update.resetData(new GraphViewDataInterface[0]);
			// res3update.resetData(new GraphViewDataInterface[0]);
			// comm1update.resetData(new GraphViewDataInterface[0]);
			// comm2update.resetData(new GraphViewDataInterface[0]);
			// comm3update.resetData(new GraphViewDataInterface[0]);
			feeder1.resetData(new GraphViewDataInterface[0]);
			feeder2.resetData(new GraphViewDataInterface[0]);
			sdge.resetData(new GraphViewDataInterface[0]);
			renewables.resetData(new GraphViewDataInterface[0]);
			// Battery.resetData(new GraphViewDataInterface[0]);
		}
		lastTime = currentTime;

		if (!update) {
			return;
		}

		// res1update.appendData(new GraphViewData(hour, SimInfo.Load1), true,
		// 24);
		// res2update.appendData(new GraphViewData(hour, SimInfo.Load2), true,
		// 24);
		// res3update.appendData(new GraphViewData(hour, SimInfo.Load3), true,
		// 24);
		// comm1update
		// .appendData(new GraphViewData(hour, SimInfo.Load6), true, 24);
		// comm2update
		// .appendData(new GraphViewData(hour, SimInfo.Load5), true, 24);
		// comm3update
		// .appendData(new GraphViewData(hour, SimInfo.Load4), true, 24);
		feeder1.appendData(new GraphViewData(hour, SimInfo.trA
				/ SimInfo.GenScale), true, 24);
		feeder2.appendData(new GraphViewData(hour, SimInfo.trM
				/ SimInfo.GenScale), true, 24);
		sdge.appendData(new GraphViewData(hour, SimInfo.SDGE), true, 24);
		renewables.appendData(
				new GraphViewData(hour, Math.max(SimInfo.BatteryStorage, 0.0)
						+ Math.max(-SimInfo.Load1, 0.0)
						+ Math.max(-SimInfo.Load2, 0.0)
						+ Math.max(-SimInfo.Load3, 0.0)
						+ Math.max(-SimInfo.Load4, 0.0)
						+ Math.max(-SimInfo.Load5, 0.0)
						+ Math.max(-SimInfo.Load6, 0.0) + SimInfo.PowPlant
						+ SimInfo.WindTurbines), true, 24);
		graphView.setViewPort(0, 23);
		// Battery.appendData(new GraphViewData(hour, SimInfo.BatteryStorage),
		// true, 24 * 5);
	}
}
