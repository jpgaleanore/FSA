# Glosario de Términos - Arquitectura FSA

> Definiciones de conceptos técnicos y arquitectónicos utilizados en el proyecto

---

## 📖 Términos Arquitectónicos

### A

**ADR (Architecture Decision Record)**  
Documento que registra una decisión arquitectónica importante, su contexto, alternativas consideradas y consecuencias. Permite entender el "por qué" de las decisiones tomadas.

**API (Application Programming Interface)**  
Interfaz que permite la comunicación entre diferentes componentes de software. En FSA, el User Service expone una API REST.

**API REST (Representational State Transfer)**  
Estilo de arquitectura para servicios web que usa HTTP y sus métodos (GET, POST, PUT, DELETE) para operaciones CRUD.

**Arquitectura Hexagonal**  
También conocida como "Ports & Adapters". Patrón arquitectónico que separa la lógica de negocio del dominio de los detalles técnicos de infraestructura.

**Asíncrono**  
Procesamiento que no requiere espera inmediata. El emisor continúa sin bloquear mientras la tarea se completa en segundo plano.

**Avro**  
Framework de serialización binaria de Apache que usa schemas para definir la estructura de datos. Más eficiente que JSON para grandes volúmenes.

### B

**Broker (Message Broker)**  
Sistema intermediario que gestiona el intercambio de mensajes entre aplicaciones. En FSA usamos Apache Kafka como broker.

**Business Logic**  
Lógica de negocio. Reglas y algoritmos que definen cómo se procesan los datos según los requisitos del negocio.

### C

**C4 Model**  
Framework para visualizar arquitectura de software en 4 niveles de abstracción: Context, Containers, Components, Code.

**CQRS (Command Query Responsibility Segregation)**  
Patrón que separa las operaciones de lectura (queries) de las de escritura (commands). En FSA, User Service escribe y Metrics Service lee.

**Cluster**  
Grupo de servidores que trabajan juntos como un sistema unificado para proveer alta disponibilidad y escalabilidad.

**Consumer (Consumidor)**  
Componente que lee y procesa mensajes de un topic. En FSA, Email Service y Metrics Service son consumidores.

**Consumer Group**  
Grupo de consumidores que comparten la carga de procesamiento de un topic de Kafka, garantizando que cada mensaje se procese solo una vez por grupo.

**Container**  
En el contexto del Modelo C4, una aplicación o almacén de datos ejecutable. En Docker, una instancia aislada de ejecución.

**CRUD**  
Create, Read, Update, Delete. Operaciones básicas de persistencia de datos.

### D

**Dead Letter Queue (DLQ)**  
Cola especial donde se envían mensajes que no pudieron procesarse exitosamente después de varios reintentos.

**Deployment (Despliegue)**  
Proceso de instalar y configurar una aplicación en un entorno de ejecución.

**Domain Model**  
Modelo que representa conceptos del negocio y sus relaciones. En FSA, la clase `User` es parte del domain model.

**DTO (Data Transfer Object)**  
Objeto usado para transferir datos entre capas o servicios sin lógica de negocio. Ejemplos: `UserCreateDTO`, `UserResponseDTO`.

### E

**EDA (Event-Driven Architecture)**  
Arquitectura basada en eventos donde los componentes se comunican mediante la publicación y suscripción a eventos.

**Event (Evento)**  
Notificación de que algo significativo ocurrió en el sistema. Ejemplo: `UserRegisteredEvent`.

**Event Sourcing**  
Patrón donde los cambios de estado se almacenan como secuencia de eventos en lugar de solo el estado actual.

**Eventual Consistency**  
Modelo de consistencia donde los datos eventualmente serán consistentes en todos los nodos, pero pueden estar temporalmente desincronizados.

### H

**Hexagonal Architecture**  
Ver "Arquitectura Hexagonal".

**High Availability (HA)**  
Capacidad de un sistema de estar operativo y accesible la mayor parte del tiempo, típicamente medido en "nueves" (99.9%, 99.99%, etc.).

**Horizontal Scaling**  
Escalabilidad horizontal. Agregar más instancias/servidores para distribuir la carga. Opuesto a vertical scaling.

### I

