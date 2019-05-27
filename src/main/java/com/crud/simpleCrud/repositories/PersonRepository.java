package com.crud.simpleCrud.repositories;

import com.crud.simpleCrud.entities.PersonEntity;
import org.springframework.data.repository.CrudRepository;

public interface PersonRepository extends CrudRepository<PersonEntity, Long> {
}
