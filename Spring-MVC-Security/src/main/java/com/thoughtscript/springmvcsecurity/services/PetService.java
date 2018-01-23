package com.thoughtscript.springmvcsecurity.services;

import com.thoughtscript.springmvcsecurity.domain.Pet;
import com.thoughtscript.springmvcsecurity.repositories.PetRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class PetService {

    Logger log = LoggerFactory.getLogger(PetService.class);

    @Autowired
    private PetRepository petRepository;

    public Pet transmuteDragon(Long id) {
        Pet pet = petRepository.findOne(id);
        pet.setType(Pet.PetType.DRAGON);
        return pet;
    }

    public List<Pet> fetchPets() {
        List<Pet> pets = new ArrayList<>();
        petRepository.findAll().forEach(pets::add);
        return pets;
    }

    public Pet fetchPetById(Long id) {
        return petRepository.findOne(id);
    }
}