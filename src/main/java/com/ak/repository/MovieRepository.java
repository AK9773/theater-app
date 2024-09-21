package com.ak.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ak.entity.Movie;

public interface MovieRepository extends JpaRepository<Movie, Long> {
	
	
	List<Movie> findByTitle(String title);

}
