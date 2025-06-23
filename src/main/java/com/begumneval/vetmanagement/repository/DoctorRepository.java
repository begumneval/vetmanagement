package com.begumneval.vetmanagement.repository;

import com.begumneval.vetmanagement.entity.Doctor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DoctorRepository extends JpaRepository<Doctor, Long> {
    // Değerlendirme formu 6: Katmanlı mimari - repository katmanı oluşturuldu
}
