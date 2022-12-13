# egovframe-lab13-2-gradle-jpa-thymeleaf
egovframe 수업시간에 한 lab 13-2에 게시판 추가하기
+ maven, mybatis, jsp쓰지 않고 전부 Gradle(groovy), JPA, Thymeleaf, Javascript(jQuery안 씀)로 작성


DB 정보

employee 테이블

create table employee (
id varchar(10) primary key, 
dept char(2),
name varchar(10), 
age int,
phone varchar(20),
email varchar(20),
addr varchar(100));



board 테이블
CREATE TABLE board (
no bigint primary key auto_increment,
name VARCHAR(50), 
sub VARCHAR(100),
content VARCHAR(4000)
);
