package com.funlam.emailservice2.application.service;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class EmailService {

    /**
     * Envía un correo electrónico de bienvenida al usuario registrado
     *
     * @param email Email del destinatario
     * @param nombre Nombre del usuario
     * @param apellido Apellido del usuario
     */
    public void sendWelcomeEmail(String email, String nombre, String apellido) {
        try {
            // TODO: Implementar envío real de email con JavaMailSender o servicio externo
            // Por ahora, simulamos el envío con logs

            String subject = "¡Bienvenido a nuestra plataforma!";
            String body = buildWelcomeEmailBody(nombre, apellido);

            log.info("📧 ===== ENVIANDO EMAIL DE BIENVENIDA =====");
            log.info("📧 Para: {}", email);
            log.info("📧 Asunto: {}", subject);
            log.info("📧 Contenido:\n{}", body);
            log.info("📧 ==========================================");

            // Simular procesamiento
            Thread.sleep(500);

            log.info("✅ Email de bienvenida enviado exitosamente a: {}", email);

        } catch (Exception e) {
            log.error("❌ Error al enviar email de bienvenida a: {}", email, e);
            throw new RuntimeException("Error enviando email de bienvenida", e);
        }
    }

    /**
     * Construye el cuerpo del email de bienvenida
     */
    private String buildWelcomeEmailBody(String nombre, String apellido) {
        return String.format("""
            Hola %s %s,
            
            ¡Bienvenido/a a nuestra plataforma!
            
            Estamos muy contentos de tenerte con nosotros.
            
            Tu cuenta ha sido creada exitosamente y ya puedes comenzar a disfrutar
            de todos nuestros servicios.
            
            Si tienes alguna pregunta, no dudes en contactarnos.
            
            ¡Gracias por unirte!
            
            Saludos cordiales,
            El equipo de FSA
            """, nombre, apellido);
    }

    /**
     * Envía un correo de notificación genérico
     */
    public void sendNotification(String email, String subject, String message) {
        log.info("📧 Enviando notificación a: {} | Asunto: {}", email, subject);
        log.info("📧 Mensaje: {}", message);
    }
}

