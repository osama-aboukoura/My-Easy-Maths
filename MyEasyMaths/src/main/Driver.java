package main;

import controller.Controller;
import model.CalculatorModel;
import model.Model;
import view.View;

/**
 * @author Osama Aboukoura
 */
public class Driver {

	public static void main(String[] args) {
		
		/*
		 * applying the MVC structure
		 */
		Model model = new Model(); 
		CalculatorModel calculatorModel = new CalculatorModel();
		Controller controller = new Controller(model, calculatorModel);
		View view = new View (model, calculatorModel, controller);
		
		calculatorModel.addObserver(view);
		model.addObserver(view);
		
		view.setVisible(true);
		
	}

}
