package com.starwars.rest;

import com.starwars.model.People;
import com.starwars.usecase.people.FindAllPeople;
import com.starwars.usecase.people.SavePeople;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;

@Controller
@RequestMapping(path = "/people")
@AllArgsConstructor
public class PeopleController {
    private FindAllPeople findAllPeople;
    private SavePeople savePeople;

    @RequestMapping(method = RequestMethod.GET)
    public ResponseEntity<List<People>> findAll(){
        List<People> people = findAllPeople.execute();
        return new ResponseEntity<List<People>>(people, HttpStatus.OK);
    }

    @RequestMapping(method = RequestMethod.POST)
    public ResponseEntity<People> save(@RequestBody People people){
        People saved = savePeople.execute(people);
        return new ResponseEntity<People>(saved,HttpStatus.CREATED);
    }
}
