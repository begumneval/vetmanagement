package com.begumneval.vetmanagement.controller;

import com.begumneval.vetmanagement.entity.Appointment;
import com.begumneval.vetmanagement.service.AppointmentService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.List;

@RestController
@RequestMapping("/api/appointments")
@RequiredArgsConstructor
public class AppointmentController {

    private final AppointmentService appointmentService;

    // Değerlendirme formu 18: Randevu kayıt işlemi
    @PostMapping
    public ResponseEntity<Appointment> save(@RequestBody Appointment appointment) {
        return new ResponseEntity<>(appointmentService.save(appointment), HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Appointment> update(@PathVariable Long id, @RequestBody Appointment appointment) {
        return ResponseEntity.ok(appointmentService.update(id, appointment));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        appointmentService.delete(id);
        return ResponseEntity.noContent().build();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Appointment> getById(@PathVariable Long id) {
        return ResponseEntity.ok(appointmentService.getById(id));
    }

    @GetMapping
    public ResponseEntity<List<Appointment>> getAll() {
        return ResponseEntity.ok(appointmentService.getAll());
    }

    // Değerlendirme formu 21: Tarih aralığı ve doktora göre filtreleme
    @GetMapping("/by-doctor")
    public ResponseEntity<List<Appointment>> getByDoctorAndDateRange(@RequestParam Long doctorId,
                                                                     @RequestParam LocalDateTime start,
                                                                     @RequestParam LocalDateTime end) {
        return ResponseEntity.ok(appointmentService.getByDoctorAndDateRange(doctorId, start, end));
    }

    // Değerlendirme formu 22: Tarih aralığı ve hayvana göre filtreleme
    @GetMapping("/by-animal")
    public ResponseEntity<List<Appointment>> getByAnimalAndDateRange(@RequestParam Long animalId,
                                                                     @RequestParam LocalDateTime start,
                                                                     @RequestParam LocalDateTime end) {
        return ResponseEntity.ok(appointmentService.getByAnimalAndDateRange(animalId, start, end));
    }
}
