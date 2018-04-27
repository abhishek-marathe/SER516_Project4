package client.controller;

import java.io.IOException;
import javax.swing.JOptionPane;
import javax.websocket.ClientEndpoint;
import javax.websocket.OnClose;
import javax.websocket.OnMessage;
import javax.websocket.OnOpen;
import javax.websocket.Session;
import com.google.gson.Gson;
import client.constants.ClientConstants;
import client.listener.MenuBarListener;
import client.model.AffectivePlotData;
import client.model.ClientDataSingleton;
import client.model.ExpressivePlotData;
import client.model.Data;

/**
 * The ClientSocketEndpoint class creates socket endpoint of client Takes care
 * of server client connection and data received from server
 * 
 * @author Team06
 * @version 1.0
 */
@ClientEndpoint
public class ClientSocketEndpoint {
	static WebSocketClientMain webSocketClientMain;
	static MenuBarListener clockListener;
	private static Gson gson = new Gson();
	private Data data;

	public static void setMainClientWebSocket(WebSocketClientMain webSocketClientMainVal) {
		webSocketClientMain = webSocketClientMainVal;

	}

	public static void setClockListener(MenuBarListener clockListenerObj) {
		clockListener = clockListenerObj;
	}

	@OnOpen
	public void open(Session session) {
		clockListener.setConnectionLabel(true);
	}

	/**
	 * onMessage parse the JSON formated data received from server into values
	 * 
	 * @param message
	 */
	@OnMessage
	public void onMessage(String message) {
		System.out.println("Message:: "+message);
		data = gson.fromJson(message, Data.class);
		data = gson.fromJson(message, Data.class);
		ClientDataSingleton.getInstance().setData(data);
		System.out.println("------------------------------------");
		System.out.println(ClientDataSingleton.getInstance().getData());
		ExpressivePlotData.getInstance().setDataToList(data.getFaceData().getExpressiveData());
		ClientDataSingleton.getInstance().getExpressplot().plotExpressionGraph();
		AffectivePlotData.getInstance().setDataToList(data.getFaceData().getAffectiveData(), data.getFaceData());
		ClientDataSingleton.getInstance().getAffectivePlot()
				.plotAffectiveGraph1(AffectivePlotData.getInstance().getDataset());
		ClientDataSingleton.getInstance().setFaceExpressionController(new ClientFaceController());
		String fileName = ClientDataSingleton.getInstance().getFaceExpressionController()
				.getFaceFileName(data.getFaceData().getExpressiveData());
		ClientDataSingleton.getInstance().getFaceExpressions().drawImage(fileName);
		clockListener.updateTime(data.getCounter());
	}

	/**
	 * closedConnection method ends the websocket and client server connection
	 * 
	 * @param session
	 *            : current session object
	 */
	@OnClose
	public void closedConnection(Session session) {
		ClientDataSingleton.getInstance().setSessionMaintained(false);
		clockListener.setConnectionLabel(false);
		clockListener.setConnectionLabel(false);
		try {
			session.close();
			webSocketClientMain.clientThread.interrupt();
		} catch (IOException e) {
			JOptionPane.showMessageDialog(null, ClientConstants.CLOSING_CONNECTION_EXCEPTION_MESSAGE);
		}
	}
}