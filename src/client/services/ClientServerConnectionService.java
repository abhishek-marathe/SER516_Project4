package client.services;

import javax.swing.JOptionPane;
import client.constants.ClientConstants;
import client.controller.WebSocketClientMain;
import client.listener.ConnectionListener;
import client.model.ClientConfigurationSingleton;
import client.model.ClientDataSingleton;
import server.controller.ServerApplicationController;

/**
 * The ClientServerConnectionService class provides service for client server
 * connection
 * 
 * @author Team06
 * @version 1.0
 */
public class ClientServerConnectionService implements ConnectionListener {
	WebSocketClientMain webSocketClientMain = new WebSocketClientMain();

	@Override
	public void startServer(String ip, String port) {
		establishServerClientConnection(ip, port);
	}

	/**
	 * reconnectServer method implements reconnection to the last connected server
	 * 
	 * @param url
	 *            String containing url of last connected server
	 */
	@Override
	public void reconnectServer(String url) {
		String ip = ClientConfigurationSingleton.getInstance().getIp();
		String port = ClientConfigurationSingleton.getInstance().getPort();
		if (ip == null || port == null) {
			JOptionPane.showMessageDialog(null, ClientConstants.CONNECT_TO_SERVER);
		} else {
			establishServerClientConnection(ip, port);
		}
	}

	/**
	 * initializeServer method instantiate ServerApplicationController class
	 */
	@Override
	public void initializeServer(String Port, String type) {
		new ServerApplicationController(Port, type);
	}

	/**
	 * establishServerClientConnection method sets client configuration for server
	 * client connection
	 * 
	 * @param ip
	 *            String which is User Input IP
	 * @param port
	 *            String denotes user input for port number
	 */
	private void establishServerClientConnection(String ip, String port) {
		/*if (!ClientDataSingleton.getInstance().isSessionMaintained()) {*/
			ClientConfigurationSingleton.getInstance().setIp(ip);
			ClientConfigurationSingleton.getInstance().setPort(port);
			webSocketClientMain.connectToServer(ip, port);
		/*} else {
			JOptionPane.showMessageDialog(null, ClientConstants.CLIENT_ALREADY_CONNECTED);
		}*/
	}
}