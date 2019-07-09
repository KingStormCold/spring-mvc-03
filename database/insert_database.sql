set search_path to new_spring_mvc_03;

insert into role(code,name) values('ADMIN','Quản trị hệ thống');
insert into role(code,name) values('USER','người dùng');

insert into users(username,password,fullname,status)
values('admin','$2a$10$/RUbuT9KIqk6f8enaTQiLOXzhnUkiwEJRdtzdrMXXwU7dgnLKTCYG','admin',1);
insert into users(username,password,fullname,status)
values('nguyenvana','$2a$10$/RUbuT9KIqk6f8enaTQiLOXzhnUkiwEJRdtzdrMXXwU7dgnLKTCYG','nguyen van a',1);

INSERT INTO user_role(user_id,role_id) VALUES (1,1);
INSERT INTO user_role(user_id,role_id) VALUES (2,2);

insert into category(code, name)
values('THE-THAO','Thể thao');
insert into category(code, name)
values('THE-GIOI','Thế giới');
insert into category(code, name)
values('CHINH-TRI','Chính trị');
insert into category(code, name)
values('THOI-SU','Thời sự');
insert into category(code, name)
values('GOC-NHIN','Góc nhìn');
insert into category(code, name)
values('KINH-DOANH','Kinh doanh');
insert into category(code, name)
values('PHAP-LUAT','Pháp luật');
insert into category(code, name)
values('GIAO-DUC','Giao dục');
insert into category(code, name)
values('SUC-KHOE','Sức khỏe');
insert into category(code, name)
values('GIA-DINH','Gia đình');
insert into category(code, name)
values('CONG-DONG','Cộng đồng');
insert into category(code, name)
values('TAM-SU','Tâm sự');

insert into new(code, thumbnail, title, content, shortDescription, category_id, view)
values('BAIVIETTHETHAO1','test1','Bán kết world cup 1', 'Bán kết world cup 1', 'Bán kết world cup 1', 1, 0);

insert into new(code, thumbnail, title, content, shortDescription, category_id, view)
values('BAIVIETTHETHAO2','test2','Bán kết world cup 2', 'Bán kết world cup 2', 'Bán kết world cup 2', 1, 0);

insert into new(code, thumbnail, title, content, shortDescription, category_id, view)
values('BAIVIETTHETHAO3','test3','Bán kết world cup 3', 'Bán kết world cup 3', 'Bán kết world cup 3', 1, 0);

insert into new(code, thumbnail, title, content, shortDescription, category_id, view)
values('BAIVIETTHETHAO4','test4','Bán kết world cup 4', 'Bán kết world cup 4', 'Bán kết world cup 4', 1, 0);








