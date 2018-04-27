package client.model;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * The ExpressivePlotData class sets up the plot for facial expression value
 * 
 * @author Team06
 * @version 1.0
 */
public class SkinPlotData {

	private static volatile SkinPlotData skinPlotData;
	private ArrayList<Float> fairlist = new ArrayList<>(Arrays.asList(0.0f));
	private ArrayList<Float> darklist = new ArrayList<>(Arrays.asList(0.0f));
	private ArrayList<Float> pinklist = new ArrayList<>(Arrays.asList(0.0f));
	private ArrayList<Float> goldenlist = new ArrayList<>(Arrays.asList(0.0f));

	private ArrayList<Float> normallist = new ArrayList<>(Arrays.asList(0.0f));
	private ArrayList<Float> drylist = new ArrayList<>(Arrays.asList(0.0f));
	private ArrayList<Float> oilylist = new ArrayList<>(Arrays.asList(0.0f));

	public ArrayList<Float> getFairlist() {
		return fairlist;
	}

	public ArrayList<Float> getDarklist() {
		return darklist;
	}

	public ArrayList<Float> getPinklist() {
		return pinklist;
	}

	public ArrayList<Float> getGoldenlist() {
		return goldenlist;
	}

	public ArrayList<Float> getNormallist() {
		return normallist;
	}

	public ArrayList<Float> getDrylist() {
		return drylist;
	}

	public ArrayList<Float> getOilylist() {
		return oilylist;
	}

	public ArrayList<Float> getCombinationlist() {
		return combinationlist;
	}

	private ArrayList<Float> combinationlist = new ArrayList<>(Arrays.asList(0.0f));


	private static Object mutex = new Object();
	private ArrayList<Float> raiseBrowList = new ArrayList<>(Arrays.asList(0.0f));
	private ArrayList<Float> furrowBrowList = new ArrayList<>(Arrays.asList(0.0f));
	private ArrayList<Float> smileList = new ArrayList<>(Arrays.asList(0.0f));
	private ArrayList<Float> clenchList = new ArrayList<>(Arrays.asList(0.0f));
	private ArrayList<Float> smirkLeftList = new ArrayList<>(Arrays.asList(0.0f));
	private ArrayList<Float> smirkRightList = new ArrayList<>(Arrays.asList(0.0f));
	private ArrayList<Float> laughList = new ArrayList<>(Arrays.asList(0.0f));
	private ArrayList<Float> winkLeftList = new ArrayList<>(Arrays.asList(0.0f));
	private ArrayList<Float> winkRightList = new ArrayList<>(Arrays.asList(0.0f));
	private ArrayList<Float> lookLeftList = new ArrayList<>(Arrays.asList(0.0f));
	private ArrayList<Float> lookRightList = new ArrayList<>(Arrays.asList(0.0f));
	private ArrayList<Float> blinkList = new ArrayList<>();
	private boolean featureVal;

	public static SkinPlotData getExpressivePlotData() {
		return skinPlotData;
	}

	/**
	 * returns instance of class
	 * 
	 * @return
	 */
	public static SkinPlotData getInstance() {
		SkinPlotData result = skinPlotData;
		if (result == null) {
			synchronized (mutex) {
				result = skinPlotData;
				if (result == null) {
					result = new SkinPlotData();
				}
				skinPlotData = result;
			}
		}
		return result;
	}

	public ArrayList<Float> getRaiseBrowList() {
		return raiseBrowList;
	}

	public ArrayList<Float> getFurrowBrowList() {
		return furrowBrowList;
	}

	public ArrayList<Float> getSmileList() {
		return smileList;
	}

	public ArrayList<Float> getClenchList() {
		return clenchList;
	}

	public ArrayList<Float> getSmirkLeftList() {
		return smirkLeftList;
	}

	public ArrayList<Float> getSmirkRightList() {
		return smirkRightList;
	}

	public ArrayList<Float> getLaughList() {
		return laughList;
	}

	public ArrayList<Float> getWinkLeftList() {
		return winkLeftList;
	}

	public ArrayList<Float> getWinkRightList() {
		return winkRightList;
	}

	public ArrayList<Float> getLookLeftList() {
		return lookLeftList;
	}

	public ArrayList<Float> getLookRightList() {
		return lookRightList;
	}

	public ArrayList<Float> getBlinkList() {
		return blinkList;
	}

	/**
	 * setDataToList sets data received from server to its category
	 * 
	 * @param expressivedata
	 *            : data received from server
	 */
	public void setDataToList(ExpressiveData expressivedata) {

		raiseBrowList.add(expressivedata.getRaiseBrow());
		furrowBrowList.add(expressivedata.getFurrowBrow());
		smileList.add(expressivedata.getSmile());
		clenchList.add(expressivedata.getClench());
		smirkLeftList.add(expressivedata.getSmirkLeft());
		smirkRightList.add(expressivedata.getSmirkRight());
		laughList.add(expressivedata.getLaugh());
		this.featureVal = expressivedata.isBlink();
		blinkList.add(featureVal ? 1.0F : 0.0F);
		this.featureVal = expressivedata.isLookLeft();
		lookLeftList.add(featureVal ? 1.0F : 0.0F);
		this.featureVal = expressivedata.isLookRight();
		lookRightList.add(featureVal ? 1.0F : 0.0F);
		this.featureVal = expressivedata.isWinkLeft();
		winkLeftList.add(featureVal ? 1.0F : 0.0F);
		this.featureVal = expressivedata.isWinkRight();
		winkRightList.add(featureVal ? 1.0F : 0.0F);
	}
}