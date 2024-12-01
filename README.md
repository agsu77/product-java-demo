# product-java-demo

### Descripción General

Esta aplicación Java, construida con Spring Boot, proporciona una API RESTful para gestionar productos. Utiliza una base de datos H2 en memoria y un servidor JMS ActiveMQ en memoria para almacenar y procesar datos.

**Características clave:**

* **CRUD completo:** Crear, leer, actualizar y eliminar productos.
* **Búsqueda:** Buscar productos por ID y nombre.
* **Estadísticas:** Genera estadísticas sobre los productos.
* **Documentación Swagger:** Interfaz interactiva para explorar la API.
* **Dockerización:** Facilidad para desplegar en cualquier entorno.
* **Seguridad básica:** Autenticación básica con usuario `admin/admin`.

### API
En la API publicamos 7 funcionalidades:

- Obtener Producto por ID
	- Dado un ID obtenemos un registro asociado, en caso de no existir ``No se encontro un producto con id: ``
- Obtener Todos los productos
	- Obtenemos todos los productos disponibles en base. 
- Obtener un Producto por nombre
	- Dado un String obtenemos todos los productos que lo contengan en el nombre.
- Modificar un Producto
	- Modificamos el producto existente en base asociado al ID recibido, en caso que no exista se devuelve ``No se encontro un producto con id: ``
- Borrar un Producto
	- Se borra el producto de ID recibido, en caso de no existir se devuelve ``No se encontro un producto con id: ``
- Crear un Producto
	- Recibimos un producto de estructura 
	```
	{
	  "nombre": "Bola de caca",
	  "categoria": "COMIDA",
	  "precio": -1,
	  "stock": 230
	}
	``` 
	 y lo guardamos en base. En cada creacion de producto se crean estadisticas de uso del sistema. 
- Obtener Estadisticas
	- El obtener estadisticas nos devuelve 3 tipos de estadisticas: Producto con mas Stock, Ultimo Producto Creado, Productos Activos por Categoria. Todas las estadisticas son calculadas partiendo de la tabla PRODUCTS.


### Ejecución Local
1. **Clonar el repositorio:**
   ```bash
   git clone https://github.com/agsu77/product-java-demo.git
   ```
2. **Crear el contenedor**
    ```bash
    cd product-java-demo
    docker build -t product-demo .
    ```
3. **Ejecutar el contenedor**
    ```bash
    docker run -d -p 8080:8080 product-demo
    ```
4. **Acceder a la API**
    - Swagger: http://localhost:8080/swagger-ui/index.html
    - API: http://localhost:8080/api/productos (ajusta la ruta según tu implementación)
