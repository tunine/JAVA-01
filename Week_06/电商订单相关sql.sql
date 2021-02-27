CREATE TABLE `user_info` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `user_id` bigint(20) NOT NULL DEFAULT '0' COMMENT '用户Id',
  `phone` varchar(12) NOT NULL COMMENT '手机号',
  `nick_name` varchar(50) NOT NULL COMMENT '昵称',
  `password` varchar(50) NOT NULL COMMENT '登录密码',
  `address_id` bigint(20) DEFAULT NULL COMMENT '收货地址id(主收货地址)',
  `is_vip` tinyint(2) DEFAULT '0' COMMENT '是否会员   0 否； 1 是',
  `vip_discount` int(5) DEFAULT NULL COMMENT '折扣百分数  ，',
  `photo_url` varchar(100) DEFAULT NULL COMMENT '头像地址',
  `vip_time` datetime DEFAULT NULL COMMENT '成为vip的时间',
  `create_time` datetime DEFAULT NULL COMMENT '创建时间',
  `update_time` datetime DEFAULT NULL COMMENT '修改时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COMMENT='用户表';




CREATE TABLE `goods_info` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '商品Id',
  `goods_name` varchar(100) NOT NULL COMMENT '商品名称',
  `goods_img` varchar(100) DEFAULT NULL COMMENT '商品图片',
  `price` int(10) DEFAULT NULL COMMENT '商品价格，单位为分',
  `discount` int(10) DEFAULT NULL COMMENT '折扣',
  `goods_detail` varchar(1000) DEFAULT NULL COMMENT '商品详情',
  `goods_num` int(10) DEFAULT NULL COMMENT '商品数量',
  `state` tinyint(2) DEFAULT NULL COMMENT '状态  0 删除； 1 上架；2 下架',
  `create_time` datetime DEFAULT NULL COMMENT '创建时间',
  `update_time` datetime DEFAULT NULL COMMENT '修改时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COMMENT='商品信息';


CREATE TABLE `goods_order` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `order_id` varchar(50) NOT NULL COMMENT '订单号',
  `user_id` bigint(20) NOT NULL COMMENT '用户Id',
  `amount` int(10) DEFAULT NULL COMMENT '价格 单位分',
  `ori_amount` int(10) DEFAULT NULL COMMENT '原价',
  `order_status` tinyint(2) DEFAULT NULL COMMENT '订单状态  0进行中，1 已交易完成；2 已取消',
  `pay_status` tinyint(2) DEFAULT NULL COMMENT '付款状态  0  未付款  1  已付款',
  `remark` varchar(100) DEFAULT NULL COMMENT '用户备注',
  `create_time` datetime DEFAULT NULL COMMENT '创建时间',
  `update_time` datetime DEFAULT NULL COMMENT '修改时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;




CREATE TABLE `goods_order_item` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `order_id` varchar(50) NOT NULL COMMENT '订单Id',
  `order_status` tinyint(2) NOT NULL COMMENT '订单状态  1 为已提交订单  2 为已取消订单',
  `user_id` bigint(20) NOT NULL COMMENT '用户Id',
  `goods_id` bigint(20) NOT NULL COMMENT '商品Id',
  `goods_num` int(10) DEFAULT NULL COMMENT '商品数量',
  `goods_price` int(10) DEFAULT NULL COMMENT '商品价格',
  `goods_ori_price` int(10) DEFAULT NULL COMMENT '商品原价',
  `discount` int(10) DEFAULT NULL COMMENT '商品折扣',
  `address_id` bigint(20) DEFAULT NULL COMMENT '送货地址',
  `create_time` datetime DEFAULT NULL COMMENT '创建时间',
  `update_time` datetime DEFAULT NULL COMMENT '更新时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COMMENT='商品订单项表';



-- 其中用户商品分类、收货地址和配送信息未设计，请忽略
