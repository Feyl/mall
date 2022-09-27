/*
 Navicat Premium Data Transfer

 Source Server         : 127.0.0.1
 Source Server Type    : MySQL
 Source Server Version : 80023
 Source Host           : localhost:3306
 Source Schema         : mall

 Target Server Type    : MySQL
 Target Server Version : 80023
 File Encoding         : 65001

 Date: 27/09/2022 10:31:47
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for accessory
-- ----------------------------
DROP TABLE IF EXISTS `accessory`;
CREATE TABLE `accessory`  (
  `id` bigint UNSIGNED NOT NULL AUTO_INCREMENT COMMENT '附属商品ID',
  `name` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL COMMENT '名称',
  `price` decimal(10, 2) UNSIGNED NULL DEFAULT NULL COMMENT '价格',
  `product_id` bigint UNSIGNED NULL DEFAULT NULL COMMENT '商品表商品ID',
  `is_deleted` tinyint UNSIGNED NULL DEFAULT NULL COMMENT '逻辑删除：0不删除/1删除',
  `create_time` datetime NULL DEFAULT NULL COMMENT '创建时间',
  `update_time` datetime NULL DEFAULT NULL COMMENT '更新时间',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 13 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci COMMENT = '附加商品表' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of accessory
-- ----------------------------
INSERT INTO `accessory` VALUES (1, '包装盒', 1.00, 1, 0, '2021-11-07 10:32:46', NULL);
INSERT INTO `accessory` VALUES (2, '纸板盒', 3.00, 1, 0, '2021-11-07 10:32:48', NULL);
INSERT INTO `accessory` VALUES (3, '捆绳', 1.00, 1, 0, '2021-11-07 10:32:51', NULL);
INSERT INTO `accessory` VALUES (4, '塑料袋', 0.50, 1, 0, '2021-11-07 10:33:04', NULL);
INSERT INTO `accessory` VALUES (5, '包装盒', 1.00, 2, 0, '2021-11-07 10:33:38', '2021-11-07 10:33:50');
INSERT INTO `accessory` VALUES (6, '纸板盒', 3.00, 2, 0, '2021-11-07 10:34:34', NULL);
INSERT INTO `accessory` VALUES (7, '捆绳', 1.50, 15, 0, '2021-11-07 17:40:21', NULL);
INSERT INTO `accessory` VALUES (8, '纸板盒', 3.00, 15, 0, '2021-11-07 17:40:21', NULL);
INSERT INTO `accessory` VALUES (9, '纸板盒', 3.00, 16, 0, '2021-11-07 18:23:58', NULL);
INSERT INTO `accessory` VALUES (10, '纸板盒', 3.00, 17, 0, '2021-11-07 18:31:05', NULL);
INSERT INTO `accessory` VALUES (11, '捆绳', 1.00, 17, 0, '2021-11-07 18:31:05', NULL);
INSERT INTO `accessory` VALUES (12, '纸板盒', 3.00, 18, 0, '2021-11-08 15:28:29', NULL);
INSERT INTO `accessory` VALUES (13, '捆绳', 1.00, 18, 0, '2021-11-08 15:28:29', NULL);

-- ----------------------------
-- Table structure for contract
-- ----------------------------
DROP TABLE IF EXISTS `contract`;
CREATE TABLE `contract`  (
  `id` bigint UNSIGNED NOT NULL AUTO_INCREMENT COMMENT '合同ID',
  `barcode` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL COMMENT '合同号',
  `type` tinyint UNSIGNED NULL DEFAULT NULL COMMENT '0：省内/1：省外',
  `retailer_id` bigint UNSIGNED NULL DEFAULT NULL COMMENT '零售商表零售商ID',
  `product_money` decimal(10, 2) UNSIGNED NULL DEFAULT NULL COMMENT '商品金额',
  `transport_way` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL COMMENT '配送方式',
  `transport_number` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL COMMENT '物流单号',
  `transport_expense` decimal(10, 2) UNSIGNED NULL DEFAULT NULL COMMENT '运费',
  `payment` tinyint UNSIGNED NULL DEFAULT NULL COMMENT '支付方式：0未支付/1微信支付/2支付宝',
  `status` tinyint NULL DEFAULT NULL COMMENT '订单状态：0待付款/1待发货/2已发货/3待收货/4已完成/5已关闭',
  `remark` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL COMMENT '备注信息',
  `is_deleted` tinyint UNSIGNED NULL DEFAULT NULL COMMENT '逻辑删除：0不删除/1删除',
  `create_time` datetime NULL DEFAULT NULL COMMENT '创建时间',
  `update_time` datetime NULL DEFAULT NULL COMMENT '更新时间',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci COMMENT = '合同表' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of contract
-- ----------------------------

-- ----------------------------
-- Table structure for contract_product
-- ----------------------------
DROP TABLE IF EXISTS `contract_product`;
CREATE TABLE `contract_product`  (
  `id` bigint UNSIGNED NOT NULL AUTO_INCREMENT COMMENT '合同商品关联ID',
  `contract_id` bigint UNSIGNED NULL DEFAULT NULL COMMENT '合同表合同ID',
  `product_id` bigint UNSIGNED NULL DEFAULT NULL COMMENT '商品表商品ID',
  `product_number` int UNSIGNED NULL DEFAULT NULL COMMENT '商品数量',
  `is_deleted` tinyint UNSIGNED NULL DEFAULT NULL COMMENT '逻辑删除：0不删除/1删除',
  `create_time` datetime NULL DEFAULT NULL COMMENT '创建时间',
  `update_time` datetime NULL DEFAULT NULL COMMENT '更新时间',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci COMMENT = '合同商品关系表' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of contract_product
-- ----------------------------

-- ----------------------------
-- Table structure for product
-- ----------------------------
DROP TABLE IF EXISTS `product`;
CREATE TABLE `product`  (
  `id` bigint UNSIGNED NOT NULL AUTO_INCREMENT COMMENT '商品ID',
  `name` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL COMMENT '名称',
  `image` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL COMMENT '图片地址',
  `price` decimal(10, 2) UNSIGNED NULL DEFAULT NULL COMMENT '价格',
  `locality` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL COMMENT '产地',
  `status` tinyint UNSIGNED NULL DEFAULT NULL COMMENT '是否上架：0上架/1下架',
  `is_deleted` tinyint UNSIGNED NULL DEFAULT NULL COMMENT '逻辑删除：0不删除/1删除',
  `create_time` datetime NULL DEFAULT NULL COMMENT '创建时间',
  `update_time` datetime NULL DEFAULT NULL COMMENT '更新时间',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 18 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci COMMENT = '商品表' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of product
-- ----------------------------
INSERT INTO `product` VALUES (1, '黄桃', 'https://fuss10.elemecdn.com/e/5d/4a731a90594a4af544c0c25941171jpeg.jpeg', 2.50, '浙江省金华区', 0, 0, '2021-11-07 10:35:41', '2021-11-10 07:38:19');
INSERT INTO `product` VALUES (2, '火龙果', 'https://fuss10.elemecdn.com/e/5d/4a731a90594a4af544c0c25941171jpeg.jpeg', 6.68, '浙江省绍兴市', 0, 0, '2021-11-07 10:36:15', '2021-11-09 17:36:48');
INSERT INTO `product` VALUES (3, '橙子', 'https://fuss10.elemecdn.com/e/5d/4a731a90594a4af544c0c25941171jpeg.jpeg', 0.40, '江苏省南京市', 0, 0, '2021-11-07 10:36:45', '2021-11-09 17:36:46');
INSERT INTO `product` VALUES (4, '柚子', 'https://fuss10.elemecdn.com/e/5d/4a731a90594a4af544c0c25941171jpeg.jpeg', 0.50, '上海市金山区', 0, 0, '2021-11-07 10:41:55', '2021-11-09 17:36:46');
INSERT INTO `product` VALUES (5, '猕猴桃', 'https://fuss10.elemecdn.com/e/5d/4a731a90594a4af544c0c25941171jpeg.jpeg', 2.20, '上海市嘉定区', 0, 0, '2021-11-07 10:41:58', '2021-11-09 17:36:46');
INSERT INTO `product` VALUES (6, '苹果', 'https://fuss10.elemecdn.com/e/5d/4a731a90594a4af544c0c25941171jpeg.jpeg', 0.70, '山东省青岛市', 0, 0, '2021-11-07 10:42:00', '2021-11-09 17:36:44');
INSERT INTO `product` VALUES (7, '橘子', 'https://fuss10.elemecdn.com/e/5d/4a731a90594a4af544c0c25941171jpeg.jpeg', 1.60, '上海市普陀区', 0, 0, '2021-11-07 10:42:05', '2021-11-09 17:36:43');
INSERT INTO `product` VALUES (8, '香蕉', 'https://fuss10.elemecdn.com/e/5d/4a731a90594a4af544c0c25941171jpeg.jpeg', 1.30, '江苏省昆山市', 0, 0, '2021-11-07 10:42:07', '2021-11-09 17:36:42');
INSERT INTO `product` VALUES (9, '柿子', 'https://fuss10.elemecdn.com/e/5d/4a731a90594a4af544c0c25941171jpeg.jpeg', 0.50, '江苏省苏州市', 0, 0, '2021-11-08 10:42:09', '2021-11-09 17:36:42');
INSERT INTO `product` VALUES (10, '榴莲', 'https://fuss10.elemecdn.com/e/5d/4a731a90594a4af544c0c25941171jpeg.jpeg', 13.00, '江苏省盐城县', 0, 0, '2021-11-08 10:42:12', '2021-11-09 17:36:41');
INSERT INTO `product` VALUES (11, '葡萄', 'https://fuss10.elemecdn.com/e/5d/4a731a90594a4af544c0c25941171jpeg.jpeg', 2.30, '上海市马陆镇', 0, 0, '2021-11-07 10:42:15', '2021-11-09 17:36:56');
INSERT INTO `product` VALUES (12, '荔枝', 'https://fuss10.elemecdn.com/e/5d/4a731a90594a4af544c0c25941171jpeg.jpeg', 1.80, '江苏省无锡市', 0, 0, '2021-11-07 10:42:18', '2021-11-09 17:36:56');
INSERT INTO `product` VALUES (13, '西瓜', 'https://fuss10.elemecdn.com/e/5d/4a731a90594a4af544c0c25941171jpeg.jpeg', 0.30, '江苏省常州市', 0, 0, '2021-11-07 10:42:20', '2021-11-09 17:36:58');
INSERT INTO `product` VALUES (14, '芒果', 'https://fuss10.elemecdn.com/e/5d/4a731a90594a4af544c0c25941171jpeg.jpeg', 3.60, '浙江省杭州市', 0, 0, '2021-11-07 10:42:23', '2021-11-09 17:36:58');
INSERT INTO `product` VALUES (15, '蛇果', 'https://fuss10.elemecdn.com/e/5d/4a731a90594a4af544c0c25941171jpeg.jpeg', 5.00, '四川省成都市', 0, 0, '2021-11-07 17:40:21', '2021-11-09 17:36:59');
INSERT INTO `product` VALUES (16, '荔枝', 'https://fuss10.elemecdn.com/e/5d/4a731a90594a4af544c0c25941171jpeg.jpeg', 6.00, '河南省郑州市', 0, 0, '2021-11-07 18:23:57', '2021-11-10 07:59:41');
INSERT INTO `product` VALUES (17, '柠檬', 'https://fuss10.elemecdn.com/e/5d/4a731a90594a4af544c0c25941171jpeg.jpeg', 2.00, '广西省桂林市', 0, 0, '2021-11-08 18:31:05', '2021-11-09 17:37:01');
INSERT INTO `product` VALUES (18, '红柚', 'https://fuss10.elemecdn.com/e/5d/4a731a90594a4af544c0c25941171jpeg.jpeg', 6.00, '重庆市梁平区', 0, 0, '2021-11-08 15:28:28', '2021-11-09 16:54:29');

-- ----------------------------
-- Table structure for retailer
-- ----------------------------
DROP TABLE IF EXISTS `retailer`;
CREATE TABLE `retailer`  (
  `id` bigint UNSIGNED NOT NULL AUTO_INCREMENT COMMENT '零售商ID',
  `name` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL COMMENT '姓名',
  `telephone` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL COMMENT '电话号码',
  `postal_code` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL COMMENT '邮政编码',
  `address` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL COMMENT '地址',
  `status` tinyint UNSIGNED NULL DEFAULT NULL COMMENT '状态：0启用/1禁用',
  `is_deleted` tinyint UNSIGNED NULL DEFAULT NULL COMMENT '逻辑删除：0不删除/1删除',
  `create_time` datetime NULL DEFAULT NULL COMMENT '创建时间',
  `update_time` datetime NULL DEFAULT NULL COMMENT '更新时间',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 14 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci COMMENT = '零售商表' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of retailer
-- ----------------------------
INSERT INTO `retailer` VALUES (1, '刘成成', '13515354893', '200120', '上海市黄浦区', 0, 0, '2021-11-07 10:44:40', '2021-11-09 17:37:44');
INSERT INTO `retailer` VALUES (2, '石恩华', '13779851246', '200121', '上海市普陀区', 1, 0, '2021-11-07 10:45:26', '2021-11-10 10:53:02');
INSERT INTO `retailer` VALUES (3, '蒋虎子', '13896548321', '200129', '上海市嘉定区', 0, 0, '2021-11-07 10:46:06', '2021-11-09 17:37:45');
INSERT INTO `retailer` VALUES (4, '胡晓丽', '15235486124', '200125', '上海市闵行区', 0, 0, '2021-11-07 10:47:01', NULL);
INSERT INTO `retailer` VALUES (5, '蒋俊佳', '13648121547', '200115', '上海市宝山区', 1, 0, '2021-11-07 10:47:46', '2021-11-10 10:52:56');
INSERT INTO `retailer` VALUES (6, '施俊杰', '13483451857', '200130', '上海市徐汇区', 1, 0, '2021-11-07 10:48:22', '2021-11-10 10:52:58');
INSERT INTO `retailer` VALUES (7, '钱晓晓', '15534847315', '200145', '上海市长宁区', 1, 0, '2021-11-07 10:51:40', '2021-11-10 10:52:59');
INSERT INTO `retailer` VALUES (8, '任宇', '13244818354', '200134', '上海市虹口区', 0, 0, '2021-11-07 10:51:48', NULL);
INSERT INTO `retailer` VALUES (9, '周佳', '15638491452', '200131', '上海市金山区', 0, 0, '2021-11-07 10:51:50', NULL);
INSERT INTO `retailer` VALUES (10, '张晓冉', '15535487913', '200133', '上海市奉贤区', 0, 0, '2021-11-07 10:51:53', NULL);
INSERT INTO `retailer` VALUES (11, '牛夏利', '13348118124', '200122', '上海市松江区', 0, 0, '2021-11-07 10:51:55', '2021-11-08 15:22:47');
INSERT INTO `retailer` VALUES (12, '刘浩', '13186867561', '200126', '上海市青浦区', 0, 0, '2021-11-07 10:51:57', NULL);
INSERT INTO `retailer` VALUES (13, '小零售商', '15988886666', NULL, '重庆市渝北区', 0, 0, '2021-11-10 19:05:45', NULL);
INSERT INTO `retailer` VALUES (14, '大零售商', '15966668888', NULL, '重庆市渝北区', 0, 0, '2021-11-10 19:07:19', NULL);

-- ----------------------------
-- Table structure for sys_permission
-- ----------------------------
DROP TABLE IF EXISTS `sys_permission`;
CREATE TABLE `sys_permission`  (
  `id` bigint UNSIGNED NOT NULL AUTO_INCREMENT COMMENT '权限ID',
  `name` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL COMMENT '权限名称',
  `permisson_value` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL COMMENT '权限值',
  `is_deleted` tinyint UNSIGNED NULL DEFAULT NULL COMMENT '逻辑删除：0不删除/1删除',
  `create_time` datetime NULL DEFAULT NULL COMMENT '创建时间',
  `update_time` datetime NULL DEFAULT NULL COMMENT '更新时间',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 1 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of sys_permission
-- ----------------------------
INSERT INTO `sys_permission` VALUES (1, '', '', NULL, NULL, NULL);

-- ----------------------------
-- Table structure for sys_role
-- ----------------------------
DROP TABLE IF EXISTS `sys_role`;
CREATE TABLE `sys_role`  (
  `id` bigint UNSIGNED NOT NULL AUTO_INCREMENT COMMENT '角色ID',
  `name` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL COMMENT '角色名称',
  `is_deleted` tinyint UNSIGNED NULL DEFAULT NULL COMMENT '逻辑删除：0不删除/1删除',
  `create_time` datetime NULL DEFAULT NULL COMMENT '创建时间',
  `update_time` datetime NULL DEFAULT NULL COMMENT '更新时间',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci COMMENT = '角色表' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of sys_role
-- ----------------------------
INSERT INTO `sys_role` VALUES (0, 'Administrator', 0, '2021-11-01 08:46:40', '2021-11-01 08:46:43');
INSERT INTO `sys_role` VALUES (1, 'MerchandiseManager', 0, '2021-11-01 08:45:54', '2021-11-01 08:45:59');
INSERT INTO `sys_role` VALUES (2, 'Retailer', 0, '2021-11-01 08:46:20', '2021-11-01 08:46:24');

-- ----------------------------
-- Table structure for sys_role_permission
-- ----------------------------
DROP TABLE IF EXISTS `sys_role_permission`;
CREATE TABLE `sys_role_permission`  (
  `id` bigint UNSIGNED NOT NULL AUTO_INCREMENT COMMENT '角色权限关联ID',
  `role_id` bigint UNSIGNED NULL DEFAULT NULL COMMENT '角色ID',
  `permission_id` bigint UNSIGNED NULL DEFAULT NULL COMMENT '权限ID',
  `is_deleted` tinyint UNSIGNED NULL DEFAULT NULL COMMENT '逻辑删除：0不删除/1删除',
  `create_time` datetime NULL DEFAULT NULL COMMENT '创建时间',
  `update_time` datetime NULL DEFAULT NULL COMMENT '更新时间',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci COMMENT = '角色权限关联表' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of sys_role_permission
-- ----------------------------

-- ----------------------------
-- Table structure for sys_user
-- ----------------------------
DROP TABLE IF EXISTS `sys_user`;
CREATE TABLE `sys_user`  (
  `id` bigint UNSIGNED NOT NULL AUTO_INCREMENT COMMENT '用户ID',
  `username` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL COMMENT '用户名',
  `password` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL COMMENT '密码',
  `avatar` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL COMMENT '头像',
  `name` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL COMMENT '姓名',
  `telephone` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL COMMENT '电话号码',
  `is_deleted` tinyint UNSIGNED NULL DEFAULT NULL COMMENT '逻辑删除：0不删除/1删除',
  `create_time` datetime NULL DEFAULT NULL COMMENT '创建时间',
  `update_time` datetime NULL DEFAULT NULL COMMENT '更新时间',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 14 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci COMMENT = '用户表' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of sys_user
-- ----------------------------
INSERT INTO `sys_user` VALUES (13, 'anonymous', '$2a$10$9wbLC6mGXjwln3CDnw8ICusNn.e9PtAG5O9dgoCshzam8p2fKtuaS', NULL, 'flow', '15998960683', 0, '2021-11-06 23:47:41', NULL);
INSERT INTO `sys_user` VALUES (14, 'flow', '$2a$10$hx7JPmv/h/11bPfEZMe0UeYuxqk3NgtTXR8b7rBYiDAASD/aCdqbq', NULL, 'flow', '15998960683', 0, '2021-11-07 00:41:42', NULL);

-- ----------------------------
-- Table structure for sys_user_role
-- ----------------------------
DROP TABLE IF EXISTS `sys_user_role`;
CREATE TABLE `sys_user_role`  (
  `id` bigint UNSIGNED NOT NULL AUTO_INCREMENT COMMENT '用户角色关联ID',
  `user_id` bigint UNSIGNED NULL DEFAULT NULL COMMENT '用户ID',
  `role_id` bigint UNSIGNED NULL DEFAULT NULL COMMENT '角色ID',
  `is_deleted` tinyint UNSIGNED NULL DEFAULT NULL COMMENT '逻辑删除：0不删除/1删除',
  `create_time` datetime NULL DEFAULT NULL COMMENT '创建时间',
  `update_time` datetime NULL DEFAULT NULL COMMENT '更新时间',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 6 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci COMMENT = '用户角色关联表' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of sys_user_role
-- ----------------------------
INSERT INTO `sys_user_role` VALUES (1, 9, 0, 0, '2021-11-06 21:44:17', NULL);
INSERT INTO `sys_user_role` VALUES (2, 10, 0, 0, '2021-11-06 23:43:30', NULL);
INSERT INTO `sys_user_role` VALUES (3, 11, 0, 0, '2021-11-06 23:44:25', NULL);
INSERT INTO `sys_user_role` VALUES (4, 12, 0, 0, '2021-11-06 23:44:50', NULL);
INSERT INTO `sys_user_role` VALUES (5, 13, 0, 0, '2021-11-06 23:47:41', NULL);
INSERT INTO `sys_user_role` VALUES (6, 14, 0, 0, '2021-11-07 00:41:42', NULL);

SET FOREIGN_KEY_CHECKS = 1;
