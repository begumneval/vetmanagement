package com.begumneval.vetmanagement.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;
import java.time.LocalDate;

@Entity
@Table(name = "vaccines")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Vaccine {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    // Değerlendirme formu 4: Entity'ler doğru şekilde tanımlanmış mı?

    private String name;
    private String code;
    private LocalDate protectionStartDate;
    private LocalDate protectionFinishDate;
    // Değerlendirme formu 4: Entity'ler doğru şekilde tanımlanmış mı?

    @ManyToOne
    @JoinColumn(name = "animal_id")
    private Animal animal;
    // Değerlendirme formu 5: Entity'ler arası ilişki doğru tanımlanmış mı? (ManyToOne - Animal)
}
