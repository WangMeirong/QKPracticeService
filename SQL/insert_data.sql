-- status
insert into qk_practice.status value(UUID(), 'INACTIVE','δ����','N',UNIX_TIMESTAMP(current_timestamp)*1000,1,UNIX_TIMESTAMP(current_timestamp)*1000);
insert into qk_practice.status value(UUID(), 'ACTIVE','����','N',UNIX_TIMESTAMP(current_timestamp)*1000,1,UNIX_TIMESTAMP(current_timestamp)*1000);

insert into qk_practice.status value(UUID(), 'PUBLISHED','�ѷ���','N',UNIX_TIMESTAMP(current_timestamp)*1000,1,UNIX_TIMESTAMP(current_timestamp)*1000);
insert into qk_practice.status value(UUID(), 'UNPUBLISHED','δ����','N',UNIX_TIMESTAMP(current_timestamp)*1000,1,UNIX_TIMESTAMP(current_timestamp)*1000);

insert into qk_practice.status value(UUID(), 'UNDO','δ����','N',UNIX_TIMESTAMP(current_timestamp)*1000,1,UNIX_TIMESTAMP(current_timestamp)*1000);
insert into qk_practice.status value(UUID(), 'COMPLETED','�����','N',UNIX_TIMESTAMP(current_timestamp)*1000,1,UNIX_TIMESTAMP(current_timestamp)*1000);
insert into qk_practice.status value(UUID(), 'UNCOMPLETED','δ���','N',UNIX_TIMESTAMP(current_timestamp)*1000,1,UNIX_TIMESTAMP(current_timestamp)*1000);
insert into qk_practice.status value(UUID(), 'PROCESSING','������','N',UNIX_TIMESTAMP(current_timestamp)*1000,1,UNIX_TIMESTAMP(current_timestamp)*1000);

insert into qk_practice.status value(UUID(), 'PASSED','��ͨ��','N',UNIX_TIMESTAMP(current_timestamp)*1000,1,UNIX_TIMESTAMP(current_timestamp)*1000);
insert into qk_practice.status value(UUID(), 'UNPASSED','δͨ��','N',UNIX_TIMESTAMP(current_timestamp)*1000,1,UNIX_TIMESTAMP(current_timestamp)*1000);

-- subject
insert into qk_practice.subject value(UUID(), 'Java','N',UNIX_TIMESTAMP(current_timestamp)*1000,1,UNIX_TIMESTAMP(current_timestamp)*1000);
insert into qk_practice.subject value(UUID(), 'C++','N',UNIX_TIMESTAMP(current_timestamp)*1000,1,UNIX_TIMESTAMP(current_timestamp)*1000);
insert into qk_practice.subject value(UUID(), 'C','N',UNIX_TIMESTAMP(current_timestamp)*1000,1,UNIX_TIMESTAMP(current_timestamp)*1000);
insert into qk_practice.subject value(UUID(), 'IOS','N',UNIX_TIMESTAMP(current_timestamp)*1000,1,UNIX_TIMESTAMP(current_timestamp)*1000);
insert into qk_practice.subject value(UUID(), 'Android','N',UNIX_TIMESTAMP(current_timestamp)*1000,1,UNIX_TIMESTAMP(current_timestamp)*1000);


insert into anwser value(uuid(), 'Test', '', 'N',UNIX_TIMESTAMP(current_timestamp)*1000,'1',UNIX_TIMESTAMP(current_timestamp)*1000);

insert into practice value
(uuid(),(select subject_id from subject where name = 'Java'),
(select anwser_id from anwser where anwser='Test'),
'practice_test','practice for test','decription',
'','Y',
(select status_id from status where code='ACTIVE'),
'N',UNIX_TIMESTAMP(current_timestamp)*1000,'1',UNIX_TIMESTAMP(current_timestamp)*1000);