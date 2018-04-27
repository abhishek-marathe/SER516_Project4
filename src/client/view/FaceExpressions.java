package client.view;

import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.io.InputStream;

import javax.imageio.ImageIO;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

import client.constants.ClientConstants;

/**
 * The FaceExpressions class
 * 
 * @author Team06
 * @version 1.0
 */
public class FaceExpressions extends JPanel {

	private BufferedImage image;

	public FaceExpressions() {

		String fileName = "000000000000.png";
		setBackground(ClientConstants.GREY);

		try {
			InputStream inputStream1 = getClass().getClassLoader().getResourceAsStream(fileName);
			if (inputStream1 != null) {
				image = ImageIO.read(inputStream1);
			}

		} catch (IOException e) {
			JOptionPane.showMessageDialog(null, ClientConstants.IMAGE_PATH_EXCEPTION_MESSAGE + "Hello");
		}

	}

	public BufferedImage getImage() {
		return image;
	}

	public void setImage(BufferedImage image) {
		this.image = image;
	}

	/**
	 * painComponent method configures the Panel
	 * 
	 * @param g
	 *            Graphics to be configured
	 */
	@Override
	protected void paintComponent(Graphics g) {
		setBackground(ClientConstants.GREY);
		super.paintComponent(g);
		g.drawImage(image, 0, 0, 250, 350, this);
	}

	/**
	 * drawImage method sets image on the faceExpression panel
	 * 
	 * @param fileName
	 *            String name of file containing image
	 */
	public void drawImage(String fileName) {
		BufferedImage image;

		try {
			InputStream inputStream1 = getClass().getClassLoader().getResourceAsStream(fileName);
			if (inputStream1 != null) {
				image = ImageIO.read(inputStream1);
				this.setImage(image);
				this.removeAll();
				this.repaint();
				this.revalidate();
			}

		} catch (IOException e) {
			JOptionPane.showMessageDialog(null, ClientConstants.IMAGE_PATH_EXCEPTION_MESSAGE + "Hello");
		}

	}
}