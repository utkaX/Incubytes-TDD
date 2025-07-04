package com.hibernate.StrCal;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;


public class StringCalculatorTest
{
   StringCalculator sc=new StringCalculator();
   
   
   @Test void testEmptyStringReturnsZero() {
	   assertEquals(0,sc.add(""));
   }
   
   @Test void testSingleNumber() {
	   assertEquals(1,sc.add("1"));
   }
   
   @Test void testTwoNumbers() {
	   assertEquals(6,sc.add("1,5"));
   }
   
   @Test void testMultipleNumbers() {
	   assertEquals(6,sc.add("1\n2,3"));
   }
   
   @Test void testNewLineOnly() {
	   assertEquals(3,sc.add("1\n2"));
	   assertEquals(19,sc.add("6\n4\n9"));
   }
   
   
}
