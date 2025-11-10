package com.funlam.emailservice2.application;

import lombok.extern.slf4j.Slf4j;
import lombok.RequiredArgsConstructor;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

@Service
@Slf4j
@RequiredArgsConstructor
public class EmailService {

    private final JavaMailSender mailSender;

    /**
     * Envía un correo electrónico de bienvenida al usuario registrado
     *
     * @param email Email del destinatario
     * @param nombre Nombre del usuario
     * @param apellido Apellido del usuario
     */
    public void sendWelcomeEmail(String email, String nombre, String apellido) {
        try {
            String subject = "¡Bienvenido a nuestra plataforma!";
            String body = buildWelcomeEmailBody(nombre, apellido);

            SimpleMailMessage message = new SimpleMailMessage();
            message.setTo(email);
            message.setSubject(subject);
            message.setText(body);
            mailSender.send(message);

            log.info("Email de bienvenida enviado exitosamente a: {}", email);
        } catch (Exception e) {
            log.error("Error al enviar email de bienvenida a: {}", email, e);
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
            El equipo de arquitectura de software
            """, nombre, apellido);
    }

    /**
     * Envía un correo de notificación genérico
     */
    public void sendNotification(String email, String subject, String messageText) {
        try {
            SimpleMailMessage message = new SimpleMailMessage();
            message.setTo(email);
            message.setSubject(subject);
            message.setText(messageText);
            mailSender.send(message);
            log.info("Notificación enviada exitosamente a: {}", email);
        } catch (Exception e) {
            log.error("Error al enviar notificación a: {}", email, e);
            throw new RuntimeException("Error enviando notificación", e);
        }
    }
}
