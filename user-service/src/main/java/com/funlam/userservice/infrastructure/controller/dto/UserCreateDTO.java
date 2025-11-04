package com.funlam.userservice.infrastructure.controller.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Schema(description = "Datos para crear un nuevo usuario")
public class UserCreateDTO {

    @Schema(description = "Nombre del usuario", example = "Juan", requiredMode = Schema.RequiredMode.REQUIRED)
    @NotBlank(message = "El nombre es obligatorio")
    @Size(min = 2, max = 100, message = "El nombre debe tener entre 2 y 100 caracteres")
    private String nombre;

    @Schema(description = "Apellido del usuario", example = "Pérez", requiredMode = Schema.RequiredMode.REQUIRED)
    @NotBlank(message = "El apellido es obligatorio")
    @Size(min = 2, max = 100, message = "El apellido debe tener entre 2 y 100 caracteres")
    private String apellido;

    @Schema(description = "Edad del usuario", example = "30", requiredMode = Schema.RequiredMode.REQUIRED)
    @NotNull(message = "La edad es obligatoria")
    @Min(value = 0, message = "La edad debe ser mayor o igual a 0")
    @Max(value = 150, message = "La edad debe ser menor o igual a 150")
    private Integer edad;

    @Schema(description = "Correo electrónico del usuario (debe ser único)", example = "juan.perez@example.com", requiredMode = Schema.RequiredMode.REQUIRED)
    @NotBlank(message = "El email es obligatorio")
    @Email(message = "El email debe ser válido")
    private String email;

    @Schema(description = "Número de teléfono del usuario", example = "+573001234567")
    @Pattern(regexp = "^[+]?[0-9]{7,15}$", message = "El teléfono debe ser válido")
    private String telefono;

    @Schema(description = "Dirección del usuario", example = "Calle 123 #45-67")
    @Size(max = 200, message = "La dirección no puede exceder 200 caracteres")
    private String direccion;
}

