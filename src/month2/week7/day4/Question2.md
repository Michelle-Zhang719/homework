有如下一张表
create table student(
	id int,
	name varchar(20),
	chinese float,
	english float,
	math float
);

1. 请添加2列信息，出生日期，籍贯。
2. 请修改语文成绩的数据类型为int型
3. 请在里面插入10名学生数据
提示：首先修改name这一列的字符集，然后再插入，否则默认的字符集为Latin1，插入中文会报错

4. 假设10名同学中有同姓的，如王，请找出姓王同学的信息

5. 请找出各科不及格学生的信息

6. 请找出有任何一科不及格学生的名称

7. 请找出两科成绩在90分以上的学生名称

8. 请找出没有一科挂科的学生名称



```java
create table student(
	id int,
	name varchar(20),
	chinese float,
	english float,
	math float
);

-- 1
alter table student  add column birthday DATE;
alter table student  add column city varchar(255);
-- 2
alter table student  modify column chinese int;
-- 3
alter table student character set utf8;
insert into `student` (`id`,`name`,`chinese`,`english`,`math`,`birthday`,`city`) value ('1','孟军','82','85','92','2020-05-01','江苏');
insert into `student` (`id`,`name`,`chinese`,`english`,`math`,`birthday`,`city`) value ('2','钱丽','98','99','83','1994-09-09','湖南');
insert into `student` (`id`,`name`,`chinese`,`english`,`math`,`birthday`,`city`) value ('3','董明','61','67','60','1993-09-04','山西');
insert into `student` (`id`,`name`,`chinese`,`english`,`math`,`birthday`,`city`) value ('4','卢丽','90','85','41','1973-01-20','青海');
insert into `student` (`id`,`name`,`chinese`,`english`,`math`,`birthday`,`city`) value ('5','王秀英','55','56','94','2004-07-16','台湾');
insert into `student` (`id`,`name`,`chinese`,`english`,`math`,`birthday`,`city`) value ('6','杨艳','78','79','58','2013-09-17','广西');
insert into `student` (`id`,`name`,`chinese`,`english`,`math`,`birthday`,`city`) value ('7','贾秀英','57','60','94','1996-08-27','新疆');
insert into `student` (`id`,`name`,`chinese`,`english`,`math`,`birthday`,`city`) value ('8','贾刚','95','61','69','1989-07-16','上海');
insert into `student` (`id`,`name`,`chinese`,`english`,`math`,`birthday`,`city`) value ('9','王敏','77','99','59','1971-07-14','辽宁');
insert into `student` (`id`,`name`,`chinese`,`english`,`math`,`birthday`,`city`) value ('10','侯艳','63','96','66','2018-07-04','宁夏');
-- 4
select * from student where name like '王%';
-- 5
select * from student where chinese<60;
select * from student where english<60;
select * from student where math < 60;
-- 6
select * from student where chinese<60 or english<60 or math < 60;
-- 7
select * from student where (chinese>90&&english>90)or (chinese>90&&math>90) or (math>90&&english>90);
-- 8 
select * from student where chinese>=60 && english>=60 && math >= 60;

```

