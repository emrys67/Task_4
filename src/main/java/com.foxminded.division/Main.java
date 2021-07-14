package com.foxminded.division;

public class Main {
    public static void main(String[] args) {
        Calculator calculator = new Calculator();
        Formatter formatter = new Formatter();
        IntegerDivision integerDivision = new IntegerDivision(formatter, calculator);
        System.out.println(integerDivision.getDivision(846554, 165));
    }
}
