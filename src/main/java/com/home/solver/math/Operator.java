package com.home.solver.math;

public enum Operator {
    PLUS, MINUS, MULTIPLY, DIVIDE, POWER;

    // Método para converter um símbolo em um operador
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
