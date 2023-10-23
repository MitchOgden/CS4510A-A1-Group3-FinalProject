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
        return value.sqrt(mc);
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
     * @param x
     * @param mc MathContext for precision.
     * @return Cosine of value.
     */
    public static BigDecimal cos(BigDecimal x, MathContext mc) {
        x = x.abs();
        
        BigDecimal TWO_PI = new BigDecimal("6.2831853071795864769252867665590057683943387987502116419498891846", mc);
        while (x.compareTo(TWO_PI) > 0){
            x = x.subtract(TWO_PI, mc);
        }
        
        BigDecimal PI = new BigDecimal("3.1415926535897932384626433832795028841971693993751058209749445923", mc);
        while (x.compareTo(PI) > 0){
            x = x.subtract(PI, mc);
        }
        
        BigDecimal HALF_PI = new BigDecimal("1.5707963267948966192313216916397514420985846996875529104874722961", mc);
        if (x.compareTo(HALF_PI) > 0){
            BigDecimal xSquared = x.multiply(x, mc);
            BigDecimal result = BigDecimal.ONE;
            BigDecimal term = BigDecimal.ONE;
            BigDecimal sign = BigDecimal.ONE;
            for (int i = 2; i < 20; i += 2) {
                term = term.multiply(xSquared, mc);
                term = term.divide(BigDecimal.valueOf(i * (i - 1)), mc);
                term = term.negate().multiply(sign, mc);
                result = result.add(term, mc);
                sign = sign.negate();          
            }
            return result.round(mc);
        } else {
            BigDecimal xSquared = x.multiply(x, mc);
            BigDecimal result = BigDecimal.ONE;
            BigDecimal term = BigDecimal.ONE;
            BigDecimal sign = BigDecimal.ONE;
            for (int i = 2; i < 20; i += 2){
                term = term.multiply(xSquared, mc);
                term = term.divide(BigDecimal.valueOf(i * (i - 1)), mc);
                term = term.negate().multiply(sign, mc);
                result = result.add(term, mc);
                sign = sign.negate();
            }
            return result.round(mc);
        }
    }
    
     /**
     * Computes the tangent of a BigDecimal angle in radians.
     * @param x
     * @param mc MathContext for precision.
     * @return Tangent of value.
     */
    public static BigDecimal tan(BigDecimal x, MathContext mc) {
        BigDecimal sinX = sin(x, mc);
        BigDecimal cosX = cos(x, mc);
        
        if (cosX.compareTo(BigDecimal.ZERO) == 0){
            throw new ArithmeticException("Tangent is undefined for this value.");
        }
        return sinX.divide(cosX, mc);
    }

    /**
     * Computes the arcsine of a BigDecimal value.
     * @param value The value.
     * @param mc MathContext for precision.
     * @return Arcsine of value.
     */
