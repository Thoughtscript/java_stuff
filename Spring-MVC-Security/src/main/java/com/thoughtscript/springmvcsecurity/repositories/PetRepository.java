package com.thoughtscript.springmvcsecurity.repositories;

import com.thoughtscript.springmvcsecurity.domain.Pet;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PetRepository extends CrudRepository<Pet, Long> {}