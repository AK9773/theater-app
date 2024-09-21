package com.ak.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.ak.entity.Movie;
import com.ak.exception.InvalidMovieIdException;
import com.ak.service.MovieService;

@RestController
@RequestMapping("/theater/")
public class MovieController {
	
	@Autowired
	private MovieService movieService;
	
	@PostMapping("/movie")
	public ResponseEntity<Movie> createNewMovie(@RequestBody Movie movie){
		
		if (movie.getTitle() == null || movie.getDirector() == null || movie.getLanguage() == null || movie.getYear() <= 0) {
            return ResponseEntity.badRequest().build(); // Return 400 Bad Request for invalid data
        }
		Movie createdNewMovie = movieService.createNewMovie(movie);
		return ResponseEntity.status(201).body(createdNewMovie);
	}
	
	@GetMapping("/movie/{movieId}")
	public ResponseEntity<Movie> getMovieDetails(@PathVariable Long movieId)throws InvalidMovieIdException{
		Movie movie = movieService.getMovieDetails(movieId);
		return  ResponseEntity.status(200).body(movie);
	}

}
