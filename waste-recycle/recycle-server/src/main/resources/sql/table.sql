
create table order_info(
id BIGINT primary key,
user_id BIGINT not null COMMENT '下单人',
prepare_handler_id BIGINT not null COMMENT '预处理订单人',
actual_handler_id BIGINT null COMMENT '实际处理订单人',
order_state TINYINT default 0 not null COMMENT '订单状态，1_已完成的订单,失效订单;0_未完成的订单,有效订单',
order_type VARCHAR(50) not null COMMENT '订单类型,PAPER\PLASTIC\CLOTH\METAL\ELECTRIC',
weight VARCHAR(20) not null COMMENT '重量',
order_person VARCHAR(10) not null COMMENT '联系人',
order_phone VARCHAR(20) not null COMMENT '联系电话',
longitude decimal(10,7) not null COMMENT '经度',
latitude decimal(10,7) not null COMMENT '纬度',
province VARCHAR(40) not null COMMENT '省',
city VARCHAR(40) not null COMMENT '市',
country VARCHAR(40) not null COMMENT '县、区',
town VARCHAR(40) COMMENT '镇、街道',
detailed_address VARCHAR(40) not null COMMENT '详细地址',
visit_time TIMESTAMP not null COMMENT '上门时间',
message VARCHAR(300) COMMENT '留言',
created_time TIMESTAMP not null,
updated_time TIMESTAMP not null,
is_enable TINYINT default 1 not null,
INDEX (user_id),
INDEX (order_type),
INDEX (order_state),
INDEX (province,city,country)
)ENGINE = INNODB DEFAULT CHARSET = utf8;


create table user_info(
id BIGINT primary key,
openid VARCHAR(40) not null,
nick_name varchar(100) DEFAULT NULL COMMENT '用户头像',
avatar_url varchar(100) DEFAULT NULL COMMENT '用户头像',
sex tinyint(1) DEFAULT NULL COMMENT '性别  0-男、1-女',
country varchar(10) DEFAULT NULL COMMENT '所在国家',
province varchar(10) DEFAULT NULL COMMENT '省份',
city varchar(10) DEFAULT NULL COMMENT '城市',
mobile varchar(20) DEFAULT NULL COMMENT '手机号码',
created_time TIMESTAMP not null,
updated_time TIMESTAMP not null,
is_enable TINYINT default 1 not null,
INDEX (openid)
)ENGINE = INNODB DEFAULT CHARSET = utf8 COMMENT='小程序用户表';

-- 图片地址（类型很少，不需要创建索引）
create table picture_info(
id BIGINT primary key,
resource_id BIGINT not null,
resource_type varchar(10) not null comment '图片类型,ORDER',
address VARCHAR(100) not null,
created_time TIMESTAMP not null,
updated_time TIMESTAMP not null,
is_enable TINYINT default 1 not null,
INDEX (resource_id)
)ENGINE = INNODB DEFAULT CHARSET = utf8 COMMENT='图片信息表';


-- 订单处理信息表
-- create table order_deal_info(
-- id BIGINT primary key,
-- order_id BIGINT not null COMMENT '订单Id',
-- prepare_header_id BIGINT not null COMMENT '预处理订单人',
-- actual_handler_id BIGINT null COMMENT '实际处理订单人',
-- created_time TIMESTAMP not null,
-- updated_time TIMESTAMP not null,
-- is_enable TINYINT default 1 not null,
-- INDEX (order_id),
-- INDEX (prepare_header_id),
-- INDEX (actual_handler_id)
-- )ENGINE = INNODB DEFAULT CHARSET = utf8;

-- 员工信息表
create table staff_info(
id BIGINT primary key,
name varchar(10) not null,
openid varchar(40) not null,
sex VARCHAR(1) not null comment '性别',
phone VARCHAR(20) not null COMMENT '手机号码',
card VARCHAR(25) COMMENT '身份证号',
created_time TIMESTAMP not null,
updated_time TIMESTAMP not null,
is_enable TINYINT default 1 not null,
INDEX (openid)
)ENGINE = INNODB DEFAULT CHARSET = utf8;