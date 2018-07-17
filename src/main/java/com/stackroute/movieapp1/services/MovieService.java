package com.stackroute.movieapp1.services;

import java.util.List;
import java.util.Optional;

import com.stackroute.movieapp1.domain.Movie;
import com.stackroute.movieapp1.exceptions.MovieAlreadyExistsException;
import com.stackroute.movieapp1.exceptions.MovieNotFoundException;

public interface MovieService {

	public Movie saveMovie(Movie movie) throws MovieAlreadyExistsException;
	
	public Iterable<Movie> getAllMovies();
	
	public Optional<Movie> getMovieById(int id) throws MovieNotFoundException;
	
	public boolean deleteMovie(int id) throws MovieNotFoundException;
	
	Movie updateMovie(Movie movie, int id);
	
	public Optional<Movie> getMovieByTitle(String title) throws MovieNotFoundException;
	
	
}
