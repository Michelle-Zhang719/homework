-- 某大学研究生院有若干研究生导师，包括职工编号、姓名、职称、研究方向，其中每个导师的职工编号是唯一的。若干研究生，包括学号、姓名、性别、入学日期，其中每个研究生的学号是唯一的。每个导师可以带若干研究生，但每个研究生只能有一个导师。请设计一个数据库，要求可以正确体现导师和研究生之间的关系。设计完毕之后，请插入一定量的数据，并验证你设计的数据库是否满足要求。

-- 1.请查出每个导师所带研究生的姓名。
-- 2.清查出特定姓名的导师所带研究生的姓名。
-- 3.请查出每个导师所带研究生的数量。
-- 4.请查出每个导师所带的男研究生的数量。
-- 5.请找出选择哪个研究方向的导师最多。
-- 6.请找统计不同职称的导师的个数。

```java
create table t_staff(
id int primary key,
name varchar(20) not null,
title varchar(20) not null,
direction varchar(255) not null
);

create table t_stu(
id int primary key,
name varchar(20) not null,
gender varchar(20) not null,
date char(10),
tutorid int not null
);
```

-- 在你设计的表中插入若干数据。: 示例如下
insert t_staff values(123,'邹华','教授','机器识别');
insert t_stu values(16071021,'唐三','male','2016.07.07',123);



答案

```java
-- 1 请查出每个导师所带研究生的姓名
SELECT  sta.name as staff_name ,GROUP_CONCAT(stu.name) as student_name
from t_staff sta 
LEFT OUTER JOIN t_stu stu ON stu.tutorid = sta.id
GROUP BY sta.name;

-- 2 清查出特定姓名的导师所带研究生的姓名。
SELECT  stu.name as student_name  
FROM t_stu as stu
WHERE  tutorid = (SELECT id FROM t_staff sta WHERE sta.name LIKE '高宇宁');

-- 3 请查出每个导师所带研究生的数量
SELECT  sta.name as staff_name ,COUNT(stu.name) as num 
FROM t_staff sta 
left OUTER JOIN t_stu stu ON stu.tutorid = sta.id
GROUP BY sta.id;

-- 4 请查出每个导师所带的男研究生的数量
SELECT  sta.name as staff_name ,COUNT(stu.name) as num 
FROM t_staff sta 
left OUTER JOIN t_stu stu ON stu.tutorid = sta.id
WHERE stu.gender = 'male'
GROUP BY sta.id;

-- 5 请找出选择哪个研究方向的导师最多
SELECT direction,count(id) as num 
FROM t_staff
GROUP BY direction
ORDER BY num desc
LIMIT 1;

-- 6 请找统计不同职称的导师的个数
SELECT title,count(id) as num 
FROM t_staff
GROUP BY title;
```

