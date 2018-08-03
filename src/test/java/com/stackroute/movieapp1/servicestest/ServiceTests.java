package com.stackroute.movieapp1.servicestest;

import static org.junit.Assert.*;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.Optional;

import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import com.stackroute.movieapp1.domain.Movie;
import com.stackroute.movieapp1.exceptions.MovieAlreadyExistsException;
import com.stackroute.movieapp1.exceptions.MovieNotFoundException;
import com.stackroute.movieapp1.repositories.MovieRepository;
import com.stackroute.movieapp1.services.MovieServiceImpl;

public class ServiceTests {

	
	@Mock
	private transient MovieRepository movieRepo;
	private transient Movie movie;
	
	@InjectMocks
	private transient MovieServiceImpl movieServiceImpl;
	
	/**
     * variable to hold user defined movies list
     */
	private transient Optional<Movie> options;
	
	  /**
     * Initializing the declarations
     */
	@Before
    public void setupMock() {
        MockitoAnnotations.initMocks(this);
        movie = new Movie(1, "POC", "good Movie", "www.abc.com", "2015-03-31");
        options = Optional.of(movie);

    }
	
//	@Test
//	public void test() {
//		fail("Not yet implemented");
//	}
	
	
	@Test
    public void testSaveMovie() throws MovieAlreadyExistsException{
        when(movieRepo.save(movie)).thenReturn(movie);
        Movie status = movieServiceImpl.saveMovie(movie);
        assertEquals(movie,status);
        verify(movieRepo,times(1)).save(movie);        
    }
	
	
            
            
    }


