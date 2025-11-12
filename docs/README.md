# Documentación del Proyecto FSA

Esta carpeta contiene toda la documentación arquitectónica y técnica del proyecto.

## 📚 Contenido

### 📄 Documentos Principales

1. **[ARCHITECTURE.md](../ARCHITECTURE.md)** - Documentación arquitectónica completa
   - Modelo C4 (4 niveles)
   - Vistas 4+1 de Kruchten
   - Decisiones arquitectónicas (ADRs)
   - Patrones y calidad de atributos

### 📊 Diagramas

Todos los diagramas arquitectónicos en formato PlantUML están en el directorio [`diagrams/`](diagrams/).

#### Modelo C4
- [Nivel 1: Contexto del Sistema](diagrams/c4-context.puml)
- [Nivel 2: Contenedores](diagrams/c4-container.puml)
- [Nivel 3: Componentes - User Service](diagrams/c4-component-user-service.puml)
- Nivel 4: Código - Ver [diagrama de clases](diagrams/class-diagram-user-service.puml)

#### Vistas 4+1
- **Vista Lógica:** [Diagrama de Clases](diagrams/class-diagram-user-service.puml)
- **Vista de Desarrollo:** [Diagrama de Paquetes](diagrams/package-diagram-development.puml)
- **Vista de Procesos:** [Secuencia de Registro](diagrams/sequence-user-registration.puml), [Actividades](diagrams/activity-diagram-registration.puml)
- **Vista Física:** [Despliegue Docker](diagrams/deployment-docker.puml), [Despliegue Producción](diagrams/deployment-production.puml)
- **Escenarios:** Incluidos en diagramas de secuencia y actividades

## 🎯 Guía Rápida por Rol

### Para Desarrolladores
1. Lee [ARCHITECTURE.md - Nivel 3 y 4](../ARCHITECTURE.md#nivel-3-componentes)
2. Revisa [Diagrama de Clases](diagrams/class-diagram-user-service.puml)
3. Consulta [Diagrama de Paquetes](diagrams/package-diagram-development.puml)
4. Estudia [Secuencia de Registro](diagrams/sequence-user-registration.puml)

### Para Arquitectos
1. Lee [ARCHITECTURE.md completo](../ARCHITECTURE.md)
2. Revisa [Modelo C4 completo](diagrams/)
3. Estudia [Decisiones Arquitectónicas](../ARCHITECTURE.md#decisiones-arquitectónicas-adrs)
4. Consulta [Patrones de Integración](../ARCHITECTURE.md#patrones-de-integración)

### Para DevOps/SRE
1. Revisa [Vista Física](../ARCHITECTURE.md#vista-física)
2. Consulta [Despliegue Docker](diagrams/deployment-docker.puml)
3. Estudia [Despliegue Producción](diagrams/deployment-production.puml)
4. Lee [Estrategias de Escalabilidad](../ARCHITECTURE.md#escalabilidad-y-disponibilidad)

### Para Product Owners
1. Lee [Introducción y Contexto](../ARCHITECTURE.md#introducción)
2. Revisa [Diagrama de Contexto C4](diagrams/c4-context.puml)
3. Consulta [Escenarios de Uso](../ARCHITECTURE.md#escenarios-casos-de-uso)

## 🔍 Índice de Diagramas

| Diagrama | Tipo | Vista | Propósito |
|----------|------|-------|-----------|
| c4-context | C4 Nivel 1 | Contexto | Sistema en su entorno |
| c4-container | C4 Nivel 2 | Contenedores | Aplicaciones y tecnologías |
| c4-component-user-service | C4 Nivel 3 | Componentes | Estructura interna |
| class-diagram-user-service | UML Clases | Lógica/Código | Diseño detallado |
| package-diagram-development | UML Paquetes | Desarrollo | Organización del código |
| sequence-user-registration | UML Secuencia | Procesos | Flujo de registro |
| activity-diagram-registration | UML Actividades | Procesos | Lógica de proceso |
| deployment-docker | UML Despliegue | Física | Entorno local |
| deployment-production | UML Despliegue | Física | Entorno productivo |

## 🛠️ Herramientas

### Visualización de Diagramas

**PlantUML:**
- Web: http://www.plantuml.com/plantuml/uml/
- VS Code: Extensión "PlantUML"
- IntelliJ: Plugin "PlantUML integration"

**Mermaid:**
- Live Editor: https://mermaid.live/
- GitHub: Renderiza automáticamente en Markdown
- VS Code: Extensión "Markdown Preview Mermaid Support"

### Generación Local

```bash
# Instalar PlantUML
brew install plantuml  # macOS
sudo apt-get install plantuml  # Linux

# Generar todos los diagramas
cd docs/diagrams
plantuml *.puml

# Generar en formato SVG (vectorial)
plantuml -tsvg *.puml
```

## 📐 Estándares de Documentación

### Nomenclatura
- Archivos: kebab-case (ejemplo: `deployment-docker.puml`)
- Títulos: Title Case con contexto
- Variables PlantUML: snake_case

### Estructura de Diagramas PlantUML
```plantuml
@startuml NombreDescriptivo
!theme plain

title Título Descriptivo - Tipo de Vista

' Contenido del diagrama

note right/left
  Notas explicativas importantes
end note

@enduml
```

### Control de Versiones
- Cada cambio arquitectónico actualiza los diagramas
- Commits deben referenciar diagramas actualizados
- Tags de Git marcan versiones de arquitectura

## 🔄 Proceso de Actualización

Cuando cambies la arquitectura:

1. **Código primero:** Implementa el cambio
2. **Actualiza diagramas:** Modifica los archivos `.puml` afectados
3. **Verifica consistencia:** Asegúrate que todos los diagramas estén alineados
4. **Actualiza ARCHITECTURE.md:** Refleja los cambios en la documentación
5. **Regenera imágenes:** Si usas imágenes estáticas
6. **Commit:** Incluye código + diagramas + docs en el mismo commit

## 📊 Matriz de Trazabilidad

| Requisito | Componente | Diagrama |
|-----------|------------|----------|
| REQ-001: Registro de usuarios | UserService, UserController | c4-component, sequence-user-registration |
| REQ-002: Notificaciones email | EmailService | c4-container, sequence-user-registration |
| REQ-003: Métricas de usuarios | MetricsService | c4-container, sequence-user-registration |
| REQ-004: Persistencia de datos | MySQL, UserRepository | c4-container, class-diagram |
| REQ-005: Comunicación asíncrona | Kafka, Event Publishers/Listeners | c4-container, sequence-user-registration |

## 🎓 Conceptos Clave

### Modelo C4
Framework de diagramas arquitectónicos con 4 niveles de abstracción:
1. **Contexto:** Sistema y usuarios
2. **Contenedores:** Aplicaciones ejecutables
3. **Componentes:** Módulos dentro de contenedores
4. **Código:** Clases e interfaces

### Vistas 4+1
Modelo de Kruchten que describe arquitectura desde 5 perspectivas:
1. **Lógica:** Funcionalidad para usuarios
2. **Desarrollo:** Organización del código
3. **Procesos:** Runtime, concurrencia
4. **Física:** Hardware, deployment
5. **Escenarios:** Casos de uso que unen las vistas

## 📞 Contacto

Para preguntas sobre la arquitectura:
- Revisa primero [ARCHITECTURE.md](../ARCHITECTURE.md)
- Consulta los diagramas en [`diagrams/`](diagrams/)
- Si aún tienes dudas, contacta al equipo de arquitectura

---

**Última actualización:** Noviembre 2025  
**Versión de documentación:** 1.0.0
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

