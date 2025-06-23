package com.begumneval.vetmanagement.service.impl;

import com.begumneval.vetmanagement.entity.Animal;
import com.begumneval.vetmanagement.exception.NotFoundException;
import com.begumneval.vetmanagement.repository.AnimalRepository;
import com.begumneval.vetmanagement.service.AnimalService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class AnimalServiceImpl implements AnimalService {
    private final AnimalRepository animalRepository;

    @Override
    public Animal save(Animal animal) {
        return animalRepository.save(animal);
    }

    @Override
    public Animal update(Long id, Animal animal) {
        Animal existing = animalRepository.findById(id)
                .orElseThrow(() -> new NotFoundException("Animal not found with id: " + id));
        existing.setName(animal.getName());
        existing.setSpecies(animal.getSpecies());
        existing.setBreed(animal.getBreed());
        existing.setGender(animal.getGender());
        existing.setColour(animal.getColour());
        existing.setDateOfBirth(animal.getDateOfBirth());
        existing.setCustomer(animal.getCustomer());
        return animalRepository.save(existing);
    }

    @Override
    public void delete(Long id) {
        Animal existing = animalRepository.findById(id)
                .orElseThrow(() -> new NotFoundException("Animal not found with id: " + id));
        animalRepository.delete(existing);
    }

    @Override
    public Animal getById(Long id) {
        return animalRepository.findById(id)
                .orElseThrow(() -> new NotFoundException("Animal not found with id: " + id));
    }

    @Override
    public List<Animal> getAll() {
        return animalRepository.findAll();
    }

    @Override
    public List<Animal> getByName(String name) {
        return animalRepository.findByNameContainingIgnoreCase(name);
    }

    @Override
    public List<Animal> getByCustomerId(Long customerId) {
        return animalRepository.findByCustomerId(customerId);
    }
}