**Idempotent (Idempotente)**  
Operación que produce el mismo resultado si se ejecuta una o múltiples veces. Importante para reintentos seguros.

**Infrastructure Layer**  
Capa que contiene detalles técnicos como bases de datos, APIs REST, mensajería. Se conecta al mundo exterior.

### J

**JPA (Java Persistence API)**  
API estándar de Java para mapeo objeto-relacional (ORM). Spring Data JPA simplifica el acceso a datos.

**JSON (JavaScript Object Notation)**  
Formato ligero de intercambio de datos, fácil de leer para humanos y procesar para máquinas.

### K

**Kafka**  
Plataforma distribuida de streaming de eventos de Apache. Usado en FSA como message broker central.

**Kafka Connect**  
Framework para conectar Kafka con sistemas externos (bases de datos, sistemas de archivos, etc.).

**Kafka Topic**  
Canal nombrado donde se publican y consumen mensajes. Ejemplo: `userRegister`.

### L

**Load Balancer**  
Distribuidor de carga. Componente que distribuye peticiones entrantes entre múltiples instancias de un servicio.

**Logging**  
Registro de eventos y actividades del sistema para debugging, auditoría y monitoreo.

### M

**Microservicio**  
Arquitectura donde una aplicación se compone de servicios pequeños, independientes y desplegables por separado.

**Mapper**  
Componente que transforma objetos de un tipo a otro. Ejemplo: `UserMapper` convierte entre DTOs y entidades.

**Message Queue**  
Cola de mensajes donde los productores envían mensajes y los consumidores los reciben de forma asíncrona.

**Multi-AZ (Multi Availability Zone)**  
Despliegue en múltiples zonas de disponibilidad para alta disponibilidad y recuperación ante desastres.

**MySQL**  
Sistema de gestión de bases de datos relacional de código abierto. Usado en FSA para almacenar usuarios.

### O

**Observability (Observabilidad)**  
Capacidad de entender el estado interno de un sistema basándose en sus salidas (logs, métricas, traces).

**ORM (Object-Relational Mapping)**  
Técnica para convertir datos entre sistemas de tipos incompatibles (objetos ↔ tablas relacionales).

### P

**Partition (Partición)**  
División lógica de un topic de Kafka que permite paralelismo y escalabilidad.

**PlantUML**  
Herramienta para crear diagramas UML usando lenguaje de texto simple.

**Port**  
En Arquitectura Hexagonal, interfaz que define cómo el dominio interactúa con el exterior. Ejemplo: `UserRepository`.

**Producer (Productor)**  
Componente que publica mensajes a un topic. En FSA, `UserEventPublisher` es un productor.

**Publisher-Subscriber (Pub-Sub)**  
Patrón de mensajería donde publishers envían mensajes a topics y subscribers los reciben sin acoplamiento directo.

### R

**Read Replica**  
Copia de solo lectura de una base de datos que se mantiene sincronizada con la principal. Mejora rendimiento de lecturas.

**Replication Factor**  
Número de copias de datos mantenidas en un cluster de Kafka para redundancia y tolerancia a fallos.

**Repository Pattern**  
Patrón que abstrae el acceso a datos, proporcionando una interfaz de colección para el dominio.

**REST (Representational State Transfer)**  
Ver "API REST".

**Retry Policy**  
Estrategia que define cómo y cuántas veces reintentar una operación fallida.

### S

**Saga Pattern**  
Patrón para manejar transacciones distribuidas en microservicios mediante secuencia de transacciones locales.

**Scalability (Escalabilidad)**  
Capacidad de un sistema de manejar crecimiento de carga mediante adición de recursos.

**Schema**  
Definición de la estructura de datos. En Kafka/Avro, define campos y tipos de un evento.

**Schema Registry**  
Servicio de Confluent que gestiona y valida schemas de Avro para eventos de Kafka.

**Serialization (Serialización)**  
Proceso de convertir objetos en un formato que puede ser almacenado o transmitido (bytes, JSON, Avro).

**Service Layer**  
Capa que contiene la lógica de aplicación y casos de uso. Orquesta operaciones del dominio.

**SMTP (Simple Mail Transfer Protocol)**  
Protocolo estándar para envío de correos electrónicos. FSA usa Gmail SMTP.

