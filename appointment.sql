-- phpMyAdmin SQL Dump
-- version 5.0.1
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: May 06, 2020 at 07:20 PM
-- Server version: 10.4.11-MariaDB
-- PHP Version: 7.4.3

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET AUTOCOMMIT = 0;
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `appointment`
--

-- --------------------------------------------------------

--
-- Table structure for table `appointment`
--

CREATE TABLE `appointment` (
  `AID` int(6) NOT NULL,
  `PID` varchar(20) NOT NULL,
  `PName` varchar(150) NOT NULL,
  `Gender` varchar(20) NOT NULL,
  `DName` varchar(150) NOT NULL,
  `RoomNo` varchar(20) NOT NULL,
  `Date` varchar(20) NOT NULL,
  `Time` varchar(20) NOT NULL,
  `HName` varchar(150) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `appointment`
--

INSERT INTO `appointment` (`AID`, `PID`, `PName`, `Gender`, `DName`, `RoomNo`, `Date`, `Time`, `HName`) VALUES
(1, 'P101', 'Dammika Fernando', 'F', 'Sahan', 'A10', '04%2F05%2F202', '2020-05-06', 'Asiri'),
(2, 'P205', 'Nimal De Silva', 'M', 'Lalith Perera', 'B0', '12/04/202', '2020-05-05', 'Kalubovila '),
(3, 'P206', 'Kalani Wijesingha', 'F', 'Anusha Perera', 'C1', '01/02/202', '2020-05-05', 'Castle'),
(4, 'asd', 'wer', 'M', 'djy', '12', '2020', '3.20', 'mkl');

-- --------------------------------------------------------

--
-- Table structure for table `doctor`
--

CREATE TABLE `doctor` (
  `DocID` int(11) NOT NULL,
  `DocName` varchar(200) NOT NULL,
  `DocNIC` varchar(10) NOT NULL,
  `Gender` varchar(6) NOT NULL,
  `Specialized` varchar(200) NOT NULL,
  `Email` varchar(200) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `doctor`
--

INSERT INTO `doctor` (`DocID`, `DocName`, `DocNIC`, `Gender`, `Specialized`, `Email`) VALUES
(100, 'Sahan Perera', '886524471v', 'M', 'OPD', 'Sahan@gmail.com'),
(105, 'Lalith Perera', '856624874v', 'M', 'Cardiology  ', 'LalithP@gmail.com'),
(200, 'Anusha Perera', '893254812v', 'F', 'Gynaecology', 'Anusha@gmail.com');

-- --------------------------------------------------------

--
-- Table structure for table `hospital`
--

CREATE TABLE `hospital` (
  `HosID` int(11) NOT NULL,
  `HosName` varchar(200) NOT NULL,
  `HosCity` varchar(200) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `hospital`
--

INSERT INTO `hospital` (`HosID`, `HosName`, `HosCity`) VALUES
(10005, 'Asiri', 'Colombo'),
(10008, 'Kalubovila', 'Kalubovila'),
(10063, 'Castle', 'Colombo');

-- --------------------------------------------------------

--
-- Table structure for table `patient`
--

CREATE TABLE `patient` (
  `PNo` int(11) NOT NULL,
  `PID` varchar(5) NOT NULL,
  `Name` varchar(200) NOT NULL,
  `Address` varchar(200) NOT NULL,
  `Age` int(11) NOT NULL,
  `NIC` varchar(20) NOT NULL,
  `Phone` int(10) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `patient`
--

INSERT INTO `patient` (`PNo`, `PID`, `Name`, `Address`, `Age`, `NIC`, `Phone`) VALUES
(1, 'P101', 'Dammika Fernando', 'No45, Mal Waththa Rd, Wadduwa', 30, '906588432v', 776589234);

--
-- Indexes for dumped tables
--

--
-- Indexes for table `appointment`
--
ALTER TABLE `appointment`
  ADD PRIMARY KEY (`AID`);

--
-- Indexes for table `doctor`
--
ALTER TABLE `doctor`
  ADD PRIMARY KEY (`DocID`);

--
-- Indexes for table `hospital`
--
ALTER TABLE `hospital`
  ADD PRIMARY KEY (`HosID`);

--
-- Indexes for table `patient`
--
ALTER TABLE `patient`
  ADD PRIMARY KEY (`PNo`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `appointment`
--
ALTER TABLE `appointment`
  MODIFY `AID` int(6) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=5;

--
-- AUTO_INCREMENT for table `doctor`
--
ALTER TABLE `doctor`
  MODIFY `DocID` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=201;

--
-- AUTO_INCREMENT for table `hospital`
--
ALTER TABLE `hospital`
  MODIFY `HosID` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=10064;

--
-- AUTO_INCREMENT for table `patient`
--
ALTER TABLE `patient`
  MODIFY `PNo` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=2;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
