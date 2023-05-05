## 新建如下表 user表，按要求写出如下SQL语句

(需要大家预习一下修改表操作, 插入数据, 修改数据操作, 查询数据操作 )

1. 写出建表语句
2. 增加 年龄这一列
3. 修改身高 为浮点类型
4. 插入10条数据
5. 修改id = 10 的名字为'乔峰'
6. 修改 id 不为1和2 的性别为 '男'

| id   | name   | nickname | gender | height | weight | score | birthday | nation |
| ---- | ------ | -------- | ------ | ------ | ------ | ----- | -------- | ------ |
| int  | String | String   | String | int    | int    | float | Date     | String |
| 编号 | 名字   | 昵称     | 性别   | 身高   | 体重   | 分数  | 生日     | 地区   |

## 答案

```java
create table user(
	id int (11) NOT NULL PRIMARY KEY  AUTO_INCREMENT,
   name varchar(255),
	 nickname  varchar(255),
	 gender  varchar(255),
	 height int (11),
	 weight int (11),
	 score float,
	 birthday datetime,
	 nation  varchar(255)
)character set utf8 collate utf8_bin;

alter table user  add column age int(3);

alter table user modify  column height float(5, 2);

INSERT INTO `user` VALUES (null, '张三', '法外狂徒', '男', 176.8, 70, 87, '2000-07-19 20:34:56','北京', 23);
INSERT INTO `user` VALUES (null, '李四', 'ls', '女', 165, 60, 77, '1989-07-19 20:34:56','深圳', 34);
INSERT INTO `user` VALUES (null, '王五', 'wu', '男', 183.4, 78, 88, '1987-07-19 20:34:56','广州', 36);
INSERT INTO `user` VALUES (null, '赵六', 'zl', '女', 156, 56, 99, '1996-07-19 20:34:56','湖北', 27);
INSERT INTO `user` VALUES (null, '长风', '娃娃脸', '男', 170.5 ,69, 66, '1999-07-19 20:34:56','四川', 24);
INSERT INTO `user` VALUES (null, '天明', '天命妈妈', '男', 179.4, 58, 67, '1989-07-19 20:34:56','新疆', 34);
INSERT INTO `user` VALUES (null, '深澜', 'sl', '男', 185.3, 80, 78, '1995-07-19 20:34:56','西藏', 28);
INSERT INTO `user` VALUES (null, '石头', 'st', '男', 176, 78, 89, '1994-07-19 20:34:56','宁夏', 29);
INSERT INTO `user` VALUES (null, '千千', '班班', '女', 161, 55, 90, '2000-07-19 20:34:56','上海', 23);
INSERT INTO `user` VALUES (null, '柒柒', '小能手', '女', 169, 56, 97, '2000-07-19 20:34:56','河南', 23);

update user set name ='乔峰' where id = 10;

update user set gender ='男' where id != 1 && id !=2;
```

