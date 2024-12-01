INSERT INTO PRODUCTS (nombre, categoria, disponible, stock, precio, fecha_Creacion, fecha_Modificacion) 
VALUES 
    ('Celular', 'ELECTRODOMESTICO', true, 100, 299.99, CURRENT_TIMESTAMP, CURRENT_TIMESTAMP),
    ('Microondas', 'ELECTRODOMESTICO', true, 50, 199.99, CURRENT_TIMESTAMP, CURRENT_TIMESTAMP),
    ('Microfono', 'ELECTRODOMESTICO', true, 150, 79.99, CURRENT_TIMESTAMP, CURRENT_TIMESTAMP),
    ('Jabon', 'LIMPIEZA', false, 0, 3.99, CURRENT_TIMESTAMP, CURRENT_TIMESTAMP),
    ('Pasta Dental', 'LIMPIEZA', true, 200, 2.49, CURRENT_TIMESTAMP, CURRENT_TIMESTAMP),
    ('Pizza', 'COMIDA', true, 80, 15.99, CURRENT_TIMESTAMP, CURRENT_TIMESTAMP),
    ('Pasta', 'COMIDA', true, 120, 7.99, CURRENT_TIMESTAMP, '2024-11-01 10:30:00');


INSERT INTO Tipo_Estadistica (nombre,descripcion) 
VALUES
    ('Producto con más stock', 'Muestra el producto con mas stock en el sistema'),
    ('Último producto creado', 'Muestra el ultimo producto en ser creado'),
    ('Productos activos por categoría', 'Por cada categoria existente va a guardar la cantidad de productos activos en el sistema.');
