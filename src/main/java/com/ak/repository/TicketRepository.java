package com.ak.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ak.entity.Ticket;

public interface TicketRepository extends JpaRepository<Ticket, Long> {

	List<Ticket> findByMovieId(Long movieId);
}
