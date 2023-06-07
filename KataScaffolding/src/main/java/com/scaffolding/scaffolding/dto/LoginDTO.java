package com.scaffolding.scaffolding.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class LoginDTO {

    @Pattern(regexp = "[XYZ]?([0-9]{7,8})([A-Z])", message = "El formato del DNI no es correcto")
    private String dni;

    @NotBlank(message = "La contraseña es obligatoria")
    private String password;
}
