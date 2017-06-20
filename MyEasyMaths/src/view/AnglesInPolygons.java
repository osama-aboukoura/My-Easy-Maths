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
public class AnglesInPolygons extends PanelWithBackground implements Observer {

	private Model model;
	private Controller controller;
	private JLabel answer;
	private JTextField N;
	private BufferedImage picture = null;
	private JLabel picLabel;
	private JPanel imageAndText;

	public AnglesInPolygons(Model model, Controller controller) {

		this.model = model;
		this.controller = controller;

		// main title
		add(new TitleLabel("Angles In Polygons"));

		// message below title
		add(new MessageLabel(
				"<html>Enter the number of sides of any shape <br>and I will show you the regular polygon:<br>"));

		// user's input panel with label and text field
		JPanel inputPanel = new JPanel(new GridLayout(1, 2));
		JLabel NLabel = new JLabel("The number of sides N = ", SwingConstants.CENTER);
		NLabel.setFont(new Font("Apple Chancery", Font.PLAIN, 24));
		NLabel.setForeground(Color.RED);
		N = new JTextField("0");
		inputPanel.add(NLabel);
		inputPanel.add(N);
		add(inputPanel);

		// calculate button
		JPanel buttonPanel = new JPanel();
		buttonPanel.setPreferredSize(new Dimension(500, 40));
		buttonPanel.setBackground(new Color(0, 0, 0, 0));
		JButton calculate = new JButton("Calculate");
		calculate.setName("Calculate");
		calculate.addActionListener(controller);
		buttonPanel.add(calculate);
		add(buttonPanel);

		// output panel with label and image
		imageAndText = new JPanel(new GridLayout(1, 2));
		imageAndText.setBackground(new Color(0, 0, 0, 0));
		answer = new JLabel("", SwingConstants.CENTER);
		answer.setFont(new Font("Apple Chancery", Font.PLAIN, 18));
		answer.setForeground(Color.RED);
		imageAndText.add(answer);

		// adding the polygon image
		try {
			picture = ImageIO.read(new File("src/images/11.png"));
		} catch (IOException e) {
			e.printStackTrace();
		}
		JLabel picLabel = new JLabel(new ImageIcon(picture));
		imageAndText.add(picLabel);

		add(imageAndText);

		// back to main button
		add(new BackToMainButton(controller));

	}

	@Override
	public void update(Observable o, Object arg) {

		if (model.getCurrentPanelIndex() == 4) {
			answer.setText(model.calculate_angles_in_polygon(N.getText()));

			// applying the correct image
			try {
				if (Integer.parseInt(N.getText()) >= 3 && Integer.parseInt(N.getText()) <= 11) {
					try {
						picture = ImageIO.read(new File("src/images/" + N.getText() + ".png"));
					} catch (IOException e) {
						System.out.println("error image not found");
					}
				} else {
					try {
						picture = ImageIO.read(new File("src/images/11.png"));
					} catch (IOException e) {
						System.out.println("Error! Image not found");
					}
				}
			} catch (NumberFormatException ex) {

			}

			// removing everything inside the panel and creating and adding the
			// new image and answer
			picLabel = new JLabel(new ImageIcon(picture));
			imageAndText.removeAll();
			imageAndText.add(answer);
			imageAndText.add(picLabel);
		}
	}

}
