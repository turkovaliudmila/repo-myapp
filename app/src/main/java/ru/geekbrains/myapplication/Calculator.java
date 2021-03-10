package ru.geekbrains.myapplication;

public class Calculator {
    private int inputMode; // 0 - ввод первого числа, 1 - ввод второго числа
    private double firstNumber;
    private double secondNumber;
    private String operator;

    public Calculator() {
        inputMode    = 0;
        firstNumber  = 0;
        secondNumber = 0;
        operator     = "";
    }

    public double getFirstNumber() {
        return firstNumber;
    }

    public double getSecondNumber() {
        return secondNumber;
    }

    public int getInputMode() {
        return inputMode;
    }

    public String getOperator() {
        return operator;
    }

    public void setFirstNumber(double firstNumber) {
        this.firstNumber = firstNumber;
    }

    public void setSecondNumber(double secondNumber) {
        this.secondNumber = secondNumber;
    }

    public void setInputMode(int inputMode) {
        this.inputMode = inputMode;
    }

    public void setOperator(String operator) {
        this.operator = operator;
    }

    public double getRes() {
        if (inputMode == 1 && operator != "") {
            if (operator == "ADD") {
                return firstNumber + secondNumber;
            } else if (operator == "DEL") {
                return firstNumber - secondNumber;
            } else if (operator == "MULTI") {
                return firstNumber * secondNumber;
            } else if (operator == "DIV") {
                return firstNumber / secondNumber;
            }
        }
        return 0;
    }
}
