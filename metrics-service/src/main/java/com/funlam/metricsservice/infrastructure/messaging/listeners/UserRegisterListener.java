package com.funlam.metricsservice.infrastructure.messaging.listeners;

import com.funlam.metricsservice.application.ExcelMetricsService;
import lombok.extern.slf4j.Slf4j;
import org.apache.avro.generic.GenericRecord;
import org.springframework.messaging.Message;
import org.springframework.stereotype.Component;

import java.time.Instant;
import java.util.function.Consumer;

@Component
@Slf4j
public class UserRegisterListener implements Consumer<Message<GenericRecord>> {

    private final ExcelMetricsService excelMetricsService;

    public UserRegisterListener(ExcelMetricsService excelMetricsService) {
        this.excelMetricsService = excelMetricsService;
    }

    @Override
    public void accept(Message<GenericRecord> genericRecordMessage) {
        GenericRecord event = genericRecordMessage.getPayload();

        try {
            // Extraer campos del GenericRecord
            String id = event.get("id").toString();
            String nombre = event.get("nombre").toString();
            String apellido = event.get("apellido").toString();
            String email = event.get("email").toString();
            Integer edad = (Integer) event.get("edad");
            String telefono = event.get("telefono") != null ? event.get("telefono").toString() : null;
            String direccion = event.get("direccion") != null ? event.get("direccion").toString() : null;
            Long timestamp = (Long) event.get("timestamp");

            log.info("===== EVENTO DE USUARIO RECIBIDO EN METRICS SERVICE =====");
            log.info("ID Usuario: {}", id);
            log.info("Nombre: {} {}", nombre, apellido);
            log.info("Email: {}", email);
            log.info("Edad: {}", edad);
            log.info("Teléfono: {}", telefono);
            log.info("Dirección: {}", direccion);
            log.info("Timestamp: {}", Instant.ofEpochMilli(timestamp));
            log.info("==========================================================");

            // Guardar en Excel
            excelMetricsService.recordUserRegistration(id, nombre, apellido, email, edad, telefono, direccion, timestamp);

            log.info("Evento procesado y guardado en Excel exitosamente para usuario: {}", email);

        } catch (Exception e) {
            log.error("Error procesando evento de usuario en metrics service", e);
            throw e;
        }
    }
}

