package edu.baker.finalproject;

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
        // return a.add(b, mc);
        return BigDecimal.ZERO;
    }

    /**
     * Subtracts the second BigDecimal number from the first.
     * @param a First number.
     * @param b Second number.
     * @param mc MathContext for precision.
     * @return a - b.
     */
    public static BigDecimal subtract(BigDecimal a, BigDecimal b, MathContext mc) {
        // return a.subtract(b, mc);
        return BigDecimal.ZERO;
    }

    /**
     * Multiplies two BigDecimal numbers.
     * @param a First number.
     * @param b Second number.
     * @param mc MathContext for precision.
     * @return a * b.
     */
    public static BigDecimal multiply(BigDecimal a, BigDecimal b, MathContext mc) {
        // return a.multiply(b, mc);
        return BigDecimal.ZERO;
    }

    /**
     * Divides the first BigDecimal number by the second.
     * @param a First number.
     * @param b Second number.
     * @param mc MathContext for precision.
     * @return a / b.
     */
    public static BigDecimal divide(BigDecimal a, BigDecimal b, MathContext mc) {
        // return a.divide(b, mc);
        return BigDecimal.ZERO;
    }

    /**
     * Returns the minimum of two BigDecimal numbers.
     * @param a First number.
     * @param b Second number.
     * @return Minimum of a and b.
     */
    public static BigDecimal min(BigDecimal a, BigDecimal b) {
        // return a.min(b);
        return BigDecimal.ZERO;
    }

    /**
     * Returns the maximum of two BigDecimal numbers.
     * @param a First number.
     * @param b Second number.
     * @return Maximum of a and b.
     */
    public static BigDecimal max(BigDecimal a, BigDecimal b) {
        // return a.max(b);
        return BigDecimal.ZERO;
    }

    /**
     * Returns the absolute value of a BigDecimal number.
     * @param a The number.
     * @return Absolute value of a.
     */
    public static BigDecimal abs(BigDecimal a) {
        // return a.abs();
        return BigDecimal.ZERO;
    }

    /**
     * Raises a BigDecimal to the power of a double exponent.
     * @param base The base number.
     * @param exponent The exponent.
     * @param mc MathContext for precision.
     * @return base raised to the power of exponent.
     */
    public static BigDecimal pow(BigDecimal base, BigDecimal exponent, MathContext mc) {
        double baseDouble = base.doubleValue();
        double powerDouble = exponent.doubleValue();
        double resultDouble = Math.pow(baseDouble, powerDouble);
        return new BigDecimal(resultDouble, mc);
    }

    /**
     * Computes the square root of a BigDecimal number.
     * @param value The number to find the square root of.
     * @param mc MathContext for precision.
     * @return Square root of value.
     */
    public static BigDecimal sqrt(BigDecimal value, MathContext mc) {
        // return value.sqrt(mc);
        return BigDecimal.ZERO;
    }

    /**
     * Computes the sine of a BigDecimal angle in radians.
     * @param value The angle in radians.
     * @param mc MathContext for precision.
     * @return Sine of value.
     */
    public static BigDecimal sin(BigDecimal value, MathContext mc) {
        double xDouble = value.doubleValue(); // Converting BigDecimal to double
        double sinValue = Math.sin(xDouble); // Using Math.sin to get the sine value
        return new BigDecimal(sinValue, mc); // Converting back to BigDecimal
    }

    /**
     * Computes the cosine of a BigDecimal angle in radians.
     * @param value The angle in radians.
     * @param mc MathContext for precision.
     * @return Cosine of value.
     */
    public static BigDecimal cos(BigDecimal value, MathContext mc) {
        // return new BigDecimal(Math.cos(value.doubleValue()), mc);
        return BigDecimal.ZERO;
    }

    /**
     * Computes the tangent of a BigDecimal angle in radians.
     * @param x
     * @param mc MathContext for precision.
     * @return Tangent of value.
     */
    public static BigDecimal tan(BigDecimal x, MathContext mc) {
        //Convert BigDecimal arguments to doubles
        double convertToDouble = x.doubleValue();
        
        //Math.tan to calculate tangent
        double result = Math.tan(convertToDouble);
        
        //Convert back to BigDecimal
        return new BigDecimal(result, mc);
        
    }

    /**
     * Computes the arcsine of a BigDecimal value.
     * @param value The value.
     * @param mc MathContext for precision.
     * @return Arcsine of value.
     */
    public static BigDecimal asin(BigDecimal value, MathContext mc) {
        // return new BigDecimal(Math.asin(value.doubleValue()), mc);
        return BigDecimal.ZERO;
    }

    /**
     * Computes the arccosine of a BigDecimal value.
     * @param value The value.
     * @param mc MathContext for precision.
     * @return Arccosine of value.
     */
    public static BigDecimal acos(BigDecimal value, MathContext mc) {
        // return new BigDecimal(Math.acos(value.doubleValue()), mc);
        return BigDecimal.ZERO;
    }

    /**
     * Computes the arctangent of a BigDecimal value.
     * @param value The value.
     * @param mc MathContext for precision.
     * @return Arctangent of value.
     */
    public static BigDecimal atan(BigDecimal value, MathContext mc) {
        // return new BigDecimal(Math.atan(value.doubleValue()), mc);
        return BigDecimal.ZERO;

    }

    /**
     * Computes the natural logarithm of a BigDecimal value.
     * @param value The value.
     * @param mc MathContext for precision.
     * @return Natural logarithm of value.
     */
    public static BigDecimal log(BigDecimal value, MathContext mc) {
        // return new BigDecimal(Math.log(value.doubleValue()), mc);
        return BigDecimal.ZERO;

    }

    /**
     * Computes the base-10 logarithm of a BigDecimal value.
     * @param value The value.
     * @param mc MathContext for precision.
     * @return Base-10 logarithm of value.
     */
    public static BigDecimal log10(BigDecimal value, MathContext mc) {
        // return new BigDecimal(Math.log10(value.doubleValue()), mc);
        return BigDecimal.ZERO;

    }

    /**
     * Rounds down a BigDecimal value to the nearest integer.
     * @param value The value to round down.
     * @return Rounded down value.
     */
    public static BigDecimal floor(BigDecimal value) {
        // Set the scale to 0 and use RoundingMode.FLOOR for rounding down.
        return value.setScale(0, RoundingMode.FLOOR);
    }

    /**
     * Rounds up a BigDecimal value to the nearest integer.
     * @param x
     * @return Rounded up value.
     */
    public static BigDecimal ceil(BigDecimal x) {
        // return value.setScale(0, RoundingMode.CEILING);
        double doubleValue = x.doubleValue();
        double ceilValue = Math.ceil(doubleValue);
        return new BigDecimal(ceilValue);
    }

    /**
     * Rounds a BigDecimal value to the nearest integer.
     * @param value The value to round.
     * @param mc
     * @return Rounded value.
     */
    public static BigDecimal round(BigDecimal value, MathContext mc) {
        double xDouble = value.doubleValue();
        BigDecimal rounded = new BigDecimal(Math.round(xDouble), mc);
        return rounded;
    }
    
    /**
    * Returns the reciprocal of a BigDecimal number.
    * @param x The number.
    * @param mc MathContext for precision.
    * @return Reciprocal of x.
    */
   public static BigDecimal recip(BigDecimal x, MathContext mc) {
       return BigDecimal.ZERO;
   }

    /**
    * Truncates a BigDecimal number.
    * @param x The number.
    * @param mc MathContext for precision.
    * @return Truncated value of x.
    */
   public static BigDecimal trunc(BigDecimal x, MathContext mc) {
       //Convert BigDecimal arguments to doubles
       double convertToDouble = x.doubleValue();
       
       //Math.floor for positive values, Math.ceil for negative value 
       double result = convertToDouble > 0 ? Math.floor(convertToDouble) : Math.ceil(convertToDouble);
       
       //Convert back to BigDecimal
       return new BigDecimal(result, mc);
   }
    
   /**
    * Raises a BigDecimal to the power of another BigDecimal exponent.
    * @param base The base number.
    * @param power The exponent.
    * @param mc MathContext for precision.
    * @return base raised to the power of exponent.
    */
   public static BigDecimal ipow(BigDecimal base, BigDecimal power, MathContext mc) {
       return BigDecimal.ZERO;
   }

   /**
    * Raises a BigDecimal to the power of a long exponent.
    * @param base The base number.
    * @param ipower The exponent.
    * @param mc MathContext for precision.
    * @return base raised to the power of exponent.
    */
   public static BigDecimal ipow(BigDecimal base, long ipower, MathContext mc) {
       return BigDecimal.ZERO;
   }

   /**
    * Computes the root of a BigDecimal number using another BigDecimal as the root value.
    * @param base The base number.
    * @param root The root value.
    * @param mc MathContext for precision.
    * @return base to the power of 1/root.
    */
   public static BigDecimal iroot(BigDecimal base, BigDecimal root, MathContext mc) {
       long longRoot = root.longValueExact(); // Will throw ArithmeticException if root is not an integer
       return iroot(base, longRoot, mc);
   }

   /**
    * Computes the root of a BigDecimal number using a long as the root value.
    * @param base The base number.
    * @param iroot The root value.
    * @param mc MathContext for precision.
    * @return base to the power of 1/root.
    */
   public static BigDecimal iroot(BigDecimal base, long iroot, MathContext mc) {
       if (iroot == 0) {
            throw new ArithmeticException("Zero root");
        }

        BigDecimal one = new BigDecimal(1, mc);
        BigDecimal n = new BigDecimal(iroot);
        BigDecimal n1 = new BigDecimal(iroot - 1);
        BigDecimal guess = base.divide(n, mc);
        BigDecimal previousGuess = BigDecimal.ZERO;
        BigDecimal tolerance = new BigDecimal("1E-" + mc.getPrecision(), mc);

        while (guess.subtract(previousGuess).abs().compareTo(tolerance) > 0) {
            previousGuess = guess;
            BigDecimal part1 = base.divide(guess.pow((int) (iroot - 1)), mc);
            BigDecimal part2 = n1.multiply(guess, mc);
            guess = part1.add(part2).divide(n, mc);
        }
        return guess;
   }

   /**
    * Computes 10 raised to the power of a BigDecimal number.
    * @param x The exponent.
    * @param mc MathContext for precision.
    * @return 10 raised to the power of x.
    */
   public static BigDecimal exp10(BigDecimal x, MathContext mc) {
       return BigDecimal.ZERO;
   }

   /**
    * Computes the arctangent of the quotient of its arguments.
    * @param y The y-coordinate.
    * @param x The x-coordinate.
    * @param mc MathContext for precision.
    * @return The angle whose tangent is y/x.
    */
   public static BigDecimal atan2(BigDecimal y, BigDecimal x, MathContext mc) {
       return BigDecimal.ZERO;
   }

   /**
    * Returns the mathematical constant e.
    * @param mc MathContext for precision.
    * @return The value of e.
    */
   public static BigDecimal e(MathContext mc) {
        double e = Math.exp(1.0); // Using Math.exp to get the value of e
        return new BigDecimal(e, mc); // Converting back to BigDecimal
   }

    /**
    * Returns the mathematical constant pi.
    * @param mc MathContext for precision.
    * @return The value of pi.
    */
   public static BigDecimal pi(MathContext mc) {
       //Math.PI to calculate pi
       double piValue = Math.PI;
       
       //Convert to BigDecimal
       return new BigDecimal(piValue, mc);
   }

   /**
    * Computes the factorial of a BigDecimal number.
    * @param x The number.
    * @param mc MathContext for precision.
    * @return x! (x factorial).
    */
   public static BigDecimal factorial(BigDecimal x, MathContext mc) {
       return BigDecimal.ZERO;
   }

    /**
    * Computes the exponential of a BigDecimal number.
    * @param x The base number.
    * @param mc MathContext for precision.
    * @return exponential of x.
    */
   public static BigDecimal exp(BigDecimal x, MathContext mc){
       //Covert BigDecimal arguments to double 
       double convertToDouble = x.doubleValue();
       
       //Math.exp to calculate the exponential 
       double result = Math.exp(convertToDouble);
       
       //Convert back to BigDecimal
       return new BigDecimal(result, mc);
   }
}
