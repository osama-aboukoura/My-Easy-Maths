package view;

import java.awt.Graphics;
import java.awt.Image;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.JPanel;

/**
 * provides a background for every panel in the program
 * 
 * @author Osama Aboukoura
 */
public class PanelWithBackground extends JPanel {

	private Image backgroundImage;

	public PanelWithBackground() {
		try {
			backgroundImage = ImageIO.read(new File("src/images/background.png"));
		} catch (IOException e) {
			System.out.println("Error! Background image not found!");
		}
	}

	protected void paintComponent(Graphics g) {
		super.paintComponent(g);
		g.drawImage(backgroundImage, 0, 0, this);
	}
}