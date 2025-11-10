package com.funlam.emailservice2.infrastructure.messaging.listeners;

import com.funlam.emailservice2.application.EmailService;
import lombok.extern.slf4j.Slf4j;
import org.apache.avro.generic.GenericRecord;
import org.springframework.messaging.Message;
import org.springframework.stereotype.Component;

import java.time.Instant;
import java.util.function.Consumer;

@Component
@Slf4j
public class UserRegisterListener implements Consumer<Message<GenericRecord>> {

    private final EmailService emailService;

    public UserRegisterListener(EmailService emailService) {
        this.emailService = emailService;
    }

    @Override
    public void accept(Message<GenericRecord> genericRecordMessage) {

        GenericRecord event = genericRecordMessage.getPayload();

        try {
            // Extraer campos del GenericRecord usando get("nombreCampo")
            String id = event.get("id").toString();
            String nombre = event.get("nombre").toString();
            String apellido = event.get("apellido").toString();
            String email = event.get("email").toString();
            Integer edad = (Integer) event.get("edad");
            String telefono = event.get("telefono") != null ? event.get("telefono").toString() : "N/A";
            String direccion = event.get("direccion") != null ? event.get("direccion").toString() : "N/A";
            Long timestamp = (Long) event.get("timestamp");

            log.info("===== EVENTO DE USUARIO RECIBIDO =====");
            log.info("ID Usuario: {}", id);
            log.info("Nombre: {} {}", nombre, apellido);
            log.info("Email: {}", email);
            log.info("Edad: {}", edad);
            log.info("Teléfono: {}", telefono);
            log.info("Dirección: {}", direccion);
            log.info("Timestamp: {}", Instant.ofEpochMilli(timestamp));
            log.info("=======================================");

            // Enviar email de bienvenida
            emailService.sendWelcomeEmail(email, nombre, apellido);

            log.info("Evento procesado exitosamente para usuario: {}", email);

        } catch (Exception e) {
            log.error("Error procesando evento de usuario", e);
            throw e;
        }
    }
}

