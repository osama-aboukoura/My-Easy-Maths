package view;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.FontFormatException;
import java.awt.GridLayout;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Observable;
import java.util.Observer;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

import controller.Controller;
import model.CalculatorModel;
import model.Model;

/**
 * @author Osama Aboukoura
 *
 */
public class Calculator extends PanelWithBackground implements Observer {

	private Model model;
	private CalculatorModel calculatorModel;
	private Controller controller;
	private JLabel input, output;

	public Calculator(Model model, CalculatorModel calculatorModel, Controller controller) {

		this.model = model;
		this.calculatorModel = calculatorModel;
		this.controller = controller;

		// main title
		add(new TitleLabel("Calculator"));

		// creating a new font for the displayed input and output screens
		Font font = null;
		try {
			font = Font.createFont(Font.TRUETYPE_FONT, new File("src/digital-7/digital-7.ttf")).deriveFont(36f);
		} catch (IOException | FontFormatException e) {

		}
		input = new JLabel("");
		output = new JLabel("");
		input.setFont(font);
		output.setFont(font);

		// creating all the buttons of the calculator
		JButton button1 = new JButton("1");
		JButton button2 = new JButton("2");
		JButton button3 = new JButton("3");
		JButton button4 = new JButton("4");
		JButton button5 = new JButton("5");
		JButton button6 = new JButton("6");
		JButton button7 = new JButton("7");
		JButton button8 = new JButton("8");
		JButton button9 = new JButton("9");
		JButton button0 = new JButton("0");
		JButton buttonPoint = new JButton(".");
		JButton buttonSign = new JButton("-/+");
		JButton buttonAdd = new JButton("+");
		JButton buttonMinus = new JButton("-");
		JButton buttonMultiply = new JButton("X");
		JButton buttonDivide = new JButton("/");
		JButton buttonModulo = new JButton("%");
		JButton buttonEquals = new JButton("=");
		JButton buttonClear = new JButton("C");
		JButton buttonBack = new JButton("<-");

		// giving each of the buttons a name for referencing in the controller
		button1.setName("btn1");
		button2.setName("btn2");
		button3.setName("btn3");
		button4.setName("btn4");
		button5.setName("btn5");
		button6.setName("btn6");
		button7.setName("btn7");
		button8.setName("btn8");
		button9.setName("btn9");
		button0.setName("btn0");
		buttonPoint.setName("buttonPoint");
		buttonSign.setName("buttonSign");
		buttonAdd.setName("buttonAdd");
		buttonMinus.setName("buttonMinus");
		buttonMultiply.setName("buttonMultiply");
		buttonDivide.setName("buttonDivide");
		buttonModulo.setName("buttonModulo");
		buttonEquals.setName("buttonEquals");
		buttonClear.setName("buttonClear");
		buttonBack.setName("buttonBack");

		// the screen panel with input and output
		JPanel screenPanel = new JPanel(new GridLayout(2, 1));
		screenPanel.setBackground(Color.white);
		screenPanel.setPreferredSize(new Dimension(400, 80));
		screenPanel.setBorder(BorderFactory.createLineBorder(Color.RED, 3));
		JPanel buttonsPanel = new JPanel(new GridLayout(5, 4));
		buttonsPanel.setPreferredSize(new Dimension(400, 300));
		screenPanel.add(input);
		screenPanel.add(output);
		add(screenPanel);

		// adding the buttons to an ArrayList to handle all buttons collectively
		ArrayList<JButton> buttonsList = new ArrayList<JButton>();
		buttonsList.add(buttonBack);
		buttonsList.add(buttonModulo);
		buttonsList.add(buttonClear);
		buttonsList.add(buttonAdd);
		buttonsList.add(button1);
		buttonsList.add(button2);
		buttonsList.add(button3);
		buttonsList.add(buttonMinus);
		buttonsList.add(button4);
		buttonsList.add(button5);
		buttonsList.add(button6);
		buttonsList.add(buttonMultiply);
		buttonsList.add(button7);
		buttonsList.add(button8);
		buttonsList.add(button9);
		buttonsList.add(buttonDivide);
		buttonsList.add(buttonPoint);
		buttonsList.add(button0);
		buttonsList.add(buttonSign);
		buttonsList.add(buttonEquals);

		// changing the style of all the buttons collectively
		for (int i = 0; i < buttonsList.size(); i++) {
			buttonsPanel.add(buttonsList.get(i));
			buttonsList.get(i).setFont(new Font("Arial", Font.PLAIN, 20));
			buttonsList.get(i).setForeground(Color.RED);
			buttonsList.get(i).addActionListener(controller);
		}

		add(buttonsPanel);

		// back to main button
		JPanel buttonPanel = new JPanel();
		buttonPanel.setPreferredSize(new Dimension(500, 40));
		buttonPanel.setBackground(new Color(0, 0, 0, 0));
		buttonPanel.add(new BackToMainButton(controller));
		add(buttonPanel);
	}

	@Override
	public void update(Observable o, Object arg) {

		if (model.getCurrentPanelIndex() == 6) {
			input.setText(calculatorModel.getInput());
			output.setText(calculatorModel.getAnswer());
		}
	}

}
