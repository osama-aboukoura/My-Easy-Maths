package view;

import java.awt.Font;
import java.util.Observable;
import java.util.Observer;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.border.Border;

import controller.Controller;
import model.Model;

/**
 * @author Osama Aboukoura
 */
public class MainMenu extends PanelWithBackground implements Observer {

	private Model model;
	private Controller controller;
	private JLabel linkedInLabel;

	public MainMenu(Model model, Controller controller) {

		this.model = model;
		this.controller = controller;

		// main title
		add(new TitleLabel("My Easy Maths"));

		// message below title
		add(new MessageLabel("Let's Start! Choose One of the Following Topics:"));
		
		// creating an empty border to be used by all the buttons 
		Border empty = BorderFactory.createEmptyBorder();
		
		// creating and adding all 9 buttons of the main menu 
		for (int i = 1 ; i <= 9 ; i++){
			
			JButton button = new JButton(new ImageIcon("src/images/button" + i + ".png"));
			
			// giving each button a name for referencing in the controller
			button.setName("button" + i);
			
			// adding an action listener to each button
			button.addActionListener(controller);
			
			// removing the buttons' borders
			button.setBorder(empty);
			
			add(button);
		}
		
		// contact me labels
		JLabel jlContact = new JLabel("<html><br>Contact me on: ");
		linkedInLabel = new JLabel("<html><br>LinkedIn");
		jlContact.setFont(new Font("Serif", Font.BOLD, 14));
		linkedInLabel.setFont(new Font("Serif", Font.BOLD, 14));
		linkedInLabel.addMouseListener(controller);
		add(jlContact);
		add(linkedInLabel);

	}

	@Override
	public void update(Observable o, Object arg) {

		if (model.getCurrentPanelIndex() == 1) {
			linkedInLabel.setForeground(model.getLabelColor());
		}
	}

}
