-- phpMyAdmin SQL Dump
-- version 4.8.5
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: 15-Nov-2019 às 02:03
-- Versão do servidor: 10.1.38-MariaDB
-- versão do PHP: 7.3.4

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET AUTOCOMMIT = 0;
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `rh`
--

-- --------------------------------------------------------

--
-- Estrutura da tabela `cargo`
--

CREATE TABLE `cargo` (
  `id` int(11) NOT NULL,
  `nomeCargo` varchar(100) NOT NULL,
  `salHoraInicial` float NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Estrutura da tabela `funcionario`
--

CREATE TABLE `funcionario` (
  `id` int(3) NOT NULL,
  `nome` varchar(255) NOT NULL,
  `data_nascimento` varchar(10) NOT NULL,
  `sexo` varchar(20) NOT NULL,
  `telefone` varchar(12) NOT NULL,
  `email` varchar(70) NOT NULL,
  `cpf` varchar(11) NOT NULL,
  `ctps` varchar(255) NOT NULL,
  `tipo_contrato` varchar(255) NOT NULL,
  `status` tinyint(1) NOT NULL,
  `rg` varchar(255) NOT NULL,
  `cep` varchar(255) NOT NULL,
  `num_residencia` int(255) NOT NULL,
  `cargo` varchar(255) NOT NULL,
  `horario_entrada` varchar(255) NOT NULL,
  `horario_saida` varchar(255) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Estrutura da tabela `horario`
--

CREATE TABLE `horario` (
  `id` int(11) NOT NULL,
  `entrada` timestamp(5) NOT NULL DEFAULT CURRENT_TIMESTAMP(5),
  `saida` timestamp(5) NOT NULL DEFAULT CURRENT_TIMESTAMP(5)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Estrutura da tabela `salario`
--

CREATE TABLE `salario` (
  `id` int(11) NOT NULL,
  `salHora` float NOT NULL,
  `dataAlteracao` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Estrutura da tabela `taxas`
--

CREATE TABLE `taxas` (
  `id` int(11) NOT NULL,
  `fgts` float NOT NULL,
  `inss` float NOT NULL,
  `decimoTerceiro` float NOT NULL,
  `ferias` float NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Indexes for dumped tables
--

--
-- Indexes for table `cargo`
--
ALTER TABLE `cargo`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `funcionario`
--
ALTER TABLE `funcionario`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `horario`
--
ALTER TABLE `horario`
  ADD KEY `fk_Funcionario` (`id`);

--
-- Indexes for table `salario`
--
ALTER TABLE `salario`
  ADD KEY `fk_idFuncionario` (`id`);

--
-- Indexes for table `taxas`
--
ALTER TABLE `taxas`
  ADD PRIMARY KEY (`id`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `cargo`
--
ALTER TABLE `cargo`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT for table `funcionario`
--
ALTER TABLE `funcionario`
  MODIFY `id` int(3) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT for table `taxas`
--
ALTER TABLE `taxas`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT;

--
-- Constraints for dumped tables
--

--
-- Limitadores para a tabela `horario`
--
ALTER TABLE `horario`
  ADD CONSTRAINT `fk_Funcionario` FOREIGN KEY (`id`) REFERENCES `funcionario` (`id`);

--
-- Limitadores para a tabela `salario`
--
ALTER TABLE `salario`
  ADD CONSTRAINT `fk_idCargo` FOREIGN KEY (`id`) REFERENCES `cargo` (`id`),
  ADD CONSTRAINT `fk_idFuncionario` FOREIGN KEY (`id`) REFERENCES `funcionario` (`id`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
