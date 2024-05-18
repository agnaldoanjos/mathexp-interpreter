package com.home.solver.math;

import java.util.Map;

public class NumericConstant implements Expression {
    private double value;

    public NumericConstant(double value) {
        this.value = value;
    }

    @Override
    public double evaluate(Map<String, Double> context) {
        return value;
    }
}