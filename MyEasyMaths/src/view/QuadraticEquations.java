package view;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Observable;
import java.util.Observer;

import javax.imageio.ImageIO;
import javax.swing.BorderFactory;
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
public class QuadraticEquations extends PanelWithBackground implements Observer{
	
	private Model model;
	private Controller controller;
	private JLabel solution;
	private JTextField jtfFirstNumber, jtfSecondNumber, jtfThirdNumber;
	
	public QuadraticEquations(Model model, Controller controller) {

		this.model = model;
		this.controller = controller;
		
		// main title
		add(new TitleLabel("Quadratic Equations"));
		
		// message bellow title 
		add(new MessageLabel("<html>Enter the constants of the equation:<br>"));
		
		// adding the equation image
		BufferedImage picture = null;
		try {
			picture = ImageIO.read(new File("src/images/equation.png"));
		} catch (IOException e) {
			e.printStackTrace();
		}
		JLabel picLabel = new JLabel(new ImageIcon(picture));
		add(picLabel);

		// add another message 
		add(new MessageLabel("<html>and I will solve the equation for you:<br>"));
		
		// input panel with 3 labels and 3 text fields
		JPanel inputPanel = new JPanel(new GridLayout(3, 2));

		JLabel jlFirstNumber = new JLabel("The constant a = ", SwingConstants.CENTER);
		jlFirstNumber.setFont(new Font("Apple Chancery", Font.PLAIN, 24));
		jlFirstNumber.setForeground(Color.RED);
		jtfFirstNumber = new JTextField();
		jtfFirstNumber.setPreferredSize(new Dimension(220, 24));

		JLabel jlSecondNumber = new JLabel("The constant b = ", SwingConstants.CENTER);
		jlSecondNumber.setFont(new Font("Apple Chancery", Font.PLAIN, 24));
		jlSecondNumber.setForeground(Color.RED);
		jtfSecondNumber = new JTextField();
		jtfSecondNumber.setPreferredSize(new Dimension(220, 24));

		JLabel jlThirdNumber = new JLabel("The constant c = ", SwingConstants.CENTER);
		jlThirdNumber.setFont(new Font("Apple Chancery", Font.PLAIN, 24));
		jlThirdNumber.setForeground(Color.RED);
		jtfThirdNumber = new JTextField();
		jtfSecondNumber.setPreferredSize(new Dimension(220, 24));

		inputPanel.add(jlFirstNumber);
		inputPanel.add(jtfFirstNumber);
		inputPanel.add(jlSecondNumber);
		inputPanel.add(jtfSecondNumber);
		inputPanel.add(jlThirdNumber);
		inputPanel.add(jtfThirdNumber);
		add(inputPanel);
		
		// calculate button 
		JButton calculate = new JButton("Calculate");
		calculate.setName("Calculate");
		calculate.addActionListener(controller);
		add(calculate);
		
		// solution label
		JLabel solutionLabel = new JLabel ("Solution:");
		solutionLabel.setFont(new Font("SignPainter", Font.PLAIN, 36));
		solutionLabel.setPreferredSize(new Dimension(470,50));
		add(solutionLabel);
		
		// output panel with label for answer  
		JPanel outputPanel = new JPanel();
		outputPanel.setPreferredSize(new Dimension(470,50));
		solution = new JLabel ("", SwingConstants.CENTER);
		solution.setForeground(Color.RED);
		solution.setFont(new Font("Apple Chancery", Font.PLAIN, 24));
		outputPanel.add(solution);
		add(outputPanel);

		// back to main button 
		add(new BackToMainButton(controller));

	}

	@Override
	public void update(Observable o, Object arg) {
		
		if (model.getCurrentPanelIndex() == 3){
			
			ArrayList<String> solutions = model.calculate_quadratic_equation(jtfFirstNumber.getText(), jtfSecondNumber.getText(), jtfThirdNumber.getText());
			
			solution.setText(solutions.get(0));
			
			if (solutions.size() == 2){
				solution.setText(solution.getText() + " and " + solutions.get(1));
			}
			
		}
	}
	
}
