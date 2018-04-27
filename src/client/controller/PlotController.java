package client.controller;

import client.model.ExpressivePlotData;
import client.model.SkinPlotData;

import java.util.ArrayList;

/**
 * The PlotController class controller for expression values
 * 
 * @author Team06
 * @version 1.0
 */
public class PlotController {

	ExpressivePlotData expressivePlotData;
	SkinPlotData skinPlotData;
	ArrayList<ArrayList<Float>> expressData = new ArrayList<>();
	ArrayList<ArrayList<Float>> skinexpressData = new ArrayList<>();


	public ArrayList getExpressivePlotData() {
		expressivePlotData = ExpressivePlotData.getInstance();
		expressData.add(expressivePlotData.getBlinkList());
		expressData.add(expressivePlotData.getClenchList());
		expressData.add(expressivePlotData.getFurrowBrowList());
		expressData.add(expressivePlotData.getLaughList());
		expressData.add(expressivePlotData.getLookLeftList());
		expressData.add(expressivePlotData.getLookRightList());
		expressData.add(expressivePlotData.getRaiseBrowList());
		expressData.add(expressivePlotData.getSmileList());
		expressData.add(expressivePlotData.getSmirkLeftList());
		expressData.add(expressivePlotData.getSmirkRightList());
		expressData.add(expressivePlotData.getWinkLeftList());
		expressData.add(expressivePlotData.getWinkRightList());
		return expressData;
	}

	public ArrayList getSkinExpressivePlotData() {
		skinPlotData = SkinPlotData.getInstance();
		expressData.add(expressivePlotData.getBlinkList());
		expressData.add(expressivePlotData.getClenchList());
		expressData.add(expressivePlotData.getFurrowBrowList());
		expressData.add(expressivePlotData.getLaughList());
		expressData.add(expressivePlotData.getLookLeftList());
		expressData.add(expressivePlotData.getLookRightList());
		expressData.add(expressivePlotData.getRaiseBrowList());
		expressData.add(expressivePlotData.getSmileList());
		expressData.add(expressivePlotData.getSmirkLeftList());
		expressData.add(expressivePlotData.getSmirkRightList());
		expressData.add(expressivePlotData.getWinkLeftList());
		expressData.add(expressivePlotData.getWinkRightList());
		return expressData;
	}
}