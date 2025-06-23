package com.begumneval.vetmanagement.repository;

import com.begumneval.vetmanagement.entity.AvailableDate;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AvailableDateRepository extends JpaRepository<AvailableDate, Long> {
    // Değerlendirme formu 6: Katmanlı mimari - repository katmanı oluşturuldu

    // Değerlendirme formu 19: Doktorun belirli tarihte müsaitliği kontrolü
    boolean existsByDoctorIdAndAvailableDate(Long doctorId, java.time.LocalDate date);
    List<AvailableDate> findByDoctorId(Long doctorId);
}

