package model;

import java.util.ArrayList;
import java.util.Observable;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @author Osama Aboukoura
 */
public class CalculatorModel extends Observable {

	private String input = "0";
	private double answer;
	private boolean newCalculation = true;

	/**
	 * returns a string of the characters entered by user
	 */
	public String getInput() {
		return input;
	}

	/**
	 * returns the answer of the calculation
	 */
	public String getAnswer() {
		return answer + "";
	}

	/**
	 * deletes the last character entered
	 */
	public void back() {
		if (input.length() > 0) {
			input = input.substring(0, input.length() - 1);
		}
		if (input.length() == 0) {
			input = "0";
		}
		setChanged();
		notifyObservers();
	}

	/**
	 * clears the user's input
	 */
	public void clear() {
		input = "0";
		answer = 0;
		setChanged();
		notifyObservers();
	}

	/**
	 * changes the sign of the last number entered
	 */
	public void changeSign() {
		// not implemented yet
	}

	/**
	 * updates the user's input
	 */
	public void inputButton(String number) {
		if (newCalculation) {
			input = "0";
		}

		if (input.equals("0")) {
			input = "";
		}
		input += number;

		newCalculation = false;

		setChanged();
		notifyObservers();
	}

	public void calculate() {

		// extracting the numbers from the user's input
		String[] numbers = input.split("[\\+\\-\\*/%]");

		// array for the non numeric characters in the user's input
		ArrayList<String> operators = new ArrayList<String>();

		// regular expression for the non digit characters in the user's input
		Pattern p = Pattern.compile("[\\+\\-\\*/%]");

		// adding all the operators in the user's input to the operators
		// ArrayList
		for (int i = 0; i < input.length(); i++) {
			Matcher m = p.matcher(input.charAt(i) + "");
			if (m.find()) {
				operators.add(input.charAt(i) + "");
			}
		}

		try {
			answer = Double.parseDouble(numbers[0]);
			for (int i = 0; i < operators.size(); i++) {
				answer = arithmetic(answer, Double.parseDouble(numbers[i + 1]), operators.get(i));
			}
		} catch (ArrayIndexOutOfBoundsException ex1) {
			input = "0";
			answer = 0;
		} catch (NumberFormatException ex2) {
			input = "0";
			answer = 0;
		}

		// once the calculate button is pressed, the calculations happen, the
		// results are printed, and the calculator is ready for a new
		// calculation
		newCalculation = true;

		setChanged();
		notifyObservers();
	}

	/**
	 * takes a parameter of 2 numbers and 1 operator. the does the arithmetics
	 * and returns the results
	 */
	public double arithmetic(double x, double y, String o) {
		if (o.equals("+")) {
			return x + y;
		} else if (o.equals("-")) {
			return x - y;
		} else if (o.equals("*")) {
			return x * y;
		} else if (o.equals("/")) {
			return x / y;
		} else if (o.equals("%")) {
			return x % y;
		}
		return 0;
	}
}
