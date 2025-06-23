package com.begumneval.vetmanagement.service;

import com.begumneval.vetmanagement.entity.Customer;
import java.util.List;

public interface CustomerService {
    // Değerlendirme formu 6: Katmanlı mimari - service interface katmanı oluşturuldu

    Customer save(Customer customer);
    Customer update(Long id, Customer customer);
    void delete(Long id);
    Customer getById(Long id);
    List<Customer> getAll();
    List<Customer> getByName(String name);
}
