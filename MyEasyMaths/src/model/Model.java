package model;

import java.awt.Color;
import java.awt.Desktop;
import java.net.URL;
import java.util.ArrayList;
import java.util.Observable;

/**
 * @author Osama Aboukoura
 */
public class Model extends Observable {

	private int currentPanelIndex;
	private String hex = "0";
	private String dec = "0";
	private String oct = "0";
	private String bin = "0";
	private Color labelColor = Color.BLACK;

	/**
	 * returns the index number of the current panel displayed
	 */
	public int getCurrentPanelIndex() {
		return currentPanelIndex;
	}

	/**
	 * sets the index number of the panel to be displayed
	 */
	public void setCurrentPanelIndex(int currentPanelIndex) {
		this.currentPanelIndex = currentPanelIndex;
		setChanged();
		notifyObservers();
	}

	/**
	 * notifies the view to call the model methods when a button is clicked
	 */
	public void notify_the_view() {
		setChanged();
		notifyObservers();
	}

	/**
	 * calculates the HCF and LCM for two given numbers returns an array of two
	 * numbers; the 1st being the HCF and the 2nd being the LCM
	 */
	public String[] calculate_hcf_lcm(String a, String b) {

		String[] array = { "0", "0" };

		try {
			Integer n1 = Integer.parseInt(a);
			Integer n2 = Integer.parseInt(b);

			int min = Math.min(n1, n2);
			for (int i = min; i >= 1; i--) {
				if (n1 % i == 0 && n2 % i == 0) {
					array[0] = i + "";
					break;
				}
			}
			for (int i = min; i <= n1 * n2; i++) {
				if (i % n1 == 0 && i % n2 == 0) {
					array[1] = i + "";
					break;
				}
			}

			return array;

		} catch (NumberFormatException ex) {
			return array;
		} catch (ArithmeticException e) {
			return array;
		}
	}

	/**
	 * takes the constants A, B, and C of a quadratic equation, and solves the
	 * equation returns an array of string solutions to the equation
	 */
	public ArrayList<String> calculate_quadratic_equation(String A, String B, String C) {

		ArrayList<String> solutions = new ArrayList<String>();

		double a, b, c;
		try {
			a = Double.parseDouble(A);
			b = Double.parseDouble(B);
			c = Double.parseDouble(C);
		} catch (NumberFormatException ex) {
			solutions.add("No solution. Bad input");
			return solutions;
		}

		if (a == 0) {
			if (b == 0) {
				if (c == 0) {
					solutions.add("Zero is always equal to zero");
					return solutions;
				} else {
					solutions.add("No solution. Bad input!");
					return solutions;
				}
			} else {
				double x = -1 * c / b;
				double rounded_x = Double.valueOf(String.format("%1$.3f", x));
				solutions.add("only one solution: x = " + rounded_x);
				return solutions;
			}
		} else {

			double delta = b * b - 4 * a * c;

			if (delta < 0) {
				solutions.add("No Real number soultion");
				return solutions;

			} else if (delta == 0) {
				double x = b / (-2 * a);
				double rounded_x = Double.valueOf(String.format("%1$.3f", x));
				solutions.add("only one solution: x = " + rounded_x);
				return solutions;
			}

			double x1 = ((-1 * b) + Math.sqrt(delta)) / (2 * a);
			double x2 = ((-1 * b) - Math.sqrt(delta)) / (2 * a);

			double rounded_x1 = Double.valueOf(String.format("%1$.3f", x1));
			double rounded_x2 = Double.valueOf(String.format("%1$.3f", x2));

			solutions.add("x1 = " + rounded_x1);
			solutions.add("x2 = " + rounded_x2);

			return solutions;
		}

	}

