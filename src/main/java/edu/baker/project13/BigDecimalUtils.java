package edu.baker.project13;

import java.math.BigDecimal;
import java.math.MathContext;
import java.math.RoundingMode;

/**
 * Utility class that provides BigDecimal-based mathematical operations.
 */
public class BigDecimalUtils {

    /**
     * Adds two BigDecimal numbers.
     * @param a First number.
     * @param b Second number.
     * @param mc MathContext for precision.
     * @return Sum of a and b.
     */
    public static BigDecimal add(BigDecimal a, BigDecimal b, MathContext mc) {
        return a.add(b, mc);
    }

    /**
     * Subtracts the second BigDecimal number from the first.
     * @param a First number.
     * @param b Second number.
     * @param mc MathContext for precision.
     * @return a - b.
     */
    public static BigDecimal subtract(BigDecimal a, BigDecimal b, MathContext mc) {
        return a.subtract(b, mc);
    }

    /**
     * Multiplies two BigDecimal numbers.
     * @param a First number.
     * @param b Second number.
     * @param mc MathContext for precision.
     * @return a * b.
     */
    public static BigDecimal multiply(BigDecimal a, BigDecimal b, MathContext mc) {
        return a.multiply(b, mc);
    }

    /**
     * Divides the first BigDecimal number by the second.
     * @param a First number.
     * @param b Second number.
     * @param mc MathContext for precision.
     * @return a / b.
     */
    public static BigDecimal divide(BigDecimal a, BigDecimal b, MathContext mc) {
        return a.divide(b, mc);
    }

    /**
     * Returns the minimum of two BigDecimal numbers.
     * @param a First number.
     * @param b Second number.
     * @return Minimum of a and b.
     */
    public static BigDecimal min(BigDecimal a, BigDecimal b) {
        return a.min(b);
    }

    /**
     * Returns the maximum of two BigDecimal numbers.
     * @param a First number.
     * @param b Second number.
     * @return Maximum of a and b.
     */
    public static BigDecimal max(BigDecimal a, BigDecimal b) {
        return a.max(b);
    }

    /**
     * Returns the absolute value of a BigDecimal number.
     * @param a The number.
     * @return Absolute value of a.
     */
    public static BigDecimal abs(BigDecimal a) {
        return a.abs();
    }

    /**
     * Raises a BigDecimal to the power of a double exponent.
     * @param base The base number.
     * @param exponent The exponent.
     * @param mc MathContext for precision.
     * @return base raised to the power of exponent.
     */
    public static BigDecimal pow(BigDecimal base, double exponent, MathContext mc) {
        return new BigDecimal(Math.pow(base.doubleValue(), exponent), mc);
    }

    /**
     * Computes the square root of a BigDecimal number.
     * @param value The number to find the square root of.
     * @param mc MathContext for precision.
     * @return Square root of value.
     */
    public static BigDecimal sqrt(BigDecimal value, MathContext mc) {
        return value.sqrt(mc);
    }

    /**
     * Computes the sine of a BigDecimal angle in radians.
     * @param value The angle in radians.
     * @param mc MathContext for precision.
     * @return Sine of value.
     */
    public static BigDecimal sin(BigDecimal value, MathContext mc) {
        return new BigDecimal(Math.sin(value.doubleValue()), mc);
    }

    /**
     * Computes the cosine of a BigDecimal angle in radians.
     * @param value The angle in radians.
     * @param mc MathContext for precision.
     * @return Cosine of value.
     */
    public static BigDecimal cos(BigDecimal value, MathContext mc) {
        return new BigDecimal(Math.cos(value.doubleValue()), mc);
    }

    /**
     * Computes the tangent of a BigDecimal angle in radians.
     * @param value The angle in radians.
     * @param mc MathContext for precision.
     * @return Tangent of value.
     */
    public static BigDecimal tan(BigDecimal value, MathContext mc) {
        return new BigDecimal(Math.tan(value.doubleValue()), mc);
    }

    /**
     * Computes the arcsine of a BigDecimal value.
     * @param value The value.
     * @param mc MathContext for precision.
     * @return Arcsine of value.
     */
    public static BigDecimal asin(BigDecimal value, MathContext mc) {
        return new BigDecimal(Math.asin(value.doubleValue()), mc);
    }

    /**
     * Computes the arccosine of a BigDecimal value.
     * @param value The value.
     * @param mc MathContext for precision.
     * @return Arccosine of value.
     */
    public static BigDecimal acos(BigDecimal value, MathContext mc) {
        return new BigDecimal(Math.acos(value.doubleValue()), mc);
    }

    /**
     * Computes the arctangent of a BigDecimal value.
     * @param value The value.
     * @param mc MathContext for precision.
     * @return Arctangent of value.
     */
    public static BigDecimal atan(BigDecimal value, MathContext mc) {
        return new BigDecimal(Math.atan(value.doubleValue()), mc);
    }

    /**
     * Computes the natural logarithm of a BigDecimal value.
     * @param value The value.
     * @param mc MathContext for precision.
     * @return Natural logarithm of value.
     */
    public static BigDecimal log(BigDecimal value, MathContext mc) {
        return new BigDecimal(Math.log(value.doubleValue()), mc);
    }

    /**
     * Computes the base-10 logarithm of a BigDecimal value.
     * @param value The value.
     * @param mc MathContext for precision.
     * @return Base-10 logarithm of value.
     */
    public static BigDecimal log10(BigDecimal value, MathContext mc) {
        return new BigDecimal(Math.log10(value.doubleValue()), mc);
    }

    /**
     * Rounds down a BigDecimal value to the nearest integer.
     * @param value The value to round down.
     * @return Rounded down value.
     */
    public static BigDecimal floor(BigDecimal value) {
        return value.setScale(0, RoundingMode.FLOOR);
    }

    /**
     * Rounds up a BigDecimal value to the nearest integer.
     * @param value The value to round up.
     * @return Rounded up value.
     */
    public static BigDecimal ceil(BigDecimal value) {
        return value.setScale(0, RoundingMode.CEILING);
    }

    /**
     * Rounds a BigDecimal value to the nearest integer.
     * @param value The value to round.
     * @return Rounded value.
     */
    public static BigDecimal round(BigDecimal value) {
        return value.setScale(0, RoundingMode.HALF_UP);
    }
}
