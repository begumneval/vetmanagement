package com.begumneval.vetmanagement.repository;

import com.begumneval.vetmanagement.entity.Appointment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.List;

@Repository
public interface AppointmentRepository extends JpaRepository<Appointment, Long> {
    // Değerlendirme formu 6: Katmanlı mimari - repository katmanı oluşturuldu

    // Değerlendirme formu 20: Randevu çakışması kontrolü
    boolean existsByDoctorIdAndAppointmentDate(Long doctorId, LocalDateTime dateTime);

    // Değerlendirme formu 22: Tarih aralığı ve hayvana göre filtreleme
    List<Appointment> findByAnimalIdAndAppointmentDateBetween(Long animalId, LocalDateTime start, LocalDateTime end);

    // Değerlendirme formu 21: Tarih aralığı ve doktora göre filtreleme
    List<Appointment> findByDoctorIdAndAppointmentDateBetween(Long doctorId, LocalDateTime start, LocalDateTime end);
}
