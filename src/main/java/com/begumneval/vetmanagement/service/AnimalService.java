package com.begumneval.vetmanagement.service;

import com.begumneval.vetmanagement.entity.Animal;
import java.util.List;

public interface AnimalService {
    // Değerlendirme formu 6: Katmanlı mimari - service interface katmanı oluşturuldu

    Animal save(Animal animal);
    Animal update(Long id, Animal animal);
    void delete(Long id);
    Animal getById(Long id);
    List<Animal> getAll();
    List<Animal> getByName(String name);
    List<Animal> getByCustomerId(Long customerId);
}
