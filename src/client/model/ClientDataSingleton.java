package client.model;

import client.controller.ClientFaceController;
import client.view.AffectivePlot;
import client.view.ExpressionPlots;
import client.view.FaceExpressions;

/**
 * The ClientDataSingleton class holds data received from server Also, act as a
 * single point of contact for all the data needs on client.
 * 
 * @author Team06
 * @version 1.0
 */
public class ClientDataSingleton {
	private static volatile ClientDataSingleton clientDataSingleton;
	private static Object mutex = new Object();
	boolean sessionMaintained = false;
	private Data data;
	private FaceData faceData;
	private SkinData skinData;
	private HeartData heartData;
	private ExpressionPlots expressplot;
	private AffectivePlot affectivePlot;
	private ClientFaceController faceExpressionController;
	private FaceExpressions faceExpressions;

	public static ClientDataSingleton getInstance() {
		ClientDataSingleton result = clientDataSingleton;
		if (result == null) {
			synchronized (mutex) {
				result = clientDataSingleton;
				if (result == null) {
					result = new ClientDataSingleton();
				}
				clientDataSingleton = result;
			}
		}
		return result;
	}

	public Data getData() {
		return data;
	}

	public void setData(Data data) {
		this.data = data;
	}

	public boolean isSessionMaintained() {
		return sessionMaintained;
	}

	public void setSessionMaintained(boolean sessionMaintained) {
		this.sessionMaintained = sessionMaintained;
	}


	public HeartData getHeartData() {
		return heartData;
	}

	public void setHeartData(HeartData heartData) {
		this.heartData = heartData;
	}

	public SkinData getSkinData() {
		return skinData;
	}

	public void setSkinData(SkinData skinData) {
		this.skinData = skinData;
	}

	public FaceData getFaceData() {
		return faceData;
	}

	public void setFaceData(FaceData faceData) {
		this.faceData = faceData;
	}

	public FaceExpressions getFaceExpressions() {
		return faceExpressions;
	}

	public void setFaceExpressions(FaceExpressions faceExpressions) {
		this.faceExpressions = faceExpressions;
	}

	public ClientFaceController getFaceExpressionController() {
		return faceExpressionController;
	}

	public void setFaceExpressionController(ClientFaceController faceExpressionController) {
		this.faceExpressionController = faceExpressionController;
	}

	public ExpressionPlots getExpressplot() {
		return expressplot;
	}

	public void setExpressplot(ExpressionPlots expressplot) {
		this.expressplot = expressplot;
	}

	public AffectivePlot getAffectivePlot() {
		return affectivePlot;
	}

	public void setAffectivePlot(AffectivePlot affectivePlot) {
		this.affectivePlot = affectivePlot;
	}
}