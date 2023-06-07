package com.scaffolding.scaffolding.service;

import com.scaffolding.scaffolding.dto.LoginDTO;
import com.scaffolding.scaffolding.dto.PasswordDTO;
import com.scaffolding.scaffolding.dto.UserDTO;
import java.util.UUID;

public interface IUserService {

    String newUser(UserDTO user);

    String deleteUser(UUID userId);

    UserDTO getUserById(UUID userId);

    UserDTO getUserByName(String userName);

    String login(LoginDTO body);

    String updatePassword(PasswordDTO body);
}
