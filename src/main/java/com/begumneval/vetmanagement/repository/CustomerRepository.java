package com.begumneval.vetmanagement.repository;

import com.begumneval.vetmanagement.entity.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CustomerRepository extends JpaRepository<Customer, Long> {
    // Değerlendirme formu 6: Katmanlı mimari - repository katmanı oluşturuldu

    // Değerlendirme formu 12: Customer ismine göre filtreleme için sorgu
    List<Customer> findByNameContainingIgnoreCase(String name);
}
