create table teacher(
teacher_id int not null auto_increment primary key,
first_name varchar(255),
name_by_father varchar(255),
last_name varchar(255),
start_of_career date,
professional_interest varchar(20000)



);

create table student(
student_id int not null auto_increment primary key,
first_name varchar(255),
name_by_father varchar(255),
last_name varchar(255),
grade int,
studying_interest varchar(20000)

);

create table school(
school_id int not null auto_increment primary key,
school_name varchar(255),
address_id int not null

)


create table address(
address_id int not null auto_increment primary key,
country varchar(255),
region varchar(255),
city varchar(255),
district varchar(255),
street varchar(255)

)

create table lessons_schedule(
lesson_id int not null auto_increment primary key,
start_time time,
end_time time

)

create table subject(
subject_id int not null auto_increment primary key,
subject_name varchar(255)

);
create table parent(


parent_id int not null auto_increment primary key,
first_name varchar(255),
name_by_father varchar(255),
last_name varchar(255)

)