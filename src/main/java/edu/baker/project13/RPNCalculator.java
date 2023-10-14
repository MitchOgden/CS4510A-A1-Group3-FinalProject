package edu.baker.project13;

import java.math.BigDecimal;
import java.math.MathContext;
import java.util.ArrayDeque;
import java.util.Deque;

public class RPNCalculator {
    private final Deque<BigDecimal> stack = new ArrayDeque<>();
    private final MathContext mathContext;

    public RPNCalculator(MathContext mathContext) {
        this.mathContext = mathContext;
    }

    public boolean isEmpty() {
        return stack.isEmpty();
    }

    public BigDecimal peek() {
        return stack.peek();
    }

    public BigDecimal peekY() {
        swap();
        BigDecimal y = stack.peek();
        swap();
        return y;
    }

    public void swap() {
        BigDecimal x = stack.pop();
        BigDecimal y = stack.pop();
        value(x);
        value(y);
    }

    public void rollDown() {
        stack.pop();
    }

    public void clear() {
        stack.clear();
    }

    public void value(BigDecimal v) {
        stack.push(v);
    }

    public void add() {
        value(stack.pop().add(stack.pop(), mathContext));
    }

    public void sub() {
        BigDecimal x = stack.pop();
        BigDecimal y = stack.pop();
        value(y.subtract(x, mathContext));
    }

    public void mult() {
        value(stack.pop().multiply(stack.pop(), mathContext));
    }

    public void div() {
        BigDecimal x = stack.pop();
        BigDecimal y = stack.pop();
        value(y.divide(x, mathContext));
    }

    public void min() {
        BigDecimal x = stack.pop();
        BigDecimal y = stack.pop();
        value(x.min(y));
    }

    public void max() {
        BigDecimal x = stack.pop();
        BigDecimal y = stack.pop();
        value(x.max(y));
    }

    public void abs() {
        value(stack.pop().abs(mathContext));
    }

    public void neg() {
        value(stack.pop().negate(mathContext));
    }

    public void floor() {
        value(BigDecimalUtils.floor(stack.pop()));
    }

    public void ceil() {
        value(BigDecimalUtils.ceil(stack.pop()));
    }

    public void round() {
        value(stack.pop().round(mathContext));
    }

    public void ipow() {
        BigDecimal x = stack.pop();
        BigDecimal y = stack.pop();
        value(BigDecimalUtils.pow(y, x.doubleValue(), mathContext));
    }

    public void pow() {
        BigDecimal x = stack.pop();
        BigDecimal y = stack.pop();
        value(BigDecimalUtils.pow(y, x.doubleValue(), mathContext));
    }
/*
    public void root() {
        BigDecimal x = stack.pop();
        BigDecimal y = stack.pop();
        value(BigDecimalUtils.pow(y, BigDecimal.ONE.divide(x, mathContext), mathContext));
    }
*/
    public void root() {
        BigDecimal x = stack.pop();
        BigDecimal y = stack.pop();
        // WARNING: This approach might lose precision
        value(BigDecimalUtils.pow(y, 1.0 / x.doubleValue(), mathContext));
    }

    public void exp() {
        value(BigDecimalUtils.pow(BigDecimal.valueOf(Math.E), stack.pop().doubleValue(), mathContext));
    }

    public void log() {
        value(BigDecimalUtils.log(stack.pop(), mathContext));
    }

    public void log10() {
        value(BigDecimalUtils.log10(stack.pop(), mathContext));
    }

    public void cos() {
        value(BigDecimalUtils.cos(stack.pop(), mathContext));
    }

    public void sin() {
        value(BigDecimalUtils.sin(stack.pop(), mathContext));
    }

    public void tan() {
        value(BigDecimalUtils.tan(stack.pop(), mathContext));
    }

    public void acos() {
        value(BigDecimalUtils.acos(stack.pop(), mathContext));
    }

    public void asin() {
        value(BigDecimalUtils.asin(stack.pop(), mathContext));
    }

    public void atan() {
        value(BigDecimalUtils.atan(stack.pop(), mathContext));
    }

    public void e() {
        value(BigDecimal.valueOf(Math.E));
    }

    public void π() {
        value(BigDecimal.valueOf(Math.PI));
    }

    void x() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    void y() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
}
