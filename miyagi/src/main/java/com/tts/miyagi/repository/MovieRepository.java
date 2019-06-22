package com.tts.miyagi.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.tts.miyagi.model.Movie;

@Repository
public interface MovieRepository extends CrudRepository<Movie, Long> {
	public List<Movie> findAllByYear(int year);
	
}
