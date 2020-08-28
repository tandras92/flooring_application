package org.sg.flooring.dtos.products.laminate;

import org.sg.flooring.dtos.products.carpet.Carpet;
import org.sg.flooring.enums.CarpetType;
import org.sg.flooring.enums.Colors;
import org.sg.flooring.enums.Patterns;
import org.sg.flooring.enums.Textures;

import java.math.BigDecimal;

public class Smooth extends Carpet {

    private Colors color;
    private Patterns pattern;
    private Textures texture;
    private String type;
    private String carpetColor;
    private String carpetPattern;
    private String carpetTexture;
    private BigDecimal costPerSquareFt;
    private BigDecimal laborCostPerSquareFt;

    public Smooth(Patterns pattern, Colors color, Textures texture, String carpetColor, String carpetPattern, String carpetTexture, BigDecimal costPerSquareFt, BigDecimal laborCostPerSquareFt) {
        this.pattern = pattern;
        this.color = color;
        this.texture = texture;
        this.carpetColor = carpetColor;
        this.carpetPattern = carpetPattern;
        this.carpetTexture = carpetTexture;
        this.costPerSquareFt = costPerSquareFt;
        this.laborCostPerSquareFt = laborCostPerSquareFt;
    }

    @Override
    public String color() {
        carpetColor = color.getColor();
        return carpetColor;
    }

    @Override
    public String pattern() {
        carpetPattern = pattern.getPattern();
        return carpetPattern;
    }

    @Override
    public String texture() {
        carpetTexture = texture.getTextureDescription();
        return carpetTexture;
    }

    @Override
    public String productType() {
        return type = CarpetType.NYLON.toString();
    }

    @Override
    public BigDecimal costPerSquareFt() {
        return BigDecimal.valueOf(CarpetType.NYLON.getCostPerSqFt());
    }

    @Override
    public BigDecimal laborCostPerSquareFt() {
        return BigDecimal.valueOf(CarpetType.NYLON.getLaborCostPerSqFt());
    }
}
