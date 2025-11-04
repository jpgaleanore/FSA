package com.funlam.userservice.infrastructure.messaging.publisher;

import com.funlam.userservice.domain.model.User;
import com.funlam.userservice.events.UserRegisteredEvent;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.cloud.stream.function.StreamBridge;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
@Slf4j
public class UserEventPublisher {

    private final StreamBridge streamBridge;
    private static final String USER_REGISTER_BINDING = "userRegister-out-0";

    public void publishUserRegisteredEvent(User user) {
        try {
            UserRegisteredEvent event = UserRegisteredEvent.newBuilder()
                    .setId(user.getId().toString())
                    .setNombre(user.getNombre())
                    .setApellido(user.getApellido())
                    .setEdad(user.getEdad())
                    .setEmail(user.getEmail())
                    .setTelefono(user.getTelefono())
                    .setDireccion(user.getDireccion())
                    .setTimestamp(System.currentTimeMillis())
                    .build();

            boolean sent = streamBridge.send(USER_REGISTER_BINDING, event);

            if (sent) {
                log.info("UserRegisteredEvent publicado exitosamente para usuario: {} ({})",
                        user.getEmail(), user.getId());
            } else {
                log.error("Error al publicar UserRegisteredEvent para usuario: {}", user.getId());
            }
        } catch (Exception e) {
            log.error("Error al construir o publicar UserRegisteredEvent para usuario: {}", user.getId(), e);
        }
    }
}

