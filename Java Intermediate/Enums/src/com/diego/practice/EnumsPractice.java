package com.diego.practice;

public class EnumsPractice {
	
	public enum MathOperator/*Here we are defining the object type, well could it be int,String or Student */ {
	    PLUS, MINUS, MULTIPLY, DIVIDE
	}
	
	 public static int calculate(MathOperator operator, int operand1, int operand2) {

	        switch(operator) {
	            case PLUS:
	                return operand1 + operand2;
	            case MINUS:
	                return operand1 - operand2;
	            case MULTIPLY:
	                return operand1 * operand2;
	            case DIVIDE:
	                return operand1 / operand2;
	            default:
	                throw new UnsupportedOperationException();
	        }
	    }

	public static void main(String[] args) {
		
		System.out.println( "Result: " +
		calculate(MathOperator.PLUS,2,2)
		);
	}
	
	
}
