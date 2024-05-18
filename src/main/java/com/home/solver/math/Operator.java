package com.home.solver.math;

public enum Operator {
    PLUS, MINUS, MULTIPLY, DIVIDE, POWER;

    // Método para converter um símbolo em um operador
    public static Operator fromSymbol(String symbol) {
        switch (symbol) {
            case "+":
                return PLUS;
            case "-":
                return MINUS;
            case "*":
                return MULTIPLY;
            case "/":
                return DIVIDE;
            case "^":
                return POWER;
            default:
                throw new IllegalArgumentException("Unknown operator: " + symbol);
        }
    }
}
