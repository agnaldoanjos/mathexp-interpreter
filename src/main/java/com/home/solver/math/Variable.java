package com.home.solver.math;

import java.util.Map;

public class Variable implements Expression {
    private String name;

    public Variable(String name) {
        this.name = name;
    }

    @Override
    public double evaluate(Map<String, Double> context) {
        if (context.containsKey(name)) {
            return context.get(name);
        } else {
            throw new IllegalArgumentException("Variable " + name + " not defined");
        }
    }
}
