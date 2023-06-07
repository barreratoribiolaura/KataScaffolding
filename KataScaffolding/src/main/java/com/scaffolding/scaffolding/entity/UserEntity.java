package com.scaffolding.scaffolding.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.annotation.Nonnull;
import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.UuidGenerator;
import java.util.Date;
import java.util.UUID;

@Entity
@Data
@NoArgsConstructor
public class UserEntity {

    @Id
    @UuidGenerator
    @GeneratedValue(strategy = GenerationType.UUID)
    @JsonIgnore
    private UUID id;

    @Nonnull
    @Column(name = "name",unique = true)
    private String name;

    @Nonnull
    @Column(name = "surnames")
    private String surnames;

    @Nonnull
    @Column(name = "dni",unique = true)
    private String dni;

    @Column(name = "birth_date")
    private Date birthDate;

    @Column(name = "address")
    private String address;

    @Column(name = "postal_code")
    private String postalCode;

    @Column(name = "email")
    private String email;

    public UserEntity(UUID id, @Nonnull String name, @Nonnull String surnames, @Nonnull String dni, Date birthDate, String address, String postalCode, String email) {
        this.id = id;
        this.name = name.toUpperCase();
        this.surnames = surnames.toUpperCase();
        this.dni = dni.toUpperCase();
        this.birthDate = birthDate;
        this.address = address.toUpperCase();
        this.postalCode = postalCode;
        this.email = email;
    }
}
