package com.fimc.hello.resource;

import java.io.Serializable;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CalculatorResponse implements Serializable{
	private String action;
	private Float results;
	
	public CalculatorResponse calculate(CalculatorRequest calculatorRequest) {
		CalculatorResponse calcu = new CalculatorResponse();
		
		switch (calculatorRequest.getOperator()) {
		case "+":
			calcu.setAction("addition");
			calcu.setResults(calculatorRequest.getNumber1()+calculatorRequest.getNumber2()); 
			break;
		case "-":
			calcu.setAction("substraction");
			calcu.setResults(calculatorRequest.getNumber1()-calculatorRequest.getNumber2()); 
			break;
		case "*":
			calcu.setAction("multiplication");
			calcu.setResults(calculatorRequest.getNumber1()*calculatorRequest.getNumber2()); 
			break;
		case "/":
			calcu.setAction("division");
			calcu.setResults(calculatorRequest.getNumber1()/calculatorRequest.getNumber2()); 
			break;
		default:
			break;
		}
		
		return calcu;
		
	}
}
