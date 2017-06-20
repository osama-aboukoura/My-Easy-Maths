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
import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.Border;

import controller.Controller;
import model.Model;

/**
 * @author Osama Aboukoura
 */
public class Trigonometry extends PanelWithBackground implements Observer {

	private Model model;
	private Controller controller;
	private JLabel solution;
	private JTextField a, b, c, A, B, C;

	public Trigonometry(Model model, Controller controller) {

		this.model = model;
		this.controller = controller;

		// main title
		add(new TitleLabel("Trigonometry"));

		// message below title
		add(new MessageLabel(
				"<html>There are 6 types of triangles that could be solved.<br>Select one trianlge to get started:<br>"));

		JPanel buttonsPanel = new JPanel(new GridLayout(3, 2));
		JScrollPane scrollFrame = new JScrollPane(buttonsPanel);

		JButton button1 = new JButton(new ImageIcon("src/images/triangle1.png"));
		JButton button2 = new JButton(new ImageIcon("src/images/triangle2.png"));
		JButton button3 = new JButton(new ImageIcon("src/images/triangle3.png"));
		JButton button4 = new JButton(new ImageIcon("src/images/triangle4.png"));
		JButton button5 = new JButton(new ImageIcon("src/images/triangle5.png"));
		JButton button6 = new JButton(new ImageIcon("src/images/triangle6.png"));

		button1.setName("triangle1");
		button2.setName("triangle2");
		button3.setName("triangle3");
		button4.setName("triangle4");
		button5.setName("triangle5");
		button6.setName("triangle6");

		button1.addActionListener(controller);
		button2.addActionListener(controller);
		button3.addActionListener(controller);
		button4.addActionListener(controller);
		button5.addActionListener(controller);
		button6.addActionListener(controller);

		Border empty = BorderFactory.createEmptyBorder();
		button1.setBorder(empty);
		button2.setBorder(empty);
		button3.setBorder(empty);
		button4.setBorder(empty);
		button5.setBorder(empty);
		button6.setBorder(empty);

		buttonsPanel.add(button1);
		buttonsPanel.add(button2);
		buttonsPanel.add(button3);
		buttonsPanel.add(button4);
		buttonsPanel.add(button5);
		buttonsPanel.add(button6);

		scrollFrame.setAutoscrolls(true);
		scrollFrame.setPreferredSize(new Dimension(500, 350));
		this.add(scrollFrame);
		add(scrollFrame);

		// back to main button
		add(new BackToMainButton(controller));

	}

	@Override
	public void update(Observable o, Object arg) {

		if (model.getCurrentPanelIndex() == 5) {

		}
	}

}
