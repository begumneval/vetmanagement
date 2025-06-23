package com.begumneval.vetmanagement.service;

import com.begumneval.vetmanagement.entity.Appointment;
import java.time.LocalDateTime;
import java.util.List;

public interface AppointmentService {
    // Değerlendirme formu 6: Katmanlı mimari - service interface katmanı oluşturuldu

    Appointment save(Appointment appointment);
    Appointment update(Long id, Appointment appointment);
    void delete(Long id);
    Appointment getById(Long id);
    List<Appointment> getAll();

    List<Appointment> getByDoctorAndDateRange(Long doctorId, LocalDateTime start, LocalDateTime end);
    List<Appointment> getByAnimalAndDateRange(Long animalId, LocalDateTime start, LocalDateTime end);
}
