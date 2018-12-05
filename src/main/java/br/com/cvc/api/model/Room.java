package br.com.cvc.api.model;

import java.io.Serializable;

import org.apache.commons.lang3.builder.ToStringBuilder;

public class Room implements Serializable {

	private static final long serialVersionUID = 6456328498489565098L;

	private int roomID;

	private String categoryName;

	private Price price;

	private double totalPrice;

	private PriceDetail priceDetail;

	public int getRoomID() {
		return roomID;
	}

	public void setRoomID(int roomID) {
		this.roomID = roomID;
	}

	public String getCategoryName() {
		return categoryName;
	}

	public void setCategoryName(String categoryName) {
		this.categoryName = categoryName;
	}

	public Price getPrice() {
		return price;
	}

	public void setPrice(Price price) {
		this.price = price;
	}

	public double getTotalPrice() {
		return totalPrice;
	}

	public void setTotalPrice(double totalPrice) {
		this.totalPrice = totalPrice;
	}

	public PriceDetail getPriceDetail() {
		return priceDetail;
	}

	public void setPriceDetail(PriceDetail priceDetail) {
		this.priceDetail = priceDetail;
	}

	@Override
	public String toString() {
		return ToStringBuilder.reflectionToString(this);
	}

}
