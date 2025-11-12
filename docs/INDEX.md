# Índice Visual de Documentación - FSA

> Navegación rápida a toda la documentación del proyecto

---

## 🗺️ Mapa de Documentación

```
📦 FSA Project
│
├─📄 README.md ........................... Introducción al proyecto
├─📄 ARCHITECTURE.md ..................... Documentación arquitectónica completa ⭐
│
├─📁 docs/
│  ├─📄 README.md ........................ Guía de documentación por rol
│  ├─📄 EXECUTIVE_SUMMARY.md ............. Resumen para stakeholders no técnicos
│  │
│  └─📁 diagrams/
│     ├─📄 README.md ..................... Guía de diagramas
│     │
│     ├─🎨 Modelo C4
│     │  ├─ c4-context.puml ............. Nivel 1: Contexto del Sistema
│     │  ├─ c4-container.puml ........... Nivel 2: Contenedores
│     │  ├─ c4-component-user-service.puml . Nivel 3: Componentes
│     │  └─ class-diagram-user-service.puml  Nivel 4: Código
│     │
│     ├─🎨 Vistas 4+1
│     │  ├─ class-diagram-user-service.puml ..... Vista Lógica
│     │  ├─ package-diagram-development.puml .... Vista de Desarrollo
│     │  ├─ sequence-user-registration.puml ..... Vista de Procesos
│     │  ├─ activity-diagram-registration.puml .. Vista de Procesos
│     │  ├─ deployment-docker.puml .............. Vista Física (Local)
│     │  └─ deployment-production.puml .......... Vista Física (Producción)
│     │
│     └─🎨 Otros Diagramas
│        └─ (futuros diagramas aquí)
│
└─📁 static/
   └─ fsa-archiv1.png .................... Diagrama de arquitectura general
```

---

## 🎯 Inicio Rápido por Objetivo

### 🚀 "Quiero empezar a usar el sistema"
1. Lee: [README.md](../README.md)
2. Sigue: Sección "Inicio Rápido con Docker"
3. Prueba: http://localhost:8081/swagger-ui.html

### 🏗️ "Necesito entender la arquitectura"
1. Empieza: [ARCHITECTURE.md](../ARCHITECTURE.md) - Introducción
2. Revisa: [Diagrama de Contexto](diagrams/c4-context.puml)
3. Profundiza: [Diagrama de Contenedores](diagrams/c4-container.puml)

### 💻 "Voy a desarrollar nueva funcionalidad"
1. Estudia: [Diagrama de Componentes](diagrams/c4-component-user-service.puml)
2. Revisa: [Diagrama de Clases](diagrams/class-diagram-user-service.puml)
3. Consulta: [Diagrama de Paquetes](diagrams/package-diagram-development.puml)

