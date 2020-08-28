package org.sg.flooring.dtos.products.tile;

import org.sg.flooring.enums.*;

import java.math.BigDecimal;

public class Ceramic extends Tile {

    private Colors color;
    private Patterns pattern;
    private Textures texture;
    private String type;
    private String tileColor;
    private String tilePattern;
    private String tileTexture;
    private BigDecimal costPerSquareFt;
    private BigDecimal laborCostPerSquareFt;

    public Ceramic(Patterns pattern, Colors color, Textures texture, String tileColor, String tilePattern, String tileTexture, BigDecimal costPerSquareFt, BigDecimal laborCostPerSquareFt) {
        this.pattern = pattern;
        this.color = color;
        this.texture = texture;
        this.tileColor = tileColor;
        this.tilePattern = tilePattern;
        this.tileTexture = tileTexture;
        this.costPerSquareFt = costPerSquareFt;
        this.laborCostPerSquareFt = laborCostPerSquareFt;
    }

    @Override
    public String color() {
        tileColor = color.getColor();
        return tileColor;
    }

    @Override
    public String pattern() {
        tilePattern = pattern.getPattern();
        return tilePattern;
    }

    @Override
    public String texture() {
        tileTexture = texture.getTextureDescription();
        return tileTexture;
    }

    @Override
    public String productType() {
        return type = TileType.CERAMIC.toString();
    }

    @Override
    public BigDecimal costPerSquareFt() {
        return BigDecimal.valueOf(TileType.CERAMIC.getCostPerSqFt());
    }

    @Override
    public BigDecimal laborCostPerSquareFt() {
        return BigDecimal.valueOf(TileType.CERAMIC.getLaborCostPerSqFt());
    }
}
