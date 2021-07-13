package com.foxminded.division;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class FormatterTest {
    private Formatter formatter;
    private Calculator calculator;
    private static final String NEW_LINE = "\n";

    @BeforeEach
    void setUp() {
        calculator = new Calculator();
        formatter = new Formatter();
    }

    @Test
    void divideIntegerByOne() {
        String expected =
                "_53|1" + NEW_LINE +
                        " 5 |--" + NEW_LINE +
                        " - |53" + NEW_LINE +
                        "  3" + NEW_LINE +
                        "  3" + NEW_LINE +
                        "  -" + NEW_LINE +
                        "  0";
        String actual = formatter.buildString(calculator.divide(53, 1));
        assertEquals(expected, actual);
    }

    @Test
    void divideNegativeInteger() {
        String expected =
                "_-78|10" + NEW_LINE +
                        "  70|--" + NEW_LINE +
                        "  --|-7" + NEW_LINE +
                        "   8";
        String actual = formatter.buildString(calculator.divide(-78, 10));
        assertEquals(expected, actual);
    }

    @Test
    void divideIntegerByNegative() {
        String expected =
                "_165|-5" + NEW_LINE +
                        " 15 |---" + NEW_LINE +
                        " -- |-33" + NEW_LINE +
                        "  15" + NEW_LINE +
                        "  15" + NEW_LINE +
                        "  --" + NEW_LINE +
                        "   0";
        String actual = formatter.buildString(calculator.divide(165, -5));
        assertEquals(expected, actual);
    }

    @Test
    void dividerEqualsToDivided() {
        String expected =
                "_165|165" + NEW_LINE +
                        " 165|---" + NEW_LINE +
                        " ---|1" + NEW_LINE +
                        "   0";
        String actual = formatter.buildString(calculator.divide(165, 165));
        assertEquals(expected, actual);
    }

    @Test
    void divideZeroByInteger() {
        String expected =
                "_0|165" + NEW_LINE +
                        " 0|---" + NEW_LINE +
                        " -|0";
        String actual = formatter.buildString(calculator.divide(0, 165));
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
        String expected =
                "_-150|-7" + NEW_LINE +
                        "  14 |--" + NEW_LINE +
                        "  -- |21" + NEW_LINE +
                        "   10" + NEW_LINE +
                        "    7" + NEW_LINE +
                        "    -" + NEW_LINE +
                        "    3";
        String actual = formatter.buildString(calculator.divide(-150, -7));
        assertEquals(expected, actual);
    }

    @Test
    void divideNegativeByInteger() {
        String expected =
                "_-150|7" + NEW_LINE +
                        "  14 |---" + NEW_LINE +
                        "  -- |-21" + NEW_LINE +
                        "   10" + NEW_LINE +
                        "    7" + NEW_LINE +
                        "    -" + NEW_LINE +
                        "    3";
        String actual = formatter.buildString(calculator.divide(-150, 7));
        assertEquals(expected, actual);
    }

}
