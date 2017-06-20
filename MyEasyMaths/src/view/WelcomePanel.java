package view;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.util.Observable;
import java.util.Observer;

import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JLabel;
import javax.swing.SwingConstants;

import controller.Controller;
import model.Model;

/**
 * @author Osama Aboukoura
 */
public class WelcomePanel extends PanelWithBackground implements Observer{

	private Model model;
	private Controller controller;
	private JButton startButton; 
	
	public WelcomePanel(Model model, Controller controller) {
		
		this.model = model;
		this.controller = controller;
						
		JLabel jlTitle = new JLabel("<html><center>Welcome to <br/>My Easy Maths<br/>", SwingConstants.CENTER);
		jlTitle.setFont(new Font("Marker Felt", Font.PLAIN, 60));
		jlTitle.setForeground(Color.RED);
		
		startButton = new JButton("Click to Start"); 
		startButton.setFont(new Font("Arial", Font.PLAIN, 20));
		startButton.setName("startButton");
		startButton.addActionListener(controller);
		
		setLayout(new BorderLayout());
		add(jlTitle, BorderLayout.CENTER);
		add(startButton, BorderLayout.SOUTH);
		
		
	}

	@Override
	public void update(Observable o, Object arg) {
		// TODO Auto-generated method stub
	}

}