**Spring Boot**  
Framework de Java que simplifica la creación de aplicaciones empresariales con configuración mínima.

**Spring Cloud Stream**  
Framework de Spring para construir aplicaciones de mensajería event-driven con brokers como Kafka.

**Swagger**  
Herramienta para documentar APIs REST de forma interactiva. También conocido como OpenAPI.

**Synchronous (Síncrono)**  
Procesamiento que requiere espera hasta completarse. El emisor bloquea hasta recibir respuesta.

### T

**Topic**  
Ver "Kafka Topic".

**Throughput**  
Cantidad de trabajo que un sistema puede procesar en un período de tiempo (ej: requests/segundo).

**Transaction**  
Secuencia de operaciones que se ejecutan como unidad atómica (todo o nada).

### U

**UUID (Universally Unique Identifier)**  
Identificador único de 128 bits. En FSA, cada usuario tiene un UUID como ID.

### V

**Vertical Scaling**  
Escalabilidad vertical. Aumentar recursos (CPU, RAM) de un servidor existente. Opuesto a horizontal scaling.

**Volume (Docker)**  
Mecanismo para persistir datos generados y usados por contenedores Docker.

### Z

**Zookeeper**  
Servicio de coordinación distribuido usado por Kafka para gestión de cluster y metadatos.

---

## 🎨 Patrones de Diseño

### Adapter Pattern
Convierte la interfaz de una clase en otra que los clientes esperan. En FSA, `UserRepositoryAdapter` adapta JPA al puerto del dominio.

### Builder Pattern
Construye objetos complejos paso a paso. Usado con Lombok `@Builder` en entidades de FSA.

### Dependency Injection
Técnica donde las dependencias son provistas externamente en lugar de crearse internamente. Spring Boot lo maneja automáticamente.

### Factory Pattern
Crea objetos sin especificar la clase exacta. Spring usa factories para crear beans.

### Observer Pattern
Múltiples objetos (observers) se suscriben a cambios de un sujeto. Base del patrón Publisher-Subscriber.

### Repository Pattern
Encapsula lógica de acceso a datos proveyendo interfaz de colección. Ejemplos: `UserRepository`, `JpaUserRepository`.

### Singleton Pattern
Garantiza que una clase tenga solo una instancia. Spring beans son singletons por defecto.

### Strategy Pattern
Define familia de algoritmos intercambiables. Usado en validaciones y mappers.

---

## 🏗️ Conceptos de Infraestructura

### Auto-scaling
Ajuste automático de recursos basado en métricas como CPU, memoria o tráfico.

### Blue-Green Deployment
Estrategia de deployment donde se mantienen dos ambientes (blue y green) y se cambia el tráfico entre ellos.

### CI/CD (Continuous Integration/Continuous Deployment)
Prácticas de integración y despliegue continuo automatizado.

### Container Orchestration
Gestión automatizada de contenedores. Kubernetes es la plataforma más popular.

### Health Check
Endpoint o mecanismo que verifica si un servicio está operativo y saludable.

### Kubernetes (K8s)
Plataforma de orquestación de contenedores para automatizar deployment, scaling y gestión de aplicaciones.

### Service Discovery
Mecanismo para que servicios se encuentren entre sí dinámicamente sin configuración hardcodeada.

---

## 📊 Métricas y Monitoreo

### APM (Application Performance Monitoring)
Monitoreo del rendimiento y disponibilidad de aplicaciones.

### Latency (Latencia)
Tiempo que toma procesar una petición desde que se recibe hasta que se responde.

### P95, P99 (Percentiles)
Percentil 95 o 99. Indica que el 95% o 99% de las peticiones están bajo ese tiempo. Mejor métrica que el promedio.

### SLA (Service Level Agreement)
Acuerdo de nivel de servicio. Define métricas de disponibilidad y rendimiento garantizadas.

### SLI (Service Level Indicator)
Indicador de nivel de servicio. Métrica cuantificable (ej: latencia, uptime).

### SLO (Service Level Objective)
Objetivo de nivel de servicio. Valor específico o rango de un SLI (ej: latencia < 200ms).

### Uptime
Porcentaje de tiempo que un sistema está operativo. 99.9% = ~8.76 horas de downtime/año.

---

## 🔐 Seguridad

