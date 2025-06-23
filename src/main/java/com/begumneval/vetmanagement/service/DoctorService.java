package com.begumneval.vetmanagement.service;

import com.begumneval.vetmanagement.entity.Doctor;
import java.util.List;

public interface DoctorService {
    // Değerlendirme formu 6: Katmanlı mimari - service interface katmanı oluşturuldu

    Doctor save(Doctor doctor);
    Doctor update(Long id, Doctor doctor);
    void delete(Long id);
    Doctor getById(Long id);
    List<Doctor> getAll();
}
