drop schema if exists proyecto_GRS;
drop user if exists usuario;
CREATE SCHEMA proyecto_GRS;
USE proyecto_GRS;

CREATE USER 'usuario' IDENTIFIED BY 'Clave_111';
GRANT ALL PRIVILEGES ON proyecto_grs.* TO 'usuario'@'%';

CREATE TABLE empresa (
  id_empresa INT NOT NULL AUTO_INCREMENT,
  descripcion blob,
  tipos_construcciones blob,
  nombre VARCHAR(50) NOT NULL,
  PRIMARY KEY (id_empresa))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8mb4;

INSERT INTO empresa (descripcion, tipos_construcciones, nombre) 
VALUES ('Lorem ipsum dolor sit amet consectetur adipiscing, elit sagittis torquent primis tincidunt, vivamus iaculis dictum placerat congue. 
                    Sociosqu vehicula varius molestie tristique dapibus rhoncus suscipit nascetur habitasse, scelerisque placerat venenatis facilisis 
                    dis orci blandit conubia interdum, metus vulputate parturient libero netus hac consequat odio. Molestie sodales curabitur laoreet 
                    pretium at cursus parturient, porta interdum phasellus pellentesque condimentum. Risus eleifend potenti at convallis morbi ac felis 
                    posuere, himenaeos facilisi ut magnis proin aliquam dictumst tortor, molestie interdum nulla sem scelerisque justo quam.',
                    "Lorem ipsum dolor sit amet consectetur adipiscing, elit sagittis torquent primis tincidunt, vivamus iaculis dictum placerat congue. 
                    Sociosqu vehicula varius molestie tristique dapibus rhoncus suscipit nascetur habitasse, scelerisque placerat venenatis facilisis 
                    dis orci blandit conubia interdum, metus vulputate parturient libero netus hac consequat odio. Molestie sodales curabitur laoreet 
                    pretium at cursus parturient, porta interdum phasellus pellentesque condimentum. Risus eleifend potenti at convallis morbi ac felis 
                    posuere, himenaeos facilisi ut magnis proin aliquam dictumst tortor, molestie interdum nulla sem scelerisque justo quam.", 'GRS Construcciones');