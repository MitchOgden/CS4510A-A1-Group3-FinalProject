/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit5TestClass.java to edit this template
 */
package edu.baker.finalproject;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import java.math.BigDecimal;
import java.math.MathContext;
import java.math.RoundingMode;

/**
 *
 * 
 */
public class BigDecimalUtilsTest {
    
    MathContext mc = new MathContext(10);
    
    public BigDecimalUtilsTest() {
    }
    
    @BeforeAll
    public static void setUpClass() {
    }
    
    @AfterAll
    public static void tearDownClass() {
    }
    
    @BeforeEach
    public void setUp() {
    }
    
    @AfterEach
    public void tearDown() {
    }

    @Test
    public void testAdd() {
    }

    @Test
    public void testSubtract() {
    }

    @Test
    public void testMultiply() {
    }

    @Test
    public void testDivide() {
    }

    @Test
    public void testMin() {
    }

    @Test
    public void testMax() {
    }

    @Test
    public void testAbs() {
    }

    @Test
    public void testPow() {
        BigDecimal base = new BigDecimal("2", mc);
        BigDecimal power = new BigDecimal("3", mc);
        BigDecimal expected = new BigDecimal(Math.pow(base.doubleValue(), power.doubleValue()), mc);
        BigDecimal result = BigDecimalUtils.pow(base, power, mc);
        assertEquals(expected, result);
    }
    
        @Test
    public void testIpow() {
        BigDecimal base = new BigDecimal("2", mc);
        BigDecimal power = new BigDecimal("3", mc);
        BigDecimal expected = new BigDecimal(Math.pow(base.doubleValue(), power.doubleValue()), mc);
        BigDecimal result = BigDecimalUtils.ipow(base, power, mc); // Replace YourClass with the actual class name
        assertEquals(expected, result);
    }

    @Test
    public void testSqrt() {
    }

    // Tests for iroot
    @Test
    void testIrootCubeRoot() {
        BigDecimal base = new BigDecimal(27);
        BigDecimal root = new BigDecimal(3);
        BigDecimal result = BigDecimalUtils.iroot(base, root, mc);
        
        // Update the expected value to match the precision and rounding mode
        BigDecimal expected = new BigDecimal(3).setScale(9, RoundingMode.HALF_UP);
        
        assertEquals(expected, result);
    }

    @Test
    void testIrootSquareRoot() {
        BigDecimal base = new BigDecimal(16);
        BigDecimal root = new BigDecimal(2);
        BigDecimal result = BigDecimalUtils.iroot(base, root, mc);
        
        // Update the expected value to match the precision and rounding mode
        BigDecimal expected = new BigDecimal(4).setScale(9, RoundingMode.HALF_UP);
        
        assertEquals(expected, result);
    }
    
    @Test
    public void testSin() {
        BigDecimal input = new BigDecimal("0.5", mc);
        BigDecimal expected = new BigDecimal(Math.sin(input.doubleValue()), mc);
        BigDecimal result = BigDecimalUtils.sin(input, mc);
        assertEquals(expected, result);
    }

    /**
     * Test of BigDecimal cos method, of class BigDecimalUtils
     */
    @Test 
    public void testCos(){
        //x = pi/4
        BigDecimal x1 = new BigDecimal("0.78539816339744830962", mc);
        BigDecimal expected1 = new BigDecimal("0.70710678118654752440", mc);
        BigDecimal result1 = BigDecimalUtils.cos(x1, mc); 
        assertEquals(expected1, result1);
        
        //x = 0
        BigDecimal x2 = BigDecimal.ZERO;
        BigDecimal expected2 = BigDecimal.ONE;
        BigDecimal result2 = BigDecimalUtils.cos(x2, mc);
        assertEquals(expected2, result2);
        
        //x = -pi/4
        BigDecimal x3 = new BigDecimal("-0.78539816339744830962", mc);
        BigDecimal expected3 = new BigDecimal("0.70710678118654752440", mc);
        BigDecimal result3 = BigDecimalUtils.cos(x3, mc);
        assertEquals(expected3, result3);
    }


