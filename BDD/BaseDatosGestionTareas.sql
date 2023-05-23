CREATE DATABASE IF NOT EXISTS `gestareas`;
USE `gestareas`;


CREATE TABLE IF NOT EXISTS `gestareas_estados` (
  `idgesTareas_estados` int(11) NOT NULL AUTO_INCREMENT,
  `nombre_estado` varchar(45) NOT NULL,
  `descripcion_estado` varchar(150) DEFAULT NULL,
  `fecha_creacion` datetime DEFAULT NULL,
  `usuario_creacion` varchar(45) NOT NULL,
  `fecha_modificacion` datetime DEFAULT NULL,
  `usuario_modificacion` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`idgesTareas_estados`),
  UNIQUE KEY `nombre_estado_UNIQUE` (`nombre_estado`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;

INSERT INTO `gestareas_estados` (`idgesTareas_estados`, `nombre_estado`, `descripcion_estado`, `fecha_creacion`, `usuario_creacion`, `fecha_modificacion`, `usuario_modificacion`) VALUES
	(1, 'PENDIENTE', 'Tarea que se encuentra pendiente de realización', '2023-05-21 19:27:01', 'admin', NULL, NULL),
	(2, 'COMPLETA', 'Tarea que se encuentra completa de realización', '2023-05-21 19:29:20', 'admin', NULL, NULL);


CREATE TABLE IF NOT EXISTS `gestareas_registrousuarios` (
  `idgesTareas_registrosUsuarios` int(11) NOT NULL AUTO_INCREMENT,
  `usuario` varchar(45) NOT NULL,
  `nombre` varchar(60) NOT NULL,
  `correo_electronico` varchar(60) NOT NULL,
  `contrasenia` varchar(500) NOT NULL,
  `fecha_creacion` datetime NOT NULL,
  `usuario_creacion` varchar(45) NOT NULL,
  `fecha_modificacion` datetime DEFAULT NULL,
  `usuario_modificacion` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`idgesTareas_registrosUsuarios`) USING BTREE,
  UNIQUE KEY `usuario_UNIQUE` (`usuario`),
  UNIQUE KEY `correo_electronico` (`correo_electronico`)
) ENGINE=InnoDB AUTO_INCREMENT=15 DEFAULT CHARSET=utf8;


CREATE TABLE IF NOT EXISTS `gestareas_tareas` (
  `idgesTareas_tareas` int(11) NOT NULL AUTO_INCREMENT,
  `idgesTareas_registrosUsuarios` int(11) NOT NULL,
  `idgesTareas_estados` int(11) NOT NULL,
  `titulo` varchar(45) NOT NULL,
  `descripcion` varchar(150) NOT NULL,
  `fecha_creacion` datetime NOT NULL,
  `usuario_creacion` varchar(45) NOT NULL,
  `fecha_modificacion` datetime DEFAULT NULL,
  `usuario_modificacion` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`idgesTareas_tareas`,`idgesTareas_registrosUsuarios`,`idgesTareas_estados`) USING BTREE,
  KEY `fk_gesTareas_tareas_gesTareas_estados1_idx` (`idgesTareas_estados`),
  KEY `fk_gesTareas_tareas_gesTareas_usuario_idx` (`idgesTareas_registrosUsuarios`) USING BTREE,
  CONSTRAINT `fk_gesTareas_tareas_gesTareas_estados` FOREIGN KEY (`idgesTareas_estados`) REFERENCES `gestareas_estados` (`idgesTareas_estados`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `fk_gesTareas_tareas_gesTareas_usuario_idx` FOREIGN KEY (`idgesTareas_registrosUsuarios`) REFERENCES `gestareas_registrousuarios` (`idgesTareas_registrosUsuarios`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB AUTO_INCREMENT=17 DEFAULT CHARSET=utf8;


