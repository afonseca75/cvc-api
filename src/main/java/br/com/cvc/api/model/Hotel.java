package br.com.cvc.api.model;

import java.io.Serializable;
import java.util.List;

public class Hotel implements Serializable {

	private static final long serialVersionUID = -2515779183630937564L;

	private int id;

	private String name;

	private int cityCode;

	private String cityName;

	private List<Room> rooms;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getCityCode() {
		return cityCode;
	}

	public void setCityCode(int cityCode) {
		this.cityCode = cityCode;
	}

	public String getCityName() {
		return cityName;
	}

	public void setCityName(String cityName) {
		this.cityName = cityName;
	}

	public List<Room> getRooms() {
		return rooms;
	}

	public void setRooms(List<Room> rooms) {
		this.rooms = rooms;
	}

	@Override
	public String toString() {
		return "Hotel [id=" + id + ", name=" + name + ", cityCode=" + cityCode + ", cityName=" + cityName + ", rooms="
				+ rooms + "]";
	}

}
