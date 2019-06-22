package com.tts.miyagi.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.tts.miyagi.model.Movie;
import com.tts.miyagi.service.MovieService;

@RestController
public class MainController {
	
	@Autowired
	MovieService movieService;
	
	@GetMapping("/{year}")
	public List<Movie> index(@PathVariable int year)
	{
		List<Movie> moviesByYear= movieService.findAllByYear(year);
		return moviesByYear;
	}
}
// create CRUD
//POST, DELETE, CREATE, UPDATE