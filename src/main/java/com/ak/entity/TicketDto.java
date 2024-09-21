package com.ak.entity;

public class TicketDto {

	private Long id;

	private String type;

	private double unitPrice;

	private int noOfTickets;

	private double price;

	private String title;

	public TicketDto() {
		super();

	}

	public TicketDto(Long id, String type, double unitPrice, int noOfTickets, double price, String title) {
		super();
		this.id = id;
		this.type = type;
		this.unitPrice = unitPrice;
		this.noOfTickets = noOfTickets;
		this.price = price;
		this.title = title;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public double getUnitPrice() {
		return unitPrice;
	}

	public void setUnitPrice(double unitPrice) {
		this.unitPrice = unitPrice;
	}

	public int getNoOfTickets() {
		return noOfTickets;
	}

	public void setNoOfTickets(int noOfTickets) {
		this.noOfTickets = noOfTickets;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	@Override
	public String toString() {
		return "TicketDto [id=" + id + ", type=" + type + ", unitPrice=" + unitPrice + ", noOfTickets=" + noOfTickets
				+ ", price=" + price + ", title=" + title + "]";
	}

}
