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
 *
 */
public class SimultaneousEquations extends PanelWithBackground implements Observer {

	private Model model;
	private Controller controller;
	private JTextField a, b, c, m, n, p;
	private JLabel solution;

	public SimultaneousEquations(Model model, Controller controller) {

		this.model = model;
		this.controller = controller;

		// main title
		add(new TitleLabel("Simultaneous Equations"));

		// message below title
		add(new MessageLabel(
				"<html>Enter the constants of the following simultaneous<br>equations and I will solve the equations for you:<br>"));

		// adding the equation image
		JPanel imagePanel = new JPanel();
		imagePanel.setPreferredSize(new Dimension(450, 113));
		BufferedImage picture = null;
		try {
			picture = ImageIO.read(new File("src/images/simultaneous.png"));
		} catch (IOException e) {
			e.printStackTrace();
		}
		JLabel picLabel = new JLabel(new ImageIcon(picture));
		imagePanel.add(picLabel);
		add(imagePanel);

		JLabel firstEquation = new JLabel("Equation 1 :");
		firstEquation.setFont(new Font("Apple Chancery", Font.PLAIN, 24));
		// firstEquation.setPreferredSize(new Dimension(500, 40));
		add(firstEquation);

		JPanel inputFirstPanel = new JPanel(new GridLayout(1, 6));
		inputFirstPanel.setPreferredSize(new Dimension(300, 40));
		JLabel aLabel = new JLabel("a = ", SwingConstants.CENTER);
		JLabel bLabel = new JLabel("b = ", SwingConstants.CENTER);
		JLabel cLabel = new JLabel("c = ", SwingConstants.CENTER);
		aLabel.setFont(new Font("Apple Chancery", Font.PLAIN, 22));
		bLabel.setFont(new Font("Apple Chancery", Font.PLAIN, 22));
		cLabel.setFont(new Font("Apple Chancery", Font.PLAIN, 22));
		aLabel.setForeground(Color.RED);
		bLabel.setForeground(Color.RED);
		cLabel.setForeground(Color.RED);
		a = new JTextField();
		b = new JTextField();
		c = new JTextField();
		inputFirstPanel.add(aLabel);
		inputFirstPanel.add(a);
		inputFirstPanel.add(bLabel);
		inputFirstPanel.add(b);
		inputFirstPanel.add(cLabel);
		inputFirstPanel.add(c);
		add(inputFirstPanel);

		JLabel secondEquation = new JLabel("Equation 2 :");
		secondEquation.setFont(new Font("Apple Chancery", Font.PLAIN, 24));
		// secondEquation.setPreferredSize(new Dimension(500, 40));
		add(secondEquation);

		JPanel inputSecondPanel = new JPanel(new GridLayout(1, 6));
		inputSecondPanel.setPreferredSize(new Dimension(300, 40));
		JLabel mLabel = new JLabel("m = ", SwingConstants.CENTER);
		JLabel nLabel = new JLabel("n = ", SwingConstants.CENTER);
		JLabel pLabel = new JLabel("p = ", SwingConstants.CENTER);
		mLabel.setFont(new Font("Apple Chancery", Font.PLAIN, 22));
		nLabel.setFont(new Font("Apple Chancery", Font.PLAIN, 22));
		pLabel.setFont(new Font("Apple Chancery", Font.PLAIN, 22));
		mLabel.setForeground(Color.RED);
		nLabel.setForeground(Color.RED);
		pLabel.setForeground(Color.RED);
		m = new JTextField();
		n = new JTextField();
		p = new JTextField();
		inputSecondPanel.add(mLabel);
		inputSecondPanel.add(m);
		inputSecondPanel.add(nLabel);
		inputSecondPanel.add(n);
		inputSecondPanel.add(pLabel);
		inputSecondPanel.add(p);
		add(inputSecondPanel);

		// calculate button
		JPanel buttonPanel = new JPanel();
		buttonPanel.setPreferredSize(new Dimension(500, 40));
		buttonPanel.setBackground(new Color(0, 0, 0, 0));
		JButton calculate = new JButton("Calculate");
		calculate.setName("Calculate");
		calculate.addActionListener(controller);
		buttonPanel.add(calculate);
		add(buttonPanel);

		JPanel solutionPanel = new JPanel(new GridLayout(2, 1));
		JLabel solutionLabel = new JLabel("Solution:");
		solution = new JLabel("");
		solutionLabel.setFont(new Font("Apple Chancery", Font.PLAIN, 24));
		solution.setFont(new Font("Apple Chancery", Font.PLAIN, 24));
		solution.setForeground(Color.RED);
		solutionPanel.setPreferredSize(new Dimension(500, 100));
		solutionPanel.add(solutionLabel);
		solutionPanel.add(solution);
		add(solutionPanel);

		// back to main button
		add(new BackToMainButton(controller));

	}

	@Override
	public void update(Observable o, Object arg) {

		if (model.getCurrentPanelIndex() == 7) {

			String s = model.calculate_Simultaneous_Equations(a.getText(), b.getText(), c.getText(), m.getText(),
					n.getText(), p.getText());

			solution.setText(s);

		}
	}

}
