-- phpMyAdmin SQL Dump
-- version 4.9.1
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Tempo de geraÃ§Ã£o: 22-Nov-2019 Ã s 04:54
-- VersÃ£o do servidor: 10.4.8-MariaDB
-- versÃ£o do PHP: 7.3.11

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET AUTOCOMMIT = 0;
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Banco de dados: `rh`
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

-- --------------------------------------------------------

--
-- Estrutura da tabela `horario`
--

CREATE TABLE `horario` (
  `id` int(11) NOT NULL,
  `entrada` timestamp(5) NOT NULL DEFAULT current_timestamp(5),
  `saida` timestamp(5) NOT NULL DEFAULT current_timestamp(5)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Estrutura da tabela `salario`
--

CREATE TABLE `salario` (
  `id` int(11) NOT NULL,
  `salario` float NOT NULL,
  `dataAlteracao` timestamp NOT NULL DEFAULT current_timestamp()
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
-- Ã�ndices para tabelas despejadas
--

--
-- Ã�ndices para tabela `cargo`
--
ALTER TABLE `cargo`
  ADD PRIMARY KEY (`id`);

--
-- Ã�ndices para tabela `funcionario`
--
ALTER TABLE `funcionario`
  ADD PRIMARY KEY (`id`);

--
-- Ã�ndices para tabela `horario`
--
ALTER TABLE `horario`
  ADD KEY `fk_Funcionario` (`id`);

--
-- Ã�ndices para tabela `salario`
--
ALTER TABLE `salario`
  ADD KEY `fk_idFuncionario` (`id`);

--
-- Ã�ndices para tabela `taxas`
--
ALTER TABLE `taxas`
  ADD PRIMARY KEY (`id`);

--
-- AUTO_INCREMENT de tabelas despejadas
--

--
-- AUTO_INCREMENT de tabela `cargo`
--
ALTER TABLE `cargo`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT de tabela `funcionario`
--
ALTER TABLE `funcionario`
  MODIFY `id` int(3) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=2;

--
-- AUTO_INCREMENT de tabela `taxas`
--
ALTER TABLE `taxas`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT;

--
-- RestriÃ§Ãµes para despejos de tabelas
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
