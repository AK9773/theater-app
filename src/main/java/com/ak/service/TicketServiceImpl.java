package com.ak.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ak.entity.Movie;
import com.ak.entity.Ticket;
import com.ak.entity.TicketDto;
import com.ak.exception.InvalidMovieIdException;
import com.ak.exception.InvalidTicketIdException;
import com.ak.exception.MovieNotFoundException;
import com.ak.repository.MovieRepository;
import com.ak.repository.TicketRepository;

@Service
public class TicketServiceImpl implements TicketService {

	@Autowired
	private TicketRepository ticketRepository;
	@Autowired
	private MovieRepository movieRepository;

	@Override
	public TicketDto bookMovieTicket(TicketDto ticketDto) throws MovieNotFoundException {
		Ticket ticketDtoToTicket = ticketDtoToTicket(ticketDto);
		Ticket savedTicket = ticketRepository.save(ticketDtoToTicket);
		TicketDto ticketToTicketDto = ticketToTicketDto(savedTicket);
		return ticketToTicketDto;
	}

	@Override
	public TicketDto getMovieTicketDetails(Long ticketId) throws InvalidTicketIdException {
		Optional<Ticket> findById = ticketRepository.findById(ticketId);
		if (!findById.isPresent()) {
			throw new InvalidTicketIdException();
		}
		Ticket ticket = findById.get();
		TicketDto ticketToTicketDto = ticketToTicketDto(ticket);

		return ticketToTicketDto;
	}

	@Override
	public List<TicketDto> getAllMovieTickets(Long movieId) throws InvalidMovieIdException {
		List<Ticket> findByMovieId = ticketRepository.findByMovieId(movieId);
		if(findByMovieId.size()==0) {
			throw new InvalidMovieIdException();
		}
		List<TicketDto> ticketDtoList = new ArrayList<>();
		for (Ticket ticket : findByMovieId) {
			TicketDto ticketToTicketDto = ticketToTicketDto(ticket);
			ticketDtoList.add(ticketToTicketDto);
		}

		return ticketDtoList;
	}

	public Ticket ticketDtoToTicket(TicketDto ticketDto) throws MovieNotFoundException {
		Ticket ticket = new Ticket();
		ticket.setNoOfTickets(ticketDto.getNoOfTickets());
		ticket.setPrice(ticketDto.getNoOfTickets());
		ticket.setType(ticketDto.getType());
		ticket.setUnitPrice(ticketDto.getUnitPrice());
		ticket.setPrice(ticketDto.getUnitPrice() * ticketDto.getNoOfTickets());
		List<Movie> findByTitle = movieRepository.findByTitle(ticketDto.getTitle());
		if (findByTitle.size() == 0) {
			throw new MovieNotFoundException();
		}
		Movie movie = findByTitle.get(0);
		ticket.setMovie(movie);
		return ticket;
	}

	public TicketDto ticketToTicketDto(Ticket ticket) {
		TicketDto ticketDto = new TicketDto();
		ticketDto.setId(ticket.getId());
		ticketDto.setNoOfTickets(ticket.getNoOfTickets());
		ticketDto.setPrice(ticket.getNoOfTickets());
		ticketDto.setType(ticket.getType());
		ticketDto.setUnitPrice(ticket.getUnitPrice());
		ticketDto.setPrice(ticket.getPrice());
		ticketDto.setTitle(ticket.getMovie().getTitle());

		return ticketDto;
	}

}
