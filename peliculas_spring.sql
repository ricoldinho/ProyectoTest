SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

CREATE DATABASE IF NOT EXISTS peliculas_spring DEFAULT CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci;
USE peliculas_spring;

CREATE TABLE actores (
  actor_id bigint NOT NULL,
  nombre varchar(255) DEFAULT NULL,
  apellido varchar(255) DEFAULT NULL,
  fecha_nacimiento date NOT NULL,
  oscarizado bit(1) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

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

CREATE TABLE actores_peliculas (
  actor_id bigint NOT NULL,
  pelicula_id bigint NOT NULL
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

CREATE TABLE peliculas (
  pelicula_id bigint NOT NULL,
  titulo varchar(255) NOT NULL,
  genero enum('ACCION','ANIMACION','CIENCIA_FICCION','COMEDIA','DRAMA','FANTASIA','TERROR','THRILLER') DEFAULT NULL,
  duracion int NOT NULL,
  fecha_estreno date NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

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


ALTER TABLE actores
  ADD PRIMARY KEY (actor_id);

ALTER TABLE actores_peliculas
  ADD PRIMARY KEY (actor_id,pelicula_id),
  ADD KEY actores_peliculasToPeliculasFK (pelicula_id);

ALTER TABLE peliculas
  ADD PRIMARY KEY (pelicula_id);


ALTER TABLE actores
  MODIFY actor_id bigint NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=26;

ALTER TABLE peliculas
  MODIFY pelicula_id bigint NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=11;


ALTER TABLE actores_peliculas
  ADD CONSTRAINT actores_peliculasToActoresFK FOREIGN KEY (actor_id) REFERENCES actores (actor_id) ON DELETE RESTRICT ON UPDATE RESTRICT,
  ADD CONSTRAINT actores_peliculasToPeliculasFK FOREIGN KEY (pelicula_id) REFERENCES peliculas (pelicula_id) ON DELETE RESTRICT ON UPDATE RESTRICT;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
