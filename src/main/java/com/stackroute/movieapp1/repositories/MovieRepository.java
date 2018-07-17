package com.stackroute.movieapp1.repositories;

import java.util.List;
import java.util.Optional;

//import org.springframework.data.jpa.repository.Query;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.stackroute.movieapp1.domain.Movie;

@Repository
public interface MovieRepository extends MongoRepository<Movie, Integer>{
    public Optional<Movie> getMovieByTitle(@Param("title") String title);
}
//public interface MovieRepository extends CrudRepository<Movie, Integer>{
//	
//	@Query("FROM Movie m where m.title = :title")
//	public Optional<Movie> getMovieByTitle(@Param("title") String title);	
//}
