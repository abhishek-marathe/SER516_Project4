package client.view;

import java.awt.BorderLayout;
import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.JPanel;
import client.constants.ClientConstants;
import client.model.ClientDataSingleton;
import client.services.AffectiveColorService;

/**
 * The AffectiveGraphPanel class sets up the the graph plot for AffectivePanel
 * UI.
 * 
 * @author Team06
 * @version 1.0
 */
class AffectiveGraphPanel extends JPanel {

	AffectivePlot affectiveGraphPlot;

	public AffectiveGraphPanel() {
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
		affectiveGraphPlot = new AffectivePlot();
		ClientDataSingleton.getInstance().setAffectivePlot(affectiveGraphPlot);
		affectiveGraphPlot.setBackground(Color.WHITE);
		add(affectiveGraphPlot);
		return this;
	}

	/**
	 * setAffectiveListener method provides connection listener to graph plot
	 * 
	 * @param affectiveColorService
	 *            instance of AffectiveColorService
	 */
	public void setAffectiveListener(AffectiveColorService affectiveColorService) {
		affectiveGraphPlot.setAffectiveListener(affectiveColorService);
	}

	/**
	 * changedisplayLengthLabel method calls for change label on graph plot
	 */
	public void changedisplayLengthLabel() {
		affectiveGraphPlot.changedisplayLengthLabel();
	}
}