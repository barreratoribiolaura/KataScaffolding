package com.scaffolding.scaffolding.dto;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import java.util.UUID;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserDTO {

    @JsonIgnore
    private UUID Id;

    @NotBlank(message = "El nombre es obligatorio")
    private String name;

    @NotBlank(message = "El apellido es obligatorio")
    private String surnames;

    @NotBlank(message = "El DNI es obligatorio")
    @Pattern(regexp = "[XYZ]?([0-9]{7,8})([A-Z])", message = "El formato del DNI no es correcto")
    private String dni;

    private String birthDate;

    private String address;

    private String postalCode;

    private String email;
}
