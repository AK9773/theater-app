package com.ak.service;

import java.util.List;

import com.ak.entity.TicketDto;
import com.ak.exception.InvalidMovieIdException;
import com.ak.exception.InvalidTicketIdException;
import com.ak.exception.MovieNotFoundException;

public interface TicketService {
	
	TicketDto bookMovieTicket(TicketDto ticketDto) throws MovieNotFoundException;
	
	TicketDto getMovieTicketDetails(Long ticketId) throws InvalidTicketIdException;
	
	List<TicketDto> getAllMovieTickets(Long movieId) throws InvalidMovieIdException;

}
