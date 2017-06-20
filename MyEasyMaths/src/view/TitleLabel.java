package view;

import java.awt.Color;
import java.awt.Font;

import javax.swing.JLabel;
import javax.swing.SwingConstants;

/**
 * Creates a red label with a big font size
 * 
 * @author osamaaboukoura
 */
public class TitleLabel extends JLabel {

	public TitleLabel(String title) {
		setText(title);
		setFont(new Font("Marker Felt", Font.PLAIN, 46));
		setForeground(Color.RED);
	}
}