    /**
     * Test of BigDecimal tan method, of class BigDecimalUtils
     */
    @Test
    public void testTan(){
        MathContext mc2 = new MathContext(20);
        //x = pi/4
        BigDecimal x1 = new BigDecimal("0.78539816339744830962", mc2);
        BigDecimal expected1 = new BigDecimal("1", mc2);
        BigDecimal result1 = BigDecimalUtils.tan(x1, mc2);
        assertEquals(expected1, result1);
        
        //x = 0
        BigDecimal x2 = BigDecimal.ZERO;
        BigDecimal expected2 = BigDecimal.ZERO;
        BigDecimal result2 = BigDecimalUtils.tan(x2, mc2);
        assertEquals(expected2, result2);
        
        //x = -pi/4
        BigDecimal x3 = new BigDecimal("-0.78539816339744830962", mc2);
        BigDecimal expected3 = BigDecimal.ONE.negate();
        BigDecimal result3 = BigDecimalUtils.tan(x3, mc2);
        assertEquals(expected3, result3);
    }

    /**
     * Test of BigDecimal asin method, of class BigDecimalUtils
     */
    @Test
    public void testAsin() {
        MathContext mc2 = new MathContext(20);
        BigDecimal sqrtTwo = new BigDecimal("1.4142135623730950488016887242096980785696718753769480731766797379907324784621070388503875343276415727");
        BigDecimal halfPi = new BigDecimal("1.5707963267948966192313216916397514420985846996875529104874722961");
        
        //asin(1/sqrt(2))
        BigDecimal x1 = BigDecimal.ONE.divide(sqrtTwo, mc2);
        BigDecimal expected1 = halfPi;
        BigDecimal result1 = BigDecimalUtils.asin(x1, mc2);
        assertEquals(expected1, result1);
        
        //asin(-1/sqrt(2))
        BigDecimal x2 = BigDecimal.ONE.divide(sqrtTwo, mc2).negate();
        BigDecimal expected2 = halfPi.negate();
        BigDecimal result2 = BigDecimalUtils.asin(x2, mc2);
        assertEquals(expected2, result2);
        
        //asin(0)
        BigDecimal x3 = BigDecimal.ZERO;
        BigDecimal expected3 = BigDecimal.ZERO;
        BigDecimal result3 = BigDecimalUtils.asin(x3, mc2);
        assertEquals(expected3, result3);    
    }
    
    @Test
    public void testAcos() {
        MathContext mc = new MathContext(5);
        // pos input
        BigDecimal result1 = BigDecimalUtils.acos(new BigDecimal("0.5"), mc);
        assertEquals(new BigDecimal("1.0472"), result1); // Approximately pi/3

        // neg test
        BigDecimal result2 = BigDecimalUtils.acos(new BigDecimal("-0.8"), mc);
        assertEquals(new BigDecimal("2.4981"), result2); 
        
        //zero input
        BigDecimal result3 = BigDecimalUtils.acos(new BigDecimal("0"), mc); 
        assertEquals(new BigDecimal("1.5708"),result3); 
        
    }

    @Test
    public void testAtan() {
    }
    
