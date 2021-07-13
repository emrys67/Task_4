package com.foxminded.division;

import java.util.ArrayList;

public class Calculator {
    private int result;
    private static final ArrayList<Step> stepList = new ArrayList<>();

    public void divide(int dividend, int divider){
        if(!stepList.isEmpty())
            stepList.clear();
        if(divider == 0)
            throw new IllegalArgumentException("Divided by 0");
        result = dividend/divider;
        dividend = Math.abs(dividend);
        divider = Math.abs(divider);
        String dividendString = String.valueOf(dividend);
        int currentNumber = getLeftDigit(dividendString);
        dividendString = destroyLeftDigit(dividendString);
        do{
                if (dividendString.length() > 0)
                    dividend = Integer.parseInt(dividendString);
                if (currentNumber < divider && dividend < divider && dividendString.length() < 1) {   // Remainder of the last division is not 0
                    stepList.add(new Step(String.valueOf(currentNumber)));
                    currentNumber = 0;
                } else if (currentNumber < divider) {
                    if (currentNumber == 0 && dividendString.length() == 0) {                    // Remainder of the last division is 0
                        stepList.add(new Step("0"));
                        break;
                    }
                    currentNumber = currentNumber * 10 + getLeftDigit(dividendString);
                    dividendString = destroyLeftDigit(dividendString);
                } else if (currentNumber / divider >= 1) {
                    stepList.add(new Step(String.valueOf(currentNumber), String.valueOf(currentNumber - currentNumber % divider)));
                    currentNumber = currentNumber % divider;
                }
        }while(dividendString.length() > 0 || currentNumber > 0 || !stepList.get(stepList.size()-1).isLast());
    }

    private int getLeftDigit(String digit){
        return Integer.parseInt(String.valueOf(digit.toCharArray()[0]));
    }

    private String destroyLeftDigit(String digit){
        return digit.substring(1);
    }

    public int getResult() {
        return result;
    }

    public static ArrayList<Step> getStepList() {
        return stepList;
    }
}