	/**
	 * takes an integer N that represents the number of sides, and returns a
	 * solution String that consists of the total sum of the angles, the size of
	 * each interior and exterior angle
	 */
	public String calculate_angles_in_polygon(String N) {
		String s = "<html><center>";
		Integer n;
		try {
			n = Integer.parseInt(N);
		} catch (NumberFormatException ex) {
			return "Bad input!";
		}
		if (n < 3) {
			return "No polygon with such input.";
		}
		switch (n) {
		case 3:
			s += "This regular polygon is an<br>Equilateral Triangle.<br>";
			break;
		case 4:
			s += "This regular polygon is a<br>Square.<br>";
			break;
		case 5:
			s += "This regular polygon is a<br>regular Pentagon.<br>";
			break;
		case 6:
			s += "This regular polygon is a<br>regular Hexagon.<br>";
			break;
		case 7:
			s += "This regular polygon is a<br>regular Septagon.<br>";
			break;
		case 8:
			s += "This regular polygon is a<br>regular Octagon.<br>";
			break;
		case 9:
			s += "This regular polygon is a<br>regular Nonagon.<br>";
			break;
		case 10:
			s += "This regular polygon is a<br>regular Decagon.<br>";
			break;
		default:
			s += "";
		}

		int anglesAddUpTo = (n - 2) * 180;
		int interiorAngleSize = anglesAddUpTo / n;
		int exteriorAngleSize = 180 - interiorAngleSize;

		s += "The angles of this polygon<br>add up to " + anglesAddUpTo;
		s += ".<br>Each interior angle equals " + interiorAngleSize;
		s += ".<br>Each exterior angle equals " + exteriorAngleSize + ".";

		return s;

	}

	/**
	 * takes the constants of 2 simultaneous equations, solves and returns a
	 * string showing the answers
	 */
	public String calculate_Simultaneous_Equations(String A, String B, String C, String M, String N, String P) {

		double a, b, c, m, n, p;
		try {
			a = Double.parseDouble(A);
			b = Double.parseDouble(B);
			c = Double.parseDouble(C);
			m = Double.parseDouble(M);
			n = Double.parseDouble(N);
			p = Double.parseDouble(P);
		} catch (NumberFormatException ex) {
			return "Bad input. No Solution.";
		}

		if ((a == 0 && b == 0) || (m == 0 && n == 0)) {
			return "No Solution.";
		}

		if ((a / b) == (m / n)) {
			String answer;
			if (-1 * a >= 0) {
				answer = "y=(" + c + "+" + (-1 * a) + "x)" + " / (" + b + ")";
			} else {
				answer = "y=(" + c + "-" + a + "x)" + " / (" + b + ")";
			}
			return "Infinite number of solutions. " + answer;
		}

		double x, y;

		if (a == 0) {
			y = c / b;
			x = (p - n * y) / m;
		} else if (b == 0) {
			x = c / a;
			y = (p - m * x) / n;
		} else if (m == 0) {
			y = p / n;
			x = (c - b * y) / a;
		} else if (n == 0) {
			x = p / m;
			y = (c - a * x) / b;
		} else {
			x = (b * p - n * c) / (b * m - a * n);
			y = (c - a * x) / b;
		}
		return "x = " + x + " y = " + y;
	}

	/**
	 * returns an array of all the numbers that divide a given number apart from
	 * 1 and the number itself
	 */
	public static ArrayList<Integer> dividers(int number) {

		ArrayList<Integer> dividers = new ArrayList<Integer>();
		for (int i = 2; i < number; i++) {
			if (number % i == 0) {
				dividers.add(i);
			}
		}
		return dividers;
	}

	/**
	 * returns a string that shows whether a given number is prime or not. if
	 * the number is not prime, it will show all the numbers that divide it
	 */
	public String getPrime(String s) {
		int number = 0;
		try {
			number = Integer.parseInt(s);
		} catch (NumberFormatException ex) {
			return "Bad Input. No solution.";
		}
		if (number <= 1) {
			return "numbers less than 1 are not accepted.";
		}

		ArrayList<Integer> array = dividers(number);

		if (array.size() == 0) {
			return number + "<html> is prime. It can only be divided by 1 and " + number + ".";
		}

		String x = number + "<html> is not prime. it can be divided by the following numbers:<br>1, ";

		for (int i = 0; i < array.size(); i++) {
			x += array.get(i) + ", ";
		}
		x += number + ".";
		return x;
	}

