package com.offcn.bean;

import java.util.Date;

public class EggInfo {
	
	private int id;
	private String name;
	private double minPrice;
	private double avgPrice;
	private double maxPrice;
	private String standard;
	private String unit;
	private Date pubDate;
	
	
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getStandard() {
		return standard;
	}
	public void setStandard(String standard) {
		this.standard = standard;
	}
	public String getUnit() {
		return unit;
	}
	public void setUnit(String unit) {
		this.unit = unit;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public double getMinPrice() {
		return minPrice;
	}
	public void setMinPrice(double minPrice) {
		this.minPrice = minPrice;
	}
	public double getAvgPrice() {
		return avgPrice;
	}
	public void setAvgPrice(double avgPrice) {
		this.avgPrice = avgPrice;
	}
	public double getMaxPrice() {
		return maxPrice;
	}
	public void setMaxPrice(double maxPrice) {
		this.maxPrice = maxPrice;
	}
	public Date getPubDate() {
		return pubDate;
	}
	public void setPubDate(Date pubDate) {
		this.pubDate = pubDate;
	}
	@Override
	public String toString() {
		return "EggInfo [id=" + id + ", name=" + name + ", minPrice=" + minPrice + ", avgPrice=" + avgPrice
				+ ", maxPrice=" + maxPrice + ", standard=" + standard + ", unit=" + unit + ", pubDate=" + pubDate + "]";
	}


	
	
}
