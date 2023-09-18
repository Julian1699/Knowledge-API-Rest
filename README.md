# Api-Rest-For-Learning

| API REST |  SpringBoot | Spring JPA | Spring Security | Hibernate | PostgreSQL | Swagger |

# DOCKER

Como el api se encuentra dockerizada es necesario:

1) Clona el repositorio específico de la rama 'main-security-in-memory-dockerized' con el siguiente comando:
   
   - $ git clone -b main-security-in-database-jwt-dockerized https://github.com/Julian1699/Api-Rest-For-Learning.git
     
2) Una vez que se haya clonado el repositorio, se debe abrir una terminal de Git Bash en el directorio que contiene el proyecto.
   
3) Ejecutar el comando de docker
   
   - $ docker compose up
     
4) Luego de ejecutar el comando anterior y haber iniciado los dos contenedores, se debe abrir otra terminal de Git Bash.
   
5) En esta nueva terminal, se debe ingresar al contenedor que contiene la base de datos PostgreSQL con el siguiente comando:
   
   - $ winpty docker exec -it db-postgres bash

![image](https://github.com/Julian1699/Api-Rest-For-Learning/assets/114323630/6b57772e-2eb3-4d37-87c9-48ed3255844a)

6) A continuación, se debe ejecutar el siguiente comando para conectarse a la base de datos:

   - $ psql -U postgres -d tryapi

![image](https://github.com/Julian1699/Api-Rest-For-Learning/assets/114323630/ca3998f3-1e02-4788-9349-79e602049a96)

     
7) El archivo 'data.sql' en el directorio 'resources' contiene los datos que deben ser copiados e insertados en la base de datos 'tryapi' para su uso posterior.

![image](https://github.com/Julian1699/Api-Rest-For-Learning/assets/114323630/3b51e45e-760c-434d-9925-7c60a4915f2e)

8) Los datos deben ser pegados y a su vez insertados en la base de datos llamada tryapi, para su posterior utilización:

![image](https://github.com/Julian1699/Api-Rest-For-Learning/assets/114323630/32dbfb54-2ff4-4009-9f84-a252fd8181e3)

9) Ahora se debe realizar la autenticacion de el usuario "admin" o "customer", así en el swagger:

![image](https://github.com/Julian1699/Api-Rest-For-Learning/assets/114323630/5542cb45-f9aa-4bb1-a92c-15e4884faa35)

10) Ahora se debe tomar el token BEARER que se genera por las credenciales empleadas, para ser utilizado de la siguiente manera en el paso 11:

![image](https://github.com/Julian1699/Api-Rest-For-Learning/assets/114323630/884dee5c-af8d-40c7-8832-b0860e786669)

11) En el botón "Authorize".

![image](https://github.com/Julian1699/Api-Rest-For-Learning/assets/114323630/837c7d3e-416c-4f96-94cc-84e239239c1f)

12) Debes introducir el token BEARER para que con cada petición HTTP se cargue y envíe junto con el JWT.

![image](https://github.com/Julian1699/Api-Rest-For-Learning/assets/114323630/184006bb-bd90-4cee-9391-d171df1ca37d)

13) Después de haber presionado el botón "Authorize", procede a cerrar la ventana.

![image](https://github.com/Julian1699/Api-Rest-For-Learning/assets/114323630/03902023-2066-4c8f-beda-d28e951028c3)

14) De esta manera, cada petición estará acompañada por el token BEARER y podrás consumir todos los endpoints que hayas autorizado para el usuario que generó el token.
    
![image](https://github.com/Julian1699/Api-Rest-For-Learning/assets/114323630/1d464da3-cf13-4198-b520-598a7ce66767)

15) Consultar como consumir el API en la ruta generada por el Swagger: http://localhost:8080/swagger-ui/index.html#/

# Configuración de Seguridad:

En este proyecto de Spring Security, se han creado dos usuarios en la base de datos postgres que requieren autenticación y tienen diferentes niveles de autorización.

- Primer Usuario (admin):

-Nombre de usuario: admin.

-Contraseña: admin.

-Rol: ADMIN.

Este usuario tiene permisos para realizar todas las operaciones HTTP (GET, POST, PUT, DELETE) de manera normal.

- Segundo Usuario (customer):

-Nombre de usuario: customer.

-Rol: CUSTOMER.

-Contraseña: customer.

El usuario "customer" tiene autorización solamente para realizar consultas a la base de datos utilizando el verbo HTTP GET.

# API de Productos

Esta API RESTful proporciona una manera de gestionar datos de productos utilizando Spring Boot. Está diseñada para ser utilizada por desarrolladores que necesitan crear, leer, actualizar y eliminar productos.

# La API proporciona las siguientes características:

- Obtener todos los productos: Recupera una lista de todos los productos disponibles en la base de datos.
- Agregar un nuevo producto: Agrega un nuevo producto a la base de datos.
- Actualizar un producto existente: Actualiza un producto existente en la base de datos.
- Eliminar un producto existente: Elimina un producto existente de la base de datos.
- Obtener un producto por ID: Recupera un producto por su identificador único.
- Buscar productos: Busca productos por nombre, referencia o categoría.
- Tecnologías utilizadas

# La API está construida utilizando las siguientes tecnologías:

- Java 17: La versión de Java.
- Spring Boot 3.0.10: Un potente marco de trabajo para construir aplicaciones web basadas en Java.
- Spring Data JPA: Simplifica el acceso y la gestión de bases de datos.
- Swagger: Proporciona documentación interactiva de la API.
- Hibernate Validator: Para la validación de los datos enviados en las solicitudes.
- Lombok: Reduce el código repetitivo.
- Cross-Origin Resource Sharing (CORS): Permite solicitudes entre dominios desde aplicaciones web.

# Documentación

La documentación de la API está disponible en Swagger: http://localhost:8080/swagger-ui/index.html#/

![image](https://github.com/Julian1699/Api-Rest-For-Learning/assets/114323630/fa586660-642d-4e80-a1ea-9b59711c17db)

# Endpoints

Los endpoints de la API son los siguientes:

- PUT /api/v1/product/put/{id}: Actualiza un producto existente.
- POST /api/v1/product/post: Agrega un nuevo producto.
- GET /api/v1/product/search/{search}: Busca productos por nombre, referencia o categoría.
- GET /api/v1/product/id/{id}: Obtiene un producto por ID.
- GET /api/v1/product/all: Obtiene todos los productos.
- DELETE /api/v1/product/delete/{id}: Elimina un producto existente.


