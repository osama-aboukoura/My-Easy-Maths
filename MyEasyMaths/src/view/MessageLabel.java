package view;

import java.awt.Font;

import javax.swing.JLabel;

/**
 * Creates a label that is used below the main title of each panel
 * 
 * @author Osama Aboukoura
 */
public class MessageLabel extends JLabel {

	public MessageLabel(String text) {
		setText(text);
		setFont(new Font("SignPainter", Font.PLAIN, 32));
	}
}
