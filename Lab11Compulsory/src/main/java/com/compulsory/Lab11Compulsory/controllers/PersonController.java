package com.compulsory.Lab11Compulsory.controllers;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/person")
public class PersonController {
    private final List<Person> persons = new ArrayList<>();

    public PersonController() {
        persons.add(new Person(1, "Mask"));
        persons.add(new Person(2, "Gloves"));
    }
    
    @GetMapping
    public List<Person> getPersons() {
        return persons;
    }

    @GetMapping("/count")
    public int countPersons() {
        return persons.size();
    }

    @GetMapping("/{id}")
    public Person getPerson(@PathVariable("id") int id) {
        return persons.stream()
                .filter(p -> p.getId() == id).findFirst().orElse(null);
    }

    @PostMapping
    public int createPerson(@RequestParam String name) {
        int id = 1 + persons.size();
        persons.add(new Person(id, name));
        return id;
    }

    @PostMapping(value = "/obj", consumes="application/json")
    public ResponseEntity<String>
    createPerson(@RequestBody Person person) {
        persons.add(person);
        return new ResponseEntity<>(
                "Person created successfully", HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<String> updatePerson(
            @PathVariable int id, @RequestParam String name) {
        Person person = findById(id);
        if (person == null) {
            return new ResponseEntity<>(
                    "Person not found", HttpStatus.NOT_FOUND); //or GONE
        }
        person.setName(name);
        return new ResponseEntity<>(
                "Person updated successfully", HttpStatus.OK);
    }

    @DeleteMapping(value = "/{id}")
    public ResponseEntity<String> deletePerson(@PathVariable int id) {
        Person person = findById(id);
        if (person == null) {
            return new ResponseEntity<>(
                    "Person not found", HttpStatus.GONE);
        }
        persons.remove(person);
        return new ResponseEntity<>("Person removed", HttpStatus.OK);
    }

    Person findById(int id){
        return persons.stream().filter(p -> p.getId() == id).findFirst().orElse(null);
    }
}
