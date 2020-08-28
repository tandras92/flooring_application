package org.sg.flooring.dtos.products.wood;

import org.sg.flooring.enums.*;

import java.math.BigDecimal;

public class Oak extends Wood {

    private Colors color;
    private Patterns pattern;
    private Textures texture;
    private String type;
    private String woodColor;
    private String woodPattern;
    private String woodTexture;
    private BigDecimal costPerSquareFt;
    private BigDecimal laborCostPerSquareFt;

    public Oak(Patterns pattern, Colors color, Textures texture, String woodColor, String woodPattern, String woodTexture, BigDecimal costPerSquareFt, BigDecimal laborCostPerSquareFt) {
        this.pattern = pattern;
        this.color = color;
        this.texture = texture;
        this.woodColor = woodColor;
        this.woodPattern = woodPattern;
        this.woodTexture = woodTexture;
        this.costPerSquareFt = costPerSquareFt;
        this.laborCostPerSquareFt = laborCostPerSquareFt;
    }

    @Override
    public String color() {
        woodColor = color.getColor();
        return woodColor;
    }

    @Override
    public String pattern() {
        woodPattern = pattern.getPattern();
        return woodPattern;
    }

    @Override
    public String texture() {
        woodTexture = texture.getTextureDescription();
        return woodTexture;
    }

    @Override
    public String productType() {
        return type = WoodType.OAK.toString();
    }

    @Override
    public BigDecimal costPerSquareFt() {
        return BigDecimal.valueOf(WoodType.OAK.getCostPerSqFt());
    }

    @Override
    public BigDecimal laborCostPerSquareFt() {
        return BigDecimal.valueOf(WoodType.OAK.getLaborCostPerSqFt());
    }
}
