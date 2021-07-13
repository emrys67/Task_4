package com.foxminded.division;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class FormatterTest {
    private Formatter formatter;
    private Calculator calculator;

    @BeforeEach
    void setUp(){
        calculator = new Calculator();
        formatter = new Formatter(calculator);
    }
    @Test
    void divideIntegerByOne(){
        String expected =
                "_53|1\n" +
                " 5 |--\n" +
                " - |53\n" +
                "  3\n" +
                "  3\n" +
                "  -\n" +
                "  0";
        calculator.divide(53,1);
        String actual = formatter.buildString(53,1);
        assertEquals(expected, actual);
    }
    @Test
    void divideNegativeInteger(){
        String expected =
                "_-78|10\n" +
                "  70|--\n" +
                "  --|-7\n" +
                "   8";
        calculator.divide(-78,10);
        String actual = formatter.buildString(-78,10);
        assertEquals(expected, actual);
    }
    @Test
    void divideIntegerByNegative(){
        String expected =
                "_165|-5\n" +
                " 15 |---\n" +
                " -- |-33\n" +
                "  15\n" +
                "  15\n" +
                "  --\n" +
                "   0";
        calculator.divide(165,-5);
        String actual = formatter.buildString(165,-5);
        assertEquals(expected, actual);
    }
    @Test
    void divideIntegerByZero(){
        String expected = "Divided by 0";
        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            calculator.divide(163, 0);
        });
        String actual = exception.getMessage();
        assertTrue(actual.contains(expected));
    }
    @Test
    void addCharLetter(){
        assertEquals("hhhhh", formatter.addChar(5,'h'));
    }
    @Test
    void addCharDigit(){
        assertEquals("33333", formatter.addChar(5,'3'));
    }
    @Test
    void addCharSymbol(){
        assertEquals("#####", formatter.addChar(5,'#'));
    }
    @Test
    void addCharZeroTimes(){
        assertEquals("", formatter.addChar(0,'h'));
    }
}
