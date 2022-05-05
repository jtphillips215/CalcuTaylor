package edu.volstate.calculator;

public class Calculation {

    private double results;

    // getter and setter; set results uses operator to determine which operation to use
    public void setResults(double number1, double number2, String operator) {
        switch (operator) {
            case "+":
                results = number1 + number2;
                break;
            case "-":
                results = number1 - number2;
                break;
            case "X":
                results = number1 * number2;
                break;
            case "/":
                results = number1 / number2;
                break;
            case "%":
                results = (number1 / 100) * number2;
                break;
            default:
                results = 0;
        }
    }

    public double getResults() {
        return results;
    }
}
