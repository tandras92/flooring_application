package org.sg.flooring.enums;

import java.util.stream.Stream;

public enum LaminateType {
    SMOOTH("Smooth laminate flooring has no texture and is designed to resemble the look of polished woods, marble or ceramic-style flooring.", 3.50, 4.15),
    EMBOSSED("Embossed laminate flooring has a pressed pattern that lends a wood grain texture to the flooring.", 4.50, 4.15),
    HANDSCRAPED("Handscraped laminate flooring is patterned after antiqued wood looks and is sold in many colors.", 4.50, 3.15),
    GLOSS("Gloss level varies in laminate floors. You can purchase high gloss for a shiny look or low gloss if you prefer a matte look. There is no difference in durability between the two finishes, but matte floors tend to do a better job of hiding small scratches.", 8.50, 5.15),;

    private String description;
    private double costPerSqFt;
    private double laborCostPerSqFt;

    LaminateType(String description, double costPerSqFt, double laborCostPerSqFt) {
        this.description = description;
        this.costPerSqFt = costPerSqFt;
        this.laborCostPerSqFt = laborCostPerSqFt;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public double getCostPerSqFt() {
        return costPerSqFt;
    }

    public void setCostPerSqFt(double costPerSqFt) {
        this.costPerSqFt = costPerSqFt;
    }

    public double getLaborCostPerSqFt() {
        return laborCostPerSqFt;
    }

    public void setLaborCostPerSqFt(double laborCostPerSqFt) {
        this.laborCostPerSqFt = laborCostPerSqFt;
    }

    public static Stream<LaminateType> stream() {
        return Stream.of(LaminateType.values());
    }
}
