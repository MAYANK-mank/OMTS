package com.capg.MovieMgmt.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.capg.MovieMgmt.dao.IMovieDao;
import com.capg.MovieMgmt.entities.Movie;
import com.capg.MovieMgmt.exceptions.MovieNotFoundException;

@Service
@Transactional
public class MovieServiceimpl implements IMovieService {
	private IMovieDao dao;

	public IMovieDao getDao() {
		return dao;
	}

	@Autowired
	public void setDao(IMovieDao dao) {
		this.dao = dao;
	}

	@Override
	public Movie save(Movie m) {
		Movie mov = dao.save(m);
		return mov;
	}

	@Override
	public List<Movie> fetchAll() {

		List<Movie> movies = dao.findAll();
		return movies;
	}

	@Override
	public Movie fetchById(int movieId) {

		Optional<Movie> optional = dao.findById(movieId);
		if (optional.isPresent()) {
			Movie mov = optional.get();
			return mov;
		}
		throw new MovieNotFoundException("Movie not found for id=" + movieId);
	}

	@Override
	public String delete(int movieId) {

		Movie movie = fetchById(movieId);
		dao.delete(movie);
		return "Deleted Succesully";
	}

	@Override
	public Movie saveMovie(Movie movie) {
		
		return dao.save(movie);
	}

}
