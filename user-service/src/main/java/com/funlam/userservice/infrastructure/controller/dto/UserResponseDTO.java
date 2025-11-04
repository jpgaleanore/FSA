package com.funlam.userservice.infrastructure.controller.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.UUID;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Schema(description = "Respuesta con los datos de un usuario")
public class UserResponseDTO {

    @Schema(description = "Identificador único del usuario (UUID)", example = "550e8400-e29b-41d4-a716-446655440000")
    private UUID id;

    @Schema(description = "Nombre del usuario", example = "Juan")
    private String nombre;

    @Schema(description = "Apellido del usuario", example = "Pérez")
    private String apellido;

    @Schema(description = "Edad del usuario", example = "30")
    private Integer edad;

    @Schema(description = "Correo electrónico del usuario", example = "juan.perez@example.com")
    private String email;

    @Schema(description = "Número de teléfono del usuario", example = "+573001234567")
    private String telefono;

    @Schema(description = "Dirección del usuario", example = "Calle 123 #45-67")
    private String direccion;
}

