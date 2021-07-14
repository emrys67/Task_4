package com.foxminded.division;


import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

public class CalculatorTest {
    private Calculator calculator;

    @BeforeEach
    void setUp() {
        calculator = new Calculator();
    }

    @Test
    void divideIntegerByOne() {
        CalculatorResult calculatorResult = new CalculatorResult(53, 1, 53);
        CalculatorResult actual = calculator.divide(53, 1);
        ArrayList<Step> stepList = new ArrayList<>();
        stepList.add(new Step(String.valueOf(5), String.valueOf(5)));
        stepList.add(new Step(String.valueOf(3), String.valueOf(3)));
        stepList.add(new Step(String.valueOf(0)));
        calculatorResult.setStepList(stepList);
        assertEquals(calculatorResult, actual);
    }

    @Test
    void divideNegativeInteger() {
        CalculatorResult calculatorResult = new CalculatorResult(-78, 10, -7);
        CalculatorResult actual = calculator.divide(-78, 10);
        ArrayList<Step> stepList = new ArrayList<>();
        stepList.add(new Step(String.valueOf(78), String.valueOf(70)));
        stepList.add(new Step(String.valueOf(8)));
        calculatorResult.setStepList(stepList);
        assertEquals(calculatorResult, actual);
    }

    @Test
    void divideIntegerByNegative() {
        CalculatorResult calculatorResult = new CalculatorResult(165, -5, -33);
        CalculatorResult actual = calculator.divide(165, -5);
        ArrayList<Step> stepList = new ArrayList<>();
        stepList.add(new Step(String.valueOf(16), String.valueOf(15)));
        stepList.add(new Step(String.valueOf(15), String.valueOf(15)));
        stepList.add(new Step(String.valueOf(0)));
        calculatorResult.setStepList(stepList);
        assertEquals(calculatorResult, actual);
    }

    @Test
    void dividerEqualsToDivided() {
        CalculatorResult calculatorResult = new CalculatorResult(165, 165, 1);
        CalculatorResult actual = calculator.divide(165, 165);
        ArrayList<Step> stepList = new ArrayList<>();
        stepList.add(new Step(String.valueOf(165), String.valueOf(165)));
        stepList.add(new Step(String.valueOf(0)));
        calculatorResult.setStepList(stepList);
        assertEquals(calculatorResult, actual);
    }

    @Test
    void divideZeroByInteger() {
        CalculatorResult calculatorResult = new CalculatorResult(0, 165, 0);
        CalculatorResult actual = calculator.divide(0, 165);
        ArrayList<Step> stepList = new ArrayList<>();
        stepList.add(new Step(String.valueOf(0)));
        calculatorResult.setStepList(stepList);
        assertEquals(calculatorResult, actual);
    }

    @Test
    void divideIntegerByZero() {
        String expected = "Divided by 0";
        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            calculator.divide(163, 0);
        });
        String actual = exception.getMessage();
        assertTrue(actual.contains(expected));
    }

    @Test
    void divideNegativeByNegative() {
        CalculatorResult calculatorResult = new CalculatorResult(-150, -7, 21);
        CalculatorResult actual = calculator.divide(-150, -7);
        ArrayList<Step> stepList = new ArrayList<>();
        stepList.add(new Step(String.valueOf(15), String.valueOf(14)));
        stepList.add(new Step(String.valueOf(10), String.valueOf(7)));
        stepList.add(new Step(String.valueOf(3)));
        calculatorResult.setStepList(stepList);
        assertEquals(calculatorResult, actual);
    }

    @Test
    void divideNegativeByInteger() {
        CalculatorResult calculatorResult = new CalculatorResult(-150, 7, -21);
        CalculatorResult actual = calculator.divide(-150, 7);
        ArrayList<Step> stepList = new ArrayList<>();
        stepList.add(new Step(String.valueOf(15), String.valueOf(14)));
        stepList.add(new Step(String.valueOf(10), String.valueOf(7)));
        stepList.add(new Step(String.valueOf(3)));
        calculatorResult.setStepList(stepList);
        assertEquals(calculatorResult, actual);
    }

}
