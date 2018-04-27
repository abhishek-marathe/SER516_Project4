package client.view;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Toolkit;
import java.util.ArrayList;

import javax.swing.JFrame;
import javax.swing.JTabbedPane;
import javax.swing.border.EmptyBorder;

import client.constants.ClientConstants;
import client.services.AffectiveColorService;
import client.services.ClientServerConnectionService;

/**
 * The ClientFrame class creates the client main window.
 * 
 * @author Team06
 * @version 1.0
 */
public class ClientFrame extends JFrame {

	EmotivePanel emotivePanel;
	AffectivePanel affectivePanel;
	SkinPanel skinPanel;
	MenuBar menuBar;

	public ClientFrame() {
		setTitle(ClientConstants.TITLE);
		menuBar = new MenuBar();
		JTabbedPane tabbedPane = new JTabbedPane();
		emotivePanel = new EmotivePanel();
		affectivePanel = new AffectivePanel();
		skinPanel= new SkinPanel();
		tabbedPane.addTab(EmotivePanel.TABNAME, emotivePanel);
		tabbedPane.addTab(AffectivePanel.TABNAME, affectivePanel);
		tabbedPane.addTab(SkinPanel.TABNAME, skinPanel);
		tabbedPane.setBorder(new EmptyBorder(10, 10, 10, 10));
		setLayout(new BorderLayout());
		pack();
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(1300, 700);
		centerGUI(this);
		setJMenuBar(menuBar);
		add(tabbedPane, BorderLayout.CENTER);
		setResizable(true);
		setVisible(true);
	}

	/**
	 * centerGUI method setup the client window dimensions
	 * 
	 * @param frame
	 *            JFrame object on which attributes have to be setup
	 */
	private void centerGUI(JFrame frame) {
		Dimension d = Toolkit.getDefaultToolkit().getScreenSize();
		int w = frame.getSize().width;
		int h = frame.getSize().height;
		int x = (d.width - w) / 2;
		int y = (d.height - h) / 2;
		frame.setLocation(x, y);
	}

	public void setServerClientListener(ClientServerConnectionService clientServerConnectionService) {
		menuBar.setServerClientListener(clientServerConnectionService);
	}

	/**
	 * updateTime method updates stop watch timer on menubar
	 * 
	 * @param time
	 *            double value of stop watch timer
	 */
	public void updateTime(double time) {
		menuBar.updateTimeValue(time);
	}

	public void setAffectiveListener(AffectiveColorService affectiveColorService) {
		affectivePanel.setAffectiveListener(affectiveColorService);
	}

	/**
	 * getColors method extracts colors from affective tab
	 * 
	 * @return ArrayList containing colors on affective tab
	 */
	public ArrayList<Color> getColors() {
		return affectivePanel.getColors();
	}

	/**
	 * changedisplayLengthLabel method updates length of affective panel
	 *
	 */
	public void changedisplayLengthLabel() {
		affectivePanel.changedisplayLengthLabel();
	}

	/**
	 * Set connection Label.
	 * 
	 * @param flag
	 *            sets the connection label
	 */
	public void setConnectionLabel(boolean flag) {
		menuBar.setConnectionLabel(flag);
	}
}