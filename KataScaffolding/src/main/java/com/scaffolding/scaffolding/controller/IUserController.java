package com.scaffolding.scaffolding.controller;

import com.scaffolding.scaffolding.dto.UserDTO;
import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.info.Info;
import io.swagger.v3.oas.annotations.responses.ApiResponse;

import java.util.UUID;

@OpenAPIDefinition(
        info = @Info(
                title = "Kata Spring",
                description = "Estas viendo el swagger de la Kata de Spring"
        )
)
public interface IUserController {

    @Operation(summary = "Get an User by his ID",
            tags = "User",
            description = "This endpoint is design to get an user by his id",
            responses = {@ApiResponse(responseCode = "200", description = "success")})
    UserDTO getUserById(UUID userId);
}
