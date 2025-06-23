package com.begumneval.vetmanagement.service.impl;

import com.begumneval.vetmanagement.entity.Vaccine;
import com.begumneval.vetmanagement.exception.BusinessException;
import com.begumneval.vetmanagement.exception.NotFoundException;
import com.begumneval.vetmanagement.repository.VaccineRepository;
import com.begumneval.vetmanagement.service.VaccineService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
@RequiredArgsConstructor
public class VaccineServiceImpl implements VaccineService {
    private final VaccineRepository vaccineRepository;

    @Override
    public Vaccine save(Vaccine vaccine) {
        // Değerlendirme formu 23: Aynı tür aktif aşı kontrolü
        boolean exists = vaccineRepository.existsByAnimalIdAndNameAndCodeAndProtectionFinishDateAfter(
                vaccine.getAnimal().getId(),
                vaccine.getName(),
                vaccine.getCode(),
                LocalDate.now()
        );
        if (exists) {
            throw new BusinessException("An active vaccine of the same type already exists for this animal.");
        }
        return vaccineRepository.save(vaccine);
    }

    @Override
    public Vaccine update(Long id, Vaccine vaccine) {
        Vaccine existing = vaccineRepository.findById(id)
                .orElseThrow(() -> new NotFoundException("Vaccine not found with id: " + id));
        existing.setName(vaccine.getName());
        existing.setCode(vaccine.getCode());
        existing.setProtectionStartDate(vaccine.getProtectionStartDate());
        existing.setProtectionFinishDate(vaccine.getProtectionFinishDate());
        existing.setAnimal(vaccine.getAnimal());
        return vaccineRepository.save(existing);
    }

    @Override
    public void delete(Long id) {
        Vaccine existing = vaccineRepository.findById(id)
                .orElseThrow(() -> new NotFoundException("Vaccine not found with id: " + id));
        vaccineRepository.delete(existing);
    }

    @Override
    public Vaccine getById(Long id) {
        return vaccineRepository.findById(id)
                .orElseThrow(() -> new NotFoundException("Vaccine not found with id: " + id));
    }

    @Override
    public List<Vaccine> getAll() {
        return vaccineRepository.findAll();
    }

    @Override
    public List<Vaccine> getByAnimalId(Long animalId) {
        return vaccineRepository.findByAnimalId(animalId);
    }

    @Override
    public List<Vaccine> getByProtectionFinishDateBetween(LocalDate start, LocalDate end) {
        return vaccineRepository.findByProtectionFinishDateBetween(start, end);
    }
}
