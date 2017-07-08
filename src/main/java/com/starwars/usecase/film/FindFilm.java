package com.starwars.usecase.film;

import com.starwars.model.Film;
import com.starwars.repository.FilmRepository;
import lombok.NonNull;
import org.springframework.stereotype.Service;

@Service
public class FindFilm {
    private FilmRepository filmRepository;

    public FindFilm(FilmRepository filmRepository) {
        this.filmRepository = filmRepository;
    }

    public Film execute(@NonNull Long id) {
        return filmRepository.findOne(id);
    }
}
