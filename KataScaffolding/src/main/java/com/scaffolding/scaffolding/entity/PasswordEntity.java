package com.scaffolding.scaffolding.entity;

import jakarta.annotation.Nonnull;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.UuidGenerator;
import java.util.UUID;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class PasswordEntity {


    @UuidGenerator
    @GeneratedValue(strategy = GenerationType.UUID)
    @Column(name = "password_id")
    @Id
    private UUID id;

    @Nonnull
    @OneToOne
    @JoinColumn(name = "user_id")
    private UserEntity user;

    @Column(name = "password")
    private String password = UUID.randomUUID().toString();

    public PasswordEntity(@Nonnull UserEntity user) {
        this.user = user;
    }
}
