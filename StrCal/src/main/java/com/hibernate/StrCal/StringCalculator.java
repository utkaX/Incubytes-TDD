package com.hibernate.StrCal;

import java.util.*;
import java.util.regex.*;

/**
 * Hello world!
 *
 */
public class StringCalculator 
{

    public int add(String input) {
        if (input == null || input.isEmpty()) return 0;

        List<String> delimiters = new ArrayList<>(Arrays.asList(",", "\n"));

        String numbers = input;

        if (input.startsWith("//")) {
            int newlineIndex = input.indexOf("\n");
            String delimiterSection = input.substring(2, newlineIndex);
            numbers = input.substring(newlineIndex + 1);

            // Handle multiple or single custom delimiters
            Matcher matcher = Pattern.compile("\\[(.*?)]").matcher(delimiterSection);
            while (matcher.find()) {
                delimiters.add(Pattern.quote(matcher.group(1)));
            }

            // If no brackets, single char delimiter like //;\n1;2
            if (delimiters.size() == 2) {
                delimiters.add(Pattern.quote(delimiterSection));
            }
        }

        String regex = String.join("|", delimiters);
        String[] tokens = numbers.split(regex);

        List<Integer> negatives = new ArrayList<>();
        int sum = 0;

        for (String token : tokens) {
            if (token.isEmpty()) continue;

            int num = Integer.parseInt(token.trim());
            if (num < 0) {
                negatives.add(num);
            } else if (num <= 1000) {
                sum += num;
            }
        }

        if (!negatives.isEmpty()) {
            throw new IllegalArgumentException("Negative numbers not allowed: " +
                    negatives.toString().replaceAll("[\\[\\]]", ""));
        }

        return sum;
    }

	
	
    public static void main( String[] args )
    {
    	  StringCalculator calc = new StringCalculator();
          String input = "//[+++][###][@@@]\n1+++2###3@@@4";
          int result = calc.add(input);
          System.out.println("Sum is: " + result);
    }
}
