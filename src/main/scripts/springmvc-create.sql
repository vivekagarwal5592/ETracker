drop table  if exists groups;
drop table  if exists friends;
drop table  if exists users;


create table users (
    id          integer auto_increment primary key,
    username    varchar(255) ,
    password    varchar(255),
    email varchar(255),
    registration_token varchar(255),
    phone  integer
);

create table friends(
   id integer primary key,
   userid integer ,
   friendid integer,
   FOREIGN KEY (userid) REFERENCES users(id),
   FOREIGN KEY (friendid) REFERENCES users(id)
);

create table groups(
  groupid integer,
  userid integer,
  groupname varchar(255),
  PRIMARY KEY (groupid,userid)
);

insert into users (username,password,phone,email) VALUES('vivek','vivek','1234','vivekagarwal5592@gmail.com');

select * from users;

