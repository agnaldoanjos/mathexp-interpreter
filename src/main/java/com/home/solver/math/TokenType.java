package com.home.solver.math;

public enum TokenType {
    NUMBER, IDENTIFIER, PLUS, MINUS, MULTIPLY, DIVIDE, POWER, LPAREN, RPAREN, EOF;

    public static TokenType fromSymbol(String symbol) {
        switch (symbol) {
            case "+": return PLUS;
            case "-": return MINUS;
            case "*": return MULTIPLY;
            case "/": return DIVIDE;
            case "^": return POWER;
            case "(": return LPAREN;
            case ")": return RPAREN;
            default: return EOF;
        }
    }
}