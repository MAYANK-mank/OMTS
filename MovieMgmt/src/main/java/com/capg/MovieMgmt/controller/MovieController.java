package com.capg.MovieMgmt.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.capg.MovieMgmt.dto.MovieDetailsDto;
import com.capg.MovieMgmt.dto.MovieRequestDto;
import com.capg.MovieMgmt.entities.Movie;
import com.capg.MovieMgmt.service.IMovieService;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping("/movies")
public class MovieController {
	
	@Autowired
	private IMovieService movieService;
	
//	@PostMapping("/add")
//	private ResponseEntity<MovieDetailsDto> addMovie(@RequestBody MovieRequestDto movieDto){
//		Movie movie = convertMovie(movieDto);
//		movie = movieService.save(movie);
//		MovieDetailsDto detailsDto = convertMovieDetails(movie) ;
//		ResponseEntity<MovieDetailsDto> response = new ResponseEntity<MovieDetailsDto>(detailsDto, HttpStatus.OK);
//		return response;
//	}
	
	@PostMapping("/add")
	public Movie movieRegister(@RequestBody Movie movie)
	{
		Movie movieObj = movieService.saveMovie(movie);
		return movieObj;
	}
	
	@GetMapping("/get/{id}")
	private ResponseEntity<MovieDetailsDto> fetchById(@PathVariable("id") int movieId){;
		Movie movie = movieService.fetchById(movieId);
		MovieDetailsDto detailsDto = convertMovieDetails(movie) ;
		ResponseEntity<MovieDetailsDto> response = new ResponseEntity<MovieDetailsDto>(detailsDto, HttpStatus.OK);
		return response;
	}
	
	private MovieDetailsDto convertMovieDetails(Movie movie) {
	
		MovieDetailsDto detailsDto = new MovieDetailsDto() ;
		detailsDto.setMovieId(movie.getMovieId());
		detailsDto.setMovieName(movie.getMovieName());
		detailsDto.setMovieDirector(movie.getMovieDirector());
		detailsDto.setMovieLength(movie.getMovieLength());
		detailsDto.setMovieReleaseDate(movie.getMovieReleaseDate());
		detailsDto.setLanguages(movie.getLanguages());
		detailsDto.setMovieGenre(movie.getMovieGenre()) ;
		return null;
	}

	@GetMapping("/all")
	ResponseEntity<List<Movie>> fetchAll(){
		List<Movie> movieList = movieService.fetchAll();
		ResponseEntity<List<Movie>> response = new ResponseEntity<List<Movie>>(movieList, HttpStatus.OK);
		return response;
	}
	
	@DeleteMapping("/delete/{id}")
	private ResponseEntity<String> delete(@PathVariable("id") int movieId)
	{
		String result  = movieService.delete(movieId);
		ResponseEntity<String> response = new ResponseEntity<String>(result, HttpStatus.OK);
		return response;
	}
	
	private Movie convertMovie(MovieRequestDto movieDto) {
		Movie movie = new Movie();
		movie.setMovieName(movieDto.getMovieName());
		movie.setMovieDirector(movieDto.getMovieDirector());
		movie.setMovieGenre(movieDto.getMovieGenre());
		movie.setMovieLength(movieDto.getMovieLength());
		movie.setMovieReleaseDate(movieDto.getMovieReleaseDate());
		movie.setLanguages(movieDto.getLanguages());
		return movie;
	}
	
	
}
