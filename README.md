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
- MySQL 8
- Maven
- Swagger / OpenAPI

---

## Arquitectura

El backend está desarrollado utilizando una arquitectura basada en capas:

```text
Controller
    ↓
Service
    ↓
Repository
    ↓
Entity
    ↓
MySQL
