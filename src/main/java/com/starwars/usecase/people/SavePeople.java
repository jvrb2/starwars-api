package com.starwars.usecase.people;

import com.starwars.model.People;
import com.starwars.repository.PeopleRepository;
import lombok.NonNull;
import org.springframework.stereotype.Service;

@Service
public class SavePeople {

    private PeopleRepository peopleRepository;

    public SavePeople(PeopleRepository peopleRepository) {
        this.peopleRepository = peopleRepository;
    }

    public People execute(@NonNull People people) {
        return peopleRepository.save(people);
    }
}
