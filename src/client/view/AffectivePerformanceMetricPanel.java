package client.view;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.ComponentOrientation;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JColorChooser;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;

import client.constants.ClientConstants;
import client.services.AffectiveColorService;

/**
 * The AffectivePerformanceMetricPanel class sets up the performance metrics for
 * the AffectivePanel UI
 * 
 * @author Team06
 * @version 1.0
 */
class AffectivePerformanceMetricPanel extends JPanel implements ActionListener, DocumentListener {

	AffectiveColorService affectiveColorService;
	JButton btnFocus;
	JButton btnStress;
	JButton btnInterest;
	JButton btnEngagement;
	JButton btnRelaxation;
	JButton btnExcitement;
	JPanel focusColorDisplay;
	JPanel stressColorDisplay;
	JPanel interestColorDisplay;
	JPanel engagementColorDisplay;
	JPanel relaxationColorDisplay;
	JPanel excitementColorDisplay;
	JPanel panel7;
	JTextField displayLength;
	private ArrayList<Color> colors = new ArrayList<>();

	public AffectivePerformanceMetricPanel() {
		buildPanel();
	}

	/**
	 * affectivePanelComponents configures the Panel with colors and button
	 * 
	 * @param panelComponent
	 *            Panel object on which other components should be integrated
	 * @param colorComponent
	 *            Color component on Affective Panel
	 * @param buttonComponent
	 *            Button for colors on panel
	 * @return
	 */
	private Component affectivePanelComponents(JPanel panelComponent, Color colorComponent, JButton buttonComponent) {
		Color defaultColorFocus = colorComponent;
		colors.add(defaultColorFocus);
		panelComponent.setBackground(defaultColorFocus);
		buttonComponent.setFont(ClientConstants.TEXT_FONT);
		buttonComponent.setPreferredSize(ClientConstants.BUTTON_DIMENSION);
		buttonComponent.addActionListener(this);
		panelComponent.add(buttonComponent);
		return panelComponent;
	}

	/**
	 * This function builds a panel with 6 performance metrics. They are Focus,
	 * Stress, Interest, Engagement, Relaxation.
	 *
	 * @return returns JPanel object with integrated 6 performance matrix
	 */
	public JPanel buildPanel() {
		setLayout(new BorderLayout());
		setBackground(ClientConstants.LIGHT_BLUE);
		JLabel performanceMetricHead = new JLabel(ClientConstants.PERFORMANCE_METRICS, JLabel.CENTER);
		performanceMetricHead.setFont(ClientConstants.TEXT_FONT);
		add(performanceMetricHead, BorderLayout.NORTH);
		JPanel performanceMetricBody = new JPanel(new GridLayout(4, 2));
		performanceMetricBody.setBackground(ClientConstants.LIGHT_GREY);
		focusColorDisplay = new JPanel();
		btnFocus = new JButton(ClientConstants.FOCUS);
		stressColorDisplay = new JPanel();
		btnStress = new JButton(ClientConstants.STRESS);
		interestColorDisplay = new JPanel();
		btnInterest = new JButton(ClientConstants.INTEREST);
		engagementColorDisplay = new JPanel();
		btnEngagement = new JButton(ClientConstants.ENGAGEMENT);
		relaxationColorDisplay = new JPanel();
		btnRelaxation = new JButton(ClientConstants.RELAXATION);
		excitementColorDisplay = new JPanel();
		btnExcitement = new JButton(ClientConstants.EXCITEMENT);
		performanceMetricBody
				.add(affectivePanelComponents(focusColorDisplay, ClientConstants.FOCUS_COLOR_DEFAULT, btnFocus));
		performanceMetricBody
				.add(affectivePanelComponents(stressColorDisplay, ClientConstants.STRESS_COLOR_DEFAULT, btnStress));
		performanceMetricBody.add(
				affectivePanelComponents(interestColorDisplay, ClientConstants.INTEREST_COLOR_DEFAULT, btnInterest));
		performanceMetricBody.add(affectivePanelComponents(engagementColorDisplay,
				ClientConstants.ENGAGEMENT_COLOR_DEFAULT, btnEngagement));
		performanceMetricBody.add(affectivePanelComponents(relaxationColorDisplay,
				ClientConstants.RELAXATION_COLOR_DEFAULT, btnRelaxation));
		performanceMetricBody.add(affectivePanelComponents(excitementColorDisplay,
				ClientConstants.EXCITEMENT_COLOR_DEFAULT, btnExcitement));
		JPanel displayLengthPanel = new JPanel(new GridBagLayout());
		displayLength = new JTextField(10);
		displayLength.setText(String.valueOf(50));
		displayLength.getDocument().addDocumentListener(this);
		displayLengthPanel.add(displayLength, setConstraints(displayLengthPanel));
		performanceMetricBody.add(displayLengthPanel);
		performanceMetricBody.setComponentOrientation(ComponentOrientation.LEFT_TO_RIGHT);
		performanceMetricBody.setBorder(BorderFactory.createEtchedBorder());
		add(performanceMetricBody, BorderLayout.CENTER);
		return this;
	}

