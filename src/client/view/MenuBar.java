package client.view;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.io.InputStream;
import javax.imageio.ImageIO;
import javax.swing.BorderFactory;
import javax.swing.Box;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPopupMenu;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.Border;

import client.constants.ClientConstants;
import client.services.ClientServerConnectionService;

/**
 * The MenuBar class handles the menu options given on main frame.
 * 
 * @author Team06
 * @version 1.0
 */
public class MenuBar extends JMenuBar implements ActionListener {

	private JMenu menu;
	private JMenuItem launchFaceServer, launchHeartServer, launchSkinServer;
	private JMenuItem connect;
	private JMenuItem stopWatch;
	private JMenuItem connectionLabel;
	private ClientServerConnectionService clientServerConnectionService;
	private BufferedImage greenIcon, redIcon;

	public MenuBar() {

		Border blackBorder = BorderFactory.createMatteBorder(5, 5, 5, 5, Color.LIGHT_GRAY);
		BufferedImage stopImage, redImage, greenImage;
		BufferedImage resizeStopImg = null;
		greenIcon = null;
		redIcon = null;
		try {
			InputStream inputStream1 = getClass().getClassLoader().getResourceAsStream(ClientConstants.CONNECTED_IMAGE);
			InputStream inputStream2 = getClass().getClassLoader()
					.getResourceAsStream(ClientConstants.NOT_CONNECTED_IMAGE);
			InputStream inputStream3 = getClass().getClassLoader()
					.getResourceAsStream(ClientConstants.STOP_WATCH_IMAGE);
			if (inputStream1 != null && inputStream2 != null && inputStream3 != null) {
				redImage = ImageIO.read(inputStream1);
				greenImage = ImageIO.read(inputStream2);
				stopImage = ImageIO.read(inputStream3);
				resizeStopImg = new BufferedImage(30, 30, BufferedImage.TYPE_INT_ARGB);
				redIcon = new BufferedImage(30, 30, BufferedImage.TYPE_INT_ARGB);
				greenIcon = new BufferedImage(30, 25, BufferedImage.TYPE_INT_ARGB);
				Graphics2D g3 = setGraphics(resizeStopImg, stopImage);
				Graphics2D g4 = setGraphics(redIcon, redImage);
				Graphics2D g5 = setGraphics(greenIcon, greenImage);
			}

		} catch (IOException e) {
			JOptionPane.showMessageDialog(null, ClientConstants.IMAGE_PATH_EXCEPTION_MESSAGE + "Hello");
		}
		stopWatch = new JMenuItem(ClientConstants.STOP_WATCH, new ImageIcon(resizeStopImg));
		connectionLabel = new JMenuItem();
		connectState(false);
		JMenu mainmenu = new JMenu("Menu");
		mainmenu.setHorizontalTextPosition(SwingConstants.CENTER);
		mainmenu.setVerticalTextPosition(SwingConstants.BOTTOM);
		mainmenu.setFont(ClientConstants.TEXT_FONT);
		mainmenu.setBackground(Color.LIGHT_GRAY);
		mainmenu.add(setMenu(new JMenu("Launch Server"),blackBorder));
		/*mainmenu.add(new JPopupMenu.Separator());*/
		/*mainmenu.add(setMenu(new JMenu(ClientConstants.CONNECT),blackBorder));
		mainmenu.add(new JPopupMenu.Separator());*/
		/*mainmenu.add(setMenu(new JMenu("Face Server"),blackBorder));
		mainmenu.add(new JPopupMenu.Separator());
		mainmenu.add(setMenu(new JMenu("Heart Server"),blackBorder));
		mainmenu.add(new JPopupMenu.Separator());
		mainmenu.add(setMenu(new JMenu("Skin Server"),blackBorder));*/
		setForegroundBackground(mainmenu, blackBorder, ClientConstants.TEXT_FONT);
		add(mainmenu);
		setForegroundBackground(stopWatch, ClientConstants.TEXT_FONT);
		add(stopWatch);
		setForegroundBackground(connectionLabel, ClientConstants.TEXT_FONT);
		add(connectionLabel);
	}

