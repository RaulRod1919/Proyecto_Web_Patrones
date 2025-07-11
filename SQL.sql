drop schema if exists proyecto_GRS;
drop user if exists usuario;
CREATE SCHEMA proyecto_GRS;
USE proyecto_GRS;

CREATE USER 'usuario' IDENTIFIED BY 'Clave_111';
GRANT ALL PRIVILEGES ON proyecto_grs.* TO 'usuario'@'%';

CREATE TABLE empresa (
  id_empresa INT NOT NULL AUTO_INCREMENT,
  descripcion blob NOT NULL,
  nombre VARCHAR(50) NOT NULL,
  PRIMARY KEY (id_empresa))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8mb4;

CREATE TABLE tipos_construcciones (
  id_tipo_construccion INT NOT NULL AUTO_INCREMENT,
  id_empresa INT NOT NULL,
  descripcion blob NOT NULL,
  nombre VARCHAR(50) NOT NULL,
  PRIMARY KEY (id_tipo_construccion),
  foreign key fk_id_empresa (id_empresa) references empresa(id_empresa))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8mb4;

CREATE TABLE tipos_acabados (
  id_tipo_acabado INT NOT NULL AUTO_INCREMENT,
  id_empresa INT NOT NULL,
  nombre VARCHAR(50) NOT NULL,
  PRIMARY KEY (id_tipo_acabado),
  foreign key fk_id_empresa (id_empresa) references empresa(id_empresa))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8mb4;

CREATE TABLE tipos_terrenos (
  id_tipo_terreno INT NOT NULL AUTO_INCREMENT,
  id_empresa INT NOT NULL,
  nombre VARCHAR(50) NOT NULL,
  PRIMARY KEY (id_tipo_terreno),
  foreign key fk_id_empresa (id_empresa) references empresa(id_empresa))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8mb4;

CREATE TABLE proyectos_realizados (
  id_proyecto_realizado INT NOT NULL AUTO_INCREMENT,
  id_empresa INT NOT NULL,
  nombre VARCHAR(50) NOT NULL,
  descripcion blob NOT NULL,
  PRIMARY KEY (id_proyecto_realizado),
  foreign key fk_id_empresa (id_empresa) references empresa(id_empresa))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8mb4;

CREATE TABLE imagenes_proyectos_realizados (
  id_imagen_proyecto_realizado INT NOT NULL AUTO_INCREMENT,
  id_proyecto_realizado INT NOT NULL,
  direccion VARCHAR(50) NOT NULL,
  PRIMARY KEY (id_imagen_proyecto_realizado),
  foreign key fk_id_proyecto_realizado (id_proyecto_realizado) references proyectos_realizados(id_proyecto_realizado))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8mb4;

CREATE TABLE servicios (
  id_servicio INT NOT NULL AUTO_INCREMENT,
  id_empresa INT NOT NULL,
  nombre VARCHAR(50) NOT NULL,
  descripcion blob NOT NULL,
  PRIMARY KEY (id_servicio),
  foreign key fk_id_empresa (id_empresa) references empresa(id_empresa))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8mb4;

CREATE TABLE usuarios (
  correo VARCHAR(70) NOT NULL,
  nombre VARCHAR(50) NOT NULL,
  password VARCHAR(30) NOT NULL,
  rol VARCHAR(30) NOT NULL,
  PRIMARY KEY (correo))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8mb4;

CREATE TABLE telefonos (
  id_telefono INT NOT NULL AUTO_INCREMENT,
  correo VARCHAR(70) NOT NULL,
  nombre VARCHAR(50) NOT NULL,
  PRIMARY KEY (id_telefono),
  foreign key fk_correo (correo) references usuarios(correo))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8mb4;

CREATE TABLE proyectos (
  id_proyecto INT NOT NULL AUTO_INCREMENT,
  id_servicio INT NOT NULL,
  correo VARCHAR(70) NOT NULL,
  nombre VARCHAR(50) NOT NULL,
  presupuesto FLOAT NOT NULL,
  fecha_inicio DATE NOT NULL,
  fecha_cierre DATE NOT NULL,
  estado VARCHAR(30) NOT NULL,
  progreso INT NOT NULL,
  PRIMARY KEY (id_proyecto),
  foreign key fk_id_servicio (id_servicio) references servicios(id_servicio),
  foreign key fk_correo (correo) references usuarios(correo))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8mb4;

CREATE TABLE imagenes_proyectos (
  id_imagen_proyecto INT NOT NULL AUTO_INCREMENT,
  id_proyecto INT NOT NULL,
  direccion VARCHAR(50) NOT NULL,
  PRIMARY KEY (id_imagen_proyecto),
  foreign key fk_id_proyecto (id_proyecto) references proyectos(id_proyecto))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8mb4;

