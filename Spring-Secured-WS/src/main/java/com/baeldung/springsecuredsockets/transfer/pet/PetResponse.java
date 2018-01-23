package com.baeldung.springsecuredsockets.transfer.pet;

import java.util.ArrayList;
import java.util.List;

public class PetResponse {

    private List<PetTransfer> pets;

    public PetResponse() { }

    public void addPet(PetTransfer p) {
        if (pets == null || pets.isEmpty()) {
            setPets(new ArrayList<>());
        }
        this.pets.add(p);
    }

    public List<PetTransfer> getPets() {
        return pets;
    }

    public void setPets(List<PetTransfer> pets) {
        this.pets = pets;
    }
}
