CREATE TABLE `user_info` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `user_id` bigint(20) NOT NULL DEFAULT '0' COMMENT '�û�Id',
  `phone` varchar(12) NOT NULL COMMENT '�ֻ���',
  `nick_name` varchar(50) NOT NULL COMMENT '�ǳ�',
  `password` varchar(50) NOT NULL COMMENT '��¼����',
  `address_id` bigint(20) DEFAULT NULL COMMENT '�ջ���ַid(���ջ���ַ)',
  `is_vip` tinyint(2) DEFAULT '0' COMMENT '�Ƿ��Ա   0 �� 1 ��',
  `vip_discount` int(5) DEFAULT NULL COMMENT '�ۿ۰ٷ���  ��',
  `photo_url` varchar(100) DEFAULT NULL COMMENT 'ͷ���ַ',
  `vip_time` datetime DEFAULT NULL COMMENT '��Ϊvip��ʱ��',
  `create_time` datetime DEFAULT NULL COMMENT '����ʱ��',
  `update_time` datetime DEFAULT NULL COMMENT '�޸�ʱ��',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COMMENT='�û���';




CREATE TABLE `goods_info` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '��ƷId',
  `goods_name` varchar(100) NOT NULL COMMENT '��Ʒ����',
  `goods_img` varchar(100) DEFAULT NULL COMMENT '��ƷͼƬ',
  `price` int(10) DEFAULT NULL COMMENT '��Ʒ�۸񣬵�λΪ��',
  `discount` int(10) DEFAULT NULL COMMENT '�ۿ�',
  `goods_detail` varchar(1000) DEFAULT NULL COMMENT '��Ʒ����',
  `goods_num` int(10) DEFAULT NULL COMMENT '��Ʒ����',
  `state` tinyint(2) DEFAULT NULL COMMENT '״̬  0 ɾ���� 1 �ϼܣ�2 �¼�',
  `create_time` datetime DEFAULT NULL COMMENT '����ʱ��',
  `update_time` datetime DEFAULT NULL COMMENT '�޸�ʱ��',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COMMENT='��Ʒ��Ϣ';


CREATE TABLE `goods_order` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `order_id` varchar(50) NOT NULL COMMENT '������',
  `user_id` bigint(20) NOT NULL COMMENT '�û�Id',
  `amount` int(10) DEFAULT NULL COMMENT '�۸� ��λ��',
  `ori_amount` int(10) DEFAULT NULL COMMENT 'ԭ��',
  `order_status` tinyint(2) DEFAULT NULL COMMENT '����״̬  0�����У�1 �ѽ�����ɣ�2 ��ȡ��',
  `pay_status` tinyint(2) DEFAULT NULL COMMENT '����״̬  0  δ����  1  �Ѹ���',
  `remark` varchar(100) DEFAULT NULL COMMENT '�û���ע',
  `create_time` datetime DEFAULT NULL COMMENT '����ʱ��',
  `update_time` datetime DEFAULT NULL COMMENT '�޸�ʱ��',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;




CREATE TABLE `goods_order_item` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `order_id` varchar(50) NOT NULL COMMENT '����Id',
  `order_status` tinyint(2) NOT NULL COMMENT '����״̬  1 Ϊ���ύ����  2 Ϊ��ȡ������',
  `user_id` bigint(20) NOT NULL COMMENT '�û�Id',
  `goods_id` bigint(20) NOT NULL COMMENT '��ƷId',
  `goods_num` int(10) DEFAULT NULL COMMENT '��Ʒ����',
  `goods_price` int(10) DEFAULT NULL COMMENT '��Ʒ�۸�',
  `goods_ori_price` int(10) DEFAULT NULL COMMENT '��Ʒԭ��',
  `discount` int(10) DEFAULT NULL COMMENT '��Ʒ�ۿ�',
  `address_id` bigint(20) DEFAULT NULL COMMENT '�ͻ���ַ',
  `create_time` datetime DEFAULT NULL COMMENT '����ʱ��',
  `update_time` datetime DEFAULT NULL COMMENT '����ʱ��',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COMMENT='��Ʒ�������';



-- �����û���Ʒ���ࡢ�ջ���ַ��������Ϣδ��ƣ������
