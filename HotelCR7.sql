CREATE DATABASE hotelCR7;
USE hotelCR7;

CREATE TABLE clientes (
    id INT AUTO_INCREMENT PRIMARY KEY,
    nombre VARCHAR(50) NOT NULL,
    apellido VARCHAR(50) NOT NULL,
    correo VARCHAR(100) NOT NULL UNIQUE,
    telefono_movil VARCHAR(15) NOT NULL
);
drop table if exists reservas;
CREATE TABLE reservas (
    id INT AUTO_INCREMENT PRIMARY KEY,
    nombreCliente VARCHAR(50) NOT NULL,
    apellidoCliente VARCHAR(50) NOT NULL,
    correo_electronico VARCHAR(100) NOT NULL,
    numeroTel VARCHAR(15) NOT NULL,
    fecha_llegada DATE NOT NULL,
    fecha_salida DATE NOT NULL,
    numeroHabitacion INT NOT NULL
);
INSERT INTO reservas (nombreCliente, apellidoCliente, correo_electronico, numeroTel, fecha_llegada, fecha_salida, numeroHabitacion) 
VALUES ('Juan', 'Perez', 'juan.perez@ej.com', '123456789', '2024-05-28', '2024-06-05', 1);
drop table habitacion;
CREATE TABLE habitacion (
    numHabitacion INT PRIMARY KEY,
    disponible BOOLEAN NOT NULL,
    precioBase DOUBLE NOT NULL,
    tipoHabitacion varchar(50)
);
INSERT INTO habitacion (numHabitacion, disponible, precioBase, tipoHabitacion) VALUES
(101, TRUE, 150.00, 'Suite'),
(102, TRUE, 100.00, 'Habitacion Individual'),
(103, FALSE, 100.00, 'Habitacion Individual'),
(104, TRUE, 120.00, 'Habitacion Doble'),
(105, FALSE, 120.00, 'Habitacion Doble'),
(106, TRUE, 150.00, 'Suite'),
(107, TRUE, 120.00, 'Habitacion Doble'),
(108, FALSE, 100.00, 'Habitacion Individual'),
(109, TRUE, 150.00, 'Suite'),
(110, TRUE, 120.00, 'Habitacion Doble');
select * from reservas;