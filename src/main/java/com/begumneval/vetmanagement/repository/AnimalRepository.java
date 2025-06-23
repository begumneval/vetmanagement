package com.begumneval.vetmanagement.repository;

import com.begumneval.vetmanagement.entity.Animal;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AnimalRepository extends JpaRepository<Animal, Long> {
    // Değerlendirme formu 6: Katmanlı mimari - repository katmanı oluşturuldu

    // Değerlendirme formu 14: Animal ismine göre filtreleme için sorgu
    List<Animal> findByNameContainingIgnoreCase(String name);

    // Değerlendirme formu 15: Bir müşteri için hayvanları listeleme
    List<Animal> findByCustomerId(Long customerId);
}
