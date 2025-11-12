# Diagramas Arquitectónicos - FSA

Este directorio contiene todos los diagramas arquitectónicos del proyecto FSA en formato PlantUML.

## 📁 Estructura de Diagramas

### Modelo C4

#### 1. Diagrama de Contexto (Nivel 1)
**Archivo:** `c4-context.puml`

Muestra el sistema FSA en su contexto, incluyendo usuarios externos y sistemas externos.

- **Actores:** Usuario Final, Administrador
- **Sistemas Externos:** Servidor SMTP
- **Vista de:** Alto nivel del sistema

#### 2. Diagrama de Contenedores (Nivel 2)
**Archivo:** `c4-container.puml`

Descompone el sistema FSA en contenedores de aplicación e infraestructura.

- **Microservicios:** User Service, Email Service, Metrics Service
- **Infraestructura:** MySQL, Kafka, Schema Registry, Zookeeper
- **Comunicación:** REST, Kafka Protocol, JDBC, SMTP

#### 3. Diagrama de Componentes (Nivel 3)
**Archivo:** `c4-component-user-service.puml`

Detalla los componentes internos del User Service siguiendo arquitectura hexagonal.

- **Capas:** Infrastructure, Application, Domain
- **Componentes:** Controllers, Services, Repositories, Publishers, Mappers
- **Patrones:** Ports & Adapters

### Diagramas UML

#### 4. Diagrama de Clases
**Archivo:** `class-diagram-user-service.puml`

Muestra las clases principales del User Service y sus relaciones.

- **Entidades:** User
- **Interfaces:** UserRepository, JpaUserRepository
- **Servicios:** UserService
- **Controllers:** UserController
- **DTOs:** UserCreateDTO, UserUpdateDTO, UserResponseDTO

#### 5. Diagrama de Paquetes
**Archivo:** `package-diagram-development.puml`

Representa la organización de paquetes y módulos del proyecto (Vista de Desarrollo).

- **Módulos Maven:** fsa (parent), user-service, email-service2, metrics-service
- **Paquetes:** domain, application, infrastructure
- **Dependencias:** Spring Boot, Kafka, MySQL

#### 6. Diagrama de Secuencia
**Archivo:** `sequence-user-registration.puml`

Describe el flujo completo de registro de un usuario.

- **Participantes:** Cliente, Controllers, Services, Repositories, Kafka, Email/Metrics Services
- **Flujo:** Sincrónico (REST) + Asincrónico (Eventos)
- **Resultado:** Usuario guardado, email enviado, métricas actualizadas

#### 7. Diagrama de Actividades
**Archivo:** `activity-diagram-registration.puml`

Muestra el proceso de registro de usuario con todas las decisiones y caminos alternativos.

- **Validaciones:** Datos de entrada, email duplicado
- **Procesamiento:** Sincrónico y asincrónico
- **Manejo de errores:** Reintentos, Dead Letter Queue

### Diagramas de Despliegue

#### 8. Despliegue Local (Docker Compose)
**Archivo:** `deployment-docker.puml`

Arquitectura de despliegue en entorno local de desarrollo.

- **Contenedores:** MySQL, Kafka, Zookeeper, Schema Registry, UIs
- **Procesos JVM:** Microservicios corriendo localmente
- **Red:** fsa-network (bridge)
- **Puertos:** Mapeo de puertos locales

#### 9. Despliegue Productivo (AWS)
**Archivo:** `deployment-production.puml`

Propuesta de arquitectura de despliegue en producción usando AWS.

- **Orquestación:** Kubernetes (EKS)
- **Bases de Datos:** RDS Multi-AZ con read replicas
- **Mensajería:** AWS MSK (Managed Kafka)
- **Balanceo:** Application Load Balancer
- **Escalado:** Horizontal Pod Autoscaler
- **Almacenamiento:** S3 para métricas
- **Email:** AWS SES

## 🔧 Cómo Visualizar los Diagramas

### Opción 1: PlantUML Online
1. Visita [PlantUML Web Server](http://www.plantuml.com/plantuml/uml/)
2. Copia el contenido del archivo `.puml`
3. Pega en el editor y visualiza

### Opción 2: Extensión de VS Code
1. Instala la extensión "PlantUML" de jebbs
2. Abre cualquier archivo `.puml`
3. Presiona `Alt+D` para preview

### Opción 3: IntelliJ IDEA
1. Instala el plugin "PlantUML integration"
2. Abre cualquier archivo `.puml`
3. El preview se muestra automáticamente

### Opción 4: Generación Local
```bash
# Instalar PlantUML
brew install plantuml  # macOS
# o descargar plantuml.jar

# Generar PNG de un diagrama
plantuml c4-context.puml

# Generar SVG
plantuml -tsvg c4-context.puml

# Generar todos los diagramas
plantuml *.puml
```

## 📊 Mapeo de Vistas

### Vistas 4+1

| Vista | Diagramas | Stakeholders |
|-------|-----------|--------------|
| **Vista Lógica** | Class Diagram, Package Diagram | Desarrolladores, Arquitectos |
| **Vista de Desarrollo** | Package Diagram, Component Diagram | Desarrolladores |
| **Vista de Procesos** | Sequence Diagram, Activity Diagram | Integradores, Arquitectos |
| **Vista Física** | Deployment Diagrams (Local y Prod) | DevOps, Ingenieros de Sistemas |
| **Escenarios** | Sequence Diagram, Activity Diagram | Todos los stakeholders |

### Modelo C4

| Nivel | Diagrama | Audiencia | Detalle |
|-------|----------|-----------|---------|
| **Nivel 1: Contexto** | c4-context.puml | Todos | Sistema en contexto |
| **Nivel 2: Contenedores** | c4-container.puml | Arquitectos, Desarrolladores | Aplicaciones y tecnologías |
| **Nivel 3: Componentes** | c4-component-user-service.puml | Desarrolladores | Componentes internos |
| **Nivel 4: Código** | class-diagram-user-service.puml | Desarrolladores | Clases y código |

## 🎨 Convenciones de Color

### Por Tipo de Componente
- **Microservicios:** Azul (#4A90E2)
- **Email Service:** Morado (#9B59B6)
- **Metrics Service:** Naranja (#E67E22)
- **Bases de Datos:** Azul claro (#3498DB)
- **Message Brokers:** Amarillo/Naranja (#F39C12)
- **Sistemas Externos:** Rojo (#E74C3C)
- **Usuarios/Actores:** Verde (#50C878)

## 📝 Nomenclatura de Archivos

Patrón: `{tipo}-{nombre}.puml`

Tipos:
- `c4-*`: Diagramas del modelo C4
- `class-*`: Diagramas de clases
- `package-*`: Diagramas de paquetes
- `sequence-*`: Diagramas de secuencia
- `activity-*`: Diagramas de actividades
- `deployment-*`: Diagramas de despliegue

## 🔄 Mantenimiento

Al actualizar la arquitectura:

1. ✅ Actualizar los diagramas afectados
2. ✅ Verificar consistencia entre diagramas
3. ✅ Regenerar imágenes si se usa CI/CD
4. ✅ Actualizar la documentación en `ARCHITECTURE.md`
5. ✅ Revisar que las vistas 4+1 estén completas

## 📚 Referencias

- [PlantUML Documentation](https://plantuml.com/)
- [C4 Model](https://c4model.com/)
- [C4-PlantUML](https://github.com/plantuml-stdlib/C4-PlantUML)
- [UML Diagrams](https://www.uml-diagrams.org/)

---

**Última actualización:** Noviembre 2025
