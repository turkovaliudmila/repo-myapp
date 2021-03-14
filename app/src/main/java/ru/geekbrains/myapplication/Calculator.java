package ru.geekbrains.myapplication;

public class Calculator {
    private int inputMode; // 0 - ввод первого числа, 1 - ввод второго числа, 2 - получен результат
    private double firstNumber;
    private double secondNumber;
    private String operator;
    private String textTablo;
    private int counterAfterDot1;
    private int counterAfterDot2;

    public Calculator() {
        inputMode    = 0;
        firstNumber  = 0;
        secondNumber = 0;
        operator     = "";
        textTablo    = "";
        counterAfterDot1 = 0;
        counterAfterDot1 = 0;
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
        double resNumber = 0;
        if (inputMode == 1 && operator != "") {
            inputMode = 2;
            if (operator == "+") {
                resNumber = firstNumber + secondNumber;
            } else if (operator == "-") {
                resNumber = firstNumber - secondNumber;
            } else if (operator == "*") {
                resNumber = firstNumber * secondNumber;
            } else if (operator == "/") {
                resNumber = firstNumber / secondNumber;
            }
            textTablo = "" + resNumber;

            firstNumber  = 0;
            secondNumber = 0;
            operator     = "";
            counterAfterDot1 = 0;
            counterAfterDot2 = 0;
        }
        return resNumber;
    }

    public void inputNumber(String textCalc, int number) {
        if (inputMode == 0) {
            if (counterAfterDot1 == 0) {
                firstNumber = firstNumber * 10 + number;
            } else {
                firstNumber = firstNumber + number / Math.pow(10, counterAfterDot1);
                counterAfterDot1++;
            }
            textTablo = textCalc + number;
        } else if (inputMode == 1) {
            if (counterAfterDot2 == 0) {
                secondNumber = secondNumber * 10 + number;
            } else {
                secondNumber = secondNumber + number / Math.pow(10, counterAfterDot2);
                counterAfterDot2++;
            }
            textTablo = textCalc + number;
        } else if (inputMode == 2) {
            firstNumber = firstNumber * 10 + number;
            textTablo = "" + number;
            inputMode = 0;
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

    public void inputDot(String textCalc) {
        if ((inputMode == 0||inputMode == 2)&&(counterAfterDot1 == 0)){
            if(inputMode==2) {
                inputMode = 0;
            }
            counterAfterDot1 = 1;
            if(firstNumber == 0) {
                textTablo = "0.";
            } else {
                textTablo = textCalc + ".";
            }
        } else if ((inputMode == 1)&&(counterAfterDot2 == 0)) {
            counterAfterDot2 = 1;
            if(secondNumber == 0) {
                textTablo = textCalc + "0.";
            } else {
                textTablo = textCalc + ".";
            }
        }
    }

}
