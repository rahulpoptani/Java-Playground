package com.rahulpoptani.mongo.service;

import com.rahulpoptani.mongo.model.Person;
import com.rahulpoptani.mongo.repository.PersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PersonService {
    @Autowired
    private PersonRepository personRepository;

    // create operation
    public Person create(String firstName, String lastName, int age) {
        return personRepository.save(new Person(firstName, lastName, age));
    }

    // Retrieve operation
    public List<Person> getAll() {
        return personRepository.findAll();
    }

    public Person getByFirstName(String firstName) {
        return personRepository.findByFirstName(firstName);
    }

    // Update Operation
    public Person update(String firstName, String lastName, int age) {
        Person p = personRepository.findByFirstName(firstName);
        p.setLastName(lastName);
        p.setAge(age);
        return personRepository.save(p);
    }

    // Delete Operation
    public void deleteAll() {
        personRepository.deleteAll();
    }

    public void delete (String firstName) {
        Person p = personRepository.findByFirstName(firstName);
        personRepository.delete(p);
    }



}
