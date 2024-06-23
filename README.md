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

## O

```
mvn spring-boot:run
```