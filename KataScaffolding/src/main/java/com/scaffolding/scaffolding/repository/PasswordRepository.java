package com.scaffolding.scaffolding.repository;

import com.scaffolding.scaffolding.entity.PasswordEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.UUID;

public interface PasswordRepository extends JpaRepository<PasswordEntity,Integer> {

    PasswordEntity findByUser_Id(UUID userId);

    PasswordEntity findPasswordByPassword(String password);

    Boolean existsByPassword(String password);

}
