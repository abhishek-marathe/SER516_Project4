package server.controller;

import server.model.Data;
import server.model.FaceData;
import server.model.ServerModelSingleton;
import server.services.DetectionListenerService;
import server.services.InteractiveListenerService;
import server.services.ServerSocketService;
import server.view.ServerView;

/**
 * The ServerApplicationController class sets singleton face data, connection
 * and listener services for the server.
 * 
 * @author Team 06
 * @version 1.0
 */
public class ServerApplicationController {

	/**
	 * Inject dependency of view model and services
	 */
	public ServerApplicationController(String Port, String type) {
		ServerView serverView = new ServerView(type);
		ServerModelSingleton serverDataSingleton = ServerModelSingleton.getInstance();
		serverDataSingleton.setData(new Data());
		ServerSocketService serverSocketService = new ServerSocketService(Port);
		InteractiveListenerService interactiveListenerService = new InteractiveListenerService();
		DetectionListenerService detectionListenerService = new DetectionListenerService();
		new ServerMainController(serverView, serverDataSingleton, serverSocketService, interactiveListenerService,
				detectionListenerService);
	}
}