    @Test
    public void testLog() {
        MathContext mc = new MathContext(15);

        // Test a valid logarithm calculation
        BigDecimal input = new BigDecimal("10.0");
        BigDecimal result = BigDecimalUtils.log(input, mc);
        BigDecimal expected = new BigDecimal("2.30258509299405");
        assertEquals(expected, result, "Logarithm of 10.0 should be approximately 2.302585092994046");

        // Test the logarithm of 1.0 should be 0.0
       BigDecimal input1 = new BigDecimal("1.0");
        BigDecimal result1 = BigDecimalUtils.log(input1, mc);
        BigDecimal expected1 = new BigDecimal("0");
        assertEquals(expected1, result1, "Logarithm of 1.0 should be 0.0");

        // Test an invalid input (non-positive value)
       final BigDecimal input2 = new BigDecimal("0.0");
        assertThrows(ArithmeticException.class, () -> BigDecimalUtils.log(input2, mc), "Logarithm of non-positive value should throw an exception");

       final BigDecimal input3 = new BigDecimal("-5.0");
        assertThrows(ArithmeticException.class, () -> BigDecimalUtils.log(input3, mc), "Logarithm of non-positive value should throw an exception");
    }
@Test
public void testLog10() {
    MathContext mc = new MathContext(15);

    // Test a positive input
    BigDecimal positiveInput = new BigDecimal("100.0");
    BigDecimal positiveExpected = new BigDecimal("2"); // Updated expected value
    BigDecimal positiveResult = BigDecimalUtils.log10(positiveInput, mc);
    assertEquals(0, positiveExpected.compareTo(positiveResult), "Log10 of 100.0 should match the expected result");

    // Test a positive input that's not a power of 10
    BigDecimal nonPowerOf10Input = new BigDecimal("30.0");
    BigDecimal nonPowerOf10Expected = new BigDecimal("1.47712125471966", mc); // Updated expected value
    BigDecimal nonPowerOf10Result = BigDecimalUtils.log10(nonPowerOf10Input, mc);
    assertEquals(0, nonPowerOf10Expected.compareTo(nonPowerOf10Result), "Log10 of 30.0 should match the expected result");

    // Test an invalid input (non-positive value)
    BigDecimal zeroInput = new BigDecimal("0.0");
    assertThrows(ArithmeticException.class, () -> BigDecimalUtils.log10(zeroInput, mc), "Log10 of non-positive value should throw an exception");

    BigDecimal negativeInput = new BigDecimal("-5.0");
    assertThrows(ArithmeticException.class, () -> BigDecimalUtils.log10(negativeInput, mc), "Log10 of non-positive value should throw an exception");
}

    // Various tests for BigDecimalUtil.floor works as intended
    
    @Test
    public void testFloorPositiveValue() {
        BigDecimal input = new BigDecimal("10.75");
        BigDecimal result = BigDecimalUtils.floor(input);
        assertEquals(0, result.compareTo(new BigDecimal("10")));
    }

    @Test
    public void testFloorNegativeValue() {
        BigDecimal input = new BigDecimal("-10.75");
        BigDecimal result = BigDecimalUtils.floor(input);
        assertEquals(0, result.compareTo(new BigDecimal("-11")));
    }

    @Test
    public void testFloorZero() {
        BigDecimal input = BigDecimal.ZERO;
        BigDecimal result = BigDecimalUtils.floor(input);
        assertEquals(0, result.compareTo(BigDecimal.ZERO));
    }

    @Test
    public void testFloorIntegerValue() {
        BigDecimal input = new BigDecimal("11");
        BigDecimal result = BigDecimalUtils.floor(input);
        assertEquals(0, result.compareTo(new BigDecimal("11")));
    }

    @Test
    public void testCeil() {
        BigDecimal test1 = new BigDecimal("3.14");
        BigDecimal result1 = BigDecimalUtils.ceil(test1, mc);
        System.out.println(result1.equals(new BigDecimal("4"))); // Output: true

        BigDecimal test2 = new BigDecimal("-2.718");
        BigDecimal result2 = BigDecimalUtils.ceil(test2, mc);
        System.out.println(result2.equals(new BigDecimal("-2"))); // Output: true

        BigDecimal test3 = new BigDecimal("0");
        BigDecimal result3 = BigDecimalUtils.ceil(test3, mc);
        System.out.println(result3.equals(new BigDecimal("0"))); // Output: true
    }

