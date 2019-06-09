-- phpMyAdmin SQL Dump
-- version 4.8.4
-- https://www.phpmyadmin.net/
--
-- Hôte : 127.0.0.1:3306
-- Généré le :  Dim 09 juin 2019 à 15:04
-- Version du serveur :  5.7.24
-- Version de PHP :  7.2.14

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET AUTOCOMMIT = 0;
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Base de données :  `ecesale`
--

-- --------------------------------------------------------

--
-- Structure de la table `acheteur`
--

DROP TABLE IF EXISTS `acheteur`;
CREATE TABLE IF NOT EXISTS `acheteur` (
  `idacheteur` int(32) NOT NULL AUTO_INCREMENT,
  `email` varchar(32) NOT NULL,
  `sel` varchar(32) NOT NULL,
  `password` varchar(256) NOT NULL,
  `nom` varchar(32) NOT NULL,
  `prenom` varchar(32) NOT NULL,
  `paiement` varchar(256) NOT NULL,
  `adressel1` text NOT NULL,
  `adressel2` text NOT NULL,
  `ville` text NOT NULL,
  `codepostal` text NOT NULL,
  `pays` text NOT NULL,
  `numerodetel` text NOT NULL,
  PRIMARY KEY (`idacheteur`)
) ENGINE=MyISAM AUTO_INCREMENT=3 DEFAULT CHARSET=latin1;

--
-- Déchargement des données de la table `acheteur`
--

INSERT INTO `acheteur` (`idacheteur`, `email`, `sel`, `password`, `nom`, `prenom`, `paiement`, `adressel1`, `adressel2`, `ville`, `codepostal`, `pays`, `numerodetel`) VALUES
(2, 'jean.prouvost@edu.ece.fr', '8be2d8e32bde120aa4ec8e20b6fbb5d7', '7b7394663fe3a216f25486c6affb999e4ae326326a3e1875814179a910cf9aa3', 'Prouvost', 'Jean', 'zeffezf', 'czecezce', 'dcscvds', 'cdscds', 'csdcs', 'cdcs', '0633746274');

-- --------------------------------------------------------

--
-- Structure de la table `admin`
--

DROP TABLE IF EXISTS `admin`;
CREATE TABLE IF NOT EXISTS `admin` (
  `idadmin` int(32) NOT NULL AUTO_INCREMENT,
  `pseudo` varchar(100) NOT NULL,
  `email` varchar(100) NOT NULL,
  `sel` varchar(32) NOT NULL,
  `password` varchar(256) NOT NULL,
  PRIMARY KEY (`idadmin`)
) ENGINE=MyISAM AUTO_INCREMENT=2 DEFAULT CHARSET=latin1;

--
-- Déchargement des données de la table `admin`
--

INSERT INTO `admin` (`idadmin`, `pseudo`, `email`, `sel`, `password`) VALUES
(1, 'jean.prouvost@edu.ece.fr', 'kek', '85e4359c48972e518e91e4ebd7f1ce18', 'f96efd627c38bcedf0e6e82dd0f4495213726ca858f2fb04817c4ca93bf15a07');

-- --------------------------------------------------------

--
-- Structure de la table `catalogue`
--

DROP TABLE IF EXISTS `catalogue`;
CREATE TABLE IF NOT EXISTS `catalogue` (
  `idprod` int(32) NOT NULL AUTO_INCREMENT,
  `nom` varchar(32) NOT NULL,
  `idvendeur` int(32) DEFAULT NULL,
  `categorie` varchar(10) NOT NULL,
  `variantes` varchar(512) DEFAULT NULL,
  PRIMARY KEY (`idprod`)
) ENGINE=MyISAM AUTO_INCREMENT=42 DEFAULT CHARSET=latin1;

--
-- Déchargement des données de la table `catalogue`
--

INSERT INTO `catalogue` (`idprod`, `nom`, `idvendeur`, `categorie`, `variantes`) VALUES
(40, 'ayayalavengeance', 5, 'Musique', 'blub;megablub');

-- --------------------------------------------------------

--
-- Structure de la table `cataloguemodele`
--

DROP TABLE IF EXISTS `cataloguemodele`;
CREATE TABLE IF NOT EXISTS `cataloguemodele` (
  `idmodele` int(32) NOT NULL AUTO_INCREMENT,
  `nommodele` varchar(32) DEFAULT NULL,
  `prix` double NOT NULL,
  `idprod` int(32) DEFAULT NULL,
  `photos` varchar(256) NOT NULL,
  `video` varchar(256) NOT NULL,
  `description` varchar(520) NOT NULL,
  `stock` int(32) NOT NULL,
  `nb_vente` int(11) NOT NULL,
  PRIMARY KEY (`idmodele`)
) ENGINE=MyISAM AUTO_INCREMENT=32 DEFAULT CHARSET=latin1;

--
-- Déchargement des données de la table `cataloguemodele`
--

INSERT INTO `cataloguemodele` (`idmodele`, `nommodele`, `prix`, `idprod`, `photos`, `video`, `description`, `stock`, `nb_vente`) VALUES
(28, 'Awooooo', 669, 40, 'amandine projet (1).jpg;amandine projet (1).png;amandine projet (2).jpg', 'Kiniro Mosaic _ Ayaya ! Ayaya !.mp4', 'AWOOOOOOOOOOOOOOOOOOO!', 58, 0),
(29, 'ayayaintensify', 69, 40, 'fez.png;Hollow-Knight.jpg;kekaisensen.jpg', 'Kiniro Mosaic _ Ayaya ! Ayaya !.mp4', 'ayayayaya! intensify!', 420, 0);

-- --------------------------------------------------------

--
-- Structure de la table `vendeur`
--

DROP TABLE IF EXISTS `vendeur`;
CREATE TABLE IF NOT EXISTS `vendeur` (
  `idvendeur` int(11) NOT NULL AUTO_INCREMENT,
  `email` varchar(32) NOT NULL,
  `sel` varchar(32) NOT NULL,
  `password` varchar(256) NOT NULL,
  `nom` varchar(32) NOT NULL,
  `photo` varchar(256) NOT NULL,
  `fond` varchar(100) NOT NULL,
  PRIMARY KEY (`idvendeur`)
) ENGINE=MyISAM AUTO_INCREMENT=6 DEFAULT CHARSET=latin1;

--
-- Déchargement des données de la table `vendeur`
--

INSERT INTO `vendeur` (`idvendeur`, `email`, `sel`, `password`, `nom`, `photo`, `fond`) VALUES
(4, 'ayaya@gayaya.fr', '4a9zwEHzyZKpBLnYpjHCC3mprciGdqT2', 'f09a3ce6dd4e01161e63fc622fc06f6edcb90957cf85be7b423fd77e5f1ac166', 'ayayaleretour', 'amandine projet (1).png', 'tentacle.jpg'),
(5, 'ayay@caramba', 'KTfTp2frGeEMq9pBqOn2uWyRcVw4fLGm', 'b58ff2ed142c45b4c7f39906383ccf9658da17042d48dfecb5f302b2ca01aadc', 'ayayalesecond', 'tentacle.jpg', 'Hollow-Knight.jpg');
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
