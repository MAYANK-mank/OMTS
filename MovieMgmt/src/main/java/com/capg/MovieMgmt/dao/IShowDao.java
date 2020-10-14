package com.capg.MovieMgmt.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.capg.MovieMgmt.entities.Show;

public interface IShowDao extends JpaRepository<Show, Integer> {

}
