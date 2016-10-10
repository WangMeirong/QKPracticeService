-- status
insert into qk_practice.status value(UUID(), 'INACTIVE','未激活','N',UNIX_TIMESTAMP(current_timestamp)*1000,1,UNIX_TIMESTAMP(current_timestamp)*1000);
insert into qk_practice.status value(UUID(), 'ACTIVE','已激活','N',UNIX_TIMESTAMP(current_timestamp)*1000,1,UNIX_TIMESTAMP(current_timestamp)*1000);

insert into qk_practice.status value(UUID(), 'PUBLISHED','已发布','N',UNIX_TIMESTAMP(current_timestamp)*1000,1,UNIX_TIMESTAMP(current_timestamp)*1000);
insert into qk_practice.status value(UUID(), 'UNPUBLISHED','未发布','N',UNIX_TIMESTAMP(current_timestamp)*1000,1,UNIX_TIMESTAMP(current_timestamp)*1000);

insert into qk_practice.status value(UUID(), 'UNDO','未尝试','N',UNIX_TIMESTAMP(current_timestamp)*1000,1,UNIX_TIMESTAMP(current_timestamp)*1000);
insert into qk_practice.status value(UUID(), 'COMPLETED','已完成','N',UNIX_TIMESTAMP(current_timestamp)*1000,1,UNIX_TIMESTAMP(current_timestamp)*1000);
insert into qk_practice.status value(UUID(), 'UNCOMPLETED','未完成','N',UNIX_TIMESTAMP(current_timestamp)*1000,1,UNIX_TIMESTAMP(current_timestamp)*1000);
insert into qk_practice.status value(UUID(), 'PROCESSING','进行中','N',UNIX_TIMESTAMP(current_timestamp)*1000,1,UNIX_TIMESTAMP(current_timestamp)*1000);

insert into qk_practice.status value(UUID(), 'PASSED','已通过','N',UNIX_TIMESTAMP(current_timestamp)*1000,1,UNIX_TIMESTAMP(current_timestamp)*1000);
insert into qk_practice.status value(UUID(), 'UNPASSED','未通过','N',UNIX_TIMESTAMP(current_timestamp)*1000,1,UNIX_TIMESTAMP(current_timestamp)*1000);

-- subject
insert into qk_practice.subject value(UUID(), 'Java','N',UNIX_TIMESTAMP(current_timestamp)*1000,1,UNIX_TIMESTAMP(current_timestamp)*1000);
insert into qk_practice.subject value(UUID(), 'C++','N',UNIX_TIMESTAMP(current_timestamp)*1000,1,UNIX_TIMESTAMP(current_timestamp)*1000);
insert into qk_practice.subject value(UUID(), 'C','N',UNIX_TIMESTAMP(current_timestamp)*1000,1,UNIX_TIMESTAMP(current_timestamp)*1000);
insert into qk_practice.subject value(UUID(), 'IOS','N',UNIX_TIMESTAMP(current_timestamp)*1000,1,UNIX_TIMESTAMP(current_timestamp)*1000);
insert into qk_practice.subject value(UUID(), 'Android','N',UNIX_TIMESTAMP(current_timestamp)*1000,1,UNIX_TIMESTAMP(current_timestamp)*1000);
insert into qk_practice.subject value(UUID(), 'TBD','N',UNIX_TIMESTAMP(current_timestamp)*1000,1,UNIX_TIMESTAMP(current_timestamp)*1000);


insert into anwser value(uuid(), 'Test', '', 'N',UNIX_TIMESTAMP(current_timestamp)*1000,'1',UNIX_TIMESTAMP(current_timestamp)*1000);

insert into practice value
(uuid(),(select subject_id from subject where name = 'Java'),
(select anwser_id from anwser where anwser='Test'),
'practice_test','practice for test','decription',
'','Y',
(select status_id from status where code='ACTIVE'),
'N',UNIX_TIMESTAMP(current_timestamp)*1000,'1',UNIX_TIMESTAMP(current_timestamp)*1000);