package view;

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
public class HexDecOctBin extends PanelWithBackground implements Observer {

	private Model model;
	private Controller controller;
	private JTextField hex, dec, oct, bin;

	public HexDecOctBin(Model model, Controller controller) {

		this.model = model;
		this.controller = controller;

		// main title
		add(new TitleLabel("Numbering Systems"));

		// message below title
		add(new MessageLabel("<html><center>Use this calculator to convert between the<br>Hexadecimal, Decimal, Octal and<br>Binary numbering systems:<br><br>"));

		// input panel with labels and text fields
		JPanel inputFirstPanel = new JPanel(new GridLayout(4, 2));
		inputFirstPanel.setPreferredSize(new Dimension(420, 150));

		JLabel HexadecimalLabel = new JLabel("Hex (base 16) = ", SwingConstants.CENTER);
		JLabel DecimalLabel = new JLabel("Dec (base 10) = ", SwingConstants.CENTER);
		JLabel OctalLabel = new JLabel("Oct (base 8) = ", SwingConstants.CENTER);
		JLabel BinaryLabel = new JLabel("Bin (base 2) = ", SwingConstants.CENTER);
		HexadecimalLabel.setFont(new Font("Apple Chancery", Font.PLAIN, 22));
		DecimalLabel.setFont(new Font("Apple Chancery", Font.PLAIN, 22));
		OctalLabel.setFont(new Font("Apple Chancery", Font.PLAIN, 22));
		BinaryLabel.setFont(new Font("Apple Chancery", Font.PLAIN, 22));
		HexadecimalLabel.setForeground(Color.RED);
		DecimalLabel.setForeground(Color.RED);
		OctalLabel.setForeground(Color.RED);
		BinaryLabel.setForeground(Color.RED);

		hex = new JTextField();
		dec = new JTextField();
		oct = new JTextField();
		bin = new JTextField();
		hex.setName("hex");
		dec.setName("dec");
		oct.setName("oct");
		bin.setName("bin");
		hex.addKeyListener(controller);
		dec.addKeyListener(controller);
		oct.addKeyListener(controller);
		bin.addKeyListener(controller);

		// adding the labels and text fields to the input panel
		inputFirstPanel.add(HexadecimalLabel);
		inputFirstPanel.add(hex);
		inputFirstPanel.add(DecimalLabel);
		inputFirstPanel.add(dec);
		inputFirstPanel.add(OctalLabel);
		inputFirstPanel.add(oct);
		inputFirstPanel.add(BinaryLabel);
		inputFirstPanel.add(bin);
		add(inputFirstPanel);

		// back To Main button
		add(new BackToMainButton(controller));

	}

	@Override
	public void update(Observable o, Object arg) {

		if (model.getCurrentPanelIndex() == 9) {
			hex.setText(model.getHex());
			dec.setText(model.getDec());
			oct.setText(model.getOct());
			bin.setText(model.getBin());
		}
	}

}
