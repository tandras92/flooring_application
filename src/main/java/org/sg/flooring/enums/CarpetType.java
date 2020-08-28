package org.sg.flooring.enums;

public enum CarpetType {
// TODO: add description
    NYLON(2.25, 2.10),
    TRIEXTA(1.75, 2.10),
    POLYESTER(3.50, 4.15),
    WOOL(5.15, 4.75),
    OLEFIN(8.75, 4.50);

    private double costPerSqFt;
    private double laborCostPerSqFt;

    CarpetType(double costPerSqFt, double laborCostPerSqFt) {
        this.costPerSqFt = costPerSqFt;
        this.laborCostPerSqFt = laborCostPerSqFt;
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
}
