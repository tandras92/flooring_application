package org.sg.flooring.enums;

import java.util.stream.Stream;

public enum Patterns {
    SOLID("solid"),
    GEOMETRIC("geometric"),
    TONAL("tonal"),
    LINEAR("linear"),
    STRIPED("striped");

    private String pattern;

    Patterns(String pattern) {
        this.pattern = pattern;
    }

    public String getPattern() {
        return pattern;
    }

    public void setPattern(String pattern) {
        this.pattern = pattern;
    }

    public static Stream<Patterns> stream() {
        return Stream.of(Patterns.values());
    }
}
