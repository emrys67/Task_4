package com.foxminded.division;

public class IntegerDivision {
    private Formatter formatter;
    private Calculator calculator;

    public IntegerDivision(Formatter formatter, Calculator calculate) {
        this.formatter = formatter;
        this.calculator = calculate;
    }

    public String getDivision(int dividend, int divider) {
        CalculatorResult dto = calculator.divide(dividend, divider);
        return formatter.buildString(dto);
    }
}
