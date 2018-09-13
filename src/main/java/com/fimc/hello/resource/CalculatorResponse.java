package com.fimc.hello.resource;

import java.io.Serializable;
import java.text.DecimalFormat;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CalculatorResponse implements Serializable{
	private String action;
	private Float results;
	
	public CalculatorResponse calculate(CalculatorRequest calculatorRequest) {
		CalculatorResponse calcu = new CalculatorResponse();
		
		DecimalFormat df = new DecimalFormat("#.#####"); 

		
		switch (calculatorRequest.getOperator()) {
		case "+":
			calcu.setAction("addition");
			calcu.setResults(Float.parseFloat(df.format(calculatorRequest.getNumber1()+calculatorRequest.getNumber2()))); 
			break;
		case "-":
			calcu.setAction("substraction");
			calcu.setResults(Float.parseFloat(df.format(calculatorRequest.getNumber1()-calculatorRequest.getNumber2()))); 
			break;
		case "*":
			calcu.setAction("multiplication");
			calcu.setResults(Float.parseFloat(df.format(calculatorRequest.getNumber1()*calculatorRequest.getNumber2()))); 
			break;
		case "/":
			calcu.setAction("division");
			calcu.setResults(Float.parseFloat(df.format(calculatorRequest.getNumber1()/calculatorRequest.getNumber2()))); 
			break;
		default:
			break;
		}
		
		
		
		return calcu;
	}
}
