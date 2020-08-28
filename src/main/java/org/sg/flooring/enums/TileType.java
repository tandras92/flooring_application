package org.sg.flooring.enums;

import java.util.stream.Stream;

public enum TileType {
    CERAMIC("Ceramic tile is one of the most common types of tile found in the home because it’s suitable for many applications.", 3.50, 4.15),
    PORCELAIN("The appeal of porcelain comes from its ability to emulate natural stone, brick, or wood—and without any of the maintenance.", 4.50, 4.15),
    GLASS("The stain resistance of glass makes it a fantastic alternative to natural stone. Red wine and any acidic foods like lemon and vinegar are wiped up with ease without any permanent staining.", 4.50, 3.15),
    CEMENT("Cement tiles are extremely versatile and can provide you with amazing patterns and colors.", 8.50, 5.15),
    MARBLE("Due to marble’s predisposition to scratches, etching, and stains, it’s best used in low-traffic areas unless a sealant is applied.", 4.25, 4.15),
    MOSAIC("Mosaic tiles work best on wall applications when an accent is needed. I recommend using them sparingly.", 4.25, 3.75),
    GRANITE("Granite is a natural stone that has a similar look and feel to marble because of its natural flecks.", 3.25, 4.15),
    LIMESTONE("To achieve a truly rustic style filled with natural tones, shades, and variation, lay down limestone tile,.", 3.25, 4.15),
    METAL("Although the cost for this type of tile is usually similar in pricing to natural stone, it will certainly withstand the test of time in both look and in function.", 3.25, 4.15),
    RESIN("These tiles look great and are water-resistant. Plus, they are perfect for the DIYer since you can make you own tile patterns.", 3.25, 4.15);

    private String description;
    private double costPerSqFt;
    private double laborCostPerSqFt;

    TileType(String description, double costPerSqFt, double laborCostPerSqFt) {
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

    public static Stream<TileType> stream() {
        return Stream.of(TileType.values());
    }
}
