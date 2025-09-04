-- phpMyAdmin SQL Dump
-- version 5.2.1
-- https://www.phpmyadmin.net/
--
-- Servidor: 127.0.0.1
-- Tiempo de generación: 04-09-2025 a las 06:46:00
-- Versión del servidor: 10.4.32-MariaDB
-- Versión de PHP: 8.2.12

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Base de datos: `conjunto_actividad`
--

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `estado_ticket`
--

CREATE TABLE `estado_ticket` (
  `id` int(11) NOT NULL,
  `nombre` varchar(50) NOT NULL,
  `creado_en` timestamp NOT NULL DEFAULT current_timestamp(),
  `actualizado_en` timestamp NOT NULL DEFAULT current_timestamp() ON UPDATE current_timestamp()
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Volcado de datos para la tabla `estado_ticket`
--

INSERT INTO `estado_ticket` (`id`, `nombre`, `creado_en`, `actualizado_en`) VALUES
(1, 'ABIERTO', '2025-09-04 04:29:16', '2025-09-04 04:38:00'),
(2, 'EN PROCESO', '2025-09-04 04:29:16', '2025-09-04 04:38:00'),
(3, 'EN ESPERA', '2025-09-04 04:29:16', '2025-09-04 04:38:00'),
(4, 'CERRADO', '2025-09-04 04:29:16', '2025-09-04 04:38:00');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `notificacion`
--

CREATE TABLE `notificacion` (
  `id` int(11) NOT NULL,
  `usuario_id` int(11) NOT NULL,
  `ticket_id` int(11) NOT NULL,
  `fecha_envio` timestamp NOT NULL DEFAULT current_timestamp(),
  `creado_en` timestamp NOT NULL DEFAULT current_timestamp(),
  `actualizado_en` timestamp NOT NULL DEFAULT current_timestamp() ON UPDATE current_timestamp()
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `tickets`
--

CREATE TABLE `tickets` (
  `id` int(11) NOT NULL,
  `usuario_id` int(11) NOT NULL,
  `tipo_solicitud_id` int(11) NOT NULL,
  `titulo` varchar(100) NOT NULL,
  `descripcion` text NOT NULL,
  `estado_ticket_id` int(11) NOT NULL,
  `creado_en` timestamp NOT NULL DEFAULT current_timestamp(),
  `actualizado_en` timestamp NOT NULL DEFAULT current_timestamp() ON UPDATE current_timestamp()
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Volcado de datos para la tabla `tickets`
--

INSERT INTO `tickets` (`id`, `usuario_id`, `tipo_solicitud_id`, `titulo`, `descripcion`, `estado_ticket_id`, `creado_en`, `actualizado_en`) VALUES
(1, 1, 1, 'Solicitud de herramienta', 'El usuario solicita un taladro para una reparación menor.', 1, '2025-09-04 04:42:59', '2025-09-04 04:42:59'),
(2, 2, 2, 'Reporte de ruido', 'Vecinos reportan ruido fuerte en la torre 2.', 1, '2025-09-04 04:42:59', '2025-09-04 04:42:59'),
(3, 3, 3, 'Aviso de mascota perdida', 'Se perdió un gato en la torre 1, último visto en el parque.', 2, '2025-09-04 04:42:59', '2025-09-04 04:42:59'),
(4, 4, 4, 'Coordinación de feria', 'Propuesta para realizar una feria de comidas el fin de semana.', 1, '2025-09-04 04:42:59', '2025-09-04 04:42:59'),
(5, 5, 1, 'Solicitud de ayuda', 'El usuario necesita ayuda para subir cajas desde su auto.', 2, '2025-09-04 04:42:59', '2025-09-04 04:42:59'),
(6, 6, 2, 'Reporte de incidente leve', 'Niños jugando fútbol en pasillos causando molestias.', 1, '2025-09-04 04:42:59', '2025-09-04 04:42:59'),
(7, 7, 3, 'Aviso de reunión', 'Convocatoria a reunión del consorcio el viernes.', 3, '2025-09-04 04:42:59', '2025-09-04 04:42:59'),
(8, 8, 1, 'Cuidado de plantas', 'El usuario solicita apoyo para cuidar plantas durante un viaje.', 1, '2025-09-04 04:42:59', '2025-09-04 04:42:59'),
(9, 9, 4, 'Coordinación compras comunitarias', 'Organizar compras de víveres al por mayor.', 2, '2025-09-04 04:42:59', '2025-09-04 04:42:59'),
(10, 10, 2, 'Reporte de fuga de agua', 'Fuga en el baño comunal de la torre 3.', 1, '2025-09-04 04:42:59', '2025-09-04 04:42:59'),
(11, 11, 1, 'Solicitud de apoyo', 'Ayuda para mover un mueble pesado.', 3, '2025-09-04 04:42:59', '2025-09-04 04:42:59'),
(12, 12, 3, 'Aviso de asamblea', 'Aviso de asamblea general el próximo mes.', 1, '2025-09-04 04:42:59', '2025-09-04 04:42:59'),
(13, 13, 4, 'Evento comunitario', 'Organizar torneo de fútbol entre residentes.', 2, '2025-09-04 04:42:59', '2025-09-04 04:42:59'),
(14, 14, 2, 'Reporte de luces dañadas', 'Luces del parque no funcionan en la noche.', 1, '2025-09-04 04:42:59', '2025-09-04 04:42:59'),
(15, 15, 1, 'Cuidado de mascota', 'Solicita apoyo para cuidar perro durante 3 días.', 1, '2025-09-04 04:42:59', '2025-09-04 04:42:59');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `tipo_solicitud`
--

CREATE TABLE `tipo_solicitud` (
  `id` int(11) NOT NULL,
  `nombre` varchar(50) NOT NULL,
  `creado_en` timestamp NOT NULL DEFAULT current_timestamp(),
  `actualizado_en` timestamp NOT NULL DEFAULT current_timestamp() ON UPDATE current_timestamp()
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Volcado de datos para la tabla `tipo_solicitud`
--

INSERT INTO `tipo_solicitud` (`id`, `nombre`, `creado_en`, `actualizado_en`) VALUES
(1, 'SOLICITUDES', '2025-09-04 04:36:58', '2025-09-04 04:36:58'),
(2, 'REPORTES', '2025-09-04 04:36:58', '2025-09-04 04:36:58'),
(3, 'AVISOS', '2025-09-04 04:36:58', '2025-09-04 04:36:58'),
(4, 'COORDINACION EVENTOS COMUNITARIOS', '2025-09-04 04:36:58', '2025-09-04 04:36:58');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `torre`
--

CREATE TABLE `torre` (
  `id` int(11) NOT NULL,
  `nombre` varchar(50) NOT NULL,
  `creado_en` timestamp NOT NULL DEFAULT current_timestamp(),
  `actualizado_en` timestamp NOT NULL DEFAULT current_timestamp() ON UPDATE current_timestamp()
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Volcado de datos para la tabla `torre`
--

INSERT INTO `torre` (`id`, `nombre`, `creado_en`, `actualizado_en`) VALUES
(1, 'TORRE A ', '2025-09-04 04:00:45', '2025-09-04 04:00:45'),
(2, 'TORRE B', '2025-09-04 04:00:45', '2025-09-04 04:00:45'),
(3, 'TORRE C', '2025-09-04 04:01:39', '2025-09-04 04:01:39'),
(4, 'TORRE D', '2025-09-04 04:01:39', '2025-09-04 04:01:39'),
(5, 'TORRE E', '2025-09-04 04:01:39', '2025-09-04 04:01:39'),
(6, 'TORRE F', '2025-09-04 04:01:39', '2025-09-04 04:01:39'),
(7, 'TORRE G', '2025-09-04 04:01:39', '2025-09-04 04:01:39'),
(8, 'TORRE H', '2025-09-04 04:01:39', '2025-09-04 04:01:39');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `usuario`
--

CREATE TABLE `usuario` (
  `id` int(11) NOT NULL,
  `nombres` varchar(50) NOT NULL,
  `apellidos` varchar(50) NOT NULL,
  `torre_id` int(10) NOT NULL,
  `correo` varchar(50) NOT NULL,
  `contraseña` varchar(50) NOT NULL,
  `creado_en` timestamp NOT NULL DEFAULT current_timestamp(),
  `actualizado_en` timestamp NOT NULL DEFAULT current_timestamp() ON UPDATE current_timestamp()
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Volcado de datos para la tabla `usuario`
--

INSERT INTO `usuario` (`id`, `nombres`, `apellidos`, `torre_id`, `correo`, `contraseña`, `creado_en`, `actualizado_en`) VALUES
(1, 'Juan Carlos', 'Cardenas Ortiz', 1, 'JuanCardenas@gmail.com', '12345678', '2025-09-04 04:13:47', '2025-09-04 04:13:47'),
(2, 'Juan Carlos', 'Pérez Gómez', 1, 'juanperez@gmail.com', '12345678', '2025-09-04 04:32:48', '2025-09-04 04:32:48'),
(3, 'María Fernanda', 'López Rodríguez', 2, 'marialopez@gmail.com', '12345678', '2025-09-04 04:32:48', '2025-09-04 04:32:48'),
(4, 'Luis Alberto', 'Martínez Torres', 3, 'luismartinez@gmail.com', '12345678', '2025-09-04 04:32:48', '2025-09-04 04:32:48'),
(5, 'Ana Sofía', 'Ramírez Sánchez', 4, 'anaramirez@gmail.com', '12345678', '2025-09-04 04:32:48', '2025-09-04 04:32:48'),
(6, 'Pedro José', 'Hernández Castro', 5, 'pedrohernandez@gmail.com', '12345678', '2025-09-04 04:32:48', '2025-09-04 04:32:48'),
(7, 'Laura Beatriz', 'García Morales', 6, 'lauragarcia@gmail.com', '12345678', '2025-09-04 04:32:48', '2025-09-04 04:32:48'),
(8, 'Carlos Andrés', 'Torres Mejía', 7, 'carlostorres@gmail.com', '12345678', '2025-09-04 04:32:48', '2025-09-04 04:32:48'),
(9, 'Diana Carolina', 'Mendoza Ríos', 8, 'dianamendoza@gmail.com', '12345678', '2025-09-04 04:32:48', '2025-09-04 04:32:48'),
(10, 'Felipe Antonio', 'Suárez Vargas', 1, 'felipesuarez@gmail.com', '12345678', '2025-09-04 04:32:48', '2025-09-04 04:32:48'),
(11, 'Sofía Juliana', 'Cárdenas Pardo', 2, 'sofiacardenas@gmail.com', '12345678', '2025-09-04 04:32:48', '2025-09-04 04:32:48'),
(12, 'Jorge Enrique', 'Reyes Duarte', 3, 'jorgereyes@gmail.com', '12345678', '2025-09-04 04:32:48', '2025-09-04 04:32:48'),
(13, 'Paula Andrea', 'Moreno Silva', 4, 'paulamoreno@gmail.com', '12345678', '2025-09-04 04:32:48', '2025-09-04 04:32:48'),
(14, 'Andrés Felipe', 'Rojas León', 5, 'andresrojas@gmail.com', '12345678', '2025-09-04 04:32:48', '2025-09-04 04:32:48'),
(15, 'Claudia Patricia', 'Ortiz Campos', 6, 'claudiaortiz@gmail.com', '12345678', '2025-09-04 04:32:48', '2025-09-04 04:32:48'),
(16, 'Mateo Alejandro', 'Gómez Ruiz', 7, 'mateogomez@gmail.com', '12345678', '2025-09-04 04:32:48', '2025-09-04 04:32:48'),
(17, 'Valentina Isabel', 'Cruz Peña', 8, 'valentinacruz@gmail.com', '12345678', '2025-09-04 04:32:48', '2025-09-04 04:32:48'),
(18, 'Camilo Esteban', 'Salazar Gil', 1, 'camilosalazar@gmail.com', '12345678', '2025-09-04 04:32:48', '2025-09-04 04:32:48'),
(19, 'Natalia Eugenia', 'Vargas Pinto', 2, 'nataliavargas@gmail.com', '12345678', '2025-09-04 04:32:48', '2025-09-04 04:32:48'),
(20, 'Ricardo José', 'Mejía Lara', 3, 'ricardomejia@gmail.com', '12345678', '2025-09-04 04:32:48', '2025-09-04 04:32:48'),
(21, 'Carolina Alejandra', 'Figueroa Beltrán', 4, 'carolinafigueroa@gmail.com', '12345678', '2025-09-04 04:32:48', '2025-09-04 04:32:48'),
(22, 'Gabriel Eduardo', 'Ramírez Parra', 5, 'gabrielramirez@gmail.com', '12345678', '2025-09-04 04:32:48', '2025-09-04 04:32:48'),
(23, 'Juliana Marcela', 'Luna Castaño', 6, 'julianaluna@gmail.com', '12345678', '2025-09-04 04:32:48', '2025-09-04 04:32:48'),
(24, 'Esteban Mauricio', 'Rivera Guzmán', 7, 'estebanrivera@gmail.com', '12345678', '2025-09-04 04:32:48', '2025-09-04 04:32:48'),
(25, 'Camila Fernanda', 'Pardo Quiroz', 8, 'camilapardo@gmail.com', '12345678', '2025-09-04 04:32:48', '2025-09-04 04:32:48'),
(26, 'Samuel Andrés', 'Díaz Torres', 1, 'samueldiaz@gmail.com', '12345678', '2025-09-04 04:32:48', '2025-09-04 04:32:48'),
(27, 'Daniela Sofía', 'Peña Cifuentes', 2, 'danielapena@gmail.com', '12345678', '2025-09-04 04:32:48', '2025-09-04 04:32:48'),
(28, 'Miguel Ángel', 'Castro Vera', 3, 'miguelcastro@gmail.com', '12345678', '2025-09-04 04:32:48', '2025-09-04 04:32:48'),
(29, 'Isabella María', 'Santos Hoyos', 4, 'isabellasantos@gmail.com', '12345678', '2025-09-04 04:32:48', '2025-09-04 04:32:48'),
(30, 'Tomás Eduardo', 'Nieto Ávila', 5, 'tomasnieto@gmail.com', '12345678', '2025-09-04 04:32:48', '2025-09-04 04:32:48'),
(31, 'Sara Lucía', 'Prieto Bonilla', 6, 'saraprieto@gmail.com', '12345678', '2025-09-04 04:32:48', '2025-09-04 04:32:48');

--
-- Índices para tablas volcadas
--

--
-- Indices de la tabla `estado_ticket`
--
ALTER TABLE `estado_ticket`
  ADD PRIMARY KEY (`id`),
  ADD UNIQUE KEY `nombre` (`nombre`);

--
-- Indices de la tabla `notificacion`
--
ALTER TABLE `notificacion`
  ADD PRIMARY KEY (`id`),
  ADD KEY `usuario_id` (`usuario_id`),
  ADD KEY `ticket_id` (`ticket_id`);

--
-- Indices de la tabla `tickets`
--
ALTER TABLE `tickets`
  ADD PRIMARY KEY (`id`),
  ADD KEY `usuario_id` (`usuario_id`),
  ADD KEY `tipo_solicitud_id` (`tipo_solicitud_id`),
  ADD KEY `estado_ticket_id` (`estado_ticket_id`);

--
-- Indices de la tabla `tipo_solicitud`
--
ALTER TABLE `tipo_solicitud`
  ADD PRIMARY KEY (`id`),
  ADD UNIQUE KEY `nombre` (`nombre`);

--
-- Indices de la tabla `torre`
--
ALTER TABLE `torre`
  ADD PRIMARY KEY (`id`);

--
-- Indices de la tabla `usuario`
--
ALTER TABLE `usuario`
  ADD PRIMARY KEY (`id`),
  ADD UNIQUE KEY `correo` (`correo`),
  ADD KEY `torre_id` (`torre_id`);

--
-- AUTO_INCREMENT de las tablas volcadas
--

--
-- AUTO_INCREMENT de la tabla `estado_ticket`
--
ALTER TABLE `estado_ticket`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=5;

--
-- AUTO_INCREMENT de la tabla `notificacion`
--
ALTER TABLE `notificacion`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT de la tabla `tickets`
--
ALTER TABLE `tickets`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=16;

--
-- AUTO_INCREMENT de la tabla `tipo_solicitud`
--
ALTER TABLE `tipo_solicitud`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=5;

--
-- AUTO_INCREMENT de la tabla `torre`
--
ALTER TABLE `torre`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=9;

--
-- AUTO_INCREMENT de la tabla `usuario`
--
ALTER TABLE `usuario`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=32;

--
-- Restricciones para tablas volcadas
--

--
-- Filtros para la tabla `notificacion`
--
ALTER TABLE `notificacion`
  ADD CONSTRAINT `notificacion_ibfk_1` FOREIGN KEY (`usuario_id`) REFERENCES `usuario` (`id`),
  ADD CONSTRAINT `notificacion_ibfk_2` FOREIGN KEY (`ticket_id`) REFERENCES `tickets` (`id`);

--
-- Filtros para la tabla `tickets`
--
ALTER TABLE `tickets`
  ADD CONSTRAINT `tickets_ibfk_1` FOREIGN KEY (`usuario_id`) REFERENCES `usuario` (`id`),
  ADD CONSTRAINT `tickets_ibfk_2` FOREIGN KEY (`tipo_solicitud_id`) REFERENCES `tipo_solicitud` (`id`),
  ADD CONSTRAINT `tickets_ibfk_3` FOREIGN KEY (`estado_ticket_id`) REFERENCES `estado_ticket` (`id`);

--
-- Filtros para la tabla `usuario`
--
ALTER TABLE `usuario`
  ADD CONSTRAINT `torre_id` FOREIGN KEY (`torre_id`) REFERENCES `torre` (`id`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
