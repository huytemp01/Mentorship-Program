package org.example;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class RomanToInteger {
    private static Map<Character, Integer> romanIntMap = createRomanToIntMap();

    public static void main(String[] args) {
        System.out.println("Enter a Roman numeral: ");
        Scanner scanner = new Scanner(System.in);
        String roman = scanner.nextLine();
        if(RomanToInteger.validate(roman)){
            int number = RomanToInteger.convertRomanToInt(roman);
            System.out.println("Integer Number: " + number);
        }
        else{
            System.out.println("The number you entered is incorrect.");
        }
    }
    public static int convertRomanToInt(String roman){
        int intNumber = 0;
        for(int i = 0; i<roman.length()-1; i++){
            if(getIntValue(roman, i) >= getIntValue(roman, i+1)){
                intNumber = intNumber + getIntValue(roman, i);
            }
            else{
                intNumber = intNumber - getIntValue(roman, i);
            }
        }

        intNumber = intNumber + getIntValue(roman, roman.length()-1);

        return intNumber;
    }


    private static Integer getIntValue(String roman, int index){
        return romanIntMap.get(roman.charAt(index));
    }

    private static Map<Character, Integer> createRomanToIntMap(){
        Map<Character, Integer> romanToInt = new HashMap<>();
        romanToInt.put('I', 1);
        romanToInt.put('V', 5);
        romanToInt.put('X',10);
        romanToInt.put('L',50);
        romanToInt.put('C',100);
        romanToInt.put('D', 500);
        romanToInt.put('M', 1000);

        return romanToInt;
    }

    public static boolean validate(String roman) {
        boolean result = true;
        if(roman == null || roman.equals("")){
            result = false;
        }

        for(int i = 0; i<roman.length(); i++){
            if(romanIntMap.get(roman.charAt(i)) == null){
                result = false;
                break;
            }
        }

        return result;
    }
}
