package com.starwars.rest;

import com.starwars.model.Film;
import com.starwars.model.Planet;
import com.starwars.usecase.film.FindAllFilm;
import lombok.AllArgsConstructor;
import org.springframework.hateoas.EntityLinks;
import org.springframework.hateoas.Link;
import org.springframework.hateoas.mvc.ControllerLinkBuilder;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import sun.awt.image.ImageWatched;

import java.util.List;

import static org.springframework.hateoas.mvc.ControllerLinkBuilder.linkTo;
import static org.springframework.hateoas.mvc.ControllerLinkBuilder.methodOn;

@Controller
@RequestMapping(path = "/films")
@AllArgsConstructor
public class FilmController {
    private FindAllFilm findAllFilm;

    @RequestMapping(method = RequestMethod.GET)
    public ResponseEntity<List<Film>> findAll(){
        List<Film> films = findAllFilm.execute();

        films.forEach((Film film) -> {
            film.getPlanets().forEach((Planet planet) -> {
                if (!planet.hasLink("self")){
                    Link selfLink = linkTo(methodOn(PlanetController.class)
                        .findById(planet.getPlanetId())).withSelfRel();
                    planet.add(selfLink);
                }
            });
        });

        return new ResponseEntity<List<Film>>(films, HttpStatus.OK);
    }
}
