package com.capg.MovieMgmt.service;

import java.util.List;

import com.capg.MovieMgmt.entities.Movie;

public interface IMovieService {

	Movie save(Movie m);
	List<Movie> fetchAll() ;
	Movie fetchById(int movieId) ;
	String delete(int movieid) ;
    public Movie saveMovie(Movie movie);
	
}
