/*
 Navicat Premium Dump SQL

 Source Server         : localhost
 Source Server Type    : MySQL
 Source Server Version : 120002 (12.0.2-MariaDB)
 Source Host           : localhost:3306
 Source Schema         : inventario_eliminar

 Target Server Type    : MySQL
 Target Server Version : 120002 (12.0.2-MariaDB)
 File Encoding         : 65001

 Date: 12/03/2026 17:58:43
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for categoria
-- ----------------------------
DROP TABLE IF EXISTS `categoria`;
CREATE TABLE `categoria`  (
  `idCategoria` int NOT NULL AUTO_INCREMENT,
  `nombreCategoria` varchar(20) CHARACTER SET latin1 COLLATE latin1_swedish_ci NOT NULL,
  `descripcionCategoria` varchar(100) CHARACTER SET latin1 COLLATE latin1_swedish_ci NOT NULL,
  PRIMARY KEY (`idCategoria`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 11 CHARACTER SET = latin1 COLLATE = latin1_swedish_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of categoria
-- ----------------------------
INSERT INTO `categoria` VALUES (1, 'Musica', 'Discos de Vinilo, Albums en fisico y mucho mas!');
INSERT INTO `categoria` VALUES (2, 'Deportes', 'Aqui encontraras informacion de cualquier deporte!');
INSERT INTO `categoria` VALUES (4, 'Politica', 'Articulos actualizados de politica');
INSERT INTO `categoria` VALUES (7, 'Tecnologia', 'Productos de tecnologia');
INSERT INTO `categoria` VALUES (8, 'Bebidas', 'Refrescos y jugos');

-- ----------------------------
-- Table structure for producto
-- ----------------------------
DROP TABLE IF EXISTS `producto`;
CREATE TABLE `producto`  (
  `idProducto` int NOT NULL AUTO_INCREMENT,
  `nombreProducto` varchar(50) CHARACTER SET latin1 COLLATE latin1_swedish_ci NOT NULL,
  `descripcionProducto` varchar(100) CHARACTER SET latin1 COLLATE latin1_swedish_ci NOT NULL,
  `precioProducto` decimal(10, 2) NOT NULL,
  `existencia` int NOT NULL,
  `create_at` date NULL DEFAULT NULL,
  `idCategoria` int NOT NULL,
  PRIMARY KEY (`idProducto`) USING BTREE,
  INDEX `fk_categoria_producto_id`(`idCategoria` ASC) USING BTREE,
  CONSTRAINT `fk_categoria_producto_id` FOREIGN KEY (`idCategoria`) REFERENCES `categoria` (`idCategoria`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE = InnoDB AUTO_INCREMENT = 5 CHARACTER SET = latin1 COLLATE = latin1_swedish_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of producto
-- ----------------------------
INSERT INTO `producto` VALUES (1, 'Rust In Peace - Megadeth', 'Album de Megadeth pionero del Trash metal', 350.00, 2, '2026-03-05', 1);
INSERT INTO `producto` VALUES (2, 'Sempiternal - Bring Me The Horizon', 'Album de BMTH de metalcore', 500.00, 5, '2026-03-05', 1);
INSERT INTO `producto` VALUES (3, 'Balon de futbol', 'Balon de futbol conmemorativo del mundial 2014 Brazilia', 450.00, 6, '2026-03-05', 2);

SET FOREIGN_KEY_CHECKS = 1;
