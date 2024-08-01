package org.example;

import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;

public class IntegerToRoman {
    private static TreeMap<Integer, String> intRomanMap = createIntToRomanMap();

    public static void main(String[] args){
        System.out.println("Enter an Integer : ");
        Scanner scanner = new Scanner(System.in);
        String strNum = scanner.nextLine();
        try{
            int intNum = Integer.parseInt(strNum);
            System.out.println("Roman Numeral: " + convertIntToRoman(intNum));
        }
        catch (NumberFormatException e){
            System.out.println("The number you entered is incorrect.");
        }




    }
    public static TreeMap<Integer,String> createIntToRomanMap(){
        TreeMap<Integer,String> intToRoman = new TreeMap<>();
        intToRoman.put(1,"I");
        intToRoman.put(4,"IV");
        intToRoman.put(5,"V");
        intToRoman.put(9,"IX");
        intToRoman.put(10,"X");
        intToRoman.put(40,"XL");
        intToRoman.put(50,"L");
        intToRoman.put(90,"XC");
        intToRoman.put(100,"C");
        intToRoman.put(400,"CD");
        intToRoman.put(500,"D");
        intToRoman.put(900,"CM");
        intToRoman.put(1000,"M");

        return intToRoman;

    }
    public static String convertIntToRoman(int intNumber){
        String roman = "";
        intRomanMap = createIntToRomanMap();
        for(int value : intRomanMap.descendingKeySet()){
            while(intNumber/value > 0){
                int multiply = intNumber/value;
                for(int i = 0; i<multiply;i++){
                    roman = roman + intRomanMap.get(value);
                }
                intNumber = intNumber % value;
            }
        }
        return roman;
    }
}
