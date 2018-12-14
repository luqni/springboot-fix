-- phpMyAdmin SQL Dump
-- version 4.8.3
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Waktu pembuatan: 11 Des 2018 pada 17.12
-- Versi server: 10.1.37-MariaDB
-- Versi PHP: 7.2.12

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET AUTOCOMMIT = 0;
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `coba3`
--

DELIMITER $$
--
-- Prosedur
--
CREATE DEFINER=`root`@`localhost` PROCEDURE `traac` (IN `id` INT(11))  NO SQL
SELECT * FROM transaction WHERE accountid = id$$

CREATE DEFINER=`root`@`localhost` PROCEDURE `tracus` (IN `id` INT(11))  NO SQL
SELECT
a.id, a.opendate, a.balance, c.id idcus, c.firsname, c.lastname
FROM account a, customer c 
WHERE a.customerid = id AND c.id = a.customerid$$

DELIMITER ;

-- --------------------------------------------------------

--
-- Struktur dari tabel `account`
--

CREATE TABLE `account` (
  `id` int(11) NOT NULL,
  `opendate` datetime NOT NULL,
  `balance` int(11) NOT NULL,
  `customerid` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data untuk tabel `account`
--

INSERT INTO `account` (`id`, `opendate`, `balance`, `customerid`) VALUES
(1, '2018-12-01 13:59:59', 10000000, 1),
(2, '2018-12-12 13:59:59', 20000000, 2),
(3, '2018-12-12 13:59:59', 20000000, 3),
(4, '2018-12-13 09:59:59', 40000000, 4),
(5, '2018-12-15 09:59:59', 50000000, 5),
(7, '2018-12-16 09:59:59', 60000000, 6),
(9, '2018-12-01 13:59:59', 10000000, 11),
(10, '2018-12-01 13:59:59', 100000000, 11);

-- --------------------------------------------------------

--
-- Struktur dari tabel `customer`
--

CREATE TABLE `customer` (
  `id` int(11) NOT NULL,
  `username` varchar(45) NOT NULL,
  `password` varchar(45) NOT NULL,
  `firsname` varchar(45) NOT NULL,
  `lastname` varchar(45) NOT NULL,
  `birthdate` varchar(45) NOT NULL,
  `phonetype` varchar(45) NOT NULL,
  `phonenumber` varchar(15) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data untuk tabel `customer`
--

INSERT INTO `customer` (`id`, `username`, `password`, `firsname`, `lastname`, `birthdate`, `phonetype`, `phonenumber`) VALUES
(1, 'tra', 'tra', 'tri rahmat', 'aribowo', '1997-03-26', 'android', '08765463'),
(2, 'admin', 'admin', 'Tri Rahmat', 'Aribowo', '1996-03-26', 'android', '082278526882'),
(3, 'dewa', 'dewa', 'dewa', 'gede', '1996-03-26', 'android', '34'),
(4, 'reza', 'reza', 'reza', 'aja', '1996-03-26', 'android', '44'),
(5, 'tika', 'tika', 'tika', 'yesi', '1996-03-26', 'android', '54'),
(6, 'jupe', 'jupe', 'jupe', 'amin', '1996-03-26', 'android', '343'),
(11, 'tra', 'tra', 'uhuhu', 'lastname', '1997-03-26', 'Android', '082278818535');

-- --------------------------------------------------------

--
-- Struktur dari tabel `transaction`
--

CREATE TABLE `transaction` (
  `id` int(11) NOT NULL,
  `type` varchar(45) NOT NULL,
  `amount` int(11) NOT NULL,
  `amountsign` varchar(45) NOT NULL,
  `accountid` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data untuk tabel `transaction`
--

INSERT INTO `transaction` (`id`, `type`, `amount`, `amountsign`, `accountid`) VALUES
(10, 'harga', 1000000, 't', 4),
(11, 'token listrik', 900000, 'T', 4);

-- --------------------------------------------------------

--
-- Stand-in struktur untuk tampilan `vtra`
-- (Lihat di bawah untuk tampilan aktual)
--
CREATE TABLE `vtra` (
`username` varchar(45)
,`firsname` varchar(45)
,`phonenumber` varchar(15)
,`opendate` datetime
,`balance` int(11)
,`type` varchar(45)
,`amount` int(11)
,`amountsign` varchar(45)
);

-- --------------------------------------------------------

--
-- Struktur untuk view `vtra`
--
DROP TABLE IF EXISTS `vtra`;

CREATE ALGORITHM=UNDEFINED DEFINER=`root`@`localhost` SQL SECURITY DEFINER VIEW `vtra`  AS  select `a`.`username` AS `username`,`a`.`firsname` AS `firsname`,`a`.`phonenumber` AS `phonenumber`,`b`.`opendate` AS `opendate`,`b`.`balance` AS `balance`,`c`.`type` AS `type`,`c`.`amount` AS `amount`,`c`.`amountsign` AS `amountsign` from ((`customer` `a` join `account` `b`) join `transaction` `c`) where ((`a`.`id` = `b`.`customerid`) and (`b`.`id` = `c`.`accountid`)) ;

--
-- Indexes for dumped tables
--

--
-- Indeks untuk tabel `account`
--
ALTER TABLE `account`
  ADD PRIMARY KEY (`id`),
  ADD KEY `customerid_idx` (`customerid`);

--
-- Indeks untuk tabel `customer`
--
ALTER TABLE `customer`
  ADD PRIMARY KEY (`id`);

--
-- Indeks untuk tabel `transaction`
--
ALTER TABLE `transaction`
  ADD PRIMARY KEY (`id`),
  ADD KEY `accountid_idx` (`accountid`);

--
-- AUTO_INCREMENT untuk tabel yang dibuang
--

--
-- AUTO_INCREMENT untuk tabel `account`
--
ALTER TABLE `account`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=11;

--
-- AUTO_INCREMENT untuk tabel `customer`
--
ALTER TABLE `customer`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=14;

--
-- AUTO_INCREMENT untuk tabel `transaction`
--
ALTER TABLE `transaction`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=12;

--
-- Ketidakleluasaan untuk tabel pelimpahan (Dumped Tables)
--

--
-- Ketidakleluasaan untuk tabel `account`
--
ALTER TABLE `account`
  ADD CONSTRAINT `customerid` FOREIGN KEY (`customerid`) REFERENCES `customer` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION;

--
-- Ketidakleluasaan untuk tabel `transaction`
--
ALTER TABLE `transaction`
  ADD CONSTRAINT `accountid` FOREIGN KEY (`accountid`) REFERENCES `account` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
