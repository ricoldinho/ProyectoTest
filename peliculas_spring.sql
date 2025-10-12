SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

CREATE DATABASE IF NOT EXISTS peliculas_spring DEFAULT CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci;
USE peliculas_spring;

DROP TABLE IF EXISTS actores;
CREATE TABLE IF NOT EXISTS actores (
  actor_id bigint NOT NULL AUTO_INCREMENT,
  nombre varchar(255) DEFAULT NULL,
  apellido varchar(255) DEFAULT NULL,
  fecha_nacimiento date NOT NULL,
  oscarizado bit(1) NOT NULL,
  PRIMARY KEY (actor_id)
) ENGINE=InnoDB AUTO_INCREMENT=26 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

INSERT INTO actores (actor_id, nombre, apellido, fecha_nacimiento, oscarizado) VALUES
(1, 'Tom', 'Hanks', '1956-07-09', b'1'),
(2, 'Meryl', 'Streep', '1949-06-22', b'1'),
(3, 'Leonardo', 'DiCaprio', '1974-11-11', b'1'),
(4, 'Scarlett', 'Johansson', '1984-11-22', b'0'),
(5, 'Denzel', 'Washington', '1954-12-28', b'1'),
(6, 'Natalie', 'Portman', '1981-06-09', b'1'),
(7, 'Brad', 'Pitt', '1963-12-18', b'1'),
(8, 'Zendaya', 'Coleman', '1996-09-01', b'0'),
(9, 'Robert', 'De Niro', '1943-08-17', b'1'),
(10, 'Jennifer', 'Lawrence', '1990-08-15', b'1'),
(11, 'Chris', 'Hemsworth', '1983-08-11', b'0'),
(12, 'Emma', 'Stone', '1988-11-06', b'1'),
(13, 'Morgan', 'Freeman', '1937-06-01', b'1'),
(14, 'Cate', 'Blanchett', '1969-05-14', b'1'),
(15, 'Dwayne', 'Johnson', '1972-05-02', b'0'),
(16, 'Viola', 'Davis', '1965-08-11', b'1'),
(17, 'Ryan', 'Reynolds', '1976-10-23', b'0'),
(18, 'Margot', 'Robbie', '1990-07-02', b'0'),
(19, 'Keanu', 'Reeves', '1964-09-02', b'0'),
(20, 'Charlize', 'Theron', '1975-08-07', b'1'),
(21, 'Timothée', 'Chalamet', '1995-12-27', b'0'),
(22, 'Florence', 'Pugh', '1996-01-03', b'0'),
(23, 'Joaquin', 'Phoenix', '1974-10-28', b'1'),
(24, 'Anya', 'Taylor-Joy', '1996-04-16', b'0'),
(25, 'Cillian', 'Murphy', '1976-05-25', b'1');

