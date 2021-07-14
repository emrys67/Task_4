package com.foxminded.division;

import java.util.Objects;

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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Step step = (Step) o;
        return last == step.last && divided.equals(step.divided) && division.equals(step.division);
    }

    @Override
    public int hashCode() {
        return Objects.hash(divided, division, last);
    }
}
