package com.begumneval.vetmanagement.controller;

import com.begumneval.vetmanagement.entity.Vaccine;
import com.begumneval.vetmanagement.service.VaccineService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;

@RestController
@RequestMapping("/api/vaccines")
@RequiredArgsConstructor
public class VaccineController {

    private final VaccineService vaccineService;

    // Değerlendirme formu 23: Aşı kayıt işlemi (koruyuculuk kontrolü service'te var)
    @PostMapping
    public ResponseEntity<Vaccine> save(@RequestBody Vaccine vaccine) {
        return new ResponseEntity<>(vaccineService.save(vaccine), HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Vaccine> update(@PathVariable Long id, @RequestBody Vaccine vaccine) {
        return ResponseEntity.ok(vaccineService.update(id, vaccine));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        vaccineService.delete(id);
        return ResponseEntity.noContent().build();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Vaccine> getById(@PathVariable Long id) {
        return ResponseEntity.ok(vaccineService.getById(id));
    }

    @GetMapping
    public ResponseEntity<List<Vaccine>> getAll() {
        return ResponseEntity.ok(vaccineService.getAll());
    }

    // Değerlendirme formu 24: Koruyuculuk bitiş tarihi aralığı filtreleme
    @GetMapping("/by-protection-finish-date")
    public ResponseEntity<List<Vaccine>> getByProtectionFinishDateBetween(
            @RequestParam LocalDate start,
            @RequestParam LocalDate end) {
        return ResponseEntity.ok(vaccineService.getByProtectionFinishDateBetween(start, end));
    }

    // Değerlendirme formu 25: Belirli hayvana ait tüm aşı kayıtları
    @GetMapping("/by-animal")
    public ResponseEntity<List<Vaccine>> getByAnimalId(@RequestParam Long animalId) {
        return ResponseEntity.ok(vaccineService.getByAnimalId(animalId));
    }
}
