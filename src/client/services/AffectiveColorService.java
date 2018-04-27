package client.services;

import java.awt.Color;
import java.util.ArrayList;
import client.listener.AffectiveColorListener;
import client.model.AffectivePlotData;
import client.view.ClientFrame;

/**
 * The AffectiveColorService class provides service of color matrix to the
 * affective panel
 * 
 * @author Team06
 * @version 1.0
 */
public class AffectiveColorService implements AffectiveColorListener {

	private ClientFrame clientWindow;

	public AffectiveColorService(ClientFrame clientWindow) {
		this.clientWindow = clientWindow;
	}

	/**
	 * setColor abstract method from AffectiveColorListener Interface
	 */
	@Override
	public void setColor() {

	}

	/**
	 * getColors method gets color array from clientwindow
	 * 
	 * @return arraylist containing Colors of each matrix
	 */
	@Override
	public ArrayList<Color> getColors() {
		return clientWindow.getColors();
	}

	/**
	 * changedisplayLengthLabel method changes label on clientWindow
	 * 
	 * @param text
	 *            : string to set on client window
	 */
	@Override
	public void changedisplayLengthLabel(String text) {
		try {
			AffectivePlotData.getInstance().setGraphLength(Integer.parseInt(text));
			clientWindow.changedisplayLengthLabel();
		} catch (Exception e) {
		}
	}
}