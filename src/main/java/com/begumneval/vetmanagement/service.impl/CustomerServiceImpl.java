package com.begumneval.vetmanagement.service.impl;

import com.begumneval.vetmanagement.entity.Customer;
import com.begumneval.vetmanagement.exception.NotFoundException;
import com.begumneval.vetmanagement.repository.CustomerRepository;
import com.begumneval.vetmanagement.service.CustomerService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CustomerServiceImpl implements CustomerService {

    private final CustomerRepository customerRepository;

    @Override
    // Değerlendirme formu 10: Customer kayıt işlemi
    public Customer save(Customer customer) {
        return customerRepository.save(customer);
    }

    @Override
    // Değerlendirme formu 11: Customer güncelleme işlemi
    public Customer update(Long id, Customer customer) {
        Customer existing = customerRepository.findById(id)
                .orElseThrow(() -> new NotFoundException("Customer not found with id: " + id));
        existing.setName(customer.getName());
        existing.setPhone(customer.getPhone());
        existing.setMail(customer.getMail());
        existing.setAddress(customer.getAddress());
        existing.setCity(customer.getCity());
        return customerRepository.save(existing);
    }

    @Override
    // Değerlendirme formu 11: Customer silme işlemi
    public void delete(Long id) {
        Customer existing = customerRepository.findById(id)
                .orElseThrow(() -> new NotFoundException("Customer not found with id: " + id));
        customerRepository.delete(existing);
    }

    @Override
    // Değerlendirme formu 10: Customer id ile getirme
    public Customer getById(Long id) {
        return customerRepository.findById(id)
                .orElseThrow(() -> new NotFoundException("Customer not found with id: " + id));
    }

    @Override
    // Değerlendirme formu 10: Tüm Customer kayıtlarını getirme
    public List<Customer> getAll() {
        return customerRepository.findAll();
    }

    @Override
    // Değerlendirme formu 12: Customer isme göre filtreleme
    public List<Customer> getByName(String name) {
        return customerRepository.findByNameContainingIgnoreCase(name);
    }
}
