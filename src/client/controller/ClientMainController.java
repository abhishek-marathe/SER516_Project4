package client.controller;

import client.model.ClientDataSingleton;
import client.listener.MenuBarListener;
import client.services.AffectiveColorService;
import client.services.ClientServerConnectionService;
import client.view.ClientFrame;

/**
 * The ClientMainController class handles web socket connection between the
 * client and the server.
 * 
 * @author Team06
 * @version 1.0
 */
public class ClientMainController {

	/**
	 * Starting point of client
	 * 
	 * @param args
	 */
	public static void main(String args[]) {
		ClientDataSingleton.getInstance();
		ClientFrame clientWindow = new ClientFrame();
		setClientServerConnection(clientWindow);
		setClockListener(clientWindow);
		setAffectiveListener(clientWindow);
	}

	/**
	 * setAffectiveListener configures the value listener for affective class
	 * 
	 * @param clientWindow
	 *            : instance of Client window GUI
	 */
	private static void setAffectiveListener(ClientFrame clientWindow) {
		clientWindow.setAffectiveListener(new AffectiveColorService(clientWindow));

	}

	/**
	 * setClockListener setup stopwatch value @ param clientWindow : instance of
	 * Client window GUI
	 */
	private static void setClockListener(ClientFrame clientWindow) {
		ClientSocketEndpoint.setClockListener(new MenuBarListener() {
			@Override
			public void updateTime(double time) {
				clientWindow.updateTime(time);
			}

			@Override
			public void setConnectionLabel(boolean flag) {
				clientWindow.setConnectionLabel(flag);
			}
		});
	}

	/**
	 * setClientServerConnection instanciates client server connection class @ param
	 * clientWindow : ClientFrame instance of Client GUI
	 */
	private static void setClientServerConnection(ClientFrame clientWindow) {
		clientWindow.setServerClientListener(new ClientServerConnectionService());
	}
}