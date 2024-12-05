package com.calculator.logic;

public class Calculator {
	
	 public double evaluate(String expression) {
	        String[] tokens = expression.split(" ");
	        double result = Double.parseDouble(tokens[0]);
	        for (int i = 1; i < tokens.length; i += 2) {
	            String operator = tokens[i];
	            double number = Double.parseDouble(tokens[i + 1]);
	            switch (operator) {
	                case "+":
	                    result += number;
	                    break;
	                case "-":
	                    result -= number;
	                    break;
	                case "*":
	                    result *= number;
	                    break;
	                case "/":
	                    if (number != 0) {
	                        result /= number;
	                    } else {
	                        throw new ArithmeticException("Sıfıra bölme hatası");
	                    }
	                    break;
	            }
	        }
	        return result;
}}
