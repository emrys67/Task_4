package com.foxminded.division;

import java.util.StringJoiner;

public class Formatter {

    public String buildString(CalculatorResult dto) {
        StringJoiner out = new StringJoiner("\n");
        String result = String.valueOf(dto.getResult());
        int dividendLength = String.valueOf(dto.getDividend()).length();
        int divided = dto.getDividend();
        if(!dto.getStepList().get(0).isLast()) {
            divided = Integer.parseInt(dto.getStepList().get(0).getDivided());
        }
        int division = Integer.parseInt(dto.getStepList().get(0).getDivision());
        int offset = String.valueOf(division).length()  - String.valueOf(divided).length() + 1;
        if (dto.getDividend() < 0) {
            offset++;
        }
        out.add("_" + dto.getDividend() + "|" + dto.getDivider());
        out.add(addChar(offset, ' ') + divided + addChar(dividendLength - offset - String.valueOf(divided).length() + 1, ' ')
                + "|" + addChar(Math.max(result.length(), String.valueOf(dto.getDivider()).length()), '-'));
        out.add(addChar(offset, ' ') + addChar(String.valueOf(divided).length(), '-')
                + addChar(dividendLength - offset - String.valueOf(divided).length() + 1, ' ') + "|" + result);

        for (var i = 1; i < dto.getStepList().size(); i++) {
            divided = Integer.parseInt(dto.getStepList().get(i - 1).getDivided());
            division = Integer.parseInt(dto.getStepList().get(i - 1).getDivision());
            int difference = division - divided;
            if (difference == 0 && !dto.getStepList().get(i).isLast()) {
                offset = offset + String.valueOf(division).length() - String.valueOf(difference).length() + 1;
            }
            else {
                offset = offset + String.valueOf(divided).length() - String.valueOf(difference).length();
            }
            if (dto.getStepList().get(i).isLast()) {
                out.add(addChar(offset, ' ') + dto.getStepList().get(i).getDivision());
            }
            else {
                out.add(addChar(offset, ' ') + dto.getStepList().get(i).getDivision());
                if (dto.getStepList().get(i).getDivision().length() > dto.getStepList().get(i).getDivided().length()) {
                    offset++;
                }
                out.add(addChar(offset, ' ') + dto.getStepList().get(i).getDivided());
                out.add(addChar(offset, ' ') + addChar(dto.getStepList().get(i).getDivided().length(), '-'));
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
