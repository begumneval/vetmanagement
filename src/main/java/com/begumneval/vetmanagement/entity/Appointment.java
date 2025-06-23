package com.begumneval.vetmanagement.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;
import java.time.LocalDateTime;

@Entity
@Table(name = "appointments")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Appointment {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    // Değerlendirme formu 4: Entity'ler doğru şekilde tanımlanmış mı?

    private LocalDateTime appointmentDate;
    // Değerlendirme formu 4: Entity'ler doğru şekilde tanımlanmış mı?

    @ManyToOne
    @JoinColumn(name = "doctor_id")
    private Doctor doctor;
    // Değerlendirme formu 5: Entity'ler arası ilişki doğru tanımlanmış mı? (ManyToOne - Doctor)

    @ManyToOne
    @JoinColumn(name = "animal_id")
    private Animal animal;
    // Değerlendirme formu 5: Entity'ler arası ilişki doğru tanımlanmış mı? (ManyToOne - Animal)
}
