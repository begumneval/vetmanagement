package com.begumneval.vetmanagement.controller;

import com.begumneval.vetmanagement.entity.Doctor;
import com.begumneval.vetmanagement.service.DoctorService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/doctors")
@RequiredArgsConstructor
public class DoctorController {

    private final DoctorService doctorService;

    // Değerlendirme formu 16: Doktor kayıt işlemi
    @PostMapping
    public ResponseEntity<Doctor> save(@RequestBody Doctor doctor) {
        return new ResponseEntity<>(doctorService.save(doctor), HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Doctor> update(@PathVariable Long id, @RequestBody Doctor doctor) {
        return ResponseEntity.ok(doctorService.update(id, doctor));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        doctorService.delete(id);
        return ResponseEntity.noContent().build();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Doctor> getById(@PathVariable Long id) {
        return ResponseEntity.ok(doctorService.getById(id));
    }

    @GetMapping
    public ResponseEntity<List<Doctor>> getAll() {
        return ResponseEntity.ok(doctorService.getAll());
    }
}
