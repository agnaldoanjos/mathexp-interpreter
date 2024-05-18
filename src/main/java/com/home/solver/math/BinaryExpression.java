package com.home.solver.math;

import java.util.Map;

public class BinaryExpression implements Expression {
    private Expression left;
    private Operator operator;
    private Expression right;

    public BinaryExpression(Expression left, Operator operator, Expression right) {
        this.left = left;
        this.operator = operator;
        this.right = right;
    }

    @Override
    public double evaluate(Map<String, Double> context) {
        switch (operator) {
            case PLUS:
                return left.evaluate(context) + right.evaluate(context);
            case MINUS:
                return left.evaluate(context) - right.evaluate(context);
            case MULTIPLY:
                return left.evaluate(context) * right.evaluate(context);
            case DIVIDE:
                return left.evaluate(context) / right.evaluate(context);
            case POWER:
                return Math.pow(left.evaluate(context), right.evaluate(context));
            default:
                throw new IllegalStateException("Unexpected value: " + operator);
        }
    }
}