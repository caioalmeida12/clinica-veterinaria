-- phpMyAdmin SQL Dump
-- version 5.2.0
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Tempo de geração: 14-Out-2022 às 02:13
-- Versão do servidor: 10.4.24-MariaDB
-- versão do PHP: 7.4.29

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Banco de dados: `clinica-veterinaria`
--

-- --------------------------------------------------------

--
-- Estrutura da tabela `agendamento`
--

CREATE TABLE `agendamento` (
  `idAgendamento` int(11) NOT NULL,
  `idAnimal` int(11) NOT NULL,
  `idFuncionario` int(11) NOT NULL,
  `idServico` int(11) NOT NULL,
  `dataAgendamento` datetime NOT NULL DEFAULT current_timestamp(),
  `situacaoAgendamento` enum('aguardando','realizado','adiado','excluido') NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Extraindo dados da tabela `agendamento`
--

INSERT INTO `agendamento` (`idAgendamento`, `idAnimal`, `idFuncionario`, `idServico`, `dataAgendamento`, `situacaoAgendamento`) VALUES
(1, 1, 1, 1, '2022-10-13 21:07:21', 'aguardando'),
(2, 2, 2, 2, '2022-10-13 21:07:56', 'realizado');

-- --------------------------------------------------------

--
-- Estrutura da tabela `animal`
--

CREATE TABLE `animal` (
  `idAnimal` int(11) NOT NULL,
  `nomeAnimal` varchar(64) NOT NULL,
  `racaAnimal` varchar(64) DEFAULT NULL,
  `nascimentoAnimal` date NOT NULL DEFAULT current_timestamp(),
  `especieAnimal` varchar(64) NOT NULL,
  `sexoAnimal` enum('F','M','O') NOT NULL,
  `corAnimal` varchar(32) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Extraindo dados da tabela `animal`
--

INSERT INTO `animal` (`idAnimal`, `nomeAnimal`, `racaAnimal`, `nascimentoAnimal`, `especieAnimal`, `sexoAnimal`, `corAnimal`) VALUES
(1, 'Animal 1', 'Raca 1', '2022-10-13', 'Especie 1', 'M', 'Cor 1'),
(2, 'Animal 2', 'Raca 2', '2022-10-13', 'Especie 2', 'F', 'Cor 2');

-- --------------------------------------------------------

--
-- Estrutura da tabela `animal-cliente`
--

CREATE TABLE `animal-cliente` (
  `idAnimal` int(11) NOT NULL,
  `idCliente` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Extraindo dados da tabela `animal-cliente`
--

INSERT INTO `animal-cliente` (`idAnimal`, `idCliente`) VALUES
(2, 2),
(1, 4);

-- --------------------------------------------------------

--
-- Estrutura da tabela `cliente`
--

CREATE TABLE `cliente` (
  `idCliente` int(11) NOT NULL,
  `nomeCliente` varchar(64) NOT NULL,
  `cpfCliente` varchar(11) NOT NULL,
  `nascimentoCliente` date NOT NULL DEFAULT current_timestamp(),
  `emailCliente` varchar(64) DEFAULT NULL,
  `telefoneCliente` varchar(13) NOT NULL,
  `enderecoCliente` varchar(128) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Extraindo dados da tabela `cliente`
--

INSERT INTO `cliente` (`idCliente`, `nomeCliente`, `cpfCliente`, `nascimentoCliente`, `emailCliente`, `telefoneCliente`, `enderecoCliente`) VALUES
(2, 'Cliente 2', '22222222222', '2002-02-02', 'emai2@gmail.com', '22222222222', 'Rua 2'),
(4, 'Cliente 1', '11111111111', '2022-10-13', 'email1@gmail.com', '1111111111111', 'Rua 1');

-- --------------------------------------------------------

--
-- Estrutura da tabela `estoque`
--

CREATE TABLE `estoque` (
  `idEstoque` int(11) NOT NULL,
  `idProduto` int(11) NOT NULL,
  `quantidadeProduto` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Extraindo dados da tabela `estoque`
--

INSERT INTO `estoque` (`idEstoque`, `idProduto`, `quantidadeProduto`) VALUES
(1, 1, 11),
(2, 2, 22),
(3, 3, 33),
(4, 4, 44);

-- --------------------------------------------------------

--
-- Estrutura da tabela `funcionario`
--

CREATE TABLE `funcionario` (
  `idFuncionario` int(11) NOT NULL,
  `cpfFuncionario` varchar(11) NOT NULL,
  `nomeFuncionario` varchar(64) NOT NULL,
  `nascimentoFuncionario` date NOT NULL DEFAULT current_timestamp(),
  `emailFuncionario` varchar(64) DEFAULT NULL,
  `salarioFuncionario` smallint(6) NOT NULL DEFAULT 1212,
  `enderecoFuncionario` varchar(128) NOT NULL,
  `telefoneFuncionario` varchar(13) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Extraindo dados da tabela `funcionario`
--

INSERT INTO `funcionario` (`idFuncionario`, `cpfFuncionario`, `nomeFuncionario`, `nascimentoFuncionario`, `emailFuncionario`, `salarioFuncionario`, `enderecoFuncionario`, `telefoneFuncionario`) VALUES
(1, '01010101010', 'Funcionario 1', '2022-10-13', 'funcionario1@gmail.com', 1212, 'Rua 1', '0101010101010'),
(2, '02020202020', 'Funcionario 2', '2022-10-13', 'funcionario2@gmail.com', 1212, 'Rua 2', '0202020202020');

-- --------------------------------------------------------

--
-- Estrutura da tabela `produto`
--

CREATE TABLE `produto` (
  `idProduto` int(11) NOT NULL,
  `nomeProduto` varchar(64) NOT NULL,
  `precoProduto` mediumint(9) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Extraindo dados da tabela `produto`
--

INSERT INTO `produto` (`idProduto`, `nomeProduto`, `precoProduto`) VALUES
(1, 'Produto 1', 1),
(2, 'Produto 2', 2),
(3, 'Produto 3', 3),
(4, 'Produto 4', 4);

-- --------------------------------------------------------

--
-- Estrutura da tabela `servico`
--

CREATE TABLE `servico` (
  `idServico` int(11) NOT NULL,
  `tipoServico` varchar(64) NOT NULL,
  `descricaoServico` tinytext DEFAULT NULL,
  `precoServico` mediumint(9) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Extraindo dados da tabela `servico`
--

INSERT INTO `servico` (`idServico`, `tipoServico`, `descricaoServico`, `precoServico`) VALUES
(1, 'Servico 1', 'Servico 1', 100),
(2, 'Servico 2', 'Servico 2', 200);

-- --------------------------------------------------------

--
-- Estrutura da tabela `venda`
--

CREATE TABLE `venda` (
  `idVenda` int(11) NOT NULL,
  `idProduto` int(11) NOT NULL,
  `idCliente` int(11) NOT NULL,
  `idFuncionario` int(11) NOT NULL,
  `dataVenda` datetime NOT NULL DEFAULT current_timestamp(),
  `quantidadeProduto` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Extraindo dados da tabela `venda`
--

INSERT INTO `venda` (`idVenda`, `idProduto`, `idCliente`, `idFuncionario`, `dataVenda`, `quantidadeProduto`) VALUES
(1, 1, 4, 1, '2022-10-13 21:11:19', 1),
(2, 2, 2, 2, '2022-10-13 21:12:18', 2);

--
-- Índices para tabelas despejadas
--

--
-- Índices para tabela `agendamento`
--
ALTER TABLE `agendamento`
  ADD PRIMARY KEY (`idAgendamento`);

--
-- Índices para tabela `animal`
--
ALTER TABLE `animal`
  ADD PRIMARY KEY (`idAnimal`);

--
-- Índices para tabela `animal-cliente`
--
ALTER TABLE `animal-cliente`
  ADD KEY `idAnimal` (`idAnimal`),
  ADD KEY `idCliente` (`idCliente`);

--
-- Índices para tabela `cliente`
--
ALTER TABLE `cliente`
  ADD PRIMARY KEY (`idCliente`),
  ADD UNIQUE KEY `cpfCliente` (`cpfCliente`);

--
-- Índices para tabela `estoque`
--
ALTER TABLE `estoque`
  ADD PRIMARY KEY (`idEstoque`),
  ADD KEY `idProduto` (`idProduto`);

--
-- Índices para tabela `funcionario`
--
ALTER TABLE `funcionario`
  ADD PRIMARY KEY (`idFuncionario`),
  ADD UNIQUE KEY `cpfFuncionario` (`cpfFuncionario`);

--
-- Índices para tabela `produto`
--
ALTER TABLE `produto`
  ADD PRIMARY KEY (`idProduto`);

--
-- Índices para tabela `servico`
--
ALTER TABLE `servico`
  ADD PRIMARY KEY (`idServico`);

--
-- Índices para tabela `venda`
--
ALTER TABLE `venda`
  ADD PRIMARY KEY (`idVenda`),
  ADD KEY `idProduto` (`idProduto`),
  ADD KEY `idCliente` (`idCliente`),
  ADD KEY `idFuncionario` (`idFuncionario`);

--
-- AUTO_INCREMENT de tabelas despejadas
--

--
-- AUTO_INCREMENT de tabela `agendamento`
--
ALTER TABLE `agendamento`
  MODIFY `idAgendamento` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=3;

--
-- AUTO_INCREMENT de tabela `animal`
--
ALTER TABLE `animal`
  MODIFY `idAnimal` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=3;

--
-- AUTO_INCREMENT de tabela `cliente`
--
ALTER TABLE `cliente`
  MODIFY `idCliente` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=7;

--
-- AUTO_INCREMENT de tabela `estoque`
--
ALTER TABLE `estoque`
  MODIFY `idEstoque` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=5;

--
-- AUTO_INCREMENT de tabela `funcionario`
--
ALTER TABLE `funcionario`
  MODIFY `idFuncionario` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=3;

--
-- AUTO_INCREMENT de tabela `produto`
--
ALTER TABLE `produto`
  MODIFY `idProduto` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=5;

--
-- AUTO_INCREMENT de tabela `servico`
--
ALTER TABLE `servico`
  MODIFY `idServico` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=3;

--
-- AUTO_INCREMENT de tabela `venda`
--
ALTER TABLE `venda`
  MODIFY `idVenda` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=3;

--
-- Restrições para despejos de tabelas
--

--
-- Limitadores para a tabela `animal-cliente`
--
ALTER TABLE `animal-cliente`
  ADD CONSTRAINT `animal-cliente_ibfk_1` FOREIGN KEY (`idAnimal`) REFERENCES `animal` (`idAnimal`),
  ADD CONSTRAINT `animal-cliente_ibfk_2` FOREIGN KEY (`idCliente`) REFERENCES `cliente` (`idCliente`);

--
-- Limitadores para a tabela `estoque`
--
ALTER TABLE `estoque`
  ADD CONSTRAINT `estoque_ibfk_1` FOREIGN KEY (`idProduto`) REFERENCES `produto` (`idProduto`);

--
-- Limitadores para a tabela `venda`
--
ALTER TABLE `venda`
  ADD CONSTRAINT `venda_ibfk_1` FOREIGN KEY (`idProduto`) REFERENCES `produto` (`idProduto`),
  ADD CONSTRAINT `venda_ibfk_2` FOREIGN KEY (`idCliente`) REFERENCES `cliente` (`idCliente`),
  ADD CONSTRAINT `venda_ibfk_3` FOREIGN KEY (`idFuncionario`) REFERENCES `funcionario` (`idFuncionario`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
