package client.view;

import javax.swing.*;
import java.awt.*;

/**
 * The SkinPanel class is a expressive tab on the GUI.
 * 
 * @author Team06
 * @version 1.0
 */
public class SkinPanel extends JPanel {
	public static final String TABNAME = "SkinPanel";
	SkinFaceExpressions skinfaceExpressions;
	SkinPlot skinPlots;
	SkinAffectiveGraphPanel skinAffectiveGraphPanel;
	//SkinAffectivePlot skinAffectivePlot;

	/**
	 * Sets up the Emotive Panel
	 */
	public SkinPanel() {
		setLayout(new BorderLayout());
		skinfaceExpressions = new SkinFaceExpressions();
		skinPlots = new SkinPlot();
		skinAffectiveGraphPanel= new SkinAffectiveGraphPanel();
		
		/*ClientDataSingleton.getInstance().setExpressplot(skinPlots);
		ClientDataSingleton.getInstance().setFaceExpressions(skinfaceExpressions);
		JSplitPane splitPane = new JSplitPane(JSplitPane.HORIZONTAL_SPLIT);
		splitPane.setResizeWeight(0.3);
		splitPane.setEnabled(false);
		splitPane.setDividerSize(0);
		splitPane.add(skinfaceExpressions);
		splitPane.add(skinPlots);
		add(splitPane, BorderLayout.CENTER);
		*/
		
		JSplitPane splitPaneV = new JSplitPane(JSplitPane.VERTICAL_SPLIT);
		splitPaneV.setEnabled(false);
		splitPaneV.setDividerSize(0);
		splitPaneV.add(skinPlots);
		splitPaneV.add(skinAffectiveGraphPanel);
		
		JSplitPane splitPaneH = new JSplitPane(JSplitPane.HORIZONTAL_SPLIT);
		
		splitPaneH.setResizeWeight(0.3);
		splitPaneH.setEnabled(false);
		splitPaneH.setDividerSize(0);		
		splitPaneH.add(skinfaceExpressions);
		splitPaneH.add(splitPaneV);
		add(splitPaneH, BorderLayout.CENTER);

	}
}