package com.foxminded.division;

public class IntegerDivision {
    private static IntegerDivision integerDivision;
    private Formatter buildString;
    private Calculator calculate;

    public static IntegerDivision getInstance(){
        if(integerDivision==null)
            integerDivision = new IntegerDivision();
        return  integerDivision;
    }
    public String getDivision(int dividend, int divider){
        getCalculator().divide(dividend,divider);
        return getFormatter().buildString(dividend, divider);
    }

    private Formatter getFormatter() {
        if(buildString==null)
            buildString = new Formatter(getCalculator());
        return buildString;
    }

    private Calculator getCalculator() {
        if(calculate==null)
            calculate = new Calculator();
        return calculate;
    }
}
