package com.stackroute.movieapp1.controllers;

import java.util.List;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.stackroute.movieapp1.domain.Movie;
import com.stackroute.movieapp1.exceptions.MovieAlreadyExistsException;
import com.stackroute.movieapp1.exceptions.MovieNotFoundException;
import com.stackroute.movieapp1.services.MovieServiceImpl;

@CrossOrigin("*")
@RestController
@RequestMapping("/api/v1")
public class MovieControllers {

	private MovieServiceImpl movieService;
	private Environment env;
	private final Logger logger = LoggerFactory.getLogger(this.getClass());

	@Autowired
	public MovieControllers(MovieServiceImpl movieService,Environment env){
		this.movieService = movieService;
		this.env = env;
	}

	public MovieControllers(MovieServiceImpl movieService) {
		// TODO Auto-generated constructor stub
	}

	@PostMapping("/movie")
	public ResponseEntity<?> saveMovie(@RequestBody Movie movie)  {
		try {
			logger.info("This is an info message");
			return new ResponseEntity<Movie> (movieService.saveMovie(movie),HttpStatus.CREATED);
		}
		catch (MovieAlreadyExistsException e) {
			// TODO: handle exception
			logger.error("This is an error message");
			return new ResponseEntity<String> ("movie already exists",HttpStatus.CONFLICT);
		}


	}

	@GetMapping("/movies")
	public ResponseEntity <?> getAllMovies() {
		logger.debug("This is a debug message");

		logger.warn("This is a warn message");
		logger.info("This is an info message");
		return new ResponseEntity<Iterable<Movie>> (movieService.getAllMovies(),HttpStatus.OK);
	}

	@GetMapping("/movie/{id}")
	public ResponseEntity <?> getMovieById(@PathVariable int id) throws MovieNotFoundException {
		try {
			logger.info("This is an info message");
			return new ResponseEntity<Optional<Movie>> (movieService.getMovieById(id),HttpStatus.OK);
		}
		catch(MovieNotFoundException e) {
			logger.error("This is an error message");
			return new ResponseEntity<String> (e.getMessage(),HttpStatus.CONFLICT);
		}

	}

	@GetMapping("/moviename/{title}")
	public ResponseEntity <?> getMovieByTitle(@PathVariable String title) throws MovieNotFoundException{
		try {
			logger.info("This is an info message");
			return new ResponseEntity<Optional<Movie>> (movieService.getMovieByTitle(title),HttpStatus.OK);
		}
		catch(MovieNotFoundException e) {
			logger.error("This is an error message");
			return new ResponseEntity <String> (e.getMessage(),HttpStatus.CONFLICT);
		}

	}

	@DeleteMapping("/movie/{id}")
	public ResponseEntity<?> deleteMovie(@PathVariable int id) {
		try {
			logger.info("This is an info message");
			movieService.deleteMovie(id);
			return new ResponseEntity<String> ("Deleted", HttpStatus.OK);
		} catch (MovieNotFoundException e) {
			// TODO Auto-generated catch block
			logger.error("This is an error message");
			return new ResponseEntity<String> (e.getMessage(), HttpStatus.CONFLICT);
		}
	}

	@PutMapping("/movie/{id}")
	public ResponseEntity<?> updateMovie(@PathVariable int id,@RequestBody Movie movie){
		logger.info("This is an info message");
		return new ResponseEntity<Movie> (movieService.updateMovie(movie, id),HttpStatus.OK);
	}


}
