package com.begumneval.vetmanagement.service.impl;

import com.begumneval.vetmanagement.entity.Appointment;
import com.begumneval.vetmanagement.exception.BusinessException;
import com.begumneval.vetmanagement.exception.NotFoundException;
import com.begumneval.vetmanagement.repository.AppointmentRepository;
import com.begumneval.vetmanagement.repository.AvailableDateRepository;
import com.begumneval.vetmanagement.service.AppointmentService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
@RequiredArgsConstructor
public class AppointmentServiceImpl implements AppointmentService {
    private final AppointmentRepository appointmentRepository;
    private final AvailableDateRepository availableDateRepository;

    @Override
    public Appointment save(Appointment appointment) {
        Long doctorId = appointment.getDoctor().getId();
        LocalDateTime dateTime = appointment.getAppointmentDate();

        // Değerlendirme formu 19: Doktorun o gün çalışıyor mu kontrolü
        boolean hasAvailableDate = availableDateRepository.existsByDoctorIdAndAvailableDate(doctorId, dateTime.toLocalDate());
        if (!hasAvailableDate) {
            throw new BusinessException("Doctor is not available on this date!");
        }

        // Değerlendirme formu 20: Çakışan randevu kontrolü
        boolean hasConflict = appointmentRepository.existsByDoctorIdAndAppointmentDate(doctorId, dateTime);
        if (hasConflict) {
            throw new BusinessException("Doctor already has an appointment at this time!");
        }

        return appointmentRepository.save(appointment);
    }

    @Override
    public Appointment update(Long id, Appointment appointment) {
        Appointment existing = appointmentRepository.findById(id)
                .orElseThrow(() -> new NotFoundException("Appointment not found with id: " + id));
        existing.setAppointmentDate(appointment.getAppointmentDate());
        existing.setDoctor(appointment.getDoctor());
        existing.setAnimal(appointment.getAnimal());
        return appointmentRepository.save(existing);
    }

    @Override
    public void delete(Long id) {
        Appointment existing = appointmentRepository.findById(id)
                .orElseThrow(() -> new NotFoundException("Appointment not found with id: " + id));
        appointmentRepository.delete(existing);
    }

    @Override
    public Appointment getById(Long id) {
        return appointmentRepository.findById(id)
                .orElseThrow(() -> new NotFoundException("Appointment not found with id: " + id));
    }

    @Override
    public List<Appointment> getAll() {
        return appointmentRepository.findAll();
    }

    @Override
    public List<Appointment> getByDoctorAndDateRange(Long doctorId, LocalDateTime start, LocalDateTime end) {
        return appointmentRepository.findByDoctorIdAndAppointmentDateBetween(doctorId, start, end);
    }

    @Override
    public List<Appointment> getByAnimalAndDateRange(Long animalId, LocalDateTime start, LocalDateTime end) {
        return appointmentRepository.findByAnimalIdAndAppointmentDateBetween(animalId, start, end);
    }
}
