-- phpMyAdmin SQL Dump
-- version 5.1.1
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Czas generowania: 18 Kwi 2022, 17:49
-- Wersja serwera: 10.4.22-MariaDB
-- Wersja PHP: 8.1.2

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Baza danych: `uczelnia`
--
CREATE DATABASE IF NOT EXISTS `uczelnia` DEFAULT CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci;
USE `uczelnia`;

-- --------------------------------------------------------

--
-- Struktura tabeli dla tabeli `kierunek`
--

CREATE TABLE `kierunek` (
  `id` int(11) NOT NULL,
  `nazwa` varchar(45) NOT NULL,
  `typ` varchar(45) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Zrzut danych tabeli `kierunek`
--

INSERT INTO `kierunek` (`id`, `nazwa`, `typ`) VALUES
(2, 'Administracja', 'licencjackie'),
(4, 'Administracja', 'licencjackie');

-- --------------------------------------------------------

--
-- Struktura tabeli dla tabeli `nauczyciel`
--

CREATE TABLE `nauczyciel` (
  `id` int(11) NOT NULL,
  `email` varchar(45) NOT NULL,
  `imie` varchar(45) NOT NULL,
  `nazwisko` varchar(45) NOT NULL,
  `nr_tel` varchar(15) NOT NULL,
  `tytul` varchar(45) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Zrzut danych tabeli `nauczyciel`
--

INSERT INTO `nauczyciel` (`id`, `email`, `imie`, `nazwisko`, `nr_tel`, `tytul`) VALUES
(1, 'nauczyciel@gmail.com', 'Kamil', 'Tester', '111222333', 'dr. inż'),
(4, 'walek@wp.pl', 'Janek', 'Wałek', '222', 'dr');

-- --------------------------------------------------------

--
-- Struktura tabeli dla tabeli `przedmiot`
--

CREATE TABLE `przedmiot` (
  `id` int(11) NOT NULL,
  `nazwa` varchar(45) NOT NULL,
  `opis` varchar(45) DEFAULT NULL,
  `typ` varchar(45) NOT NULL,
  `nauczyciel_id` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Zrzut danych tabeli `przedmiot`
--

INSERT INTO `przedmiot` (`id`, `nazwa`, `opis`, `typ`, `nauczyciel_id`) VALUES
(1, 'Matematyka', '', 'wykład', 1),
(2, 'Programowanie', 'jakiś opis', 'laboratorium', 1);

-- --------------------------------------------------------

--
-- Struktura tabeli dla tabeli `przedmioty_kierunek`
--

CREATE TABLE `przedmioty_kierunek` (
  `kierunek_id` int(11) NOT NULL,
  `przedmiot_id` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Zrzut danych tabeli `przedmioty_kierunek`
--

INSERT INTO `przedmioty_kierunek` (`kierunek_id`, `przedmiot_id`) VALUES
(2, 1),
(4, 2);

-- --------------------------------------------------------

--
-- Struktura tabeli dla tabeli `users`
--

CREATE TABLE `users` (
  `id` int(11) NOT NULL,
  `email` varchar(45) NOT NULL,
  `first_name` varchar(45) NOT NULL,
  `last_name` varchar(45) NOT NULL,
  `stypendium` bit(1) NOT NULL,
  `kierunek_id` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Zrzut danych tabeli `users`
--

INSERT INTO `users` (`id`, `email`, `first_name`, `last_name`, `stypendium`, `kierunek_id`) VALUES
(2, 'ttt@wp.pl', 'Wojciech', 'Kowal', b'0', 2);

--
-- Indeksy dla zrzutów tabel
--

--
-- Indeksy dla tabeli `kierunek`
--
ALTER TABLE `kierunek`
  ADD PRIMARY KEY (`id`);

--
-- Indeksy dla tabeli `nauczyciel`
--
ALTER TABLE `nauczyciel`
  ADD PRIMARY KEY (`id`);

--
-- Indeksy dla tabeli `przedmiot`
--
ALTER TABLE `przedmiot`
  ADD PRIMARY KEY (`id`),
  ADD KEY `FKs78s0kmxfyr4lnu7jstilvv51` (`nauczyciel_id`);

--
-- Indeksy dla tabeli `przedmioty_kierunek`
--
ALTER TABLE `przedmioty_kierunek`
  ADD PRIMARY KEY (`kierunek_id`,`przedmiot_id`),
  ADD KEY `FK3to0621nskwayomr7tlnuaatw` (`przedmiot_id`);

--
-- Indeksy dla tabeli `users`
--
ALTER TABLE `users`
  ADD PRIMARY KEY (`id`),
  ADD UNIQUE KEY `UK_6dotkott2kjsp8vw4d0m25fb7` (`email`),
  ADD KEY `FKn64njpvwpapjt5x5mi8y3hb8l` (`kierunek_id`);

--
-- AUTO_INCREMENT dla zrzuconych tabel
--

--
-- AUTO_INCREMENT dla tabeli `kierunek`
--
ALTER TABLE `kierunek`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=5;

--
-- AUTO_INCREMENT dla tabeli `nauczyciel`
--
ALTER TABLE `nauczyciel`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=5;

--
-- AUTO_INCREMENT dla tabeli `przedmiot`
--
ALTER TABLE `przedmiot`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=5;

--
-- AUTO_INCREMENT dla tabeli `users`
--
ALTER TABLE `users`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=6;

--
-- Ograniczenia dla zrzutów tabel
--

--
-- Ograniczenia dla tabeli `przedmiot`
--
ALTER TABLE `przedmiot`
  ADD CONSTRAINT `FKs78s0kmxfyr4lnu7jstilvv51` FOREIGN KEY (`nauczyciel_id`) REFERENCES `nauczyciel` (`id`);

--
-- Ograniczenia dla tabeli `przedmioty_kierunek`
--
ALTER TABLE `przedmioty_kierunek`
  ADD CONSTRAINT `FK3to0621nskwayomr7tlnuaatw` FOREIGN KEY (`przedmiot_id`) REFERENCES `przedmiot` (`id`),
  ADD CONSTRAINT `FKq4mt653iwn9046f82fd3lqk1b` FOREIGN KEY (`kierunek_id`) REFERENCES `kierunek` (`id`);

--
-- Ograniczenia dla tabeli `users`
--
ALTER TABLE `users`
  ADD CONSTRAINT `FKn64njpvwpapjt5x5mi8y3hb8l` FOREIGN KEY (`kierunek_id`) REFERENCES `kierunek` (`id`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
