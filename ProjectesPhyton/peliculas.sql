-- phpMyAdmin SQL Dump
-- version 4.9.0.1
-- https://www.phpmyadmin.net/
--
-- Servidor: 127.0.0.1
-- Tiempo de generación: 08-11-2019 a las 02:02:33
-- Versión del servidor: 10.4.6-MariaDB
-- Versión de PHP: 7.2.22

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET AUTOCOMMIT = 0;
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Base de datos: `peliculas`
--

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `pelicula`
--

CREATE TABLE `pelicula` (
  `titulo` varchar(100) CHARACTER SET utf8mb4 COLLATE utf8mb4_spanish_ci NOT NULL,
  `link_pelicula` varchar(200) CHARACTER SET utf8mb4 COLLATE utf8mb4_spanish_ci NOT NULL,
  `imagen_pelicula` varchar(200) CHARACTER SET utf8mb4 COLLATE utf8mb4_spanish_ci NOT NULL,
  `id_pelicula` varchar(200) CHARACTER SET utf8mb4 COLLATE utf8mb4_spanish_ci NOT NULL,
  `resolucion` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_spanish_ci NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_520_ci;

--
-- Volcado de datos para la tabla `pelicula`
--

INSERT INTO `pelicula` (`titulo`, `link_pelicula`, `imagen_pelicula`, `id_pelicula`, `resolucion`) VALUES
('Driven: El origen de la leyenda', 'https://www.elitetorrent.nu/peliculas/driven-el-origen-de-la-leyenda/', 'images/DrivenElorigendelaleyenda.jpg', '108a6f31-7115-4e51-92a5-d7a6ecc71505', '720p'),
('Wounds', 'https://www.elitetorrent.nu/peliculas/wounds/', 'images/Wounds.jpg', '1462ad2e-20e1-460b-b114-84dc9fe893fb', '1080p'),
('Hotel Artemis', 'https://www.elitetorrent.nu/peliculas/hotel-artemis/', 'images/HotelArtemis.jpg', '17e204ca-78cc-44b9-8983-b6829dc43bd8', '1080p'),
('Diecisiete', 'https://www.elitetorrent.nu/peliculas/diecisiete/', 'images/Diecisiete.jpg', '1990d98c-187a-4d98-b7f8-2e4f484289a9', '1080p'),
('Toy Story 4', 'https://www.elitetorrent.nu/peliculas/toy-story-4-4/', 'images/ToyStory4.jpg', '242ce5bd-5a63-4b34-8b6b-0b8571913eb7', '1080p'),
('Maléfica: Maestra del Mal', 'https://www.elitetorrent.nu/peliculas/malefica-maestra-del-mal-ts-castellano/', 'images/MaléficaMaestradelMal.jpg', '2b397d3d-60c8-472c-bfb9-b1a2e50353eb', 'TS'),
('La Lavandería', 'https://www.elitetorrent.nu/peliculas/la-lavanderia/', 'images/LaLavandería.jpg', '2f4be9d5-f65a-42af-9ca2-6cc8c1a00d0b', '1080p'),
('Los Descendientes 3', 'https://www.elitetorrent.nu/peliculas/los-descendientes-3-castellano/', 'images/LosDescendientes3.jpg', '332ed1ea-6b0d-4910-86bf-a36181a57650', '1080p'),
('Mr. Link: El origen perdido', 'https://www.elitetorrent.nu/peliculas/mr-link-el-origen-perdido/', 'images/Mr.LinkElorigenperdido.jpg', '36fda73e-e872-4cf5-b9d2-42887a4764ec', 'HDRIP'),
('Vitoria, 3 de marzo', 'https://www.elitetorrent.nu/peliculas/vitoria-3-de-marzo/', 'images/Vitoria,3demarzo.jpg', '37e48f10-0bf8-40f6-b6f1-41cb5d677c70', '1080p'),
('La Influencia', 'https://www.elitetorrent.nu/peliculas/la-influencia/', 'images/LaInfluencia.jpg', '3cdc9e8b-bd2e-4504-ba16-767177243e06', '1080p'),
('Terminator: Destino Oscuro', 'https://www.elitetorrent.nu/peliculas/terminator-destino-oscuro-ts-castellano/', 'images/TerminatorDestinoOscuro.jpg', '49404fc0-0a6a-44a6-a196-c111e34b5a32', 'TS'),
('El vendedor de tabaco', 'https://www.elitetorrent.nu/peliculas/el-vendedor-de-tabaco/', 'images/Elvendedordetabaco.jpg', '49ed85f4-9af2-494a-a3e4-ad5a440bb998', '1080p'),
('Vuela como una mariposa', 'https://www.elitetorrent.nu/peliculas/vuela-como-una-mariposa/', 'images/Vuelacomounamariposa.jpg', '5bb262e2-84a0-4071-85cd-9e40d1121773', 'HDRIP'),
('Enemigos íntimos', 'https://www.elitetorrent.nu/peliculas/enemigos-intimos-2/', 'images/Enemigosíntimos.jpg', '64a9ad12-0549-4e7e-8067-436da69dc9ac', '1080p'),
('Fractura', 'https://www.elitetorrent.nu/peliculas/fractura/', 'images/Fractura.jpg', '72400b2b-f883-496f-b80d-2a28e3c644f6', '1080p'),
('Una pequeña mentira', 'https://www.elitetorrent.nu/peliculas/una-pequena-mentira/', 'images/Unapequeñamentira.jpg', '7bc4827f-d473-4a55-9946-d6f629f1ea65', 'TS'),
('El sol también es una estrella', 'https://www.elitetorrent.nu/peliculas/el-sol-tambien-es-una-estrella-7/', 'images/Elsoltambiénesunaestrella.jpg', '8f54b5cc-1478-40db-9c31-cc7fb386a300', '1080p'),
('Suburbanos', 'https://www.elitetorrent.nu/peliculas/suburbanos/', 'images/Suburbanos.jpg', '9978df96-1176-4f6c-ac25-a4bbe5309050', '1080p'),
('La biblioteca de los libros rechazados', 'https://www.elitetorrent.nu/peliculas/la-biblioteca-de-los-libros-rechazados/', 'images/Labibliotecadeloslibrosrechazados.jpg', 'c04ec94b-b35c-410b-95bd-8c56cc866450', '1080p'),
('Zombieland: Mata y remata', 'https://www.elitetorrent.nu/peliculas/zombieland-mata-y-remata-2/', 'images/ZombielandMatayremata.jpg', 'cc54e257-501d-4da0-b29c-0a9ca94cd77a', 'TS'),
('10 días sin mamá', 'https://www.elitetorrent.nu/peliculas/10-dias-sin-mama/', 'images/10díassinmamá.jpg', 'cd88fd77-5885-441b-a55c-e69b63a7bc46', '1080p'),
('Una nueva identidad', 'https://www.elitetorrent.nu/peliculas/una-nueva-identidad/', 'images/Unanuevaidentidad.jpg', 'd0d400b4-d9b0-4d7c-bebd-0b88a0433ffd', '720p'),
('Necesitamos tu voto', 'https://www.elitetorrent.nu/peliculas/necesitamos-tu-voto/', 'images/Necesitamostuvoto.jpg', 'ddb37454-abb4-4d46-ae2d-2bc2db060a95', '1080p'),
('Dobles vidas', 'https://www.elitetorrent.nu/peliculas/dobles-vidas-4/', 'images/Doblesvidas.jpg', 'df7d27a1-929a-427b-81aa-3b8d790f0435', '1080p'),
('La canción de mi padre', 'https://www.elitetorrent.nu/peliculas/la-cancion-de-mi-padre/', 'images/Lacancióndemipadre.jpg', 'e2989df5-92b2-44ce-b46a-f51624fe5ec6', '1080p'),
('Historias de miedo para contar en la oscuridad', 'https://www.elitetorrent.nu/peliculas/historias-de-miedo-para-contar-en-la-oscuridad/', 'images/Historiasdemiedoparacontarenlaoscuridad.jpg', 'e32e8f01-5d54-4bf7-8ccb-012bdb1cbeda', 'BRS'),
('Kin', 'https://www.elitetorrent.nu/peliculas/kin-2/', 'images/Kin.jpg', 'e488e8bc-c44e-497f-8191-d9541fbc0908', '1080p'),
('Hurricane', 'https://www.elitetorrent.nu/peliculas/hurricane-2/', 'images/Hurricane.jpg', 'f4ce3f50-e0c8-434b-8a44-fb38813e8b2e', '1080p'),
('Eli', 'https://www.elitetorrent.nu/peliculas/eli/', 'images/Eli.jpg', 'fe2b17e5-eb71-4fa4-ad83-670e4c8193de', '1080p');

--
-- Índices para tablas volcadas
--

--
-- Indices de la tabla `pelicula`
--
ALTER TABLE `pelicula`
  ADD PRIMARY KEY (`id_pelicula`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
