package com.starwars.usecase.film;

import com.starwars.repository.FilmRepository;
import lombok.NonNull;
import org.springframework.stereotype.Service;

@Service
public class DeleteFilm {

    private FilmRepository filmRepository;

    public DeleteFilm(FilmRepository filmRepository) {
        this.filmRepository = filmRepository;
    }

    public void execute(@NonNull Long id) {
        filmRepository.delete(id);
    }
}
