package view;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.Observable;
import java.util.Observer;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

import controller.Controller;
import model.Model;

/**
 * @author Osama Aboukoura
 */
public class Trigonometry6 extends PanelWithBackground implements Observer {

	private Model model;
	private Controller controller;

	public Trigonometry6(Model model, Controller controller) {

		this.model = model;
		this.controller = controller;

		// main title
		add(new TitleLabel("Trigonometry"));

		// message below title
		add(new MessageLabel(
				"<html><center>For a triangle with 3 valid angles that add up<br>to 180, there's always infinite number of triangles<br>that could be formed of these angles.<br><br>"));

		// adding the triangle image
		BufferedImage picture = null;
		try {
			picture = ImageIO.read(new File("src/images/triangle6.png"));
		} catch (IOException e) {
			e.printStackTrace();
		}
		JLabel picLabel = new JLabel(new ImageIcon(picture));
		add(picLabel);

		// back to the Triangles button
		JPanel buttonPanel = new JPanel();
		buttonPanel.setPreferredSize(new Dimension(500, 40));
		buttonPanel.setBackground(new Color(0, 0, 0, 0));
		buttonPanel.add(new BackToTriangles(controller));
		add(buttonPanel);

	}

	@Override
	public void update(Observable o, Object arg) {
		// TODO Auto-generated method stub

	}

}
