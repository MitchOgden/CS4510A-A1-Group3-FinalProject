package edu.baker.project13;

import java.math.BigDecimal;
import java.math.MathContext;
import java.math.RoundingMode;

public class BigDecimalUtils {

    public static BigDecimal add(BigDecimal a, BigDecimal b, MathContext mc) {
        return a.add(b, mc);
    }

    public static BigDecimal subtract(BigDecimal a, BigDecimal b, MathContext mc) {
        return a.subtract(b, mc);
    }

    public static BigDecimal multiply(BigDecimal a, BigDecimal b, MathContext mc) {
        return a.multiply(b, mc);
    }

    public static BigDecimal divide(BigDecimal a, BigDecimal b, MathContext mc) {
        return a.divide(b, mc);
    }

    public static BigDecimal min(BigDecimal a, BigDecimal b) {
        return a.min(b);
    }

    public static BigDecimal max(BigDecimal a, BigDecimal b) {
        return a.max(b);
    }

    public static BigDecimal abs(BigDecimal a) {
        return a.abs();
    }

    // This method emulates the Math.pow method.
    public static BigDecimal pow(BigDecimal base, double exponent, MathContext mc) {
        return new BigDecimal(Math.pow(base.doubleValue(), exponent), mc);
    }

    public static BigDecimal sqrt(BigDecimal value, MathContext mc) {
        return value.sqrt(mc);
    }

    // Trigonometric functions - note that these are approximations because BigDecimal doesn't have native trig methods
    public static BigDecimal sin(BigDecimal value, MathContext mc) {
        return new BigDecimal(Math.sin(value.doubleValue()), mc);
    }

    public static BigDecimal cos(BigDecimal value, MathContext mc) {
        return new BigDecimal(Math.cos(value.doubleValue()), mc);
    }

    public static BigDecimal tan(BigDecimal value, MathContext mc) {
        return new BigDecimal(Math.tan(value.doubleValue()), mc);
    }

    // Inverse trigonometric functions
    public static BigDecimal asin(BigDecimal value, MathContext mc) {
        return new BigDecimal(Math.asin(value.doubleValue()), mc);
    }

    public static BigDecimal acos(BigDecimal value, MathContext mc) {
        return new BigDecimal(Math.acos(value.doubleValue()), mc);
    }

    public static BigDecimal atan(BigDecimal value, MathContext mc) {
        return new BigDecimal(Math.atan(value.doubleValue()), mc);
    }

    public static BigDecimal log(BigDecimal value, MathContext mc) {
        return new BigDecimal(Math.log(value.doubleValue()), mc);
    }

    public static BigDecimal log10(BigDecimal value, MathContext mc) {
        return new BigDecimal(Math.log10(value.doubleValue()), mc);
    }

    public static BigDecimal floor(BigDecimal value) {
        return value.setScale(0, RoundingMode.FLOOR);
    }

    public static BigDecimal ceil(BigDecimal value) {
        return value.setScale(0, RoundingMode.CEILING);
    }

    public static BigDecimal round(BigDecimal value) {
        return value.setScale(0, RoundingMode.HALF_UP);
    }

    // This can be expanded with other utility functions as required.
}
