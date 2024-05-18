package com.home.solver.math;

public enum TokenType {
    NUMBER, IDENTIFIER, PLUS, MINUS, MULTIPLY, DIVIDE, POWER, LPAREN, RPAREN, EOF;

    public static TokenType fromSymbol(String symbol) {
        return switch (symbol) {
            case "+" -> PLUS;
            case "-" -> MINUS;
            case "*" -> MULTIPLY;
            case "/" -> DIVIDE;
            case "^" -> POWER;
            case "(" -> LPAREN;
            case ")" -> RPAREN;
            default -> EOF;
        };
    }
}