-- Base de datos: QUIMICOS
CREATE DATABASE QUIMICAS;
USE QUIMICAS;

---- Estructura de tabla para la tabla Usuario

--DROP TABLE IF EXISTS Usuario;
--CREATE TABLE Usuario (
--	idUsuario INT PRIMARY KEY IDENTITY, -- El IDENTITY es igual al AUTO_INCREMENT de MySQL
--	nombreUsuario VARCHAR(255) UNIQUE NOT NULL,
--	contrase�a VARCHAR(255) NOT NULL,
--	nombre VARCHAR(255) NOT NULL,
--	apellidos VARCHAR(255) NOT NULL,
--	esProfesor BIT NOT NULL -- BIT == BOOLEAN en MySQL
--); 

--Creaci�n de la tabla formato para los reactivos
CREATE TABLE formato (
  idFormato int PRIMARY KEY,
  nombreFormato varchar(20) NOT NULL);

  INSERT INTO formato (IdFormato, nombreFormato) VALUES
(1, '1 Kg'),
(2, '100 g'),
(3, '250 g'),
(4, '500 g'),
(5, '5 g'),
(100, 'No viene reflejado'),
(6, '1 L'),
(7, '500 mL'),
(8, '5 Kg'),
(9, '2,5 L'),
(10, '250 mL'),
(11, '100 mL'),
(12, '250 g,1 kg'),
(13, '10 g');

--Creaci�n de la tabla de Localizacion

DROP TABLE IF EXISTS Localizacion;
CREATE TABLE Localizacion (
	idLocalizacion INT PRIMARY KEY IDENTITY,
	nombreAlmacen VARCHAR(255) NOT NULL,
	CONSTRAINT CK_nombreAlmacen
        CHECK (nombreAlmacen IN ('Laboratorio Instrumental', 'Almacen General', 'Almac�n 1/principal')),
);
INSERT into Localizacion (nombreAlmacen) values
('Almacen General'),
('Laboratorio Instrumental'),
('Almac�n 1/principal');
select * from localizacion
-- Creaci�n de la tabla de Ubicacion

DROP TABLE IF EXISTS Ubicacion;
CREATE TABLE Ubicacion (
	idUbicacion INT PRIMARY KEY IDENTITY,
	nombre VARCHAR(100) NOT NULL,
	idLocalizacion INT,
	FOREIGN KEY (idLocalizacion) REFERENCES Localizacion(idLocalizacion)
);
INSERT INTO ubicacion (nombre, idLocalizacion) VALUES
( '5N', 3),
( '4N', 3),
( '3N', 3),
( '2N', 3),
( '1CA', 3),
( '8l', 3),
( 'C1', 2),
( 'C2', 2),
( 'P1', 2),
( 'P2', 2),
( 'estanter�a 1, balda 3', 1),
( 'estanter�a 1,balda 4', 1),
( 'estanter�a 0, balda 4 ', 1);



--Estructura de la tabla para la tabla ProductoQuimico

DROP TABLE IF EXISTS Productos;
CREATE TABLE Productos (
	idProducto INT PRIMARY KEY,
	nombre VARCHAR(255) NOT NULL,
	idUbicacion INT,
	cantidad INT NOT NULL,
	stockMinimo INT,
	tipoProducto VARCHAR(255) NOT NULL,
	
	FOREIGN KEY (idUbicacion) REFERENCES Ubicacion(idUbicacion),
	
);
INSERT INTO productos (IdProducto, Nombre, Cantidad, StockMinimo, IdUbicacion, tipoProducto) VALUES
(1, 'AMONIO NITRATO', 1, 1, 1, 1),
(2, 'BROMURO DE AMONIO (PARA AN�LISIS)', 2, 1, 1, 1),
(3, 'AZUFRE SUBLIMADO (AZUFRE FLOR)', 2, 1, 1, 1),
(4, 'ALUMINIO NITRATO 9-HIDRATO', 2, 1, 1, 1),
(5, 'ACETANILIDA CRISTALIZADA', 1, 1, 1, 1),
(6, 'AMINOMETANO', 1, 1, 1, 1),
(7, 'ESTA�O II CLORURO', 2, 1, 1, 1),
(8, '�CIDO TART�RICO', 2, 1, 1, 1),
(9, '�CIDO TART�RICO', 1, 1, 1, 1),
(10, 'BIPIRIDINA', 1, 1, 1, 1),
(11, 'HIDROXIQUINOLEINA', 1, 1, 1, 1),
(12, 'HIDROXIQUINOLEINA', 1, 1, 1, 1),
(13, 'CELITE 545', 1, 1, 1, 1),
(14, 'REACTIVO DE BENEDICT', 1, 1, 1, 1),
(15, 'REACTIVO FEHLING-A', 1, 1, 1, 1),
(16, 'REACTIVO FEHLING-B', 1, 1, 1, 1),
(17, 'UREA', 1, 1, 1, 1),
(18, 'AMONIO MOLIBDATO 4-HIDRATO', 1, 1, 2, 1),
(19, 'AMONIO OXALATO 1-HIDRATO', 1, 1, 2, 1),
(20, 'AMONIO OXALATO 1-HIDRATO', 1, 1, 2, 1),
(21, 'PERSULFATO AM�NICO', 1, 1, 2, 1),
(22, 'AM�NIO TIOCIANATO', 1, 1, 2, 1),
(23, 'AM�NIO TIOCIANATO', 1, 1, 2, 1),
(24, 'AMONIO META-VANADATO', 1, 1, 2, 1),
(25, 'CADMIO NITRATO 4-HIDRATO', 1, 1, 2, 1),
(26, 'COBALTO II NITRATO 6-HIDRATO', 1, 1, 2, 1),
(27, 'COBRE (II) NITRATO 3-HIDRATO', 1, 1, 2, 1),
(28, '�XIDO DE COBRE (II)', 1, 1, 2, 1),
(29, 'COBRE (II) SULFATO 5-HIDRATO', 1, 1, 2, 1),
(30, 'COBRE (II) SULFATO 5-HIDRATO', 1, 1, 2, 1),
(31, 'ESTRONCIO NITRATO ANHIDRO', 1, 1, 2, 1),
(32, 'HIERRO (III) CLORURO 6-HIDRATO', 2, 1, 2, 1),
(33, 'HIERRO (III) NITRATO 9-HIDRATO', 1, 1, 2, 1),
(34, 'HIERRO (II) SULFATO ~ 2-HIDRATO', 2, 1, 2, 1),
(35, 'HIERRO (II) SULFATO 7-HIDRATO', 1, 1, 2, 1),
(36, 'HIERRO (II) SULFATO 7-HIDRATO', 1, 1, 2, 1),
(37, 'LANTANO (III) CLORURO 7-HIDRATO', 1, 1, 2, 1),
(38, 'MANGANESO (IV) �XIDO', 1, 1, 2, 1),
(39, 'SULFATO DE MANGANESO 1-HIDRATO', 1, 1, 2, 1),
(40, 'MANGANESO (II) SULFATO 1-HIDRATO', 1, 1, 2, 1),
(41, 'CARBONATO DE N�QUEL', 1, 1, 2, 1),
(42, 'N�QUEL (II) NITRATO 6-HIDRATO PRS', 1, 1, 2, 1),
(43, 'PLOMO (II) ACETATO 3-HIDRATO', 1, 1, 2, 1),
(44, 'ZINC NITRATO 6-HIDRATO', 1, 1, 2, 1),
(45, '�XIDO DE ZINC', 1, 1, 2, 1),
(46, 'SULFATO DE ZINC 7-HIDRATO', 1, 1, 2, 1),
(47, 'ZINC SULFATO 1-HIDRATO', 1, 1, 2, 1),
(48, 'SODIO CARBONATO 10-HIDRATO', 4, 1, 3, 1),
(49, 'SODIO CARBONATO ANHIDRO', 1, 1, 3, 1),
(50, 'SODIO CARBONATO ANHIDRO', 1, 1, 3, 1),
(51, 'SODIO OXALATO', 1, 1, 3, 1),
(52, 'SODIO SALICILATO', 1, 1, 3, 1),
(53, 'SODIO SILICATO', 1, 1, 3, 1),
(54, 'SODIO TUNGSTATO 2-HIDRATO', 2, 1, 3, 1),
(55, 'POTASIO DE BROMURO', 1, 1, 3, 1),
(56, 'POTASIO DE BROMURO', 1, 1, 3, 1),
(57, 'POTASIO DE BROMURO', 1, 1, 3, 1),
(58, 'POTASIO DE BROMURO', 1, 1, 3, 1),
(59, 'POTASIO CARBONATO PRS', 2, 1, 3, 1),
(60, 'POTASIO CLORATO', 1, 1, 3, 1),
(61, 'OXALATO DE POTASIO 1-HIDRATO', 2, 1, 3, 1),
(62, 'POTASIO OXALATO', 1, 1, 3, 1),
(63, 'POTASIO BIOXALATO', 1, 1, 3, 1),
(64, 'POTASIO BIOXALATO', 1, 1, 3, 1),
(65, 'PERMANGANATO DE POTASIO', 2, 1, 3, 1),
(66, 'PERMANGANATO DE POTASIO', 1, 1, 3, 1),
(67, 'PERMANGANATO DE POTASIO', 1, 1, 3, 1),
(68, 'PERMANGANATO DE POTASIO', 1, 1, 3, 1),
(69, 'POTASIO TIOCIANATO', 2, 1, 3, 1),
(70, 'POTASIO TIOCIANATO', 1, 1, 3, 1),
(71, 'BARIO ACETATO', 1, 1, 3, 1),
(72, 'BARIO HIDR�XIDO 8-HIDRATO', 1, 1, 3, 1),
(73, 'BARIO HIDR�XIDO 8-HIDRATO', 1, 1, 3, 1),
(74, 'CALCIO CLORURO ANHIDRO QP', 1, 1, 3, 1),
(75, 'CALCIO CLORURO 2-HIDRATO PRS', 1, 1, 3, 1),
(76, 'CALCIO OXOLATO-1-HIDRATO', 1, 1, 3, 1),
(77, 'CALCIO HIDROXISO', 1, 1, 3, 1),
(78, 'HIDROXIHAMONIO CLORURO', 1, 1, 3, 1),
(79, 'AMONIO CLORURO', 1, 1, 3, 1),
(80, '�CIDO BENZOICO', 1, 1, 4, 1),
(81, '�CIDO BENZOICO', 1, 1, 4, 1),
(82, '4-DICLOROBENCENO', 1, 1, 4, 1),
(83, '�CIDO 2-CLOROBENZOICO', 1, 1, 4, 1),
(84, '�CIDO 4-CLOROBENZOICO', 1, 1, 4, 1),
(85, '�CIDO 4-AMINOBENZOICO', 1, 1, 4, 1),
(86, '�CIDO 4-NITROBENZOICO', 1, 1, 4, 1),
(87, 'AMON�ACO', 1, 1, 4, 1),
(88, 'ISOBUTANOL', 1, 1, 4, 1),
(89, '2-BUTANOL', 1, 1, 4, 1),
(90, '3-METIL-1-BUTANOL SEG�N GERBER', 3, 1, 4, 1),
(91, 'CLORAMINA T', 1, 1, 4, 1),
(92, 'CLORAMINA T TRIHIDRATADA', 1, 1, 4, 1),
(93, 'DIMETILGLIOXIMA', 1, 1, 4, 1),
(94, '�CIDO 3,5-DINITROSALIC�LICO PS', 1, 1, 4, 1),
(95, 'ETILENGLICOL', 1, 1, 4, 1),
(96, 'AMONIO FORMATO', 1, 1, 4, 1),
(97, 'CICLOHEXANOL', 1, 1, 4, 1),
(98, 'DICLOROMETANO', 1, 1, 4, 1),
(99, 'NAFTALENO PRS', 1, 1, 4, 1),
(100, 'NAFTALENO PRS', 1, 1, 4, 1),
(101, 'NAFTALENO', 1, 1, 4, 1),
(102, '1-NAFTILAMINA PS', 1, 1, 4, 1),
(103, '1-NAFTOL', 1, 1, 4, 1),
(104, 'p-NITROFENOL', 1, 1, 4, 1),
(105, 'p-NITROFENOL', 1, 1, 4, 1),
(106, '�CIDO OX�LICO 2-HIDRATO', 2, 1, 4, 1),
(107, '�CIDO OX�LICO', 1, 1, 4, 1),
(108, '�CIDO OX�LICO CRISTALIZADO', 1, 1, 4, 1),
(109, '�CIDO SULFAN�LICO', 2, 1, 4, 1),
(110, 'TRIT�N X', 1, 1, 4, 1),
(111, '�CIDO AC�TICO GLACIAL', 1, 1, 5, 1),
(112, '�CIDO AC�TICO GLACIAL', 1, 1, 5, 1),
(113, '�CIDO AC�TICO GLACIAL', 1, 1, 5, 1),
(114, '�CIDO AC�TICO GLACIAL', 1, 1, 5, 1),
(115, '�CIDO AC�TICO', 1, 1, 5, 1),
(116, 'ANH�DRICO AC�TICO', 1, 1, 5, 1),
(117, '�CIDO CLORH�DRICO', 4, 1, 5, 1),
(118, '�CIDO CLORH�DRICO', 3, 1, 5, 1),
(119, '�CIDO CLORH�DRICO', 1, 1, 5, 1),
(120, '�CIDO PERCL�RICO EN �CIDO AC�TICO', 2, 1, 5, 1),
(121, '�CIDO PERCL�RICO', 1, 1, 5, 1),
(122, '�CIDO ORTOFOSF�RICO', 1, 1, 5, 1),
(123, '�CIDO ORTOFOSF�RICO', 1, 1, 5, 1),
(124, '�CIDO N�TRICO', 2, 1, 5, 1),
(125, '�CIDO N�TRICO', 1, 1, 5, 1),
(126, '�CIDO N�TRICO', 3, 1, 5, 1),
(127, '�CIDO SULF�RICO', 3, 1, 5, 1),
(128, '�CIDO SULF�RICO', 1, 1, 5, 1),
(129, '�CIDO FLUORH�DRICO', 1, 1, 5, 1),
(130, '�CIDO F�RMICO', 1, 1, 5, 1),
(131, '�CIDO ORTO-FOSF�RICO', 1, 1, 5, 1),
(132, 'REACTIVO DE HANUS', 3, 1, 5, 1),
(133, 'REACTIVO DE HANUS', 1, 1, 5, 1),
(134, 'DIETANOLAMINA', 1, 1, 5, 1),
(135, 'CLOROACETILO CLORURO RPE', 1, 1, 5, 1),
(136, 'SODIO ACETATO ANHIDRO', 1, 1, 6, 1),
(137, 'SODIO TETRATO 2 HIDRATO', 1, 1, 6, 1),
(138, 'SODIO TETRA-BORATO 10 HIDRATO', 2, 1, 6, 1),
(139, 'TETRABORATO SODICO', 1, 1, 6, 1),
(140, 'SODIO TETRA-FENILBORATO', 4, 1, 6, 1),
(141, 'SODIO HIDROGENOCARBONATO', 1, 1, 6, 1),
(142, 'SODIO HIDROGENOCARBONATO', 2, 1, 6, 1),
(143, 'CARBOXIMETILCELULOSA SAL SODICA', 1, 1, 6, 1),
(144, 'SODIO FOSFATO MONO-BASICO 2-HIDRATO', 1, 1, 6, 1),
(145, 'SODIO FOSFATO MONO-BASICO 2-HIDRATO', 1, 1, 6, 1),
(146, 'SODIO FOSFATO MONO-BASICO 1-HIDRATO', 2, 1, 6, 1),
(147, 'SODIO FOSFATO MONO-BASICO 2-HIDRATO', 1, 1, 6, 1),
(148, 'SODIO FOSFATO DI-BASICO ANHIDRATO', 1, 1, 6, 1),
(149, 'SODIO HIDR�GENO FOSFATO ANHIDRO', 1, 1, 6, 1),
(150, 'FOSFATO TRIS�DICO ANHIDRO', 1, 1, 6, 1),
(151, 'DI-SODIO HIDR�GENO FOSFATO ANHIDRO', 1, 1, 6, 1),
(152, 'DI-SODIO HIDR�GENO FOSFATO ANHIDRO', 1, 1, 6, 1),
(153, '�CIDO ETILENDIAMINOTETRAAC�TICO SAL DIS�DICA 2-HIDRATO', 1, 1, 6, 1),
(154, 'SODIO MOLIBDATO 2-HIDRATO', 1, 1, 6, 1),
(155, 'SODIO MOLIBDATO CRIST', 1, 1, 6, 1),
(156, 'MOLIBDENO (VI) �XIDO', 2, 1, 6, 1),
(157, 'Bandejas ', 4, 0, 13, 2),
(158, 'Vaso medidor ', 2, 0, 13, 2),
(159, 'Botellas con cierre manual', 2, 0, 13, 2),
(160, 'Exprimidor ', 1, 0, 13, 2),
(161, 'Vasos variados ', 10, 0, 13, 2),
(162, 'Coladores ', 3, 0, 13, 2),
(163, 'Ladrillos', 4, 0, 13, 2),
(164, 'Jeringa', 1, 0, 13, 2),
(165, 'Vasos de precipitados', 2, 0, 11, 3),
(166, 'Vasos de precipitados ', 2, 0, 11, 3),
(167, 'Vaso de precipitados ', 1, 0, 11, 3),
(168, 'Matraz erlenmeyer grande', 1, 0, 11, 3),
(169, 'Matraz erlenmeyer con tap�n de cristal', 1, 0, 11, 3),
(170, 'Matraz erlenmeyer ', 1, 0, 11, 3),
(171, 'Matraz erlenmeyer ', 1, 0, 11, 3),
(172, 'Recipiente as�ptico ', 1, 0, 12, 3),
(173, 'Tubos de ensayo graduados ', 1, 0, 12, 3),
(174, 'Conduct�metro', 1, 0, 7, 3),
(175, 'Conduct�metro', 1, 0, 8, 3),
(176, 'Potenci�metro', 1, 0, 9, 3),
(177, 'Potenci�metro', 1, 0, 10, 3);



