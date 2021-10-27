-- phpMyAdmin SQL Dump
-- version 5.1.1
-- https://www.phpmyadmin.net/
--
-- Hôte : localhost
-- Généré le : mar. 26 oct. 2021 à 03:12
-- Version du serveur : 10.5.11-MariaDB-1
-- Version de PHP : 7.4.21

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Base de données : `TP_NOTE`
--

-- --------------------------------------------------------

--
-- Structure de la table `pokedex`
--

CREATE TABLE `pokedex` (
  `id` int(11) NOT NULL,
  `nom` varchar(10) NOT NULL,
  `types0nom` varchar(10) NOT NULL,
  `types0couleur` varchar(21) NOT NULL,
  `types1nom` varchar(6) DEFAULT NULL,
  `types1couleur` varchar(20) DEFAULT NULL,
  `baseHP` int(11) NOT NULL,
  `baseAttack` int(11) NOT NULL,
  `baseDefense` int(11) NOT NULL,
  `baseSpAttack` int(11) NOT NULL,
  `baseSpDefense` int(11) NOT NULL,
  `baseSpeed` int(11) NOT NULL,
  `description` varchar(108) NOT NULL,
  `image` varchar(7) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Déchargement des données de la table `pokedex`
--

INSERT INTO `pokedex` (`id`, `nom`, `types0nom`, `types0couleur`, `types1nom`, `types1couleur`, `baseHP`, `baseAttack`, `baseDefense`, `baseSpAttack`, `baseSpDefense`, `baseSpeed`, `description`, `image`) VALUES
(1, 'Bulbizarre', 'Plante', '#66bb6a', 'Poison', '#ab47bc', 45, 49, 49, 65, 65, 45, 'Bulbasaur is a Grass/Poison type Pokémon introduced in Generation 1. It is known as the Seed Pokémon.', '001.png'),
(2, 'Herbizarre', 'Plante', '#66bb6a', 'Poison', '#ab47bc', 60, 62, 63, 80, 80, 60, 'Ivysaur is a Grass/Poison type Pokémon introduced in Generation 1. It is known as the Seed Pokémon.', '002.png'),
(3, 'Florizarre', 'Plante', '#66bb6a', 'Poison', '#ab47bc', 80, 82, 83, 100, 100, 80, 'Venusaur is a Grass/Poison type Pokémon introduced in Generation 1. It is known as the Seed Pokémon.', '003.png'),
(4, 'Salamèche', 'Feu', '#ff7043', NULL, NULL, 39, 52, 43, 60, 50, 65, 'Charmander is a Fire type Pokémon introduced in Generation 1. It is known as the Lizard Pokémon.', '004.png'),
(5, 'Reptincel', 'Feu', '#ff7043', NULL, NULL, 58, 64, 58, 80, 65, 80, 'Charmeleon is a Fire type Pokémon introduced in Generation 1. It is known as the Flame Pokémon.', '005.png'),
(6, 'Dracaufeu', 'Feu', '#ff7043', 'Vol', '#81d4fa', 78, 84, 78, 109, 85, 100, 'Charizard is a Fire/Flying type Pokémon introduced in Generation 1. It is known as the Flame Pokémon.', '006.png'),
(7, 'Carapuce', 'Eau', '#42a5f5', NULL, NULL, 44, 48, 65, 50, 64, 43, 'Squirtle is a Water type Pokémon introduced in Generation 1. It is known as the Tiny Turtle Pokémon.', '007.png'),
(8, 'Carabaffe', 'Eau', '#42a5f5', NULL, NULL, 59, 63, 80, 65, 80, 58, 'Wartortle is a Water type Pokémon introduced in Generation 1. It is known as the Turtle Pokémon.', '008.png'),
(9, 'Tortank', 'Eau', '#42a5f5', NULL, NULL, 79, 83, 100, 85, 105, 78, 'Blastoise is a Water type Pokémon introduced in Generation 1. It is known as the Shellfish Pokémon.', '009.png'),
(10, 'Chenipan', 'Insecte', '#aeea00', NULL, NULL, 45, 30, 35, 20, 20, 45, 'Caterpie is a Bug type Pokémon introduced in Generation 1. It is known as the Worm Pokémon.', '010.png'),
(11, 'Chrysacier', 'Insecte', '#aeea00', NULL, NULL, 50, 20, 55, 25, 25, 30, 'Metapod is a Bug type Pokémon introduced in Generation 1. It is known as the Cocoon Pokémon.', '011.png'),
(12, 'Papilusion', 'Insecte', '#aeea00', 'Vol', '#81d4fa', 60, 45, 50, 90, 80, 70, 'Butterfree is a Bug/Flying type Pokémon introduced in Generation 1. It is known as the Butterfly Pokémon.', '012.png'),
(13, 'Aspicot', 'Insecte', '#aeea00', 'Poison', '#ab47bc', 40, 35, 30, 20, 20, 50, 'Weedle is a Bug/Poison type Pokémon introduced in Generation 1. It is known as the Hairy Bug Pokémon.', '013.png'),
(14, 'Coconfort', 'Insecte', '#aeea00', 'Poison', '#ab47bc', 45, 25, 50, 25, 25, 35, 'Kakuna is a Bug/Poison type Pokémon introduced in Generation 1. It is known as the Cocoon Pokémon.', '014.png'),
(15, 'Dardargnan', 'Insecte', '#aeea00', 'Poison', '#ab47bc', 65, 90, 40, 45, 80, 75, 'Beedrill is a Bug/Poison type Pokémon introduced in Generation 1. It is known as the Poison Bee Pokémon.', '015.png'),
(16, 'Roucool', 'Normal', '#bdbdbd', 'Vol', '#81d4fa', 40, 45, 40, 35, 35, 56, 'Pidgey is a Normal/Flying type Pokémon introduced in Generation 1. It is known as the Tiny Bird Pokémon.', '016.png'),
(17, 'Roucoups', 'Normal', '#bdbdbd', 'Vol', '#81d4fa', 63, 60, 55, 50, 50, 71, 'Pidgeotto is a Normal/Flying type Pokémon introduced in Generation 1. It is known as the Bird Pokémon.', '017.png'),
(18, 'Roucarnage', 'Normal', '#bdbdbd', 'Vol', '#81d4fa', 83, 80, 75, 70, 70, 101, 'Pidgeot is a Normal/Flying type Pokémon introduced in Generation 1. It is known as the Bird Pokémon.', '018.png'),
(19, 'Rattata', 'Normal', '#bdbdbd', NULL, NULL, 30, 56, 35, 25, 35, 72, 'Rattata is a Normal type Pokémon introduced in Generation 1. It is known as the Mouse Pokémon.', '019.png'),
(20, 'Rattatac', 'Normal', '#bdbdbd', NULL, NULL, 55, 81, 60, 50, 70, 97, 'Raticate is a Normal type Pokémon introduced in Generation 1. It is known as the Mouse Pokémon.', '020.png'),
(21, 'Piafabec', 'Normal', '#bdbdbd', 'Vol', '#81d4fa', 40, 60, 30, 31, 31, 70, 'Spearow is a Normal/Flying type Pokémon introduced in Generation 1. It is known as the Tiny Bird Pokémon.', '021.png'),
(22, 'Rapasdepic', 'Normal', '#bdbdbd', 'Vol', '#81d4fa', 65, 90, 65, 61, 61, 100, 'Fearow is a Normal/Flying type Pokémon introduced in Generation 1. It is known as the Beak Pokémon.', '022.png'),
(23, 'Abo', 'Poison', '#ab47bc', NULL, NULL, 35, 60, 44, 40, 54, 55, 'Ekans is a Poison type Pokémon introduced in Generation 1. It is known as the Snake Pokémon.', '023.png'),
(24, 'Arbok', 'Poison', '#ab47bc', NULL, NULL, 60, 95, 69, 65, 79, 80, 'Arbok is a Poison type Pokémon introduced in Generation 1. It is known as the Cobra Pokémon.', '024.png'),
(25, 'Pikachu', 'Electrique', '#ffee58', NULL, NULL, 35, 55, 40, 50, 50, 90, 'Pikachu is an Electric type Pokémon introduced in Generation 1. It is known as the Mouse Pokémon.', '025.png'),
(26, 'Raichu', 'Electrique', '#ffee58', NULL, NULL, 60, 90, 55, 90, 80, 110, 'Raichu is an Electric type Pokémon introduced in Generation 1. It is known as the Mouse Pokémon.', '026.png'),
(27, 'Sabelette', 'Sol', '#ffe57f', NULL, NULL, 50, 75, 85, 20, 30, 40, 'Sandshrew is a Ground type Pokémon introduced in Generation 1. It is known as the Mouse Pokémon.', '027.png'),
(28, 'Sablaireau', 'Sol', '#ffe57f', NULL, NULL, 75, 100, 110, 45, 55, 65, 'Sandslash is a Ground type Pokémon introduced in Generation 1. It is known as the Mouse Pokémon.', '028.png'),
(29, 'Nidoran♀', 'Poison', '#ab47bc', NULL, NULL, 55, 47, 52, 40, 40, 41, 'Nidoran♀ is a Poison type Pokémon introduced in Generation 1. It is known as the Poison Pin Pokémon.', '029.png'),
(30, 'Nidorina', 'Poison', '#ab47bc', NULL, NULL, 70, 62, 67, 55, 55, 56, 'Nidorina is a Poison type Pokémon introduced in Generation 1. It is known as the Poison Pin Pokémon.', '030.png'),
(31, 'Nidoqueen', 'Poison', '#ab47bc', 'Sol', '#ffe57f', 90, 92, 87, 75, 85, 76, 'Nidoqueen is a Poison/Ground type Pokémon introduced in Generation 1. It is known as the Drill Pokémon.', '031.png'),
(32, 'Nidoran♂', 'Poison', '#ab47bc', NULL, NULL, 46, 57, 40, 40, 40, 50, 'Nidoran♂ is a Poison type Pokémon introduced in Generation 1. It is known as the Poison Pin Pokémon.', '032.png'),
(33, 'Nidorino', 'Poison', '#ab47bc', NULL, NULL, 61, 72, 57, 55, 55, 65, 'Nidorino is a Poison type Pokémon introduced in Generation 1. It is known as the Poison Pin Pokémon.', '033.png'),
(34, 'Nidoking', 'Poison', '#ab47bc', 'Sol', '#ffe57f', 81, 102, 77, 85, 75, 85, 'Nidoking is a Poison/Ground type Pokémon introduced in Generation 1. It is known as the Drill Pokémon.', '034.png'),
(35, 'Mélofée', 'Fée', '#f48fb1', NULL, NULL, 70, 45, 48, 60, 65, 35, 'Clefairy is a Fairy type Pokémon introduced in Generation 1. It is known as the Fairy Pokémon.', '035.png'),
(36, 'Mélodelfe', 'Fée', '#f48fb1', NULL, NULL, 95, 70, 73, 95, 90, 60, 'Clefable is a Fairy type Pokémon introduced in Generation 1. It is known as the Fairy Pokémon.', '036.png'),
(37, 'Goupix', 'Feu', '#ff7043', NULL, NULL, 38, 41, 40, 50, 65, 65, 'Vulpix is a Fire type Pokémon introduced in Generation 1. It is known as the Fox Pokémon.', '037.png'),
(38, 'Feunard', 'Feu', '#ff7043', NULL, NULL, 73, 76, 75, 81, 100, 100, 'Ninetales is a Fire type Pokémon introduced in Generation 1. It is known as the Fox Pokémon.', '038.png'),
(39, 'Rondoudou', 'Normal', '#bdbdbd', 'Fée', '#f48fb1', 115, 45, 20, 45, 25, 20, 'Jigglypuff is a Normal/Fairy type Pokémon introduced in Generation 1. It is known as the Balloon Pokémon.', '039.png'),
(40, 'Grodoudou', 'Normal', '#bdbdbd', 'Fée', '#f48fb1', 140, 70, 45, 85, 50, 45, 'Wigglytuff is a Normal/Fairy type Pokémon introduced in Generation 1. It is known as the Balloon Pokémon.', '040.png'),
(41, 'Nosferapti', 'Poison', '#ab47bc', 'Vol', '#81d4fa', 40, 45, 35, 30, 40, 55, 'Zubat is a Poison/Flying type Pokémon introduced in Generation 1. It is known as the Bat Pokémon.', '041.png'),
(42, 'Nosferalto', 'Poison', '#ab47bc', 'Vol', '#81d4fa', 75, 80, 70, 65, 75, 90, 'Golbat is a Poison/Flying type Pokémon introduced in Generation 1. It is known as the Bat Pokémon.', '042.png'),
(43, 'Mystherbe', 'Plante', '#66bb6a', 'Poison', '#ab47bc', 45, 50, 55, 75, 65, 30, 'Oddish is a Grass/Poison type Pokémon introduced in Generation 1. It is known as the Weed Pokémon.', '043.png'),
(44, 'Ortide', 'Plante', '#66bb6a', 'Poison', '#ab47bc', 60, 65, 70, 85, 75, 40, 'Gloom is a Grass/Poison type Pokémon introduced in Generation 1. It is known as the Weed Pokémon.', '044.png'),
(45, 'Rafflesia', 'Plante', '#66bb6a', 'Poison', '#ab47bc', 75, 80, 85, 110, 90, 50, 'Vileplume is a Grass/Poison type Pokémon introduced in Generation 1. It is known as the Flower Pokémon.', '045.png'),
(46, 'Paras', 'Insecte', '#aeea00', 'Plante', '#66bb6a', 35, 70, 55, 45, 55, 25, 'Paras is a Bug/Grass type Pokémon introduced in Generation 1. It is known as the Mushroom Pokémon.', '046.png'),
(47, 'Parasect', 'Insecte', '#aeea00', 'Plante', '#66bb6a', 60, 95, 80, 60, 80, 30, 'Parasect is a Bug/Grass type Pokémon introduced in Generation 1. It is known as the Mushroom Pokémon.', '047.png'),
(48, 'Mimitoss', 'Insecte', '#aeea00', 'Poison', '#ab47bc', 60, 55, 50, 40, 55, 45, 'Venonat is a Bug/Poison type Pokémon introduced in Generation 1. It is known as the Insect Pokémon.', '048.png'),
(49, 'Aéromite', 'Insecte', '#aeea00', 'Poison', '#ab47bc', 70, 65, 60, 90, 75, 90, 'Venomoth is a Bug/Poison type Pokémon introduced in Generation 1. It is known as the Poison Moth Pokémon.', '049.png'),
(50, 'Taupiqueur', 'Sol', '#ffe57f', NULL, NULL, 10, 55, 25, 35, 45, 95, 'Diglett is a Ground type Pokémon introduced in Generation 1. It is known as the Mole Pokémon.', '050.png'),
(51, 'Triopikeur', 'Sol', '#ffe57f', NULL, NULL, 35, 100, 50, 50, 70, 120, 'Dugtrio is a Ground type Pokémon introduced in Generation 1. It is known as the Mole Pokémon.', '051.png'),
(52, 'Miaouss', 'Normal', '#bdbdbd', NULL, NULL, 40, 45, 35, 40, 40, 90, 'Meowth is a Normal type Pokémon introduced in Generation 1. It is known as the Scratch Cat Pokémon.', '052.png'),
(53, 'Persian', 'Normal', '#bdbdbd', NULL, NULL, 65, 70, 60, 65, 65, 115, 'Persian is a Normal type Pokémon introduced in Generation 1. It is known as the Classy Cat Pokémon.', '053.png'),
(54, 'Psykokwak', 'Eau', '#42a5f5', NULL, NULL, 50, 52, 48, 65, 50, 55, 'Psyduck is a Water type Pokémon introduced in Generation 1. It is known as the Duck Pokémon.', '054.png'),
(55, 'Akwakwak', 'Eau', '#42a5f5', NULL, NULL, 80, 82, 78, 95, 80, 85, 'Golduck is a Water type Pokémon introduced in Generation 1. It is known as the Duck Pokémon.', '055.png'),
(56, 'Férosinge', 'Combat', '#bf360c', NULL, NULL, 40, 80, 35, 35, 45, 70, 'Mankey is a Fighting type Pokémon introduced in Generation 1. It is known as the Pig Monkey Pokémon.', '056.png'),
(57, 'Colossinge', 'Combat', '#bf360c', NULL, NULL, 65, 105, 60, 60, 70, 95, 'Primeape is a Fighting type Pokémon introduced in Generation 1. It is known as the Pig Monkey Pokémon.', '057.png'),
(58, 'Caninos', 'Feu', '#ff7043', NULL, NULL, 55, 70, 45, 70, 50, 60, 'Growlithe is a Fire type Pokémon introduced in Generation 1. It is known as the Puppy Pokémon.', '058.png'),
(59, 'Arcanin', 'Feu', '#ff7043', NULL, NULL, 90, 110, 80, 100, 80, 95, 'Arcanine is a Fire type Pokémon introduced in Generation 1. It is known as the Legendary Pokémon.', '059.png'),
(60, 'Ptitard', 'Eau', '#42a5f5', NULL, NULL, 40, 50, 40, 40, 40, 90, 'Poliwag is a Water type Pokémon introduced in Generation 1. It is known as the Tadpole Pokémon.', '060.png'),
(61, 'Têtarte', 'Eau', '#42a5f5', NULL, NULL, 65, 65, 65, 50, 50, 90, 'Poliwhirl is a Water type Pokémon introduced in Generation 1. It is known as the Tadpole Pokémon.', '061.png'),
(62, 'Tartard', 'Eau', '#42a5f5', 'Combat', '#bf360c', 90, 95, 95, 70, 90, 70, 'Poliwrath is a Water/Fighting type Pokémon introduced in Generation 1. It is known as the Tadpole Pokémon.', '062.png'),
(63, 'Abra', 'Psy', '#ff4081', NULL, NULL, 25, 20, 15, 105, 55, 90, 'Abra is a Psychic type Pokémon introduced in Generation 1. It is known as the Psi Pokémon.', '063.png'),
(64, 'Kadabra', 'Psy', '#ff4081', NULL, NULL, 40, 35, 30, 120, 70, 105, 'Kadabra is a Psychic type Pokémon introduced in Generation 1. It is known as the Psi Pokémon.', '064.png'),
(65, 'Alakazam', 'Psy', '#ff4081', NULL, NULL, 55, 50, 45, 135, 95, 120, 'Alakazam is a Psychic type Pokémon introduced in Generation 1. It is known as the Psi Pokémon.', '065.png'),
(66, 'Machoc', 'Combat', '#bf360c', NULL, NULL, 70, 80, 50, 35, 35, 35, 'Machop is a Fighting type Pokémon introduced in Generation 1. It is known as the Superpower Pokémon.', '066.png'),
(67, 'Machopeur', 'Combat', '#bf360c', NULL, NULL, 80, 100, 70, 50, 60, 45, 'Machoke is a Fighting type Pokémon introduced in Generation 1. It is known as the Superpower Pokémon.', '067.png'),
(68, 'Mackogneur', 'Combat', '#bf360c', NULL, NULL, 90, 130, 80, 65, 85, 55, 'Machamp is a Fighting type Pokémon introduced in Generation 1. It is known as the Superpower Pokémon.', '068.png'),
(69, 'Chétiflor', 'Plante', '#66bb6a', 'Poison', '#ab47bc', 50, 75, 35, 70, 30, 40, 'Bellsprout is a Grass/Poison type Pokémon introduced in Generation 1. It is known as the Flower Pokémon.', '069.png'),
(70, 'Boustiflor', 'Plante', '#66bb6a', 'Poison', '#ab47bc', 65, 90, 50, 85, 45, 55, 'Weepinbell is a Grass/Poison type Pokémon introduced in Generation 1. It is known as the Flycatcher Pokémon.', '070.png'),
(71, 'Empiflor', 'Plante', '#66bb6a', 'Poison', '#ab47bc', 80, 105, 65, 100, 70, 70, 'Victreebel is a Grass/Poison type Pokémon introduced in Generation 1. It is known as the Flycatcher Pokémon.', '071.png'),
(72, 'Tentacool', 'Eau', '#42a5f5', 'Poison', '#ab47bc', 40, 40, 35, 50, 100, 70, 'Tentacool is a Water/Poison type Pokémon introduced in Generation 1. It is known as the Jellyfish Pokémon.', '072.png'),
(73, 'Tentacruel', 'Eau', '#42a5f5', 'Poison', '#ab47bc', 80, 70, 65, 80, 120, 100, 'Tentacruel is a Water/Poison type Pokémon introduced in Generation 1. It is known as the Jellyfish Pokémon.', '073.png'),
(74, 'Racaillou', 'Roche', '#a1887f', 'Sol', '#ffe57f', 40, 80, 100, 30, 30, 20, 'Geodude is a Rock/Ground type Pokémon introduced in Generation 1. It is known as the Rock Pokémon.', '074.png'),
(75, 'Gravalanch', 'Roche', '#a1887f', 'Sol', '#ffe57f', 55, 95, 115, 45, 45, 35, 'Graveler is a Rock/Ground type Pokémon introduced in Generation 1. It is known as the Rock Pokémon.', '075.png'),
(76, 'Grolem', 'Roche', '#a1887f', 'Sol', '#ffe57f', 80, 120, 130, 55, 65, 45, 'Golem is a Rock/Ground type Pokémon introduced in Generation 1. It is known as the Megaton Pokémon.', '076.png'),
(77, 'Ponyta', 'Feu', '#ff7043', NULL, NULL, 50, 85, 55, 65, 65, 90, 'Ponyta is a Fire type Pokémon introduced in Generation 1. It is known as the Fire Horse Pokémon.', '077.png'),
(78, 'Galopa', 'Feu', '#ff7043', NULL, NULL, 65, 100, 70, 80, 80, 105, 'Rapidash is a Fire type Pokémon introduced in Generation 1. It is known as the Fire Horse Pokémon.', '078.png'),
(79, 'Ramoloss', 'Eau', '#42a5f5', 'Psy', '#ff4081', 90, 65, 65, 40, 40, 15, 'Slowpoke is a Water/Psychic type Pokémon introduced in Generation 1. It is known as the Dopey Pokémon.', '079.png'),
(80, 'Flagadoss', 'Eau', '#42a5f5', 'Psy', '#ff4081', 95, 75, 110, 100, 80, 30, 'Slowbro is a Water/Psychic type Pokémon introduced in Generation 1. It is known as the Hermit Crab Pokémon.', '080.png'),
(81, 'Magnéti', 'Electrique', '#ffee58', 'Acier', '#78909c', 25, 35, 70, 95, 55, 45, 'Magnemite is an Electric/Steel type Pokémon introduced in Generation 1. It is known as the Magnet Pokémon.', '081.png'),
(82, 'Magnéton', 'Electrique', '#ffee58', 'Acier', '#78909c', 50, 60, 95, 120, 70, 70, 'Magneton is an Electric/Steel type Pokémon introduced in Generation 1. It is known as the Magnet Pokémon.', '082.png'),
(83, 'Canarticho', 'Normal', '#bdbdbd', 'Vol', '#81d4fa', 52, 90, 55, 58, 62, 60, 'Farfetch\'d is a Normal/Flying type Pokémon introduced in Generation 1. It is known as the Wild Duck Pokémon.', '083.png'),
(84, 'Doduo', 'Normal', '#bdbdbd', 'Vol', '#81d4fa', 35, 85, 45, 35, 35, 75, 'Doduo is a Normal/Flying type Pokémon introduced in Generation 1. It is known as the Twin Bird Pokémon.', '084.png'),
(85, 'Dodrio', 'Normal', '#bdbdbd', 'Vol', '#81d4fa', 60, 110, 70, 60, 60, 110, 'Dodrio is a Normal/Flying type Pokémon introduced in Generation 1. It is known as the Triple Bird Pokémon.', '085.png'),
(86, 'Otaria', 'Eau', '#42a5f5', NULL, NULL, 65, 45, 55, 45, 70, 45, 'Seel is a Water type Pokémon introduced in Generation 1. It is known as the Sea Lion Pokémon.', '086.png'),
(87, 'Lamantine', 'Eau', '#42a5f5', 'Glace', '#26c6da', 90, 70, 80, 70, 95, 70, 'Dewgong is a Water/Ice type Pokémon introduced in Generation 1. It is known as the Sea Lion Pokémon.', '087.png'),
(88, 'Tadmorv', 'Poison', '#ab47bc', NULL, NULL, 80, 80, 50, 40, 50, 25, 'Grimer is a Poison type Pokémon introduced in Generation 1. It is known as the Sludge Pokémon.', '088.png'),
(89, 'Grotadmorv', 'Poison', '#ab47bc', NULL, NULL, 105, 105, 75, 65, 100, 50, 'Muk is a Poison type Pokémon introduced in Generation 1. It is known as the Sludge Pokémon.', '089.png'),
(90, 'Kokiyas', 'Eau', '#42a5f5', NULL, NULL, 30, 65, 100, 45, 25, 40, 'Shellder is a Water type Pokémon introduced in Generation 1. It is known as the Bivalve Pokémon.', '090.png'),
(91, 'Crustabri', 'Eau', '#42a5f5', 'Glace', '#26c6da', 50, 95, 180, 85, 45, 70, 'Cloyster is a Water/Ice type Pokémon introduced in Generation 1. It is known as the Bivalve Pokémon.', '091.png'),
(92, 'Fantominus', 'Spectre', '#7e57c2', 'Poison', '#ab47bc', 30, 35, 30, 100, 35, 80, 'Gastly is a Ghost/Poison type Pokémon introduced in Generation 1. It is known as the Gas Pokémon.', '092.png'),
(93, 'Spectrum', 'Spectre', '#7e57c2', 'Poison', '#ab47bc', 45, 50, 45, 115, 55, 95, 'Haunter is a Ghost/Poison type Pokémon introduced in Generation 1. It is known as the Gas Pokémon.', '093.png'),
(94, 'Ectoplasma', 'Spectre', '#7e57c2', 'Poison', '#ab47bc', 60, 65, 60, 130, 75, 110, 'Gengar is a Ghost/Poison type Pokémon introduced in Generation 1. It is known as the Shadow Pokémon.', '094.png'),
(95, 'Onix', 'Roche', '#a1887f', 'Sol', '#ffe57f', 35, 45, 160, 30, 45, 70, 'Onix is a Rock/Ground type Pokémon introduced in Generation 1. It is known as the Rock Snake Pokémon.', '095.png'),
(96, 'Soporifik', 'Psy', '#ff4081', NULL, NULL, 60, 48, 45, 43, 90, 42, 'Drowzee is a Psychic type Pokémon introduced in Generation 1. It is known as the Hypnosis Pokémon.', '096.png'),
(97, 'Hypnomade', 'Psy', '#ff4081', NULL, NULL, 85, 73, 70, 73, 115, 67, 'Hypno is a Psychic type Pokémon introduced in Generation 1. It is known as the Hypnosis Pokémon.', '097.png'),
(98, 'Krabby', 'Eau', '#42a5f5', NULL, NULL, 30, 105, 90, 25, 25, 50, 'Krabby is a Water type Pokémon introduced in Generation 1. It is known as the River Crab Pokémon.', '098.png'),
(99, 'Krabboss', 'Eau', '#42a5f5', NULL, NULL, 55, 130, 115, 50, 50, 75, 'Kingler is a Water type Pokémon introduced in Generation 1. It is known as the Pincer Pokémon.', '099.png'),
(100, 'Voltorbe', 'Electrique', '#ffee58', NULL, NULL, 40, 30, 50, 55, 55, 100, 'Voltorb is an Electric type Pokémon introduced in Generation 1. It is known as the Ball Pokémon.', '100.png'),
(101, 'Électrode', 'Electrique', '#ffee58', NULL, NULL, 60, 50, 70, 80, 80, 150, 'Electrode is an Electric type Pokémon introduced in Generation 1. It is known as the Ball Pokémon.', '101.png'),
(102, 'Noeunoeuf', 'Plante', '#66bb6a', 'Psy', '#ff4081', 60, 40, 80, 60, 45, 40, 'Exeggcute is a Grass/Psychic type Pokémon introduced in Generation 1. It is known as the Egg Pokémon.', '102.png'),
(103, 'Noadkoko', 'Plante', '#66bb6a', 'Psy', '#ff4081', 95, 95, 85, 125, 75, 55, 'Exeggutor is a Grass/Psychic type Pokémon introduced in Generation 1. It is known as the Coconut Pokémon.', '103.png'),
(104, 'Osselait', 'Sol', '#ffe57f', NULL, NULL, 50, 50, 95, 40, 50, 35, 'Cubone is a Ground type Pokémon introduced in Generation 1. It is known as the Lonely Pokémon.', '104.png'),
(105, 'Ossatueur', 'Sol', '#ffe57f', NULL, NULL, 60, 80, 110, 50, 80, 45, 'Marowak is a Ground type Pokémon introduced in Generation 1. It is known as the Bone Keeper Pokémon.', '105.png'),
(106, 'Kicklee', 'Combat', '#bf360c', NULL, NULL, 50, 120, 53, 35, 110, 87, 'Hitmonlee is a Fighting type Pokémon introduced in Generation 1. It is known as the Kicking Pokémon.', '106.png'),
(107, 'Tygnon', 'Combat', '#bf360c', NULL, NULL, 50, 105, 79, 35, 110, 76, 'Hitmonchan is a Fighting type Pokémon introduced in Generation 1. It is known as the Punching Pokémon.', '107.png'),
(108, 'Excelangue', 'Normal', '#bdbdbd', NULL, NULL, 90, 55, 75, 60, 75, 30, 'Lickitung is a Normal type Pokémon introduced in Generation 1. It is known as the Licking Pokémon.', '108.png'),
(109, 'Smogo', 'Poison', '#ab47bc', NULL, NULL, 40, 65, 95, 60, 45, 35, 'Koffing is a Poison type Pokémon introduced in Generation 1. It is known as the Poison Gas Pokémon.', '109.png'),
(110, 'Smogogo', 'Poison', '#ab47bc', NULL, NULL, 65, 90, 120, 85, 70, 60, 'Weezing is a Poison type Pokémon introduced in Generation 1. It is known as the Poison Gas Pokémon.', '110.png'),
(111, 'Rhinocorne', 'Sol', '#ffe57f', 'Roche', '#a1887f', 80, 85, 95, 30, 30, 25, 'Rhyhorn is a Ground/Rock type Pokémon introduced in Generation 1. It is known as the Spikes Pokémon.', '111.png'),
(112, 'Rhinoféros', 'Sol', '#ffe57f', 'Roche', '#a1887f', 105, 130, 120, 45, 45, 40, 'Rhydon is a Ground/Rock type Pokémon introduced in Generation 1. It is known as the Drill Pokémon.', '112.png'),
(113, 'Leveinard', 'Normal', '#bdbdbd', NULL, NULL, 250, 5, 5, 35, 105, 50, 'Chansey is a Normal type Pokémon introduced in Generation 1. It is known as the Egg Pokémon.', '113.png'),
(114, 'Saquedeneu', 'Plante', '#66bb6a', NULL, NULL, 65, 55, 115, 100, 40, 60, 'Tangela is a Grass type Pokémon introduced in Generation 1. It is known as the Vine Pokémon.', '114.png'),
(115, 'Kangourex', 'Normal', '#bdbdbd', NULL, NULL, 105, 95, 80, 40, 80, 90, 'Kangaskhan is a Normal type Pokémon introduced in Generation 1. It is known as the Parent Pokémon.', '115.png'),
(116, 'Hypotrempe', 'Eau', '#42a5f5', NULL, NULL, 30, 40, 70, 70, 25, 60, 'Horsea is a Water type Pokémon introduced in Generation 1. It is known as the Dragon Pokémon.', '116.png'),
(117, 'Hypocéan', 'Eau', '#42a5f5', NULL, NULL, 55, 65, 95, 95, 45, 85, 'Seadra is a Water type Pokémon introduced in Generation 1. It is known as the Dragon Pokémon.', '117.png'),
(118, 'Poissirène', 'Eau', '#42a5f5', NULL, NULL, 45, 67, 60, 35, 50, 63, 'Goldeen is a Water type Pokémon introduced in Generation 1. It is known as the Goldfish Pokémon.', '118.png'),
(119, 'Poissoroy', 'Eau', '#42a5f5', NULL, NULL, 80, 92, 65, 65, 80, 68, 'Seaking is a Water type Pokémon introduced in Generation 1. It is known as the Goldfish Pokémon.', '119.png'),
(120, 'Stari', 'Eau', '#42a5f5', NULL, NULL, 30, 45, 55, 70, 55, 85, 'Staryu is a Water type Pokémon introduced in Generation 1. It is known as the Star Shape Pokémon.', '120.png'),
(121, 'Staross', 'Eau', '#42a5f5', 'Psy', '#ff4081', 60, 75, 85, 100, 85, 115, 'Starmie is a Water/Psychic type Pokémon introduced in Generation 1. It is known as the Mysterious Pokémon.', '121.png'),
(122, 'M. Mime', 'Psy', '#ff4081', 'Fée', '#f48fb1', 40, 45, 65, 100, 120, 90, 'Mr. Mime is a Psychic/Fairy type Pokémon introduced in Generation 1. It is known as the Barrier Pokémon.', '122.png'),
(123, 'Insécateur', 'Insecte', '#aeea00', 'Vol', '#81d4fa', 70, 110, 80, 55, 80, 105, 'Scyther is a Bug/Flying type Pokémon introduced in Generation 1. It is known as the Mantis Pokémon.', '123.png'),
(124, 'Lippoutou', 'Glace', '#26c6da', 'Psy', '#ff4081', 65, 50, 35, 115, 95, 95, 'Jynx is an Ice/Psychic type Pokémon introduced in Generation 1. It is known as the Human Shape Pokémon.', '124.png'),
(125, 'Élektek', 'Electrique', '#ffee58', NULL, NULL, 65, 83, 57, 95, 85, 105, 'Electabuzz is an Electric type Pokémon introduced in Generation 1. It is known as the Electric Pokémon.', '125.png'),
(126, 'Magmar', 'Feu', '#ff7043', NULL, NULL, 65, 95, 57, 100, 85, 93, 'Magmar is a Fire type Pokémon introduced in Generation 1. It is known as the Spitfire Pokémon.', '126.png'),
(127, 'Scarabrute', 'Insecte', '#aeea00', NULL, NULL, 65, 125, 100, 55, 70, 85, 'Pinsir is a Bug type Pokémon introduced in Generation 1. It is known as the Stag Beetle Pokémon.', '127.png'),
(128, 'Tauros', 'Normal', '#bdbdbd', NULL, NULL, 75, 100, 95, 40, 70, 110, 'Tauros is a Normal type Pokémon introduced in Generation 1. It is known as the Wild Bull Pokémon.', '128.png'),
(129, 'Magicarpe', 'Eau', '#42a5f5', NULL, NULL, 20, 10, 55, 15, 20, 80, 'Magikarp is a Water type Pokémon introduced in Generation 1. It is known as the Fish Pokémon.', '129.png'),
(130, 'Léviator', 'Eau', '#42a5f5', 'Vol', '#81d4fa', 95, 125, 79, 60, 100, 81, 'Gyarados is a Water/Flying type Pokémon introduced in Generation 1. It is known as the Atrocious Pokémon.', '130.png'),
(131, 'Lokhlass', 'Eau', '#42a5f5', 'Glace', '#26c6da', 130, 85, 80, 85, 95, 60, 'Lapras is a Water/Ice type Pokémon introduced in Generation 1. It is known as the Transport Pokémon.', '131.png'),
(132, 'Métamorph', 'Normal', '#bdbdbd', NULL, NULL, 48, 48, 48, 48, 48, 48, 'Ditto is a Normal type Pokémon introduced in Generation 1. It is known as the Transform Pokémon.', '132.png'),
(133, 'Évoli', 'Normal', '#bdbdbd', NULL, NULL, 55, 55, 50, 45, 65, 55, 'Eevee is a Normal type Pokémon introduced in Generation 1. It is known as the Evolution Pokémon.', '133.png'),
(134, 'Aquali', 'Eau', '#42a5f5', NULL, NULL, 130, 65, 60, 110, 95, 65, 'Vaporeon is a Water type Pokémon introduced in Generation 1. It is known as the Bubble Jet Pokémon.', '134.png'),
(135, 'Voltali', 'Electrique', '#ffee58', NULL, NULL, 65, 65, 60, 110, 95, 130, 'Jolteon is an Electric type Pokémon introduced in Generation 1. It is known as the Lightning Pokémon.', '135.png'),
(136, 'Pyroli', 'Feu', '#ff7043', NULL, NULL, 65, 130, 60, 95, 110, 65, 'Flareon is a Fire type Pokémon introduced in Generation 1. It is known as the Flame Pokémon.', '136.png'),
(137, 'Porygon', 'Normal', '#bdbdbd', NULL, NULL, 65, 60, 70, 85, 75, 40, 'Porygon is a Normal type Pokémon introduced in Generation 1. It is known as the Virtual Pokémon.', '137.png'),
(138, 'Amonita', 'Roche', '#a1887f', 'Eau', '#42a5f5', 35, 40, 100, 90, 55, 35, 'Omanyte is a Rock/Water type Pokémon introduced in Generation 1. It is known as the Spiral Pokémon.', '138.png'),
(139, 'Amonistar', 'Roche', '#a1887f', 'Eau', '#42a5f5', 70, 60, 125, 115, 70, 55, 'Omastar is a Rock/Water type Pokémon introduced in Generation 1. It is known as the Spiral Pokémon.', '139.png'),
(140, 'Kabuto', 'Roche', '#a1887f', 'Eau', '#42a5f5', 30, 80, 90, 55, 45, 55, 'Kabuto is a Rock/Water type Pokémon introduced in Generation 1. It is known as the Shellfish Pokémon.', '140.png'),
(141, 'Kabutops', 'Roche', '#a1887f', 'Eau', '#42a5f5', 60, 115, 105, 65, 70, 80, 'Kabutops is a Rock/Water type Pokémon introduced in Generation 1. It is known as the Shellfish Pokémon.', '141.png'),
(142, 'Ptéra', 'Roche', '#a1887f', 'Vol', '#81d4fa', 80, 105, 65, 60, 75, 130, 'Aerodactyl is a Rock/Flying type Pokémon introduced in Generation 1. It is known as the Fossil Pokémon.', '142.png'),
(143, 'Ronflex', 'Normal', '#bdbdbd', NULL, NULL, 160, 110, 65, 65, 110, 30, 'Snorlax is a Normal type Pokémon introduced in Generation 1. It is known as the Sleeping Pokémon.', '143.png'),
(144, 'Artikodin', 'Glace', '#26c6da', 'Vol', '#81d4fa', 90, 85, 100, 95, 125, 85, 'Articuno is an Ice/Flying type Pokémon introduced in Generation 1. It is known as the Freeze Pokémon.', '144.png'),
(145, 'Électhor', 'Electrique', '#ffee58', 'Vol', '#81d4fa', 90, 90, 85, 125, 90, 100, 'Zapdos is an Electric/Flying type Pokémon introduced in Generation 1. It is known as the Electric Pokémon.', '145.png'),
(146, 'Sulfura', 'Feu', '#ff7043', 'Vol', '#81d4fa', 90, 100, 90, 125, 85, 90, 'Moltres is a Fire/Flying type Pokémon introduced in Generation 1. It is known as the Flame Pokémon.', '146.png'),
(147, 'Minidraco', 'Dragon', '#651fff', NULL, NULL, 41, 64, 45, 50, 50, 50, 'Dratini is a Dragon type Pokémon introduced in Generation 1. It is known as the Dragon Pokémon.', '147.png'),
(148, 'Draco', 'Dragon', '#651fff', NULL, NULL, 61, 84, 65, 70, 70, 70, 'Dragonair is a Dragon type Pokémon introduced in Generation 1. It is known as the Dragon Pokémon.', '148.png'),
(149, 'Dracolosse', 'Dragon', '#651fff', 'Vol', '#81d4fa', 91, 134, 95, 100, 100, 80, 'Dragonite is a Dragon/Flying type Pokémon introduced in Generation 1. It is known as the Dragon Pokémon.', '149.png'),
(150, 'Mewtwo', 'Psy', '#ff4081', NULL, NULL, 106, 110, 90, 154, 90, 130, 'Mewtwo is a Psychic type Pokémon introduced in Generation 1. It is known as the Genetic Pokémon.', '150.png'),
(151, 'Mew', 'Psy', '#ff4081', NULL, NULL, 100, 100, 100, 100, 100, 100, 'Mew is a Psychic type Pokémon introduced in Generation 1. It is known as the New Species Pokémon.', '151.png');

--
-- Index pour les tables déchargées
--

--
-- Index pour la table `pokedex`
--
ALTER TABLE `pokedex`
  ADD PRIMARY KEY (`id`);

--
-- AUTO_INCREMENT pour les tables déchargées
--

--
-- AUTO_INCREMENT pour la table `pokedex`
--
ALTER TABLE `pokedex`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=152;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
