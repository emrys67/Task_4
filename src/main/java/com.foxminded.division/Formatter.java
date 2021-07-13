package com.foxminded.division;

import java.util.StringJoiner;

public class Formatter {
    private static final char DASH = '-';
    private static final char SPACE = ' ';
    private static final String NEW_LINE = "\n";
    private static final char UNDERSCORE = '_';
    private static final char VERTICAL_BAR = '|';

    public String buildString(CalculatorResult dto) {
        var head = buildHead(dto);
        var body = buildBody(dto, head);
        return body.toString();
    }

    private StringJoiner buildHead(CalculatorResult dto) {
        var out = new StringJoiner(NEW_LINE);
        int divided = dto.getDividend();
        if (!dto.getStepList().get(0).isLast()) {
            divided = Integer.parseInt(dto.getStepList().get(0).getDivided());
        }
        int offset = String.valueOf(dto.getStepList().get(0).getDivision()).length() - String.valueOf(dto.getStepList().get(0).getDivided()).length() + 1;
        if (dto.getDividend() < 0) {
            offset++;
        }
        out.add(UNDERSCORE + String.valueOf(dto.getDividend()) + VERTICAL_BAR + dto.getDivider());
        out.add(addChar(offset, SPACE) + divided + addChar(String.valueOf(dto.getDividend()).length() - offset - String.valueOf(divided).length() + 1, SPACE)
                + VERTICAL_BAR + addChar(Math.max(String.valueOf(dto.getResult()).length(), String.valueOf(dto.getDivider()).length()), DASH));
        out.add(addChar(offset, SPACE) + addChar(String.valueOf(divided).length(), DASH)
                + addChar(String.valueOf(dto.getDividend()).length() - offset - String.valueOf(divided).length() + 1, SPACE) + VERTICAL_BAR + dto.getResult());
        return out;
    }

    private StringJoiner buildBody(CalculatorResult dto, StringJoiner out) {
        int offset = String.valueOf(dto.getStepList().get(0).getDivision()).length() - String.valueOf(dto.getStepList().get(0).getDivided()).length() + 1;
        if (dto.getDividend() < 0) {
            offset++;
        }
        for (var i = 1; i < dto.getStepList().size(); i++) {
            var divided = Integer.parseInt(dto.getStepList().get(i - 1).getDivided());
            var division = Integer.parseInt(dto.getStepList().get(i - 1).getDivision());
            int difference = division - divided;
            if (difference == 0 && !dto.getStepList().get(i).isLast()) {
                offset = offset + String.valueOf(division).length() - String.valueOf(difference).length() + 1;
            } else {
                offset = offset + String.valueOf(divided).length() - String.valueOf(difference).length();
            }
            if (dto.getStepList().get(i).isLast()) {
                out.add(addChar(offset, SPACE) + dto.getStepList().get(i).getDivision());
            } else {
                out.add(addChar(offset, SPACE) + dto.getStepList().get(i).getDivision());
                if (dto.getStepList().get(i).getDivision().length() > dto.getStepList().get(i).getDivided().length()) {
                    offset++;
                }
                out.add(addChar(offset, SPACE) + dto.getStepList().get(i).getDivided());
                out.add(addChar(offset, SPACE) + addChar(dto.getStepList().get(i).getDivided().length(), DASH));
            }
        }
        return out;
    }

    private String addChar(int times, char character) {
        var out = "";
        for (var i = 0; i < times; i++)
            out = out + character;
        return out;
    }

}
