package com.crud.simpleCrud.services;

import com.crud.simpleCrud.entities.PersonEntity;
import com.crud.simpleCrud.repositories.PersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Set;

@Service
public class PersonJpaService implements PersonService {

    @Autowired
    private PersonRepository personRepository;



    @Override
    public Set findAll() {
        Set<PersonEntity> personEntitiesSet = new HashSet<>();
        personRepository.findAll().forEach(personEntitiesSet::add);
        return personEntitiesSet;
    }

    @Override
    public PersonEntity findById(Long id) {
        return personRepository.findById(id).orElse(null);
    }

    @Override
    public PersonEntity save(PersonEntity personEntity) {
        return personRepository.save(personEntity);
    }

    @Override
    public void deleteById(Long id) {
        personRepository.deleteById(id);
    }
}
