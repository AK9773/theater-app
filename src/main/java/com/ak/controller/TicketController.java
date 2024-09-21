package com.ak.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ak.entity.TicketDto;
import com.ak.exception.InvalidMovieIdException;
import com.ak.exception.InvalidTicketIdException;
import com.ak.exception.MovieNotFoundException;
import com.ak.service.TicketService;

@RestController
@RequestMapping("/theater")
public class TicketController {

	@Autowired
	private TicketService ticketService;

	@PostMapping("/movie/ticket/booking")
	public ResponseEntity<TicketDto> bookMovieTicket(TicketDto ticketDto) throws MovieNotFoundException {
		if (ticketDto.getType() == null || ticketDto.getUnitPrice() <= 0 || ticketDto.getNoOfTickets() <= 0
				|| ticketDto.getTitle() == null) {
			return ResponseEntity.badRequest().build(); // Return 400 Bad Request for invalid data
		}

		TicketDto bookMovieTicket = ticketService.bookMovieTicket(ticketDto);
		return ResponseEntity.status(201).body(bookMovieTicket);
	}

	@GetMapping("/movie/ticket/booking/{ticketId}")
	public ResponseEntity<TicketDto> getMovieTicketDetails(Long ticketId) throws InvalidTicketIdException {

		TicketDto movieTicketDetails = ticketService.getMovieTicketDetails(ticketId);
		return ResponseEntity.status(200).body(movieTicketDetails);
	}

	@GetMapping("/movie/{movieId}/ticket")
	public ResponseEntity<List<TicketDto>> getAllMovieTickets(@PathVariable Long movieId)
			throws InvalidMovieIdException {
		List<TicketDto> allMovieTickets = ticketService.getAllMovieTickets(movieId);
		return ResponseEntity.status(200).body(allMovieTickets);
	}

}
