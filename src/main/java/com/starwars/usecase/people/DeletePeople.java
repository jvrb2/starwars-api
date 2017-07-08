package com.starwars.usecase.people;

import com.starwars.repository.PeopleRepository;
import org.springframework.stereotype.Service;

@Service
public class DeletePeople {
    private PeopleRepository peopleRepository;

    public DeletePeople(PeopleRepository peopleRepository) {
        this.peopleRepository = peopleRepository;
    }

    public void execute(Long id) throws NullPointerException {
        if (id == null) throw new NullPointerException("People id is required");
        peopleRepository.delete(id);
    }
}