UPDATE Productos
SET tipoProducto = CASE
    WHEN tipoProducto = 1 THEN 'REACTIVO'
    WHEN tipoProducto = 2 THEN 'PRODUCTOAUXILIAR'
    WHEN tipoProducto = 3 THEN 'MATERIAL'
END;

ALTER TABLE Productos
ADD CONSTRAINT CK_tipoProducto       
CHECK (tipoProducto IN ('REACTIVO', 'PRODUCTOAUXILIAR', 'MATERIAL'));

--Creaci�n de la tabla Reactivo

DROP TABLE IF EXISTS Reactivo;
CREATE TABLE Reactivo (
	idReactivo INT PRIMARY KEY IDENTITY,
	idProducto INT NOT NULL,
	descripcion VARCHAR(255),
	gradoPureza VARCHAR(50),
	fechaCaducidad DATE,
	idFormato int NOT NULL,
	FOREIGN KEY (idProducto) REFERENCES Productos(idProducto),
	FOREIGN KEY (idFormato) REFERENCES Formato (idformato)
);


INSERT INTO reactivo (idReactivo, gradoPureza, fechaCaducidad, idProducto, idFormato) VALUES
(1, 'No viene reflejado', 'No viene reflejada', 1, 1),
(2, '99 %', 'No viene reflejada', 2, 1),
(3, 'Puro', 'No viene reflejada', 3, 1),
(4, '98 %', 'No viene reflejada', 4, 1),
(5, 'Pur�sima', 'No viene reflejada', 5, 1),
(6, '99 %', 'No viene reflejada', 6, 2),
(7, '99 %', 'No viene reflejada', 7, 3),
(8, '99 %', 'No viene reflejada', 8, 4),
(9, '99,7 %', 'No viene reflejada', 9, 1),
(10, 'No viene reflejado', 'No viene reflejada', 10, 5),
(11, '98 %', 'No viene reflejada', 11, 2),
(12, '99 %', 'No viene reflejada', 12, 4),
(13, 'No viene reflejado', 'No viene reflejada', 13, 6),
(14, 'No viene reflejado', 'No viene reflejada', 14, 7),
(15, 'No viene reflejado', 'No viene reflejada', 15, 8),
(16, 'No viene reflejado', 'No viene reflejada', 16, 8),
(17, '99 %', 'No viene reflejada', 17, 6),
(18, '99 %', 'No viene reflejada', 18, 3),
(19, '99,5 %', 'No viene reflejada', 19, 4),
(20, '99 %', 'No viene reflejada', 20, 1),
(21, '98 %', 'No viene reflejada', 21, 6),
(22, '99 %', 'No viene reflejada', 22, 1),
(23, '99 %', 'No viene reflejada', 23, 1),
(24, '99 %', 'No viene reflejada', 24, 3),
(25, '98 %', 'No viene reflejada', 25, 3),
(26, '98 %', 'No viene reflejada', 26, 3),
(27, '99 %', 'No viene reflejada', 27, 4),
(28, '95 %', 'No viene reflejada', 28, 4),
(29, '99 %', 'No viene reflejada', 29, 1),
(30, 'No viene reflejado', 'No viene reflejada', 30, 6),
(31, '98 %', 'No viene reflejada', 31, 1),
(32, '98 %', 'No viene reflejada', 32, 1),
(33, '98 %', 'No viene reflejada', 33, 1),
(34, '80 %', 'No viene reflejada', 34, 1),
(35, '99,5 %', 'No viene reflejada', 35, 1),
(36, '98 %', 'No viene reflejada', 36, 1),
(37, '98 %', 'No viene reflejada', 37, 3),
(38, '85 %', 'No viene reflejada', 38, 4),
(39, 'Pur�sima', 'No viene reflejada', 39, 1),
(40, '99 %', 'No viene reflejada', 40, 1),
(41, 'No viene reflejado', 'No viene reflejada', 41, 6),
(42, '98 %', 'No viene reflejada', 42, 1),
(43, '99 %', 'No viene reflejada', 43, 1),
(44, '98 %', 'No viene reflejada', 44, 4),
(45, '98 %', 'No viene reflejada', 45, 6),
(46, 'Puro', 'No viene reflejada', 46, 6),
(47, '98 %', 'No viene reflejada', 47, 1),
(48, '99 %', 'No viene reflejada', 48, 1),
(49, 'Puro', 'No viene reflejada', 49, 2),
(50, 'Puro', 'No viene reflejada', 50, 1),
(51, '98 %', 'No viene reflejada', 51, 1),
(52, '99,5 %', 'No viene reflejada', 52, 3),
(53, 'No viene reflejado', 'No viene reflejada', 53, 7),
(54, '99 %', 'No viene reflejada', 54, 3),
(55, '98 %', 'No viene reflejada', 55, 4),
(56, '99 %', 'No viene reflejada', 56, 4),
(57, 'Puro', 'No viene reflejada', 57, 3),
(58, '98 %', 'No viene reflejada', 58, 3),
(59, '99 %', 'No viene reflejada', 59, 1),
(60, '98,5 %', 'No viene reflejada', 60, 6),
(61, '99 %', 'No viene reflejada', 61, 4),
(62, 'No viene reflejado', 'No viene reflejada', 62, 1),
(63, '99 %', 'No viene reflejada', 63, 4),
(64, '99 %', 'No viene reflejada', 64, 1),
(65, 'No viene reflejado', 'No viene reflejada', 65, 3),
(66, 'No viene reflejado', 'No viene reflejada', 66, 2),
(67, '99 %', 'No viene reflejada', 67, 1),
(68, 'Puro', 'No viene reflejada', 68, 6),
(69, '99 %', 'No viene reflejada', 69, 4),
(70, '98 %', 'No viene reflejada', 70, 4),
(71, '98 %', 'No viene reflejada', 71, 4),
(72, 'Puro', 'No viene reflejada', 72, 4),
(73, '98 %', 'No viene reflejada', 73, 1),
(74, '95 %', 'No viene reflejada', 74, 1),
(75, '99 %', 'No viene reflejada', 75, 9),
(76, '98 %', 'No viene reflejada', 76, 4),
(77, '95 %', 'No viene reflejada', 77, 1),
(78, '99,55 %', 'No viene reflejada', 78, 3),
(79, '100 %', 'No viene reflejada', 79, 1),
(80, '99,5 %', 'No viene reflejada', 80, 4),
(81, '99,5 %', 'No viene reflejada', 81, 1),
(82, 'Puro', 'No viene reflejada', 82, 4),
(83, '99 %', 'No viene reflejada', 83, 4),
(84, '97 %', 'No viene reflejada', 84, 3),
(85, '99 %', 'No viene reflejada', 85, 3),
(86, '99 %', 'No viene reflejada', 86, 6),
(87, '30 %', 'No viene reflejada', 87, 7),
(88, '99 %', 'No viene reflejada', 88, 7),
(89, '99 %', 'No viene reflejada', 89, 7),
(90, '98,5 %', 'No viene reflejada', 90, 7),
(91, '98 %', 'No viene reflejada', 91, 3),
(92, '99 %', 'No viene reflejada', 92, 3),
(93, '99 %', 'No viene reflejada', 93, 4),
(94, '99 %', 'No viene reflejada', 94, 2),
(95, '99 %', 'No viene reflejada', 95, 7),
(96, '99 %', 'No viene reflejada', 96, 1),
(97, 'Pur�simo', 'No viene reflejada', 97, 6),
(98, 'No viene reflejado', 'No viene reflejada', 98, 7),
(99, '98 %', 'No viene reflejada', 99, 4),
(100, '98 %', 'No viene reflejada', 100, 4),
(101, 'Pur�simo', 'No viene reflejada', 101, 6),
(102, '99 %', 'No viene reflejada', 102, 2),
(103, '99 %', 'No viene reflejada', 103, 3),
(104, '96 %', 'No viene reflejada', 104, 2),
(105, '96 %', 'No viene reflejada', 105, 3),
(106, '99 %', 'No viene reflejada', 106, 4),
(107, 'No viene reflejado', 'No viene reflejada', 107, 7),
(108, 'Pur�simo', 'No viene reflejada', 108, 6),
(109, '98 %', 'No viene reflejada', 109, 3),
(110, 'No viene reflejado', 'No viene reflejada', 110, 6),
(111, '99,7 %', 'No viene reflejada', 111, 7),
(112, '99,9 %', 'No viene reflejada', 112, 7),
(113, '99,9 %', 'No viene reflejada', 113, 10),
(114, '99,5 %', 'No viene reflejada', 114, 11),
(115, '99,7 %', 'No viene reflejada', 115, 7),
(116, '98 %', 'No viene reflejada', 116, 7),
(117, '37 %', 'No viene reflejada', 117, 10),
(118, '37 %', 'No viene reflejada', 118, 7),
(119, '37 %', 'No viene reflejada', 119, 7),
(120, 'No viene reflejado', 'No viene reflejada', 120, 7),
(121, '60 %', 'No viene reflejada', 121, 7),
(122, '85 %', 'No viene reflejada', 122, 7),
(123, '85 %', 'No viene reflejada', 123, 7),
(124, '65 %', 'No viene reflejada', 124, 7),
(125, '65 %', 'No viene reflejada', 125, 7),
(126, '70 %', 'No viene reflejada', 126, 7),
(127, '96 %', 'No viene reflejada', 127, 6),
(128, '98 %', 'No viene reflejada', 128, 7),
(129, 'No viene reflejado', 'No viene reflejada', 129, 11),
(130, '95 %', 'No viene reflejada', 130, 8),
(131, '85 %', 'No viene reflejada', 131, 7),
(132, 'No viene reflejado', 'No viene reflejada', 132, 7),
(133, 'No viene reflejado', 'No viene reflejada', 133, 7),
(134, '99 %', 'No viene reflejada', 134, 12),
(135, 'Puro', 'No viene reflejada', 135, 12),
(136, '99 %', 'No viene reflejada', 136, 6),
(137, '99 %', 'No viene reflejada', 137, 4),
(138, 'No viene reflejado', 'No viene reflejada', 138, 13),
(139, 'No viene reflejado', 'No viene reflejada', 139, 6),
(140, '99 %', 'No viene reflejada', 140, 14),
(141, '99,9 %', 'No viene reflejada', 141, 1),
(142, '99 %', 'No viene reflejada', 142, 1),
(143, '99,5 %', 'No viene reflejada', 143, 3),
(144, '99,10 %', 'No viene reflejada', 144, 3),
(145, 'Puro', 'No viene reflejada', 145, 3),
(146, '99 %', 'No viene reflejada', 146, 4),
(147, '99 %', 'No viene reflejada', 147, 4),
(148, '98 %', 'No viene reflejada', 148, 4),
(149, '99 %', 'No viene reflejada', 149, 1),
(150, 'No viene reflejado', 'No viene reflejada', 150, 4),
(151, '98 %', 'No viene reflejada', 151, 4),
(152, '99 %', 'No viene reflejada', 152, 4),
(153, '99 %', 'No viene reflejada', 153, 3),
(154, '99 %', 'No viene reflejada', 154, 1),
(155, '99 %', 'No viene reflejada', 155, 1),
(156, '99 %', 'No viene reflejada', 156, 3);
--Estructura de la tabla para la tabla Material

