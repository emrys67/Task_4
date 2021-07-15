package com.foxminded.division;

import java.util.Objects;

public class Step {
    private final int divided;
    private final int division;
    private final boolean last;

    public Step(int division, int divided) {
        this.divided = divided;
        this.division = division;
        last = false;
    }

    public Step(int division) {
        this.division = division;
        divided = 0;
        last = true;
    }

    public int getDivided() {
        return divided;
    }

    public int getDivision() {
        return division;
    }

    public boolean isLast() {
        return last;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Step step = (Step) o;
        return divided == step.divided && division == step.division && last == step.last;
    }

    @Override
    public int hashCode() {
        return Objects.hash(divided, division, last);
    }
}
