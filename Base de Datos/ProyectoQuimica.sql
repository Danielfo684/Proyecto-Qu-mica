-- Base de datos: QUIMICOS
CREATE DATABASE IF NOT EXISTS QUIMICOS;
USE QUIMICOS;

-- Estructura de tabla para la tabla Usuario


--La tabla usuario puede que no nos haga falta porque ya
-- el propio mysql te trae un sistema de gestión de usuarios que ya he programao en java
DROP TABLE IF EXISTS Usuario;
CREATE TABLE Usuario (
	idUsuario INT PRIMARY KEY IDENTITY,
	nombreUsuario VARCHAR(255) UNIQUE NOT NULL,
	contraseña VARCHAR(255) NOT NULL,
	nombre VARCHAR(255) NOT NULL,
	apellidos VARCHAR(255) NOT NULL,
	esProfesor BIT NOT NULL -- BIT == BOOLEAN
); 

--Nos falta una tabla de localización que hace referencia a los distintos almacenes


-- Creación de la tabla de Ubicacion

DROP TABLE IF EXISTS Ubicacion;
CREATE TABLE Ubicacion (
	idUbicacion INT PRIMARY KEY IDENTITY,
	estanteria INT,
	balda INT
);

--Estructura de la tabla para la tabla ProductoQuimico

DROP TABLE IF EXISTS ProductoQuimico;
CREATE TABLE ProductoQuimico (
	idProducto INT PRIMARY KEY IDENTITY,
	nombre VARCHAR(255) NOT NULL,
	localizacion VARCHAR(50) NOT NULL,
	ubicacionCodigo VARCHAR(10),
	idUbicacion INT,
	cantidad INT NOT NULL,
	stockMinimo INT,
	FOREIGN KEY (idUbicacion) REFERENCES Ubicacion(idUbicacion)
);

-- Nos falta la table de productos auxiliares, que es la tercera especialización de productoQuimico

--Creación de la tabla Reactivo

DROP TABLE IF EXISTS Reactivo;
CREATE TABLE Reactivo (
	idReactivo INT PRIMARY KEY IDENTITY,
	idProducto INT NOT NULL,
	descripcion VARCHAR(255),
	riesgo VARCHAR(255),
	gradoPureza VARCHAR(50),
	fechaCaducidad DATE,
	FOREIGN KEY (idProducto) REFERENCES ProductoQuimico(idProducto)
);

--Estructura de la tabla para la tabla Material

DROP TABLE IF EXISTS Material;
CREATE TABLE Material (
	idMaterial INT PRIMARY KEY IDENTITY,
	idProducto INT NOT NULL,
	Subcategoria VARCHAR(50) NOT NULL,
    CONSTRAINT CK_Subcategoria 
        CHECK (Subcategoria IN ('Plástico', 'Cristal', 'Instrumental Electrónico')),
	descripcion VARCHAR(255),
	numeroSerie VARCHAR(100),
	fechaCompra DATE,
	FOREIGN KEY (idProducto) REFERENCES ProductoQuimico(idProducto)
);

--Tabla de Riesgo
DROP TABLE IF EXISTS Riesgo;
CREATE TABLE Riesgo (
	idRiesgo INT PRIMARY KEY IDENTITY,
	nombre VARCHAR(255) NOT NULL,
	pictograma VARBINARY(MAX) --Campo para almacenar imágenes
);

--Tabla de ReactivoRiesgo (Tabla de unión)
DROP TABLE IF EXISTS ReactivoRiesgo;
CREATE TABLE ReactivoRiesgo (
	idReactivo INT,
	idRiesgo INT,
	PRIMARY KEY (idReactivo, idRiesgo),
	FOREIGN KEY (idReactivo) REFERENCES Reactivo(idReactivo) ON DELETE CASCADE,
	FOREIGN KEY (idRiesgo) REFERENCES Riesgo(idRiesgo) ON DELETE CASCADE
);



