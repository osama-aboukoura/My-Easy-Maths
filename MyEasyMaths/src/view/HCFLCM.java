package view;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridLayout;
import java.util.Observable;
import java.util.Observer;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

import controller.Controller;
import model.Model;

/**
 * @author osamaaboukoura
 */
public class HCFLCM extends PanelWithBackground implements Observer {

	private Model model;
	private Controller controller;
	private JLabel hcf, lcm;
	private JTextField jtfFirstNumber, jtfSecondNumber;

	public HCFLCM(Model model, Controller controller) {

		this.model = model;
		this.controller = controller;

		// main title
		add(new TitleLabel("HCF and LCM"));

		// message below title
		add(new MessageLabel("<html>Enter two numbers to find their HCF and LCM:<br>"));

		// input panel with labels and text fields
		JPanel inputPanel = new JPanel(new GridLayout(4, 2));

		JLabel jlFirstNumber = new JLabel("Enter 1st Number:", SwingConstants.CENTER);
		jlFirstNumber.setFont(new Font("Apple Chancery", Font.PLAIN, 24));
		jlFirstNumber.setForeground(Color.RED);
		jtfFirstNumber = new JTextField();
		jtfFirstNumber.setPreferredSize(new Dimension(220, 24));

		JLabel jlSecondNumber = new JLabel("Enter 2nd Number:", SwingConstants.CENTER);
		jlSecondNumber.setFont(new Font("Apple Chancery", Font.PLAIN, 24));
		jlSecondNumber.setForeground(Color.RED);
		jtfSecondNumber = new JTextField();
		jtfSecondNumber.setPreferredSize(new Dimension(220, 24));

		inputPanel.add(new JLabel());
		inputPanel.add(new JLabel());
		inputPanel.add(jlFirstNumber);
		inputPanel.add(jtfFirstNumber);
		inputPanel.add(jlSecondNumber);
		inputPanel.add(jtfSecondNumber);
		inputPanel.add(new JLabel());
		inputPanel.add(new JLabel());
		add(inputPanel);

		// calculate button
		JButton calculate = new JButton("Calculate");
		calculate.setName("Calculate");
		calculate.addActionListener(controller);
		add(calculate);

		// output panel with labels
		JPanel outputPanel = new JPanel(new GridLayout(4, 2));

		JLabel hcfLabel = new JLabel("Highest Common Factor: ");
		JLabel lcmLabel = new JLabel("Lowest Common Multiple: ");
		hcf = new JLabel("");
		lcm = new JLabel("");
		hcf.setOpaque(true);
		lcm.setOpaque(true);
		hcf.setBackground(Color.WHITE);
		lcm.setBackground(Color.WHITE);
		hcf.setForeground(Color.RED);
		lcm.setForeground(Color.RED);
		hcf.setBorder(BorderFactory.createLineBorder(Color.LIGHT_GRAY, 3));
		lcm.setBorder(BorderFactory.createLineBorder(Color.LIGHT_GRAY, 3));
		hcfLabel.setFont(new Font("Apple Chancery", Font.PLAIN, 20));
		lcmLabel.setFont(new Font("Apple Chancery", Font.PLAIN, 20));
		hcf.setFont(new Font("Apple Chancery", Font.PLAIN, 20));
		lcm.setFont(new Font("Apple Chancery", Font.PLAIN, 20));

		outputPanel.add(new JLabel());
		outputPanel.add(new JLabel());
		outputPanel.add(hcfLabel);
		outputPanel.add(hcf);
		outputPanel.add(lcmLabel);
		outputPanel.add(lcm);
		outputPanel.add(new JLabel());
		outputPanel.add(new JLabel());
		add(outputPanel);

		// back to main button
		add(new BackToMainButton(controller));

	}

	@Override
	public void update(Observable o, Object arg) {

		if (model.getCurrentPanelIndex() == 2) {
			String[] results = model.calculate_hcf_lcm(jtfFirstNumber.getText(), jtfSecondNumber.getText());

			hcf.setText(results[0]);
			lcm.setText(results[1]);
		}

	}

}
