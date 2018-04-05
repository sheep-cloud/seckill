-- 数据库初始化脚本

-- 创建数据库
CREATE DATABASE seckill;
-- 使用数据库
USE seckill;
-- 创建秒杀库存表
CREATE TABLE seckill(
	seckill_id VARCHAR(64) NOT NULL COMMENT '商品库存id',
	NAME VARCHAR(128) NOT NULL COMMENT '商品名称',
	number INT NOT NULL COMMENT '库存数量',
	start_time DATETIME NOT NULL COMMENT '秒杀开始时间',
	end_time DATETIME NOT NULL COMMENT '秒杀结束时间',
	create_time TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
	PRIMARY KEY (seckill_id),
	-- 创建索引
	KEY idx_start_time(start_time),
	KEY idx_end_time(end_time),
	KEY idx_create_time(create_time)
) ENGINE=INNODB DEFAULT CHARSET=utf8 COMMENT '秒杀库存表';

-- 初始化数据
INSERT INTO
	seckill(seckill_id, NAME, number, start_time, end_time)
VALUES
	(REPLACE(UUID(), '-', ''), '1000元秒杀iphone6', 100, '2015-11-01 00:00:00', '2015-11-02 00:00:00'),
	(REPLACE(UUID(), '-', ''), '500元秒杀ipad2', 200, '2015-11-01 00:00:00', '2015-11-02 00:00:00'),
	(REPLACE(UUID(), '-', ''), '300元秒杀小米4', 300, '2015-11-01 00:00:00', '2015-11-02 00:00:00'),
	(REPLACE(UUID(), '-', ''), '200元秒杀红米note', 400, '2015-11-01 00:00:00', '2015-11-02 00:00:00');
	
-- 秒杀成功明细表
-- 用户登录认证相关的信息
CREATE TABLE success_killed(
	seckill_id VARCHAR(64) NOT NULL COMMENT '秒杀商品id',
	user_phone VARCHAR(32) NOT NULL COMMENT '用户手机号',
	state CHAR(2) NOT NULL DEFAULT -1 COMMENT '状态标识（-1：无效，0：成功，1：已付款）',
	create_time TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
	-- 联合主键
	PRIMARY KEY (seckill_id, user_phone),
	-- 索引
	KEY idx_create_time(create_time)
) ENGINE=INNODB CHARSET=utf8 COMMENT '秒杀成功明细表';



-- 为什么手写ddl
-- 记录每次上线的ddl修改
-- 上线v1.1版本
ALTER TABLE seckill
DROP INDEX idx_create_time,
ADD INDEX idx_c_s(start_time, create_time);

-- 上线v1.2
-- ddl