	/**
	 * takes a hexadecimal number and converts it to binary, octal and decimal.
	 */
	public void calculate_all_from_hex(String number) {

		hex = number;

		int decimalValue = 0;

		try {
			decimalValue = Integer.parseInt(number, 16);
		} catch (NumberFormatException ex) {
			hex = "0";
		}
		bin = Integer.toBinaryString(decimalValue);
		oct = Integer.toOctalString(decimalValue);
		dec = decimalValue + "";

		setChanged();
		notifyObservers();
	}

	/**
	 * takes a decimal number and converts it to binary, octal and hexadecimal.
	 */
	public void calculate_all_from_dec(String number) {

		dec = number;

		int x = 0;

		try {
			x = Integer.parseInt(number);
		} catch (NumberFormatException e) {
			dec = "0";
		}
		bin = Integer.toBinaryString(x);
		hex = Integer.toHexString(x);
		oct = Integer.toOctalString(x);

		setChanged();
		notifyObservers();
	}

	/**
	 * takes an octal number and converts it to binary, decimal and hexadecimal.
	 */
	public void calculate_all_from_oct(String number) {
		oct = number;

		int decimalValue = 0;

		try {
			decimalValue = Integer.parseInt(number, 8);
		} catch (NumberFormatException ex) {
			oct = "0";
		}
		bin = Integer.toBinaryString(decimalValue);
		hex = Integer.toString(decimalValue, 16);
		dec = decimalValue + "";

		setChanged();
		notifyObservers();
	}

	/**
	 * takes a binary number and converts it to decimal, octal and hexadecimal.
	 */
	public void calculate_all_from_bin(String number) {

		for (int i = 0; i < number.length(); i++) {
			if (!(number.charAt(i) == '1' || number.charAt(i) == '0')) {
				number = "0";
				break;
			}
		}

		int decimalValue = Integer.parseInt(number, 2);

		hex = Integer.toString(decimalValue, 16);
		oct = Long.toOctalString(Long.parseLong(number, 2));
		dec = decimalValue + "";
		bin = number;

		setChanged();
		notifyObservers();
	}

	/**
	 * deletes the contents of the binary, decimal, octal and hexadecimal fields
	 */
	public void emptyAllFields() {
		hex = "";
		dec = "";
		oct = "";
		bin = "";
		setChanged();
		notifyObservers();
	}

	/**
	 * hexadecimal number getter
	 */
	public String getHex() {
		return hex;
	}

	/**
	 * decimal number getter
	 */
	public String getDec() {
		return dec;
	}

	/**
	 * octal number getter
	 */
	public String getOct() {
		return oct;
	}

	/**
	 * binary number getter
	 */
	public String getBin() {
		return bin;
	}

	/**
	 * returns the factorial of a given number
	 */
	private int factorial(int x) {

		if (x <= 1) {
			return 1;
		}
		return x * factorial(x - 1);
	}

	/**
	 * returns a string representing the number of different ways of choosing y
	 * items from a set of x items (Binomial Coefficients)
	 */
	public String choose(String x, String y) {
		int N = 0;
		int K = 0;

		try {
			N = Integer.parseInt(x);
			K = Integer.parseInt(y);
		} catch (NumberFormatException ex) {
			return "0";
		}

		// choose numbers property
		if (N / 2 > K) {
			K = N - K;
		}

		long number = 1;

		try {
			for (int i = N; i > K; i--) {
				number *= i;
			}
			number /= factorial(N - K);
		} catch (ArithmeticException e) {
			return "Error.";
		}

		if ((number + "").length() > 11) {
			return "Error. Big number!";
		}
		return number + "";
	}

	/**
	 * takes 2 angles and returns their complement to 180
	 */
	public String angles_add_up_to_180(String angleX, String angleY) {

		double angle1;
		double angle2;

		try {
			angle1 = Double.parseDouble(angleX);
			angle2 = Double.parseDouble(angleY);
		} catch (NumberFormatException ex) {
			return "";
		}

		return (180 - (angle1 + angle2)) + "";
	}

