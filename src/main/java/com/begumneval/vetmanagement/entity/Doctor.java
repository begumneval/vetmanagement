package com.begumneval.vetmanagement.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "doctors")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Doctor {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    // Değerlendirme formu 4: Entity'ler doğru şekilde tanımlanmış mı?

    private String name;
    private String phone;
    private String mail;
    private String address;
    private String city;

    @OneToMany(mappedBy = "doctor", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<AvailableDate> availableDates = new ArrayList<>();
    // Değerlendirme formu 5: Entity'ler arası ilişki doğru tanımlanmış mı? (OneToMany - AvailableDate)

    @OneToMany(mappedBy = "doctor", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Appointment> appointments = new ArrayList<>();
    // Değerlendirme formu 5: Entity'ler arası ilişki doğru tanımlanmış mı? (OneToMany - Appointment)
}
