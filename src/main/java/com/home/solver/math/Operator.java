package com.home.solver.math;

public enum Operator {
    PLUS, MINUS, MULTIPLY, DIVIDE, POWER;

    // Method to convert a symbol into an operator
    public static Operator fromSymbol(String symbol) {
        return switch (symbol) {
            case "+" -> PLUS;
            case "-" -> MINUS;
            case "*" -> MULTIPLY;
            case "/" -> DIVIDE;
            case "^" -> POWER;
            default -> throw new IllegalArgumentException("Unknown operator: " + symbol);
        };
    }
}
