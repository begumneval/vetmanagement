package com.begumneval.vetmanagement.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "animals")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Animal {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    // Değerlendirme formu 4: Entity'ler doğru şekilde tanımlanmış mı?

    private String name;
    private String species;
    private String breed;
    private String gender;
    private String colour;
    private LocalDate dateOfBirth;

    @ManyToOne
    @JoinColumn(name = "customer_id")
    private Customer customer;
    // Değerlendirme formu 5: Entity'ler arası ilişki doğru tanımlanmış mı? (ManyToOne)

    @OneToMany(mappedBy = "animal", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Vaccine> vaccines = new ArrayList<>();
    // Değerlendirme formu 5: Entity'ler arası ilişki doğru tanımlanmış mı? (OneToMany - Vaccine)

    @OneToMany(mappedBy = "animal", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Appointment> appointments = new ArrayList<>();
    // Değerlendirme formu 5: Entity'ler arası ilişki doğru tanımlanmış mı? (OneToMany - Appointment)
}
