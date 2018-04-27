package client.view;

import client.constants.ClientConstants;
import client.services.AffectiveColorService;

import javax.swing.*;
import java.awt.*;

/**
 * The AffectiveGraphPanel class sets up the the graph plot for AffectivePanel
 * UI.
 * 
 * @author Team06
 * @version 1.0
 */
class SkinAffectiveGraphPanel extends JPanel {

	SkinAffectivePlot skinaffectiveGraphPlot;

	public SkinAffectiveGraphPanel() {
		buildPanel();
	}

	/**
	 * buildPanel function constructs a JPanel at the center for graph plot.
	 * 
	 * @return
	 */
	public JPanel buildPanel() {
		setLayout(new BorderLayout());
		setBackground(ClientConstants.LIGHT_YELLOW);
		JLabel graphPlotLabel = new JLabel(ClientConstants.GRAPH_PLOT, JLabel.CENTER);
		graphPlotLabel.setFont(ClientConstants.TEXT_FONT);
		add(graphPlotLabel, BorderLayout.NORTH);
		setLayout(new BorderLayout());
		skinaffectiveGraphPlot = new SkinAffectivePlot();
		//ClientDataSingleton.getInstance().setAffectivePlot(skinaffectiveGraphPlot);
		skinaffectiveGraphPlot.setBackground(Color.WHITE);
		add(skinaffectiveGraphPlot);
		return this;
	}

	/**
	 * setAffectiveListener method provides connection listener to graph plot
	 * 
	 * @param affectiveColorService
	 *            instance of AffectiveColorService
	 */
	public void setAffectiveListener(AffectiveColorService affectiveColorService) {
		skinaffectiveGraphPlot.setAffectiveListener(affectiveColorService);
	}

	/**
	 * changedisplayLengthLabel method calls for change label on graph plot
	 */
	public void changedisplayLengthLabel() {
		skinaffectiveGraphPlot.changedisplayLengthLabel();
	}
}