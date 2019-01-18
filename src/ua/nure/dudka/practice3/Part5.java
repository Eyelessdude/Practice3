package ua.nure.dudka.practice3;

import java.util.TreeMap;

public class Part5 {
    private static final TreeMap<Character, Integer> ROMAN_TO_DECIMAL = new TreeMap<>();
    private static final TreeMap<Integer, String> DECIMAL_TO_ROMAN = new TreeMap<>();
    private static final int NUMBERS_TO_CONVERT = 100;
    private static final int ROMAN_HUNDRED = 100;
    private static final int ROMAN_NINETY = 90;
    private static final int ROMAN_FIFTY = 50;
    private static final int ROMAN_FORTY = 40;

    static {
        DECIMAL_TO_ROMAN.put(ROMAN_HUNDRED, "C");
        DECIMAL_TO_ROMAN.put(ROMAN_NINETY, "XC");
        DECIMAL_TO_ROMAN.put(ROMAN_FIFTY, "L");
        DECIMAL_TO_ROMAN.put(ROMAN_FORTY, "XL");
        DECIMAL_TO_ROMAN.put(10, "X");
        DECIMAL_TO_ROMAN.put(9, "IX");
        DECIMAL_TO_ROMAN.put(5, "V");
        DECIMAL_TO_ROMAN.put(4, "IV");
        DECIMAL_TO_ROMAN.put(1, "I");

        ROMAN_TO_DECIMAL.put('C', ROMAN_HUNDRED);
        ROMAN_TO_DECIMAL.put('L', ROMAN_FIFTY);
        ROMAN_TO_DECIMAL.put('X', 10);
        ROMAN_TO_DECIMAL.put('V', 5);
        ROMAN_TO_DECIMAL.put('I', 1);
    }

    public static String decimal2Roman(int decimal) {
        int greatestValue = DECIMAL_TO_ROMAN.floorKey(decimal);
        if (decimal == greatestValue) {
            return DECIMAL_TO_ROMAN.get(decimal);
        }

        return DECIMAL_TO_ROMAN.get(greatestValue) + decimal2Roman(decimal - greatestValue);
    }

    public static int roman2Decimal(String decimal) {
        int resultDecimal = 0;
        int previousNumber = 0;

        for (int i = decimal.length() - 1; i >= 0; i--) {
            int temp = ROMAN_TO_DECIMAL.get(decimal.charAt(i));
            if (temp < previousNumber) {
                resultDecimal -= temp;
            } else {
                resultDecimal += temp;
            }
            previousNumber = temp;
        }

        return resultDecimal;
    }

    public static void main(String[] args) {
        for (int i = 1; i <= NUMBERS_TO_CONVERT; i++) {
            String romanNumber = decimal2Roman(i);
            System.out.println(i + " ====> " + romanNumber + " ====> " + roman2Decimal(romanNumber));
        }
    }
}
