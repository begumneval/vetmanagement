package com.begumneval.vetmanagement.controller;

import com.begumneval.vetmanagement.entity.Animal;
import com.begumneval.vetmanagement.service.AnimalService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/animals")
@RequiredArgsConstructor
public class AnimalController {

    private final AnimalService animalService;

    // Değerlendirme formu 13: Hayvan kayıt işlemi
    @PostMapping
    public ResponseEntity<Animal> save(@RequestBody Animal animal) {
        return new ResponseEntity<>(animalService.save(animal), HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Animal> update(@PathVariable Long id, @RequestBody Animal animal) {
        return ResponseEntity.ok(animalService.update(id, animal));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        animalService.delete(id);
        return ResponseEntity.noContent().build();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Animal> getById(@PathVariable Long id) {
        return ResponseEntity.ok(animalService.getById(id));
    }

    @GetMapping
    public ResponseEntity<List<Animal>> getAll() {
        return ResponseEntity.ok(animalService.getAll());
    }

    // Değerlendirme formu 14: Hayvan isme göre filtreleme
    @GetMapping("/search")
    public ResponseEntity<List<Animal>> getByName(@RequestParam String name) {
        return ResponseEntity.ok(animalService.getByName(name));
    }

    // Değerlendirme formu 15: Müşterinin tüm hayvanlarını listeleme
    @GetMapping("/by-customer")
    public ResponseEntity<List<Animal>> getByCustomerId(@RequestParam Long customerId) {
        return ResponseEntity.ok(animalService.getByCustomerId(customerId));
    }
}
