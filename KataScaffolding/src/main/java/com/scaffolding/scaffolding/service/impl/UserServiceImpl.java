package com.scaffolding.scaffolding.service.impl;

import com.scaffolding.scaffolding.dto.LoginDTO;
import com.scaffolding.scaffolding.dto.PasswordDTO;
import com.scaffolding.scaffolding.dto.UserDTO;
import com.scaffolding.scaffolding.entity.PasswordEntity;
import com.scaffolding.scaffolding.entity.UserEntity;
import com.scaffolding.scaffolding.repository.PasswordRepository;
import com.scaffolding.scaffolding.repository.UserRepository;
import com.scaffolding.scaffolding.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.Date;
import java.util.UUID;

@Service
public class UserServiceImpl implements IUserService {

    @Autowired
    UserRepository userRepository;

    @Autowired
    PasswordRepository passwordRepository;

    @Override
    public String newUser(UserDTO user) {
        UserEntity userEntity = new UserEntity(user.getId(),user.getName(),user.getSurnames(),user.getDni(),new Date(user.getBirthDate()),user.getAddress(),user.getPostalCode(),user.getEmail());
        userRepository.save(userEntity);
        PasswordEntity passwordEntity = new PasswordEntity(userEntity);
        passwordRepository.save(passwordEntity);
        return passwordEntity.getId().toString();
    }

    @Override
    public String deleteUser(UUID userId) {
        UserEntity userEntity = userRepository.findById(userId);
        if (userEntity==null) return "Ese usuario no existe";
        PasswordEntity password = passwordRepository.findByUser_Id(userId);
        passwordRepository.delete(password);
        userRepository.delete(userEntity);
        return "El usuario "+userEntity.getName()+" ha sido eliminado";
    }

    @Override
    public UserDTO getUserById(UUID userId) {
        UserEntity userEntity = userRepository.findById(userId);
        if(userEntity==null) return null;
        UserDTO userDTO = new UserDTO(userEntity.getId(),userEntity.getName(),userEntity.getSurnames(),userEntity.getDni(),userEntity.getBirthDate().toString(),userEntity.getAddress(),userEntity.getPostalCode(),userEntity.getEmail());
        return userDTO;
    }

    @Override
    public UserDTO getUserByName(String userName) {
        UserEntity userEntity = userRepository.findByName(userName);
        if(userEntity==null) return null;
        UserDTO userDTO = new UserDTO(userEntity.getId(),userEntity.getName(),userEntity.getSurnames(),userEntity.getDni(),userEntity.getBirthDate().toString(),userEntity.getAddress(),userEntity.getPostalCode(),userEntity.getEmail());
        return userDTO;
    }

    @Override
    public String login(LoginDTO body) {
        return validatePassword(body.getPassword()) && validateDNI(body.getDni())
                ? "Has iniciado sesión correctamente" : "Datos incorrectos";
    }

    private Boolean validatePassword(String passwordValue) {
        return passwordRepository.existsByPassword(passwordValue);
    }

    private Boolean validateDNI(String dni) {
        return userRepository.existsByDni(dni);
    }

    @Override
    public String updatePassword(PasswordDTO body) {
        if (!validateDNI(body.getDni())) return "El DNI es incorrecto";
        if (!validatePassword(body.getExistingPassword())) return "La contraseña actual es incorrecta";
        PasswordEntity newPassword = passwordRepository.findPasswordByPassword(body.getExistingPassword());
        newPassword.setPassword(body.getNewPassword());
        passwordRepository.saveAndFlush(newPassword);
        return "Contraseña actualizada correctamente";
    }
}
