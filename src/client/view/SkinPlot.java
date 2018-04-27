package client.view;

import client.constants.ClientConstants;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.Random;
//import client.model.ExpressiveDataModel;

public class SkinPlot extends JPanel {



	JPanel dustPanel = new JPanel();
	JPanel heatPanel = new JPanel();
	JPanel coldPanel = new JPanel();
	JSplitPane dustSplitPane = new JSplitPane(JSplitPane.HORIZONTAL_SPLIT);
	JSplitPane heatSplitPane = new JSplitPane(JSplitPane.HORIZONTAL_SPLIT);
	JSplitPane coldSplitPane = new JSplitPane(JSplitPane.HORIZONTAL_SPLIT);
	//private PlotController plotController = new PlotController();
	private ArrayList<ArrayList<Float>> plotData = new ArrayList<>();
	private ArrayList<ArrayList<Float>> inputData = new ArrayList<>();
	private ArrayList<Color> colors = new ArrayList<>();
	private GraphPlot graphPlot;
	private GraphPlot dustGraphPlot;
	private GraphPlot heatGraphPlot;
	private GraphPlot coldGraphPlot;
	
	public SkinPlot() {
		this.setPreferredSize(new Dimension(500, 500));
		addPanels();
	}

	/**
	 * setRandomColors method assigns color values
	 * 
	 * @param size
	 *            int size of color array
	 */
	private void setRandomColors(int size) {
		for (int i = 0; i < size; i++) {
			Random rand = new Random();
			float r = rand.nextFloat();
			float g = rand.nextFloat();
			float b = rand.nextFloat();
			Color randomColor = new Color(r, g, b);
			colors.add(randomColor);
		}
	}

	/**
	 * addPanels method configures the 12 graph plots on Expressive panel
	 */
	public void addPanels() {
		this.setLayout(new GridLayout(12, 1, 1, 1));
		setPanelsLayout(dustPanel, dustSplitPane, ClientConstants.BLINK);
		setPanelsLayout(heatPanel, heatSplitPane, ClientConstants.CLENCH);
		setPanelsLayout(coldPanel, coldSplitPane, ClientConstants.FURROW_BROW);
		this.add(dustPanel);
		this.add(heatPanel);
		this.add(coldPanel);
		setRandomColors(3);
	}

	private void setPanelsLayout(JPanel expression, JSplitPane splitPane, String feature) {
		expression.setLayout(new GridLayout(1, 1, 1, 1));
		splitPane.setResizeWeight(0.1);
		splitPane.setDividerLocation(100);
		splitPane.setEnabled(false);
		splitPane.setDividerSize(0);
		splitPane.add(new JLabel(feature));
		expression.add(splitPane);
	}

	/**
	 * plotGraphForFeature plots feature values received from server
	 * 
	 * @param data
	 *            ArrayList received from server
	 * @return GraphPlot instance of graph
	 */
	private GraphPlot plotGraphForFeature(ArrayList<Float> data) {
		inputData.clear();
		inputData.add(data);
		graphPlot = new GraphPlot(inputData, colors);
		graphPlot.setBackground(Color.LIGHT_GRAY);
		return graphPlot;
	}

	/**
	 * plotExpressionGraph method adds values to the graph and plots graph
	 */
	public void plotExpressionGraph() {
		/*if (ClientDataSingleton.getInstance().getFaceData() != null) {
			plotData = plotController.getExpressivePlotData();
			blinkGraphPlot = plotGraphForFeature(plotData.get(0));
			addGraphsToPanel(blinkPanel, blinkSplitPane, blinkGraphPlot, ClientConstants.BLINK);
			clenchGraphPlot = plotGraphForFeature(plotData.get(1));
			addGraphsToPanel(clenchPanel, clenchSplitPane, clenchGraphPlot, ClientConstants.CLENCH);
			furrowBrowGraphPlot = plotGraphForFeature(plotData.get(2));
			addGraphsToPanel(furrowBrowPanel, furrowBrowSplitPane, furrowBrowGraphPlot, ClientConstants.FURROW_BROW);
			laughGraphPlot = plotGraphForFeature(plotData.get(3));
			addGraphsToPanel(laughPanel, laughSplitPane, laughGraphPlot, ClientConstants.LAUGH);
			lookLeftGraphPlot = plotGraphForFeature(plotData.get(4));
			addGraphsToPanel(lookLeftPanel, lookLeftSplitPane, lookLeftGraphPlot, ClientConstants.LOOK_LEFT);
			lookRightGraphPlot = plotGraphForFeature(plotData.get(5));
			addGraphsToPanel(lookRightPanel, lookRightSplitPane, lookRightGraphPlot, ClientConstants.LOOK_RIGHT);
			raiseBrowGraphPlot = plotGraphForFeature(plotData.get(6));
			addGraphsToPanel(raiseBrowPanel, raiseBrowSplitPane, raiseBrowGraphPlot, ClientConstants.RAISE_BROW);
			smileGraphPlot = plotGraphForFeature(plotData.get(7));
			addGraphsToPanel(smilePanel, smileSplitPane, smileGraphPlot, ClientConstants.SMILE);
			smirkLeftGraphPlot = plotGraphForFeature(plotData.get(8));
			addGraphsToPanel(smirkLeftPanel, smirkLeftSplitPane, smirkLeftGraphPlot, ClientConstants.SMIRK_LEFT);
			smirkRightGraphPlot = plotGraphForFeature(plotData.get(9));
			addGraphsToPanel(smirkRightPanel, smirkRightSplitPane, smirkRightGraphPlot, ClientConstants.SMIRK_RIGHT);
			winkLeftGraphPlot = plotGraphForFeature(plotData.get(10));
			addGraphsToPanel(winkLeftPanel, winkLeftSplitPane, winkLeftGraphPlot, ClientConstants.WINK_LEFT);
			winkRightGraphPlot = plotGraphForFeature(plotData.get(11));
			addGraphsToPanel(winkRightPanel, winkRightSplitPane, winkRightGraphPlot, ClientConstants.WINK_RIGHT);
		}*/
	}

	/**
	 * addGraphsToPanel adds plotted graph to the panel
	 * 
	 * @param expression
	 *            Panel object of each expression
	 * @param splitPane
	 *            SplitPane object to split label and graph
	 * @param graphPlotCurr
	 *            GraphPlot graph with values
	 * @param feature
	 *            String with feature name related to expression
	 */
	private void addGraphsToPanel(JPanel expression, JSplitPane splitPane, GraphPlot graphPlotCurr, String feature) {
		expression.removeAll();
		splitPane.removeAll();
		setPanelsLayout(expression, splitPane, feature);
		splitPane.add(graphPlotCurr);
		expression.add(splitPane);
		expression.repaint();
		expression.revalidate();
	}
}