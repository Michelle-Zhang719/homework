新建一个学生表S，有包含如下信息
学号 id，
学生姓名 name，
性别 gender，
年龄 age，

专业 dept，

所在系编号 …等

 

并插入10条数据。

学号格式为 201801 201802 201803...
性别只有 'male' & 'female'
院系包含（信息系、数学系，计算机科学系 等）


然后做如下查询：

-- 1.查询全体学生的学号与姓名。

-- 3.查询全体学生的详细记录。

-- 4.查询全体学生的姓名、出生年份和所属部门 使用列别名改变查询结果的列标题



-- 7.查询所有年龄在20岁以下的学生姓名及其年龄。



-- 8.查询年龄在20~23岁（包括20岁和23岁）之间的学生的姓名、系别和年龄。


-- 9.查询年龄不在20~23岁之间的学生姓名、系别和年龄。


-- 10.查询信息系、数学系和计算机系学生的姓名和性别。


-- 11.查询既不是信息系、数学系，也不是计算机科学系的学生的姓名和性别。


-- 12.查询学号为200518的学生的详细情况。



-- 13.查询所有姓刘学生的姓名、学号和性别。

-- 14.查询姓“李”且全名为两个汉字的学生的姓名。



-- 15.查询名字中第2个字为“立"字的学生的姓名和学号。



-- 16.查询所有不姓刘的学生姓名。



-- 17.查询学号在201801~201809之间的学生姓名。



-- 18.查询不同院系学生的人数。


-- 19.查询不同院系学生的平均年龄，并以降序排序。


-- 20.查询计算机系年龄在20岁以下的学生姓名。



-- 22.查询全体学生情况，查询结果按所在系的系号升序排列，同一系中的学生按年龄降序排列。

```java
create table s(
	id int,
	name varchar(20),
	gender varchar(20),
	age int(3),
	dept varchar(20),
	dept_id int,
	birthday date,
	sector varchar(20)
);
insert into `s` (`id`,`name`,`gender`,`age`,`dept`,`dept_id`,`birthday`,`sector`) value ('201802','程桂英','female','18','信息系','2','1977-02-01 02','外联');
insert into `s` (`id`,`name`,`gender`,`age`,`dept`,`dept_id`,`birthday`,`sector`) value ('201803','秦丽','female','22','物理系','5','2021-07-22 20','行政');
insert into `s` (`id`,`name`,`gender`,`age`,`dept`,`dept_id`,`birthday`,`sector`) value ('200518','陈立伟','male','23','计算机科学系','3','1974-06-08 21','宣传');
insert into `s` (`id`,`name`,`gender`,`age`,`dept`,`dept_id`,`birthday`,`sector`) value ('201804','李磊','male','21','数学系','1','2004-01-04 01','外联');
insert into `s` (`id`,`name`,`gender`,`age`,`dept`,`dept_id`,`birthday`,`sector`) value ('201801','袁娟','female','19','信息系','2','2003-12-20 18','外联');
insert into `s` (`id`,`name`,`gender`,`age`,`dept`,`dept_id`,`birthday`,`sector`) value ('201602','曹丽','female','20','艺术系','4','2004-06-20 10','外联');
insert into `s` (`id`,`name`,`gender`,`age`,`dept`,`dept_id`,`birthday`,`sector`) value ('201703','刘军','male','19','计算机科学系','3','2016-01-04 11','行政');
insert into `s` (`id`,`name`,`gender`,`age`,`dept`,`dept_id`,`birthday`,`sector`) value ('201806','戴立','male','18','数学系','1','1971-05-30 18','宣传');
insert into `s` (`id`,`name`,`gender`,`age`,`dept`,`dept_id`,`birthday`,`sector`) value ('201807','文洋','female','23','数学系','1','2002-06-20 04','行政');
insert into `s` (`id`,`name`,`gender`,`age`,`dept`,`dept_id`,`birthday`,`sector`) value ('201808','李国强','male','20','信息系','2','2022-08-01 05','宣传');

-- 1
select id,name from s;
-- 3
select * from s;
-- 4
select  name as student_name,birthday as birth , sector as deportment from s;
-- 7
select name,age from s where age <20;
-- 8
select name,dept,age from s where age>=20&&age<=23;
-- 9
select name,dept,age from s where age<20||age>23;
-- 10
select name ,gender from s where dept like '信息系' or dept like '数学系' or dept like '计算机科学系';
-- 11
select name ,gender from s where dept != '信息系' && dept != '数学系' && dept != '计算机科学系';
-- 12
select * from s where id = 200518;
-- 13 
select name, id, gender from s where name like '刘%';
-- 14
select name from s where name like '李_';
-- 15
select name, id from s where name like '_立%';
-- 16
select name from s where name != '刘%';
-- 17
select name from s where id > 201801 && id<201809;
-- 18
select  dept, count(*) as student_number  from s group by dept;
-- 19
select dept, avg(age) as ave_age   from s group by dept order by ave_age desc  ;
-- 20
select name from s where dept = '计算机科学系'  &&  age < 20;
-- 22
select * from s
ORDER BY dept_id asc,age desc;
```

