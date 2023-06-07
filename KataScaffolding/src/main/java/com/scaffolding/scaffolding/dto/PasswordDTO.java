package com.scaffolding.scaffolding.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class PasswordDTO {

    @Pattern(regexp = "[XYZ]?([0-9]{7,8})([A-Z])", message = "El formato del DNI no es correcto")
    private String dni;

    @NotBlank(message = "La actual contraseña es obligatoria")
    private String existingPassword;

    @NotBlank(message = "La nueva contraseña es obligatoria")
    @Pattern(regexp = "^(?=.*[A-Za-z])(?=.*\\d)[A-Za-z\\d]{8,}$", message = "El formato de la contraseña no es correcto")
    private String newPassword;
}
