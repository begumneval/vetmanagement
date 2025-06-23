package com.begumneval.vetmanagement.service;

import com.begumneval.vetmanagement.entity.AvailableDate;
import java.time.LocalDate;
import java.util.List;

public interface AvailableDateService {
    // Değerlendirme formu 6: Katmanlı mimari - service interface katmanı oluşturuldu

    AvailableDate save(AvailableDate availableDate);
    AvailableDate update(Long id, AvailableDate availableDate);
    void delete(Long id);
    AvailableDate getById(Long id);
    List<AvailableDate> getAll();
    boolean existsByDoctorIdAndDate(Long doctorId, LocalDate date);
    List<AvailableDate> getByDoctorId(Long doctorId);
}
