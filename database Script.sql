drop database if exists RememberME;
create database RememberME;
use RememberME;

create table RecurrenceType(
idRecurrence int not null auto_increment,
Recname varchar(25),
RecDescription varchar(50),
intervalType varchar(25),
intervalRecurrence int,
Constraint pk_Recurrence primary key(idRecurrence));


create table task(
idTask int not null auto_increment,
taskName varchar(25),
taskDescription varchar(50),
isCancelled bit default false,
taskCreatedDate date,
taskDate date,
endTask date,
nextDate Date,
idRecurrence int not null,
isDone bit default false,
Constraint pk_idTask primary key(idTask),
Constraint fk_idRecurrence foreign key(idRecurrence)references RecurrenceType(idRecurrence));

create table TaskHistory(
idTask int not null,
taskDate Date,
idRecurrence int not null,
isDone bit not null,
Constraint pk_idTask primary key(idTask,taskDate),
Constraint fk_idTask foreign key(idTask) references task(idTask),
constraint fk_idRecurrence_TaskHistory foreign key(idRecurrence) references recurrencetype(idRecurrence));

delimiter //
drop procedure if exists insertRecurrence //
create procedure insertRecurrence(_RecName varchar(25),_RecDescription varchar(50),_intervalType varchar(25),_interval int )
begin
insert into RecurrenceType(RecName,RecDescription,intervalType,intervalRecurrence) values (_RecName,_RecDescription,_intervalType,_interval);
end //
delimiter ;
call insertRecurrence('Diaria','nada','Dia',1);
call insertRecurrence('Semanal','nada','Semana',1);
call insertRecurrence('Quincenal','nada','Semana',2);
call insertRecurrence('Mensual','nada','Mes',3);
call insertRecurrence('Anual','nada','Anual',1);
delimiter //
drop procedure if exists insertTask //
create procedure insertTask(_taskName varchar(25),_taskDescription varchar(50),_taskDate date,_endtask date,_idRecurrence int )
begin
insert into task(taskName,taskDescription,taskCreatedDate,taskDate,endtask,idRecurrence) values (_taskName,_taskDescription,curdate(),date_format(_taskDate,'%d/%m/%y'),date_format(_endtask,'%d/%m/%y'),_idRecurrence);
end //
delimiter ;

delimiter //
drop procedure if exists isDoneTask //
create procedure isDoneTask(_idTask int)
begin
update task set isDone = 1 where idTask = _idTask;
end //
delimiter ;

delimiter //
drop trigger if exists trg_insertNextDateTask //
create trigger trg_insertNextDateTask before insert on task 
for each row
begin
select r.idRecurrence,r.intervalType,r.intervalrecurrence into @id,@name,@interval from recurrencetype r where
 r.idRecurrence = new.idRecurrence group by r.idRecurrence,r.recname,r.intervalrecurrence;
if @name = 'Dia' then
set new.nextDate =  DATE_ADD(new.taskDate,INTERVAL @interval DAY);

elseif @name = 'Semana' then
set new.nextDate =  DATE_ADD(new.taskDate,INTERVAL @interval WEEK);

elseif @name = 'Mes' then
set new.nextDate =  DATE_ADD(new.taskDate,INTERVAL @interval MONTH);

elseif @name = 'Anual' then
set new.nextDate =  DATE_ADD(new.taskDate,INTERVAL @interval YEAR);
end if;
end //
delimiter ;



delimiter //
drop trigger if exists trg_UpdateNextDateTask //
create trigger trg_UpdateNextDateTask before update on task 
for each row
begin
select r.idRecurrence,r.intervaltype,r.intervalrecurrence into @id,@name,@interval from recurrencetype r where
 r.idRecurrence = new.idRecurrence group by r.idRecurrence,r.recname,r.intervalrecurrence;
if new.isDone = 1 then
insert into taskhistory (idTask,taskname,taskdescription,taskdate,idRecurrence,isDone) values (old.idTask,old.taskName,old.taskDescription,
old.taskDate,old.idRecurrence,new.isDone);
if @name = 'Dia' then

set new.nextDate =  DATE_ADD(old.nextDate,INTERVAL @interval DAY);

elseif @name = 'Semana' then
set new.nextDate =  DATE_ADD(old.nextDate,INTERVAL @interval WEEK);

elseif @name = 'Mes' then
set new.nextDate =  DATE_ADD(old.nextDate,INTERVAL @interval MONTH);

elseif @name = 'Anual' then

set new.nextDate =  DATE_ADD(old.nextDate,INTERVAL @interval YEAR);
end if;
set new.taskDate = old.nextDate;
set new.isDone = 0;
end if;
end //
delimiter ;


call insertTask('Llamar a Betel','Nada','4/04/19',1);
call insertTask('Llamar a Carlos','Nada','4/04/19',2);
call insertTask('Llavar','Nada','4/04/19',3);
call insertTask('Comer','Nada','4/04/19',4);
select idTask, date_format(taskDate,'%d/%m/%y'),date_format(nextDate,'%d/%m/%y') from task;
select idTask, date_format(taskDate,'%d/%m/%y') from taskHistory;
call isDoneTask(3);

select * from recurrencetype;




SET SQL_SAFE_UPDATES = 0;