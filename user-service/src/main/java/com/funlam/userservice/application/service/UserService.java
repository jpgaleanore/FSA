package com.funlam.userservice.application.service;

import com.funlam.userservice.infrastructure.controller.dto.UserCreateDTO;
import com.funlam.userservice.infrastructure.controller.dto.UserResponseDTO;
import com.funlam.userservice.infrastructure.controller.dto.UserUpdateDTO;
import com.funlam.userservice.infrastructure.messaging.publisher.UserEventPublisher;
import com.funlam.userservice.infrastructure.mapper.UserMapper;
import com.funlam.userservice.domain.model.User;
import com.funlam.userservice.domain.port.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class UserService {

    private final UserRepository userRepository;
    private final UserMapper userMapper;
    private final UserEventPublisher userEventPublisher;

    @Transactional
    public UserResponseDTO createUser(UserCreateDTO dto) {
        // Validar si el email ya existe
        if (userRepository.findByEmail(dto.getEmail()).isPresent()) {
            throw new IllegalArgumentException("El email ya está registrado");
        }

        User user = userMapper.toEntity(dto);
        User savedUser = userRepository.save(user);

        // Publicar evento de usuario registrado
        userEventPublisher.publishUserRegisteredEvent(savedUser);

        return userMapper.toResponseDTO(savedUser);
    }

    @Transactional(readOnly = true)
    public UserResponseDTO getUserById(UUID id) {
        User user = userRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Usuario no encontrado con id: " + id));
        return userMapper.toResponseDTO(user);
    }

    @Transactional(readOnly = true)
    public List<UserResponseDTO> getAllUsers() {
        return userRepository.findAll().stream()
                .map(userMapper::toResponseDTO)
                .collect(Collectors.toList());
    }

    @Transactional
    public UserResponseDTO updateUser(UUID id, UserUpdateDTO dto) {
        User user = userRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Usuario no encontrado con id: " + id));

        // Validar email si se está actualizando
        if (dto.getEmail() != null && !dto.getEmail().equals(user.getEmail())) {
            if (userRepository.findByEmail(dto.getEmail()).isPresent()) {
                throw new IllegalArgumentException("El email ya está registrado");
            }
        }

        userMapper.updateEntityFromDTO(user, dto);
        User updatedUser = userRepository.save(user);
        return userMapper.toResponseDTO(updatedUser);
    }

    @Transactional
    public void deleteUser(UUID id) {
        if (!userRepository.existsById(id)) {
            throw new IllegalArgumentException("Usuario no encontrado con id: " + id);
        }
        userRepository.deleteById(id);
    }
}

