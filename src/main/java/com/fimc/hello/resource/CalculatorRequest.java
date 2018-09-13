package com.fimc.hello.resource;

import java.io.Serializable;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
@EqualsAndHashCode
public class CalculatorRequest implements Serializable{
	private String operator;
	private Float number1;
	private Float number2;
}
