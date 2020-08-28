package org.sg.flooring.enums;

public enum States {
	OH("Ohio", 6.25),
	PA("Pennsylvania", 6.75),
	MI("Michigan", 5.75),
	IN("Indiana", 6.00);

	private String stateName;
	private double stateTaxRate;

	States(String stateName, double stateTaxRate) {
		this.stateName = stateName;
		this.stateTaxRate = stateTaxRate;
	}

	public String getStateName() {
		return stateName;
	}

	public void setStateName(String stateName) {
		this.stateName = stateName;
	}

	public double getStateTaxRate() {
		return stateTaxRate;
	}

	public void setStateTaxRate(double stateTaxRate) {
		this.stateTaxRate = stateTaxRate;
	}
}
