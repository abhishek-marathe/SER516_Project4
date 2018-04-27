package client.controller;

import client.constants.ClientConstants;
import client.model.ExpressiveData;

/**
 * The ClientFaceController class maps expression image to the value received
 * from server
 * 
 * @author Team06
 * @version 1.0
 */
public class ClientFaceController {

	/**
	 * getFaceFileName depending on the expression values gives the filename of
	 * image
	 * 
	 * @param expressivedata
	 *            : Data received from server
	 * @return : String containing name of image file with expression related to
	 *         given expression
	 */
	public String getFaceFileName(ExpressiveData expressivedata) {
		StringBuilder fileName = new StringBuilder();
		fileName.append(expressivedata.getRaiseBrow() < 0.5 ? ClientConstants.ON_VALUE : ClientConstants.OFF_VALUE);
		fileName.append(expressivedata.getFurrowBrow() < 0.5 ? ClientConstants.ON_VALUE : ClientConstants.OFF_VALUE);
		fileName.append(expressivedata.getSmile() < 0.5 ? ClientConstants.ON_VALUE : ClientConstants.OFF_VALUE);
		fileName.append(expressivedata.getClench() < 0.5 ? ClientConstants.ON_VALUE : ClientConstants.OFF_VALUE);
		fileName.append(expressivedata.getSmirkLeft() < 0.5 ? ClientConstants.ON_VALUE : ClientConstants.OFF_VALUE);
		fileName.append(expressivedata.getSmirkRight() < 0.5 ? ClientConstants.ON_VALUE : ClientConstants.OFF_VALUE);
		fileName.append(expressivedata.getLaugh() < 0.5 ? ClientConstants.ON_VALUE : ClientConstants.OFF_VALUE);
		fileName.append(expressivedata.isBlink() ? ClientConstants.OFF_VALUE : ClientConstants.ON_VALUE);
		fileName.append(expressivedata.isWinkLeft() ? ClientConstants.OFF_VALUE : ClientConstants.ON_VALUE);
		fileName.append(expressivedata.isWinkRight() ? ClientConstants.OFF_VALUE : ClientConstants.ON_VALUE);
		fileName.append(expressivedata.isLookLeft() ? ClientConstants.OFF_VALUE : ClientConstants.ON_VALUE);
		fileName.append(expressivedata.isLookRight() ? ClientConstants.OFF_VALUE : ClientConstants.ON_VALUE);
		fileName.append(ClientConstants.PNG);
		return fileName.toString();
	}
}