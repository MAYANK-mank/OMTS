package com.capg.MovieMgmt.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.capg.MovieMgmt.entities.Seat;

@Repository
public interface ISeatDao extends JpaRepository<Seat, Integer>{

}
