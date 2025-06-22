package io.swagger;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class PetService {

    @Autowired
    private PetRepository petRepository;

    public Pet save(Pet pet) {
        // Business rule: Name must not be blank
        if (pet.getName() == null || pet.getName().isBlank()) {
            throw new IllegalArgumentException("Pet name is required.");
        }
        return petRepository.save(pet);
    }

    public List<Pet> findAll() {
        return petRepository.findAll();
    }

    public Pet findById(Long id) {
        return petRepository.findById(id).orElse(null);
    }

    public void delete(Long id) {
        if (!petRepository.existsById(id)) {
            throw new IllegalArgumentException("Pet not found.");
        }
        petRepository.deleteById(id);
    }
}