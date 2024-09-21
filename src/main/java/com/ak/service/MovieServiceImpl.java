package com.ak.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ak.entity.Movie;
import com.ak.exception.InvalidMovieIdException;
import com.ak.repository.MovieRepository;

@Service
public class MovieServiceImpl implements MovieService {

	@Autowired
	private MovieRepository movieRepository;

	@Override
	public Movie createNewMovie(Movie movie) {
		
		return movieRepository.save(movie);
	}

	@Override
	public Movie getMovieDetails(Long movieId) throws InvalidMovieIdException {
		Optional<Movie> optional = movieRepository.findById(movieId);
		if(!optional.isPresent()) {
			throw new InvalidMovieIdException();
		}
		Movie movie = optional.get();
		return movie;
	}

}
