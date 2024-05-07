-- Base de datos: QUIMICOS
CREATE DATABASE IF NOT EXISTS QUIMICOS;
USE QUIMICOS;

---- Estructura de tabla para la tabla Usuario

--DROP TABLE IF EXISTS Usuario;
--CREATE TABLE Usuario (
--	idUsuario INT PRIMARY KEY IDENTITY, -- El IDENTITY es igual al AUTO_INCREMENT de MySQL
--	nombreUsuario VARCHAR(255) UNIQUE NOT NULL,
--	contraseña VARCHAR(255) NOT NULL,
--	nombre VARCHAR(255) NOT NULL,
--	apellidos VARCHAR(255) NOT NULL,
--	esProfesor BIT NOT NULL -- BIT == BOOLEAN en MySQL
--); 

--Creación de la tabla de Localizacion

DROP TABLE IF EXISTS Localizacion;
CREATE TABLE Localizacion (
	idLocalizacion INT PRIMARY KEY IDENTITY,
	Almacen VARCHAR(255) NOT NULL,
	CONSTRAINT CK_Almacen
        CHECK (Almacen IN ('Laboratorio001', 'Laboratorio002', 'Laboratorio003' 'Laboratorio004', 'Almacen General')),
);

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
	idLocalizacion INT NOT NULL,
	ubicacionCodigo VARCHAR(10),
	idUbicacion INT,
	cantidad INT NOT NULL,
	stockMinimo INT,
	FOREIGN KEY (idUbicacion) REFERENCES Ubicacion(idUbicacion),
	FOREIGN KEY (idLocalizacion) REFERENCES Localizacion(idLocalizacion)
);

--Creación de la tabla Reactivo

DROP TABLE IF EXISTS Reactivo;
CREATE TABLE Reactivo (
	idReactivo INT PRIMARY KEY IDENTITY,
	idProducto INT NOT NULL,
	descripcion VARCHAR(255),
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
	--El ENUM en MySQL sería: nombre_enum ENUM('Plástico', 'Cristal', 'Instrumental Electrónico'),
	descripcion VARCHAR(255),
	numeroSerie VARCHAR(100),
	fechaCompra DATE,
	FOREIGN KEY (idProducto) REFERENCES ProductoQuimico(idProducto)
);

--Estructura de la tabla para la tabla Productos Auxiliares

DROP TABLE IF EXISTS ProductoAuxiliar;
CREATE TABLE ProductoAuxiliar (
	idProductoAuxiliar INT PRIMARY KEY IDENTITY,
	idProducto INT NOT NULL,
	formato VARCHAR(255) NOT NULL,
	FOREIGN KEY (idProducto) REFERENCES ProductoQuimico(idProducto)
);

--Tabla de Riesgo
DROP TABLE IF EXISTS Riesgo;
CREATE TABLE Riesgo (
	idRiesgo INT PRIMARY KEY IDENTITY,
	nombre VARCHAR(255) NOT NULL,
	pictograma VARBINARY(MAX) --Campo para almacenar imágenes en MySQL es un BLOB en vez de VARBINARY
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



