-- status
insert into qk_practice.status value('1', 'INACTIVE','未激活','N',UNIX_TIMESTAMP(current_timestamp)*1000,1,UNIX_TIMESTAMP(current_timestamp)*1000);
insert into qk_practice.status value('2', 'ACTIVE','已激活','N',UNIX_TIMESTAMP(current_timestamp)*1000,1,UNIX_TIMESTAMP(current_timestamp)*1000);

insert into qk_practice.status value('3', 'PUBLIIC','已公开','N',UNIX_TIMESTAMP(current_timestamp)*1000,1,UNIX_TIMESTAMP(current_timestamp)*1000);
insert into qk_practice.status value('4', 'UNPUBLIIC','未分开','N',UNIX_TIMESTAMP(current_timestamp)*1000,1,UNIX_TIMESTAMP(current_timestamp)*1000);

insert into qk_practice.status value('5', 'UNDO','未尝试','N',UNIX_TIMESTAMP(current_timestamp)*1000,1,UNIX_TIMESTAMP(current_timestamp)*1000);
insert into qk_practice.status value('6', 'COMPLETED','已完成','N',UNIX_TIMESTAMP(current_timestamp)*1000,1,UNIX_TIMESTAMP(current_timestamp)*1000);
insert into qk_practice.status value('7', 'UNCOMPLETED','未完成','N',UNIX_TIMESTAMP(current_timestamp)*1000,1,UNIX_TIMESTAMP(current_timestamp)*1000);
insert into qk_practice.status value('8', 'PROCESSING','进行中','N',UNIX_TIMESTAMP(current_timestamp)*1000,1,UNIX_TIMESTAMP(current_timestamp)*1000);

insert into qk_practice.status value('9', 'PASSED','已通过','N',UNIX_TIMESTAMP(current_timestamp)*1000,1,UNIX_TIMESTAMP(current_timestamp)*1000);
insert into qk_practice.status value('10', 'UNPASSED','未通过','N',UNIX_TIMESTAMP(current_timestamp)*1000,1,UNIX_TIMESTAMP(current_timestamp)*1000);

-- subject
insert into qk_practice.subject value('1', 'Java','N',UNIX_TIMESTAMP(current_timestamp)*1000,1,UNIX_TIMESTAMP(current_timestamp)*1000);
insert into qk_practice.subject value('2', 'C++','N',UNIX_TIMESTAMP(current_timestamp)*1000,1,UNIX_TIMESTAMP(current_timestamp)*1000);
insert into qk_practice.subject value('3', 'C','N',UNIX_TIMESTAMP(current_timestamp)*1000,1,UNIX_TIMESTAMP(current_timestamp)*1000);
insert into qk_practice.subject value('4', 'IOS','N',UNIX_TIMESTAMP(current_timestamp)*1000,1,UNIX_TIMESTAMP(current_timestamp)*1000);
insert into qk_practice.subject value('5', 'Android','N',UNIX_TIMESTAMP(current_timestamp)*1000,1,UNIX_TIMESTAMP(current_timestamp)*1000);
insert into qk_practice.subject value('6', 'TBD','N',UNIX_TIMESTAMP(current_timestamp)*1000,1,UNIX_TIMESTAMP(current_timestamp)*1000);

-- tag
insert into tag values('1', 'Easy','N',UNIX_TIMESTAMP()*1000,1,UNIX_TIMESTAMP()*1000);
insert into tag values('2', 'Difficult','N',UNIX_TIMESTAMP()*1000,1,UNIX_TIMESTAMP()*1000);
insert into tag values('3', 'Medium','N',UNIX_TIMESTAMP()*1000,1,UNIX_TIMESTAMP()*1000);