	/**
	 * connectState method changes the label and icon on menubar.
	 *
	 * @param blackBorder
	 *            : border color
	 * @param menu:
	 *            menu item to set on menubar.
	 */
	private JMenu setMenu(JMenu menu, Border blackBorder){

		menu.setHorizontalTextPosition(SwingConstants.CENTER);
		menu.setVerticalTextPosition(SwingConstants.BOTTOM);
		menu.setFont(ClientConstants.TEXT_FONT);
		menu.setBackground(Color.LIGHT_GRAY);
		launchFaceServer = new JMenuItem("Face Server");
		setForegroundBackground(launchFaceServer, blackBorder, ClientConstants.TEXT_FONT);
		launchHeartServer = new JMenuItem("Heart Server");
		setForegroundBackground(launchHeartServer, blackBorder, ClientConstants.TEXT_FONT);
		launchSkinServer = new JMenuItem("Skin Server");
		setForegroundBackground(launchSkinServer, blackBorder, ClientConstants.TEXT_FONT);

		launchFaceServer.addActionListener(this);
		launchHeartServer.addActionListener(this);
		launchSkinServer.addActionListener(this);
		setForegroundBackground(menu, blackBorder, ClientConstants.TEXT_FONT);
		menu.add(launchFaceServer);
		menu.add(new JPopupMenu.Separator());
		menu.add(launchHeartServer);
		menu.add(new JPopupMenu.Separator());
		menu.add(launchSkinServer);
		/*menu.add(connect);*/
		return  menu;
	}
	/**
	 * connectState method changes the label and icon on menubar.
	 *
	 * @param flag
	 *            : boolean connected or not connected flag
	 */
	public void connectState(boolean flag) {
		if (flag) {
			connectionLabel.setIcon(new ImageIcon(greenIcon));
			connectionLabel.setText(ClientConstants.CONNECTED);
		} else {
			connectionLabel.setIcon(new ImageIcon(redIcon));
			connectionLabel.setText(ClientConstants.NOT_CONNECTED);
		}
	}

	/**
	 * setForegroundBackground method customizes appearance of items in menubar.
	 * 
	 * @param item
	 *            : Menu item to be configured
	 * @param blackBorder
	 *            : border to set
	 * @param font
	 *            : to set font of menu item
	 */
	public void setForegroundBackground(JMenu item, Border blackBorder, Font font) {
		item.setBackground(Color.LIGHT_GRAY);
		item.setForeground(Color.BLACK);
		item.setFont(font);
		item.setBorder(blackBorder);
		item.setOpaque(true);
	}

	/**
	 * setForegroundBackground method customizes appearance of items in menubar.
	 * 
	 * @param item
	 *            : Menu item to be configured
	 * @param blackBorder
	 *            : border to set
	 * @param font
	 *            : to set font of menu item
	 */
	public void setForegroundBackground(JMenuItem item, Border blackBorder, Font font) {
		item.setBackground(Color.LIGHT_GRAY);
		item.setForeground(Color.BLACK);
		item.setBorder(blackBorder);
		item.setFont(font);
		item.setOpaque(true);
	}

	/**
	 * setForegroundBackground method customizes appearance of items in menubar.
	 *
	 * @param item
	 *            : Menu item to be configured
	 * @param font
	 *            : to set font of menu item
	 */
	public void setForegroundBackground(JMenuItem item, Font font) {
		item.setBackground(Color.LIGHT_GRAY);
		item.setForeground(Color.BLACK);
		item.setFont(font);
		item.setOpaque(true);
	}

