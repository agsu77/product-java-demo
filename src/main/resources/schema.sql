
CREATE TABLE Tipo_Estadistica (
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    nombre VARCHAR(255) NOT NULL,
    descripcion VARCHAR(255) NOT NULL
);

CREATE TABLE Estadistica (
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    tipo INT NOT NULL,
    valor VARCHAR(255),
    categoria VARCHAR(255),
    fecha TIMESTAMP NOT NULL,
    CONSTRAINT FK_Estadistica_Tipo FOREIGN KEY (tipo) REFERENCES Tipo_Estadistica(id)
);

CREATE TABLE Products (
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    nombre VARCHAR(255) NOT NULL,
    categoria VARCHAR(255) NOT NULL,
    disponible BOOLEAN NOT NULL,
    stock INT,
    precio DECIMAL(10,2),
    fecha_Creacion TIMESTAMP,
    fecha_Modificacion TIMESTAMP
);