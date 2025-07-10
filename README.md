
# Servicio de Reservas (Booking Service)

Este proyecto es una implementación del **Servicio de Reservas** como parte de una arquitectura de microservicios para un sistema de gestión de reservas en la nube.

## 1. Tecnologías Utilizadas
- **Java 17**
- **Spring Boot 3.x**
- **Spring Web:** Para crear los endpoints REST.
- **Spring Data JPA:** Para la persistencia de datos.
- **H2 Database:** Base de datos en memoria para un desarrollo y pruebas sencillas.
- **Lombok:** Para reducir el código boilerplate (getters, setters, constructores).
- **Maven:** Para la gestión de dependencias y construcción del proyecto.

## 2. Cómo Compilar y Ejecutar

### Prerrequisitos
- Tener instalado JDK 17 o superior.
- Tener instalado Apache Maven.

### Pasos
1.  **Clonar/Descargar el Proyecto:**
    Crea la estructura de directorios y archivos como se muestra en este documento.

2.  **Compilar el Proyecto:**
    Abre una terminal en la raíz del proyecto (donde se encuentra el `pom.xml`) y ejecuta el siguiente comando Maven:
    ```bash
    mvn clean install
    ```

3.  **Ejecutar la Aplicación:**
    Una vez compilado, puedes ejecutar la aplicación con el siguiente comando:
    ```bash
    mvn spring-boot:run
    ```
    El servicio se iniciará y estará escuchando en el puerto `8081`.

## 3. Cómo Probar los Endpoints

Puedes usar una herramienta como `curl` o Postman para interactuar con la API.

### a) Crear una Nueva Reserva
- **Endpoint:** `POST /api/bookings`
- **Headers:** `Content-Type: application/json`
- **Body (Ejemplo):**
  ```json
  {
    "resourceId": "sala-reuniones-01",
    "userId": "user-123",
    "startTime": "2024-08-15T10:00:00",
    "endTime": "2024-08-15T11:00:00"
  }
  ```
- **Comando `curl`:**
  ```bash
  curl -X POST http://localhost:8081/api/bookings \
  -H "Content-Type: application/json" \
  -d '{
    "resourceId": "sala-reuniones-01",
    "userId": "user-123",
    "startTime": "2024-08-15T10:00:00",
    "endTime": "2024-08-15T11:00:00"
  }'
  ```

### b) Obtener una Reserva por ID
- **Endpoint:** `GET /api/bookings/{id}`
- **Comando `curl` (reemplaza `{id}` con un ID real, ej. 1):**
  ```bash
  curl http://localhost:8081/api/bookings/1
  ```

### c) Obtener Todas las Reservas
- **Endpoint:** `GET /api/bookings`
- **Comando `curl`:**
  ```bash
  curl http://localhost:8081/api/bookings
  ```

## 4. Entrega del Proyecto
Para entregar este proyecto:
1.  Crea un nuevo repositorio en GitHub.
2.  Sube todos los archivos y directorios de este proyecto a tu repositorio.
3.  Asegúrate de que el `README.md` esté completo.
4.  Comparte el enlace a tu repositorio de GitHub en la plataforma solicitada (Moodle).
    
