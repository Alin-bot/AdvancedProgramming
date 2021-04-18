-- phpMyAdmin SQL Dump
-- version 5.1.0
-- https://www.phpmyadmin.net/
--
-- Gazdă: 127.0.0.1
-- Timp de generare: apr. 18, 2021 la 10:00 PM
-- Versiune server: 10.4.18-MariaDB
-- Versiune PHP: 8.0.3

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Bază de date: `test`
--

-- --------------------------------------------------------

--
-- Structură tabel pentru tabel `actors`
--

CREATE TABLE `actors` (
  `id_movie` int(11) NOT NULL,
  `name` varchar(100) NOT NULL,
  `role` varchar(100) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Eliminarea datelor din tabel `actors`
--

INSERT INTO `actors` (`id_movie`, `name`, `role`) VALUES
(3, 'Chris Hemsworth', 'Thor'),
(3, 'Robert Downey', 'Iron Man');

-- --------------------------------------------------------

--
-- Structură tabel pentru tabel `asoc`
--

CREATE TABLE `asoc` (
  `id_movie` int(11) NOT NULL,
  `id_genres` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Eliminarea datelor din tabel `asoc`
--

INSERT INTO `asoc` (`id_movie`, `id_genres`) VALUES
(3, 2);

-- --------------------------------------------------------

--
-- Structură tabel pentru tabel `directors`
--

CREATE TABLE `directors` (
  `id_movie` int(11) NOT NULL,
  `name` varchar(100) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Eliminarea datelor din tabel `directors`
--

INSERT INTO `directors` (`id_movie`, `name`) VALUES
(3, 'Joe Russo'),
(3, 'Anthony Russo');

-- --------------------------------------------------------

--
-- Structură tabel pentru tabel `genres`
--

CREATE TABLE `genres` (
  `id` int(11) NOT NULL,
  `name` varchar(200) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Eliminarea datelor din tabel `genres`
--

INSERT INTO `genres` (`id`, `name`) VALUES
(1, 'drama'),
(2, 'action');

-- --------------------------------------------------------

--
-- Structură tabel pentru tabel `movies`
--

CREATE TABLE `movies` (
  `id` int(11) NOT NULL,
  `title` varchar(200) NOT NULL,
  `release_date` date NOT NULL,
  `duration` double NOT NULL,
  `score` double NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Eliminarea datelor din tabel `movies`
--

INSERT INTO `movies` (`id`, `title`, `release_date`, `duration`, `score`) VALUES
(1, 'Captain America: Civil War', '2016-05-06', 228, 7.8),
(2, 'Avengers: Infinity War', '2018-04-23', 240, 8.4),
(3, 'Avengers: Endgame', '2019-04-26', 320, 8.4);

--
-- Indexuri pentru tabele eliminate
--

--
-- Indexuri pentru tabele `actors`
--
ALTER TABLE `actors`
  ADD KEY `actor_id` (`id_movie`);

--
-- Indexuri pentru tabele `asoc`
--
ALTER TABLE `asoc`
  ADD UNIQUE KEY `id_movie` (`id_movie`,`id_genres`),
  ADD KEY `id-genres` (`id_genres`);

--
-- Indexuri pentru tabele `directors`
--
ALTER TABLE `directors`
  ADD KEY `director_id` (`id_movie`);

--
-- Indexuri pentru tabele `genres`
--
ALTER TABLE `genres`
  ADD PRIMARY KEY (`id`);

--
-- Indexuri pentru tabele `movies`
--
ALTER TABLE `movies`
  ADD PRIMARY KEY (`id`);

--
-- AUTO_INCREMENT pentru tabele eliminate
--

--
-- AUTO_INCREMENT pentru tabele `genres`
--
ALTER TABLE `genres`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=9;

--
-- AUTO_INCREMENT pentru tabele `movies`
--
ALTER TABLE `movies`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=15;

--
-- Constrângeri pentru tabele eliminate
--

--
-- Constrângeri pentru tabele `actors`
--
ALTER TABLE `actors`
  ADD CONSTRAINT `actor_id` FOREIGN KEY (`id_movie`) REFERENCES `movies` (`id`) ON DELETE CASCADE ON UPDATE CASCADE;

--
-- Constrângeri pentru tabele `asoc`
--
ALTER TABLE `asoc`
  ADD CONSTRAINT `id-genres` FOREIGN KEY (`id_genres`) REFERENCES `genres` (`id`) ON DELETE CASCADE ON UPDATE CASCADE,
  ADD CONSTRAINT `id-movie` FOREIGN KEY (`id_movie`) REFERENCES `movies` (`id`) ON DELETE CASCADE ON UPDATE CASCADE;

--
-- Constrângeri pentru tabele `directors`
--
ALTER TABLE `directors`
  ADD CONSTRAINT `director_id` FOREIGN KEY (`id_movie`) REFERENCES `movies` (`id`) ON DELETE CASCADE ON UPDATE CASCADE;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
