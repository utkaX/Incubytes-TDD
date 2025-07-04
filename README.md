# 🧮 String Calculator - TDD Assignment

This project implements a String Calculator in Java following **Test-Driven Development (TDD)** principles as per the Incubyte assessment guidelines.

It includes full **JUnit 5 test coverage**, support for **custom delimiters**, **negative number handling**, and **multi-delimiter parsing**.

---

## 📌 Features Implemented

- ✅ Empty string returns `0`
- ✅ Single number returns that number
- ✅ Two numbers return their sum
- ✅ Any number of comma-separated numbers supported
- ✅ Supports newline (`\n`) as delimiter
- ✅ Supports custom single-character and multi-character delimiters
- ✅ Supports multiple custom delimiters
- ✅ Handles escaped characters as delimiters
- ✅ Throws exception on negative numbers
- ✅ Ignores numbers greater than 1000
- ✅ Handles edge cases like empty delimiter definition, whitespace, and no numbers

---

## 🔍 Test Cases with Input and Output

| Description                          | Input                                 | Output / Behavior                            |
|--------------------------------------|----------------------------------------|-----------------------------------------------|
| Empty string                         | `""`                                   | `0`                                            |
| Single number                        | `"1"`                                  | `1`                                            |
| Two numbers                          | `"1,5"`                                 | `6`                                            |
| Multiple numbers                     | `"1,2,3,4"`                             | `10`                                           |
| Newlines as delimiters              | `"1\n2,3"`                              | `6`                                            |
| Custom delimiter (single char)       | `"//;\n1;2"`                            | `3`                                            |
| Custom escaped delimiter             | `"//\\\n1\\2"`                          | `3`                                            |
| Tab delimiter                        | `"//\t\n1\t2\t3"`                       | `6`                                            |
| Quote delimiter                      | `"//\"\n1\"2\"3\"4"`                    | `10`                                           |
| Negative number                      | `"3,4,-8"`                              | ❌ Exception: `Negative numbers are not allowed` |
| Multiple negatives                   | `"-7,-9,-10,-11"`                       | ❌ Exception: `Negative numbers not allowed: -7, -9, -10, -11` |
| Ignore numbers > 1000               | `"1001,1,2,3,1"`                        | `7`                                            |
| Multiple custom delimiters          | `"//[***][;;][+++++]\n1***2+++++4;;1"` | `8`                                            |
| Custom delimiter with any length     | `"//[;;;]\n1;;;2;;;3"`                 | `6`                                            |
| Multiple multi-char delimiters       | `"//[;;;][===]\n1;;;20===5"`           | `26`                                           |
| Empty custom delimiter section       | `"//[]\n1241"`                          | `8` (treated as no delimiter)                 |
| Only delimiter defined, no numbers   | `"//;\n"`                               | `0`                                            |
| Delimiters with whitespace           | `" 1 , 2 , 3 "`                         | `6`                                            |
| Long delimiter name                  | `"//[delim123456789]\n5delim1234567895delim1234567895"` | `15` |

---

## 🧪 Test Coverage

> **Achieved:** ✅ 76.2% Test Coverage, ✅ 87.8% Main Coverage  
> Measured using: **JaCoCo** via Eclipse Coverage plugin or Maven

✅ `StringCalculator.java` — All branches and edge cases covered.  
✅ `StringCalculatorTest.java` — 20+ well-structured test methods.

---


🙏 Special thanks to Incubyte for this opportunity to apply Test-Driven Development principles and showcase clean coding practices through this engaging assignment.
