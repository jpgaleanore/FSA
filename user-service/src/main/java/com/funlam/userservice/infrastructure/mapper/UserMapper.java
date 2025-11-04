package com.funlam.userservice.infrastructure.mapper;

import com.funlam.userservice.infrastructure.controller.dto.UserCreateDTO;
import com.funlam.userservice.infrastructure.controller.dto.UserResponseDTO;
import com.funlam.userservice.infrastructure.controller.dto.UserUpdateDTO;
import com.funlam.userservice.domain.model.User;
import org.springframework.stereotype.Component;

@Component
public class UserMapper {

    public User toEntity(UserCreateDTO dto) {
        return User.builder()
                .nombre(dto.getNombre())
                .apellido(dto.getApellido())
                .edad(dto.getEdad())
                .email(dto.getEmail())
                .telefono(dto.getTelefono())
                .direccion(dto.getDireccion())
                .build();
    }

    public UserResponseDTO toResponseDTO(User user) {
        return UserResponseDTO.builder()
                .id(user.getId())
                .nombre(user.getNombre())
                .apellido(user.getApellido())
                .edad(user.getEdad())
                .email(user.getEmail())
                .telefono(user.getTelefono())
                .direccion(user.getDireccion())
                .build();
    }

    public void updateEntityFromDTO(User user, UserUpdateDTO dto) {
        if (dto.getNombre() != null) {
            user.setNombre(dto.getNombre());
        }
        if (dto.getApellido() != null) {
            user.setApellido(dto.getApellido());
        }
        if (dto.getEdad() != null) {
            user.setEdad(dto.getEdad());
        }
        if (dto.getEmail() != null) {
            user.setEmail(dto.getEmail());
        }
        if (dto.getTelefono() != null) {
            user.setTelefono(dto.getTelefono());
        }
        if (dto.getDireccion() != null) {
            user.setDireccion(dto.getDireccion());
        }
    }
}

