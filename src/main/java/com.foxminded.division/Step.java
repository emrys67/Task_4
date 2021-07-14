package com.foxminded.division;

public class Step {
    private String divided;
    private final String division;
    private final boolean last;


    public Step(String division, String divided) {
        this.divided = divided;
        this.division = division;
        last = false;
    }

    public Step(String division) {
        this.division = division;
        divided = "0";
        last = true;
    }

    public String getDivided() {
        return divided;
    }

    public String getDivision() {
        return division;
    }

    public boolean isLast() {
        return last;
    }

    @Override
    public String toString() {
        return "Step{" +
                "divided='" + divided + '\'' +
                ", division='" + division + '\'' +
                ", last=" + last +
                '}';
    }
}
