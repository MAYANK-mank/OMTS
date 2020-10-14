package com.capg.MovieMgmt.service;

import java.util.List;

import com.capg.MovieMgmt.entities.Show;

public interface IShowService {

	Show save(Show s) ;
	Show fetchById(int showId) ;
	String DeleteShow(int showId);
	List<Show>fetchAll() ;

	
	
	
}
