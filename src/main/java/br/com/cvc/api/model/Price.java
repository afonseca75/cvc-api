package br.com.cvc.api.model;

import java.io.Serializable;

import org.apache.commons.lang3.builder.ToStringBuilder;

public class Price implements Serializable {

	private static final long serialVersionUID = -622674161753110356L;

	private double adult;

	private double child;

	public double getAdult() {
		return adult;
	}

	public void setAdult(double adult) {
		this.adult = adult;
	}

	public double getChild() {
		return child;
	}

	public void setChild(double child) {
		this.child = child;
	}

	@Override
	public String toString() {
		return ToStringBuilder.reflectionToString(this);
	}

}
