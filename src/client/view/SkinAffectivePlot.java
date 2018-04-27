package client.view;

import client.constants.ClientConstants;
import client.services.AffectiveColorService;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.axis.ValueAxis;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.chart.plot.XYPlot;
import org.jfree.chart.renderer.xy.XYLineAndShapeRenderer;
import org.jfree.data.xy.XYSeriesCollection;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.util.ArrayList;

//import client.model.SkinAffectivePlotData;

/**
 * The SkinAffectivePlot class sets up the the graph plot for skinaffectivePanel GUI.
 * 
 * @author Team06
 * @version 1.0
 */
public class SkinAffectivePlot extends JPanel {

	JPanel skinaffectivePanel = new JPanel();
	AffectiveColorService affectiveColorService;
	private GraphPlot graphPlot;
	private Integer length = 50;

	public SkinAffectivePlot() {
		this.setPreferredSize(new Dimension(500, 500));
		this.setLayout(new BorderLayout());
		skinaffectivePanel.setLayout(new GridLayout(1, 1, 1, 1));
		skinaffectivePanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		this.add(skinaffectivePanel);
	}

	public void setAffectiveListener(AffectiveColorService affectiveColorService) {
		this.affectiveColorService = affectiveColorService;
	}

	/**
	 * changedisplayLengthLabel changes label on the graph plot
	 */
	public void changedisplayLengthLabel() {
	//	plotAffectiveGraph1(SkinAffectivePlotData.getInstance().regenerateDataSet());
	}

	/**
	 * plotAffectiveGraph1 method provides implementation of plotting values on
	 * AffectiveGraph
	 * 
	 * @param dataset
	 *            XYSeriesCollection values to plot in 2d
	 */
	public void plotAffectiveGraph1(XYSeriesCollection dataset) {
		JFreeChart chart = ChartFactory.createXYLineChart(ClientConstants.EMPTY, ClientConstants.EMPTY,
				ClientConstants.EMPTY, dataset, PlotOrientation.VERTICAL, false, true, false);
		XYPlot plot = chart.getXYPlot();
		XYLineAndShapeRenderer renderer = new XYLineAndShapeRenderer();
		ValueAxis range = plot.getRangeAxis();
		range = plot.getDomainAxis();
	//	range.setRange(0, SkinAffectivePlotData.getInstance().getGraphLength());
		range = plot.getRangeAxis();
		range.setRange(0, 1);
		ArrayList<Color> colors = affectiveColorService.getColors();
		for (int i = 0; i < colors.size(); i++) {
			renderer.setSeriesPaint(i, colors.get(i));
			renderer.setSeriesShapesVisible(i, false);
		}
		plot.setRenderer(renderer);
		plot.setRangeGridlinesVisible(false);
		plot.setDomainGridlinesVisible(false);
		skinaffectivePanel.removeAll();
		skinaffectivePanel.add(new ChartPanel(chart));
		skinaffectivePanel.repaint();
		skinaffectivePanel.revalidate();
	}
}