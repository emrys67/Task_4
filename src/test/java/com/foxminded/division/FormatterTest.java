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
        formatter = new Formatter();
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
        String actual = formatter.buildString(calculator.divide(53,1));
        assertEquals(expected, actual);
    }
    @Test
    void divideNegativeInteger(){
        String expected =
                "_-78|10\n" +
                "  70|--\n" +
                "  --|-7\n" +
                "   8";
        String actual = formatter.buildString(calculator.divide(-78,10));
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
        String actual = formatter.buildString(calculator.divide(165,-5));
        assertEquals(expected, actual);
    }
    @Test
    void dividerEqualsToDivided(){
        String expected =
                "_165|165\n" +
                " 165|---\n" +
                " ---|1\n" +
                "   0";
        String actual = formatter.buildString(calculator.divide(165,165));
        assertEquals(expected, actual);
    }
    @Test
    void divideZeroByInteger(){
        String expected =
                "_0|165\n" +
                " 0|---\n" +
                " -|0";
        String actual = formatter.buildString(calculator.divide(0,165));
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
    void divideNegativeByNegative(){
        String expected =
                "_-150|-7\n" +
                "  14 |--\n" +
                "  -- |21\n" +
                "   10\n" +
                "    7\n" +
                "    -\n" +
                "    3";
        String actual = formatter.buildString(calculator.divide(-150,-7));
        assertEquals(expected, actual);
    }
    @Test
    void divideNegativeByInteger(){
        String expected =
                "_-150|7\n" +
                "  14 |---\n" +
                "  -- |-21\n" +
                "   10\n" +
                "    7\n" +
                "    -\n" +
                "    3";
        String actual = formatter.buildString(calculator.divide(-150,7));
        assertEquals(expected, actual);
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
