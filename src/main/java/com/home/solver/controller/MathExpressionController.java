package com.home.solver.controller;

import com.home.solver.math.Expression;
import com.home.solver.math.Lexer;
import com.home.solver.math.Parser;
import com.home.solver.math.Token;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.http.ResponseEntity;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/v1/math")
public class MathExpressionController {

    @PostMapping("/evaluate")
    public ResponseEntity<String> evaluateExpression(@RequestBody Map<String, Object> payload) {
        try {
            String expression = (String) payload.get("expression");
            Map<String, Double> variables = (Map<String, Double>) payload.get("variables");
            Lexer lexer = new Lexer();
            List<Token> tokens = lexer.tokenize(expression);

            Parser parser = new Parser(tokens);

            Expression expr = parser.parse();
            double result = expr.evaluate(variables);
            return ResponseEntity.ok(String.valueOf(result));
        } catch (Exception e) {
            return ResponseEntity.badRequest().body("Error in expression: " + e.getMessage());
        }
    }
}