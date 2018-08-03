package com.stackroute.movieapp1.services;


import java.util.List;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.stackroute.movieapp1.domain.Movie;
import com.stackroute.movieapp1.exceptions.MovieAlreadyExistsException;
import com.stackroute.movieapp1.exceptions.MovieNotFoundException;
import com.stackroute.movieapp1.repositories.MovieRepository;

@Service
public class MovieServiceImpl implements MovieService{

	private MovieRepository movieRepository;
	private final Logger logger = LoggerFactory.getLogger(this.getClass());
	@Autowired
	public MovieServiceImpl(MovieRepository movieRepository) {
		super();
		this.movieRepository = movieRepository;
	}

	@Override
	public Movie saveMovie(Movie movie) throws MovieAlreadyExistsException {
		if(movieRepository.existsById(movie.getId())) {
			throw new MovieAlreadyExistsException("existed");
		}
		else
		{return movieRepository.save(movie);}

	}

	@Override
	public Iterable<Movie> getAllMovies() {
		return movieRepository.findAll();
	}

	@Override
	public Optional<Movie> getMovieById(int id) throws MovieNotFoundException {
		if(movieRepository.existsById(id)) {
			return movieRepository.findById(id);
		}
		else {
			throw new MovieNotFoundException("Movie not found");
		}
	}

	@Override
	public boolean deleteMovie(int id) throws MovieNotFoundException {
		if(movieRepository.existsById(id)) {
			movieRepository.deleteById(id);
			return true;
		}
		else {
			throw new MovieNotFoundException("movie not found");
		}

	}

	@Override
	public Movie updateMovie(Movie movie, int id) {
		movie.setId(id);
		return movieRepository.save(movie);
	}

	@Override
	public Optional<Movie> getMovieByTitle(String title) throws MovieNotFoundException {
		// TODO Auto-generated method stub
		Optional<Movie> mov= movieRepository.getMovieByTitle(title); 
		
		if(mov.isPresent()){
			return mov;
			
		}
		else {
			throw new MovieNotFoundException("Movie not found");
		}
	}	
}
