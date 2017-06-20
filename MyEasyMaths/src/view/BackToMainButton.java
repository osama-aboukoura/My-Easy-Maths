package view;

import javax.swing.JButton;

import controller.Controller;

/**
 * Creates a button that goes back to the main panel.
 * 
 * @author Osama Aboukoura
 */
public class BackToMainButton extends JButton{
	
	public BackToMainButton(Controller controller){
		setText("Back To Main");
		setName("backToMain");
		addActionListener(controller);
	}
}
