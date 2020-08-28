package org.sg.flooring.enums;

import java.util.stream.Stream;

public enum Colors {
    NATURAL("natural"),
    RED("red"),
    BLUE("blue"),
    GREEN("green"),
    BEIGE("beige"),
    ORANGE("orange"),
    BLACK("black"),
    WHITE("white"),
    YELLOW("yellow"),
    VIOLET("violet"),
    NAVY("navy"),
    GREY("grey"),
    PINK("pink"),
    BROWN("brown"),
    LIGHT_BROWN("light brown"),
    CHOCOLATE_BROWN("chocolate brown"),
    RED_OAK("red oak"),
    WHITE_OAK("white oak");

    private String color;

    Colors(String color) {
        this.color = color;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public static Stream<Colors> stream() {
        return Stream.of(Colors.values());
    }
}