DROP TABLE IF EXISTS Material;
CREATE TABLE Material (
	idMaterial INT PRIMARY KEY IDENTITY,
	idProducto INT NOT NULL,
	Subcategoria VARCHAR(50) NOT NULL,
    CONSTRAINT CK_Subcategoria 
        CHECK (Subcategoria IN ('Pl�stico', 'Cristal', 'Instrumental Electr�nico')),
	--El ENUM en MySQL ser�a: nombre_enum ENUM('Pl�stico', 'Cristal', 'Instrumental Electr�nico'),
	descripcion VARCHAR(255),
	numeroSerie VARCHAR(100),
	fechaCompra VARCHAR(50),
	FOREIGN KEY (idProducto) REFERENCES Productos(idProducto)


);
INSERT INTO material ( Subcategoria, Descripcion, FechaCompra, IdProducto, NumeroSerie) VALUES
( 'pl�stico ', '1000 ml', 'No viene especificada', 165, 'No viene especificado'),
( 'pl�stico ', '500ml', 'No viene especificada', 166, 'No viene especificado'),
( 'pl�stico ', '1000 ml ', 'No viene especificada', 167, 'No viene especificado'),
( 'cristal', '3 L', 'No viene especificada', 168, 'No viene especificado'),
( 'cristal ', '1000 ml', 'No viene especificada', 169, 'No viene especificado'),
( 'cristal', '2L ', 'No viene especificada', 170, 'No viene especificado'),
( 'cristal ', '1000 ml', 'No viene especificada', 171, 'No viene especificado'),
( 'pl�stico ', '2L ', 'No viene especificada', 172, 'No viene especificado'),
( 'cristal', '50 ml', 'No viene especificada', 173, 'No viene especificado'),
( 'Instrumental Electr�nico', 'No viene especificado', 'No viene especificada', 174, '�534031�'),
( 'Instrumental Electr�nico', 'No viene especificado', 'No viene especificada', 175, '�531030�'),
( 'Instrumental Electr�nico', 'No viene especificado', 'No viene especificada', 176, '�539010�'),
( 'Instrumental Electr�nico', 'No viene especificado', 'No viene especificada', 177, '�539007�');





