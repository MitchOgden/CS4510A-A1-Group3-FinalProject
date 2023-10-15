package edu.baker.project13;

import java.math.BigDecimal;
import java.math.MathContext;
import java.util.ArrayDeque;
import java.util.Deque;

/**
 * RPNCalculator class for performing Reverse Polish Notation calculations.
 * Utilizes BigDecimal for arbitrary-precision arithmetic.
 */
public class RPNCalculator {
    
    // Stack to hold BigDecimal numbers for calculations
    private final Deque<BigDecimal> stack = new ArrayDeque<>();
    
    // MathContext object for controlling precision and rounding in BigDecimal operations
    private final MathContext mathContext;

    /**
     * Constructor to initialize the RPNCalculator with a MathContext.
     * @param mathContext MathContext for BigDecimal operations.
     */
    public RPNCalculator(MathContext mathContext) {
        this.mathContext = mathContext;
    }

    /**
     * Checks if the stack is empty.
     * @return boolean indicating if the stack is empty.
     */
    public boolean isEmpty() {
        return stack.isEmpty();
    }

    /**
     * Peeks at the top element of the stack without removing it.
     * @return Top element of the stack.
     */
    public BigDecimal peek() {
        return stack.peek();
    }

    /**
     * Swaps the top two elements of the stack.
     */
    public BigDecimal peekY() {
        swap();
        BigDecimal y = stack.peek();
        swap();
        return y;
    }

    /**
     * Swaps the top two elements of the stack.
     */
    public void swap() {
        BigDecimal x = stack.pop(); 
        BigDecimal y = stack.pop();
        value(x);
        value(y);
    }

    /**
     * Removes the top element from the stack.
     */
    public void rollDown() {
        stack.pop();
    }

    /**
     * Clears all elements from the stack.
     */
    public void clear() {
        stack.clear();
    }

    /**
     * Pushes a BigDecimal value onto the stack.
     * @param v BigDecimal value to be pushed.
     */
    public void value(BigDecimal v) {
        stack.push(v);
    }

    /**
     * Adds the top two elements on the stack and pushes the result back onto the stack.
     */
    public void add() {
        value(BigDecimalUtils.add(stack.pop(), stack.pop(), mathContext));
    }

    /**
     * Subtracts the top element from the second top element on the stack and pushes the result back onto the stack.
     */
    public void sub() {
        BigDecimal x = stack.pop();
        BigDecimal y = stack.pop();
        value(BigDecimalUtils.subtract(x, y, mathContext));
    }

    /**
     * Multiplies the top two elements on the stack and pushes the result back onto the stack.
     */
    public void mult() {
        value(BigDecimalUtils.multiply(stack.pop(), stack.pop(), mathContext));
    }

    /**
     * Divides the second top element by the top element on the stack and pushes the result back onto the stack.
     */
    public void div() {
        BigDecimal x = stack.pop();
        BigDecimal y = stack.pop();
        value(BigDecimalUtils.divide(x, y, mathContext));
    }

    /**
     * Finds the minimum of the top two elements on the stack and pushes the result back onto the stack.
     */
    public void min() {
        BigDecimal x = stack.pop();
        BigDecimal y = stack.pop();
        value(BigDecimalUtils.min(x, y));
    }

    /**
     * Finds the maximum of the top two elements on the stack and pushes the result back onto the stack.
     */
    public void max() {
        BigDecimal x = stack.pop();
        BigDecimal y = stack.pop();
        value(BigDecimalUtils.max(x,y));
    }

    /**
     * Finds the absolute value of the top element on the stack and pushes the result back onto the stack.
     */
    public void abs() {
        value(stack.pop().abs(mathContext));
    }

    /**
     * Negates the top element on the stack and pushes the result back onto the stack.
     */
    public void neg() {
        value(stack.pop().negate(mathContext));
    }

