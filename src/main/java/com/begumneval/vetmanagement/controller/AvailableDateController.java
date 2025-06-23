package com.begumneval.vetmanagement.controller;

import com.begumneval.vetmanagement.entity.AvailableDate;
import com.begumneval.vetmanagement.service.AvailableDateService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/available-dates")
@RequiredArgsConstructor
public class AvailableDateController {

    private final AvailableDateService availableDateService;

    // Değerlendirme formu 17: Doktorun müsait günü kayıt işlemi
    @PostMapping
    public ResponseEntity<AvailableDate> save(@RequestBody AvailableDate availableDate) {
        return new ResponseEntity<>(availableDateService.save(availableDate), HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<AvailableDate> update(@PathVariable Long id, @RequestBody AvailableDate availableDate) {
        return ResponseEntity.ok(availableDateService.update(id, availableDate));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        availableDateService.delete(id);
        return ResponseEntity.noContent().build();
    }

    @GetMapping("/{id}")
    public ResponseEntity<AvailableDate> getById(@PathVariable Long id) {
        return ResponseEntity.ok(availableDateService.getById(id));
    }

    @GetMapping
    public ResponseEntity<List<AvailableDate>> getAll() {
        return ResponseEntity.ok(availableDateService.getAll());
    }

    // Değerlendirme formu 17: Doktorun müsait günlerini doktor ID'ye göre listeleme
    @GetMapping("/doctor/{doctorId}")
    public ResponseEntity<List<AvailableDate>> getByDoctorId(@PathVariable Long doctorId) {
        return ResponseEntity.ok(availableDateService.getByDoctorId(doctorId));
    }

}

