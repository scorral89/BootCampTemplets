package com.tts.miyagi.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tts.miyagi.model.Movie;
import com.tts.miyagi.repository.MovieRepository;

@Service
public class MovieService {
	
	@Autowired
	MovieRepository movieRepository;
	
	public List<Movie> findAllByYear(int year)
	{
		return movieRepository.findAllByYear(year);
	}

}