	/**
	 * setGraphics method creates a rendered image
	 * 
	 * @param resizeImg
	 *            : resized BufferedImage to be drawn on GUI
	 * @param menuImage
	 *            : original BufferedImage which is to be drawn on
	 * @return : Graphics2D object for reference
	 */
	public Graphics2D setGraphics(BufferedImage resizeImg, BufferedImage menuImage) {
		Graphics2D g2 = resizeImg.createGraphics();
		g2.setRenderingHint(RenderingHints.KEY_INTERPOLATION, RenderingHints.VALUE_INTERPOLATION_BILINEAR);
		g2.drawImage(menuImage, 0, 0, 30, 24, null);
		g2.dispose();
		return g2;
	}

	/**
	 * actionPerformed method handles the on click event from menu.
	 *
	 * @param e
	 *            : ActionEvent performed on MenuBar
	 */
	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == launchFaceServer) {
			launchPortDialogBox("face");

		} else if (e.getSource() == launchHeartServer) {
			launchPortDialogBox("heart");
		}
		else if (e.getSource() == launchSkinServer) {
			launchPortDialogBox("skin");
		}
	}

	/**
	 * setServerClientListener method connects client server connection lister
	 * 
	 * @param clientServerConnectionService
	 *            : Client Server Connection setup
	 */
	public void setServerClientListener(ClientServerConnectionService clientServerConnectionService) {
		this.clientServerConnectionService = clientServerConnectionService;
	}

	/**
	 * launchPortDialogBox method provides a dialogue box for IP and port user inputs
	 * so that you can change port number to connect server on localhost
	 */
	private void launchPortDialogBox(String type) {
		JTextField ipField = new JTextField(15);
		JTextField ipPort = new JTextField(15);
		ipField.setText(ClientConstants.LOCALHOST);
		ipField.setEditable(false);
		ipPort.setText(ClientConstants.PORT_NUMBER);
		JPanel myPanel = new JPanel();
		myPanel.add(new JLabel(ClientConstants.IP_STRING));
		myPanel.add(ipField);
		myPanel.add(Box.createHorizontalStrut(15));
		myPanel.add(new JLabel(ClientConstants.PORT_STRING));
		myPanel.add(ipPort);
		int result = JOptionPane.showConfirmDialog(null, myPanel, ClientConstants.ENTER_IP,
				JOptionPane.OK_CANCEL_OPTION);
		if (result == JOptionPane.OK_OPTION) {
			clientServerConnectionService.initializeServer(ipPort.getText(), type);
			clientServerConnectionService.startServer(ipField.getText(), ipPort.getText());
		}
	}

	/**
	 * launchDialogBox method provides a dialogue box for IP and port user inputs
	 */
	private void launchDialogBox() {
		JTextField ipField = new JTextField(15);
		JTextField ipPort = new JTextField(15);
		ipField.setText(ClientConstants.LOCALHOST);
		ipPort.setText(ClientConstants.PORT_NUMBER);
		JPanel myPanel = new JPanel();
		myPanel.add(new JLabel(ClientConstants.IP_STRING));
		myPanel.add(ipField);
		myPanel.add(Box.createHorizontalStrut(15));
		myPanel.add(new JLabel(ClientConstants.PORT_STRING));
		myPanel.add(ipPort);
		int result = JOptionPane.showConfirmDialog(null, myPanel, ClientConstants.ENTER_IP,
				JOptionPane.OK_CANCEL_OPTION);
		if (result == JOptionPane.OK_OPTION) {
			clientServerConnectionService.startServer(ipField.getText(), ipPort.getText());
		}
	}

	/**
	 * updateTimeValue method updates stop watch timer on menubar.
	 * 
	 * @param time
	 *            : stop watch time to update
	 */
	public void updateTimeValue(double time) {
		stopWatch.setOpaque(true);
		stopWatch.setText(String.valueOf(time));
		setForegroundBackground(stopWatch, ClientConstants.TEXT_FONT);
	}

	public void setConnectionLabel(boolean flag) {
		connectState(flag);
	}
}