### Authentication (Autenticación)
Proceso de verificar la identidad de un usuario o sistema.

### Authorization (Autorización)
Proceso de determinar qué puede hacer un usuario autenticado.

### JWT (JSON Web Token)
Token de acceso compacto y auto-contenido usado para autenticación sin estado.

### OAuth 2.0
Framework de autorización que permite a aplicaciones obtener acceso limitado a recursos.

### TLS/SSL (Transport Layer Security)
Protocolo criptográfico para comunicaciones seguras. HTTPS usa TLS.

---

## 💻 Tecnologías Específicas

### Apache POI
Biblioteca Java para leer y escribir archivos de Microsoft Office (Excel, Word, PowerPoint).

### Docker Compose
Herramienta para definir y ejecutar aplicaciones Docker multi-contenedor.

### HikariCP
Connection pool de alto rendimiento para JDBC usado por Spring Boot por defecto.

### JavaMailSender
API de Spring para envío de correos electrónicos.

### Lombok
Biblioteca Java que genera código repetitivo (getters, setters, constructores) mediante anotaciones.

### Maven
Herramienta de gestión y construcción de proyectos Java.

### Spring Data JPA
Abstracción de Spring sobre JPA que simplifica el acceso a datos relacionales.

### Tomcat
Servidor web y contenedor de servlets. Spring Boot lo incluye embebido.

---

## 📚 Acrónimos Comunes

| Acrónimo | Significado | Contexto |
|----------|-------------|----------|
| **ACID** | Atomicity, Consistency, Isolation, Durability | Propiedades de transacciones |
| **AWS** | Amazon Web Services | Proveedor cloud |
| **EKS** | Elastic Kubernetes Service | Kubernetes en AWS |
| **HA** | High Availability | Alta disponibilidad |
| **HTTP** | HyperText Transfer Protocol | Protocolo web |
| **JDBC** | Java Database Connectivity | API de acceso a BD |
| **JSON** | JavaScript Object Notation | Formato de datos |
| **JVM** | Java Virtual Machine | Máquina virtual Java |
| **MSK** | Managed Streaming for Kafka | Kafka en AWS |
| **MVC** | Model-View-Controller | Patrón arquitectónico |
| **ORM** | Object-Relational Mapping | Mapeo objeto-relacional |
| **POI** | Poor Obfuscation Implementation | Biblioteca Apache |
| **RDS** | Relational Database Service | Base de datos en AWS |
| **S3** | Simple Storage Service | Almacenamiento en AWS |
| **SES** | Simple Email Service | Email en AWS |
| **UUID** | Universally Unique Identifier | Identificador único |
| **YAML** | YAML Ain't Markup Language | Formato de configuración |

---

## 🔄 Conceptos de Vistas 4+1

### Vista Lógica
Perspectiva de funcionalidad del sistema para usuarios finales. Incluye clases, paquetes y sus relaciones.

### Vista de Desarrollo
Perspectiva de organización del código para desarrolladores. Incluye módulos, capas y dependencias.

### Vista de Procesos
Perspectiva de runtime del sistema. Incluye concurrencia, sincronización y flujos de ejecución.

### Vista Física
Perspectiva de deployment e infraestructura. Incluye servidores, redes y distribución de componentes.

### Escenarios (Vista +1)
Casos de uso que ilustran cómo las otras vistas trabajan juntas para cumplir requisitos.

---

## 📖 Referencias y Recursos

### Libros Recomendados
- **"Building Microservices"** - Sam Newman
- **"Domain-Driven Design"** - Eric Evans
- **"Clean Architecture"** - Robert C. Martin
- **"Designing Data-Intensive Applications"** - Martin Kleppmann

### Sitios Web Útiles
- **Martin Fowler's Blog:** https://martinfowler.com/
- **C4 Model:** https://c4model.com/
- **Spring Documentation:** https://spring.io/docs
- **Apache Kafka:** https://kafka.apache.org/documentation/

### Comunidades
- **Stack Overflow:** Para preguntas técnicas específicas
- **Reddit r/microservices:** Discusiones sobre arquitectura
- **Spring Community:** https://spring.io/community

---

**Última actualización:** Noviembre 2025  
**Mantenido por:** Equipo FSA

