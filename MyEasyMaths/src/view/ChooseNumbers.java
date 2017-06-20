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
public class ChooseNumbers extends PanelWithBackground implements Observer {

	private Model model;
	private Controller controller;
	private JTextField n, k;
	private JLabel answerLabel;

	public ChooseNumbers(Model model, Controller controller) {

		this.model = model;
		this.controller = controller;

		// main title
		add(new TitleLabel("<html><center>Choose Numbers<br>(Binomial Coefficients)"));

		// message below title
		add(new MessageLabel("<html><center>Find out how many ways you can<br>choose k items from a set of n items without<br>repetition and without order:<br><br>"));
		
		// user's input panel with labels and text fields
		JPanel inputPanel = new JPanel(new GridLayout(2, 2));
		JLabel NLabel = new JLabel("Items to choose from N = ", SwingConstants.CENTER);
		JLabel KLabel = new JLabel("Number of items chosen K = ", SwingConstants.CENTER);
		NLabel.setFont(new Font("Apple Chancery", Font.PLAIN, 20));
		KLabel.setFont(new Font("Apple Chancery", Font.PLAIN, 20));
		NLabel.setForeground(Color.RED);
		KLabel.setForeground(Color.RED);
		n = new JTextField();
		k = new JTextField();
		inputPanel.add(NLabel);
		inputPanel.add(n);
		inputPanel.add(KLabel);
		inputPanel.add(k);
		add(inputPanel);

		// adding the equation image as a JLabel
		BufferedImage picture = null;
		try {
			picture = ImageIO.read(new File("src/images/chooseNK.png"));
		} catch (IOException e) {
			e.printStackTrace();
		}
		JLabel picLabel = new JLabel(new ImageIcon(picture));
		add(picLabel);

		// output label
		answerLabel = new JLabel("0");
		answerLabel.setFont(new Font("Apple Chancery", Font.PLAIN, 46));
		add(answerLabel);

		// calculate button
		JPanel buttonPanel = new JPanel();
		buttonPanel.setPreferredSize(new Dimension(500, 40));
		buttonPanel.setBackground(new Color(0, 0, 0, 0));
		JButton calculate = new JButton("Calculate");
		calculate.setName("Calculate");
		calculate.addActionListener(controller);
		buttonPanel.add(calculate);
		add(buttonPanel);

		// back to main button
		add(new BackToMainButton(controller));

	}

	@Override
	public void update(Observable o, Object arg) {

		if (model.getCurrentPanelIndex() == 10) {
			String answer = model.choose(n.getText(), k.getText());
			answerLabel.setText(answer);
		}
	}

}
