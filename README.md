# Sistema web para la gestión y seguimiento de casos de adicciones

Backend del sistema web desarrollado para la gestión y seguimiento de casos relacionados con el consumo de sustancias psicoactivas.

El backend proporciona una API REST para la gestión de usuarios, casos y seguimientos, incorporando autenticación mediante JWT y control de acceso según roles.

## Tecnologías

- Java 25
- Spring Boot 4.1.1
- Spring Web MVC
- Spring Data JPA
- Spring Security
- JWT
- Hibernate
- MySQL (desarrollo inicial)
- PostgreSQL
- Neon
- Maven
- Swagger / OpenAPI

## Arquitectura

El backend utiliza una arquitectura por capas que permite separar las responsabilidades de cada componente:

- **Controller:** recibe y responde las solicitudes HTTP de la API REST.
- **Service:** contiene la lógica de negocio.
- **Repository:** gestiona el acceso a los datos mediante Spring Data JPA.
- **Entity:** representa las entidades principales del sistema.

Esta organización facilita el mantenimiento y permite trabajar de manera independiente cada parte del backend.

## Seguridad

La autenticación y autorización se implementan mediante Spring Security y JWT.

El sistema cuenta con dos roles principales:

- ADMINISTRADOR
- PROFESIONAL

Los permisos se controlan de acuerdo con el rol del usuario autenticado. Los profesionales tienen acceso a los casos que les corresponden, mientras que el administrador cuenta con acceso general a la información y funcionalidades administrativas.

## API REST

La API proporciona servicios para las principales operaciones del sistema:

- Autenticación de usuarios.
- Gestión de usuarios.
- Gestión de casos.
- Gestión de seguimientos.
- Consulta de información.
- Control de acceso según roles.

La documentación de los endpoints está disponible mediante Swagger / OpenAPI.

## Base de datos

Durante las primeras etapas del desarrollo se utilizó MySQL como base de datos para el desarrollo y las pruebas.

Posteriormente, como parte de la preparación del sistema para su despliegue, se realizó la migración a PostgreSQL utilizando Neon.

La versión actualmente desplegada utiliza PostgreSQL como sistema gestor de base de datos y Neon como servicio de alojamiento. Para el desarrollo local se utiliza MySQL.

## Requisitos

Para ejecutar el backend localmente se necesita:

- Java 25
- MySQL Server 8.0 o superior
- Maven Wrapper incluido en el proyecto
- IDE compatible con Java, como Visual Studio Code o IntelliJ IDEA

## Ejecución

Clonar el repositorio:

```bash
git clone https://github.com/JEduardo7/sistema-de-adicciones-backend.git
```

Ingresar a la carpeta del proyecto:

```bash
cd sistema-de-adicciones-backend
```

Para ejecutar el backend localmente con MySQL, configurar primero el archivo `src/main/resources/application-local.properties` con las credenciales propias del entorno local.

En Windows, ejecutar desde la carpeta del backend:

```powershell
.\mvnw.cmd spring-boot:run "-Dspring-boot.run.profiles=local"
```

El backend local estará disponible en:

http://localhost:8080

Las credenciales y claves secretas locales no deben publicarse en GitHub.

## Documentación de la API

La API cuenta con documentación interactiva mediante Swagger:

https://sistema-de-adicciones-api-rest.onrender.com/swagger-ui/index.html

También se encuentra disponible la especificación OpenAPI:

https://sistema-de-adicciones-api-rest.onrender.com/v3/api-docs

## Backend desplegado

El backend se encuentra desplegado en Render:

https://sistema-de-adicciones-api-rest.onrender.com/

## Disponibilidad del servicio

El backend se encuentra desplegado en Render. Después de un periodo de inactividad, la primera solicitud puede tardar unos segundos mientras el servicio vuelve a estar disponible. Una vez activo, las solicitudes funcionan con normalidad.

## Frontend

El backend es consumido por la aplicación frontend desarrollada con Angular.

Repositorio del frontend:

https://github.com/JEduardo7/sistema-de-adicciones-frontend

Aplicación desplegada:

https://sistema-de-adicciones.vercel.app/

## Curso

**Soluciones Web y Aplicaciones Distribuidas**

Facultad de Ingeniería  
Carrera de Ingeniería de Sistemas Computacionales

Cajamarca – Perú  
2026
