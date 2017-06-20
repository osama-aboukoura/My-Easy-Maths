package view;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.util.ArrayList;
import java.util.Observable;
import java.util.Observer;

import javax.swing.JFrame;
import javax.swing.JPanel;

import controller.Controller;
import model.CalculatorModel;
import model.Model;

/**
 * @author Osama Aboukoura
 */
public class View extends JFrame implements Observer {

	private Model model;
	private Controller controller;
	private CalculatorModel calculatorModel;
	private ArrayList<JPanel> panels = new ArrayList<JPanel>();
	private JPanel changeablePanel;

	public View(Model model, CalculatorModel calculatorModel, Controller controller) {

		this.model = model;
		this.controller = controller;
		this.calculatorModel = calculatorModel;

		setTitle("My Easy Maths");

		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		setMinimumSize(new Dimension(540, 560));
		setResizable(false);

		initWidgets();

	}

	private void initWidgets() {

		// creating instances of all the panels of the program
		JPanel welcomePanel = new WelcomePanel(model, controller);
		JPanel mainMenu = new MainMenu(model, controller);
		JPanel hcflcm = new HCFLCM(model, controller);
		JPanel quadraticEquations = new QuadraticEquations(model, controller);
		JPanel AnglesInPolygons = new AnglesInPolygons(model, controller);
		JPanel trigonometry = new Trigonometry(model, controller);
		JPanel calculator = new Calculator(model, calculatorModel, controller);
		JPanel simultaneousEquations = new SimultaneousEquations(model, controller);
		JPanel primeNumbers = new PrimeNumbers(model, controller);
		JPanel hexDecOctBin = new HexDecOctBin(model, controller);
		JPanel chooseNumbers = new ChooseNumbers(model, controller);
		JPanel trigonometry1 = new Trigonometry1(model, controller);
		JPanel trigonometry2 = new Trigonometry2(model, controller);
		JPanel trigonometry3 = new Trigonometry3(model, controller);
		JPanel trigonometry4 = new Trigonometry4(model, controller);
		JPanel trigonometry5 = new Trigonometry5(model, controller);
		JPanel trigonometry6 = new Trigonometry6(model, controller);
		
		calculatorModel.addObserver((Observer) calculator);
		
		// adding these panels to a 'panels' ArrayList
		panels.add(welcomePanel);
		panels.add(mainMenu);
		panels.add(hcflcm);
		panels.add(quadraticEquations);
		panels.add(AnglesInPolygons);
		panels.add(trigonometry);
		panels.add(calculator);
		panels.add(simultaneousEquations);
		panels.add(primeNumbers);
		panels.add(hexDecOctBin);
		panels.add(chooseNumbers);
		panels.add(trigonometry1);
		panels.add(trigonometry2);
		panels.add(trigonometry3);
		panels.add(trigonometry4);
		panels.add(trigonometry5);
		panels.add(trigonometry6);
		
		for (JPanel panel : panels){
			model.addObserver((Observer) panel);
		}
		

		// the main frame consists of 1 panel that changes its contents
		changeablePanel = new JPanel(new BorderLayout());
		changeablePanel.add(panels.get(model.getCurrentPanelIndex()));
		add(changeablePanel);

	}

	@Override
	public void update(Observable o, Object arg) {

		// updating the current panel to be displayed
		changeablePanel.removeAll();
		changeablePanel.add(panels.get(model.getCurrentPanelIndex()));

		revalidate();
		repaint();
	}

}
