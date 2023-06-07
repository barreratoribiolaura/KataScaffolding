package com.scaffolding.scaffolding.repository;

import com.scaffolding.scaffolding.entity.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.UUID;

public interface UserRepository extends JpaRepository<UserEntity,Integer> {

    UserEntity findById(UUID userId);

    UserEntity findByName(String name);

    Boolean existsByDni(String dni);

    UserEntity findByDni(String dni);
}