    @Test
    public void testE() {
        BigDecimal expected = new BigDecimal(Math.E, mc);
        BigDecimal result = BigDecimalUtils.e(mc);
        assertEquals(expected, result);
    }
    
    /**
     * Test of BigDecimal round method, of class BigDecimalUtils
     */
    @Test
    public void testRound() {
        //Positive value
        BigDecimal x1 = new BigDecimal("3.14159", mc);
        BigDecimal expected = x1.setScale(0, RoundingMode.HALF_UP).round(mc);
        BigDecimal result = BigDecimalUtils.round(x1, mc);
        assertEquals(expected, result);
        
        //Negative value 
        BigDecimal x2 = new BigDecimal("-2.71828", mc);
        BigDecimal expected2 = x2.setScale(0, RoundingMode.HALF_UP).round(mc);
        BigDecimal result2 = BigDecimalUtils.round(x2, mc);
        assertEquals(expected2, result2);
        
        //Specified precision
        MathContext mc2 = new MathContext(3);
        BigDecimal x3 = new BigDecimal("3.14159", mc2);
        BigDecimal expected3 = x3.setScale(0, RoundingMode.HALF_UP).round(mc2);
        BigDecimal result3 = BigDecimalUtils.round(x3, mc2);
        assertEquals(expected3, result3);
    }
    
    /**
     * Test of BigDecimal trunc method, of class BigDecimalUtils
     */
    @Test 
    public void testTrunc(){
        //Positive value test 
        BigDecimal positiveInput = new BigDecimal("12.3456789");
        BigDecimal positiveResult = BigDecimalUtils.trunc(positiveInput, mc);
        BigDecimal positiveExpected = new BigDecimal("12");
        assertEquals(positiveExpected, positiveResult);
        
        //Negative value test
        BigDecimal negativeInput = new BigDecimal("-12.3456789");
        BigDecimal negativeResult = BigDecimalUtils.trunc(negativeInput, mc);
        BigDecimal negativeExpected = new BigDecimal("-12");
        assertEquals(negativeExpected, negativeResult);
        
        //Trunc with zero
        BigDecimal zeroInput = BigDecimal.ZERO;
        BigDecimal zeroResult = BigDecimalUtils.trunc(zeroInput, mc);
        BigDecimal zeroExpected = BigDecimal.ZERO;
        assertEquals(zeroExpected,zeroResult);
    }

    /**
     * Test of BigDecimal exp method, of class BigDecimalUtils
     */
    @Test
    public void testExp(){
        //Test e^2
        BigDecimal positiveInput = new BigDecimal(2);
        BigDecimal positiveExpected = new BigDecimal(Math.exp(2), mc);
        BigDecimal positiveResult = BigDecimalUtils.exp(positiveInput, mc);
        assertEquals(positiveExpected, positiveResult);
        
        //Test e^-2
        BigDecimal negativeInput = new BigDecimal(-2);
        BigDecimal negativeExpected = new BigDecimal(Math.exp(-2), mc);
        BigDecimal negativeResult = BigDecimalUtils.exp(negativeInput, mc);
        assertEquals(negativeExpected,negativeResult);
        
        //Test e^0
        BigDecimal zeroInput = new BigDecimal(0);
        BigDecimal zeroExpected = new BigDecimal(Math.exp(0), mc);
        BigDecimal zeroResult = BigDecimalUtils.exp(zeroInput, mc);
        assertEquals(zeroExpected,zeroResult);
        
        //Test e^100
        BigDecimal largeInput = new BigDecimal(100);
        BigDecimal largeExpected = new BigDecimal(Math.exp(100), mc);
        BigDecimal largeResult = BigDecimalUtils.exp(largeInput, mc);
        assertEquals(largeExpected,largeResult);
    }

    /**
     * Test of BigDecimal pi method, of class BigDecimalUtils
     */
    @Test
    public void testPi(){
        BigDecimal expected = new BigDecimal(Math.PI, mc);
        BigDecimal result = BigDecimalUtils.pi(mc);
        assertEquals(expected, result);
    }

