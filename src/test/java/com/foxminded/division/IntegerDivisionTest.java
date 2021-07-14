package com.foxminded.division;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class IntegerDivisionTest {

    private CalculatorResult calculatorResult;
    @Mock
    Calculator calculator;
    @Mock
    Formatter formatter;

    @BeforeEach
    void setUp() {
        calculatorResult = new CalculatorResult(1, 1, 1);
    }

    @Test
    void divide() {
        when(calculator.divide(1, 1)).thenReturn(calculatorResult);
        when(formatter.buildString(calculatorResult)).thenReturn(new String());
        calculator.divide(1, 1);
        formatter.buildString(calculatorResult);
        Mockito.verify(calculator).divide(1, 1);
        Mockito.verify(formatter).buildString(calculatorResult);
    }
}
