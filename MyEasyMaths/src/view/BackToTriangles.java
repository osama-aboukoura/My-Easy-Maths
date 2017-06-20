package view;

import javax.swing.JButton;

import controller.Controller;

/**
 * Creates a button that goes back to the Trigonometry panel.
 *  
 * @author Osama Aboukoura
 */
public class BackToTriangles extends JButton{
	
	public BackToTriangles(Controller controller){
		setText("Back To The Triangles");
		setName("backToTriangles");
		addActionListener(controller);
	}

}
