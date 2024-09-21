package com.ak.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "TICKET_ENTITY")
public class Ticket {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;

	@Column(nullable = false)
	private String type;

	@Column(name = "unit_price", nullable = false)
	private double unitPrice;

	@Column(name = "no_of_tickets", nullable = false)
	private int noOfTickets;

	@Column(nullable = false)
	private double price;

	@ManyToOne
	@JoinColumn(name = "movie_id", nullable = false)
	private Movie movie;

	public Ticket() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Ticket(String type, double unitPrice, int noOfTickets) {
		super();
		this.type = type;
		this.unitPrice = unitPrice;
		this.noOfTickets = noOfTickets;
	}

	// Getters and Setters
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
		this.price = unitPrice * noOfTickets; // Automatically calculate price
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public Movie getMovie() {
		return movie;
	}

	public void setMovie(Movie movie) {
		this.movie = movie;
	}
}
