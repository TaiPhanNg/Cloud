create database  myemployee;
use myemployee;
create table employee(
        id int(10) not null auto_increment PRIMARY key,
        name nvarchar(100) not null,
        sex varchar(13) null,
        age int null,
        salary int null,did int  null
);

create table Department(id int(10) not null auto_increment PRIMARY key,
 name nvarchar(100) not null,
 location varchar(13) null);
 
 CREATE TABLE  `role` (
  `role_id` int(11) NOT NULL auto_increment,
  `role` varchar(255) default NULL,
  PRIMARY KEY  (`role_id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;
CREATE TABLE  `user` (
  `id` int(11) NOT NULL auto_increment,
  `firstname` varchar(255) NOT NULL,
  `lastname` varchar(255) NOT NULL,
  `email` varchar(255) NOT NULL,
  `password` varchar(255) NOT NULL,
  `active` int(11) default NULL,
  PRIMARY KEY  (`id`),
  eid int 
) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=utf8;

CREATE TABLE  `user_role` (
  `user_id` int(11) NOT NULL,
  `role_id` int(11) NOT NULL,
  PRIMARY KEY  (`user_id`,`role_id`),
  KEY `user_role_key` (`role_id`),
  CONSTRAINT `user_userrole` FOREIGN KEY (`user_id`) REFERENCES `user` (`id`),
  CONSTRAINT `role_userrole` FOREIGN KEY (`role_id`) REFERENCES `role` (`role_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
CREATE TABLE  `persistent_logins` (
  `username` varchar(64) NOT NULL,
  `series` varchar(64) NOT NULL,
  `token` varchar(64) NOT NULL,
  `last_used` timestamp NOT NULL default CURRENT_TIMESTAMP on update CURRENT_TIMESTAMP,
  PRIMARY KEY  (`series`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8; 

create table projects(id int  auto_increment primary key,name  nvarchar(50) not null,location nvarchar (50)not null);
create table workon(eid int,pid int,duration nvarchar(50),startdate nvarchar(50),primary key(eid,pid));

alter table workon add foreign key(eid) references employee(id);
alter table workon add foreign key(pid) references projects(id);
alter table user add foreign key(eid) references employee(id);
alter table employee add foreign key(did) references Department(id);

INSERT INTO `role` VALUES (1,'ADM.IN');
INSERT INTO `role` VALUES (2,'USER');
