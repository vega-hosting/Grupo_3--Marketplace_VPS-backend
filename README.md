# Grupo_3--Marketplace_VPS

Nuestro proyecto consiste en diseñar un sitio web dedicado a la venta de VPS (Virtual Private Server).

El sitio web contara con un sistema de inicio de sesion para usuarios y administradores, un sistema de registro de usuarios, tambien incluira un simulador de compra en el cual el usuario podra elegir un plan redireccionandolo a una pagina para configurar el servidor y por ultimo una pagina en el cual el usuario podra seleccionar la duracion del plan. Por parte del administrador contara con un menu para gestionar los planes y los usuarios. Por ultimo el usuario tendra la capacidad de modificar la informacion de su perfil y la posibilidad de escribir reseñas acerca de servicio.

Responsabilidad integrantes

Ignacio Uribe:

- CRUD de planes.
- Formulario de configuración de servidor.
- Simulación de compra.
- CRUD de suscripciones.
- Registro de usuario.
- Modificar datos de usuario.

Nicolas Llancaqueo:

- Manejo de stock en administrador.
- Sistema de inicio de sesión.
- CRUD de usuario.
- Implementación de seguridad/autenticación para inicio de sesión.
- Eliminación de usuarios.

# vega-hosting

# Como ejecutar el backend

## 1. Abrir una terminal en VSC

Ve a la pestana "Terminal" en la parte superior y selecciona “New Terminal” o simplemente presiona "Ctrl + shift + ñ" para abrir la terminal integrada.

## 2. Cambiar el directorio mediante la terminal

Si no esta dentro del directorio "vega-hosting" debe ejecutar el siguiente comando para cambiar de directorio

```
cd .\vega-hosting\
```

## 3. Ejecutar el proyecto SpringBoot

Ejecuta el siguiente comando para ejecutar el programa

```
.\mvnw.cmd spring-boot:run
```

**O**

```
mvn spring-boot:run
```

# Endpoints

## User

- **GET /v1/api/users**: Recibe una lista de usuarios.

**URL**:
```
http://localhost:8081/v1/api/users
```

- **GET /v1/api/users/{userId}**: Recibe un usuario por ID.

**URL**:
```
http://localhost:8081/v1/api/users/{userId}
```

- **DELETE /v1/api/users/{userId}**: Elimina un usuario por ID.

**URL**:
```
http://localhost:8081/v1/api/users/{userId}
```

- **POST /v1/api/users**: Crea un nuevo usuario.

**URL**:
```
http://localhost:8081/v1/api/users
```

- **PUT /v1/api/users/{userId}**: Actualiza los datos de un usuario por ID.

**URL**:
```
http://localhost:8081/v1/api/users/{userId}
```

## Plan

- **GET /v1/api/plans/admin**: Recibe una lista de planes con los datos disponible para el administador.

**URL**:
```
http://localhost:8081/v1/api/plans/admin
```

- **GET /v1/api/plans/user**: Recibe una lista de planes con los datos disponible para el usuario.

**URL**:
```
http://localhost:8081/v1/api/plans/user
```

- **GET /v1/api/plans/admin/plan/{planId}**: Recibe un plan especifico mediante la ID de este, con los datos disponible para el administrador.

**URL**:
```
http://localhost:8081/v1/api/plans/admin/plan/{planId}
```

- **GET /v1/api/plans/user/plan/{planId}**: Recibe un plan especifico mediante la ID de este, con los datos disponible para el usuario.

**URL**:
```
http://localhost:8081/v1/api/plans/user/plan/{planId}
```

- **POST /v1/api/plans**: Crea un nuevo plan.

**URL**:
```
http://localhost:8081/v1/api/plans
```

- **DELETE /v1/api/plans/{planId}**: Elimina un plan por ID.

**URL**:
```
http://localhost:8081/v1/api/plans/{planId}
```

- **PUT /v1/api/plans**: Actualiza los datos de un plan.

**URL**:
```
http://localhost:8081/v1/api/plans
```

- **PUT /v1/api/plans/user/{planId}/reduce-quantity**: Actualiza el campo 'quantity' de un plan reduciendo una unidad.

**URL**:
```
http://localhost:8081/v1/api/plans/user/{planId}/reduce-quantity
```

## Subscription

- **GET v1/api/subscriptions/user/{userId}**: Recibe una lista de suscripciones por la ID de usuario.

**URL**:
```
http://localhost:8081/v1/api/subscriptions/user/{userId}
```

- **POST v1/api/subscriptions**: Crea una nueva suscripcion.

**URL**:
```
http://localhost:8081/v1/api/subscriptions
```