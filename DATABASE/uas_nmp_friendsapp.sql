-- phpMyAdmin SQL Dump
-- version 5.2.1
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: Dec 12, 2025 at 02:56 PM
-- Server version: 8.0.33
-- PHP Version: 8.0.30

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `uas_nmp_friendsapp`
--

-- --------------------------------------------------------

--
-- Table structure for table `my_friends`
--

CREATE TABLE `my_friends` (
  `id` int NOT NULL,
  `nrp` varchar(20) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

-- --------------------------------------------------------

--
-- Table structure for table `student`
--

CREATE TABLE `student` (
  `nrp` varchar(20) NOT NULL,
  `nama` varchar(100) DEFAULT NULL,
  `email` varchar(100) DEFAULT NULL,
  `program` varchar(100) DEFAULT NULL,
  `about_me` text,
  `my_course` text,
  `my_experiences` text,
  `photo_url` text
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

--
-- Dumping data for table `student`
--

INSERT INTO `student` (`nrp`, `nama`, `email`, `program`, `about_me`, `my_course`, `my_experiences`, `photo_url`) VALUES
('220001', 'Andi Pratama', 'andi.pratama@example.com', 'Informatika', 'Mahasiswa yang suka ngoding dan teknologi AI.', 'Pemrograman Java, Mobile Development, Database Fundamental', 'Magang sebagai Android Developer di startup lokal.', 'https://randomuser.me/api/portraits/men/1.jpg'),
('220002', 'Budi Santoso', 'budi.santoso@example.com', 'Sistem Informasi', 'Suka analisis data dan business intelligence.', 'Basis Data, Data Analytics, UI/UX Fundamental', 'Pernah menjadi panitia acara kampus dan freelance UI designer.', 'https://randomuser.me/api/portraits/men/2.jpg'),
('220003', 'Citra Lestari', 'citra.lestari@example.com', 'Informatika', 'Pecinta desain UI dan pengembangan aplikasi mobile.', 'Android Studio, Kotlin, UI/UX Design', 'Magang sebagai UI/UX Designer di agensi digital.', 'https://randomuser.me/api/portraits/women/3.jpg'),
('220004', 'Dewi Kusuma', 'dewi.kusuma@example.com', 'Teknik Komputer', 'Suka belajar tentang jaringan dan keamanan komputer.', 'Networking, Ethical Hacking, Sistem Operasi', 'Pernah mengikuti program pelatihan keamanan siber.', 'https://randomuser.me/api/portraits/women/4.jpg'),
('220005', 'Eko Ramadhan', 'eko.ramadhan@example.com', 'Informatika', 'Hobi membuat game indie dan belajar Unity.', 'Pemrograman C#, Unity, Algoritma & Struktur Data', 'Membuat 2 game simple dan ikut lomba IT fair.', 'https://randomuser.me/api/portraits/men/5.jpg'),
('220006', 'Fajar Nugroho', 'fajar.nugroho@example.com', 'Teknik Komputer', 'Tertarik dengan hardware komputer dan IoT.', 'Elektronika Digital, IoT Basic, Mikrokontroler', 'Magang di perusahaan IoT sebagai teknisi perangkat.', 'https://randomuser.me/api/portraits/men/6.jpg'),
('220007', 'Gita Permata', 'gita.permata@example.com', 'Sistem Informasi', 'Suka penelitian data dan business process.', 'Data Mining, Sistem Informasi Manajemen, SQL', 'Asisten dosen mata kuliah sistem informasi.', 'https://randomuser.me/api/portraits/women/7.jpg'),
('220008', 'Hani Wulandari', 'hani.wulandari@example.com', 'Informatika', 'Berfokus pada machine learning dan data science.', 'Python, Machine Learning, Statistik', 'Pernah membuat model prediksi sederhana untuk tugas kuliah.', 'https://randomuser.me/api/portraits/women/8.jpg'),
('220009', 'Irwan Syahputra', 'irwan.syahputra@example.com', 'Teknik Komputer', 'Hobi oprek hardware dan overclocking.', 'Arsitektur Komputer, Mikrokontroler, Elektronika', 'Teknisi lab komputer selama 1 tahun.', 'https://randomuser.me/api/portraits/men/9.jpg'),
('220010', 'Jasmine Safira', 'jasmine.safira@example.com', 'Sistem Informasi', 'Tertarik dengan digital marketing dan manajemen data.', 'Digital Marketing, Database, Data Visualization', 'Magang sebagai content creator & data assistant.', 'https://randomuser.me/api/portraits/women/10.jpg');

--
-- Indexes for dumped tables
--

--
-- Indexes for table `my_friends`
--
ALTER TABLE `my_friends`
  ADD PRIMARY KEY (`id`),
  ADD KEY `nrp` (`nrp`);

--
-- Indexes for table `student`
--
ALTER TABLE `student`
  ADD PRIMARY KEY (`nrp`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `my_friends`
--
ALTER TABLE `my_friends`
  MODIFY `id` int NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=7;

--
-- Constraints for dumped tables
--

--
-- Constraints for table `my_friends`
--
ALTER TABLE `my_friends`
  ADD CONSTRAINT `my_friends_ibfk_1` FOREIGN KEY (`nrp`) REFERENCES `student` (`nrp`) ON DELETE CASCADE ON UPDATE CASCADE;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
