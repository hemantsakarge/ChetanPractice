package com.cjc.main.crud.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity
public class RedBus {


	@Id
	private int busId;
	private String busName;
	private String busColor;
	private double busPrice;
	private String  customername;
	private long mobileno;
	private String date;
	public int getBusId() {
		return busId;
	}
	public void setBusId(int busId) {
		this.busId = busId;
	}
	public String getBusName() {
		return busName;
	}
	public void setBusName(String busName) {
		this.busName = busName;
	}
	public String getBusColor() {
		return busColor;
	}
	public void setBusColor(String busColor) {
		this.busColor = busColor;
	}
	public double getBusPrice() {
		return busPrice;
	}
	public void setBusPrice(double busPrice) {
		this.busPrice = busPrice;
	}
	public String getCustomername() {
		return customername;
	}
	public void setCustomername(String customername) {
		this.customername = customername;
	}
	public long getMobileno() {
		return mobileno;
	}
	public void setMobileno(long mobileno) {
		this.mobileno = mobileno;
	}
	public String getDate() {
		return date;
	}
	public void setDate(String date) {
		this.date = date;
	}
	
}
