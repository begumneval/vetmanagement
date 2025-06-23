package com.begumneval.vetmanagement.controller;

import com.begumneval.vetmanagement.entity.Customer;
import com.begumneval.vetmanagement.service.CustomerService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/customers")
@RequiredArgsConstructor
public class CustomerController {

    private final CustomerService customerService;

    // Değerlendirme formu 10: Customer kayıt işlemi
    @PostMapping
    public ResponseEntity<Customer> save(@RequestBody Customer customer) {
        return new ResponseEntity<>(customerService.save(customer), HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Customer> update(@PathVariable Long id, @RequestBody Customer customer) {
        return ResponseEntity.ok(customerService.update(id, customer));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        customerService.delete(id);
        return ResponseEntity.noContent().build();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Customer> getById(@PathVariable Long id) {
        return ResponseEntity.ok(customerService.getById(id));
    }

    @GetMapping
    public ResponseEntity<List<Customer>> getAll() {
        return ResponseEntity.ok(customerService.getAll());
    }

    // Değerlendirme formu 12: Customer isme göre filtreleme
    @GetMapping("/search")
    public ResponseEntity<List<Customer>> getByName(@RequestParam String name) {
        return ResponseEntity.ok(customerService.getByName(name));
    }
}