--Estructura de la tabla para la tabla Productos Auxiliares

DROP TABLE IF EXISTS ProductoAuxiliar;
CREATE TABLE ProductoAuxiliar (
	idProductoAuxiliar INT PRIMARY KEY IDENTITY,
	idProducto INT NOT NULL,
	formato VARCHAR(255) NOT NULL,
	FOREIGN KEY (idProducto) REFERENCES Productos(idProducto)
);

INSERT INTO ProductoAuxiliar( formato, IdProducto) VALUES
('Pl�stico , verdes, medianas ', 157),
( 'Pl�stico', 158),
( 'Cristal', 159),
( 'Pl�stico ', 160),
( 'Pl�stico ', 161),
( 'Pl�stico, metal, tela', 162),
( 'De cer�mica, 6 cuadrados enteros', 163),
( 'Pl�stico ', 164);


--Tabla de Riesgo
DROP TABLE IF EXISTS Riesgo;
CREATE TABLE Riesgo (
	idRiesgo INT PRIMARY KEY IDENTITY,
	nombre VARCHAR(255) NOT NULL,
	pictograma VARBINARY(MAX) --Campo para almacenar im�genes en MySQL es un BLOB en vez de VARBINARY
);

--Tabla de ReactivoRiesgo (Tabla de uni�n)
DROP TABLE IF EXISTS ReactivoRiesgo;
CREATE TABLE ReactivoRiesgo (
	idReactivo INT,
	idRiesgo INT,
	PRIMARY KEY (idReactivo, idRiesgo),
	FOREIGN KEY (idReactivo) REFERENCES Reactivo(idReactivo) ON DELETE CASCADE,
	FOREIGN KEY (idRiesgo) REFERENCES Riesgo(idRiesgo) ON DELETE CASCADE
);