public static BigDecimal asin(BigDecimal x, MathContext mc) {
    // Ensure x is within the range [-1, 1] as the arcsine is only defined in that range.
    if (x.compareTo(BigDecimal.ONE) > 0 || x.compareTo(BigDecimal.ONE.negate()) < 0) {
        throw new ArithmeticException("Arcsine is undefined for values outside the range [-1, 1].");
    }

    double result = Math.asin(x.doubleValue());
    return new BigDecimal(result, mc);
}

    /**
     * Computes the arccosine of a BigDecimal value.
     * @param value The value.
     * @param mc MathContext for precision.
     * @return Arccosine of value.
     */
    public static BigDecimal acos(BigDecimal x, MathContext mc) {
        //AK
        if (x.compareTo(BigDecimal.ONE) > 0 || x.compareTo(BigDecimal.ONE.negate()) < 0) {
            throw new IllegalArgumentException("Input must be in the range [-1, 1].");
        }

        double arccosine = Math.acos(x.doubleValue());
        
        return new BigDecimal(arccosine, mc);
        //AK END
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
public static BigDecimal log(BigDecimal x, MathContext mc) {
    // Ensure x is a positive number, as the logarithm is undefined for negative numbers and zero.
    if (x.compareTo(BigDecimal.ZERO) <= 0) {
        throw new ArithmeticException("Logarithm is undefined for non-positive values.");
    }
    
    double result = Math.log(x.doubleValue());
    return new BigDecimal(result, mc);
}

    /**
     * Computes the base-10 logarithm of a BigDecimal value.
     * @param value The value.
     * @param mc MathContext for precision.
     * @return Base-10 logarithm of value.
     */
 public static BigDecimal log10(BigDecimal x, MathContext mc) {
    // Ensure x is positive, as the logarithm is undefined for non-positive values.
    if (x.compareTo(BigDecimal.ZERO) <= 0) {
        throw new ArithmeticException("Logarithm base 10 is undefined for non-positive values.");
    }

    BigDecimal logX = log(x, mc);  // Calculate the natural logarithm of x
    BigDecimal log10 = new BigDecimal(Math.log(10.0), mc);  // Calculate the natural logarithm of 10

    // Calculate log10(x) by dividing log(x) by log(10)
    return logX.divide(log10, mc);
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
public static BigDecimal ceil(BigDecimal x, MathContext mc) {
    // Calculate the ceiling value with the specified MathContext
    BigDecimal scaledValue = x.setScale(mc.getPrecision() + 1, RoundingMode.CEILING);
    return scaledValue.setScale(mc.getPrecision(), RoundingMode.DOWN);
}

    /**
     * Rounds a BigDecimal value to the nearest integer.
     * @param x 
     * @param mc 
     * @return Rounded value.
     */
    public static BigDecimal round(BigDecimal x, MathContext mc) {
        return x.setScale(0, RoundingMode.HALF_UP).round(mc);
    }
    
    /**
    * Returns the reciprocal of a BigDecimal number.
    * @param x The number.
    * @param mc MathContext for precision.
    * @return Reciprocal of x.
    */
   public static BigDecimal recip(BigDecimal x, MathContext mc) {
       if(x.compareTo(BigDecimal.ZERO) == 0) {
           throw new ArithmeticException("Cannot calculate reciprocal of zero.");
       }

       BigDecimal reciprocal = BigDecimal.ONE.divide(x, mc);
       return new BigDecimal(reciprocal);
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
 public static BigDecimal pow(BigDecimal base, BigDecimal power, MathContext mc) {
        BigDecimal logBase = log(base,mc);
        BigDecimal logPower = logBase.multiply(power,mc);
        BigDecimal result = exp(logPower,mc);
        
        return result;
    
}

   /**
    * Raises a BigDecimal to the power of a long exponent.
    * @param base The base number.
    * @param ipower The exponent.
    * @param mc MathContext for precision.
    * @return base raised to the power of exponent.
    */
   public static BigDecimal ipow(BigDecimal base, long ipower, MathContext mc) {
       if (ipower < 0) {
            throw new IllegalArgumentException("Exponent must be non-negative.");
        }

        double ip = Math.pow(base.doubleValue(), ipower);

        return new BigDecimal(ip, mc);
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
       return pow(BigDecimal.TEN, x, mc);
   }

   /**
    * Computes the arctangent of the quotient of its arguments.
    * @param y The y-coordinate.
    * @param x The x-coordinate.
    * @param mc MathContext for precision.
    * @return The angle whose tangent is y/x.
    */
   public static BigDecimal atan2(BigDecimal y, BigDecimal x, MathContext mc) {
        if (x.compareTo(BigDecimal.ZERO) == 0) {
            if (y.compareTo(BigDecimal.ZERO) > 0) {
                return BigDecimalUtils.pi(mc).divide(new BigDecimal(2), mc); // pi/2
            } else {
                return BigDecimalUtils.pi(mc).divide(new BigDecimal(-2), mc); // -pi/2
            }
        } else {
            BigDecimal atanResult = BigDecimalUtils.atan(y.divide(x, mc), mc);
            if (x.compareTo(BigDecimal.ZERO) > 0) {
                return atanResult;
            } else {
                if (y.compareTo(BigDecimal.ZERO) >= 0) {
                    return atanResult.add(BigDecimalUtils.pi(mc), mc); // atan(y/x) + pi
                } else {
                    return atanResult.subtract(BigDecimalUtils.pi(mc), mc); // atan(y/x) - pi
                }
            }
        }
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
    // Convert the BigDecimal to a double
    double doubleX = x.doubleValue();

    if (doubleX < 0) {
        throw new IllegalArgumentException("Factorial is not defined for negative numbers");
    }

    // Calculate the factorial using double arithmetic
    double result = 1.0;
    for (int i = 2; i <= doubleX; i++) {
        result *= i;
    }

    // Convert the double result back to BigDecimal with the specified MathContext
    return new BigDecimal(result, mc);
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
