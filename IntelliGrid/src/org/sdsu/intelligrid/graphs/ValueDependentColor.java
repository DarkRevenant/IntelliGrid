package org.sdsu.intelligrid.graphs;

/**
 * you can change the color depending on the value.
 * takes only effect in BarGraphView
 */
public interface ValueDependentColor {
    public int get(GraphViewDataInterface data);
}
