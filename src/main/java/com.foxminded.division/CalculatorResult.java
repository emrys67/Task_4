package com.foxminded.division;

import java.util.ArrayList;
import java.util.Objects;

public class CalculatorResult {
    private final int dividend;
    private final int divider;
    private final int result;
    private ArrayList<Step> stepList;

    public CalculatorResult(int dividend, int divider, int result) {
        this.dividend = dividend;
        this.divider = divider;
        this.result = result;
    }

    public ArrayList<Step> getStepList() {
        return stepList;
    }

    public int getDividend() {
        return dividend;
    }

    public int getDivider() {
        return divider;
    }

    public int getResult() {
        return result;
    }

    public void setStepList(ArrayList<Step> stepList) {
        this.stepList = stepList;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        CalculatorResult that = (CalculatorResult) o;
        return dividend == that.dividend && divider == that.divider && result == that.result && stepList.equals(that.stepList);
    }

    @Override
    public int hashCode() {
        return Objects.hash(dividend, divider, result, stepList);
    }
}
