
-- Crear base de datos

CREATE SCHEMA `dbusuarios` ;

-- Crear tabla

CREATE TABLE `usuarios` (
  `id` int NOT NULL AUTO_INCREMENT,
  `nombre` varchar(60) NOT NULL,
  `tipoid` varchar(45) NOT NULL,
  `identificacion` int NOT NULL DEFAULT '0',
  `email` varchar(60) NOT NULL,
  `direccion` varchar(100) NOT NULL,
  `contraseña` varchar(45) NOT NULL,
  `producto` varchar(45) NOT NULL,
  `aceptaterminos` tinyint NOT NULL DEFAULT '1',
  `activo` tinyint NOT NULL DEFAULT '1',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;


-- consultar datos
SELECT * FROM dbusuarios.usuarios;

SELECT * FROM dbusuarios.usuarios WHERE activo=true;

SELECT id, nombre FROM dbusuarios.usuarios;

-- crear datos
INSERT INTO usuarios (nombre,tipoid,aceptaterminos,email,contraseña,producto,direccion) VALUES ('Juan Manuel',123456798,true,'juan@',123,123,'cra3'); 

-- modificar datos
UPDATE usuarios SET identificacion = 123 WHERE id=2;

-- eliminacion logica
UPDATE usuarios SET activo = 0 WHERE id=2;

-- eliminar datos
DELETE FROM usuarios WHERE id=3;