	/**
	 * takes 3 side lengths of a triangle and returns the angle opposite the
	 * first parameter in degrees
	 */
	public String cosine_law_to_find_angle(String side_opposite_angle, String side_y, String side_z) {

		int side_opposite = 0;
		int side2 = 0;
		int side3 = 0;

		try {
			side_opposite = Integer.parseInt(side_opposite_angle);
			side2 = Integer.parseInt(side_y);
			side3 = Integer.parseInt(side_z);
		} catch (NumberFormatException ex) {
			return "";
		}

		double angleInRadians = Math
				.acos((side2 * side2 + side3 * side3 - side_opposite * side_opposite) / (2.0 * side2 * side3));

		double angleInDegrees = Double.valueOf(String.format("%1$.2f", Math.toDegrees(angleInRadians)));
		return angleInDegrees + "";
	}

	/**
	 * takes a parameter of 1 angle and 2 sides and returns the length of third
	 * side of the triangle
	 */
	public String cosine_law_to_find_side(String angleInBetween, String side_x, String side_y) {

		int angle = 0;
		int side1 = 0;
		int side2 = 0;

		try {
			angle = Integer.parseInt(angleInBetween);
			side1 = Integer.parseInt(side_x);
			side2 = Integer.parseInt(side_y);
		} catch (NumberFormatException ex) {
			return "";
		}

		double sideOppositeAngle = Math
				.sqrt(side1 * side1 + side2 * side2 - 2 * side1 * side2 * Math.cos(Math.toRadians(angle)));
		double roundedSideOppositeAngle = Double.valueOf(String.format("%1$.3f", sideOppositeAngle));

		return roundedSideOppositeAngle + "";
	}

	/**
	 * takes a parameter of 2 sides and 1 angle that is opposite one of the
	 * sides. returns the angle that is opposite the other side.
	 */
	public String sine_law_to_find_angle(String sideOppositeRequestedAngle, String angle_X, String side_x) {

		double side1 = 0;
		double angle2 = 0;
		double side2 = 0;

		try {
			side1 = Double.parseDouble(sideOppositeRequestedAngle);
			angle2 = Double.parseDouble(angle_X);
			side2 = Double.parseDouble(side_x);
		} catch (NumberFormatException ex) {
			return "";
		}

		double angle = Math.asin((Math.sin(Math.toRadians(angle2)) / side2) * side1);
		double angleInDegrees = Double.valueOf(String.format("%1$.2f", Math.toDegrees(angle)));

		return angleInDegrees + "";
	}

	/**
	 * takes a parameter of 2 angles and 1 side that is opposite one of the two
	 * angles. returns the length of the side that is opposite the other angle.
	 */
	public String sine_law_to_find_side(String angleOppositeRequestedSide, String angle_X, String side_x) {

		double angle1 = 0;
		double angle2 = 0;
		double side2 = 0;

		try {
			angle1 = Double.parseDouble(angleOppositeRequestedSide);
			angle2 = Double.parseDouble(angle_X);
			side2 = Double.parseDouble(side_x);
		} catch (NumberFormatException ex) {
			return "";
		}

		double side = (side2 / Math.sin(Math.toRadians(angle2))) * Math.sin(Math.toRadians(angle1));

		return side + "";
	}

	/**
	 * takes a parameter of 2 sides and 1 angle in between the 2 sides, and
	 * returns the area of the triangle
	 */
	public String getTriangleArea(String side1, String side2, String angle) {

		double a = 0;
		double b = 0;
		double C = 0;

		try {
			a = Double.parseDouble(side1);
			b = Double.parseDouble(side2);
			C = Double.parseDouble(angle);
		} catch (NumberFormatException ex) {
			return "";
		}

		double area = 0.5 * a * b * Math.sin(Math.toRadians(C));
		double roundedArea = Double.valueOf(String.format("%1$.2f", area));

		if (roundedArea < 0) {
			return "0";
		}

		return roundedArea + "";
	}
	
	/**
	 * changes the colour of a label
	 */
	public void setLabelColour (Color color) {
		labelColor  = color; 
		setChanged();
		notifyObservers();
	}
	
	/**
	 * colour getter
	 */
	public Color getLabelColor(){
		return labelColor;
	}

	/**
	 * takes a URL for a web page as a string, and opens the web page in a web
	 * browser
	 */
	public void openWebpage(String urlString) {
		try {
			Desktop.getDesktop().browse(new URL(urlString).toURI());
		} catch (Exception e) {
		}
	}

}