	/**
	 * setConstraints method configures the UI constraints on Panel object
	 * 
	 * @param displayLengthPanel
	 *            panel object to set constraints
	 * @return Panel object with constraints
	 */
	private GridBagConstraints setConstraints(JPanel displayLengthPanel) {
		displayLengthPanel.setBackground(ClientConstants.LIGHT_GREY);
		GridBagConstraints displayLengthDimensions = new GridBagConstraints();
		displayLengthDimensions.gridx = 0;
		displayLengthDimensions.gridy = 0;
		JLabel displayLengthLabel = new JLabel(ClientConstants.DISPLAY_LENGTH);
		displayLengthLabel.setFont(ClientConstants.TEXT_FONT);
		displayLengthPanel.add(displayLengthLabel, displayLengthDimensions);
		displayLengthDimensions.gridx = 1;
		displayLengthDimensions.gridy = 0;
		return displayLengthDimensions;
	}

	public void setAffectiveListener(AffectiveColorService affectiveColorService) {
		this.affectiveColorService = affectiveColorService;
	}

	/**
	 * actionPerformed method joins action to it's handler
	 * 
	 * @param e
	 *            ActionEvent instance to denote which actione is performed on GUI
	 */
	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == btnFocus) {
			setColor(focusColorDisplay, 0);
		} else if (e.getSource() == btnStress) {
			setColor(stressColorDisplay, 1);
		} else if (e.getSource() == btnInterest) {
			setColor(interestColorDisplay, 2);
		} else if (e.getSource() == btnEngagement) {
			setColor(engagementColorDisplay, 3);
		} else if (e.getSource() == btnRelaxation) {
			setColor(relaxationColorDisplay, 4);
		} else if (e.getSource() == btnExcitement) {
			setColor(excitementColorDisplay, 5);
		}
	}

	public ArrayList<Color> getColors() {
		return colors;
	}

	public void setColors(ArrayList<Color> colors) {
		this.colors = colors;
	}

	/**
	 * setColor method implements dialogue box for colors
	 * 
	 * @param panel
	 *            panel instance for setting colors dialogue box
	 * @param index
	 *            int to set color of that index
	 */
	private void setColor(JPanel panel, int index) {
		Color newColor = JColorChooser.showDialog(null, ClientConstants.CHOOSE_COLOR, null);
		if (newColor == null) {
			return;
		} else {
			panel.setBackground(newColor);
			colors.set(index, newColor);
		}
	}

	@Override
	public void insertUpdate(DocumentEvent e) {
		affectiveColorService.changedisplayLengthLabel(displayLength.getText());
	}

	@Override
	public void removeUpdate(DocumentEvent e) {
		affectiveColorService.changedisplayLengthLabel(displayLength.getText());
	}

	@Override
	public void changedUpdate(DocumentEvent e) {
		affectiveColorService.changedisplayLengthLabel(displayLength.getText());
	}
}