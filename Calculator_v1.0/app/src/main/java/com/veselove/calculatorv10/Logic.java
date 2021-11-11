package com.veselove.calculatorv10;

public class Logic {
    public static double calculate (char function, int firstOperand, int secondOperand) {
        double result = 0;
        switch (function) {
            case '/':
                result = firstOperand / secondOperand;
                break;
            case '*':
                result = firstOperand * secondOperand;
                break;
            case '-':
                result = firstOperand - secondOperand;
                break;
            case '+':
                result = firstOperand + secondOperand;
                break;
        }
        return result;
    }

}
