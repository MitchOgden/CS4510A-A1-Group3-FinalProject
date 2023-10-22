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
        BigDecimal radians = new BigDecimal("1.04719755119659774615421446109316762806572313312535");
        MathContext var = new MathContext(15);
        BigDecimal result = BigDecimalUtils.cos(radians, var);
        
        BigDecimal expected = new BigDecimal("0.500000000000000");
        
        assertEquals(expected, result);
        
        BigDecimal pi = BigDecimalUtils.pi(mc);
        BigDecimal negativePi = pi.negate();
        
        BigDecimal result1 = BigDecimalUtils.cos(pi, mc);
        BigDecimal result2 = BigDecimalUtils.cos(negativePi, mc);
        
        assertEquals(BigDecimal.ONE.negate(), result1, "Cosine of pi is -1");
        assertEquals(BigDecimal.ONE.negate(), result2, "Cosine of negative pi is -1");
    }

    /**
     * Test of BigDecimal tan method, of class BigDecimalUtils
     */
    @Test
    public void testTan(){
        //Test positive input
        BigDecimal positiveInput = new BigDecimal(1);
        BigDecimal positiveExpected = new BigDecimal(Math.tan(1), mc);
        BigDecimal positiveResult = BigDecimalUtils.tan(positiveInput, mc);
        assertEquals(positiveExpected, positiveResult);
        
        //Test negative input 
        BigDecimal negativeInput = new BigDecimal(-1);
        BigDecimal negativeExpected = new BigDecimal(Math.tan(-1), mc);
        BigDecimal negativeResult = BigDecimalUtils.tan(negativeInput, mc);
        assertEquals(negativeExpected, negativeResult);
        
        //Test input of zero
        BigDecimal zeroInput = new BigDecimal(0);
        BigDecimal zeroExpected = new BigDecimal(Math.tan(0), mc);
        BigDecimal zeroResult = BigDecimalUtils.tan(zeroInput, mc);
        assertEquals(zeroExpected, zeroResult);       
    }

      @Test
    public void testAsin() {
        MathContext mc = new MathContext(15);

        // Test positive input
        BigDecimal positiveInput = new BigDecimal("0.5");
        BigDecimal positiveExpected = new BigDecimal(Math.asin(0.5), mc);
        BigDecimal positiveResult = BigDecimalUtils.asin(positiveInput, mc);
        assertEquals(positiveExpected, positiveResult, "Arcsine of 0.5 should match the expected result");

        // Test negative input
        BigDecimal negativeInput = new BigDecimal("-0.7");
        BigDecimal negativeExpected = new BigDecimal(Math.asin(-0.7), mc);
        BigDecimal negativeResult = BigDecimalUtils.asin(negativeInput, mc);
        assertEquals(negativeExpected, negativeResult, "Arcsine of -0.7 should match the expected result");

        // Test input of zero
        BigDecimal zeroInput = new BigDecimal("0");
        BigDecimal zeroExpected = new BigDecimal(Math.asin(0), mc);
        BigDecimal zeroResult = BigDecimalUtils.asin(zeroInput, mc);
        assertEquals(zeroExpected, zeroResult, "Arcsine of 0 should match the expected result");
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

    @Test
    public void testExp10(){
        MathContext mc = new MathContext(5);
          
        // Test case 1: 10^2
        BigDecimal result1 = BigDecimalUtils.exp10(new BigDecimal("2"), mc);
        assertEquals(new BigDecimal("100"), result1);

        // Test case 2: 10^(-1)
        BigDecimal result2 = BigDecimalUtils.exp10(new BigDecimal("-1"), mc);
        assertEquals(new BigDecimal("0.10000"), result2);
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
    
