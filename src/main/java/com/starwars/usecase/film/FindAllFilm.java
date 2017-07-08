package com.starwars.usecase.film;

import com.starwars.model.Film;
import com.starwars.repository.FilmRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FindAllFilm {

    private FilmRepository filmRepository;

    public FindAllFilm(FilmRepository filmRepository) {
        this.filmRepository = filmRepository;
    }

    public List<Film> execute() {
        return filmRepository.findAll();
    }
}
