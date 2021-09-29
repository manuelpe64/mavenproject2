CREATE SCHEMA `dbusuarios` ;

CREATE TABLE `dbusuarios`.`usuarios` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `nombre` VARCHAR(60) NOT NULL,
  `tipoid` VARCHAR(45) NOT NULL,
  `identificacion` INT NOT NULL,
  `email` VARCHAR(60) NOT NULL,
  `direccion` VARCHAR(100) NOT NULL,
  `contraseña` VARCHAR(45) NOT NULL,
  `producto` VARCHAR(45) NOT NULL,
  `aceptaterminos` TINYINT NOT NULL DEFAULT 1,
  `activo` TINYINT NOT NULL DEFAULT 1,
  PRIMARY KEY (`id`));

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