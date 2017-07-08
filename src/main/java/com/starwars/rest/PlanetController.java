package com.starwars.rest;

import com.starwars.model.Planet;
import com.starwars.usecase.planet.DeletePlanet;
import com.starwars.usecase.planet.FindAllPlanets;
import com.starwars.usecase.planet.FindPlanet;
import com.starwars.usecase.planet.SavePlanet;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping(path = "/planets")
@Controller
@AllArgsConstructor
public class PlanetController {

    private FindAllPlanets findAllPlanets;
    private SavePlanet savePlanet;
    private FindPlanet findPlanet;
    private DeletePlanet deletePlanet;

    @RequestMapping(method = RequestMethod.GET)
    public ResponseEntity<List<Planet>> findAll() {
        List<Planet> planets = findAllPlanets.execute();

        return new ResponseEntity<List<Planet>>(planets, HttpStatus.OK);
    }

    @RequestMapping(method = RequestMethod.GET, path = "/{id}")
    public ResponseEntity<Planet> findById(@PathVariable Long id) {
        Planet planet = findPlanet.execute(id);

        return new ResponseEntity<Planet>(planet, HttpStatus.OK);
    }

    @RequestMapping(method = RequestMethod.POST)
    public ResponseEntity<Planet> save(@RequestBody Planet planet) {
        Planet saved = savePlanet.execute(planet);
        return new ResponseEntity<Planet>(saved, HttpStatus.CREATED);    }

    @RequestMapping(method = RequestMethod.PUT, path = "/{id}")
    public ResponseEntity<Planet> update(@PathVariable Long id,@RequestBody Planet planet) {
        Planet found = findPlanet.execute(id);
        if (found == null) {
            return new ResponseEntity<Planet>(HttpStatus.NO_CONTENT);
        }

        Planet updated = savePlanet.execute(planet);
        return new ResponseEntity<Planet>(updated, HttpStatus.OK);
    }

    @RequestMapping(method = RequestMethod.DELETE, path = "/{id}")
    public ResponseEntity<Planet> delete(@PathVariable Long id) {
        deletePlanet.execute(id);

        return new ResponseEntity<Planet>(HttpStatus.NO_CONTENT);
    }

}
