package com.starwars.usecase.people;

import com.starwars.model.People;
import com.starwars.repository.PeopleRepository;
import lombok.NonNull;
import org.springframework.stereotype.Service;

@Service
public class FindPeople {

    private PeopleRepository peopleRepository;

    public FindPeople(PeopleRepository peopleRepository) {
        this.peopleRepository = peopleRepository;
    }

    public People execute(@NonNull Long id) {
        return peopleRepository.findOne(id);
    }
}
