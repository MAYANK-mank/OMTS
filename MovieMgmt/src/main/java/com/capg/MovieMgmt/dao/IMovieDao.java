package com.capg.MovieMgmt.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.capg.MovieMgmt.entities.Movie;

public interface IMovieDao extends JpaRepository<Movie, Integer> {

	
	
	
}
