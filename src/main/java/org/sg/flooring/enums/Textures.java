package org.sg.flooring.enums;

import java.util.stream.Stream;

public enum Textures {
    LEVEL_LOOP("consistent, uncut loop piles, tight overall texture;" +
            "Less soft, but won't show footprints or vacuum marks.  Great for high-traffic areas."),
    BERBER("A level loop pile made of thicker yarn that's typically a neutral" +
            " shade with flecks of color;  Durable, great for high-traffic areas, hides dirt and stains well."),
    CUT_LOOP_PILE("durable, good for both low and high-traffic areas.  The loops " +
            "are evenly cut");

    private String textureDescription;

    Textures(String textureDescription) {
        this.textureDescription = textureDescription;
    }

    public String getTextureDescription() {
        return textureDescription;
    }

    public void setDescription(String textureDescription) {
        this.textureDescription = textureDescription;
    }

    public static Stream<Textures> stream() {
        return Stream.of(Textures.values());
    }
}