    /**
     * Rounds the top element on the stack down to the nearest integer and pushes the result back onto the stack.
     */
    public void floor() {
        value(BigDecimalUtils.floor(stack.pop()));
    }

    /**
     * Rounds the top element on the stack up to the nearest integer and pushes the result back onto the stack.
     */
    public void ceil() {
        value(BigDecimalUtils.ceil(stack.pop()));
    }

    /**
     * Rounds the top element on the stack to the nearest integer and pushes the result back onto the stack.
     */
    public void round() {
        value(stack.pop().round(mathContext));
    }

    /**
     * Raises the second top element on the stack to the power of the top element and pushes the result back onto the stack.
     */
    public void ipow() {
        BigDecimal x = stack.pop();
        BigDecimal y = stack.pop();
        value(BigDecimalUtils.pow(y, x, mathContext));
    }

    /**
     * Raises the second top element on the stack to the power of the top element and pushes the result back onto the stack.
     */
    public void pow() {
        BigDecimal x = stack.pop();
        BigDecimal y = stack.pop();
        value(BigDecimalUtils.pow(y, x, mathContext));
    }
    
    
/*
    public void root() {
        BigDecimal x = stack.pop();
        BigDecimal y = stack.pop();
        value(BigDecimalUtils.pow(y, BigDecimal.ONE.divide(x, mathContext), mathContext));
    }
*/
    
    /**
     * Calculates the root of the second top element on the stack using the top element as the root value and pushes the result back onto the stack.
     */
    public void root() {
        BigDecimal x = stack.pop();
        BigDecimal y = stack.pop();
        // WARNING: This approach might lose precision
        value(BigDecimalUtils.iroot(y, x, mathContext));
    }

    /**
     * Calculates the exponential function of the top element on the stack and pushes the result back onto the stack.
     */
    public void exp() {
        value(BigDecimalUtils.exp10(stack.pop(), mathContext));
    }

    /**
     * Calculates the natural logarithm of the top element on the stack and pushes the result back onto the stack.
     */
    public void log() {
        value(BigDecimalUtils.log(stack.pop(), mathContext));
    }

    /**
     * Calculates the base-10 logarithm of the top element on the stack and pushes the result back onto the stack.
     */
    public void log10() {
        value(BigDecimalUtils.log10(stack.pop(), mathContext));
    }

    /**
     * Calculates the cosine of the top element on the stack and pushes the result back onto the stack.
     */
    public void cos() {
        value(BigDecimalUtils.cos(stack.pop(), mathContext));
    }

    /**
     * Calculates the sine of the top element on the stack and pushes the result back onto the stack.
     */
    public void sin() {
        value(BigDecimalUtils.sin(stack.pop(), mathContext));
    }

    /**
     * Calculates the tangent of the top element on the stack and pushes the result back onto the stack.
     */
    public void tan() {
        value(BigDecimalUtils.tan(stack.pop(), mathContext));
    }

    /**
     * Calculates the arccosine of the top element on the stack and pushes the result back onto the stack.
     */
    public void acos() {
        value(BigDecimalUtils.acos(stack.pop(), mathContext));
    }

    /**
     * Calculates the arcsine of the top element on the stack and pushes the result back onto the stack.
     */
    public void asin() {
        value(BigDecimalUtils.asin(stack.pop(), mathContext));
    }

    /**
     * Calculates the arctangent of the top element on the stack and pushes the result back onto the stack.
     */
    public void atan() {
        value(BigDecimalUtils.atan(stack.pop(), mathContext));
    }

    /**
     * Pushes the constant e onto the stack.
     */
    public void e() {
        value(BigDecimalUtils.e(mathContext));
    }

    /**
     * Pushes the constant π (Pi) onto the stack.
     */
    public void π() {
        value(BigDecimalUtils.pi(mathContext));
    }

    /**
     * Placeholder for future implementation related to variable x.
     */
    void x() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    /**
     * Placeholder for future implementation related to variable y.
     */
    void y() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
}
