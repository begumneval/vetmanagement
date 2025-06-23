package com.begumneval.vetmanagement.service.impl;

import com.begumneval.vetmanagement.entity.AvailableDate;
import com.begumneval.vetmanagement.exception.NotFoundException;
import com.begumneval.vetmanagement.repository.AvailableDateRepository;
import com.begumneval.vetmanagement.service.AvailableDateService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
@RequiredArgsConstructor
public class AvailableDateServiceImpl implements AvailableDateService {
    private final AvailableDateRepository availableDateRepository;

    @Override
    public AvailableDate save(AvailableDate availableDate) {
        return availableDateRepository.save(availableDate);
    }

    @Override
    public AvailableDate update(Long id, AvailableDate availableDate) {
        AvailableDate existing = availableDateRepository.findById(id)
                .orElseThrow(() -> new NotFoundException("AvailableDate not found with id: " + id));
        existing.setAvailableDate(availableDate.getAvailableDate());
        existing.setDoctor(availableDate.getDoctor());
        return availableDateRepository.save(existing);
    }

    @Override
    public void delete(Long id) {
        AvailableDate existing = availableDateRepository.findById(id)
                .orElseThrow(() -> new NotFoundException("AvailableDate not found with id: " + id));
        availableDateRepository.delete(existing);
    }

    @Override
    public AvailableDate getById(Long id) {
        return availableDateRepository.findById(id)
                .orElseThrow(() -> new NotFoundException("AvailableDate not found with id: " + id));
    }

    @Override
    public List<AvailableDate> getAll() {
        return availableDateRepository.findAll();
    }

    @Override
    public boolean existsByDoctorIdAndDate(Long doctorId, LocalDate date) {
        return availableDateRepository.existsByDoctorIdAndAvailableDate(doctorId, date);
    }

    @Override
    public List<AvailableDate> getByDoctorId(Long doctorId) {
        return availableDateRepository.findByDoctorId(doctorId);
    }
}
