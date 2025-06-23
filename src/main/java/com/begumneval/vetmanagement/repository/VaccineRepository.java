package com.begumneval.vetmanagement.repository;

import com.begumneval.vetmanagement.entity.Vaccine;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;

@Repository
public interface VaccineRepository extends JpaRepository<Vaccine, Long> {
    // Değerlendirme formu 6: Katmanlı mimari - repository katmanı oluşturuldu

    // Değerlendirme formu 25: Belirli hayvana ait aşı kayıtlarını listeleme
    List<Vaccine> findByAnimalId(Long animalId);

    // Değerlendirme formu 24: Koruyuculuk bitiş tarihi aralığına göre filtreleme
    List<Vaccine> findByProtectionFinishDateBetween(LocalDate start, LocalDate end);

    // Değerlendirme formu 23: Aynı tür aktif aşının varlığını kontrol
    boolean existsByAnimalIdAndNameAndCodeAndProtectionFinishDateAfter(Long animalId, String name, String code, LocalDate date);
}
