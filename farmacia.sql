-- phpMyAdmin SQL Dump
-- version 5.0.4
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Tempo de geração: 26-Abr-2022 às 10:44
-- Versão do servidor: 10.4.17-MariaDB
-- versão do PHP: 8.0.0

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Banco de dados: `farmacia`
--

-- --------------------------------------------------------

--
-- Estrutura da tabela `entrada`
--

CREATE TABLE `entrada` (
  `ide` bigint(10) NOT NULL,
  `qtd` int(50) NOT NULL,
  `datav` datetime(6) NOT NULL,
  `idp` bigint(20) NOT NULL,
  `idf` bigint(20) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_nopad_ci;

-- --------------------------------------------------------

--
-- Estrutura da tabela `funcionario`
--

CREATE TABLE `funcionario` (
  `idf` bigint(20) NOT NULL,
  `nome` varchar(50) COLLATE utf8mb4_unicode_nopad_ci NOT NULL,
  `bi` varchar(14) COLLATE utf8mb4_unicode_nopad_ci DEFAULT NULL,
  `cargo` varchar(25) COLLATE utf8mb4_unicode_nopad_ci NOT NULL,
  `usuario` varchar(25) COLLATE utf8mb4_unicode_nopad_ci NOT NULL,
  `senha` varchar(10) COLLATE utf8mb4_unicode_nopad_ci NOT NULL,
  `estado` varchar(11) COLLATE utf8mb4_unicode_nopad_ci NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_nopad_ci;

-- --------------------------------------------------------

--
-- Estrutura da tabela `produto`
--

CREATE TABLE `produto` (
  `idp` bigint(20) NOT NULL,
  `nome` varchar(50) COLLATE utf8mb4_unicode_nopad_ci NOT NULL,
  `tipo` varchar(30) COLLATE utf8mb4_unicode_nopad_ci NOT NULL,
  `precovenda` double NOT NULL,
  `descricao` varchar(100) COLLATE utf8mb4_unicode_nopad_ci DEFAULT NULL,
  `origem` varchar(50) COLLATE utf8mb4_unicode_nopad_ci DEFAULT NULL,
  `idf` bigint(20) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_nopad_ci;

-- --------------------------------------------------------

--
-- Estrutura da tabela `rastreio`
--

CREATE TABLE `rastreio` (
  `idr` bigint(15) DEFAULT NULL,
  `qtde` int(50) NOT NULL,
  `qtdad_r` int(50) NOT NULL,
  `data` datetime(6) NOT NULL,
  `idp` bigint(20) NOT NULL,
  `idf` bigint(20) NOT NULL,
  `tempoderastreio` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_nopad_ci;

-- --------------------------------------------------------

--
-- Estrutura da tabela `venda`
--

CREATE TABLE `venda` (
  `idv` bigint(15) DEFAULT NULL,
  `idp` bigint(20) NOT NULL,
  `qtdrequerida` int(50) NOT NULL,
  `datavenda` datetime(6) NOT NULL,
  `idf` bigint(20) NOT NULL,
  `fatura` int(15) NOT NULL,
  `totalvenda` datetime(6) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_nopad_ci;

--
-- Índices para tabelas despejadas
--

--
-- Índices para tabela `entrada`
--
ALTER TABLE `entrada`
  ADD PRIMARY KEY (`ide`),
  ADD KEY `idf` (`idf`),
  ADD KEY `idp` (`idp`);

--
-- Índices para tabela `funcionario`
--
ALTER TABLE `funcionario`
  ADD PRIMARY KEY (`idf`);

--
-- Índices para tabela `produto`
--
ALTER TABLE `produto`
  ADD PRIMARY KEY (`idp`),
  ADD KEY `idf` (`idf`);

--
-- Índices para tabela `rastreio`
--
ALTER TABLE `rastreio`
  ADD KEY `idf` (`idf`),
  ADD KEY `idp` (`idp`);

--
-- Índices para tabela `venda`
--
ALTER TABLE `venda`
  ADD KEY `idf` (`idf`),
  ADD KEY `idp` (`idp`);

--
-- AUTO_INCREMENT de tabelas despejadas
--

--
-- AUTO_INCREMENT de tabela `funcionario`
--
ALTER TABLE `funcionario`
  MODIFY `idf` bigint(20) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT de tabela `produto`
--
ALTER TABLE `produto`
  MODIFY `idp` bigint(20) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=3;

--
-- Restrições para despejos de tabelas
--

--
-- Limitadores para a tabela `entrada`
--
ALTER TABLE `entrada`
  ADD CONSTRAINT `entrada_ibfk_1` FOREIGN KEY (`idf`) REFERENCES `funcionario` (`idf`) ON UPDATE CASCADE,
  ADD CONSTRAINT `entrada_ibfk_2` FOREIGN KEY (`idp`) REFERENCES `produto` (`idp`) ON DELETE CASCADE ON UPDATE CASCADE;

--
-- Limitadores para a tabela `produto`
--
ALTER TABLE `produto`
  ADD CONSTRAINT `produto_ibfk_1` FOREIGN KEY (`idf`) REFERENCES `funcionario` (`idf`) ON UPDATE CASCADE;

--
-- Limitadores para a tabela `rastreio`
--
ALTER TABLE `rastreio`
  ADD CONSTRAINT `rastreio_ibfk_1` FOREIGN KEY (`idp`) REFERENCES `produto` (`idp`) ON UPDATE CASCADE,
  ADD CONSTRAINT `rastreio_ibfk_2` FOREIGN KEY (`idf`) REFERENCES `funcionario` (`idf`) ON UPDATE CASCADE;

--
-- Limitadores para a tabela `venda`
--
ALTER TABLE `venda`
  ADD CONSTRAINT `venda_ibfk_1` FOREIGN KEY (`idf`) REFERENCES `funcionario` (`idf`) ON UPDATE CASCADE,
  ADD CONSTRAINT `venda_ibfk_2` FOREIGN KEY (`idp`) REFERENCES `produto` (`idp`) ON UPDATE CASCADE;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
