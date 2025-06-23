package com.begumneval.vetmanagement.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;
import java.time.LocalDate;

@Entity
@Table(name = "available_dates")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class AvailableDate {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    // Değerlendirme formu 4: Entity'ler doğru şekilde tanımlanmış mı?

    private LocalDate availableDate;
    // Değerlendirme formu 4: Entity'ler doğru şekilde tanımlanmış mı?

    @ManyToOne
    @JoinColumn(name = "doctor_id")
    private Doctor doctor;
    // Değerlendirme formu 5: Entity'ler arası ilişki doğru tanımlanmış mı? (ManyToOne - Doctor)
}
