package com.begumneval.vetmanagement.service.impl;

import com.begumneval.vetmanagement.entity.Doctor;
import com.begumneval.vetmanagement.exception.NotFoundException;
import com.begumneval.vetmanagement.repository.DoctorRepository;
import com.begumneval.vetmanagement.service.DoctorService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class DoctorServiceImpl implements DoctorService {
    private final DoctorRepository doctorRepository;

    @Override
    public Doctor save(Doctor doctor) {
        return doctorRepository.save(doctor);
    }

    @Override
    public Doctor update(Long id, Doctor doctor) {
        Doctor existing = doctorRepository.findById(id)
                .orElseThrow(() -> new NotFoundException("Doctor not found with id: " + id));
        existing.setName(doctor.getName());
        existing.setPhone(doctor.getPhone());
        existing.setMail(doctor.getMail());
        existing.setAddress(doctor.getAddress());
        existing.setCity(doctor.getCity());
        return doctorRepository.save(existing);
    }

    @Override
    public void delete(Long id) {
        Doctor existing = doctorRepository.findById(id)
                .orElseThrow(() -> new NotFoundException("Doctor not found with id: " + id));
        doctorRepository.delete(existing);
    }

    @Override
    public Doctor getById(Long id) {
        return doctorRepository.findById(id)
                .orElseThrow(() -> new NotFoundException("Doctor not found with id: " + id));
    }

    @Override
    public List<Doctor> getAll() {
        return doctorRepository.findAll();
    }
}
