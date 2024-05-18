package com.home.solver.math;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * The Lexer, or lexical analyzer, is responsible for reading the text input (the mathematical expression) and
 * converting it into a sequence of tokens. This conversion is based on defined rules that identify character patterns
 * that make up the different types of tokens.
 *
 * Responsibilities:
 *
 * Analyze the input string and identify and extract tokens.
 * Ignore whitespace or other delimiters that are not significant for syntactic analysis.
 * Generate a list of tokens that will be used by the parser.
 */
public class Lexer {
    private static final Pattern TOKEN_PATTERNS = Pattern.compile("\\s*(?:(\\d+\\.\\d*|\\d*\\.\\d+|\\d+)|([a-zA-Z_][a-zA-Z0-9_]*|:[a-zA-Z_][a-zA-Z0-9_]*)|(.))");

    public List<Token> tokenize(String input) {
        List<Token> tokens = new ArrayList<>();
        Matcher matcher = TOKEN_PATTERNS.matcher(input);

        while (matcher.find()) {
            if (matcher.group(1) != null) { // Number
                tokens.add(new Token(TokenType.NUMBER, matcher.group(1)));
            } else if (matcher.group(2) != null) { // Identifier or variable
                tokens.add(new Token(TokenType.IDENTIFIER, matcher.group(2)));
            } else if (matcher.group(3) != null) { // Operator or parenthesis
                tokens.add(new Token(TokenType.fromSymbol(matcher.group(3)), matcher.group(3)));
            }
        }
        return tokens;
    }
}
