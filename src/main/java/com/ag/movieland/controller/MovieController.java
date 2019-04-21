package com.ag.movieland.controller;

import com.ag.movieland.entity.Movie;
import com.ag.movieland.service.IMovieService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class MovieController {
    private final Logger logger = LoggerFactory.getLogger(getClass());

    private IMovieService movieService;

    @GetMapping(path = "/movies", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    List<Movie> findAll() {
        logger.info("find All Movies");
        List<Movie> movies = movieService.findAll();
        return movies;
    }

    @GetMapping(path = "/movies/random", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    List<Movie> getRandom() {
        logger.info("get Random Movies");
        List<Movie> movies = movieService.getRandom();
        return movies;
    }

    @GetMapping(path = "/movies/genre/{genreId}", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    List<Movie> findByGenreId(@PathVariable int genreId) {
        logger.info("find Movies by Genre ID");
        List<Movie> movies = movieService.findByGenreId(genreId);
        return movies;
    }

    @Autowired
    public void setMovieService(IMovieService movieService) {
        this.movieService = movieService;
    }

}
