package com.begumneval.vetmanagement.service;

import com.begumneval.vetmanagement.entity.Vaccine;
import java.time.LocalDate;
import java.util.List;

public interface VaccineService {
    // Değerlendirme formu 6: Katmanlı mimari - service interface katmanı oluşturuldu

    Vaccine save(Vaccine vaccine);
    Vaccine update(Long id, Vaccine vaccine);
    void delete(Long id);
    Vaccine getById(Long id);
    List<Vaccine> getAll();

    List<Vaccine> getByAnimalId(Long animalId);
    List<Vaccine> getByProtectionFinishDateBetween(LocalDate start, LocalDate end);
}
