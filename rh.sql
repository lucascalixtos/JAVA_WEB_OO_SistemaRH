-- phpMyAdmin SQL Dump
-- version 4.8.4
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: 23-Nov-2019 às 16:43
-- Versão do servidor: 10.1.37-MariaDB
-- versão do PHP: 7.3.1

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
  `salInicial` float NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Extraindo dados da tabela `cargo`
--

INSERT INTO `cargo` (`id`, `nomeCargo`, `salInicial`) VALUES
(1, 'Programador Junior', 2000);

-- --------------------------------------------------------

--
-- Estrutura da tabela `funcionario`
--

CREATE TABLE `funcionario` (
  `id` int(3) NOT NULL,
  `nome` varchar(255) NOT NULL,
  `data_nascimento` varchar(10) NOT NULL,
  `sexo` varchar(20) NOT NULL,
  `telefone` varchar(15) NOT NULL,
  `email` varchar(70) NOT NULL,
  `cpf` varchar(14) NOT NULL,
  `ctps` varchar(255) NOT NULL,
  `tipo_contrato` varchar(255) NOT NULL,
  `status` varchar(1) NOT NULL,
  `rg` varchar(255) NOT NULL,
  `cep` varchar(255) NOT NULL,
  `num_residencia` int(255) NOT NULL,
  `cargo` varchar(255) NOT NULL,
  `horario_entrada` varchar(255) NOT NULL,
  `horario_saida` varchar(255) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Extraindo dados da tabela `funcionario`
--

INSERT INTO `funcionario` (`id`, `nome`, `data_nascimento`, `sexo`, `telefone`, `email`, `cpf`, `ctps`, `tipo_contrato`, `status`, `rg`, `cep`, `num_residencia`, `cargo`, `horario_entrada`, `horario_saida`) VALUES
(2, 'Thiago', '06/05/1996', 'Masculino', '(11)97319-4551', 'thiagosilva196@gmail.com', '469.709.158-24', '2548498-48445', 'CLT', 'S', '38.048.875-9', '07132-140', 111, 'ProgramadorJr', '08:00', '17:00'),
(3, 'Joao', '12/11/1888', 'Masculino', '', 'dfdsf', '184.894.489-49', '1844984-98489', 'CLT', 'S', '18.484.894-9', '14894-844', 188, 'ProgramadorJr', '08:00', '17:00');

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
  `id` int(10) NOT NULL,
  `salario` float NOT NULL,
  `fk_idCargo` int(10) NOT NULL,
  `fk_idFuncionario` int(10) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Extraindo dados da tabela `salario`
--

INSERT INTO `salario` (`id`, `salario`, `fk_idCargo`, `fk_idFuncionario`) VALUES
(1, 1000, 1, 2);

-- --------------------------------------------------------

--
-- Estrutura da tabela `taxas`
--

CREATE TABLE `taxas` (
  `id` int(11) NOT NULL,
  `nome` varchar(255) NOT NULL,
  `valor` float NOT NULL,
  `dataAlteracao` timestamp(6) NOT NULL DEFAULT CURRENT_TIMESTAMP(6)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Extraindo dados da tabela `taxas`
--

INSERT INTO `taxas` (`id`, `nome`, `valor`, `dataAlteracao`) VALUES
(1, 'INSS', 5, '2019-11-23 14:45:48.953565');

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
  ADD PRIMARY KEY (`id`);

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
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=2;

--
-- AUTO_INCREMENT for table `funcionario`
--
ALTER TABLE `funcionario`
  MODIFY `id` int(3) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=4;

--
-- AUTO_INCREMENT for table `salario`
--
ALTER TABLE `salario`
  MODIFY `id` int(10) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=2;

--
-- AUTO_INCREMENT for table `taxas`
--
ALTER TABLE `taxas`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=2;

--
-- Constraints for dumped tables
--

--
-- Limitadores para a tabela `horario`
--
ALTER TABLE `horario`
  ADD CONSTRAINT `fk_Funcionario` FOREIGN KEY (`id`) REFERENCES `funcionario` (`id`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
