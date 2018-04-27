package client.view;

import client.services.AffectiveColorService;
import java.awt.BorderLayout;
import java.awt.Color;
import java.util.ArrayList;
import javax.swing.JPanel;

/**
 * The AffectivePanel class creates the affective panel in which graph plot is
 * done based on the six affective parameters.
 * 
 * @author Team06
 * @version 1.0
 */
public class AffectivePanel extends JPanel {

	public static final String TABNAME = "Affective";

	AffectiveGraphPanel panelGraph;
	AffectivePerformanceMetricPanel panelMetric;

	/**
	 * constructor of affective panel. calls two other classes -
	 * AffectiveGraphPanel: for graph plot panel AffectivePerformanceMetricPanel. -
	 * for performance metric panel.
	 *
	 */
	public AffectivePanel() {
		panelGraph = new AffectiveGraphPanel();
		panelMetric = new AffectivePerformanceMetricPanel();
		setLayout(new BorderLayout());
		add(panelGraph, BorderLayout.CENTER);
		add(panelMetric, BorderLayout.EAST);
	}

	/**
	 * setAffectiveListener method passes value to the AffectiveListener of Graph
	 * Panel and Metric value Panel
	 * 
	 * @param affectiveColorService
	 *            instance of AffectiveColorService
	 */
	public void setAffectiveListener(AffectiveColorService affectiveColorService) {
		panelGraph.setAffectiveListener(affectiveColorService);
		panelMetric.setAffectiveListener(affectiveColorService);
	}

	/**
	 * getColors method gets color array from panelMetric
	 * 
	 * @return arraylist containing Colors of each matrix
	 */
	public ArrayList<Color> getColors() {
		return panelMetric.getColors();
	}

	/**
	 * changedisplayLengthLabel functions calls for AffectiveGraphPanel to change
	 * label on Graph plot
	 */
	public void changedisplayLengthLabel() {
		panelGraph.changedisplayLengthLabel();
	}
}