CREATE TABLE contacto (
    id_contacto INT AUTO_INCREMENT PRIMARY KEY,
    asunto VARCHAR(70) NOT NULL,
    email VARCHAR(70) NOT NULL,
    telefono INT NOT NULL,
    detalle VARCHAR(255)
);

drop table contacto;

INSERT INTO empresa (descripcion, nombre) 
VALUES ('GRS Construcciones es una empresa comprometida con el desarrollo de proyectos de construcción de alta calidad, orientada a ofrecer soluciones innovadoras, seguras y sostenibles.Con una sólida trayectoria en el sector, nos especializamos en obras residenciales, comerciales e industriales, brindando un servicio integral que abarca desde el diseño hasta la ejecución final.
Nuestro equipo está conformado por profesionales altamente calificados, que trabajan con pasión, responsabilidad y respeto por el entorno. En GRS Construcciones creemos en la importancia de construir más que estructuras: construimos espacios que mejoran la calidad de vida de las personas y fomentan el progreso de las comunidades.
Nos distinguimos por nuestro compromiso con la excelencia, el cumplimiento de los plazos y el uso de materiales de primera calidad. Cada proyecto que realizamos es una muestra de nuestra dedicación y de la confianza que nuestros clientes depositan en nosotros.

', 'GRS Construcciones');
                    
INSERT INTO servicios (id_empresa, nombre, descripcion) 
VALUES (1, 'Paquete Completo', 'Lorem ipsum dolor sit amet consectetur adipiscing, elit sagittis torquent primis tincidunt, vivamus iaculis dictum placerat congue. 
                    Sociosqu vehicula varius molestie tristique dapibus rhoncus suscipit nascetur habitasse, scelerisque placerat venenatis facilisis 
                    dis orci blandit conubia interdum, metus vulputate parturient libero netus hac consequat odio. Molestie sodales curabitur laoreet 
                    pretium at cursus parturient, porta interdum phasellus pellentesque condimentum. Risus eleifend potenti at convallis morbi ac felis 
                    posuere, himenaeos facilisi ut magnis proin aliquam dictumst tortor, molestie interdum nulla sem scelerisque justo quam.');

INSERT INTO servicios (id_empresa, nombre, descripcion) 
VALUES (1, 'Solo Construcción', 'Lorem ipsum dolor sit amet consectetur adipiscing, elit sagittis torquent primis tincidunt, vivamus iaculis dictum placerat congue. 
                    Sociosqu vehicula varius molestie tristique dapibus rhoncus suscipit nascetur habitasse, scelerisque placerat venenatis facilisis 
                    dis orci blandit conubia interdum, metus vulputate parturient libero netus hac consequat odio. Molestie sodales curabitur laoreet 
                    pretium at cursus parturient, porta interdum phasellus pellentesque condimentum. Risus eleifend potenti at convallis morbi ac felis 
                    posuere, himenaeos facilisi ut magnis proin aliquam dictumst tortor, molestie interdum nulla sem scelerisque justo quam.');
                    
INSERT INTO servicios (id_empresa, nombre, descripcion) 
VALUES (1, 'Diseño y Construcción', 'Lorem ipsum dolor sit amet consectetur adipiscing, elit sagittis torquent primis tincidunt, vivamus iaculis dictum placerat congue. 
                    Sociosqu vehicula varius molestie tristique dapibus rhoncus suscipit nascetur habitasse, scelerisque placerat venenatis facilisis 
                    dis orci blandit conubia interdum, metus vulputate parturient libero netus hac consequat odio. Molestie sodales curabitur laoreet 
                    pretium at cursus parturient, porta interdum phasellus pellentesque condimentum. Risus eleifend potenti at convallis morbi ac felis 
                    posuere, himenaeos facilisi ut magnis proin aliquam dictumst tortor, molestie interdum nulla sem scelerisque justo quam.');


INSERT INTO tipos_construcciones (id_empresa, nombre, descripcion) VALUES
(1, 'Construcción Residencial', 'Desarrollo de viviendas unifamiliares y multifamiliares, ofreciendo soluciones habitacionales modernas, funcionales y seguras, adaptadas a las necesidades del cliente y las normativas locales.'),
(1, 'Construcción Comercial', 'Diseño y edificación de locales, oficinas y centros comerciales, con énfasis en la eficiencia energética, la funcionalidad de los espacios y la estética que impulsa los negocios.'),
(1, 'Construcción Industrial', 'Ejecución de proyectos para naves industriales, bodegas y plantas de producción, priorizando la durabilidad, la seguridad estructural y la optimización de los procesos productivos.');