### 🔧 "Necesito desplegar el sistema"
1. Desarrollo: [Diagrama Docker](diagrams/deployment-docker.puml)
2. Producción: [Diagrama Producción](diagrams/deployment-production.puml)
3. Guía: [ARCHITECTURE.md - Vista Física](../ARCHITECTURE.md#vista-física)

### 📊 "Debo presentar a stakeholders"
1. Lee: [Resumen Ejecutivo](EXECUTIVE_SUMMARY.md)
2. Usa: [Diagrama de Contexto](diagrams/c4-context.puml)
3. Explica: Flujo de usuario del resumen ejecutivo

---

## 📚 Documentos por Audiencia

### 👔 Stakeholders de Negocio / Product Owners
```
┌─────────────────────────────────────────────────┐
│ 1️⃣  EXECUTIVE_SUMMARY.md                       │ 🌟 EMPIEZA AQUÍ
│    └─ Resumen no técnico del sistema           │
│                                                 │
│ 2️⃣  ARCHITECTURE.md                            │
│    └─ Secciones: Introducción, Escenarios      │
│                                                 │
│ 3️⃣  diagrams/c4-context.puml                   │
│    └─ Vista general del sistema                │
└─────────────────────────────────────────────────┘
Tiempo estimado: 15-30 minutos
```

### 🏗️ Arquitectos de Software
```
┌─────────────────────────────────────────────────┐
│ 1️⃣  ARCHITECTURE.md (COMPLETO)                 │ 🌟 LECTURA COMPLETA
│    └─ Todos los niveles C4 y vistas 4+1        │
│                                                 │
│ 2️⃣  Todos los diagramas en diagrams/           │
│    └─ Revisar cada uno en detalle              │
│                                                 │
│ 3️⃣  Código fuente de cada microservicio        │
│    └─ Validar implementación vs diseño         │
└─────────────────────────────────────────────────┘
Tiempo estimado: 2-4 horas
```

### 💻 Desarrolladores
```
┌─────────────────────────────────────────────────┐
│ 1️⃣  README.md                                  │ 🌟 SETUP INICIAL
│    └─ Setup del entorno de desarrollo          │
│                                                 │
│ 2️⃣  ARCHITECTURE.md                            │
│    └─ Nivel 3 (Componentes) y Nivel 4 (Código) │
│                                                 │
│ 3️⃣  diagrams/class-diagram-user-service.puml   │
│    └─ Estructura de clases                     │
│                                                 │
│ 4️⃣  diagrams/sequence-user-registration.puml   │
│    └─ Flujos de ejecución                      │
│                                                 │
│ 5️⃣  diagrams/package-diagram-development.puml  │
│    └─ Organización del código                  │
└─────────────────────────────────────────────────┘
Tiempo estimado: 1-2 horas
```

### 🔧 DevOps / SRE
```
┌─────────────────────────────────────────────────┐
│ 1️⃣  docker-compose.yml                         │ 🌟 INFRAESTRUCTURA
│    └─ Configuración de servicios               │
│                                                 │
│ 2️⃣  ARCHITECTURE.md - Vista Física             │
│    └─ Arquitectura de deployment               │
│                                                 │
│ 3️⃣  diagrams/deployment-docker.puml            │
│    └─ Despliegue local                         │
│                                                 │
│ 4️⃣  diagrams/deployment-production.puml        │
│    └─ Propuesta para producción                │
│                                                 │
│ 5️⃣  ARCHITECTURE.md - Escalabilidad            │
│    └─ Estrategias de scaling y HA              │
└─────────────────────────────────────────────────┘
Tiempo estimado: 1-2 horas
```

### 🧪 QA / Testers
```
┌─────────────────────────────────────────────────┐
│ 1️⃣  README.md - Servicios                      │ 🌟 FUNCIONALIDADES
│    └─ Descripción de cada microservicio        │
│                                                 │
│ 2️⃣  ARCHITECTURE.md - Escenarios               │
│    └─ Casos de uso principales                 │
│                                                 │
│ 3️⃣  diagrams/sequence-user-registration.puml   │
│    └─ Flujo completo de registro               │
│                                                 │
│ 4️⃣  diagrams/activity-diagram-registration.puml│
│    └─ Escenarios de éxito y error              │
└─────────────────────────────────────────────────┘
Tiempo estimado: 1 hora
```

---

## 🎨 Guía de Diagramas

### Modelo C4 - Niveles de Abstracción

```
┌─────────────────────────────────────────────────────────┐
│ Nivel 1: CONTEXTO                                       │
│ ┌─────────────────────────────────────────────────┐     │
│ │ c4-context.puml                                 │     │ ← Usuarios y sistemas externos
│ │ "Vista de 30,000 pies"                          │     │
│ └─────────────────────────────────────────────────┘     │
│                         ↓                               │
│ Nivel 2: CONTENEDORES                                   │
│ ┌─────────────────────────────────────────────────┐     │
│ │ c4-container.puml                               │     │ ← Aplicaciones y bases de datos
│ │ "Aplicaciones ejecutables"                      │     │
│ └─────────────────────────────────────────────────┘     │
│                         ↓                               │
│ Nivel 3: COMPONENTES                                    │
│ ┌─────────────────────────────────────────────────┐     │
│ │ c4-component-user-service.puml                  │     │ ← Componentes internos
│ │ "Módulos dentro de contenedores"               │     │
│ └─────────────────────────────────────────────────┘     │
│                         ↓                               │
│ Nivel 4: CÓDIGO                                         │
│ ┌─────────────────────────────────────────────────┐     │
│ │ class-diagram-user-service.puml                 │     │ ← Clases e interfaces
│ │ "Implementación detallada"                      │     │
│ └─────────────────────────────────────────────────┘     │
└─────────────────────────────────────────────────────────┘
```

### Vistas 4+1 - Perspectivas

```
                    ┌──────────────────┐
                    │   ESCENARIOS     │
                    │  (Casos de Uso)  │
                    └────────┬─────────┘
                             │
        ┌────────────────────┼────────────────────┐
        │                    │                    │
┌───────▼────────┐  ┌────────▼────────┐  ┌───────▼────────┐
│ VISTA LÓGICA   │  │ VISTA PROCESOS  │  │ VISTA FÍSICA   │
│ (Funcionalidad)│  │   (Runtime)     │  │  (Deployment)  │
└────────────────┘  └─────────────────┘  └────────────────┘
        │                    │                    │
        └────────────────────┼────────────────────┘
                             │
                    ┌────────▼─────────┐
                    │ VISTA DESARROLLO │
                    │ (Organización)   │
                    └──────────────────┘
```

| Vista | Diagramas | Pregunta que responde |
|-------|-----------|----------------------|
| **Lógica** | class-diagram | "¿Qué hace el sistema?" |
| **Desarrollo** | package-diagram | "¿Cómo está organizado el código?" |
| **Procesos** | sequence, activity | "¿Cómo funciona en runtime?" |
| **Física** | deployment | "¿Dónde se ejecuta?" |
| **Escenarios** | sequence, activity | "¿Cuáles son los casos de uso?" |

---

## 🔍 Búsqueda Rápida de Información

### ¿Necesitas saber sobre...?

| Tema | Documento | Sección/Diagrama |
|------|-----------|------------------|
| **Tecnologías usadas** | README.md | Sección "Tecnologías" |
| **Cómo levantar el proyecto** | README.md | "Inicio Rápido con Docker" |
| **Puertos de servicios** | ARCHITECTURE.md | "Nivel 2: Contenedores" |
| **Estructura de paquetes** | diagrams/package-diagram | Vista completa |
| **Flujo de registro** | diagrams/sequence-user-registration | Diagrama completo |
| **Esquema de eventos** | ARCHITECTURE.md | "Nivel 4: Código" |
| **Despliegue en producción** | diagrams/deployment-production | Vista AWS |
| **Decisiones arquitectónicas** | ARCHITECTURE.md | Sección "ADRs" |
| **Patrones utilizados** | ARCHITECTURE.md | "Patrones de Integración" |
| **Escalabilidad** | ARCHITECTURE.md | "Vista Física" + EXECUTIVE_SUMMARY |
| **Manejo de errores** | diagrams/activity-diagram | Caminos alternativos |
| **Costos estimados** | EXECUTIVE_SUMMARY.md | "Consideraciones de Costos" |

---

## 📖 Orden de Lectura Recomendado

### Para Comprensión Completa (4-6 horas)

```
1. README.md (15 min)
   └─ Entender qué es el proyecto
   
2. EXECUTIVE_SUMMARY.md (20 min)
   └─ Contexto de negocio y valor
   
3. ARCHITECTURE.md - Introducción y Modelo C4 (1 hora)
   └─ Los 4 niveles de abstracción
   
4. Revisar diagramas C4 (30 min)
   ├─ c4-context.puml
   ├─ c4-container.puml
   ├─ c4-component-user-service.puml
   └─ class-diagram-user-service.puml
   
5. ARCHITECTURE.md - Vistas 4+1 (1.5 horas)
   └─ Las 5 vistas arquitectónicas
   
6. Revisar diagramas de vistas (30 min)
   ├─ package-diagram-development.puml
   ├─ sequence-user-registration.puml
   ├─ activity-diagram-registration.puml
   └─ deployment-*.puml
   
7. ARCHITECTURE.md - ADRs y Patrones (45 min)
   └─ Decisiones y mejores prácticas
   
8. Explorar código fuente (variable)
   └─ Validar implementación
```

### Para Inicio Rápido (30 min)

```
1. README.md - Inicio Rápido (10 min)
2. c4-context.puml (5 min)
3. c4-container.puml (5 min)
4. sequence-user-registration.puml (10 min)
```

---

## 🛠️ Herramientas para Visualizar Diagramas

### Opción 1: Online (Sin instalación)
- **PlantUML Web Server:** http://www.plantuml.com/plantuml/uml/
- **Mermaid Live:** https://mermaid.live/

### Opción 2: VS Code (Recomendado para desarrollo)
```bash
# Extensiones necesarias
- PlantUML (by jebbs)
- Markdown Preview Mermaid Support
```

### Opción 3: IntelliJ IDEA
```bash
# Plugins necesarios
- PlantUML integration
```

### Opción 4: Línea de comandos
```bash
# Instalar
brew install plantuml  # macOS
sudo apt-get install plantuml  # Linux

# Usar
cd docs/diagrams
plantuml *.puml  # Genera todos los PNGs
```

---

## 📊 Estadísticas de Documentación

```
📄 Documentos Markdown:     5 archivos
🎨 Diagramas PlantUML:      9 archivos
📈 Diagramas Mermaid:       15+ embebidos en ARCHITECTURE.md
📦 Total de páginas:        ~100 páginas equivalentes
⏱️  Tiempo de lectura:      4-6 horas (completo)
🎯 Cobertura:               Modelo C4 + Vistas 4+1 + ADRs
```

---

## ✅ Checklist de Documentación

Para nuevos miembros del equipo:

- [ ] Leído README.md completo
- [ ] Entorno de desarrollo configurado
- [ ] Revisado EXECUTIVE_SUMMARY.md
- [ ] Estudiado los 4 niveles del Modelo C4
- [ ] Comprendido las 5 vistas 4+1
- [ ] Revisado decisiones arquitectónicas (ADRs)
- [ ] Explorado código de al menos un microservicio
- [ ] Capaz de explicar el flujo de registro de usuario
- [ ] Entendido estrategia de deployment

---

## 🔄 Mantenimiento de Documentación

### Cuándo Actualizar

Actualiza la documentación cuando:

✅ Agregas/eliminas un microservicio  
✅ Cambias la arquitectura significativamente  
✅ Modificas la infraestructura  
✅ Tomas una decisión arquitectónica importante  
✅ Cambias el flujo de un proceso principal  
✅ Actualizas tecnologías/frameworks  

### Proceso de Actualización

1. **Código primero:** Implementa el cambio
2. **Diagramas:** Actualiza archivos `.puml` afectados
3. **Documentación:** Actualiza `ARCHITECTURE.md`
4. **Índice:** Actualiza este archivo si es necesario
5. **Commit:** Todo junto en el mismo commit

---

## 📞 Ayuda y Soporte

### ¿Tienes preguntas?

1. **Busca primero** en este índice
2. **Consulta** el documento específico
3. **Revisa** los diagramas relacionados
4. **Si aún tienes dudas,** contacta al equipo de arquitectura

### Contribuir a la Documentación

¿Encontraste algo confuso o faltante?

1. Crea un issue describiendo el problema
2. O mejor, envía un PR con mejoras
3. La documentación vive y evoluciona con el proyecto

---

**Última actualización:** Noviembre 2025  
**Mantenido por:** Equipo de Arquitectura FSA  
**Versión:** 1.0.0

