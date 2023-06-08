# demo

1. test 文件夹中 testA testB为测试spring事务的嵌套事务的回滚问题
2. config 文件夹中为 rabbitMQ的配置文件和线程池的配置文件
3. dto 文件夹为测试所用的实体对象 对应数据库表文件的sql如下：所用数据库为mysql

CREATE TABLE `user` (
  `name` varchar(100) COLLATE utf8mb4_general_ci DEFAULT NULL,
  `age` bigint DEFAULT NULL,
  `id` int NOT NULL AUTO_INCREMENT,
  `SEX` varchar(100) COLLATE utf8mb4_general_ci DEFAULT NULL,
  `create_date` varchar(100) COLLATE utf8mb4_general_ci DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `user_index_info` (`name`,`age`,`SEX`)
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

INSERT INTO nancal.`user`
(id, name, age, SEX, create_date)
VALUES(1, '111', 11, '男', NULL);
INSERT INTO nancal.`user`
(id, name, age, SEX, create_date)
VALUES(2, '222', 22, '女', NULL);
INSERT INTO nancal.`user`
(id, name, age, SEX, create_date)
VALUES(3, '123', 12, '男', NULL);
INSERT INTO nancal.`user`
(id, name, age, SEX, create_date)
VALUES(4, '145', 44, '女', NULL);
INSERT INTO nancal.`user`
(id, name, age, SEX, create_date)
VALUES(5, NULL, NULL, NULL, NULL);

4. service文件夹中 TestService为测试多线程中线程池的核心参数，当执行第一个任务的时候才会创建线程，而不是一开始定义线程数的时候就创建
5. 
