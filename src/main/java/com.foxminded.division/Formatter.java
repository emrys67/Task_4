package com.foxminded.division;

import java.util.StringJoiner;

public class Formatter {
    private final Calculator calculate;

    public Formatter(Calculator calculate) {
        this.calculate = calculate;
    }

    public String buildS(int dividend, int divider) {
        StringJoiner out = new StringJoiner("\n");
        String result = String.valueOf(calculate.getResult());
        int dividendLength = String.valueOf(dividend).length();
        int divided = Integer.parseInt(Calculator.getStepList().get(0).getDivided());
        int division = Integer.parseInt(Calculator.getStepList().get(0).getDivision());
        int offset = String.valueOf(division).length() - String.valueOf(division - divided).length();
        if (dividend < 0)
            offset++;
        out.add("_" + dividend + "|" + divider);
        if (String.valueOf(division).length() > String.valueOf(divided).length())
            offset++;
        out.add(addChar(offset, ' ') + divided + addChar(dividendLength - offset - String.valueOf(divided).length() + 1, ' ')
                + "|" + addChar(Math.max(result.length(), String.valueOf(divider).length()), '-'));
        out.add(addChar(offset, ' ') + addChar(String.valueOf(divided).length(), '-')
                + addChar(dividendLength - offset - String.valueOf(divided).length() + 1, ' ') + "|" + result);

        for (var i = 1; i < Calculator.getStepList().size(); i++) {
            divided = Integer.parseInt(Calculator.getStepList().get(i - 1).getDivided());
            division = Integer.parseInt(Calculator.getStepList().get(i - 1).getDivision());
            int difference = division - divided;
            if (difference == 0)
                offset = offset + String.valueOf(division).length() - String.valueOf(difference).length() + 1;
            else
                offset = offset + String.valueOf(divided).length() - String.valueOf(difference).length();
            if (Calculator.getStepList().get(i).isLast())
                out.add(addChar(offset, ' ') + Calculator.getStepList().get(i).getDivision());
            else {
                out.add(addChar(offset, ' ') + Calculator.getStepList().get(i).getDivision());
                if (Calculator.getStepList().get(i).getDivision().length() > Calculator.getStepList().get(i).getDivided().length())
                    offset++;
                out.add(addChar(offset, ' ') + Calculator.getStepList().get(i).getDivided());
                out.add(addChar(offset, ' ') + addChar(Calculator.getStepList().get(i).getDivided().length(), '-'));
            }
        }
        return out.toString();
    }

    String addChar(int times, char character) {
        var out = "";
        for (var i = 0; i < times; i++)
            out = out + character;
        return out;
    }
}
