-- phpMyAdmin SQL Dump
-- version 5.2.0
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: Jul 18, 2022 at 07:19 AM
-- Server version: 10.4.24-MariaDB
-- PHP Version: 8.1.6

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `sushi_restaurant`
--

-- --------------------------------------------------------

--
-- Table structure for table `customers`
--

CREATE TABLE `customers` (
  `customer_id` int(11) NOT NULL,
  `user_name` varchar(20) NOT NULL,
  `user_pass` varchar(16) NOT NULL,
  `full_name` varchar(50) NOT NULL,
  `mobile_no` varchar(12) NOT NULL,
  `user_addr` text NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `customers`
--

INSERT INTO `customers` (`customer_id`, `user_name`, `user_pass`, `full_name`, `mobile_no`, `user_addr`) VALUES
(117, 'jeremy', '123#Pass', 'Jeremy Devis', '09120000000', 'Bagac, Bataan'),
(141, 'elyeandre', '123#Pass', 'Jerickson Mayor', '09120000000', 'Sample Address'),
(142, 'janette', 'janetteM@1', 'Janette Ambito', '09120000000', 'Orion Bataan'),
(143, 'sampleuser1', 'dfdf@223WE', 'Sample User 1', '09120000000', 'Sample Address'),
(144, 'sampleuser2', 'fgrfg#$3erE', 'Sample User 2', '09120000000', 'Sample Address'),
(145, 'sampleuser3', 'dfdf3@#efWE', 'Sample User 3', '09120000000', 'Sample Address'),
(146, 'sampleuser4', 'dfdf#ERFFERfds33', 'Sample User 4', '09120000000', 'Sample Address'),
(147, 'sampleuser5', 'sdsd2@2212E', 'Sample User 5', '09120000000', 'Sample Address'),
(148, 'sampleuser6', 'dfdf33EW3@', 'Sample User 6', '09120000000', 'Sample Address'),
(149, 'jerickson', '123#Eraserheads', 'Jerickson Mayor', '09120000000', '83 Pag asa Wawa, Orion, Bataan'),
(150, 'sampleuser7', 'dfdf#3ereE', 'Sample User 7', '09120000000', 'Sample Address'),
(151, 'jerick', '123#Eraserheads', 'Jerickson Mayor', '09120000000', 'Pag asa Wawa, Orion, Bataan'),
(152, 'jerick08', '123#Jerickson', 'Jerickson Mayor', '09120000000', 'Orion Bataan');

-- --------------------------------------------------------

--
-- Table structure for table `sales`
--

CREATE TABLE `sales` (
  `order_id` int(11) NOT NULL,
  `order_created` date NOT NULL,
  `item_name` varchar(20) NOT NULL,
  `item_quantity` int(100) NOT NULL,
  `unit_price` double NOT NULL,
  `total_amount` double NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `sales`
--

INSERT INTO `sales` (`order_id`, `order_created`, `item_name`, `item_quantity`, `unit_price`, `total_amount`) VALUES
(142, '2022-07-15', 'Aburi', 4, 49, 196),
(142, '2022-07-15', 'Ama Ebi', 1, 59, 59),
(142, '2022-07-15', 'Kani', 1, 39, 39),
(142, '2022-07-15', 'Maki', 9, 39, 351),
(142, '2022-07-15', 'Saki', 4, 59, 236),
(142, '2022-07-15', 'Tamago', 3, 39, 117),
(151, '2022-07-17', 'Aburi', 1, 49, 49),
(151, '2022-07-17', 'Ama Ebi', 1, 59, 59),
(151, '2022-07-17', 'Kani', 2, 39, 78),
(151, '2022-07-17', 'Maki', 22, 39, 858),
(151, '2022-07-17', 'Saki', 1, 59, 59),
(151, '2022-07-17', 'Tamago', 1, 39, 39),
(152, '2022-07-18', 'Aburi', 6, 49, 294),
(152, '2022-07-18', 'Ama Ebi', 2, 59, 118),
(152, '2022-07-18', 'Kani', 4, 39, 156),
(152, '2022-07-18', 'Maki', 8, 39, 312),
(152, '2022-07-18', 'Saki', 7, 59, 413),
(152, '2022-07-18', 'Tamago', 2, 39, 78);

--
-- Indexes for dumped tables
--

--
-- Indexes for table `customers`
--
ALTER TABLE `customers`
  ADD PRIMARY KEY (`customer_id`);

--
-- Indexes for table `sales`
--
ALTER TABLE `sales`
  ADD PRIMARY KEY (`order_id`,`order_created`,`item_name`,`item_quantity`,`unit_price`,`total_amount`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `customers`
--
ALTER TABLE `customers`
  MODIFY `customer_id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=153;

--
-- Constraints for dumped tables
--

--
-- Constraints for table `sales`
--
ALTER TABLE `sales`
  ADD CONSTRAINT `sales_ibfk_1` FOREIGN KEY (`order_id`) REFERENCES `customers` (`customer_id`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
