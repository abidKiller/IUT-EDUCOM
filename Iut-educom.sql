
#IUT EDUCOM 

# 10 char username
# 10 char password
# 10 char group key
# max msg length 100

create table groups(
	g_id number primary key,
 	name varchar(20),
 	gen_key varchar(10)
);

create table students(
	s_id number primary key,
 	user_name varchar(10),
 	password varchar(10)	
);

create table grp_to_student(
    g_id number,
    s_id number	
);

create table storage(
	g_id number,
	file_path varchar(30)
);


create table messages(
	m_id number,
	g_id number,
	s_id number,
	day varchar(10),
	time varchar(10),
	text varchar(100)	
);

create table events(
	s_id number,
	g_id number,
	day varchar(10),
	text varchar(100)
);

create table admin(
	g_id number,
	s_id number,
	password varchar(10)
);



#some sample data insertion 


insert into students  values(1,'abid','abid123');
insert into students  values(2,'rakib','rakib123');
insert into students  values(3,'abdullah','abdul123');

insert into groups values(1,'ajaira','abcdef');
insert into groups values(2,'haluwa','uvwxyz');

insert into grp_to_student values(1,1);
insert into grp_to_student values(1,2);
insert into grp_to_student values(1,3);
insert into grp_to_student values(2,1);
insert into grp_to_student values(2,3);

insert into messages values(message_seq.NEXTVAL,1,2,'2020-09-19','08:58:57','arreh mammah project er kaj hoise');
insert into messages values(message_seq.NEXTVAL,1,1,'2020-09-19','08:59:47','vai ar somvob na');
insert into messages values(message_seq.NEXTVAL,1,3,'2020-09-19','09:10:22','amr o kora possible na');

insert into messages values (message_seq.NEXTVAL,2,1,'2020-09-19','05:06:44','rakib er sathe kaj kotbo na ar');
insert into messages values (message_seq.NEXTVAL,2,3,'2020-09-19','05:10:43','chele ki kore');


insert into events values(1,1,'2020-07-19','project start');
insert into events values(1,2,'2020-09-19','project end');







create sequence message_seq
increment by 1;

create sequence group_sq
start with 5
increment by 1;


insert into groups values(group_sq.NEXTVAL,'cse 1233','abcde');

insert into grp_to_student values(group_sq.currval,1);
# trigger for group key generation 

create or replace trigger gen_group_key
before insert on groups
for each row
declare


#time date trigger on messege

create sequence message_seq
increment by 1;

create or replace trigger set_date_time
before insert on message
for each row
begin
:new.date_time=sysdate;

#event text , date and group name
select groups.name ,a.day,a.text from (select * from events where s_id=1) a inner join groups on groups.g_id=a.g_id;

select a.day,a.time,a.text,students.user_name from (select * from messages where g_id=2 )a inner join students on students.s_id=a.s_id;

# trigger for group_to_studunt 

select b.name,events.day  from (select* from (select * from grp_to_student where s_id=3) a inner join groups on groups.g_id=a.g_id) b inner join events on events.g_id=g_id;  

select * 
from( select events.text,groups.g_id,grp_to_student.s_id from events
inner join grp_to_student on grp_to_student.g_id = events.g_id
inner join groups on groups.g_id=grp_to_student.g_id) a
where a.s_id=2;

#test codes here

 declare
  m date;
   n varchar(20);
   begin
  
   m:=sysdate;
   dbms_output.put_line(to_char(m,'hh:mm:ss'));
   end;

# groups load

select groups.name from (select * from grp_to_student where s_id=3) a inner join groups on a.g_id=groups.g_id;


select groups.name,groups.g_id from groups where gen_key='ddfdf';


insert into grp_to_student values(g_id,s_id);
