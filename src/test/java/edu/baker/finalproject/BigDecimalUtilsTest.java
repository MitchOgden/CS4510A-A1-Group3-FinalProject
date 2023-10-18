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

    @Test
    public void testTan() {
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
    }
    
}
