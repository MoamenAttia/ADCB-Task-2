package com.adcb;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        // -------------------------------------------------------- //
        // This problem is solved using geometric sequence.
        // Result = initialArea * ( ( 1 - q ) ^ (n + 1) ) / ( 1 - q ).
        // -------------------------------------------------------- //

        final double COMMON_RATIO = 1.01 * 1.01;

        int numBlocks = (int) getNumber("Please enter integer number of blocks: ", 1, 1_000_000, true);
        // Assume the length and width are between [1, 1_000_000]
        double length = getNumber("Please enter length: ", 1, 1_000_000, false);
        double width = getNumber("Please enter width: ", 1, 1_000_000, false);

        BigDecimal initialArea = BigDecimal.valueOf(length * width);
        BigDecimal numerator = BigDecimal.valueOf(1).subtract(BigDecimal.valueOf(COMMON_RATIO).pow(numBlocks));
        BigDecimal denominator = BigDecimal.valueOf(1).subtract(BigDecimal.valueOf(COMMON_RATIO));
        BigDecimal result = initialArea.multiply(numerator).divide(denominator, 9, RoundingMode.DOWN);

        System.out.println("-----------------------------");
        System.out.println("Result: " + result);
    }

    /**
     * getNumber is used to validate the input from user before using it.
     *
     * @param prompt: A message to be displayed to the user while getting the value.
     * @param min:    to validate that the input is greater than the min.
     * @param max:    to validate that the input is lower than the max.
     * @param isInt:  to validate that the input is integer.
     * @return Number that entered from the user.
     */
    public static double getNumber(String prompt, double min, double max, boolean isInt) {
        double value = 0;
        while (true) {
            try {
                System.out.print(prompt);
                Scanner scanner = new Scanner(System.in);
                value = isInt ? scanner.nextInt() : scanner.nextDouble();
                // check if the value does not meet the requirements.
                if (value < min || value > max) {
                    System.out.println("Please Enter a value between " + min + " and " + max);
                    continue;
                }
                break;
            } catch (Exception ignored) {
                System.out.println("Invalid value");
            }
        }
        return value;
    }
}
