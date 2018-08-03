package com.stackroute.movieapp1.controllers;

import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.util.Optional;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import com.stackroute.movieapp1.controllers.MovieControllers;
import com.stackroute.movieapp1.domain.Movie;
import com.stackroute.movieapp1.services.MovieServiceImpl;

@RunWith(SpringRunner.class)
@WebMvcTest(MovieControllers.class)
public class MovieControllersTest {
    
         @Autowired
         private MockMvc movieMockMvc;
         
         @MockBean
         private MovieServiceImpl movieServiceImpl;
         
         @InjectMocks
         private MovieControllers movieController = new MovieControllers(movieServiceImpl);
         
        Movie movie = new Movie(7,"qwe","asd","qwe","12");
         
        @Before
        public void setUp() throws Exception {
            MockitoAnnotations.initMocks(this);   
        } 
        
        @Test
        public void testGetAllMovies() throws Exception{
              when(movieServiceImpl.getAllMovies()).thenReturn(null);
             movieMockMvc.perform(get("/api/v1/movies"))
            .andExpect(status().isOk());
        }
        
        @Test
        public void testGetMovieById() throws Exception{
//        	when(movieServiceImpl.getMovieById(1)).thenReturn(null);
//        	movieMockMvc.perform(get("/api/v1/movie/1"))
//        	.andExpect(status().isOk());	
        	Movie movie=new Movie();
            movie.setId(1);
            movie.setTitle("asd");
            movie.setImdbId("wer");
            movie.setPoster("dfgh");
            movie.setYear("2019");
            int id=1;
        	Optional<Movie> opt = Optional.of(movie);
            when(movieServiceImpl.getMovieById(id)).thenReturn(opt);
            movieMockMvc.perform(get("/api/v1/movie/" + id))
            .andExpect(status().isOk());
        }
        
        @Test
        public void testGetMovieByTitle() throws Exception{
        	when(movieServiceImpl.getMovieByTitle("1234")).thenReturn(null);
        	movieMockMvc.perform(get("/api/v1/moviename/1234"))
        	.andExpect(status().isOk());
        }
        
        @Test
        public void testUpdateMovie() throws Exception{
        	Movie movie = new Movie(10,"ab","ab","ab","ab");
        	when(movieServiceImpl.updateMovie(movie, movie.getId())).thenReturn(null);
        	movieMockMvc.perform(get("/api/v1/movie/"+movie.getId()))
        	.andExpect(status().isOk());
        }
        
        @Test
        public void testSaveMovie() throws Exception{
        	
        	when(movieServiceImpl.saveMovie(movie)).thenReturn(null);
        	movieController.saveMovie(movie);
        	verify(movieServiceImpl, times(1)).saveMovie(movie);
        	//movieMockMvc.perform(get("/api/v1/movie"))
        	//.andExpect(status().isCreated());
        }
        
        @Test
        public void testDeleteMovie() throws Exception{
        	when(movieServiceImpl.deleteMovie(1)).thenReturn(true);
        	movieMockMvc.perform(get("/api/v1/movie/1"))
        	.andExpect(status().isOk());
        	//verify(movieServiceImpl, times(1)).deleteMovie(movie.getId());
        }

}