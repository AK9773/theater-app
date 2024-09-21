package com.ak.service;

import com.ak.entity.Movie;
import com.ak.exception.InvalidMovieIdException;

public interface MovieService {
	
	Movie createNewMovie(Movie movie);
	
	Movie getMovieDetails(Long movieId)throws InvalidMovieIdException;

}