DROP TABLE IF EXISTS actores_peliculas;
CREATE TABLE IF NOT EXISTS actores_peliculas (
  actor_id bigint NOT NULL,
  pelicula_id bigint NOT NULL,
  PRIMARY KEY (actor_id,pelicula_id),
  KEY actores_peliculasToPeliculasFK (pelicula_id)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

INSERT INTO actores_peliculas (actor_id, pelicula_id) VALUES
(1, 1),
(2, 2),
(3, 3),
(4, 3),
(25, 3),
(4, 4),
(11, 4),
(5, 5),
(6, 6),
(7, 7),
(13, 8),
(13, 9),
(25, 9),
(7, 10),
(9, 10),
(18, 10);

DROP TABLE IF EXISTS criticas;
CREATE TABLE IF NOT EXISTS criticas (
  critica_id bigint NOT NULL AUTO_INCREMENT,
  fecha date NOT NULL,
  autor varchar(100) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL DEFAULT 'Anónimo',
  valoracion enum('1','2','3','4','5') NOT NULL,
  cuerpo text CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL,
  pelicula_id bigint NOT NULL,
  PRIMARY KEY (critica_id),
  KEY criticasToPeliculasFK (pelicula_id)
) ENGINE=InnoDB AUTO_INCREMENT=21 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

INSERT INTO criticas (critica_id, fecha, autor, valoracion, cuerpo, pelicula_id) VALUES
(1, '2024-01-15', 'Elena García', '5', 'Una obra maestra conmovedora. Tom Hanks está espectacular. Un viaje emocional inolvidable.', 1),
(2, '2024-02-20', 'Marcos Sánchez', '5', 'Película icónica con una historia que te atrapa de principio a fin. Absolutamente recomendable.', 1),
(3, '2023-11-10', 'Lucía Fernández', '4', 'Meryl Streep se roba la película. Una comedia inteligente y con mucho estilo. Muy entretenida.', 2),
(4, '2023-12-05', 'Javier Torres', '4', 'Divertida, ingeniosa y con un vestuario espectacular. Anne Hathaway y Meryl Streep tienen una química increíble.', 2),
(5, '2024-03-01', 'Sofía Romero', '5', 'Un thriller de ciencia ficción que te vuela la cabeza. Visualmente impresionante y con un guion brillante.', 3),
(6, '2024-04-12', 'David Alonso', '5', 'Compleja pero fascinante. Christopher Nolan en su máxima expresión. Te deja pensando días después.', 3),
(7, '2023-08-19', 'Adrián Navarro', '5', 'El final perfecto para una saga legendaria. Épica, emocionante y llena de acción. Un hito del cine.', 4),
(8, '2023-09-25', 'Paula Mendoza', '4', 'Un espectáculo visual y narrativo. Satisface a los fans y cierra todas las tramas de forma magistral.', 4),
(9, '2024-05-18', 'Sergio Ruiz', '5', 'Denzel Washington ofrece una de las mejores actuaciones de su carrera. Un thriller policial crudo e intenso.', 5),
(10, '2024-06-21', 'María Jiménez', '4', 'La tensión no decae en ningún momento. Un guion potente y unas interpretaciones memorables.', 5),
(11, '2023-10-30', 'Daniel Vega', '5', 'Un thriller psicológico absorbente y perturbador. Natalie Portman está increíble en su papel.', 6),
(12, '2023-11-15', 'Cristina Muñoz', '4', 'Visualmente hipnótica y narrativamente angustiante. Una película que no te deja indiferente.', 6),
(13, '2024-07-07', 'Pablo Gil', '5', 'Una película de culto con un giro final legendario. Provocadora, inteligente y con un estilo único.', 7),
(14, '2024-08-14', 'Laura Moreno', '5', 'Una crítica mordaz a la sociedad de consumo. Sigue siendo tan relevante hoy como en su estreno.', 7),
(15, '2024-01-05', 'Jorge Pascual', '5', 'Considerada por muchos la mejor película de la historia, y con razón. Una historia de esperanza inolvidable.', 8),
(16, '2024-02-11', 'Irene Soto', '5', 'Emotiva, poderosa y perfectamente narrada. Las actuaciones de Robbins y Freeman son magistrales.', 8),
(17, '2023-07-22', 'Miguel Ángel Cano', '5', 'El Joker de Heath Ledger es historia del cine. Más que una película de superhéroes, es un thriller criminal.', 9),
(18, '2023-08-28', 'Sara Pons', '5', 'Una obra maestra del género. Oscura, compleja y con una trama que te mantiene pegado a la pantalla.', 9),
(19, '2023-09-13', 'Francisco Ríos', '5', 'Tarantino cambió las reglas del juego con esta película. Diálogos brillantes y una estructura narrativa genial.', 10),
(20, '2023-10-18', 'Beatriz Roca', '5', 'Violenta, divertida y original. Un clásico moderno que hay que ver sí o sí. Pura genialidad.', 10);

DROP TABLE IF EXISTS peliculas;
CREATE TABLE IF NOT EXISTS peliculas (
  pelicula_id bigint NOT NULL AUTO_INCREMENT,
  titulo varchar(255) NOT NULL,
  genero enum('ACCION','ANIMACION','CIENCIA_FICCION','COMEDIA','DRAMA','FANTASIA','TERROR','THRILLER') DEFAULT NULL,
  duracion int NOT NULL,
  fecha_estreno date NOT NULL,
  PRIMARY KEY (pelicula_id)
) ENGINE=InnoDB AUTO_INCREMENT=11 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

INSERT INTO peliculas (pelicula_id, titulo, genero, duracion, fecha_estreno) VALUES
(1, 'Forrest Gump', 'DRAMA', 142, '1994-07-06'),
(2, 'The Devil Wears Prada', 'COMEDIA', 109, '2006-06-30'),
(3, 'Inception', 'CIENCIA_FICCION', 148, '2010-07-16'),
(4, 'Avengers: Endgame', 'ACCION', 181, '2019-04-26'),
(5, 'Training Day', 'THRILLER', 122, '2001-10-05'),
(6, 'Black Swan', 'DRAMA', 108, '2010-12-17'),
(7, 'Fight Club', 'THRILLER', 139, '1999-10-15'),
(8, 'The Shawshank Redemption', 'DRAMA', 142, '1994-09-23'),
(9, 'The Dark Knight', 'ACCION', 152, '2008-07-18'),
(10, 'Pulp Fiction', 'THRILLER', 154, '1994-10-14');


ALTER TABLE actores_peliculas
  ADD CONSTRAINT actores_peliculasToActoresFK FOREIGN KEY (actor_id) REFERENCES actores (actor_id) ON DELETE RESTRICT ON UPDATE RESTRICT,
  ADD CONSTRAINT actores_peliculasToPeliculasFK FOREIGN KEY (pelicula_id) REFERENCES peliculas (pelicula_id) ON DELETE RESTRICT ON UPDATE RESTRICT;

ALTER TABLE criticas
  ADD CONSTRAINT criticasToPeliculasFK FOREIGN KEY (pelicula_id) REFERENCES peliculas (pelicula_id) ON DELETE CASCADE;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
