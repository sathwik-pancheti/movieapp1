package com.stackroute.movieapp1;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationListener;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.boot.CommandLineRunner;

import com.stackroute.movieapp1.domain.Movie;
import com.stackroute.movieapp1.repositories.MovieRepository;

@Configuration
public class BootStrapDB implements ApplicationListener<ContextRefreshedEvent> {
	//public class BootStrapDB implements CommandLineRunner{
	
	
private MovieRepository movieRepo;
    
    @Autowired
    public BootStrapDB(MovieRepository movieRepository) {
        this.movieRepo=movieRepository;
    }
	@Override
	public void onApplicationEvent(ContextRefreshedEvent event) {
		// TODO Auto-generated method stub
		Movie movie = new Movie(5,"1234","as","a1234wef","asdf");
		movieRepo.save(movie);
		
	}
//	@Override
//	public void run(String... args) throws Exception {
//		// TODO Auto-generated method stub
//		
//		
//		
//	}

}
