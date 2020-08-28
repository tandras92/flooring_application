package org.sg.flooring.enums;

public enum ProductType {
	CARPET(2.25, 2.10),
	LAMINATE(1.75, 2.10),
	TILE(3.50, 4.15),
	WOOD(5.15, 4.75);

	private double costPerSqFt;
	private double laborCostPerSqFt;

	ProductType(double costPerSqFt, double laborCostPerSqFt) {
		this.costPerSqFt = costPerSqFt;
		this.laborCostPerSqFt = laborCostPerSqFt;
	}

}
