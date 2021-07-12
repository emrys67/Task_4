package com.foxminded.division;

import java.util.ArrayList;

public class Calculator {
    private int result;
    private static final ArrayList<Step> stepList = new ArrayList<>();

    protected void divide(int dividend, int divider){
        if(!stepList.isEmpty())
            stepList.clear();
        if(divider == 0)
            throw new IllegalArgumentException("Divided by 0");
        dividend = Math.abs(dividend);
        divider = Math.abs(divider);
        String dividendd = String.valueOf(dividend);
        int currentNumber = getLeftDigit(dividendd);
        dividendd = destroyLeftDigit(dividendd);
        result = dividend/divider;
        while(dividendd.length() > 0 || currentNumber > 0){
            if(dividendd.length() > 0)
                dividend = Integer.parseInt(dividendd);
            if(currentNumber < divider && dividend < divider && dividendd.length() < 1){
                stepList.add(new Step(String.valueOf(currentNumber)));
                currentNumber = 0;
            }
            else if(currentNumber < divider){
                currentNumber = currentNumber * 10 + getLeftDigit(dividendd);
                dividendd = destroyLeftDigit(dividendd);
                if(currentNumber==0 && dividendd.length()==0)
                    stepList.add(new Step("0"));
            }
            else if(currentNumber / divider >= 1){
                stepList.add(new Step(String.valueOf(currentNumber),String.valueOf(currentNumber - currentNumber % divider)));
                currentNumber = currentNumber % divider;
            }
        }
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
