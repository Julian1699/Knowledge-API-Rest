# Api-Rest-Intermedian
| API REST |  SpringBoot | PostgreSQL | JPA | Swagger |

API de Productos - Controlador REST de Spring Boot
Versión de Java
Versión de Spring Boot
Licencia

Este repositorio contiene la API RESTful para gestionar datos de productos utilizando Spring Boot. La clase ProductController sirve como punto de entrada para varias operaciones relacionadas con productos. Esta API proporciona puntos finales para realizar operaciones comunes de CRUD (Crear, Leer, Actualizar, Eliminar) en registros de productos almacenados en una base de datos.

Características:

Obtener Todos los Productos: Recupera una lista de todos los productos disponibles en la base de datos.
Agregar un Nuevo Producto: Agrega un nuevo producto a la base de datos.
Actualizar un Producto Existente: Actualiza un producto existente en la base de datos.
Eliminar un Producto Existente: Elimina un producto existente de la base de datos.
Obtener Producto por ID: Recupera un producto por su identificador único.
Buscar Productos: Busca productos por nombre, referencia o categoría.
Tecnologías Utilizadas
Spring Boot: Un potente marco de trabajo para construir aplicaciones web basadas en Java.
Spring Data JPA: Simplifica el acceso y la gestión de bases de datos.
Swagger: Proporciona documentación interactiva de la API.
Hibernate Validator: Para la validación de los datos enviados en las solicitudes.
Lombok: Reduce el código repetitivo.
Cross-Origin Resource Sharing (CORS): Permite solicitudes entre dominios desde aplicaciones web.
Documentación de la API

Puede explorar y probar la API utilizando la documentación de Swagger navegando a la siguiente URL después de ejecutar la aplicación:

http://localhost:8080/swagger-ui.html

END POINTS de la API
GET /api/v1/product/all: Obtener todos los productos.
POST /api/v1/product/post: Agregar un nuevo producto.
PUT /api/v1/product/put/{id}: Actualizar un producto existente.
DELETE /api/v1/product/delete/{id}: Eliminar un producto existente.
GET /api/v1/product/id/{id}: Obtener un producto por ID.
GET /api/v1/product/search/{search}: Buscar productos.
