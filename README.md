# FSA - Final Project Of Software Architecture

Proyecto modular de microservicios con Spring Boot y Maven.

## 🐳 Inicio Rápido con Docker

### Prerequisitos
- Docker
- Docker Compose
- Java 21
- Maven

### 1. Iniciar Infraestructura
```bash
# Iniciar MySQL y otros servicios
docker-compose up -d

# Verificar que MySQL esté corriendo
docker-compose ps
```

### 2. Ejecutar Microservicio
```bash
# Compilar el proyecto
mvn clean install

# Ejecutar user-service
cd user-service
mvn spring-boot:run
```

### 3. Acceder a Swagger UI
```
http://localhost:8081/swagger-ui.html
```

📖 **Documentación completa de Docker:** [DOCKER.md](DOCKER.md)

---

## Estructura del Proyecto

Este es un proyecto multi-módulo de Maven donde el POM principal (`fsa`) actúa como padre de todos los microservicios.

```
fsa/
├── pom.xml (Parent POM)
├── email-service/
│   ├── pom.xml
│   └── src/
└── user-service/
    ├── pom.xml
    └── src/
```

## Configuración Maven

### POM Principal (Parent)
- **GroupId**: `com.funlam`
- **ArtifactId**: `fsa`
- **Version**: `0.0.1-SNAPSHOT`
- **Packaging**: `pom`
- **Parent**: `spring-boot-starter-parent` 3.5.7

### Módulos
Los siguientes microservicios están configurados como módulos del proyecto principal:
1. `email-service`
2. `user-service`

Cada módulo hereda del POM principal (`fsa`) la configuración común:
- Versión de Java: 21
- Spring Boot: 3.5.7
- Plugins y configuraciones de compilación

## Comandos Maven

### Compilar todo el proyecto (desde la raíz)
```bash
mvn clean install
```

### Validar la configuración
```bash
mvn validate
```

### Compilar solo un microservicio específico
```bash
cd email-service
mvn clean install
```

### Ejecutar tests de todos los módulos
```bash
mvn test
```

### Ejecutar un microservicio
```bash
cd email-service
mvn spring-boot:run
```

o

```bash
cd user-service
mvn spring-boot:run
```

## Ventajas de esta Configuración

1. **Gestión centralizada**: Todas las dependencias y versiones se gestionan desde el POM principal
2. **Construcción en cadena**: Maven compila todos los módulos en orden con el Reactor
3. **Configuración compartida**: Los plugins y propiedades se heredan automáticamente
4. **Versionado unificado**: Todos los módulos comparten la misma versión del proyecto

## Agregar Nuevos Microservicios

Para agregar un nuevo microservicio:

1. Crear el directorio del nuevo servicio
2. Crear su `pom.xml` con el parent apuntando a `fsa`:
```xml
<parent>
    <groupId>com.funlam</groupId>
    <artifactId>fsa</artifactId>
    <version>0.0.1-SNAPSHOT</version>
    <relativePath>../pom.xml</relativePath>
</parent>
```
3. Agregar el módulo al POM principal en la sección `<modules>`:
```xml
<modules>
    <module>email-service</module>
    <module>user-service</module>
    <module>nuevo-servicio</module>
</modules>
```

## Tecnologías

- Java 21
- Spring Boot 3.5.7
- Maven
- Spring Boot Starter (Web, Test, Actuator, Data JDBC disponibles)
- Lombok (configurado en el parent)

