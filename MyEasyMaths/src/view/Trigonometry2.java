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
public class Trigonometry2 extends PanelWithBackground implements Observer {

	private Model model;
	private Controller controller;
	private JLabel solution;
	private JTextField a, b, c, A, B, C;
	private JLabel a_answer, b_answer, c_answer, A_answer, B_answer, C_answer, areaAnswer;

	public Trigonometry2(Model model, Controller controller) {

		this.model = model;
		this.controller = controller;

		// main title
		add(new TitleLabel("Trigonometry"));

		// message below title
		add(new MessageLabel("<html>Give an input of 2 angles and 1 side that is inbetween<br>the 2 angles and I will solve the triangle:<br><br>"));

		JPanel inputPanel = new JPanel(new GridLayout(3, 2));
		JLabel cLabel = new JLabel("Side c = ", SwingConstants.CENTER);
		JLabel ALabel = new JLabel("Angle A = ", SwingConstants.CENTER);
		JLabel BLabel = new JLabel("Angle B = ", SwingConstants.CENTER);
		cLabel.setFont(new Font("Apple Chancery", Font.PLAIN, 22));
		ALabel.setFont(new Font("Apple Chancery", Font.PLAIN, 22));
		BLabel.setFont(new Font("Apple Chancery", Font.PLAIN, 22));
		cLabel.setForeground(Color.RED);
		ALabel.setForeground(Color.RED);
		BLabel.setForeground(Color.RED);

		c = new JTextField();
		A = new JTextField();
		B = new JTextField();

		inputPanel.add(cLabel);
		inputPanel.add(c);
		inputPanel.add(ALabel);
		inputPanel.add(A);
		inputPanel.add(BLabel);
		inputPanel.add(B);
		add(inputPanel);

		// adding the triangle image
		BufferedImage picture = null;
		try {
			picture = ImageIO.read(new File("src/images/triangle2.png"));
		} catch (IOException e) {
			e.printStackTrace();
		}
		JLabel picLabel = new JLabel(new ImageIcon(picture));
		add(picLabel);

		// calculate button
		JPanel buttonPanel = new JPanel();
		buttonPanel.setPreferredSize(new Dimension(500, 40));
		buttonPanel.setBackground(new Color(0, 0, 0, 0));
		JButton calculate = new JButton("Calculate");
		calculate.setName("Calculate");
		calculate.addActionListener(controller);
		buttonPanel.add(calculate);
		add(buttonPanel);

		JPanel answersLeftPanel = new JPanel(new GridLayout(3, 1));
		answersLeftPanel.setPreferredSize(new Dimension(150, 100));
		JLabel sides = new JLabel("Sides (a, b, c):");
		JLabel angles = new JLabel("Angles (A, B, C):");
		JLabel area = new JLabel("Area of Triangle:");
		sides.setFont(new Font("Apple Chancery", Font.PLAIN, 18));
		angles.setFont(new Font("Apple Chancery", Font.PLAIN, 18));
		area.setFont(new Font("Apple Chancery", Font.PLAIN, 18));
		sides.setForeground(Color.RED);
		angles.setForeground(Color.RED);
		area.setForeground(Color.RED);

		answersLeftPanel.add(sides);
		answersLeftPanel.add(angles);
		answersLeftPanel.add(area);

		add(answersLeftPanel);

		JPanel answersRightPanel = new JPanel(new GridLayout(3, 1));
		answersRightPanel.setPreferredSize(new Dimension(300, 100));

		JPanel answersSides = new JPanel(new GridLayout(1, 6));
		JPanel answersAngles = new JPanel(new GridLayout(1, 6));

		JLabel a_ = new JLabel(" a = ");
		JLabel b_ = new JLabel(" b = ");
		JLabel c_ = new JLabel(" c = ");
		JLabel A_ = new JLabel(" A = ");
		JLabel B_ = new JLabel(" B = ");
		JLabel C_ = new JLabel(" C = ");
		a_answer = new JLabel("");
		b_answer = new JLabel("");
		c_answer = new JLabel("");
		A_answer = new JLabel("");
		B_answer = new JLabel("");
		C_answer = new JLabel("");
		a_.setFont(new Font("Apple Chancery", Font.PLAIN, 18));
		b_.setFont(new Font("Apple Chancery", Font.PLAIN, 18));
		c_.setFont(new Font("Apple Chancery", Font.PLAIN, 18));
		A_.setFont(new Font("Apple Chancery", Font.PLAIN, 18));
		B_.setFont(new Font("Apple Chancery", Font.PLAIN, 18));
		C_.setFont(new Font("Apple Chancery", Font.PLAIN, 18));

		areaAnswer = new JLabel("123");
		areaAnswer.setFont(new Font("Apple Chancery", Font.PLAIN, 18));

		answersSides.add(a_);
		answersSides.add(a_answer);
		answersSides.add(b_);
		answersSides.add(b_answer);
		answersSides.add(c_);
		answersSides.add(c_answer);

		answersAngles.add(A_);
		answersAngles.add(A_answer);
		answersAngles.add(B_);
		answersAngles.add(B_answer);
		answersAngles.add(C_);
		answersAngles.add(C_answer);

		answersRightPanel.add(answersSides);
		answersRightPanel.add(answersAngles);
		answersRightPanel.add(areaAnswer);
		add(answersRightPanel);

		// back to the Triangles button
		add(new BackToTriangles(controller));

	}

	@Override
	public void update(Observable o, Object arg) {
		if (model.getCurrentPanelIndex() == 12) {

			String angleC = model.angles_add_up_to_180(A.getText(), B.getText());
			String side_a = model.sine_law_to_find_side(A.getText(), angleC, c.getText());
			String side_b = model.sine_law_to_find_side(B.getText(), angleC, c.getText());

			String DegreeSign = "\u00b0";

			a_answer.setText(side_a);
			b_answer.setText(side_b);
			c_answer.setText(c.getText());
			A_answer.setText(A.getText() + DegreeSign);
			B_answer.setText(B.getText() + DegreeSign);
			C_answer.setText(angleC + DegreeSign);

			String area = model.getTriangleArea(side_a, c.getText(), B.getText());

			areaAnswer.setText(area);

		}
	}

}