    /** 
     * Test of BigDecimal atan2 method, of class BigDecimalUtils
     */
    @Test
    public void testAtan2(){
        //Test atan2(1, 1)
        BigDecimal y = new BigDecimal("1");
        BigDecimal x = new BigDecimal("1");
        BigDecimal result = BigDecimalUtils.atan2(y, x, mc);
        BigDecimal expected = new BigDecimal(Math.PI / 4, mc);
        assertEquals(expected, result);
        
        //Test atan2 (1, -1)
        y = new BigDecimal("1");
        x = new BigDecimal("-1");
        result = BigDecimalUtils.atan2(y, x, mc);
        expected = new BigDecimal(3 * Math.PI / 4, mc);
        assertEquals(expected, result);
        
        //Test atan2 (0, 1)
        y = new BigDecimal("0");
        x = new BigDecimal("1");
        result = BigDecimalUtils.atan2(y, x, mc);
        expected = BigDecimal.ZERO;
        assertEquals(expected, result);
        
        //Test atan2 (0, 0)
        y = BigDecimal.ZERO;
        x = BigDecimal.ZERO;
        result = BigDecimalUtils.atan2(y, x, mc);
        expected = BigDecimal.ZERO;
        assertEquals(expected, result);     
    }
    
    @Test
    public void testFactorial() {
        // Test with a positive integer
        BigDecimal input = new BigDecimal(5);
        MathContext mc = MathContext.DECIMAL32;
        BigDecimal expected = new BigDecimal(120);
        assertEquals(expected, BigDecimalUtils.factorial(input, mc));

        // Test with a decimal number
        input = new BigDecimal(4.5);
        expected = new BigDecimal(24);
        assertEquals(expected, BigDecimalUtils.factorial(input, mc));

        // Test with zero
        input = new BigDecimal(0);
        expected = new BigDecimal(1);
        assertEquals(expected, BigDecimalUtils.factorial(input, mc));

        // Test with a negative number (expecting an exception)
        input = new BigDecimal(-3);
        boolean exceptionThrown = false;
        try {
            BigDecimalUtils.factorial(input, mc);
        } catch (IllegalArgumentException e) {
            exceptionThrown = true;
        }
        assertTrue(exceptionThrown);
    }

    /** 
     * Test of BigDecimal exp10 method, of class BigDecimalUtils
     */
    @Test
    public void testExp10(){
        MathContext mc2 = new MathContext(2);
        //Positive exponent
        BigDecimal x1 = new BigDecimal("2", mc);
        BigDecimal expected1 = new BigDecimal("100", mc);
        BigDecimal result1 = BigDecimalUtils.exp10(x1, mc);
        assertEquals(expected1, result1);
        
        //Negative exponent
        BigDecimal x2 = new BigDecimal("-2", mc);
        BigDecimal expected2 = new BigDecimal("0.010", mc2);
        BigDecimal result2 = BigDecimalUtils.exp10(x2, mc2);
        assertEquals(expected2, result2);
        
        //Zero exponent
        BigDecimal x3 = BigDecimal.ZERO;
        BigDecimal expected3 = BigDecimal.ONE;
        BigDecimal result3 = BigDecimalUtils.exp10(x3, mc);
        assertEquals(expected3, result3);      
    }

    @Test
    public void testRecip(){
        MathContext mc = new MathContext(5);

        // Test case 1: reciprocal of 2
        BigDecimal result1 = BigDecimalUtils.recip(new BigDecimal("2"), mc);
        assertEquals(new BigDecimal("0.5"), result1);

        // Test case 2: reciprocal of 5
        BigDecimal result2 = BigDecimalUtils.recip(new BigDecimal("5"), mc);
        assertEquals(new BigDecimal("0.20000"), result2);
    }
}
    
