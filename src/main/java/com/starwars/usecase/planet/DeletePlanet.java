package com.starwars.usecase.planet;

import com.starwars.repository.PlanetRepository;
import lombok.NonNull;
import org.springframework.stereotype.Service;

@Service
public class DeletePlanet {

    private PlanetRepository planetRepository;

    public DeletePlanet(PlanetRepository planetRepository) {
        this.planetRepository = planetRepository;
    }

    public void execute(@NonNull Long id) {
        planetRepository.delete(id);
    }
}
