package com.home.solver.math;

import java.util.List;

/**
 * The Parser, or syntactic analyzer, receives the list of tokens from the lexer and builds an abstract syntactic tree (AST).
 * This tree represents the hierarchical structure of the mathematical expression according to the grammar of the defined language.
 * defined language.
 *
 * Responsibilities:
 *
 * Verify that the sequence of tokens follows the grammatical rules of the language.
 * Building the AST from the tokens, where each node represents different grammatical constructs (such as expressions, binary operations, etc.).
 * Manage the precedence of mathematical operations and groupings by parentheses.
 */
public class Parser {
    private final List<Token> tokens;
    private int position = 0;

    public Parser(List<Token> tokens) {
        this.tokens = tokens;
    }

    public Expression parse() {
        return parseExpression();
    }

    private Expression parseExpression() {
        Expression result = parseTerm();
        while (lookahead().type == TokenType.PLUS || lookahead().type == TokenType.MINUS) {
            Token op = next();
            Expression right = parseTerm();
            result = new BinaryExpression(result, op.type == TokenType.PLUS ? Operator.PLUS : Operator.MINUS, right);
        }
        return result;
    }

    private Expression parseTerm() {
        Expression result = parseFactor();
        while (lookahead().type == TokenType.MULTIPLY || lookahead().type == TokenType.DIVIDE) {
            Token op = next();
            Expression right = parseFactor();
            result = new BinaryExpression(result, op.type == TokenType.MULTIPLY ? Operator.MULTIPLY : Operator.DIVIDE, right);
        }
        return result;
    }

    private Expression parseFactor() {
        Expression result = parsePower();
        return result;
    }

    private Expression parsePower() {
        Expression base = parsePrimary();
        while (lookahead().type == TokenType.POWER) {
            Token op = next(); // consume '^'
            Expression exponent = parsePrimary(); // parse the exponent
            base = new BinaryExpression(base, Operator.POWER, exponent);
        }
        return base;
    }

    private Expression parsePrimary() {
        if (lookahead().type == TokenType.NUMBER) {
            Token num = next();
            return new NumericConstant(Double.parseDouble(num.text));
        } else if (lookahead().type == TokenType.IDENTIFIER) {
            Token var = next();
            return new Variable(var.text);
        } else if (lookahead().type == TokenType.LPAREN) {
            next(); // consume '('
            Expression expr = parseExpression();
            match(TokenType.RPAREN); // consume ')'
            return expr;
        }
        throw new RuntimeException("Unexpected token: " + lookahead().text);
    }

    private Token lookahead() {
        if (position < tokens.size()) {
            return tokens.get(position);
        }
        return new Token(TokenType.EOF, "");
    }

    private Token next() {
        Token token = lookahead();
        position++;
        return token;
    }

    private void match(TokenType expected) {
        Token token = next();
        if (token.type != expected) {
            throw new RuntimeException("Expected token " + expected + " but found " + token.type);
        }
    }
}