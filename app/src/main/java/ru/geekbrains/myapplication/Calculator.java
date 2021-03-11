package ru.geekbrains.myapplication;

public class Calculator {
    private int inputMode; // 0 - ввод первого числа, 1 - ввод второго числа, 2 - получен результат
    private double firstNumber;
    private double secondNumber;
    private String operator;
    private String textTablo;

    public Calculator() {
        inputMode    = 0;
        firstNumber  = 0;
        secondNumber = 0;
        operator     = "";
        textTablo    = "";
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

    public void inputNumber(String textCalc, int number) {
        if (inputMode == 0) {
            firstNumber = firstNumber * 10 + number;
            textTablo = textCalc + number;
        } else if (inputMode == 1) {
            secondNumber = secondNumber * 10 + number;
            textTablo = textCalc + number;
        } else if (inputMode == 2) {
            inputMode = 0;
            firstNumber = number;
            secondNumber = 0;
            operator = "";
            this.textTablo = "";
            textTablo = "";
        }
    }

    public String getTextTablo() {
        return textTablo;
    }

    public void setTextTablo(String textTablo) {
        this.textTablo = textTablo;
    }

    public void inputOperation(String textCalc, String operation) {
        if (inputMode == 0) {
            inputMode = 1;
            operator = operation;
            textTablo = textCalc + operation;
        } else if (inputMode == 1) {
            operator = operation;
            textTablo = "" + firstNumber + operation + secondNumber;
        }
    }

}
