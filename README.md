# Sistema web para la gestión y seguimiento de casos de adicciones

Backend del sistema web desarrollado para la gestión, seguimiento y control de casos relacionados con el consumo de sustancias psicoactivas.

El backend proporciona una API REST para la gestión de usuarios, casos y seguimientos, incorporando autenticación mediante JWT y control de acceso según roles.

---

## Tecnologías utilizadas

- Java 25
- Spring Boot 4.1.1
- Spring Web MVC
- Spring Data JPA
- Spring Security
- JWT
- OAuth2 Resource Server
- Hibernate
- PostgreSQL
- Neon
- Maven
- Swagger / OpenAPI

---

## Arquitectura

El backend está desarrollado utilizando una arquitectura basada en capas:

Controller
    ↓
Service
    ↓
Repository
    ↓
Entity
    ↓
PostgreSQL / Neon

Esta organización permite separar las responsabilidades del backend y facilita el mantenimiento y evolución del sistema.

---

## Principales componentes

### Controller

Gestiona las solicitudes HTTP recibidas por la API REST.

### Service

Contiene la lógica de negocio necesaria para procesar las operaciones del sistema.

### Repository

Gestiona el acceso a los datos mediante Spring Data JPA.

### Entity

Representa las principales entidades utilizadas por el sistema, como usuarios, casos y seguimientos.

---

## Seguridad

El backend utiliza Spring Security y JWT para implementar la autenticación y autorización.

El sistema contempla dos roles principales:

- ADMINISTRADOR
- PROFESIONAL

El acceso a los recursos se controla de acuerdo con los permisos correspondientes a cada rol.

---

## API REST

La API permite realizar operaciones relacionadas con:

- Autenticación de usuarios
- Gestión de usuarios
- Gestión de casos
- Gestión de seguimientos

La documentación de los endpoints se encuentra disponible mediante Swagger / OpenAPI.

---

## Base de datos

Durante las primeras etapas del desarrollo se utilizó MySQL como sistema gestor de base de datos.

Posteriormente, como parte de la preparación del sistema para su despliegue, se realizó la migración a PostgreSQL utilizando Neon.

La versión final desplegada utiliza PostgreSQL como sistema gestor de base de datos y Neon como servicio de alojamiento de la base de datos.

---

## Proyecto

Sistema web desarrollado para la gestión y seguimiento de casos de adicciones, integrando frontend Angular, backend Spring Boot y una base de datos PostgreSQL.
