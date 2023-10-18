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
    public void testSqrt() {
    }

    // Tests for iroot
    @Test
    void testIrootCubeRoot() {
        BigDecimal base = new BigDecimal(27);
        BigDecimal root = new BigDecimal(3);
        BigDecimal result = BigDecimalUtils.iroot(base, root, mc);
        assertEquals(new BigDecimal(3).setScale(mc.getPrecision(), mc.getRoundingMode()), result);
    }

    @Test
    void testIrootSquareRoot() {
        BigDecimal base = new BigDecimal(16);
        BigDecimal root = new BigDecimal(2);
        BigDecimal result = BigDecimalUtils.iroot(base, root, mc);
        assertEquals(new BigDecimal(4).setScale(mc.getPrecision(), mc.getRoundingMode()), result);
    }
    
    @Test
    public void testSin() {
        BigDecimal input = new BigDecimal("0.5", mc);
        BigDecimal expected = new BigDecimal(Math.sin(input.doubleValue()), mc);
        BigDecimal result = BigDecimalUtils.sin(input, mc);
        assertEquals(expected, result);
    }

    @Test
    public void testCos() {
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
    }

    @Test
    public void testAcos() {
    }

    @Test
    public void testAtan() {
    }

    @Test
    public void testLog() {
    }

    @Test
    public void testLog10() {
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
    
    @Test
    public void testRound() {
        BigDecimal x = new BigDecimal("3.14159", mc);
        BigDecimal expected = new BigDecimal(Math.round(x.doubleValue()), mc);
        BigDecimal result = BigDecimalUtils.round(x, mc);
        assertEquals(expected, result);
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
    
}
