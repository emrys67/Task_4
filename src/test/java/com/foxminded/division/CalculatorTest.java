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
        String actual = calculator.divide(53, 1).getStepList().toString();
        ArrayList<Step> stepList = new ArrayList<>();
        stepList.add(new Step(String.valueOf(5), String.valueOf(5)));
        stepList.add(new Step(String.valueOf(3), String.valueOf(3)));
        stepList.add(new Step(String.valueOf(0)));
        calculatorResult.setStepList(stepList);
        String expected = calculatorResult.getStepList().toString();
        assertEquals(expected, actual);
    }

    @Test
    void divideNegativeInteger() {
        CalculatorResult calculatorResult = new CalculatorResult(-78, 10, -7);
        String actual = calculator.divide(-78, 10).getStepList().toString();
        ArrayList<Step> stepList = new ArrayList<>();
        stepList.add(new Step(String.valueOf(78), String.valueOf(70)));
        stepList.add(new Step(String.valueOf(8)));
        calculatorResult.setStepList(stepList);
        String expected = calculatorResult.getStepList().toString();
        assertEquals(expected, actual);
    }

    @Test
    void divideIntegerByNegative() {
        CalculatorResult calculatorResult = new CalculatorResult(165, -5, -33);
        String actual = calculator.divide(165, -5).getStepList().toString();
        ArrayList<Step> stepList = new ArrayList<>();
        stepList.add(new Step(String.valueOf(16), String.valueOf(15)));
        stepList.add(new Step(String.valueOf(15), String.valueOf(15)));
        stepList.add(new Step(String.valueOf(0)));
        calculatorResult.setStepList(stepList);
        String expected = calculatorResult.getStepList().toString();
        assertEquals(expected, actual);
    }

    @Test
    void dividerEqualsToDivided() {
        CalculatorResult calculatorResult = new CalculatorResult(165, 165, 1);
        String actual = calculator.divide(165, 165).getStepList().toString();
        ArrayList<Step> stepList = new ArrayList<>();
        stepList.add(new Step(String.valueOf(165), String.valueOf(165)));
        stepList.add(new Step(String.valueOf(0)));
        calculatorResult.setStepList(stepList);
        String expected = calculatorResult.getStepList().toString();
        assertEquals(expected, actual);
    }

    @Test
    void divideZeroByInteger() {
        CalculatorResult calculatorResult = new CalculatorResult(0, 165, 0);
        String actual = calculator.divide(0, 165).getStepList().toString();
        ArrayList<Step> stepList = new ArrayList<>();
        stepList.add(new Step(String.valueOf(0)));
        calculatorResult.setStepList(stepList);
        String expected = calculatorResult.getStepList().toString();
        assertEquals(expected, actual);
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
        String actual = calculator.divide(-150, -7).getStepList().toString();
        ArrayList<Step> stepList = new ArrayList<>();
        stepList.add(new Step(String.valueOf(15), String.valueOf(14)));
        stepList.add(new Step(String.valueOf(10), String.valueOf(7)));
        stepList.add(new Step(String.valueOf(3)));
        calculatorResult.setStepList(stepList);
        String expected = calculatorResult.getStepList().toString();
        assertEquals(expected, actual);
    }

    @Test
    void divideNegativeByInteger() {
        CalculatorResult calculatorResult = new CalculatorResult(-150, 7, -21);
        String actual = calculator.divide(-150, 7).getStepList().toString();
        ArrayList<Step> stepList = new ArrayList<>();
        stepList.add(new Step(String.valueOf(15), String.valueOf(14)));
        stepList.add(new Step(String.valueOf(10), String.valueOf(7)));
        stepList.add(new Step(String.valueOf(3)));
        calculatorResult.setStepList(stepList);
        String expected = calculatorResult.getStepList().toString();
        assertEquals(expected, actual);
    }

}
