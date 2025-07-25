package com.hibernate.StrCal;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class StringCalculatorTest {
    StringCalculator sc = new StringCalculator();

    @Test void testEmptyStringReturnsZero() {
        assertEquals(0, sc.add(""));
    }

    @Test void testSingleNumber() {
        assertEquals(1, sc.add("1"));
    }

    @Test void testTwoNumbers() {
        assertEquals(6, sc.add("1,5"));
    }

    @Test void testMultipleNumbers() {
        assertEquals(6, sc.add("1\n2,3"));
    }

    @Test void testNewLineOnly() {
        assertEquals(3, sc.add("1\n2"));
        assertEquals(19, sc.add("6\n4\n9"));
    }

    @Test void TestCustomDelimiter() {
        assertEquals(3, sc.add("//;\n1;2"));
        assertEquals(6, sc.add("//\\t\\n1\\t2\\t3"));
        assertEquals(10, sc.add("//\"\n1\"2\"3\"4"));
        assertEquals(3, sc.add("//\\\n1\\2"));
    }

    @Test void testNegativeNumberWithException() {
        Exception e = assertThrows(IllegalArgumentException.class, () -> sc.add("3,4,-8"));
        assertEquals("Negative numbers are not allowed", e.getMessage());

        Exception e2 = assertThrows(IllegalArgumentException.class, () -> sc.add("-7,-9,-10,-11"));
        assertEquals("Negative numbers not allowed: -7, -9, -10, -11", e2.getMessage());
    }

    @Test void testNumbersGreaterThan1000Ignored() {
        assertEquals(7, sc.add("1001,1,2,3,1"));
        assertEquals(7, sc.add("1001\n1\n2\n3\n1"));
    }

    @Test void LongDelimiters() {
        assertEquals(6, sc.add("//[;;;]\n1;;;2;;;3"));
        assertEquals(8, sc.add("//[***]\n1***2***4***1"));
        assertEquals(26, sc.add("//[;;;][===]\n1;;;20===5"));
        assertEquals(8, sc.add("//[***][;;][+++++]\n1***2+++++4;;1"));
    }

    @Test void testEmptyCustomDelimiter() {
        assertEquals(8, sc.add("//[]\n1241"));
    }


    @Test void testWithWhitespaceAndTrimming() {
        assertEquals(6, sc.add(" 1 , 2 , 3 "));
    }

    @Test void testOnlyDelimiterNoNumbers() {
        assertEquals(0, sc.add("//;\n"));
    }

    @Test void testCustomSingleCharDelimiterWithoutBrackets() {
        assertEquals(9, sc.add("//#\n2#3#4"));
    }

    @Test void testMultipleNumbersWithSpaces() {
        assertEquals(10, sc.add(" 1, 2 ,3 , 4 "));
    }

    @Test void testVeryLongDelimiter() {
        assertEquals(15, sc.add("//[delim123456789]\n5delim1234567895delim1234567895"));
    }
}
