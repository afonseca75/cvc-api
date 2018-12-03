package br.com.cvc.api.model;

import java.io.Serializable;

import org.apache.commons.lang3.builder.ToStringBuilder;

public class PriceDetail implements Serializable {

	private static final long serialVersionUID = 4715170080238354302L;

	private double pricePerDayAdult;

	private double pricePerDayChild;

	public double getPricePerDayAdult() {
		return pricePerDayAdult;
	}

	public void setPricePerDayAdult(double pricePerDayAdult) {
		this.pricePerDayAdult = pricePerDayAdult;
	}

	public double getPricePerDayChild() {
		return pricePerDayChild;
	}

	public void setPricePerDayChild(double pricePerDayChild) {
		this.pricePerDayChild = pricePerDayChild;
	}

	@Override
	public String toString() {
		return ToStringBuilder.reflectionToString(this);
	}

}
