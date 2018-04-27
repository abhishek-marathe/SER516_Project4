package client.view;

import javax.swing.*;
import client.model.ClientDataSingleton;
import java.awt.*;

/**
 * The EmotivePanel class is a expressive tab on the GUI.
 * 
 * @author Team06
 * @version 1.0
 */
public class EmotivePanel extends JPanel {
	public static final String TABNAME = "Expressive";
	FaceExpressions faceExpressions;
	ExpressionPlots expressionPlots;

	/**
	 * Sets up the Emotive Panel
	 */
	public EmotivePanel() {
		setLayout(new BorderLayout());
		faceExpressions = new FaceExpressions();
		expressionPlots = new ExpressionPlots();
		ClientDataSingleton.getInstance().setExpressplot(expressionPlots);
		ClientDataSingleton.getInstance().setFaceExpressions(faceExpressions);
		JSplitPane splitPane = new JSplitPane(JSplitPane.HORIZONTAL_SPLIT);
		splitPane.setResizeWeight(0.3);
		splitPane.setEnabled(false);
		splitPane.setDividerSize(0);
		splitPane.add(faceExpressions);
		splitPane.add(expressionPlots);
		add(splitPane, BorderLayout.CENTER);
	}
}