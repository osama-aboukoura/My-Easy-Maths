package view;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridLayout;
import java.util.Observable;
import java.util.Observer;

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
public class PrimeNumbers extends PanelWithBackground implements Observer {

	private Model model;
	private Controller controller;
	private JTextField N;
	private JLabel solution;

	public PrimeNumbers(Model model, Controller controller) {

		this.model = model;
		this.controller = controller;

		// main title
		add(new TitleLabel("Prime Numbers"));

		// message below title
		add(new MessageLabel("<html><center>Enter a positive number to find out<br>whether it's prime or not:<br>"));

		// input panel with label and text field
		JPanel inputPanel = new JPanel(new GridLayout(1, 2));
		inputPanel.setPreferredSize(new Dimension(300, 40));
		JLabel aLabel = new JLabel("Number = ", SwingConstants.CENTER);
		aLabel.setFont(new Font("Apple Chancery", Font.PLAIN, 22));
		aLabel.setForeground(Color.RED);
		N = new JTextField("0");
		inputPanel.add(aLabel);
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

		// output panel with label
		JPanel outputPanel = new JPanel(new BorderLayout());
		solution = new JLabel("<html>");
		solution.setFont(new Font("Apple Chancery", Font.PLAIN, 24));
		solution.setForeground(Color.RED);
		outputPanel.setPreferredSize(new Dimension(500, 200));
		outputPanel.add(solution);
		add(outputPanel);

		// back to main button
		add(new BackToMainButton(controller));

	}

	@Override
	public void update(Observable o, Object arg) {
		if (model.getCurrentPanelIndex() == 8) {
			solution.setText("<html>" + model.getPrime(N.getText()));
		}
	}
}
