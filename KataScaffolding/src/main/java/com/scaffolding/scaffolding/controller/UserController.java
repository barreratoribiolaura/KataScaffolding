package com.scaffolding.scaffolding.controller;

import com.scaffolding.scaffolding.dto.LoginDTO;
import com.scaffolding.scaffolding.dto.PasswordDTO;
import com.scaffolding.scaffolding.dto.UserDTO;
import com.scaffolding.scaffolding.service.impl.UserServiceImpl;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.UUID;

@RestController
public class UserController implements IUserController{

    @Autowired
    UserServiceImpl userService;

    @Override
    @GetMapping("/getUserById/{user_id}")
    public UserDTO getUserById(@PathVariable("user_id") UUID userId) {
        return userService.getUserById(userId);
    }

    @GetMapping("/getUserByName/{name}")
    private UserDTO getUserByName(@PathVariable("name") String userName) {
        return userService.getUserByName(userName);
    }

    @PostMapping("/newUser")
    private String newUser(@Valid @RequestBody UserDTO user) {
        return userService.newUser(user);
    }

    @PostMapping("/login")
    private String login(@Valid @RequestBody LoginDTO body) {
        return userService.login(body);
    }

    @PatchMapping("/updatePassword")
    private String updatePassword(@Valid @RequestBody PasswordDTO body) {
        return userService.updatePassword(body);
    }

    @DeleteMapping("/deleteUser/{user_id}")
    private String deleteUser(@PathVariable("user_id") UUID userId) {
        return userService.deleteUser(userId);
    }
}
