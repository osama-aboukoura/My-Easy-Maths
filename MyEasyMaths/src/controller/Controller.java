package controller;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JButton;
import javax.swing.JTextField;

import model.CalculatorModel;
import model.Model;

/**
 * @author Osama Aboukoura
 */
public class Controller implements ActionListener, KeyListener, MouseListener {

	private Model model;
	private CalculatorModel calculatorModel;

	public Controller(Model model, CalculatorModel calculatorModel) {

		this.model = model;
		this.calculatorModel = calculatorModel;

	}

	@Override
	public void actionPerformed(ActionEvent e) {

		// casting the action event into a JButton
		JButton pressedButton = (JButton) e.getSource();

		if (pressedButton.getName().equals("startButton")) {
			model.setCurrentPanelIndex(1);
		}

		if (pressedButton.getName().equals("button1")) {
			model.setCurrentPanelIndex(2);
		}

		if (pressedButton.getName().equals("button2")) {
			model.setCurrentPanelIndex(3);
		}

		if (pressedButton.getName().equals("button3")) {
			model.setCurrentPanelIndex(4);
		}

		if (pressedButton.getName().equals("button4")) {
			model.setCurrentPanelIndex(5);
		}

		if (pressedButton.getName().equals("button5")) {
			model.setCurrentPanelIndex(6);
		}

		if (pressedButton.getName().equals("button6")) {
			model.setCurrentPanelIndex(7);
		}

		if (pressedButton.getName().equals("button7")) {
			model.setCurrentPanelIndex(8);
		}

		if (pressedButton.getName().equals("button8")) {
			model.setCurrentPanelIndex(9);
		}
		
		if (pressedButton.getName().equals("button9")) {
			model.setCurrentPanelIndex(10);
		}
		
		if (pressedButton.getName().equals("triangle1")) {
			model.setCurrentPanelIndex(11);
		}

		if (pressedButton.getName().equals("triangle2")) {
			model.setCurrentPanelIndex(12);
		}

		if (pressedButton.getName().equals("triangle3")) {
			model.setCurrentPanelIndex(13);
		}

		if (pressedButton.getName().equals("triangle4")) {
			model.setCurrentPanelIndex(14);
		}

		if (pressedButton.getName().equals("triangle5")) {
			model.setCurrentPanelIndex(15);
		}

		if (pressedButton.getName().equals("triangle6")) {
			model.setCurrentPanelIndex(16);
		}

		if (pressedButton.getName().equals("Calculate")) {
			model.notify_the_view();
		}

		if (pressedButton.getName().equals("backToMain")) {
			model.setCurrentPanelIndex(1);
		}
		
		if (pressedButton.getName().equals("backToTriangles")) {
			model.setCurrentPanelIndex(5);
		}

		
		if (pressedButton.getName().equals("btn1")) {
			calculatorModel.inputButton("1");

		} else if (pressedButton.getName().equals("btn2")) {
			calculatorModel.inputButton("2");

		} else if (pressedButton.getName().equals("btn3")) {
			calculatorModel.inputButton("3");

		} else if (pressedButton.getName().equals("btn4")) {
			calculatorModel.inputButton("4");

		} else if (pressedButton.getName().equals("btn5")) {
			calculatorModel.inputButton("5");

		} else if (pressedButton.getName().equals("btn6")) {
			calculatorModel.inputButton("6");

		} else if (pressedButton.getName().equals("btn7")) {
			calculatorModel.inputButton("7");

		} else if (pressedButton.getName().equals("btn8")) {
			calculatorModel.inputButton("8");

		} else if (pressedButton.getName().equals("btn9")) {
			calculatorModel.inputButton("9");

		} else if (pressedButton.getName().equals("btn0")) {
			calculatorModel.inputButton("0");

		} else if (pressedButton.getName().equals("buttonPoint")) {
			calculatorModel.inputButton(".");

		} else if (pressedButton.getName().equals("buttonSign")) {
			calculatorModel.changeSign();

		} else if (pressedButton.getName().equals("buttonAdd")) {
			calculatorModel.inputButton("+");

		} else if (pressedButton.getName().equals("buttonMinus")) {
			calculatorModel.inputButton("-");

		} else if (pressedButton.getName().equals("buttonMultiply")) {
			calculatorModel.inputButton("*");

		} else if (pressedButton.getName().equals("buttonDivide")) {
			calculatorModel.inputButton("/");

		} else if (pressedButton.getName().equals("buttonModulo")) {
			calculatorModel.inputButton("%");

		} else if (pressedButton.getName().equals("buttonEquals")) {
			calculatorModel.calculate();

		} else if (pressedButton.getName().equals("buttonClear")) {
			calculatorModel.clear();

		} else if (pressedButton.getName().equals("buttonBack")) {
			calculatorModel.back();

		}

	}

	@Override
	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub
	}

	@Override
	public void keyPressed(KeyEvent e) {
		// TODO Auto-generated method stub
	}

	@Override
	public void keyReleased(KeyEvent e) {
		// casting the action event into a JTextField
		JTextField textFieldTriggered = (JTextField) e.getSource();

		String field = textFieldTriggered.getName();
		String text = textFieldTriggered.getText();

		if (field.equals("hex")) {
			model.calculate_all_from_hex(text);
		} else if (field.equals("dec")) {
			model.calculate_all_from_dec(text);
		} else if (field.equals("oct")) {
			model.calculate_all_from_oct(text);
		} else if (field.equals("bin")) {
			model.calculate_all_from_bin(text);
		}

		textFieldTriggered.requestFocus();
	}

	@Override
	public void mouseClicked(MouseEvent e) {
		// TODO Auto-generated method stub
	}

	@Override
	public void mousePressed(MouseEvent e) {
		// TODO Auto-generated method stub
	}

	@Override
	public void mouseReleased(MouseEvent e) {
		model.openWebpage("https://uk.linkedin.com/in/osama-aboukoura-b26585a1");
	}

	@Override
	public void mouseEntered(MouseEvent e) {
		model.setLabelColour (Color.GRAY);
	}

	@Override
	public void mouseExited(MouseEvent e) {
		model.setLabelColour (Color.BLACK);
	}


}
