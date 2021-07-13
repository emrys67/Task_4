package com.foxminded.division;

import java.util.ArrayList;

public class Calculator {

    public CalculatorResult divide(int dividend, int divider) {
        checkZero(divider);
        int result = dividend / divider;
        var dto = new CalculatorResult(dividend, divider, result);
        dividend = Math.abs(dividend);
        divider = Math.abs(divider);
        var dividendString = String.valueOf(dividend);
        int currentNumber = getLeftDigit(dividendString);
        dividendString = destroyLeftDigit(dividendString);
        ArrayList<Step> stepList = new ArrayList<>();
        do {
            dividend = dividendStringToInt(dividend, dividendString);
            if (currentNumber < divider) {
                if (dividendString.length() > 0) {
                    currentNumber = currentNumber * 10 + getLeftDigit(dividendString);
                    dividendString = destroyLeftDigit(dividendString);
                } else {
                    stepList.add(new Step(String.valueOf(currentNumber)));
                    currentNumber = 0;
                }
            } else {
                stepList.add(new Step(String.valueOf(currentNumber), String.valueOf(currentNumber - currentNumber % divider)));
                currentNumber = currentNumber % divider;
            }
        } while (dividendString.length() > 0 || currentNumber > 0 || !stepList.get(stepList.size() - 1).isLast());
        dto.setStepList(stepList);
        return dto;
    }

    private int getLeftDigit(String digit) {
        return Integer.parseInt(String.valueOf(digit.toCharArray()[0]));
    }

    private String destroyLeftDigit(String digit) {
        return digit.substring(1);
    }

    private int dividendStringToInt(int dividend, String dividendString) {
        if (dividendString.length() > 0) {
            return Integer.parseInt(dividendString);
        } else {
            return dividend;
        }
    }

    private void checkZero(int divider) {
        if (divider == 0) {
            throw new IllegalArgumentException("Divided by 0");
        }
    }

}